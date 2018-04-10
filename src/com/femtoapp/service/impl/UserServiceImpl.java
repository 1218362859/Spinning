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

			throw new SpinningException("û���ҵ�");
		}
		return user;
	}

	public void insertUser(User user) throws Exception {
		// TODO Auto-generated method stub
	try {
		userMapper.insertUser(user);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("����û�������Ϣʧ��");
	}
	}

	public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception {
		// TODO Auto-generated method stub
		List<UserCustom> userList = userMapper.findUserList(userQueryVo);
		if (userList != null && userList.size() > 0) {
			return userList;
		} else {
			throw new SpinningException("����ʧ��");
		}

	}

	public void updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
	try {
		userMapper.updateUser(user);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("�޸��û�������Ϣʧ�� ");
	}
	}

	public void deleteUser(String uid) throws Exception {
		// TODO Auto-generated method stub
	try {
		userMapper.deleteUser(uid);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("���Լ����ɾ���û�ʧ�ܣ����û�����������Ϣ����ֹɾ�� ");
	}
	}

}
