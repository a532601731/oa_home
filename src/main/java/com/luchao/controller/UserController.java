package com.luchao.controller;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
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
	public String login(){
		logger.info("用户进入登录页面");
		
		return "user/login";
	}
	//进行登录操作
	@PostMapping(value="dologin")
	public String dologin(User user,HttpSession session){

		logger.info("用户进行登录操作");
		User user1=userservice.getUserByUsernameAndPassword(user);
		if(user1==null){
			logger.info("登录失败");
			session.setAttribute("errors", 1);
			return "redirect:/user/login?errors=1";
		}else{
			logger.info("登录成功");
			
			session.removeAttribute("errors");
			
			User nbuser=userservice.getMenusByUserId(user1.getUserId());
			session.setAttribute("user", nbuser);
			for(Menu u:nbuser.getMenus()){
				logger.info(u.getMenuName());
				
			}
			
			
			return "redirect:/index";
		}
	}
	//退出登录操作
	
	@GetMapping("loginout")
	public String loginout(HttpSession session){
		session.removeAttribute("user");
		return "redirect:/user/login";
	}
}
