package com.luchao.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.luchao.entity.AffairModule;
import com.luchao.entity.AffairModuleModuleOptions;
import com.luchao.entity.Department;
import com.luchao.entity.ModuleApproval;
import com.luchao.entity.Permission;
import com.luchao.entity.Role;
import com.luchao.entity.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class TestService {
	
	@Autowired
	@Qualifier("userserviceimpl")
	IUserService userservice;
	
	
	
	@Autowired
	IAffairModuleService aff;
	
	@Autowired
	IAffairModuleModuleOptionsService ammo;
	
	@Autowired
	IModuleApprovalService mas;
	@Autowired
	IDepartmentService departmentservice;
	@Autowired
	IRoleService irs;
	
	@Autowired
	IPermissionService ips;
//	@Test
//	public void test1(){
//		
//		User user=userservice.getFinalUserById(1);
//		System.out.println(user);
//				
//	} 
//	
//	@Test
//	public void test2(){
//		AffairModule a=new AffairModule();
//		a.setAffairModuleName("鲁大师2");
//		a.setAffairModuleUserId(1);
//		aff.add(a);
//		
//	}
//	@Test
//	public void test3(){
//		String a="1,2,3,";
//		a=a.substring(0,a.length()-1);
//		System.out.println(a);
//		String[] as=a.split(",");
//		System.out.println(as.length);
//	}
//	@Test
//	public void test4(){
//		
//		List<AffairModule> ls= aff.getAllAffairModule();
//		for(AffairModule a:ls){
//			System.out.println(a);
//		}
//	}
//	@Test
//	public void test4(){
//		AffairModule a=aff.getAffairModuleById(5);
//		System.out.println(a);
//		
//		
//	}
	@Test
	public void test6(){
		
//		List<AffairModuleModuleOptions> a=ammo.getByAffairModuleId(6);
//		for(AffairModuleModuleOptions b:a){
//			System.out.println(b);
//		}
//		for(Department a:departmentservice.getAllDepartmentAndUsers()){
//			System.out.println(a);
//		}
//		for(Role a:irs.getAllAndPermissions()){
//			System.out.println(a);
//		}
//		List<Permission> lps= ips.getByRoleId(26);
//		List<Integer> ls=new ArrayList<Integer>();
//		for(Permission a:lps){
////			ls.add(a.getPermissionId());
//			System.out.println(a);
//		}
//		System.out.println(ls);
		
		//System.out.println(ips.deleteByRoleId(29));
//		System.out.println(ips.add(29, 13));
		List<ModuleApproval> ls=mas.getAndUserById(7);
		for(ModuleApproval a:ls){
			System.out.println(a);
		}
	}
//	@Test
//	public void test5(){
//		List<ModuleApproval> a=mas.getById(6);
//		for(ModuleApproval b:a){
//			System.out.println(b);
//		}
//	}
}
