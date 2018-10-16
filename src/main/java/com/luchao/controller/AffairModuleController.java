package com.luchao.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luchao.entity.AffairModule;
import com.luchao.entity.AffairModuleModuleOptions;
import com.luchao.entity.Department;
import com.luchao.entity.ModuleApproval;
import com.luchao.service.IAffairModuleModuleOptionsService;
import com.luchao.service.IAffairModuleService;
import com.luchao.service.IDepartmentService;
import com.luchao.service.IModuleApprovalService;

@Controller
@RequestMapping("affair_module")
public class AffairModuleController {
	@Autowired
	IDepartmentService departmentservice;
	
	@Autowired
	IAffairModuleService affairmoduleservice;
	
	@Autowired
	IAffairModuleModuleOptionsService affairoptions;
	
	@Autowired
	IModuleApprovalService mas;
	@GetMapping("show")
	public String show(ModelMap modelmap,Integer success,Integer errors){
		if(success!=null){
			modelmap.addAttribute("success", success);
		}
		if(errors!=null){
			modelmap.addAttribute("errors", errors);
		}
		System.out.println("用户进入了公文模板show菜单");
		List<AffairModule> ls= affairmoduleservice.getAllAffairModule();
		modelmap.addAttribute("affairmodules",ls);
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
						String Approval,
						String ApprovalId
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
		//2:往关系表中增加N条数据
		AffairModuleModuleOptions affairoption=new AffairModuleModuleOptions();
		for(int i=0;i<moduleOptionsName.length;i++){
			affairoption.setAffairModuleId(affairModule.getAffairModuleId());
			
			affairoption.setModuleOptionsId(moduleOptionsId[i]);
			affairoption.setOrder(i+1);
			affairoption.setModuleOptionsName(moduleOptionsName[i]);
			affairoption.setModuleOptionsData(moduleOptionsData[i]);
			
			affairoptions.add(affairoption);
		}
		//3:往审批表中添加一条数据
		ModuleApproval moduleapproval=new ModuleApproval();
		
		ApprovalId=ApprovalId.substring(0,ApprovalId.length()-1);
		
		String[] ApprovalsId=ApprovalId.split(",");
		
		for(int i=0;i<ApprovalsId.length;i++){
			moduleapproval.setAffairModuleId(affairModule.getAffairModuleId());
			moduleapproval.setApprovalOrder(i+1);
			moduleapproval.setApprovalUserId(Integer.parseInt(ApprovalsId[i]));
			mas.add(moduleapproval);
		}
		return "redirect:/affair_module/show";
	}
	
	@GetMapping("update/{id}")
	public String update(@PathVariable("id") Integer id,ModelMap modelmap){

		System.out.println("用户进入模板编辑界面");
		System.out.println("用户正在编辑模板编号为"+id+"的模板");
		AffairModule a=affairmoduleservice.getAffairModuleById(id);
		List<AffairModuleModuleOptions> ls1=affairoptions.getByAffairModuleId(id);
//		for(AffairModuleModuleOptions b:ls1){
//			System.out.println(b);
//		}
		
		List<ModuleApproval> ls2=mas.getAndUserById(id);
		List<String> ls3=new ArrayList<String>();
		for(ModuleApproval b:ls2){
			ls3.add(b.getUser().getNickname());
		}
		modelmap.addAttribute("moduleApprovalNames",ls3);
		modelmap.addAttribute("departments",departmentservice.getAllDepartmentAndUsers());
		modelmap.addAttribute("affairModule",a);
		if(ls1.size()>0){
			modelmap.addAttribute("affairOptions",ls1);
		}
		
		modelmap.addAttribute("moduleApproval",ls2);
		return "affair_module/update";
	}
	
	@PostMapping("doupdate/{id}")
	public String doupdate(@PathVariable("id") Integer id){
		//实现模板保存
		return null;
	}
	
	@GetMapping("delete/{id}")
	public String deleteUserById(@PathVariable("id") Integer id) {
		System.out.println("用户进行删除模板操作。");
		System.out.println("用户要删除的模板id为" + id);
		
		affairmoduleservice.delete(id);
		
		return "redirect:/affair_module/show?success=1";
	}
	
	// 批量删除的方法
		@RequestMapping("delete/some")
		public void batchDeletes(HttpServletRequest request, HttpServletResponse response) {
			System.out.println("用户进行模板批量删除操作");
			String items = request.getParameter("deleteIds");// System.out.println(items);
			String[] strs = items.split(",");
			for (int i = 0; i < strs.length; i++) {
				
				int id = Integer.parseInt(strs[i]);
				System.out.println("用户删除id为"+id+"的模板");
				affairmoduleservice.delete(id);

			}
		}
	
}

