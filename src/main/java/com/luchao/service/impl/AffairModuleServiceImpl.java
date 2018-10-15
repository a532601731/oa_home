package com.luchao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchao.dao.AffairModuleMapper;
import com.luchao.entity.AffairModule;
import com.luchao.service.IAffairModuleService;

@Service
public class AffairModuleServiceImpl implements IAffairModuleService{
		@Autowired
		AffairModuleMapper affairmodulemapper;
	
		
	@Override
	public int add(AffairModule a) {
		// TODO Auto-generated method stub
		return affairmodulemapper.add(a);
	}
	
	
	
	

}
