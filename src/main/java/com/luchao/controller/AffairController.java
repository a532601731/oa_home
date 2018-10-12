package com.luchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("affair")
public class AffairController {

	@GetMapping("show")
	public String show(){
		System.out.println("用户进入了公文管理菜单");
		return "affair/show";
	}
	
}
