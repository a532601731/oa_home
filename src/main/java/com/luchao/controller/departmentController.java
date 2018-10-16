package com.luchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("department")
public class departmentController {

	@GetMapping("show")
	public String show(){
		System.out.println("用户进入部门管理页面");
		return "department/show";
	}
}
