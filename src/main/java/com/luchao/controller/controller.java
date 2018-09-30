package com.luchao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controller {

	@GetMapping(value="add")
	public void add(){
		System.out.println("进入add成功");
		System.out.println("修改2");
	}
}
