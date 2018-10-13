package com.luchao.service;

import java.util.List;

import com.luchao.entity.User;

public interface IUserService {

	User getUserById(Integer id);
	int add(User user);
	int delete(Integer id);
	int update(User user);
	User getUserByUsernameAndPassword(User user);
	User getMenusAndOperateByUserId(Integer id);
	List<User> getAllUsers();
	User getUserWithLeaderAndSubordinate(Integer id);
	List<User> getAllUserWithLeaderAndSubordinate();
	Integer getAllUserCount();
	List<User> getAllUserWithLeaderAndSubordinateByPage(Integer page,Integer pagesize);
	List<User> searchUserByNickname(String nickname);
	List<User> getAllUserWithLeaderAndSubordinateByPageAndNickname(Integer page,Integer pagesize,String nickname);
}
