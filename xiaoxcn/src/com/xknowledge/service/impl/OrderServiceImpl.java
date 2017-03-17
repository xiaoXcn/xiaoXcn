package com.xknowledge.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.common.utils.DataSourceUtil;
import com.common.utils.IDUtilx;
import com.xiaoxcn.domain.UserEntity;
import com.xknowledge.dao.OrderDao;
import com.xknowledge.dao.impl.OrderDaoImpl;
import com.xknowledge.domain.OrderDetailsEntity;
import com.xknowledge.domain.OrderEntity;
import com.xknowledge.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Override
	public List<OrderDetailsEntity> changeUserCart(List<OrderDetailsEntity> list,String commodityId) {
		List<OrderDetailsEntity> reList = new ArrayList<OrderDetailsEntity>();
		boolean hasCommodity = false;
		if(list != null && list.size()>0){
			for(OrderDetailsEntity ode : list){
				if(commodityId.equals(ode.getCommodityId())){
					hasCommodity = true;
				}
			}
		}
		reList.addAll(list);
		if(!hasCommodity){
			OrderDetailsEntity ode = new OrderDetailsEntity();
			ode.setCommodityId(commodityId);
			reList.add(ode);
		}

		return reList;
	}

	@Override
	public Boolean bulidOrder(UserEntity currentUser, List<OrderDetailsEntity> list) {
		try {
			DataSourceUtil.startTransaction();
			OrderEntity orderEntity = new OrderEntity();
			String orderId = IDUtilx.getUUID();
			orderEntity.setId(orderId);
			orderEntity.setUserId(currentUser.getId());
			orderEntity.setCreateTime(new Date());
			orderEntity.setStatus("1");
			OrderDao orderDao = new OrderDaoImpl();
			Boolean f1 = orderDao.createOrder(orderEntity);
			for(OrderDetailsEntity ode:list){
				ode.setId(IDUtilx.getUUID());
				ode.setOrderId(orderId);
				ode.setStatus("0");
				Boolean f2 = orderDao.createOrderDetail(ode);
			}
		} catch (SQLException e) {
			DataSourceUtil.rollBack();
			e.printStackTrace();
		} finally{
			DataSourceUtil.commit();
			DataSourceUtil.release();
		}
		return true;
	}

	@Override
	public Boolean confirmOrder(OrderEntity orderEntity) {
		OrderDao orderDao = new OrderDaoImpl();
		Boolean flag = false;
		try {
			flag = orderDao.confirmOrder(orderEntity);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public Boolean completeOrder(String id) {
		OrderDao orderDao = new OrderDaoImpl();
		Boolean flag = false;
		try {
			flag = orderDao.completeOrder(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;

	}

}
