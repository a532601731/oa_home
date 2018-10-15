package com.luchao.service;

import java.util.List;

import com.luchao.entity.AffairModuleModuleOptions;

public interface IAffairModuleModuleOptionsService {

	int add(AffairModuleModuleOptions a);
	List<AffairModuleModuleOptions> getByAffairModuleId(Integer id);
}
