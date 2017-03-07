package com.xknowledge.domain;

public class Book {
	
	private String id;  //主键
	private String name;  //书名
	private String author;  //作者
	private String enName;  //书英文名
	private String publishDate;  //出版日期
	private String type;  //图书类型
	
	private BookPlus bookPlus;  //书籍额外信息

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BookPlus getBookPlus() {
		return bookPlus;
	}

	public void setBookPlus(BookPlus bookPlus) {
		this.bookPlus = bookPlus;
	}

	
}
