package com.xiaoxcn.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xiaoxcn.dao.AccountDao;
import com.xiaoxcn.dao.impl.AccountDaoImpl;
import com.xiaoxcn.domain.AccountEntity;
import com.xiaoxcn.domain.UserEntity;
import com.xiaoxcn.service.AccountService;

public class AccountServiceImpl implements AccountService {

	@Override
	public UserEntity doLogin(AccountEntity accountEntity) {
		AccountDao accountDao = new AccountDaoImpl();
		UserEntity userEntity = new UserEntity();
		try {
			AccountEntity retAccountEntity = accountDao.doLogin(accountEntity);
			List list = new ArrayList();
			list.add(retAccountEntity);
			userEntity.setAccountList(list);
			return userEntity;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
