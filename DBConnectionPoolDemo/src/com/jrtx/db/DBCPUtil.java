package com.jrtx.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class DBCPUtil {

	private static DataSource DS;
	private static final String configFile = "/dbcp.properties";

	/***
	 * 获取连接
	 * 
	 * @return Connection
	 */
	public Connection getConn() {
		Connection conn = null;
		if (DS !=null) {
			try { 
				conn = DS.getConnection();
				conn.setAutoCommit(false);
			} catch (SQLException e) {
				e.printStackTrace(System.err);
			}
			return conn;
		}
		return conn;
		
	}
	
	/**
	 * 构造函数
	 */
	public DBCPUtil() {
			initDbcp();
	}
	
	/**
	 * 初始化DataSource
	 */
	public static void initDbcp() {
		Properties pops =new Properties();
		try {
			pops.load(Object.class.getResourceAsStream(configFile));
			DS = BasicDataSourceFactory.createDataSource(pops);
			/*BasicDataSource ds=new BasicDataSource();
			ds.setDriverClassName("");
			ds.setUsername("");
			ds.setPassword("");
			ds.setUrl("");
			*/
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
