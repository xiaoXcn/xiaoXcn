package com.xiaoxcn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.utils.StringUtilx;
import com.xiaoxcn.domain.AccountEntity;
import com.xiaoxcn.domain.UserEntity;
import com.xiaoxcn.service.AccountService;
import com.xiaoxcn.service.impl.AccountServiceImpl;

/**
 * Servlet implementation class LoginServelt
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setAccount(account);
		accountEntity.setPassword(password);
		AccountService accountService = new AccountServiceImpl();
		UserEntity userEntity = accountService.doLogin(accountEntity);
		if(userEntity!=null){
			String autoLogin = request.getParameter("autoLogin");
			Cookie cookie = new Cookie("accountInfo", account+"&"+password);
			cookie.setPath("/");
			if(!StringUtilx.isBlank(autoLogin)){
				cookie.setMaxAge(60*60*24*7);
			}else{
				cookie.setMaxAge(0);
			}
			response.addCookie(cookie);
			request.getRequestDispatcher("/indexServlet").forward(request, response);
		}else{
			request.setAttribute("errorMsg", "用户名或密码错误!");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
