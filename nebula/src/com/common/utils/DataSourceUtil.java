package com.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DataSourceUtil {

	private static DataSource dataSource;
	static{
		try {
			InputStream is = DataSourceUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties prop = new Properties();
			prop.load(is);
			
			BasicDataSourceFactory factory = new BasicDataSourceFactory();
			dataSource = factory.createDataSource(prop);
		} catch (Exception e) {
			throw new RuntimeException("创建数据库连接失败...");
		}
	}
	
	
	public static DataSource getDataSource() {
		return dataSource;
	}


	public static void setDataSource(DataSource dataSource) {
		DataSourceUtil.dataSource = dataSource;
	}


	public static Connection getConnection(){
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
