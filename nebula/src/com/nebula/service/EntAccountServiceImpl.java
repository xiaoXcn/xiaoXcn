package com.nebula.service;

import com.nebula.domain.EntAccountDaoImpl;
import com.nebula.entity.EntAccount;

public class EntAccountServiceImpl {

	public boolean doRegister(EntAccount entAccount) {
		EntAccountDaoImpl entAccountDao = new EntAccountDaoImpl();
		return entAccountDao.doRegister(entAccount);
	}

	public boolean doLogin(EntAccount entAccount) {
		EntAccountDaoImpl entAccountDao = new EntAccountDaoImpl();
		return entAccountDao.doLogin(entAccount);
	}
	
}
