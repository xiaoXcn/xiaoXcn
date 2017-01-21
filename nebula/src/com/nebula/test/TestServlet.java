package com.nebula.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TestServlet extends MyGenericServlet{
	
	private HttpServletRequest request;

	/*@Override
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
	}*/

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		this.request = (HttpServletRequest)request;
		System.out.println("service...");
		if(getServletConfig()!=null){
			ServletContext servletContext = getServletConfig().getServletContext();
			System.out.println("contextPath:"+servletContext.getContextPath());
			System.out.println("serverInfo:"+servletContext.getServerInfo());
			System.out.println("contextName:"+servletContext.getServletContextName());
			System.out.println("servletContextName:"+servletContext.getServletContextName());
			this.request = (HttpServletRequest)request;
			System.out.println(this.request.getRequestURI());
		}
		
		ServletContext servletContext = getServletContext();
		String user = servletContext.getInitParameter("user");
		String password = servletContext.getInitParameter("password");
		PrintWriter out = response.getWriter();
		if(user.equals(request.getParameter("user")) && password.equals(request.getParameter("password"))){
			out.print("hello:"+user);
		}else{
			out.print("sorry:"+request.getParameter("user"));
		}
	}
	
	public TestServlet(){
		System.out.println("TestServlet...");
	}

}
