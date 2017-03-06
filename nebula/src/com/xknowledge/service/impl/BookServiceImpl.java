package com.xknowledge.service.impl;

import java.sql.SQLException;

import com.xknowledge.dao.BookDao;
import com.xknowledge.dao.impl.BookDaoImpl;
import com.xknowledge.domain.Book;
import com.xknowledge.domain.Pager;
import com.xknowledge.service.BookService;

public class BookServiceImpl implements BookService {

	@Override
	public Pager<Book> queryBookPage(Pager<Book> pager) {
		BookDao bookDao = new BookDaoImpl();
		try {
			return bookDao.queryBookPage(pager);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
