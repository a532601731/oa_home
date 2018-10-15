package com.luchao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luchao.entity.AffairModule;
import com.luchao.entity.Department;
import com.luchao.service.IAffairModuleService;
import com.luchao.service.IDepartmentService;

@Controller
@RequestMapping("affair_module")
public class AffairModuleController {
	@Autowired
	IDepartmentService departmentservice;
	
	@Autowired
	IAffairModuleService affairmoduleservice;
	@GetMapping("show")
	public String show(){
		System.out.println("用户进入了公文模板show菜单");
		return "affair_module/show";
	}
	@GetMapping("add")
	public String add(ModelMap modelmap){
		System.out.println("用户进入了公文模板add菜单");
		List<Department> departments=departmentservice.getAllDepartmentAndUsers();
		
		modelmap.addAttribute("departments",departments);
		return "affair_module/add";
	}
	
	
	@PostMapping("doadd")
	public String doadd(AffairModule affairModule,
						String affairModuleName,
						String[] moduleOptionsName,
						Integer[] moduleOptionsId,
						String[] moduleOptionsData,
						String Approval
			
			){
		
		System.out.println("用户进入了公文模板doadd菜单");
		System.out.println("模板表："+affairModule);
		System.out.println("-------------------------------");
		System.out.println("模板名："+affairModuleName);
		
		for(int i=0;i<moduleOptionsName.length;i++){
			System.out.println("选项名："+moduleOptionsName[i]+",选项类型："+moduleOptionsId[i]+",选项数据:"+moduleOptionsData[i]);
			
			System.out.println("------------");
		}
		System.out.println("审批人："+Approval);
		//1:往模板表中增加一条数据
		affairmoduleservice.add(affairModule);
		
		
		
		return "redirect:/affair_module/show";
	}
}
