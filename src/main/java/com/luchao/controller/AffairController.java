package com.luchao.controller;

import javax.servlet.http.HttpServletRequest;

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
	public String add(Integer affairModuleId,ModelMap modelmap){
		System.out.println("用户进入了公文增加菜单");
		modelmap.addAttribute("affairModuleId",affairModuleId);
		modelmap.addAttribute("modeloptions",ammos.getByAffairModuleId(affairModuleId));
		return "affair/add";
	}
	@RequestMapping("doadd")
	public void doadd(HttpServletRequest req){
		System.out.println("用户进行了公文增加保存操作");
		System.out.println("affairModuleId:"+req.getParameter("affairModuleId"));
		
		System.out.println(req.getParameter("html"));
		System.out.println("user："+req.getSession().getAttribute("user"));
		
	}
}
