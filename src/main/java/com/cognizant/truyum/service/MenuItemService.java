package com.cognizant.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {
	@Autowired
	MenuItemDao menuItemDao;
	
	public List<MenuItem> getMenuListAdmin(){
		try {
			return menuItemDao.getMenuListAdmin();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<MenuItem> getMenuListCustomer() {
		try {
			return menuItemDao.getMenuListCustomer();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public MenuItem getMenuItem(Long menuItemId) {
		try {
			return menuItemDao.getMenuItem(menuItemId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean modifyMenuItem(MenuItem menuItem) {
		try {
			menuItemDao.modifyMenuItem(menuItem);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
