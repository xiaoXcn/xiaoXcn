package com.xknowledge.dao;

import java.sql.SQLException;
import java.util.List;

import com.xknowledge.domain.Book;
import com.xknowledge.domain.Pager;

public interface BookDao {

	public Pager<Book> queryBookPage(Pager<Book> pager) throws SQLException;

	public Book queryBookSingle(String id) throws SQLException;

	public Boolean addBookInfo(Book book) throws SQLException;
	
	public Boolean addBookPlusInfo(Book book) throws SQLException;

	public Boolean editBookInfo(Book book) throws SQLException;
	
	public Boolean editBookPlusInfo(Book book) throws SQLException;

	public Boolean delBookInfo(String id) throws SQLException;

	public Boolean delBookPlusInfo(String id) throws SQLException;

	public List<Object> searchByName(String name) throws SQLException;

	

}
