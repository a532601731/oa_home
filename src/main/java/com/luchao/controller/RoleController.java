package com.luchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("role")
public class RoleController {
	
	@GetMapping("show")
	public String show(){
		System.out.println("用户进入角色管理页面");
		return "role/show";
	}
}
