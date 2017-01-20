package com.nebula.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EntAccountController {
	
	public String register(HttpServletRequest request,HttpServletResponse response){
		return "/register.jsp";
	}
	
	public void doLogin(HttpServletRequest request,HttpServletResponse response){
		System.out.println("调用login方法...");
	}
	
	public void doRegister(HttpServletRequest request,HttpServletResponse response){
		System.out.println("调用register方法...");
	}

}
