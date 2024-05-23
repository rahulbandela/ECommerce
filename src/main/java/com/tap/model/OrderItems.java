package com.tap.model;

public class OrderItems {
	private int orderItemsId;
	private int userId;
	private int menuId;
	private String itemName;
	private float rating;
	private int quantity;
	private int price;
	
	public OrderItems() {
		super();
	}
	
	
	public OrderItems(int orderItemsId, int userId, int menuId, String itemName, float rating, int quantity, int price) {
		super();
		this.orderItemsId = orderItemsId;
		this.userId = userId;
		this.menuId = menuId;
		this.itemName = itemName;
		this.rating = rating;
		this.quantity = quantity;
		this.price = price;
	}
	
	
	public int getOrderItemsId() {
		return orderItemsId;
	}
	public void setOrderItemsId(int orderItemsId) {
		this.orderItemsId = orderItemsId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMenuId() {
		return menuId;
	}
	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
