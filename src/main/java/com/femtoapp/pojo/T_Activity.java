package com.femtoapp.pojo;

public class T_Activity {
	private Integer aid; //自动递增
	private String state;//状态  
	private Integer zan_count;//赞  的数量
	private Integer clicks_count;//点击数
	
	private String type;//类型  赛事 活动  阅读 训练推荐 
	
	private String title; //标题
	
	
	
	private String time;
	private String content;
	private String user_id;
	private String create_time;
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getZan_count() {
		return zan_count;
	}
	public void setZan_count(Integer zan_count) {
		this.zan_count = zan_count;
	}
	public Integer getClicks_count() {
		return clicks_count;
	}
	public void setClicks_count(Integer clicks_count) {
		this.clicks_count = clicks_count;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "T_Activity [aid=" + aid + ", state=" + state + ", zan_count=" + zan_count + ", clicks_count="
				+ clicks_count + ", type=" + type + ", title=" + title + ", time=" + time + ", content=" + content
				+ ", user_id=" + user_id + ", create_time=" + create_time + "]";
	}
	
	
	
	
}
