package com.luchao.service;


import java.util.List;

import com.luchao.entity.ModuleApproval;

public interface IModuleApprovalService {

	int add(ModuleApproval a);
	List<ModuleApproval> getById(Integer id);
}
