package com.nebula.test;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TestServlet implements Servlet{
	
	private ServletConfig servletConfig;
	private HttpServletRequest request;

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
		this.servletConfig = servletConfig;
	}

	@Override
	public void service(ServletRequest request, ServletResponse arg1) throws ServletException, IOException {
		this.request = (HttpServletRequest)request;
		System.out.println("service...");
		if(servletConfig!=null){
			ServletContext servletContext = servletConfig.getServletContext();
			System.out.println("contextPath:"+servletContext.getContextPath());
			System.out.println("serverInfo:"+servletContext.getServerInfo());
			System.out.println("contextName:"+servletContext.getServletContextName());
			System.out.println("servletContextName:"+servletContext.getServletContextName());
			this.request = (HttpServletRequest)request;
			System.out.println(this.request.getRequestURI());
		}
		
	}
	
	public TestServlet(){
		System.out.println("TestServlet...");
	}

}
