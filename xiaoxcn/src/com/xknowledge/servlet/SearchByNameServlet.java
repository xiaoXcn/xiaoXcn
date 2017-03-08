package com.xknowledge.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xknowledge.service.BookService;
import com.xknowledge.service.impl.BookServiceImpl;

/**
 * Servlet implementation class SearchByNameServlet
 */
public class SearchByNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String name = request.getParameter("name");
		BookService bookService = new BookServiceImpl();
		List<Object> nameList = bookService.searchByName(name);
		String retStr = "";
		if(nameList!=null){
			for(int i=0;i<nameList.size();i++){
				retStr += nameList.get(i);
				if(i!=nameList.size()-1){
					retStr += ",";
				}
			}
		}
		System.out.println(retStr);
		response.getWriter().write(retStr);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
