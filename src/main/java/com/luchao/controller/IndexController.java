package com.luchao.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	
	@GetMapping(value={"index","index/index","","home"})
	public String index(HttpSession session){
		logger.info("用户进入index页面");
		
		return "index";
		
	}
	
	@GetMapping(value="home")
	public String home(){
		logger.info("开启index中的Home界面");
		return "admin_home";
	}
}
