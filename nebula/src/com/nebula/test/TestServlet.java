package com.nebula.test;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TestServlet implements Servlet{

	@Override
	public void destroy() {
		System.out.println("destroy...");
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		System.out.println("init...");
		System.out.println(servletConfig.getInitParameter("name"));
		System.out.println(servletConfig.getInitParameterNames());
		Enumeration names = servletConfig.getInitParameterNames();
		while(names.hasMoreElements()){
			names.nextElement();
		}
		servletConfig.getServletName();
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("service...");
		
	}
	
	public TestServlet(){
		System.out.println("TestServlet...");
	}

}
