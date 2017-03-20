package com.xiaoxcn.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.common.utils.DataSourceUtil;
import com.xiaoxcn.dao.UserDao;
import com.xiaoxcn.domain.UserEntity;

public class UserDaoImpl implements UserDao {

	@Override
	public UserEntity getUserById(String userId) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select id,name,gender,birthday,id_card_no idCardNo,phone_number phoneNumber,qq_number qqNumber,weixin,weibo,email from x_user where id=? ";
		return qr.query(sql, new BeanHandler<>(UserEntity.class), userId);
		
	}

}
