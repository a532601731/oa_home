package com.luchao.service;

import java.util.List;

import com.luchao.entity.Role;

public interface IRoleService {
	List<Role> getAll();
	List<Role> getAllAndPermissions();
}
