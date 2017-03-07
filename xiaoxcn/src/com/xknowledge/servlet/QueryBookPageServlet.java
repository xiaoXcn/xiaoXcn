package com.xknowledge.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.common.utils.StringUtilx;
import com.xknowledge.domain.Book;
import com.xknowledge.domain.Pager;
import com.xknowledge.service.BookService;
import com.xknowledge.service.impl.BookServiceImpl;

/**
 * Servlet implementation class QueryBookPageServlet
 */
public class QueryBookPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		Pager<Book> pager = new Pager<Book>();
		String currentPage = request.getParameter("currentPage");
		pager.setCurrentPage(StringUtilx.isBlank(currentPage)?1:Integer.parseInt(currentPage));
		Book book = new Book();
		book.setAuthor(request.getParameter("author"));
		book.setName(request.getParameter("name"));
		book.setType(request.getParameter("type"));
		List<Book> list = new ArrayList<Book>();
		list.add(book);
		pager.setList(list);
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		pager.setStartTime(startTime);
		pager.setEndTime(endTime);
		BookService bookService = new BookServiceImpl();
		Pager<Book> returnPager = bookService.queryBookPage(pager);
		request.setAttribute("pager", returnPager);
		request.getRequestDispatcher("/WEB-INF/xknowledge/bookList.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
