package com.xknowledge.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.common.utils.DataSourceUtil;
import com.common.utils.IDUtilx;
import com.common.utils.StringUtilx;
import com.xknowledge.dao.BookDao;
import com.xknowledge.domain.Book;
import com.xknowledge.domain.BookPlus;
import com.xknowledge.domain.Pager;

public class BookDaoImpl implements BookDao {

	@Override
	public Pager<Book> queryBookPage(Pager<Book> pager) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select * from c_book where 1=1 ";
		List<String> param = new ArrayList<String>();
		Book paramBook = pager.getList().get(0);
		if(!StringUtilx.isBlank(paramBook.getAuthor())){
			sql += " and author like ? ";
			param.add("%"+paramBook.getAuthor()+"%");
		}
		if(!StringUtilx.isBlank(paramBook.getName())){
			sql += " and name like ? or en_name like ?";
			param.add("%"+paramBook.getName()+"%");
			param.add("%"+paramBook.getName()+"%");
		}
		if(!StringUtilx.isBlank(paramBook.getType())){
			sql += " and type = ? ";
			param.add(paramBook.getType());
		}
		if(!StringUtilx.isBlank(pager.getStartTime())){
			sql += " and publish_date > ? ";
			param.add(pager.getStartTime());
		}
		if(!StringUtilx.isBlank(pager.getEndTime())){
			sql += " and publish_date < ? ";
			param.add(pager.getEndTime());
		}
		sql += "limit "+pager.getCurrentPage()*pager.getPageSize()+","+pager.getPageSize();
		List<Book> reList = qr.query(sql, new BeanListHandler<Book>(Book.class), param.toArray());
		pager.setList(reList);
		return pager;
	}

	@Override
	public Book queryBookSingle(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		Book book = new Book();
		book = qr.query("select * from c_book where id = ? ", new BeanHandler<>(Book.class), id);
		BookPlus bookPlus = qr.query("select * from c_book_plus where book_id = ? ", new BeanHandler<>(BookPlus.class), id);
		book.setBookPlus(bookPlus);
		return book;
	}

	@Override
	public Boolean addBookInfo(Book book) throws SQLException {
		QueryRunner qr = new QueryRunner();
		Object[] paramBook = new Object[]{book.getId(),book.getName(),book.getAuthor(),book.getEnName(),book.getPublishDate(),book.getType()};
		qr.update(DataSourceUtil.getConnection(),"insert into c_book (id,name,author,en_name,publish_date,type) values (?,?,?,?,?,?)",paramBook);
		return true;
	}
	
	@Override
	public Boolean addBookPlusInfo(Book book) throws SQLException {
		QueryRunner qr = new QueryRunner();
		BookPlus bookPlus = book.getBookPlus();
		Object[] paramBookPlus =
				new Object[]{IDUtilx.getUUID(),book.getId(),bookPlus.getUrlBaike(),bookPlus.getUrlDouban(),bookPlus.getUrlYunpan(),bookPlus.getDownloadPwd()};
		qr.update(DataSourceUtil.getConnection(),"insert into c_book_plus (id,book_id,url_baike,url_douban,url_yunpan,download_pwd) values (?,?,?,?,?,?)",paramBookPlus);
		return true;
	}

	@Override
	public Boolean editBookInfo(Book book) throws SQLException {
		QueryRunner qr = new QueryRunner();
		Object[] paramBook = new Object[]{book.getName(),book.getAuthor(),book.getEnName(),book.getPublishDate(),book.getType(),book.getId()};
		qr.update(DataSourceUtil.getConnection(),"update c_book set name = ?,author=?,en_name=?,publish_date=?,type=? where id = ? ",paramBook);
		return true;
	}
	
	@Override
	public Boolean editBookPlusInfo(Book book) throws SQLException {
		QueryRunner qr = new QueryRunner();
		BookPlus bookPlus = book.getBookPlus();
		Object[] paramBookPlus =
				new Object[]{bookPlus.getUrlBaike(),bookPlus.getUrlDouban(),bookPlus.getUrlYunpan(),bookPlus.getDownloadPwd(),bookPlus.getId()};
		qr.update(DataSourceUtil.getConnection(),"update c_book_plus set url_baike=?,url_douban=?,url_yunpan=?,download_pwd=? where  id=? ",paramBookPlus);
		return true;
	}

	@Override
	public Boolean delBookInfo(String id) throws SQLException {
		QueryRunner qr = new QueryRunner();
		qr.update(DataSourceUtil.getConnection(),"delete from c_book where id=? ", id);
		return true;
	}
	
	@Override
	public Boolean delBookPlusInfo(String id) throws SQLException {
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		qr.update(DataSourceUtil.getConnection(),"delete from c_book_plus where book_id=? ", id);
		return true;
	}

}