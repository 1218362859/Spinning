package com.femtoapp.service;

import org.apache.ibatis.annotations.Param;

import com.femtoapp.pojo.Zans;

public interface ZansService {

	public Zans findZanByUser_id(@Param(value="user_id") String user_id,@Param(value="aid") Integer aid) throws Exception;
	public void insertZans(Zans zans)throws Exception;
	public void deleteZans(Zans zans)throws Exception;
}
