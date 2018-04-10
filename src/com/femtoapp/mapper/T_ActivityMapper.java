package com.femtoapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.femtoapp.pojo.T_Activity;
import com.femtoapp.pojo.T_ActivityCustom;
import com.femtoapp.pojo.T_ActivityQueryVo;


public interface T_ActivityMapper {

	
	public T_Activity findT_ActivityByid(Integer   aid) throws Exception;
	public void insertT_Activity(T_Activity t_Activity) throws Exception;
	public List<T_ActivityCustom> findT_ActivityList(T_ActivityQueryVo t_ActivityQueryVo) throws Exception;
	public void updateT_Activity(T_Activity t_Activity) throws Exception;
	public void deleteT_Activity(Integer aid)throws Exception;
	public void updateT_ActivityZans(@Param(value="aid") Integer aid,@Param(value="zan_count")  Integer zan_count)throws Exception;
	public void updateT_ActivityClicks_count(@Param(value="aid")  Integer aid,@Param(value="clicks_count")  Integer clicks_count)throws Exception;
}
