package com.femtoapp.pojo;

public class Collect {

	private Integer id;  //自动递增
	private Integer aid;//对应t_activity的主键
	private String create_time;//收藏的时间
	private String user_id;//对应user表的id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Collect [id=" + id + ", aid=" + aid + ", create_time=" + create_time + ", user_id=" + user_id + "]";
	}
	
	
	
	
}
