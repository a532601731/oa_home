package com.luchao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luchao.service.IAffairModuleModuleOptionsService;
import com.luchao.service.IAffairModuleService;

@Controller
@RequestMapping("affair")
public class AffairController {
	@Autowired
	IAffairModuleService ams;
	
	@Autowired
	IAffairModuleModuleOptionsService ammos;

	@GetMapping("show")
	public String show(ModelMap modelmap){
		System.out.println("用户进入了公文管理菜单");
		
		modelmap.addAttribute("affairmodules",ams.getAllAffairModule());
		return "affair/show";
	}
	
	@GetMapping("add")
	public String show(Integer affairModuleId,ModelMap modelmap){
		System.out.println("用户进入了公文管理菜单");
		
		modelmap.addAttribute("modeloptions",ammos.getByAffairModuleId(affairModuleId));
		return "affair/add";
	}
	
}
