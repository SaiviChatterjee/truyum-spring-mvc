package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cognizant.truyum.model.MenuItem;

@Repository
@Qualifier("cartDao")
public class CartDaoSqlImpl implements CartDao {

	private Connection conn;
	
	@Autowired	
	public void setConnection(ConnectionHandler connectionHandler) {
		try {
			this.conn=connectionHandler.getConnection();
		} catch (Exception e) {
			this.conn=null;
		}
	}

	public void addCartItem(Long userId, Long menuItemId) throws ClassNotFoundException, IOException, SQLException {
		PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO carts VALUES(?, ?)");
		preparedStatement.setLong(1, userId);
		preparedStatement.setLong(2, menuItemId);
		preparedStatement.executeUpdate();
	}

	public List<MenuItem> getAllCartItems(Long userId)
			throws CartEmptyException, ClassNotFoundException, IOException, SQLException {
		List<MenuItem> menuItemList=new ArrayList<MenuItem>();
		PreparedStatement preparedStatement=conn
				.prepareStatement("SELECT * FROM menuItems INNER JOIN carts ON menuItems.id=carts.menuID WHERE userId = ?");
		preparedStatement.setLong(1, userId);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			MenuItem menuItem = new MenuItem(resultSet.getLong("id"), resultSet.getString("name"), resultSet.getFloat("price"),
					resultSet.getBoolean("active"), resultSet.getDate("dateOfLaunch"), resultSet.getString("category"),
					resultSet.getBoolean("freeDelivery"));
			menuItemList.add(menuItem);
		}
		if(menuItemList.size()==0) {
			throw new CartEmptyException("Your cart is empty");
		}
		return menuItemList;
	}

	public void removeCartItem(Long userId, Long menuItemId) throws ClassNotFoundException, IOException, SQLException {
		PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM carts WHERE userID=? AND menuId=?");
		preparedStatement.setLong(1, userId);
		preparedStatement.setLong(2, menuItemId);
		preparedStatement.executeUpdate();
		
	}

}
