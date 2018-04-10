package com.femtoapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.femtoapp.exception.SpinningException;
import com.femtoapp.mapper.UserMapper;
import com.femtoapp.pojo.User;
import com.femtoapp.pojo.UserCustom;
import com.femtoapp.pojo.UserQueryVo;
import com.femtoapp.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	 
	public User findUserByid(String uid) throws Exception {
		User user = userMapper.findUserByid(uid);
		if (user == null) {

			throw new SpinningException("没有找到");
		}
		return user;
	}

	public void insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
	try {
		userMapper.insertUser(user);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("添加用户基本信息失败");
	}
	}

	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception {
		// TODO Auto-generated method stub
		List<UserCustom> userList = userMapper.findUserList(userQueryVo);
		if (userList != null && userList.size() > 0) {
			return userList;
		} else {
			throw new SpinningException("查找失败");
		}

	}

	public void updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
	try {
		userMapper.updateUser(user);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("修改用户基本信息失败 ");
	}
	}

	public void deleteUser(String uid) throws Exception {
		// TODO Auto-generated method stub
	try {
		userMapper.deleteUser(uid);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("外检约束，删除用户失败，该用户含有其他信息，禁止删除 ");
	}
	}

}
