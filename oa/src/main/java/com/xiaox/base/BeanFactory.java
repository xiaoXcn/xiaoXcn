package com.xiaox.base;

import com.xiaox.dao.AccountDao;
import com.xiaox.dao.impl.AccountDaoImpl;
import com.xiaox.service.AccountService;
import com.xiaox.service.impl.AccountServiceImpl;

public class BeanFactory {
	
	private static AccountService accountService = new AccountServiceImpl();
	private static AccountDao accountDao = new AccountDaoImpl();

	public static Object getInstance(String str){
		if("AccountService".equals(str)){
			return accountService;
		}else if("AccountDao".equals(str)){
			return accountDao;
		}
		return null;
	}
}
