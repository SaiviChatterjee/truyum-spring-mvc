package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	public List<MenuItem> getMenuListAdmin() throws ClassNotFoundException, IOException, SQLException;
	public List<MenuItem> getMenuListCustomer() throws SQLException, ClassNotFoundException, IOException;
	public void modifyMenuItem(MenuItem menuItem) throws ClassNotFoundException, IOException, SQLException;
	public MenuItem getMenuItem(Long menuItemId) throws ClassNotFoundException, IOException, SQLException;
}
