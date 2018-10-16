package com.luchao.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luchao.entity.Permission;
import com.luchao.service.IPermissionService;
import com.luchao.service.IRoleService;

@Controller
@RequestMapping("permission")
public class PermissionController {
	@Autowired
	IRoleService irs;
	
	@Autowired
	IPermissionService ips;
	@GetMapping("show")
	public String show(ModelMap modelmap,Integer roleId,Integer success,Integer errors){
		System.out.println("用户进入权限管理页面");
		if(success!=null){
			modelmap.addAttribute("success", success);
		}
		if(errors!=null){
			modelmap.addAttribute("errors", errors);
		}
		//默认超级管理员
		if(roleId==null){
			roleId=2;
		}
		List<Permission> lps= ips.getByRoleId(roleId);
		List<Integer> ls=new ArrayList<Integer>();
		for(Permission a:lps){
			ls.add(a.getPermissionId());
			
		}
		modelmap.addAttribute("currentpermissionsId",ls);
		modelmap.addAttribute("permissions",ips.getAll());
		modelmap.addAttribute("roles",irs.getAll());
		modelmap.addAttribute("roleId",roleId);
		return "permission/show";
	}
	
	@PostMapping("doUpdate")
	public String doUpdate(Integer roleId,Integer[] permissionId,ModelMap modelmap){
		ips.deleteByRoleId(roleId);
		for(int i=0;i<permissionId.length;i++){
			ips.add(roleId, permissionId[i]);
			
		}
		modelmap.addAttribute("roleId",roleId);
		return "redirect:/permission/show?success=1";
	}
}
