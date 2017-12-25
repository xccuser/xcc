/**
 * 
 */
package com.xcc.electrombilebean;

/**
 *  Administrator
 *
 */
public class UserResponse {
	private String identify;//身份认证0：root 身份认证1：user
	private String status;// 用是否登录成功
	private String mac;
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getIdentify() {
		return identify;
	}
	public void setIdentify(String identify) {
		this.identify = identify;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
