package com.xknowledge.dao;

import java.sql.SQLException;

import com.xknowledge.domain.OrderDetailsEntity;
import com.xknowledge.domain.OrderEntity;

public interface OrderDao {

	public Boolean createOrder(OrderEntity orderEntity) throws SQLException;

	public Boolean createOrderDetail(OrderDetailsEntity ode) throws SQLException;

	public Boolean confirmOrder(OrderEntity orderEntity) throws SQLException;

	public Boolean completeOrder(String id) throws SQLException;

}
