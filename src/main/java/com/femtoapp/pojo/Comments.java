package com.femtoapp.pojo;

public class Comments {

	private Integer id;  //�Զ�����

	private Integer aid;  //��ӦT_Activity��aid
	private String to_user;//�������û�
	private String from_user;//���۵��û�
	private String msg;//����
	private String time;//ʱ��
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
	public String getTo_user() {
		return to_user;
	}
	public void setTo_user(String to_user) {
		this.to_user = to_user;
	}
	public String getFrom_user() {
		return from_user;
	}
	public void setFrom_user(String from_user) {
		this.from_user = from_user;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "Comments [id=" + id + ", aid=" + aid + ", to_user=" + to_user + ", from_user=" + from_user + ", msg="
				+ msg + ", time=" + time + "]";
	}
	
	
}
