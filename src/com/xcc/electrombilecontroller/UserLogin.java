package com.xcc.electrombilecontroller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.xcc.electrombilebean.RootUser;
import com.xcc.electrombilebean.User;
import com.xcc.mybatis.RootUserDB;

import com.xcc.constant.Constant;

/**
 * 用户登录
 *
 */
@Controller
public class UserLogin {


	/*
	 * phone,loginname,passwrod,identify(身份)
	 * 1返回成功,0返回错误
	 * 查询超级用户
	 * 
	 * */
	@RequestMapping("/loginRootUser")
	public void login(@RequestBody RootUser user
			,HttpServletResponse response) throws Exception{

		SqlSession session=RootUserDB.getSqlSession();
		List<RootUser> users=null;
		try{
			users=session.selectList("com.xcc.mapper.LoginUser.rootUserselectByPhone",user);
			if(users.size()==0){
				response.setCharacterEncoding("utf-8");
				response.getWriter().println("查无此用户");
			}else{
				if(users.get(0).getUserPassword()!=user.getUserPassword()){
					response.setCharacterEncoding("utf-8");
					response.getWriter().println("密码错误");
				}else{
					response.setCharacterEncoding("utf-8");
					response.getWriter().println(users);
				}
			}
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}	
	}
	
	


	/*
	 * 
	 * 普通用户登录
	 * 
	 * loginname,passwrod,identify(身份)
	 * 返回mac具有权限，返回null或""为没有权限
	 * 
	 * */
	@RequestMapping("/loginUser")
	public void login(@RequestBody User user
			,HttpServletResponse response){

		SqlSession session=RootUserDB.getSqlSession();
		List<RootUser> users=null;
		try{
			users=session.selectList("com.xcc.mapper.LoginUser.UserselectByPhone",user);
			if(users.size()==0){
				response.setCharacterEncoding("utf-8");
				response.getWriter().println(Constant.USER_NOT);
			}else{
				if(users.get(0).getUserPassword()!=user.getUserPassword()){
					response.setCharacterEncoding("utf-8");
					response.getWriter().println(Constant.USER_PASSWORD);
				}else{
					response.setCharacterEncoding("utf-8");
					response.getWriter().println(users);//返还用户数据
				}
			}
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}	




	}


}
