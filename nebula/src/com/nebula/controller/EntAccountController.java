package com.nebula.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.utils.StringUtilx;
import com.nebula.entity.EntAccount;
import com.nebula.service.EntAccountServiceImpl;

public class EntAccountController {
	
	public String register(HttpServletRequest request,HttpServletResponse response){
		return "/view/register.jsp";
	}
	
	public String doRegister(HttpServletRequest request,HttpServletResponse response){
		System.out.println("doRegister");
		String account = request.getParameter("account");
		String accountPwd = request.getParameter("accountPwd");
		if(StringUtilx.isBlank(account)||StringUtilx.isBlank(accountPwd)){
			return null;
		}
		EntAccount entAccount = new EntAccount();
		entAccount.setAccount(account);
		entAccount.setAccountPwd(accountPwd);
		EntAccountServiceImpl entAccountService = new EntAccountServiceImpl();
		boolean flag = entAccountService.doRegister(entAccount);
		if(flag){
			return "/view/login.jsp";
		}else{
			return null;
		}
	}
	
	public String login(HttpServletRequest request,HttpServletResponse response){
		return "/view/login.jsp";
	}
	
	public String doLogin(HttpServletRequest request,HttpServletResponse response){
		System.out.println("doLogin");
		String account = request.getParameter("account");
		String accountPwd = request.getParameter("accountPwd");
		if(StringUtilx.isBlank(account)||StringUtilx.isBlank(accountPwd)){
			return null;
		}
		EntAccount entAccount = new EntAccount();
		entAccount.setAccount(account);
		entAccount.setAccountPwd(accountPwd);
		EntAccountServiceImpl entAccountService = new EntAccountServiceImpl();
		boolean flag = entAccountService.doLogin(entAccount);
		if(flag){
			return "/view/index.jsp";
		}else{
			return null;
		}
	}

}
