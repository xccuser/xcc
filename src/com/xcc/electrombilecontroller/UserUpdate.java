/**
 * 
 */
package com.xcc.electrombilecontroller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xcc.constant.Constant;
import com.xcc.electrombilebean.RootUser;
import com.xcc.electrombilebean.User;
import com.xcc.mybatis.RootUserDB;

/**
 *  Administrator
 *
 */
@Controller
public class UserUpdate {


	/*
	 * 
	 *    mobile	是	String	手机号
      secret	是	String	验证码
      pwd	          是	String	新的密码
	 * 
	 */	
	@RequestMapping("/userRootPassword")
	public void updataUserPassword(@RequestBody RootUser user,
			HttpServletResponse response) throws Exception{
		user.setDate(new Date().toString());
		System.out.println(user);
		SqlSession session=RootUserDB.getSqlSession();
		List<RootUser> users=new ArrayList<>();
		try{
			users=session.selectList("com.xcc.mapper.LoginUser.rootUserselectByPhone",user);
			if(users.size()==0){
				response.setCharacterEncoding("utf-8");
				response.getWriter().println("查无此用户");
			}else{
				System.out.println(users.get(0).getUserpassword());
				if(!users.get(0).getUserpassword().equals(user.getUserpassword())){
					int id=session.update("com.xcc.mapper.UserUpdate.updatetbrootuser",user);
					response.setCharacterEncoding("utf-8");
					response.getWriter().println(JSONObject.toJSON(users));
				}else{
					response.setCharacterEncoding("utf-8");
					response.getWriter().println(Constant.ERROR);
				}
			}
			session.commit();
			//response.getWriter().println(JSONObject.toJSONString(users));
		}catch(Exception e){
			response.getWriter().println(Constant.ERROR);
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
	
	@RequestMapping("/userPassword")
	public void updataUserPassword(@RequestBody User user,
			HttpServletResponse response) throws Exception{
		user.setDate(new Date().toString());
		System.out.println(user);
		SqlSession session=RootUserDB.getSqlSession();
		List<User> users=new ArrayList<>();
		try{
			users=session.selectList("com.xcc.mapper.LoginUser.UserselectByPhone",user);
			if(users.size()==0){
				response.setCharacterEncoding("utf-8");
				response.getWriter().println("查无此用户");
			}else{
				System.out.println(users.get(0).getUserpassword());
				if(!users.get(0).getUserpassword().equals(user.getUserpassword())){
					int id=session.update("com.xcc.mapper.UserUpdate.updatetbuser",user);
					response.setCharacterEncoding("utf-8");
					response.getWriter().println(JSONObject.toJSON(users));
				}else{
					response.setCharacterEncoding("utf-8");
					response.getWriter().println(Constant.ERROR);
				}
			}
			session.commit();
			//response.getWriter().println(JSONObject.toJSONString(users));
		}catch(Exception e){
			response.getWriter().println(Constant.ERROR);
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
}
