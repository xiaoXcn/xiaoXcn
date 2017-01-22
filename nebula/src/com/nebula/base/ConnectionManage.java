package com.nebula.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManage {
	
	private static String url = "jdbc:mysql://121.43.151.74:3306/entertainment?useUnicode=true&characterEncoding=UTF-8";
	private static String name = "nebula_ent";
	private static String password = "pass4nebula_ent";
	
	public static  Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,name,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static  boolean closeConnection(Connection conn,PreparedStatement ps,ResultSet rs){
		try {
			if(rs!=null&&rs instanceof ResultSet){
				rs.close();
			}
			if(ps!=null&&ps instanceof PreparedStatement){
				ps.close();
			}
			if(conn!=null&&conn instanceof Connection){
				conn.close();
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
