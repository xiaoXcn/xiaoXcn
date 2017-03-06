package com.xknowledge.service;

import com.xknowledge.domain.Book;
import com.xknowledge.domain.Pager;

public interface BookService {

	Pager<Book> queryBookPage(Pager<Book> pager);

}
