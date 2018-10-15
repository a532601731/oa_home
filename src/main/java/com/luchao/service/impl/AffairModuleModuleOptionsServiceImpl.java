package com.luchao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchao.dao.AffairModuleModuleOptionsMapper;
import com.luchao.entity.AffairModuleModuleOptions;
import com.luchao.service.IAffairModuleModuleOptionsService;

@Service
public class AffairModuleModuleOptionsServiceImpl implements IAffairModuleModuleOptionsService{
	@Autowired
	AffairModuleModuleOptionsMapper aff;
	
	@Override
	public int add(AffairModuleModuleOptions a) {
		// TODO Auto-generated method stub
		return aff.add(a);
	}

	@Override
	public List<AffairModuleModuleOptions> getByAffairModuleId(Integer id) {
		// TODO Auto-generated method stub
		return aff.getByAffairModuleId(id);
	}

}
