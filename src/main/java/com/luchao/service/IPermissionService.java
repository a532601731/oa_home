package com.luchao.service;

import java.util.List;



import com.luchao.entity.Permission;


public interface IPermissionService {
	List<Permission> getAll();
	List<Permission> getByRoleId(Integer id);
	int deleteByRoleId(Integer id);
	int add(Integer roleId,Integer permissionId);
}
