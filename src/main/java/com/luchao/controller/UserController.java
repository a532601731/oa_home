package com.luchao.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.luchao.dao.UserMapper;
import com.luchao.entity.Page;
import com.luchao.entity.User;
import com.luchao.service.IUserService;
import com.luchao.util.md5;



@Controller
@RequestMapping(value = "user")
public class UserController {
	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	@Qualifier("userserviceimpl")
	IUserService userservice;

	// 登录页面
	@GetMapping(value = "login")
	public String login(Integer errors, ModelMap modelmap) {
		logger.info("用户进入登录页面");
		logger.info("错误代码:{}", errors);
		modelmap.addAttribute("errors", errors);
		return "user/login";
	}

	// 进行登录操作
	@PostMapping(value = "dologin")
	public String dologin(User user, HttpSession session) {

		logger.info("用户进行登录操作");
		User user1 = userservice.getUserByUsernameAndPassword(user);
		logger.info("{}", user1);
		if (user1 == null) {
			logger.info("用户用户名或者密码错误导致登录失败");

			return "redirect:/user/login?errors=1";
		} else {
			logger.info("登录成功");
			// 登录成功，获取用户的菜单栏和权限栏
			User nbuser = userservice.getFinalUserById(user1.getUserId());
			session.setAttribute("user", nbuser);
			logger.info("nbuser:{}", nbuser);
			return "redirect:/index";
		}
	}
	// 退出登录操作

	@GetMapping("loginout")
	public String loginout(HttpSession session) {
		logger.info("用户进行退出登录操作");
		session.removeAttribute("user");
		return "redirect:/user/login";
	}
	//编辑用户操作
	@GetMapping("update/{id}")
	public String update(@PathVariable Integer id,ModelMap modelmap){
		User user=userservice.getUserById(id);
		List<User> users=userservice.getAllUsers();
		modelmap.addAttribute("user1",user);
		modelmap.addAttribute("allusers",users);
		return "user/update";
	}
	@RequestMapping("doUpdate")
	public String doupdate(User user){
		System.out.println("需要更新的user信息："+user);
		if(user.getPassword()!=""&&null!=user.getPassword()){
			user.setPassword(md5.md5Password(user.getPassword()));
		}
		int i=userservice.update(user);
		if(i==1){
			return "redirect:/user/show?success=2";
		}else{
			return "redirect:/user/show?errors=3";
		}
	}
	
	@GetMapping("show")
	public String userShow(ModelMap modelmap, Integer page,String nickname,Integer success,Integer errors) {
		if(success!=null){
			modelmap.addAttribute("success", success);
		}
		if(errors!=null){
			modelmap.addAttribute("errors", errors);
		}
		System.out.println("成功代码："+success+",错误代码:"+errors);
		logger.info("用户进入员工管理界面");

		if (page == null) {
			page = 1;
		}
		
		// 每页显示数量

		Integer pagesize = 5;
		// user总数
		Integer allUserCount = userservice.getAllUserCount();
		
		
		Page pagebean=new Page(page, allUserCount, pagesize);
		// user总页数
				
		System.out.println("每页显示数量:" + pagebean.getPageSize() + ",user总数:" + pagebean.getAllCount() + ",user总页数:" + pagebean.getAllpages());
		System.out.println("用户当前在第"+pagebean.getPageNow()+"页");
		System.out.println("有上一页？"+pagebean.getHasFirst());
		System.out.println("有下一页？"+pagebean.getHasLast());
		List<User> users=null;
		if(nickname==null){
			users = userservice.getAllUserWithLeaderAndSubordinateByPage(page, pagesize);
		}else{
			System.out.println("用户使用搜索功能，搜索昵称为："+nickname);
			users = userservice.getAllUserWithLeaderAndSubordinateByPageAndNickname(page, pagesize,nickname);
		}
		
		List<Integer> pages=new ArrayList<Integer>();
		for(int i=1;i<=pagebean.getAllpages();i++){
			pages.add(i);
			
		}
		modelmap.addAttribute("pages",pages);
		modelmap.addAttribute("users", users);
		modelmap.addAttribute("pagebean",pagebean);
		return "user/show";
	}

	@GetMapping("delete/{id}")
	public String deleteUserById(@PathVariable("id") Integer id) {
		System.out.println("用户进行删除用户操作。");
		System.out.println("用户要删除的用户id为" + id);
		userservice.delete(id);
		return "redirect:/user/show";
	}

	// 批量删除的方法
	@RequestMapping("delete/some")
	public void batchDeletes(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("用户进行批量删除操作");
		String items = request.getParameter("deleteIds");// System.out.println(items);
		String[] strs = items.split(",");
		for (int i = 0; i < strs.length; i++) {
			
			int id = Integer.parseInt(strs[i]);
			System.out.println("用户删除鲁id为"+id+"的用户");
			userservice.delete(id);

		}
	}
	
	@GetMapping("add")
	public String add( ModelMap modelmap){
		System.out.println("用户进入add页面");
		modelmap.addAttribute("allusers",userservice.getAllUsers());
		return "user/add";
	}
	
	@RequestMapping("doadd")
	public String doadd(@Valid User user,BindingResult b,HttpServletRequest req,RedirectAttributesModelMap rmm){
		System.out.println("用户进入doadd页面");
		
		if(b.hasErrors()){
			List<ObjectError> errors =  b.getAllErrors();
			for( ObjectError error : errors ) {
				System.out.println( error.getCode() + "|" + error.getDefaultMessage() );
			}
			//req.getSession().setAttribute("valierrors", b.getAllErrors());
			rmm.addFlashAttribute("valierrors",b.getAllErrors());
			return "redirect:/user/add";
		}
		else{
			//用户输入没错，查询该username在数据库里是否存在
			User user1=userservice.getUserByUsernameAndPassword(user);
			if(user1==null){
				userservice.add(user);
				return "redirect:/user/show?page=1&success=1";
			}else{
				//用户名重复
				rmm.addFlashAttribute("usernameerror","用户名重复!!");
				return "redirect:/user/add";
			}
			
			
		}
	}
}
