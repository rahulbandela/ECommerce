package com.tap.model;

public class Menu extends Restaurant{
	
	private int menuId;
	private String name;
	private int price;
	private String description;
	private String imagepath;
	private String isAvailable;
	private int restaurantId;
	private float ratings;
	
	
	public Menu() {
		super();
	}
	
	
	public Menu(int menuId, String name, int price, String description, String imagepath, String isAvailable,
			int restaurantId, float ratings) {
		super();
		this.menuId = menuId;
		this.name = name;
		this.price = price;
		this.description = description;
		this.imagepath = imagepath;
		this.isAvailable = isAvailable;
		this.restaurantId = restaurantId;
		this.ratings = ratings;
	}


	public int getMenuId() {
		return menuId;
	}


	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImagepath() {
		return imagepath;
	}


	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}


	public String getIsAvailable() {
		return isAvailable;
	}


	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}


	public int getRestaurantIdFromMenu() {
		return restaurantId;
	}


	public void setRestaurantIdFromMenu(int restaurantId) {
		this.restaurantId = restaurantId;
	}


	public float getRatings() {
		return ratings;
	}


	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	
	
}
