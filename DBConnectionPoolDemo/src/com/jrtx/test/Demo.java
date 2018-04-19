package com.jrtx.test;

import java.util.Date;

import org.junit.Test;

import com.jrtx.dao.UserDao;
import com.jrtx.model.User;

public class Demo {


	
	@Test
	public void c3p0Demo() throws Exception{
		Date time1=new Date();
		UserDao user=new UserDao();
		User u=	user.getUserByIdByC3P0("287e3eb67cdd4139bb4cca52610e9f58");
		System.out.println(u.getUserName());
		Date time2=new Date();
		System.out.println(time2.getTime()-time1.getTime());
	}
	
	
	@Test
	public void druidDemo() throws Exception{
		Date time1=new Date();
		UserDao user=new UserDao();
		User u=	user.getUserByIdByDruid("287e3eb67cdd4139bb4cca52610e9f58");
		System.out.println(u.getUserName());
		Date time2=new Date();
		System.out.println(time2.getTime()-time1.getTime());
	}
	
	
	@Test
	public void dbcpDemo() throws Exception{
		Date time1=new Date();
		UserDao user=new UserDao();
		User u=	user.getUserByIdByDBCP("287e3eb67cdd4139bb4cca52610e9f58");
		System.out.println(u.getUserName());
		Date time2=new Date();
		System.out.println(time2.getTime()-time1.getTime());
	}
	
}
