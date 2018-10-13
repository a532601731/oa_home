package com.luchao.service;

import java.util.List;

import com.luchao.entity.Department;

public interface IDepartmentService {

	List<Department> getAllDepartment();
	
	
	List<Department> getAllDepartmentAndUsers();
}
