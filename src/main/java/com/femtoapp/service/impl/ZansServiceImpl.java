package com.femtoapp.service.impl;


import org.springframework.beans.factory.annotation.Autowired;

import com.femtoapp.mapper.ZansMapper;
import com.femtoapp.pojo.Zans;
import com.femtoapp.service.ZansService;

public class ZansServiceImpl implements ZansService {

	@Autowired
	private ZansMapper zansMapper;

	@Override
	public Zans findZanByUser_id(String user_id, Integer aid) throws Exception {
		// TODO Auto-generated method stub
		
		Zans zans = zansMapper.findZanByUser_id(user_id, aid);
		
		return zans;
	}

	@Override
	public void insertZans(Zans zans) throws Exception {
		// TODO Auto-generated method stub
		zansMapper.insertZans(zans);
	}

	@Override
	public void deleteZans(Zans zans) throws Exception {
		// TODO Auto-generated method stub
		zansMapper.deleteZans(zans);
	}

	 

}
