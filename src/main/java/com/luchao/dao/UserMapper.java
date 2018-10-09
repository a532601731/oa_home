package com.luchao.dao;

import com.luchao.entity.User;

public interface UserMapper {

	
User getUserById(Integer id);
int add(User user);
int delete(Integer id);
int update(User user);
User getUserByUsernameAndPassword(User user);
User getMenusAndOperateByUserId(Integer id);
}
