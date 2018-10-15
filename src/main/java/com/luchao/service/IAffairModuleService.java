package com.luchao.service;

import java.util.List;

import com.luchao.entity.AffairModule;

public interface IAffairModuleService {

	int add(AffairModule a);
	List<AffairModule> getAllAffairModule();
	int delete(Integer id);
	AffairModule getAffairModuleById(Integer id);
}
