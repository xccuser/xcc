/**
 * 
 */
package com.xcc.electrombilecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xcc.electrombilebean.RootUser;

/**
 *  用户删除
 *
 */
@Controller
public class Userdelete {
	
	@RequestMapping("/delete")
	public void deleteUser(@RequestBody RootUser user){
		
	}
	
	
	
	
	
	
	
	
}
