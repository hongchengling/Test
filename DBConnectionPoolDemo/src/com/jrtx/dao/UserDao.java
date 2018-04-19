package com.jrtx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jrtx.db.C3P0Util;
import com.jrtx.db.DBCPUtil;
import com.jrtx.db.DruidUtil;
import com.jrtx.model.User;

public class UserDao {

	/**
	 * 使用DBCP查询User
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User getUserByIdByDBCP(String id) throws Exception{
		DBCPUtil db=new DBCPUtil();
		Connection conn=db.getConn();
		return queryUser(id, conn);
		
	}
	/**
	 * 使用C3P0查询User
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User getUserByIdByC3P0(String id) throws Exception{
		C3P0Util db=new C3P0Util();
		Connection conn=db.getConn();
		return queryUser(id, conn);
		
	}
	/**
	 * 使用Druid查询User
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public User getUserByIdByDruid(String id) throws Exception{
		DruidUtil db=new DruidUtil();
		Connection conn=db.getConn();
		return queryUser(id, conn);
		
	}

	/**
	 * 查询用户User
	 * @param id
	 * @param conn
	 * @return
	 * @throws SQLException
	 */
	private User queryUser(String id, Connection conn) throws SQLException {
		StringBuilder sb=new StringBuilder();
		sb.append(" SELECT * from SYS_USERS where id=? ");

		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		ptmt.setString(1, id);
		ResultSet re=ptmt.executeQuery();
		
		User u=null;
		while(re.next()){
			u=new User();
			u.setId(re.getString("ID"));
			u.setUserName(re.getString("USER_NAME"));
			u.setUserId(re.getString("USER_ID"));
		}
		return u;
	}
}
