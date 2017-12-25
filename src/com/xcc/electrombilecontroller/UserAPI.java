package com.xcc.electrombilecontroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xcc.electrombilebean.RootUser;

@Controller
public class UserAPI {

	@RequestMapping("/{url}")
	public String test(@PathVariable String url){
		return url;
	}
	
	List<RootUser>  test=new ArrayList<>();
	
	@RequestMapping("/validateUser")
	public void register(@RequestBody RootUser user,
			HttpServletResponse respone) throws IOException{
		user.setMac("02:32:15:FD");
		user.setUserName("root");
		user.setUserPassword("123456");
		respone.getWriter().println(JSONObject.toJSONString(user));
	//	return "success";
	}
}
