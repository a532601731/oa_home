package com.luchao.service;

import java.util.List;

import com.luchao.entity.AffairApproval;

public interface IAffairApprovalService {

	int add(AffairApproval aa);

	List<AffairApproval> getByAffairId(Integer id);


}
