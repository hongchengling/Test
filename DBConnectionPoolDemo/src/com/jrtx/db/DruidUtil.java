package com.jrtx.db;

import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;


public class DruidUtil {

	private static DruidDataSource dds = null;
	private static final String configFile = "/druid.properties";
	
	/**
	 * 获取连接
	 * @return
	 * @throws SQLException
	 */
	public DruidPooledConnection getConn() throws SQLException {
		return dds.getConnection();
	}
	
	/**
	 * 构造函数
	 */
	public DruidUtil() {
		initDruid();
	}
	/**
	 * 初始化DruidDataSource
	 */
	public static void initDruid() {
	try {
			Properties pops = new Properties();
			//从输入流中读取属性列表（键和元素对）
			pops.load(Object.class.getResourceAsStream(configFile));
			dds = (DruidDataSource) DruidDataSourceFactory.createDataSource(pops);	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}