package com.common.utils;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class StrutsConfigUtilx {

	public static Map<String,ActionEntity> resolveStrutsConfig(){
		Map<String,ActionEntity> map = new HashMap<String,ActionEntity>();
		InputStream is = StrutsConfigUtilx.class.getResourceAsStream("/struts2-mini.xml");
		SAXReader sr = new SAXReader();
		try {
			Document document = sr.read(is);
			List<Element> elements = document.selectNodes("//action");
			if(elements!=null && elements.size()>0){
				for(Element element:elements){
					ActionEntity actionEntity = new ActionEntity();
					actionEntity.setName(element.attributeValue("name"));
					actionEntity.setClazz(element.attributeValue("class"));
					actionEntity.setMethod(element.attributeValue("method"));
					List<Element> resultEles = element.elements("result");
					Map<String,ResultEntity> resultMap = new HashMap<String,ResultEntity>();
					if(resultEles!=null&&resultEles.size()>0){
						for(Element resultEle:resultEles){
							ResultEntity resultEntity = new ResultEntity();
							resultEntity.setResultName(resultEle.attributeValue("name"));
							resultEntity.setResultContext(resultEle.getText());
							resultMap.put(resultEntity.getResultName(), resultEntity);
						}
					}
					map.put(actionEntity.getName(), actionEntity);
				}
			}
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("加载struts2-mini.xml配置错误...");
		}
		return map;
	}
}
