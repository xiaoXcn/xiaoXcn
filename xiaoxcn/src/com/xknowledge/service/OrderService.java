package com.xknowledge.service;

import java.util.List;

import com.xiaoxcn.domain.UserEntity;
import com.xknowledge.domain.OrderDetailsEntity;
import com.xknowledge.domain.OrderEntity;

public interface OrderService {

	public List<OrderDetailsEntity> changeUserCart(List<OrderDetailsEntity> list,String commodityId);

	public Boolean bulidOrder(UserEntity currentUser, List<OrderDetailsEntity> list);

	public Boolean confirmOrder(OrderEntity orderEntity);

	public Boolean completeOrder(String id);

}
