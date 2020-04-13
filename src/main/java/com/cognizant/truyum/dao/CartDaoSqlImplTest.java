package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;

public class CartDaoSqlImplTest {
	public static void main(String[] args) throws NumberFormatException, ClassNotFoundException, CartEmptyException, IOException, SQLException {
		CartDao cartDao=new CartDaoSqlImpl();
		System.out.println(cartDao.getAllCartItems(Long.valueOf("1")));
	}
}
