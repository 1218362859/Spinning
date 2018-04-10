package com.femtoapp.pojo;

public class User_Auths {

	private Integer id; //自动递增
	private String user_id;//对应user表的id
	private String identity_type;//第三方类型  微信  qq  微博  手机号码 邮箱
	private String identifier; //识别码
	private String credential;//凭据
	private String phonenum;
	private User user;
	

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
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

	@Override
	public String toString() {
		return "User_Auths [id=" + id + ", user_id=" + user_id + ", identity_type=" + identity_type + ", identifier="
				+ identifier + ", credential=" + credential + ", phonenum=" + phonenum + ", user=" + user + "]";
	}
	
	
}
