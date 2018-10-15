package com.luchao.dao;

import java.util.List;

import com.luchao.entity.AffairModuleModuleOptions;

public interface AffairModuleModuleOptionsMapper {
	int add(AffairModuleModuleOptions a);
	List<AffairModuleModuleOptions> getByAffairModuleId(Integer id);
}
