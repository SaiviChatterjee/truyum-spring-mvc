package com.cognizant.truyum.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<MenuItem> menuItemList;
	Double total;

	public Cart() {
		super();
		menuItemList=new ArrayList<MenuItem>();
	}

	public Cart(List<MenuItem> menuItemList, Double total) {
		super();
		this.menuItemList = menuItemList;
		this.total = total;
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}

	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
}
