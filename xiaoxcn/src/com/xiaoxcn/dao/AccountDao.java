package com.xiaoxcn.dao;

import java.sql.SQLException;

import com.xiaoxcn.domain.AccountEntity;

public interface AccountDao {

	public AccountEntity doLogin(AccountEntity accountEntity) throws SQLException;

}
