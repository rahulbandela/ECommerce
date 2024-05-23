package com.tap.userdao;

import java.util.List;

import com.tap.model.Restaurant;

public interface RestaurantDao {
	
	public void addRestaurant(Restaurant restaurant);
	public Restaurant getRestaurant(int id);
	public List<Restaurant> getAll();
	public void updateRestaurant(Restaurant restaurant);
	public void deleteRestaurant(int id);
	
	
	
	
	
	
	

}
