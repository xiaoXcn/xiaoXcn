package com.xiaoxcn.service;

import com.xiaoxcn.domain.AccountEntity;
import com.xiaoxcn.domain.UserEntity;

public interface AccountService {

	public UserEntity doLogin(AccountEntity accountEntity);

	public Boolean doRegister(UserEntity userEntity, AccountEntity accountEntity);

}
