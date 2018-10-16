package com.luchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("email")
public class EmailController {
	@GetMapping("show")
	public String show(){
		System.out.println("用户进入邮箱管理页面");
		return "email/show";
	}
}
