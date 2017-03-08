package com.xknowledge.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.xknowledge.domain.Book;
import com.xknowledge.domain.BookPlus;
import com.xknowledge.service.BookService;
import com.xknowledge.service.impl.BookServiceImpl;

/**
 * Servlet implementation class AddBookInfoServlet
 */
public class AddSaveBookInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Book book = new Book();
		BookPlus bookPlus = new BookPlus();
		try {
			BeanUtils.populate(book, request.getParameterMap());
			BeanUtils.populate(bookPlus, request.getParameterMap());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		book.setBookPlus(bookPlus);
		BookService bookService = new BookServiceImpl();
		bookService.addBookInfo(book);
		request.getRequestDispatcher("/xknowledge/queryBookPageServlet?operateType=skip").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
