package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;

@Repository
@Qualifier("menuItemDao")
public class MenuItemDaoSqlImpl implements MenuItemDao {

	private Connection conn;
	
	@Autowired	
	public void setConnection(ConnectionHandler connectionHandler) {
		try {
			this.conn=connectionHandler.getConnection();
		} catch (Exception e) {
			this.conn=null;
		}
	}
	
	public List<MenuItem> getMenuListAdmin() throws ClassNotFoundException, IOException, SQLException {
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM menuItems");
		ResultSet resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			MenuItem menuItem = new MenuItem(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getFloat("price"),
					resultSet.getBoolean("active"), resultSet.getDate("dateOfLaunch"), resultSet.getString("category"),
					resultSet.getBoolean("freeDelivery"));
			menuItemList.add(menuItem);
		}
		return menuItemList;
	}

	public List<MenuItem> getMenuListCustomer() throws SQLException, ClassNotFoundException, IOException {
		List<MenuItem> menuItemList = new ArrayList<MenuItem>();
		PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM menuItems where active=? AND dateOfLaunch<?");
		preparedStatement.setBoolean(1, true);
		preparedStatement.setDate(2, new java.sql.Date(new Date().getTime()));
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			MenuItem menuItem = new MenuItem(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getFloat("price"),
					resultSet.getBoolean("active"), resultSet.getDate("dateOfLaunch"), resultSet.getString("category"),
					resultSet.getBoolean("freeDelivery"));
			menuItemList.add(menuItem);
		}

		return menuItemList;
	}

	public void modifyMenuItem(MenuItem menuItem) throws ClassNotFoundException, IOException, SQLException {
		PreparedStatement preparedStatement = conn.prepareStatement(
				"UPDATE menuItems SET name=?, price=?, active=?, dateOfLaunch=?, category=?, freeDelivery=? WHERE id=?");
		preparedStatement.setString(1, menuItem.getName());
		preparedStatement.setFloat(2, menuItem.getPrice());
		preparedStatement.setBoolean(3, menuItem.getActive());
		preparedStatement.setDate(4, new java.sql.Date(menuItem.getDateOfLaunch().getTime()));
		preparedStatement.setString(5, menuItem.getCategory());
		preparedStatement.setBoolean(6, menuItem.getFreeDelivery());
		preparedStatement.setLong(7, menuItem.getId());
		preparedStatement.executeUpdate();

	}

	public MenuItem getMenuItem(Long menuItemId) throws ClassNotFoundException, IOException, SQLException {
		PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM menuItems WHERE id=?");
		preparedStatement.setLong(1, menuItemId);
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			return new MenuItem(result.getLong("id"), result.getString("name"), result.getFloat("price"),
					result.getBoolean("active"), result.getDate("dateOfLaunch"), result.getString("category"),
					result.getBoolean("freeDelivery"));
		}
		return null;
	}

}
