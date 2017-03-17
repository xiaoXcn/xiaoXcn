package com.common.utils;

import java.util.Map;

public class ActionEntity {
	
	private String name;
	private String clazz;
	private String method;
	private Map<String,ResultEntity> resultEntity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public Map<String, ResultEntity> getResultEntity() {
		return resultEntity;
	}
	public void setResultEntity(Map<String, ResultEntity> resultEntity) {
		this.resultEntity = resultEntity;
	}

}
