package com.femtoapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.femtoapp.pojo.Badge;
import com.femtoapp.pojo.Original;
import com.femtoapp.pojo.OriginalCustom;
import com.femtoapp.pojo.OriginalQueryVo;
import com.femtoapp.pojo.User_Auths;
import com.femtoapp.pojo.User_AuthsCustom;
import com.femtoapp.pojo.User_AuthsQueryVo;



public interface OriginalMapper {

	
	public List<Original> findOriginalByUser_id(String user_id) throws Exception;
	public void insertOriginal(Original original)throws Exception;
	
	
	
	
	
	public List<OriginalCustom> findOriginalList(OriginalQueryVo originalQueryVo) throws Exception;
	public void deleteOriginal (Integer id)throws Exception;
}
