package com.xiaoxcn.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.xiaoxcn.init.InitSystemParams;

public class InitSystemListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("系统启动。。。");
		ServletContext servletContext = arg0.getServletContext();
		InitSystemParams initSystemParams = new InitSystemParams();
		initSystemParams.InitNodeParams(servletContext);
		initSystemParams.InitBookTypeParams(servletContext);
		
		
	}

}
