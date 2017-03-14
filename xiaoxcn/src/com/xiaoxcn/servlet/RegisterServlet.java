package com.xiaoxcn.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.common.utils.IDUtilx;
import com.common.utils.MD5Utilx;
import com.xiaoxcn.domain.AccountEntity;
import com.xiaoxcn.domain.UserEntity;
import com.xiaoxcn.service.AccountService;
import com.xiaoxcn.service.impl.AccountServiceImpl;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserEntity userEntity = new UserEntity();
		AccountEntity accountEntity = new AccountEntity();
		try {
			BeanUtils.populate(userEntity, request.getParameterMap());
			BeanUtils.populate(accountEntity, request.getParameterMap());
			String userId = IDUtilx.getUUID();
			String accountId = IDUtilx.getUUID();
			userEntity.setId(userId);
			accountEntity.setId(accountId);
			accountEntity.setPassword(MD5Utilx.toMD5(accountEntity.getPassword()));
			accountEntity.setUserId(userId);
			AccountService accountService = new AccountServiceImpl();
			Boolean flag = accountService.doRegister(userEntity,accountEntity);
			if(flag){
				request.setAttribute("msg", "注册成功，请登录!");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "注册失败，请按正确格式填写信息!");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
