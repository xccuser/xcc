/**
 * 
 */
package com.xcc.mybatis;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.xcc.electrombilebean.RootUser;
import com.xcc.electrombilebean.User;

/**
 *  Administrator
 *
 */
public class Test {
	public static void main(String[] args){
		testUpdate();
	}

	public static void testLogin(){
		User user=new User();
		user.setPhone("13812667134");
		SqlSession session=RootUserDB.getSqlSession();
		List<RootUser> users=null;
		try{
			users=session.selectList("com.xcc.mapper.LoginUser.rootUserselectByPhone",user);
			System.out.println(users);
			session.commit();


		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	public static void testRegister(){
		User user=new User();
		user.setLoginname("xcc");
		user.setUserPassword("123456");
		user.setMac("10:13:13:43");
		user.setPhone("1233231123");
		user.setDate(new Date().toString());
		SqlSession session=RootUserDB.getSqlSession();
		try{
			session.insert("com.xcc.mapper.RootInsertUser.insertRootUser");
			session.commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	public static void testDelete(){
		User user=new User();
		user.setLoginname("xcc");
		user.setUserPassword("123456");
		user.setMac("12:32:12:31");
		user.setPhone("12324234232");
		user.setDate(new Date().toString());
		SqlSession session=RootUserDB.getSqlSession();
		try{
			int id=session.delete("com.xcc.mapper.DeleteUser.deleteUser",user);
			session.commit();
			System.out.println(id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	public static void testUpdate(){
		User user=new User();
		user.setLoginname("xcc");
		user.setUserPassword("123456");
		user.setMac("12:32:12:31");
		user.setPhone("13812667134");
		user.setDate(new Date().toString());
		SqlSession session=RootUserDB.getSqlSession();
		try{
			int id=session.update("com.xcc.mapper.UserUpdate.updatetbrootuser",user);
			session.commit();
			System.out.println(id);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}

	}

}
