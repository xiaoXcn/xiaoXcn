package com.xiaoxcn.init;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.common.utils.DataSourceUtil;
import com.xiaoxcn.domain.NodeEntity;
import com.xknowledge.domain.BookClassifyEntity;

public class InitSystemDao {

	public List<NodeEntity> queryAllNode() throws SQLException{
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select id,node_id nodeId,parent_node_id parentNodeId,node_name nodeName,skip_url skipUrl,title,target,status from kno_node";
		List<NodeEntity> nodeEntityList = qr.query(sql, new BeanListHandler<>(NodeEntity.class));
		return nodeEntityList;
	}
	
	public List<BookClassifyEntity> queryBookClassify() throws SQLException{
		QueryRunner qr = new QueryRunner(DataSourceUtil.getDataSource());
		String sql = "select id,classify_code classifyCode,classify_name classifyName from kno_book_classify";
		List<BookClassifyEntity> bookClassifyEntityList = qr.query(sql, new BeanListHandler<>(BookClassifyEntity.class));
		return bookClassifyEntityList;
	}
}
