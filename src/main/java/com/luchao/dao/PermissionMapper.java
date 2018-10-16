package com.luchao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luchao.entity.Permission;


public interface PermissionMapper {
	
	List<Permission> getAll();
	List<Permission> getByRoleId(Integer id);
	int deleteByRoleId(Integer id);
	int add(@Param("roleId")Integer roleId,@Param("permissionId")Integer permissionId);
}
