package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;

public class MenuItemDaoSqlImplTest {
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		MenuItemDao menuItemDao=new MenuItemDaoSqlImpl();
		System.out.println(menuItemDao.getMenuListAdmin());
	}
}
