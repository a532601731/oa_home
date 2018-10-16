package com.luchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("daily")
public class DailyController {
	@GetMapping("show")
	public String show(){
		System.out.println("用户进入工作日志页面");
		return "daily/show";
	}
}
