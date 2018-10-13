package com.luchao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luchao.entity.Department;
import com.luchao.service.IDepartmentService;

@Controller
@RequestMapping("affair_module")
public class AffairModuleController {
	@Autowired
	IDepartmentService departmentservice;

	@GetMapping("show")
	public String show(){
		System.out.println("用户进入了公文设计菜单");
		return "affair_module/show";
	}
	@GetMapping("add")
	public String add(ModelMap modelmap){
		System.out.println("用户进入了新增一个公文模板页面");
		List<Department> departments=departmentservice.getAllDepartmentAndUsers();
		
		modelmap.addAttribute("departments",departments);
		return "affair_module/add";
	}
}
