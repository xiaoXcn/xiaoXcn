package com.xknowledge.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.common.utils.DataSourceUtil;
import com.common.utils.IDUtilx;
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

	@Override
	public Book queryBookSingle(String id) {
		BookDao bookDao = new BookDaoImpl();
		try {
			return bookDao.queryBookSingle(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Boolean addBookInfo(Book book) {
		BookDao bookDao = new BookDaoImpl();
		try {
			DataSourceUtil.startTransaction();
			book.setId(IDUtilx.getUUID());
			bookDao.addBookInfo(book);
			bookDao.addBookPlusInfo(book);
		} catch (SQLException e) {
			DataSourceUtil.rollBack();
			e.printStackTrace();
		} finally{
			DataSourceUtil.commit();
			DataSourceUtil.release();
		}
		return true;
		
	}

	@Override
	public Boolean editBookInfo(Book book) {
		BookDao bookDao = new BookDaoImpl();
		try {
			DataSourceUtil.startTransaction();
			bookDao.editBookInfo(book);
			bookDao.editBookPlusInfo(book);
		} catch (SQLException e) {
			DataSourceUtil.rollBack();
			e.printStackTrace();
		} finally{
			DataSourceUtil.commit();
			DataSourceUtil.release();
		}
		return true;
	}

	@Override
	public Boolean delBookInfo(String id) {
		BookDao bookDao = new BookDaoImpl();
		try {
			DataSourceUtil.startTransaction();
			bookDao.delBookInfo(id);
			bookDao.delBookPlusInfo(id);
		} catch (SQLException e) {
			DataSourceUtil.rollBack();
			e.printStackTrace();
		} finally{
			DataSourceUtil.commit();
			DataSourceUtil.release();
		}
		return true;
	}

	@Override
	public List<Object> searchByName(String name) {
		BookDao bookDao = new BookDaoImpl();
		try {
			return bookDao.searchByName(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
