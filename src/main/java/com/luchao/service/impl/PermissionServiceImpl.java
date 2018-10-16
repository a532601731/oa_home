package com.luchao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchao.dao.PermissionMapper;
import com.luchao.entity.Permission;

import com.luchao.service.IPermissionService;


@Service
public class PermissionServiceImpl implements IPermissionService {

	@Autowired
	PermissionMapper pm;
	
	@Override
	public List<Permission> getAll() {
		// TODO Auto-generated method stub
		return pm.getAll();
	}

	@Override
	public List<Permission> getByRoleId(Integer id) {
		// TODO Auto-generated method stub
		return pm.getByRoleId(id);
	}

	@Override
	public int deleteByRoleId(Integer id) {
		// TODO Auto-generated method stub
		return pm.deleteByRoleId(id);
	}

	@Override
	public int add(Integer roleId, Integer permissionId) {
		// TODO Auto-generated method stub
		return pm.add(roleId, permissionId);
	}

	

	

}
