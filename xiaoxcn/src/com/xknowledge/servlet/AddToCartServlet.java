package com.xknowledge.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.common.utils.StringUtilx;
import com.xknowledge.domain.OrderDetailsEntity;
import com.xknowledge.service.OrderService;
import com.xknowledge.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class AddToCart
 */
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commodityId = request.getParameter("id");
		OrderService orderService = new OrderServiceImpl();
		HttpSession session = request.getSession();
		List<OrderDetailsEntity> list = (List<OrderDetailsEntity>) session.getAttribute("userCart");
		List<OrderDetailsEntity> reList = orderService.changeUserCart(list,commodityId);
		session.setAttribute("userCart", reList);
		request.getRequestDispatcher("/WEB-INF/xknowledge/cartSkip.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
