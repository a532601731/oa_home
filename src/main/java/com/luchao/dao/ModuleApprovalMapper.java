package com.luchao.dao;

import java.util.List;

import com.luchao.entity.ModuleApproval;

public interface ModuleApprovalMapper {
	int add(ModuleApproval a);
	List<ModuleApproval> getById(Integer id);
	
	List<ModuleApproval> getAndUserById(Integer id);
}
