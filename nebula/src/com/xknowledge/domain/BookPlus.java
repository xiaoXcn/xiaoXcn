package com.xknowledge.domain;

public class BookPlus {

	private String id;  //主键
	private String bookId;  //书籍ID
	private String urlBaike;  //百科url
	private String urlDouban;  //豆瓣url
	private String urlYunpan;  //云盘url
	private String downloadPwd;  //下载密码
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getUrlBaike() {
		return urlBaike;
	}
	public void setUrlBaike(String urlBaike) {
		this.urlBaike = urlBaike;
	}
	public String getUrlDouban() {
		return urlDouban;
	}
	public void setUrlDouban(String urlDouban) {
		this.urlDouban = urlDouban;
	}
	public String getUrlYunpan() {
		return urlYunpan;
	}
	public void setUrlYunpan(String urlYunpan) {
		this.urlYunpan = urlYunpan;
	}
	public String getDownloadPwd() {
		return downloadPwd;
	}
	public void setDownloadPwd(String downloadPwd) {
		this.downloadPwd = downloadPwd;
	}
	
	
}
