/**
 * 
 */
package com.xcc.electrombilecontroller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xcc.constant.Constant;
import com.xcc.electrombilebean.RootUser;
import com.xcc.electrombilebean.TempUser;
import com.xcc.electrombilebean.User;
import com.xcc.mybatis.RootUserDB;


/**
 *  超级用户模块
 *
 */

@Controller
public class UserReaisterAPI {

	private static final Log logger = LogFactory.getLog(UserReaisterAPI.class);

	List<User>  list=new ArrayList<User>();
	/**
	 *  需要"Content-Type", "application/json" 设施post
	 *  phone，password,mac,username,identity
	 *  phone是唯一的
	 */
	@RequestMapping("/registerRoot")
	public void Register(@RequestBody RootUser user,
			ServletResponse respone) throws Exception{
		String stringJson=JSONObject.toJSONString(user);
		user.setDate(new Date().toString());
		/*先查询mac地址是否唯一，
		 * 不唯一返回用户mac错误
		 * mac正确返回sucess
		 * 添加到数据库中代码
		 * */
		//respone.getWriter().println(stringJson);
		SqlSession session=RootUserDB.getSqlSession();
		try{
			session.insert("com.xcc.mapper.RootInsertUser.insertRootUser",user);
			session.commit();
		}catch(Exception e){
			if(user.getMac()==""|user.getMac()==null){
				respone.getWriter().println("mac_null");
			}else{
				respone.getWriter().println("other_error");
			}
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	/**
	 *  普通用户模块设计
	 *  超级用户通过设给临时用户设置mac给权限(手机唯一)
	 *   phone,password,username,email注册
	 *   
	 */
	@RequestMapping("/registerUser")
	public void Register(@RequestBody User user,
			ServletResponse respone) throws Exception{
		String stringJson=JSONObject.toJSONString(user);
		System.out.println(stringJson);
		/**
		 * 设置mac 地址
		 */
		SqlSession session=RootUserDB.getSqlSession();
		try{
			session.insert("com.xcc.mapper.UserInert.insertUser",user);
			session.commit();
			respone.getWriter().println(JSONObject.toJSONString(user));
		}catch(Exception e){
			respone.getWriter().println(JSONObject.toJSONString(Constant.ERROR));
			e.printStackTrace();
		}finally{
			session.close();
		}
	}


/*	*//**
	 *  临时用户模块
	 *//*
	@RequestMapping("/registerTempUser")
	public void Register(@RequestBody TempUser user,
			ServletResponse respone) throws Exception{		
		*//**
		 * 查询验证 临时mac
		 *//*
		String stringJson=JSONObject.toJSONString(user);
		System.out.println(stringJson);
		respone.getWriter().println("success");
	}*/

}
