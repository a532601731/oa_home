package com.luchao.dao;

import java.util.List;

import com.luchao.entity.AffairApproval;

public interface AffairApprovalMapper {

	int add(AffairApproval aa);
	List<AffairApproval> getByAffairId(Integer id);
	
	
}
