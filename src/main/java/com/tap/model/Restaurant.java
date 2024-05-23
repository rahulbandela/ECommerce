package com.tap.model;

import java.sql.Time;

public class Restaurant extends User{
	
	private int restaurantId;
	private String name;
	private String imagePath;
	private float ratings;
	private String eta;
	private String cuisineType; 
	private String address;
	private String isActive;
	private int restaurantOwnerId;
	
	
	public Restaurant() {
		super();
	}
	
	
	public Restaurant(int restaurantId,String name, String imagePath, float ratings, String eta, String cuisineType,
			String address, String isActive, int restaurantOwnerId) {
		super();
		this.restaurantId=restaurantId;
		this.name = name;
		this.imagePath = imagePath;
		this.ratings = ratings;
		this.eta = eta;
		this.cuisineType = cuisineType;
		this.address = address;
		this.isActive = isActive;
		this.restaurantOwnerId = restaurantOwnerId;
	}
	
	
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public float getRatings() {
		return ratings;
	}
	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta = eta;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public int getRestaurantOwnerId() {
		return restaurantOwnerId;
	}
	public void setRestaurantOwnerId(int restaurantOwnerId) {
		this.restaurantOwnerId = restaurantOwnerId;
	} 

}
