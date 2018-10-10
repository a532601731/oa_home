package com.luchao.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luchao.entity.Menu;
import com.luchao.entity.User;
import com.luchao.service.IUserService;



@Controller
@RequestMapping(value="user")
public class UserController {
	Logger logger= LoggerFactory.getLogger(UserController.class);
	@Autowired
	@Qualifier("userserviceimpl")
	IUserService userservice;
	
	//登录页面
	@GetMapping(value="login")
	public String login(Integer errors,ModelMap modelmap){
		logger.info("用户进入登录页面");
		logger.info("错误代码:{}",errors);
		modelmap.addAttribute("errors", errors);
		return "user/login";
	}
	//进行登录操作
	@PostMapping(value="dologin")
	public String dologin(User user,HttpSession session){

		logger.info("用户进行登录操作");
		User user1=userservice.getUserByUsernameAndPassword(user);
		logger.info("{}",user1);
		if(user1==null){
			logger.info("用户用户名或者密码错误导致登录失败");
			
			return "redirect:/user/login?errors=1";
		}else{
			logger.info("登录成功");	
			//登录成功，获取用户的菜单栏和权限栏
			User nbuser=userservice.getMenusAndOperateByUserId(user1.getUserId());
			session.setAttribute("user", nbuser);
			logger.info("nbuser:{}",nbuser);						
			return "redirect:/index";
		}
	}
	//退出登录操作
	
	@GetMapping("loginout")
	public String loginout(HttpSession session){
		logger.info("用户进行退出登录操作");
		session.removeAttribute("user");
		return "redirect:/user/login";
	}
	
	
	@GetMapping("show")
	public String userShow(ModelMap modelmap,Integer page){
		logger.info("用户进入员工管理界面");
		
		if(page==null){
			page=1;
		}
		
		//每页显示数量
		
		Integer pagesize=5;
		//user总数
		Integer allUserCount=userservice.getAllUserCount();
		
		//user总页数
		Integer allUserPages=(int) Math.ceil(allUserCount*1.0/pagesize);
		System.out.println("每页显示数量:"+pagesize+",user总数:"+allUserCount+",user总页数:"+allUserPages);
		
		List<User> users=userservice.getAllUserWithLeaderAndSubordinateByPage(page,pagesize);	
//		for(User user:users){
//			System.out.println(user.getNickname()+"的下属：");
//			for(User user1:user.getSubordinates()){
//				System.out.println(user1.getNickname());
//			}
//			System.out.println("----------------------------");
//		}
		modelmap.addAttribute("users",users);
		
		
		
		
		
		return "user/show";
	}
}
