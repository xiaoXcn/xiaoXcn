package com.xknowledge.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.common.utils.DataSourceUtil;
import com.xknowledge.dao.OrderDao;
import com.xknowledge.domain.OrderDetailsEntity;
import com.xknowledge.domain.OrderEntity;

public class OrderDaoImpl implements OrderDao {

	@Override
	public Boolean createOrder(OrderEntity orderEntity) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "insert into know_order (id,user_id,create_time,status) values (?,?,?,?)";
		qr.update(DataSourceUtil.getConnection(), sql, orderEntity.getId(),orderEntity.getUserId(),orderEntity.getCreateTime(),orderEntity.getStatus());
		return true;
	}

	@Override
	public Boolean createOrderDetail(OrderDetailsEntity ode) throws SQLException {
		QueryRunner qr = new QueryRunner();
		String sql = "insert into know_order_details (id,order_id,commodity_id,create_time,status) values (?,?,?,?,?)";
		qr.update(DataSourceUtil.getConnection(), sql, ode.getId(),ode.getOrderId(),ode.getCommodityId(),ode.getCreateTime(),ode.getStatus());
		return true;
	}

	@Override
	public Boolean confirmOrder(OrderEntity orderEntity) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "update know_order set user_name=? ,user_phone_number=?,user_address=? where id=? ";
		qr.update(sql, orderEntity.getUserName(),orderEntity.getUserPhoneNumber(),orderEntity.getUserAddress(),orderEntity.getId());
		return true;
	}

	@Override
	public Boolean completeOrder(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "update know_order set status='2' where id=? ";
		qr.update(sql,id);
		return true;
	}

}
