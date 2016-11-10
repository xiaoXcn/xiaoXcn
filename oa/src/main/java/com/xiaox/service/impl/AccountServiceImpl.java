package com.xiaox.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.xiaox.base.BeanFactory;
import com.xiaox.base.Constants;
import com.xiaox.base.ReturnMap;
import com.xiaox.dao.AccountDao;
import com.xiaox.domain.User;
import com.xiaox.service.AccountService;

import common.utils.StringUtils;

public class AccountServiceImpl implements AccountService{

	@Override
	public Map<String, Object> signin(User user) {
		Map<String,Object> map = new HashMap<String,Object>();
		if(StringUtils.isBlank(user.getAccount())||StringUtils.isBlank(user.getPassword())){
			map = ReturnMap.assembleReturnMap(Constants.RESULT_FAILED, Constants.PARAM_IS_NULL_ACCOUNT_OR_PWD);
			return map;
		}
		AccountDao accountDao = (AccountDao)BeanFactory.getInstance("AccountDao");
		User returnUser = accountDao.signin(user);
		if(null==returnUser){
			return ReturnMap.assembleReturnMap(Constants.RESULT_FAILED, Constants.WRONG_ACCOUNT_OR_PWD);
		}
		map = ReturnMap.assembleReturnMap(Constants.RESULT_SUCCESS, Constants.DESC_SUCCESS);
		map = ReturnMap.addReturnParam(map, "user", returnUser);
		return map;
	}

}
