/**
 * 
 */
package com.xcc.electrombilebean;

/**
 *  记录电瓶车的轨迹
 *
 */
public class UserInfo {
	private String mac; 
	private String longitude;//经度
	private String latitude;//纬度
	
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	
	@Override
	public String toString(){
		return "[mac:"+mac+",longitude:"+
	longitude+"latitude:"+latitude+"]";
	}
	
}
