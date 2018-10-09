package com.luchao.service.impl;

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

	@Override
	public User getUserByUsernameAndPassword(User user) {
		user.setPassword(md5.md5Password(user.getPassword()));
		return usermapper.getUserByUsernameAndPassword(user);
	}

	@Override
	public User getMenusAndOperateByUserId(Integer id) {
		// TODO Auto-generated method stub
		return usermapper.getMenusAndOperateByUserId(id);
	}

}
