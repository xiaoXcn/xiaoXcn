package com.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DataSourceUtil {
	//加入事务控制  使用线程局部变量类   并添加开启事务、回滚事务、和提交事务方法
	private static ThreadLocal<Connection> tl  = new ThreadLocal<Connection>();
	

	private static DataSource dataSource;
	static{
		try {
			InputStream is = DataSourceUtil.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			Properties prop = new Properties();
			prop.load(is);
			System.out.println("创建数据源....");
			dataSource = BasicDataSourceFactory.createDataSource(prop);
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
		Connection conn = null;
		try {
			//从线程中获取连接，如果没有则创建一个并将其放入线程中
			conn = tl.get();
			synchronized(DataSourceUtil.class){
				if(conn==null){
					conn = dataSource.getConnection();
					tl.set(conn);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void startTransaction(){
		try {
			Connection conn = tl.get();
			if(conn==null){
				conn = getConnection();
			}
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void rollBack(){
		try {
			Connection conn = tl.get();
			if(conn==null){
				conn = getConnection();
			}
			conn.rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void commit(){
		try {
			Connection conn = tl.get();
			if(conn==null){
				conn = getConnection();
			}
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void release(){
		try {
			Connection conn = tl.get();
			if(conn!=null){
				conn.close();
				tl.remove();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
