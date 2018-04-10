package com.femtoapp.pojo;

public class User_AuthsCustom extends User_Auths {

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
	private Integer id; //自动递增
	private String user_id;//对应user表的id
	private String identity_type;//第三方类型  微信  qq  微博  手机号码 邮箱
	private String identifier; //识别码
	private String credential;//凭据
	private String phonenum;
	
	


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getIdentity_type() {
		return identity_type;
	}

	public void setIdentity_type(String identity_type) {
		this.identity_type = identity_type;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getCredential() {
		return credential;
	}

	public void setCredential(String credential) {
		this.credential = credential;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

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
		return "User_AuthsCustom [uid=" + uid + ", nickname=" + nickname + ", photourl=" + photourl + ", sex=" + sex
				+ ", weight=" + weight + ", level=" + level + ", regist_time=" + regist_time + ", purview=" + purview
				+ ", height=" + height + ", birthday=" + birthday + ", id=" + id + ", user_id=" + user_id
				+ ", identity_type=" + identity_type + ", identifier=" + identifier + ", credential=" + credential
				+ ", phonenum=" + phonenum + "]";
	}

	
	
	
}
