package com.femtoapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.femtoapp.pojo.User_Auths;
import com.femtoapp.pojo.User_AuthsCustom;
import com.femtoapp.pojo.User_AuthsQueryVo;



public interface User_AuthsMapper {

	
	public User_Auths  findUser_AuthsByid(Integer  id) throws Exception;
	
	public void insertUser_Auths(User_Auths user_Auths) throws Exception;
	
	public List<User_AuthsCustom> findUser_AuthsList(User_AuthsQueryVo user_AuthsQueryVo) throws Exception;
	
	public void updateUser_Auths(User_Auths user_Auths) throws Exception;
	
	public void deleteUser_Auths(Integer id)throws Exception;
	
	public User_Auths  findUser_AuthsUserLazyLoading(Integer id)throws Exception;
	
	public User_Auths findUser_AuthsByIdentifier(String identifier) throws  Exception;
	
	
	public User_Auths findUser_AuthsByPhonenum(String phonenum) throws  Exception;
}
