package com.xiaoxcn.menu.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.db.ConnectionManager;
import com.xiaoxcn.menu.dao.MenuDao;
import com.xiaoxcn.menu.entity.Menu;

public class MenuDaoImpl implements MenuDao {

	public List<Menu> getMenuList(Menu menu) {
		String sql = "select id,menu_name menuName,menu_code menuCode,sort,type,create_time createTime from c_menu where type=?";
		Connection conn = ConnectionManager.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Menu> list = new ArrayList<Menu>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, menu.getType());
			rs = ps.executeQuery();
			while(rs.next()){
				Menu reMenu = new Menu();
				reMenu.setId(rs.getString("id"));
				reMenu.setMenuName(rs.getString("menuName"));
				reMenu.setMenuCode(rs.getString("menuCode"));
				reMenu.setSort(rs.getInt("sort"));
				reMenu.setType(rs.getString("type"));
				reMenu.setCreateTime(rs.getDate("createTime"));
				list.add(reMenu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
