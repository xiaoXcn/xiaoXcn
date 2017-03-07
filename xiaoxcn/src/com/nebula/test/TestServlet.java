package com.nebula.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.ConnectionEvent;

public class TestServlet extends MyHttpServlet{
	
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

	/*@Override
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
	}*/
	
	public TestServlet(){
		System.out.println("TestServlet...");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("user");
		String password = request.getParameter("password");
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select count(1) from ent_account where account = ? and account_pwd = ?";
		String url = "jdbc:mysql://121.43.151.74:3306/entertainment?useUnicode=true&characterEncoding=UTF-8";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url,"nebula_ent","pass4nebula_ent");
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()){
				System.out.println(rs.getInt(1));
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
