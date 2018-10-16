package com.luchao.dao;

import java.util.List;

import com.luchao.entity.AffairModule;

public interface AffairModuleMapper {
	int add(AffairModule a);
	List<AffairModule> getAllAffairModule();
	int delete(Integer id);
	AffairModule getAffairModuleById(Integer id);
	
	
}
