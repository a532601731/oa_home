package com.luchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("affair_module")
public class AffairModuleController {

	@GetMapping("show")
	public String show(){
		System.out.println("用户进入了公文设计菜单");
		return "affair_module/show";
	}
	@GetMapping("add")
	public String add(){
		System.out.println("用户进入了新增一个公文模板页面");
		
		return "affair_module/add";
	}
}
