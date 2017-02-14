package com.xiaoxcn.menu.entity;

import java.io.Serializable;
import java.util.Date;

public class Menu implements Serializable{

	private static final long serialVersionUID = 8163405778914075660L;
	
	private String id;  //主键
	private String menuName;  //菜单名称
	private String menuCode;  //菜单编码
	private Integer sort;  //排序
	private String type;  //菜单类型
	private Date createTime;  //创建时间
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuCode() {
		return menuCode;
	}
	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

}
