package com.xknowledge.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.common.utils.DataSourceUtil;
import com.common.utils.StringUtilx;
import com.xknowledge.dao.BookDao;
import com.xknowledge.domain.Book;
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

}
