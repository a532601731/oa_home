package com.luchao.dao;

import java.util.List;

import com.luchao.entity.Role;

public interface RoleMapper {
	
	List<Role> getAll();
	List<Role> getAllAndPermissions();
}
