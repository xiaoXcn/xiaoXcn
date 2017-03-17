package com.xknowledge.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xknowledge.domain.OrderEntity;
import com.xknowledge.service.OrderService;
import com.xknowledge.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class ConfirmOrderServlet
 */
public class ConfirmOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userPhoneNumber = request.getParameter("userPhoneNumber");
		String userAddress = request.getParameter("usesAddress");
		String userName = request.getParameter("userName");
		String id = request.getParameter("id");
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setId(id);
		orderEntity.setUserPhoneNumber(userPhoneNumber);
		orderEntity.setUserAddress(userAddress);
		orderEntity.setUserName(userName);
		OrderService orderService = new OrderServiceImpl();
		Boolean falg = orderService.confirmOrder(orderEntity);
		request.setAttribute("id", id);
		request.getRequestDispatcher("/WEB-INF/xknowledge/completeOrder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
