package com.femtoapp.pojo;

public class OriginalCustom extends Original{

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
	private Integer id;
	private String bluetooth_data;
	private String create_time;
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
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBluetooth_data() {
		return bluetooth_data;
	}
	public void setBluetooth_data(String bluetooth_data) {
		this.bluetooth_data = bluetooth_data;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	@Override
	public String toString() {
		return "OriginalCustom [uid=" + uid + ", nickname=" + nickname + ", photourl=" + photourl + ", sex=" + sex
				+ ", weight=" + weight + ", level=" + level + ", regist_time=" + regist_time + ", purview=" + purview
				+ ", height=" + height + ", birthday=" + birthday + ", id=" + id + ", bluetooth_data=" + bluetooth_data
				+ ", create_time=" + create_time + "]";
	}
	
}
