package com.luchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("roster")
public class RosterController {

	@GetMapping("show")
	public String show(){
		System.out.println("用户进入考勤管理页面");
		return "roster/show";
	}
}
