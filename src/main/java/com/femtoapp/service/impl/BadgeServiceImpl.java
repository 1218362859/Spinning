package com.femtoapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.femtoapp.exception.SpinningException;
import com.femtoapp.mapper.BadgeMapper;
import com.femtoapp.pojo.Badge;
import com.femtoapp.service.BadgeService;

public class BadgeServiceImpl implements BadgeService {

	@Autowired
	private BadgeMapper badgeMapper;

	 
	public List<Badge> findBadgeByUser_id(String user_id) throws Exception {
		List<Badge> findBadgeByUser_id = badgeMapper.findBadgeByUser_id(user_id);
		if (findBadgeByUser_id != null && findBadgeByUser_id.size() > 0) {
			return findBadgeByUser_id;
		} else {
			throw new SpinningException("您没有获得徽章");
		}
	}

	 
	public void insertBadge(Badge badge) throws Exception {
		// TODO Auto-generated method stub
		try {
			badgeMapper.insertBadge(badge);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new SpinningException("添加徽章失败");
		}

	}

}
