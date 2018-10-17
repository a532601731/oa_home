package com.luchao.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.luchao.entity.Affair;
import com.luchao.entity.AffairApproval;
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
	
	@Autowired
	IAffairService ias;
	@Autowired
	IAffairApprovalService iaas;
	@Test
	public void test1(){
		List<Affair> ls=ias.getAllByUserId(1);
		for(Affair a:ls){
			System.out.println(a);
		}
	} 

}
