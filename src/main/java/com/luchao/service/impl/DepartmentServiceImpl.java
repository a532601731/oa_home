package com.luchao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchao.dao.DepartmentMapper;
import com.luchao.dao.UserMapper;
import com.luchao.entity.Department;
import com.luchao.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	DepartmentMapper departmentmapper;
	
	
	@Override
	public List<Department> getAllDepartment() {
		// TODO Auto-generated method stub
		return departmentmapper.getAllDepartment();
	}


	/**
	 * 获取所有的部门和属于该部门的员工
	 */
	@Override
	public List<Department> getAllDepartmentAndUsers() {
		// TODO Auto-generated method stub
		return departmentmapper.getAllDepartmentAndUsers();
	}

}
