package com.xiaoxcn.init;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;

import com.xiaoxcn.domain.NodeEntity;
import com.xknowledge.domain.BookClassifyEntity;

public class InitSystemParams {
	
	public void InitNodeParams(ServletContext servletContext){
		System.out.println("加载节点数据...");
		InitSystemDao initSystemDao = new InitSystemDao();
		List<NodeEntity> nodeEntityList = null;
		try {
			nodeEntityList = initSystemDao.queryAllNode();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(nodeEntityList!=null&&nodeEntityList.size()>0){
			servletContext.setAttribute("nodeList", nodeEntityList);
		}
		/*List<NodeEntity> nodeList = (List<NodeEntity>) servletContext.getAttribute("nodeList");
		if(nodeList!=null&&nodeList.size()>0){
			for(NodeEntity nodeEntity:nodeList){
				System.out.println(nodeEntity.getId()+"  "+nodeEntity.getNodeId()+" "+nodeEntity.getNodeName());
			}
		}*/
	}
	
	public void InitBookTypeParams(ServletContext servletContext){
		System.out.println("加载书籍类型数据...");
		InitSystemDao initSystemDao = new InitSystemDao();
		List<BookClassifyEntity> bookClassifyEntityList = null;
		try {
			bookClassifyEntityList = initSystemDao.queryBookClassify();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(bookClassifyEntityList!=null&&bookClassifyEntityList.size()>0){
			servletContext.setAttribute("bookClassifyList", bookClassifyEntityList);
		}
		/*List<BookClassifyEntity> bookClassifyList = (List<BookClassifyEntity>) servletContext.getAttribute("bookClassifyList");
		if(bookClassifyList!=null&&bookClassifyList.size()>0){
			for(BookClassifyEntity bookClassifyEntity:bookClassifyList){
				System.out.println(bookClassifyEntity.getId()+"  "+bookClassifyEntity.getClassifyCode()+" "+bookClassifyEntity.getClassifyName());
			}
		}*/
	}
	

}
