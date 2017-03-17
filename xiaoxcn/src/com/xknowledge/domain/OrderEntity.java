package com.xknowledge.domain;

import java.util.Date;
import java.util.List;

public class OrderEntity {

	private String id;
	private String userId;
	private String userName;
	private String userPhoneNumber;
	private String userAddress;
	private Date createTime;
	private String status;
	
	private List<OrderDetailsEntity> odeList;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhoneNumber() {
		return userPhoneNumber;
	}
	public void setUserPhoneNumber(String userPhoneNumber) {
		this.userPhoneNumber = userPhoneNumber;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<OrderDetailsEntity> getOdeList() {
		return odeList;
	}
	public void setOdeList(List<OrderDetailsEntity> odeList) {
		this.odeList = odeList;
	}
	
}
