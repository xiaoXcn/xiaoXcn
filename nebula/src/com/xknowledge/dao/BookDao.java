package com.xknowledge.dao;

import java.sql.SQLException;

import com.xknowledge.domain.Book;
import com.xknowledge.domain.Pager;

public interface BookDao {

	public Pager<Book> queryBookPage(Pager<Book> pager) throws SQLException;

}
