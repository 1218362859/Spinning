package com.femtoapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.femtoapp.exception.SpinningException;
import com.femtoapp.mapper.User_AuthsMapper;
import com.femtoapp.pojo.User_AuthsCustom;
import com.femtoapp.pojo.User_Auths;
import com.femtoapp.pojo.User_AuthsQueryVo;
import com.femtoapp.service.User_AuthsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class User_AuthsServiceImpl implements User_AuthsService {

	@Autowired
	private User_AuthsMapper user_AuthsMapper;

	 
	public User_Auths findUser_AuthsByid(Integer id) throws Exception {
		User_Auths user_Auths = user_AuthsMapper.findUser_AuthsByid(id);
		if (user_Auths == null) {

			throw new SpinningException("没有找到");
		}
		return user_Auths;
	}

	 
	public void insertUser_Auths(User_Auths user_Auths) throws Exception {
		// TODO Auto-generated method stub
		user_AuthsMapper.insertUser_Auths(user_Auths);
	}

	 
	public List<User_AuthsCustom> findUser_AuthsList(User_AuthsQueryVo user_AuthsQueryVo) throws Exception {
		List<User_AuthsCustom> user_AuthsList = user_AuthsMapper.findUser_AuthsList(user_AuthsQueryVo);
		if (user_AuthsList != null && user_AuthsList.size() > 0) {
			return user_AuthsList;
		} else {
			throw new SpinningException("查找失败");
		}
	}

	 
	public void updateUser_Auths(User_Auths user_Auths) throws Exception {
	
		// TODO Auto-generated method stub
		try {
		user_AuthsMapper.updateUser_Auths(user_Auths);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("修改用户信息失败 ");
	}
	}

	 
	public void deleteUser_Auths(Integer id) throws Exception {
		// TODO Auto-generated method stub
		try {
			user_AuthsMapper.deleteUser_Auths(id);
			int i=10/0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new SpinningException("删除失败，该用户含有其他记录");
		}
	}

	 
	public User_Auths findUser_AuthsUserLazyLoading(Integer id) throws Exception {
		User_Auths user_Auths = user_AuthsMapper.findUser_AuthsUserLazyLoading(id);
		if (user_Auths == null) {

			throw new SpinningException("没有找到");
		}
		return user_Auths;
	}

	 
	public User_Auths findUser_AuthsByIdentifier(String identifier) throws Exception {
		// TODO Auto-generated method stub
		User_Auths user_Auths = user_AuthsMapper.findUser_AuthsByIdentifier(identifier);
		if (user_Auths == null) {

			throw new SpinningException("没有找到该用户");
		}
		return user_Auths;
	}

	 
	public PageInfo<User_AuthsCustom> queryByPage(User_AuthsCustom user_AuthsCustom,Integer pageNo, Integer pageSize) throws Exception {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		User_AuthsQueryVo user_AuthsQueryVo = new User_AuthsQueryVo();
		user_AuthsQueryVo.setUser_AuthsCustom(user_AuthsCustom);
		List<User_AuthsCustom> list = user_AuthsMapper.findUser_AuthsList(user_AuthsQueryVo);
		// 用PageInfo对结果进行包装
		PageInfo<User_AuthsCustom> page = new PageInfo<User_AuthsCustom>(list);
		// 測试PageInfo所有属性

		return page;
	}


	 
	public User_Auths findUser_AuthsByPhonenum(String phonenum) throws Exception {
		User_Auths user_Auths = user_AuthsMapper.findUser_AuthsByPhonenum(phonenum);
		if (user_Auths == null) {
			throw new SpinningException("没有找到");
		}
		
		return user_Auths;
	}

}
