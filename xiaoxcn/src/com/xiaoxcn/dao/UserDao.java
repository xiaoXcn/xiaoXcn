package com.xiaoxcn.dao;

import java.sql.SQLException;

import com.xiaoxcn.domain.UserEntity;

public interface UserDao {

	public UserEntity getUserById(String userId) throws SQLException;

}
