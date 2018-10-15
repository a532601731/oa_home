package com.luchao.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.luchao.entity.AffairModule;
import com.luchao.entity.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(locations="classpath:spring-mybatis.xml")
public class TestService {
	
	@Autowired
	@Qualifier("userserviceimpl")
	IUserService userservice;
	
	@Autowired
	IAffairModuleService aff;
	@Test
	public void test1(){
		
		User user=userservice.getFinalUserById(1);
		System.out.println(user);
				
	} 
	
	@Test
	public void test2(){
		AffairModule a=new AffairModule();
		a.setAffairModuleName("鲁大师2");
		a.setAffairModuleUserId(1);
		aff.add(a);
		
	}
}
