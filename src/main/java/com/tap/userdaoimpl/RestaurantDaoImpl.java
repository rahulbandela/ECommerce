package com.tap.userdaoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.tap.model.Menu;
import com.tap.model.Restaurant;
import com.tap.model.User;
import com.tap.userdao.RestaurantDao;

public class RestaurantDaoImpl implements RestaurantDao{
	
	
	
	

	
	Connection con;
	String url = "jdbc:mysql://localhost:3306/tapfoods";
	String uname ="root";
	String pass ="root";
	String ADD_RESTAURANT = "INSERT INTO `restaurant`(name, imagePath, ratings, eta, cuisineType, address, isActive,restaurantOwnerId)VALUES(?,?,?,?,?,?,?,?)";
	String GET_RESTAURANT = "SELECT * FROM `restaurant` WHERE restaurantId=?";
	String GET_ALL = "SELECT * FROM `restaurant`";
	String UPDATE_RESTAURANT = "UPDATE `restaurant` SET name=?, imagePath=?, ratings=?, eta=?, cuisineType=?, address=?, isActive=? WHERE restaurantId=? ";
	String DELETE_RESTAURANT = "DELETE `restaurant` WHERE restaurantId=?";	
	String GET_LASTID = "SELECT * FROM `restaurant` ORDER BY restaurantId DESC LIMIT 1";
	
	
	
	
	public RestaurantDaoImpl()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pass);
		
		}
		catch(SQLException |ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void addRestaurant(Restaurant restaurant) {
		
		
		
		try
		{
			PreparedStatement ps=con.prepareStatement(ADD_RESTAURANT);
			ps.setString(1, restaurant.getName());
			ps.setString(2, restaurant.getImagePath());
			ps.setFloat(3, restaurant.getRatings());
			ps.setString(4, restaurant.getEta());
			ps.setString(5, restaurant.getCuisineType());
			ps.setString(6, restaurant.getAddress());
			ps.setString(7, restaurant.getIsActive());
			ps.setInt(8, restaurant.getRestaurantOwnerId());
			int i =ps.executeUpdate();
			
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public Restaurant getRestaurant(int id) {
		
		Restaurant restaurant=null;
		try
		{
			PreparedStatement ps=con.prepareStatement(GET_RESTAURANT);
			ps.setInt(1, id);
			ResultSet res=ps.executeQuery();
			if(res.next())
			{
				int restaurantId  =res.getInt("restaurantId");
				String name = res.getString("name");
				String imagePath = res.getString("imagePath");
				float ratings = res.getFloat("ratings");
				String eta = res.getString("eta");
				String cuisineType = res.getString("cuisineType");
				String address = res.getString("address");
				String isActive = res.getString("isActive");
				int restaurantOwnerId = res.getInt("restaurantOwnerId");
				
			
				 restaurant =new Restaurant(restaurantId,name, imagePath, ratings, eta, cuisineType, address, isActive, restaurantOwnerId);
				
			}
			
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
			return restaurant;
		
		
	}

	@Override
	public List<Restaurant> getAll() {
		
		
		ArrayList<Restaurant> li2 = new ArrayList<Restaurant>();
		
		try
		{
			
			Statement stmt =con.createStatement();
			ResultSet res =stmt.executeQuery(GET_ALL);
			while(res.next())
				{
				int id = res.getInt("restaurantId");
				String name = res.getString("name");
				String imagePath = res.getString("imagePath");
				float ratings = res.getFloat("ratings");
				String eta = res.getString("eta");
				String cuisineType = res.getString("cuisineType");
				String address = res.getString("address");
				String isActive = res.getString("isActive");
				int restaurantOwnerId = res.getInt("restaurantOwnerId");
				
			
				Restaurant restaurant =new Restaurant(id,name, imagePath, ratings, eta, cuisineType, address, isActive, restaurantOwnerId);
				li2.add(restaurant);
			
				}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return li2;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
			
		try {
			PreparedStatement ps =con.prepareStatement(UPDATE_RESTAURANT);
			ps.setString(1, restaurant.getName());
			ps.setString(2, restaurant.getImagePath());
			ps.setFloat(3, restaurant.getRatings());
			ps.setString(4, restaurant.getEta());
			ps.setString(5, restaurant.getCuisineType());
			ps.setString(6, restaurant.getAddress());
			ps.setString(7, restaurant.getIsActive());
			ps.setInt(8, restaurant.getRestaurantId());
			int i =ps.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteRestaurant(int id) {

		
		try
		{
			Statement stmt=con.createStatement();
			int i =stmt.executeUpdate(DELETE_RESTAURANT);
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public int lastId()
	{
		
		int i=0;
		try
		{
			
			Statement stmt =con.createStatement();
			ResultSet res  =stmt.executeQuery(GET_LASTID);
			if(res.next())
			{
				 i =Integer.parseInt(res.getString("restaurantId"));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return i;
	}
	
	
	public List<Restaurant> getByRestaurantOwnerId(ArrayList<Menu> list)
	{
		ArrayList<Restaurant> li = new ArrayList<Restaurant>();
		
		
		try
		{
			
			PreparedStatement ps =con.prepareStatement(GET_RESTAURANT);
			
			if(list != null)
			{
				for(Menu m : list)
				{
					int id =m.getRestaurantIdFromMenu();
					ps.setInt(1, id);
					ResultSet res =ps.executeQuery();
					while(res.next())
					{
					String name =res.getString("name");
						Float ratings =res.getFloat("ratings");
						String address =res.getString("address");
						
						Restaurant r=new Restaurant();
						r.setName(name);
						r.setRatings(ratings);
						r.setAddress(address);
						
						li.add(r);
					}
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return li;
	}
	

}


