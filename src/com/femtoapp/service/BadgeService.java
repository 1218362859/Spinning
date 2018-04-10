package com.femtoapp.service;

import java.util.List;

import com.femtoapp.pojo.Badge;

public interface BadgeService {

	public List<Badge> findBadgeByUser_id(String user_id) throws Exception;
	public void insertBadge(Badge badge)throws Exception;
}
