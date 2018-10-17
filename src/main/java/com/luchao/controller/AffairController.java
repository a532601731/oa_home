package com.luchao.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luchao.entity.Affair;
import com.luchao.entity.AffairApproval;
import com.luchao.entity.ModuleApproval;
import com.luchao.entity.User;
import com.luchao.service.IAffairApprovalService;
import com.luchao.service.IAffairModuleModuleOptionsService;
import com.luchao.service.IAffairModuleService;
import com.luchao.service.IAffairService;
import com.luchao.service.IModuleApprovalService;

@Controller
@RequestMapping("affair")
public class AffairController {
	@Autowired
	IAffairModuleService ams;
	
	@Autowired
	IAffairModuleModuleOptionsService ammos;
	@Autowired
	IAffairService ias;
	@Autowired
	IModuleApprovalService imas;
	@Autowired
	IAffairApprovalService iaas;
	

	@GetMapping("show")
	public String show(ModelMap modelmap,Integer success,Integer errors,HttpSession session){
		System.out.println("用户进入了公文管理菜单");
		if(success!=null){
			modelmap.addAttribute("success",success);
		}
		if(errors!=null){
			modelmap.addAttribute("errors",errors);
		}
		User user=(User) session.getAttribute("user");
		
		modelmap.addAttribute("affairByUserId",ias.getAllByUserId(user.getUserId()));
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
	public String doadd(HttpServletRequest req){
		System.out.println("用户进行了公文增加操作");
//		System.out.println("affairModuleId:"+req.getParameter("affairModuleId"));
//		
//		System.out.println(req.getParameter("html"));
//		System.out.println("user："+req.getSession().getAttribute("user"));
		User user=(User) req.getSession().getAttribute("user");
		Affair a=new Affair();
		a.setAffairModuleId(Integer.parseInt(req.getParameter("affairModuleId")));
		a.setAffairUserId(user.getUserId());
		a.setAffairData(req.getParameter("html"));
		a.setAffairStatus(1);
		int addsuccess=ias.add(a);
		List<ModuleApproval> mas=imas.getAndUserById(a.getAffairModuleId());
		AffairApproval aa=new AffairApproval();
		for(int i=0;i<mas.size();i++){
			
			aa.setAffairId(a.getAffairId());
			aa.setAffairApprovalOrder(mas.get(i).getApprovalOrder());
			aa.setAffairApprovalStatus(0);
			aa.setAffairApprovalUserId(mas.get(i).getApprovalUserId());
			if(iaas.add(aa)<=0){
				return "redirect:/affair/show?errors=1";
			}
		}
		
		if(addsuccess>0){
			
			return "redirect:/affair/show?success=1";
		}else{
			return "redirect:/affair/show?errors=1";
		}
		
	}
	@RequestMapping("detail/{id}")
	public String detail(@PathVariable Integer id,ModelMap modelmap){
		Affair a=ias.getByAffairId(id);
		modelmap.addAttribute("affair",a);
		List<AffairApproval> aa=iaas.getByAffairId(id);
		
		modelmap.addAttribute("affairApproval",aa);
		return "affair/detail";
	}
}
