/**
 * 
 */
package com.xcc.electrombilecontroller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@RequestMapping("/setPwd")
	public void updataUserPassword(@RequestBody User user,
			HttpServletResponse response){
		
		user.setDate(new Date().toString());
		SqlSession session=RootUserDB.getSqlSession();
		try{
			int id=session.update("com.xcc.mapper.UserUpdate.updatetbrootuser",user);
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}

		
	}
	
}
