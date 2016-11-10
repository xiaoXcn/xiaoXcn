package com.xiaox.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oracle.jrockit.jfr.RequestDelegate;
import com.xiaox.base.BeanFactory;
import com.xiaox.base.Constants;
import com.xiaox.domain.User;
import com.xiaox.service.AccountService;

import common.utils.StringUtils;

/**
 * Servlet implementation class AccountServlet
 */
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String operateType = request.getParameter("operateType");
		User user = new User();
		Map<String,Object> map = new HashMap<String,Object>();
		RequestDispatcher rd = null;
		if(Constants.OPERATE_TPYE_SIGNIN.equals(operateType)){
			//登录操作
			String account = request.getParameter("account");
			String password = request.getParameter("password");
			user.setAccount(account);
			user.setPassword(password);
			AccountService accountService = (AccountService)BeanFactory.getInstance("AccountService");
			map = accountService.signin(user);
			request.setAttribute("result", map);
			if(Constants.RESULT_SUCCESS.equals(map.get("result"))){
				rd = request.getRequestDispatcher("index.jsp");
			}else{
				rd = request.getRequestDispatcher("login.jsp");
			}
		}else if(Constants.OPERATE_TYPE_SIGNOUT.equals(operateType)){
			
		}else if(Constants.OPERATE_TYPE_SINGUP.equals(operateType)){
			
		}else{
			
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
