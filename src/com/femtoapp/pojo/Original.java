package com.femtoapp.pojo;

public class Original {

	private Integer id;
	private String uid;
	private String bluetooth_data;
	private String create_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
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
		return "original [id=" + id + ", uid=" + uid + ", bluetooth_data=" + bluetooth_data + ", create_time="
				+ create_time + "]";
	}
	
}
