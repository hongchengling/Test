package com.jrtx.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;


public class DruidUtil123 {
	private static DruidPooledConnection databasePool=null;
	private static DruidDataSource dds = null;
	static {
		Properties properties = loadPropertyFile("db_server.properties");
		try {
			dds = (DruidDataSource) DruidDataSourceFactory
					.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void DruidPooledConnection() {}
	public static synchronized DruidPooledConnection getInstance() {
		if (null == databasePool) {
			databasePool = new DruidPooledConnection(null);
		}
		return databasePool;
	}
	public DruidPooledConnection getConnection() throws SQLException {
		return dds.getConnection();
	}
	public static Properties loadPropertyFile(String fullFile) {
		/*String webRootPath = null;
		if (null == fullFile || fullFile.equals(""))
			throw new IllegalArgumentException(
					"Properties file path can not be null : " + fullFile);
		webRootPath = DbPoolConnection.class.getClassLoader().getResource("")
				.getPath();
		
		//getParent()获取webRootPath的父级目录
		webRootPath = new File(webRootPath).getParent();
		System.out.println(webRootPath);
		InputStream inputStream = null;
		Properties p = null;
		try {
			inputStream = new FileInputStream(new File(webRootPath
					+ File.separator + fullFile));
			p = new Properties();
			p.load(inputStream);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Properties file not found: "
					+ fullFile);
		} catch (IOException e) {
			throw new IllegalArgumentException(
					"Properties file can not be loading: " + fullFile);
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;*/
		
		Properties p = new Properties();
		if(fullFile == "" || fullFile.equals(""))
		{
			System.out.println("属性文件为空!~");
		}
		else
		{
			//加载属性文件
			InputStream inStream = DruidPooledConnection.class.getClassLoader().getResourceAsStream(fullFile);
			try {
				p.load(inStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return p;
	}
	
}