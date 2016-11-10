package com.xiaox.service;

import java.util.Map;

import com.xiaox.domain.User;

public interface AccountService {

	public Map<String,Object> signin(User user);
}
