package com.luchao.dao;

import java.util.List;

import com.luchao.entity.Department;

public interface DepartmentMapper {

	List<Department> getAllDepartment();
	List<Department> getAllDepartmentAndUsers();
}
