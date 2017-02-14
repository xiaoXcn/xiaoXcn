package com.xiaoxcn.menu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaoxcn.menu.entity.Menu;
import com.xiaoxcn.menu.service.MenuService;
import com.xiaoxcn.menu.service.impl.MenuServiceImpl;

public class MenuController {
	
	private MenuService menuService;
	
	private MenuService instanceService(){
		synchronized (this) {
			if(menuService!=null){
				return menuService;
			}else{
				return new MenuServiceImpl();
			}
		}
		
	}
	
	/**
	 * 查询指定类型的菜单列表
	 * @param request
	 * @param response
	 * @return
	 */
	public List<Menu> getMenuList(HttpServletRequest request,HttpServletResponse response){
		String type = request.getParameter("type");
		Menu menu = new Menu();
		menu.setType(type);
		return this.instanceService().getMenuList(menu);
	}
	
	public boolean addMenu(HttpServletRequest request,HttpServletResponse response){
		Menu menu = new Menu();
		//menu.setId(id);
		menu.setMenuName(request.getParameter("menuName"));
		menu.setMenuCode(request.getParameter("menuCode"));
		menu.setSort(Integer.parseInt(request.getParameter("sort")));
		menu.setType(request.getParameter("type"));
		//menu.setCreateTime(new Date());
		return true;
	}

}
