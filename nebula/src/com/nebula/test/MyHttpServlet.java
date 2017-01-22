package com.nebula.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class MyHttpServlet extends MyGenericServlet{

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		
		try{
			request = (HttpServletRequest)arg0;
			response = (HttpServletResponse)arg1;
			String method = request.getMethod();
			if("GET".equalsIgnoreCase(method)){
				doGet(request,response);
			}else if("POST".equalsIgnoreCase(method)){
				doPost(request,response);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public abstract void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException;
	
	public abstract void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException;

}
