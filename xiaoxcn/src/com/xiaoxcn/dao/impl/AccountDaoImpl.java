package com.xiaoxcn.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.common.utils.DataSourceUtil;
import com.xiaoxcn.dao.AccountDao;
import com.xiaoxcn.domain.AccountEntity;

public class AccountDaoImpl implements AccountDao {

	@Override
	public AccountEntity doLogin(AccountEntity accountEntity) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		AccountEntity retAccountEntity = qr.query("select * from x_account where account = ? and password = ? limit 1 ", new BeanHandler<AccountEntity>(AccountEntity.class), accountEntity.getAccount(),accountEntity.getPassword());
		return retAccountEntity;
	}

}
