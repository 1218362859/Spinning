package com.femtoapp.pojo;

public class Badge {

	private Integer id;
	private String name;
	private String create_time;
	private String content;
	private String user_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
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
	@Override
	public String toString() {
		return "badge [id=" + id + ", name=" + name + ", create_time=" + create_time + ", content=" + content
				+ ", user_id=" + user_id + "]";
	}
	
}
