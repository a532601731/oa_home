package com.luchao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luchao.dao.UserMapper;
import com.luchao.entity.User;
import com.luchao.service.IUserService;
import com.luchao.util.md5;

@Service(value="userserviceimpl")
public class UserServiceImpl implements IUserService{
	@Autowired
	UserMapper usermapper;
	
	@Override
	public User getUserById(Integer id) {
		// TODO Auto-generated method stub
		return usermapper.getUserById(id);
	}

	@Override
	public int add(User user) {
		// TODO Auto-generated method stub
		return usermapper.add(user);
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return usermapper.delete(id);
	}

	@Override
	public int update(User user) {
		// TODO Auto-generated method stub
		return usermapper.update(user);
	}

	/**
	 * 用户输入用户名密码，查询用户的操作
	 */
	@Override
	public User getUserByUsernameAndPassword(User user) {
		user.setPassword(md5.md5Password(user.getPassword()));
		return usermapper.getUserByUsernameAndPassword(user);
	}

	/**
	 * 根据用户ID获取该用户的菜单栏和操作权限栏
	 */
	@Override
	public User getMenusAndOperateByUserId(Integer id) {
		// TODO Auto-generated method stub
		return usermapper.getMenusAndOperateByUserId(id);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return usermapper.getAllUsers();
	}

	/**
	 * 根据id获取user的领导和下属
	 */
	@Override
	public User getUserWithLeaderAndSubordinate(Integer id) {
		// TODO Auto-generated method stub
		return usermapper.getUserWithLeaderAndSubordinate(id);
	}

	/**
	 * 获取所有user包括其领导和下属
	 */
	@Override
	public List<User> getAllUserWithLeaderAndSubordinate() {
		// TODO Auto-generated method stub
		return usermapper.getAllUserWithLeaderAndSubordinate();
	}

	/**
	 * 根据页码查询所有该页的user和领导及下属
	 */
	@Override
	public List<User> getAllUserWithLeaderAndSubordinateByPage(Integer page,Integer pagesize) {
		page=(page-1)*pagesize;
		return usermapper.getAllUserWithLeaderAndSubordinateByPage(page,pagesize);
	}

	@Override
	public Integer getAllUserCount() {
		// TODO Auto-generated method stub
		return usermapper.getAllUserCount();
	}

	

	

}
