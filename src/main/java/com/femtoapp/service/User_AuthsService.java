package com.femtoapp.service;

import java.util.List;

import com.femtoapp.pojo.Collect;
import com.femtoapp.pojo.CollectCustom;
import com.femtoapp.pojo.CollectQueryVo;
import com.femtoapp.pojo.User_Auths;
import com.femtoapp.pojo.User_AuthsCustom;
import com.femtoapp.pojo.User_AuthsQueryVo;
import com.github.pagehelper.PageInfo;

public interface User_AuthsService {

	
	public User_Auths findUser_AuthsByid(Integer  id) throws Exception;
	public void insertUser_Auths(User_Auths user_Auths) throws Exception;
	public List<User_AuthsCustom> findUser_AuthsList(User_AuthsQueryVo user_AuthsQueryVo) throws Exception;
	public void updateUser_Auths(User_Auths user_Auths) throws Exception;
	public void deleteUser_Auths(Integer id)throws Exception;
	public User_Auths  findUser_AuthsUserLazyLoading(Integer id)throws Exception;
	public User_Auths findUser_AuthsByIdentifier(String identifier) throws  Exception;
	PageInfo<User_AuthsCustom> queryByPage(User_AuthsCustom user_AuthsCustom,Integer pageNo,Integer pageSize) throws  Exception;
	public User_Auths findUser_AuthsByPhonenum(String phonenum) throws  Exception;
}
