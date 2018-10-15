package com.luchao.service.impl;

import java.util.List;

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


	@Override
	public List<AffairModule> getAllAffairModule() {
		// TODO Auto-generated method stub
		return affairmodulemapper.getAllAffairModule();
	}


	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return affairmodulemapper.delete(id);
	}


	@Override
	public AffairModule getAffairModuleById(Integer id) {
		// TODO Auto-generated method stub
		return affairmodulemapper.getAffairModuleById(id);
	}
	
	
	
	

}
