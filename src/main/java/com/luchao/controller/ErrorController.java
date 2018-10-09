package com.luchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("errors")
public class ErrorController {

	@GetMapping("operateerror")
	public String operateErrorShow(){
		System.out.println("用户进入提示操作权限不够页面");
		return "errors/operateerror";
	}
}
