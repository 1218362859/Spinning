package com.femtoapp.pojo;

public class User {

	private String uid;  //uuid生成
	private String nickname;  //昵称
	private String photourl; //头像地址
	private Integer sex;//性别
	private float weight;//体重
	private Integer level;//级别
	private String regist_time;//注册时间
	private Integer purview;//权限
	private float height;//身高
	private String birthday;//生日

	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhotourl() {
		return photourl;
	}
	public void setPhotourl(String photourl) {
		this.photourl = photourl;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getRegist_time() {
		return regist_time;
	}
	public void setRegist_time(String regist_time) {
		this.regist_time = regist_time;
	}
	public Integer getPurview() {
		return purview;
	}
	public void setPurview(Integer purview) {
		this.purview = purview;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", nickname=" + nickname + ", photourl=" + photourl + ", sex=" + sex + ", weight="
				+ weight + ", level=" + level + ", regist_time=" + regist_time + ", purview=" + purview + ", height="
				+ height + ", birthday=" + birthday + "]";
	}
	
	
	
}
