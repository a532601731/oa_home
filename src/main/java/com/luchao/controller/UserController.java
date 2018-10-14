package com.luchao.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luchao.entity.Menu;
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
			User nbuser = userservice.getMenusAndOperateByUserId(user1.getUserId());
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

	@GetMapping("show")
	public String userShow(ModelMap modelmap, Integer page,String nickname) {

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
	public String doadd(@Valid User user,BindingResult b,ModelMap modelmap ){
		System.out.println("用户进入doadd页面");
		System.out.println(user);
		if(b.hasErrors()){
			System.out.println("用户错误总数："+b.getFieldErrorCount());
		
			modelmap.addAttribute("valierrors",b.getAllErrors());
			return "redirect:/user/add";
		}
		return "redirect:/user/show";
		
	}
}
