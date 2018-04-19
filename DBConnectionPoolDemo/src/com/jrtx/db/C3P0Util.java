package com.jrtx.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
* C3P0Util
* 功能：使用C3P0连接池获取数据库连接对象
* @author hcl
*/
public class C3P0Util {
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	/***
	 * 获取连接
	 * 
	 * @return Connection
	 * @throws SQLException 
	 */
	public Connection getConn() throws SQLException {
		return ds.getConnection();
		
	}
	

	

	
}
