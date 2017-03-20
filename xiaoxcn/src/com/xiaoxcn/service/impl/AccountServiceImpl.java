package com.xiaoxcn.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.common.utils.DataSourceUtil;
import com.common.utils.StringUtilx;
import com.xiaoxcn.dao.AccountDao;
import com.xiaoxcn.dao.UserDao;
import com.xiaoxcn.dao.impl.AccountDaoImpl;
import com.xiaoxcn.dao.impl.UserDaoImpl;
import com.xiaoxcn.domain.AccountEntity;
import com.xiaoxcn.domain.UserEntity;
import com.xiaoxcn.service.AccountService;

public class AccountServiceImpl implements AccountService {

	@Override
	public UserEntity doLogin(AccountEntity accountEntity) {
		AccountDao accountDao = new AccountDaoImpl();
		UserDao userDao = new UserDaoImpl();
		UserEntity userEntity = new UserEntity();
		try {
			AccountEntity retAccountEntity = accountDao.doLogin(accountEntity);
			if(retAccountEntity!=null&&!StringUtilx.isBlank(retAccountEntity.getUserId())){
				userEntity = userDao.getUserById(retAccountEntity.getUserId());
			}
			List<AccountEntity> list = new ArrayList<AccountEntity>();
			list.add(retAccountEntity);
			userEntity.setAccountList(list);
			return userEntity;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean doRegister(UserEntity userEntity, AccountEntity accountEntity) {
		Boolean flag = true;
		try {
			DataSourceUtil.startTransaction();
			AccountDao accountDao = new AccountDaoImpl();
			Boolean f1 = accountDao.addUserInfo(userEntity);
			Boolean f2 = accountDao.addAccountInfo(accountEntity);
		} catch (SQLException e) {
			flag=false;
			DataSourceUtil.rollBack();
			e.printStackTrace();
		}finally{
			DataSourceUtil.commit();
			DataSourceUtil.release();
		}
		
		return flag;
	}

}
