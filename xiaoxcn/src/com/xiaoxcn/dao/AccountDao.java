package com.xiaoxcn.dao;

import java.sql.SQLException;

import com.xiaoxcn.domain.AccountEntity;
import com.xiaoxcn.domain.UserEntity;

public interface AccountDao {

	public AccountEntity doLogin(AccountEntity accountEntity) throws SQLException;

	public Boolean addUserInfo(UserEntity userEntity) throws SQLException;

	public Boolean addAccountInfo(AccountEntity accountEntity) throws SQLException;

}
