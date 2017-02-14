package com.xiaoxcn.menu.service.impl;

import java.util.List;

import com.xiaoxcn.menu.dao.MenuDao;
import com.xiaoxcn.menu.dao.impl.MenuDaoImpl;
import com.xiaoxcn.menu.entity.Menu;
import com.xiaoxcn.menu.service.MenuService;

public class MenuServiceImpl implements MenuService {

	private MenuDao menuDao;
	
	private MenuDao instanceDao(){
		synchronized (this) {
			if(menuDao!=null){
				return menuDao;
			}else{
				return new MenuDaoImpl();
			}
		}
		
	}
	public List<Menu> getMenuList(Menu menu) {
		return instanceDao().getMenuList(menu);
	}

	

	
}
