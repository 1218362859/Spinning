package com.femtoapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.femtoapp.exception.SpinningException;
import com.femtoapp.mapper.BadgeMapper;
import com.femtoapp.mapper.OriginalMapper;
import com.femtoapp.pojo.Badge;
import com.femtoapp.pojo.Original;
import com.femtoapp.pojo.OriginalCustom;
import com.femtoapp.pojo.OriginalQueryVo;
import com.femtoapp.pojo.User_AuthsCustom;
import com.femtoapp.service.BadgeService;
import com.femtoapp.service.OriginalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class OriginalServiceImpl implements OriginalService {

	@Autowired
	private OriginalMapper originalMapper;

	 
	public List<Original> findOriginalByUser_id(String user_id) throws Exception {
		// TODO Auto-generated method stub
		List<Original> list = originalMapper.findOriginalByUser_id(user_id);
		if (list != null && list.size() > 0) {
			return list;
		} else {
			throw new SpinningException("没有找到该用户的原始数据");
		}
	}

	 
	public void insertOriginal(Original original) throws Exception {
		// TODO Auto-generated method stub
	try {
		originalMapper.insertOriginal(original);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("添加原始数据失败 ");
	}
	}



	 
	public List<OriginalCustom> findOriginalList(OriginalQueryVo originalQueryVo) throws Exception {
		// TODO Auto-generated method stub
		
		List<OriginalCustom> findOriginalList = originalMapper.findOriginalList(originalQueryVo);
		if (findOriginalList != null && findOriginalList.size() > 0) {
			return findOriginalList;
		} else {
			throw new SpinningException("查找失败");
		}
	}

	 
	public PageInfo<OriginalCustom> queryByPage(OriginalQueryVo originalQueryVo, Integer pageNo, Integer pageSize)
			throws Exception {
		pageNo = pageNo == null ? 1 : pageNo;
		pageSize = pageSize == null ? 10 : pageSize;
		PageHelper.startPage(pageNo, pageSize);
		List<OriginalCustom> list = originalMapper.findOriginalList(originalQueryVo);
		// 用PageInfo对结果进行包装
		PageInfo<OriginalCustom> page = new PageInfo<OriginalCustom>(list);
		// 測试PageInfo所有属性

		return page;
	}

	 
	public void deleteOriginal(Integer id) throws Exception {
		// TODO Auto-generated method stub
	try {
		originalMapper.deleteOriginal(id);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("删除原始数据失败 ");
	}
	}


	

}
