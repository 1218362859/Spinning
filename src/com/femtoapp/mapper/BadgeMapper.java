package com.femtoapp.mapper;

import java.util.List;

import com.femtoapp.pojo.Badge;



public interface BadgeMapper {

	
	public List<Badge> findBadgeByUser_id(String user_id) throws Exception;
	public void insertBadge(Badge badge)throws Exception;
}
