package com.nebula.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.utils.StringUtilx;

public class HandlerServlet implements Servlet{
	
	private ServletConfig servletConfig;
	private ServletContext servletContext;
	private HttpServletRequest request;
	private HttpServletResponse response;
	

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
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
	public void init(ServletConfig arg0) throws ServletException {
		this.servletConfig = arg0;
		this.servletContext = arg0.getServletContext();
		
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		this.request = (HttpServletRequest) arg0;
		this.response = (HttpServletResponse) arg1;
		String requestUrl = request.getRequestURI();
		String contextPath = servletContext.getContextPath();
		String requestName = requestUrl.replace(contextPath, "");
		System.out.println("methodName:"+requestName);
		
		//将/xxx/yyy.do请求名转换成XxxController 类  yyy方法  
		String[] str = requestName.split("/");
		if(str.length == 3){
			String className = StringUtilx.upperFirstWord(str[1])+"Controller";
			String methodName = str[2].split("\\.")[0];
			try {
				Class<?> c = Class.forName("com.nebula.controller."+className);
				Object obj = c.newInstance();
				Method method = c.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
				String returnString = (String) method.invoke(obj, arg0,arg1);
				System.out.println(returnString);
				request.getRequestDispatcher("/WEB-INF"+returnString).forward(arg0, arg1);
				//response.sendRedirect("/WEB-INF"+returnString);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
