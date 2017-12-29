package com.xcc.electrombilebean;

public class User {
	private Integer id;
	private String loginname;
	private String username;
	private String userpassword;
	private String identity;
	private String email;
	private String mac;
	private String phone;
	private String date;
	private String car_info;

	public String getCar_info() {
		return car_info;
	}
	public void setCar_info(String car_info) {
		this.car_info = car_info;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	
	
	/*id;loginname;username;
	 * userPassword;identity; 
	 * email;mac;phone;date;car_info;
*/
	@Override
	public String toString(){
		return "id:"+id+",loginname:"+loginname+",userpassword:"+userpassword+
				",identity:"+identity+",email:"+email+",mac:"+mac+",phone:"+phone+",date:"+
				date+",car_info:"+car_info;
	}
	
	
}
