package com.xknowledge.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xknowledge.domain.Book;
import com.xknowledge.service.BookService;
import com.xknowledge.service.impl.BookServiceImpl;

/**
 * Servlet implementation class QueryBookSigleServlet
 */
public class QueryBookSigleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String id = request.getParameter("id");
		String operType = request.getParameter("operType");
		BookService bookService = new BookServiceImpl();
		Book book = bookService.queryBookSingle(id);
		request.setAttribute("book", book);
		if("query".equalsIgnoreCase(operType)){
			request.getRequestDispatcher("/WEB-INF/xknowledge/bookInfo.jsp").forward(request, response);
		}else if("edit".equalsIgnoreCase(operType)){
			request.getRequestDispatcher("/WEB-INF/xknowledge/editBook.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
