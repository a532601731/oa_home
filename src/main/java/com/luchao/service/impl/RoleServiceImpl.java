package com.luchao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchao.dao.RoleMapper;
import com.luchao.entity.Role;
import com.luchao.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {

	@Autowired
	RoleMapper rm;
	
	@Override
	public List<Role> getAll() {
		// TODO Auto-generated method stub
		return rm.getAll();
	}

	@Override
	public List<Role> getAllAndPermissions() {
		// TODO Auto-generated method stub
		return rm.getAllAndPermissions();
	}

}
