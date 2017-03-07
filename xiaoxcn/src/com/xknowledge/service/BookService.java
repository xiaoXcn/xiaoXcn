package com.xknowledge.service;

import com.xknowledge.domain.Book;
import com.xknowledge.domain.Pager;

public interface BookService {

	Pager<Book> queryBookPage(Pager<Book> pager);

	Book queryBookSingle(String id);

	Boolean addBookInfo(Book book);

	Boolean editBookInfo(Book book);

	Boolean delBookInfo(String id);

}
