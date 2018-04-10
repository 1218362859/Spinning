package com.femtoapp.pojo;

public class Train {

	
	private Integer id;//自动递增
	private Integer count;//数量
	private String site;//部位
	private String content;//内容
	private String user_id;//对应user表的id
	private String create_time;//创建时间
	private String begin_time;
	private String end_time;
	private Integer group_count;
	
	
	
	public Integer getGroup_count() {
		return group_count;
	}
	public void setGroup_count(Integer group_count) {
		this.group_count = group_count;
	}
	public String getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
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
		return "Train [id=" + id + ", count=" + count + ", site=" + site + ", content=" + content + ", user_id="
				+ user_id + ", create_time=" + create_time + ", begin_time=" + begin_time + ", end_time=" + end_time
				+ ", group_count=" + group_count + "]";
	}
	
	
}
