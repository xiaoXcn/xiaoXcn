package com.common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionManager {
	
	private static String url = null;
	private static String name = null;
	private static String password = null;
	
	static{
		ResourceBundle rb = ResourceBundle.getBundle("/jdbc.properties");
		url = rb.getString("jdbc.mysql.url");
		name = rb.getString("jdbc.mysql.name");
		password = rb.getString("jdbc.mysql.password");
	}
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection(url,name,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

}
