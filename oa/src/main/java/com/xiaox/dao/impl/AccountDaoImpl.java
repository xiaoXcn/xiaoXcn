package com.xiaox.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import com.xiaox.base.DBConnection;
import com.xiaox.dao.AccountDao;
import com.xiaox.domain.User;

public class AccountDaoImpl implements AccountDao{

	@Override
	public User signin(User user) {
		String sql = "select * from oa_user where account=? and password=? and status='0'";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User returnUser = null;
		try {
			conn = DBConnection.getDBConnection();
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			if(rs.next()){
				returnUser = new User();
				returnUser.setId(rs.getString("id"));
				returnUser.setAccount(rs.getString("account"));
				returnUser.setName(rs.getString("name"));
				returnUser.setGender(rs.getString("gender"));
				returnUser.setPhone(rs.getString("phone"));
				returnUser.setJoniTime(rs.getTimestamp("jointime"));
				returnUser.setGrade(rs.getString("grade"));
				returnUser.setSuperior(rs.getString("superior"));
				returnUser.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBConnection.close(rs);
			DBConnection.close(pst);
			DBConnection.close(conn);
		}
		return returnUser;
	}

}
