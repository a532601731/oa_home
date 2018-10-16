package com.luchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("schedule")
public class ScheduleController {
	@GetMapping("show")
	public String show(){
		System.out.println("用户进入行程安排页面");
		return "schedule/show";
	}
}
