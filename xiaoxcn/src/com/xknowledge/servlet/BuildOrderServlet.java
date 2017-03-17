package com.xknowledge.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiaoxcn.domain.UserEntity;
import com.xknowledge.domain.OrderDetailsEntity;
import com.xknowledge.service.OrderService;
import com.xknowledge.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class BuildServlet
 */
public class BuildOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<OrderDetailsEntity> list = (List<OrderDetailsEntity>) session.getAttribute("userCart");
		if(list!=null&&list.size()>0){
			UserEntity currentUser = (UserEntity) session.getAttribute("userInfo");
			if(currentUser!=null){
				OrderService orderService = new OrderServiceImpl();
				Boolean falg = orderService.bulidOrder(currentUser,list);
				request.getRequestDispatcher("/WEB-INF/xknowledge/viewOrder.jsp").forward(request, response);
			}
		}
		request.getRequestDispatcher("/WEB-INF/xknowledge/viewCart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
