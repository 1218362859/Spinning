package com.femtoapp.pojo;

public class Course {

	private Integer id; //自动递增
	private Integer level;//等级
	private Integer heat;//热量值
	private Integer step_count;//步数
private String begin_time;
private String end_time;
	private String user_id;//对应user表id
	private String mileage;//公里数
	private String create_time;//创建时间
	private String title;//标题
	
	
	
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
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Integer getHeat() {
		return heat;
	}
	public void setHeat(Integer heat) {
		this.heat = heat;
	}
	public Integer getStep_count() {
		return step_count;
	}
	public void setStep_count(Integer step_count) {
		this.step_count = step_count;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getMileage() {
		return mileage;
	}
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", level=" + level + ", heat=" + heat + ", step_count=" + step_count
				+ ", begin_time=" + begin_time + ", end_time=" + end_time + ", user_id=" + user_id + ", mileage="
				+ mileage + ", create_time=" + create_time + ", title=" + title + "]";
	}
	
	
}
