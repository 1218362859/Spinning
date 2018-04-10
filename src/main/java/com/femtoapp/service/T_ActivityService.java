package com.femtoapp.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.femtoapp.pojo.Collect;
import com.femtoapp.pojo.CollectCustom;
import com.femtoapp.pojo.CollectQueryVo;
import com.femtoapp.pojo.T_Activity;
import com.femtoapp.pojo.T_ActivityCustom;
import com.femtoapp.pojo.T_ActivityQueryVo;
import com.femtoapp.pojo.User_AuthsCustom;
import com.github.pagehelper.PageInfo;

public interface T_ActivityService {

	

	
	public T_Activity findT_ActivityByid(Integer   aid) throws Exception;
	public void insertT_Activity(T_Activity t_Activity) throws Exception;
	public List<T_ActivityCustom> findT_ActivityList(T_ActivityQueryVo t_ActivityQueryVo) throws Exception;
	public void updateT_Activity(T_Activity t_Activity) throws Exception;
	public void deleteT_Activity(Integer aid)throws Exception;
	PageInfo<T_ActivityCustom> queryByPage(T_ActivityQueryVo t_ActivityQueryVo,Integer pageNo,Integer pageSize) throws  Exception;
	public void updateT_ActivityZans(  Integer aid, Integer zan_count)throws Exception;
	public void updateT_ActivityClicks_count(   Integer aid, Integer clicks_count)throws Exception;
}
