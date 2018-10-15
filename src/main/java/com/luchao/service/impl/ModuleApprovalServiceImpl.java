package com.luchao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchao.dao.ModuleApprovalMapper;
import com.luchao.entity.ModuleApproval;
import com.luchao.service.IModuleApprovalService;

@Service
public class ModuleApprovalServiceImpl implements IModuleApprovalService {
	@Autowired
	ModuleApprovalMapper mam;
	
	@Override
	public int add(ModuleApproval a) {
		// TODO Auto-generated method stub
		return mam.add(a);
	}

}
