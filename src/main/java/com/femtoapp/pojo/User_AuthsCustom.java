package com.femtoapp.pojo;

public class User_AuthsCustom extends User_Auths {

	private String uid;  //uuid����
	private String nickname;  //�ǳ�
	private String photourl; //ͷ���ַ
	private Integer sex;//�Ա�
	private float weight;//����
	private Integer level;//����
	private String regist_time;//ע��ʱ��
	private Integer purview;//Ȩ��
	private float height;//���
	private String birthday;//����
	private Integer id; //�Զ�����
	private String user_id;//��Ӧuser���id
	private String identity_type;//����������  ΢��  qq  ΢��  �ֻ����� ����
	private String identifier; //ʶ����
	private String credential;//ƾ��
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
