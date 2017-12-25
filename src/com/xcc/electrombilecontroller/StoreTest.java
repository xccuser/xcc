/**
 * 
 */
package com.xcc.electrombilecontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xcc.com.xcc.commodity.CommodityBean;

/**
 *  Administrator
 *
 */
@Controller
public class StoreTest {

	@RequestMapping("/store")
	public void storeInfo(HttpServletResponse response) 
			throws IOException{
		CommodityBean user=new CommodityBean("上海市浦东新区巨峰路店","上海市浦东新区耀华路666弄5号楼","1.3km");
		CommodityBean user1=new CommodityBean("上海市浦东新区巨峰路店1","上海市浦东新区耀华路666弄5号楼1","1.3km");
		response.setCharacterEncoding("utf-8");
		response.setHeader("Content-Type","text/html;charset=UTF-8" );  
		response.getWriter().println("["+JSONObject.toJSONString(user)+","
		+JSONObject.toJSONString(user1)+"]");
		/*writer.flush();
		writer.close();*/
	}
	
}
