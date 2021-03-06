package com.luchao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.luchao.entity.User;

public interface UserMapper {

	

int add(User user);
int delete(Integer id);
int update(User user);

User getUserByUsernameAndPassword(User user);
User getMenusAndOperateByUserId(Integer id);
List<User> getAllUsers();
User getUserById1(Integer id);
User getLeaderUserById(Integer id);
User getUserWithLeaderAndSubordinate(Integer id);
List<User> getAllUserWithLeaderAndSubordinate();
List<User> getAllUserWithLeaderAndSubordinateByPage(@Param("page")Integer page,@Param("pagesize")Integer pagesize);
Integer getAllUserCount();
//最终的user,包含上下属，菜单，权限
User getFinalUserById(Integer id);
List<User> searchUserByNickname(String nickname);
List<User> getAllUserWithLeaderAndSubordinateByPageAndNickname(@Param("page")Integer page, @Param("pagesize")Integer pagesize, @Param("nickname")String nickname);
}
