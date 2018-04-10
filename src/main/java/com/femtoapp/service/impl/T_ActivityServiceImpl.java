package com.femtoapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.femtoapp.exception.SpinningException;
import com.femtoapp.mapper.T_ActivityMapper;
import com.femtoapp.pojo.T_Activity;
import com.femtoapp.pojo.T_ActivityCustom;
import com.femtoapp.pojo.T_ActivityQueryVo;
import com.femtoapp.service.T_ActivityService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class T_ActivityServiceImpl implements T_ActivityService {

	@Autowired
	private T_ActivityMapper t_ActivityMapper;

	 
	public T_Activity findT_ActivityByid(Integer aid) throws Exception {
		// TODO Auto-generated method stub

		T_Activity t_Activity = t_ActivityMapper.findT_ActivityByid(aid);
		if (t_Activity == null) {

			throw new SpinningException("û���ҵ�");
		}
		return t_Activity;
	}

	 
	public void insertT_Activity(T_Activity t_Activity) throws Exception {
		// TODO Auto-generated method stub
	try {
		t_ActivityMapper.insertT_Activity(t_Activity);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("��ӻ���µ�ʧ�� ");
	}
	}

	 
	public List<T_ActivityCustom> findT_ActivityList(T_ActivityQueryVo t_ActivityQueryVo) throws Exception {
		List<T_ActivityCustom> t_ActivityList = t_ActivityMapper.findT_ActivityList(t_ActivityQueryVo);
		if (t_ActivityList != null && t_ActivityList.size() > 0) {
			return t_ActivityList;
		} else {
			throw new SpinningException("����ʧ��");
		}
	}

	 
	public void updateT_Activity(T_Activity t_Activity) throws Exception {
		// TODO Auto-generated method stub
	try {
		t_ActivityMapper.updateT_Activity(t_Activity);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("�޸Ļ���µ�ʧ�� ");
	}
	}

	 
	public void deleteT_Activity(Integer aid) throws Exception {
		// TODO Auto-generated method stub
	try {
		t_ActivityMapper.deleteT_Activity(aid);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		throw new SpinningException("ɾ�������ʧ�ܣ��������Լ�� ");
	}
	}

	 
	public PageInfo<T_ActivityCustom> queryByPage(T_ActivityQueryVo t_ActivityQueryVo,Integer pageNo, Integer pageSize) throws Exception {
		pageNo = pageNo == null?1:pageNo;
	    pageSize = pageSize == null?10:pageSize;
	    PageHelper.startPage(pageNo, pageSize);
	    List<T_ActivityCustom> list = t_ActivityMapper.findT_ActivityList(t_ActivityQueryVo);
	    //��PageInfo�Խ�����а�װ
	    PageInfo<T_ActivityCustom> page = new PageInfo<T_ActivityCustom>(list);
	    //�y��PageInfo��������
	  
	    
	    
	    return page;
	}


	@Override
	public void updateT_ActivityZans(Integer aid, Integer zan_count) throws Exception {
		// TODO Auto-generated method stub
		t_ActivityMapper.updateT_ActivityZans(aid, zan_count);
	}


	@Override
	public void updateT_ActivityClicks_count(Integer aid, Integer clicks_count) throws Exception {
		// TODO Auto-generated method stub
		t_ActivityMapper.updateT_ActivityClicks_count(aid, clicks_count);
	}

}
