package com.femtoapp.service;

import java.util.List;

import com.femtoapp.pojo.User;
import com.femtoapp.pojo.UserCustom;
import com.femtoapp.pojo.UserQueryVo;

public interface UserService {

	public User findUserByid(String  uid) throws Exception;
	public void insertUser(User user) throws Exception;
	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
	public void updateUser(User user) throws Exception;
	public void deleteUser(String uid)throws Exception;
}
