package com.nebula.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.common.utils.IDUtilx;
import com.nebula.base.ConnectionManage;
import com.nebula.entity.EntAccount;

public class EntAccountDaoImpl {

	public boolean doRegister(EntAccount entAccount) {
		String account_id = IDUtilx.getUUID();
		String user_id = IDUtilx.getUUID();
		String sql = "insert into ent_account (id,account,account_pwd,user_id) values (?,?,?,?)";
		String sql1 = "insert into ent_user (user_id) values (?)";
		Connection conn = ConnectionManage.getConnection();
		PreparedStatement ps = null;
		try {
			 ps = conn.prepareStatement(sql);
			 ps.setString(1, account_id);
			 ps.setString(2, entAccount.getAccount());
			 ps.setString(3, entAccount.getAccountPwd());
			 ps.setString(4, user_id);
			 ps.executeUpdate();
			 ps = null;
			 ps = conn.prepareStatement(sql1);
			 ps.setString(1, user_id);
			 ps.executeUpdate();
			 return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}finally {
			ConnectionManage.closeConnection(conn, ps, null);
		}
	}

	public boolean doLogin(EntAccount entAccount) {
		String sql = "select * from ent_account where account=? and account_pwd=?";
		Connection conn = ConnectionManage.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, entAccount.getAccount());
			ps.setString(2, entAccount.getAccountPwd());
			rs= ps.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

}
