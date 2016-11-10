package com.xiaox.domain;

import java.util.Date;

public class User {
	
	private String id;  //主键
	private String account;  //账号
	private String name;  //姓名
	private String password;  //密码
	private String gender;  //性别
	private String phone;  //手机号码
	private Date joniTime;  //录入时间
	private String grade;  //级别
	private String superior;  //上级
	private String status;  //状态
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getJoniTime() {
		return joniTime;
	}
	public void setJoniTime(Date joniTime) {
		this.joniTime = joniTime;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSuperior() {
		return superior;
	}
	public void setSuperior(String superior) {
		this.superior = superior;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
}
