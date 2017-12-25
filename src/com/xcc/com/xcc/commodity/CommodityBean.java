/**
 * 
 */
package com.xcc.com.xcc.commodity;

/**
 *  Administrator
 *
 */
public class CommodityBean {
	private String store;
	private String position;
	private String distance;
	
	public CommodityBean(){

	}
	public CommodityBean(String store,String position,String distance){
		//super();
		this.store=store;
		this.position=position;
		this.distance=distance;
	}



	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
}
