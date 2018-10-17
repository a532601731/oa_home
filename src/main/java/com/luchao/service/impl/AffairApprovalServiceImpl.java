package com.luchao.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchao.dao.AffairApprovalMapper;
import com.luchao.entity.AffairApproval;
import com.luchao.service.IAffairApprovalService;

@Service
public class AffairApprovalServiceImpl implements IAffairApprovalService{

	@Autowired
	AffairApprovalMapper aam;
	
	@Override
	public int add(AffairApproval aa) {
		// TODO Auto-generated method stub
		return aam.add(aa);
	}
		
	
	
	

}
