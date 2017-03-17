package com.xiaoxcn.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.common.utils.DataSourceUtil;
import com.xiaoxcn.dao.AccountDao;
import com.xiaoxcn.domain.AccountEntity;
import com.xiaoxcn.domain.UserEntity;

public class AccountDaoImpl implements AccountDao {

	@Override
	public AccountEntity doLogin(AccountEntity accountEntity) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		AccountEntity retAccountEntity = qr.query("select * from x_account where account = ? and password = ? limit 1 ", new BeanHandler<AccountEntity>(AccountEntity.class), accountEntity.getAccount(),accountEntity.getPassword());
		return retAccountEntity;
	}

	@Override
	public Boolean addUserInfo(UserEntity userEntity) throws SQLException {
		String sql = "insert into x_user (id,name,gender,birthday,phone_number,email) values (?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner();
		qr.update(DataSourceUtil.getConnection(), sql, userEntity.getId(),userEntity.getName(),userEntity.getGender(),userEntity.getBirthday(),userEntity.getPhoneNumber(),userEntity.getEmail());
		return true;
	}

	@Override
	public Boolean addAccountInfo(AccountEntity accountEntity) throws SQLException {
		String sql = "insert into x_user (id,user_id,account,password,account_type,app_code,status) values (?,?,?,?,?,?,?)";
		QueryRunner qr = new QueryRunner();
		qr.update(DataSourceUtil.getConnection(), sql, accountEntity.getId(),accountEntity.getUserId(),accountEntity.getAccount(),accountEntity.getPassword(),accountEntity.getAccountType(),accountEntity.getAppCode(),accountEntity.getStatus());
		return true;
	}

}
