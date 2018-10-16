package com.luchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("setting")
public class SettingController {
	@GetMapping("show")
	public String show(){
		System.out.println("用户进入个人设置页面");
		return "setting/show";
	}
}
