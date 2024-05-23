package com.tap.userdaoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.model.Menu;
import com.tap.model.cart;
import com.tap.userdao.MenuDao;

public class MenuDaoImpl implements MenuDao{

	Connection con;
	String url = "jdbc:mysql://localhost:3306/tapfoods";
	String uname = "root";
	String pass = "root";
	String ADD_USER = "INSERT INTO `menu`(name, price, description, imagepath, isAvailable,ratings)VALUES(?,?,?,?,?,?)";
	String GET_USER = "SELECT * FROM `menu` WHERE menuId=?";
	String GET_ALL = "SELECT * FROM `menu`";
	String UPDATE_USER = "UPDATE `menu` SET name=?, price=?, description=?, imagepath=?, isAvailable=?,ratings=? WHERE menuId=? ";
	String DELETE_USER = "DELETE `menu` WHERE menuId=?";
	String GET_BY_OWNER_ID = "SELECT * FROM `menu` WHERE restaurantId=?";
	
	public MenuDaoImpl()
	{
		
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection(url, uname , pass);
			
		}
		catch(ClassNotFoundException |SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void addMenu(Menu menu) {

		
		try
		{
			PreparedStatement ps=con.prepareStatement(ADD_USER);
			ps.setString(1, menu.getName());
			ps.setInt(2, menu.getPrice());
			ps.setString(3, menu.getDescription());
			ps.setString(4, menu.getImagepath());
			ps.setString(5, menu.getIsAvailable());
			ps.setFloat(6, menu.getRatings());
			
			int i =ps.executeUpdate();
			
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public Menu getMenu(int id) {
		
		Menu menu=null;
		try
		{
			PreparedStatement ps =con.prepareStatement(GET_USER);
			ps.setInt(1, id);
			ResultSet res =ps.executeQuery();
			if(res.next())
			{
				int menuId = res.getInt("menuId");
				String name = res.getString("name");
				int price = res.getInt("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				String isAvailable = res.getString("isAvailable");
				int restaurantId = res.getInt("restaurantId");
				float ratings = res.getFloat("ratings");
				
				 menu=new Menu(menuId, name, price, description, imagePath, isAvailable, restaurantId, ratings);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public List<Menu> getAll() {
		
		ArrayList<Menu> li3 = new ArrayList<Menu>();
		try
		{
			Statement stmt =con.createStatement();
			ResultSet res =stmt.executeQuery(GET_ALL);
			while(res.next())
			{
				int menuId = res.getInt("menuId");
				String name = res.getString("name");
				int price = res.getInt("price");
				String description = res.getString("description");
				String imagePath = res.getString("imagePath");
				String isAvailable = res.getString("isAvailable");
				int restaurantId = res.getInt("restaurantId");
				float ratings = res.getFloat("ratings");
				
				Menu menu =new Menu(menuId, name, price, description, imagePath, isAvailable, restaurantId, ratings);
				li3.add(menu);
			
			}
			
		}
		catch(SQLException e )
		{
			e.printStackTrace();
		}
		
		return li3;
	}

	@Override
	public void updateMenu(Menu menu) {
		
		try
		{
			
			PreparedStatement ps =con.prepareStatement(UPDATE_USER);
			ps.setString(1, menu.getName());
			ps.setInt(2, menu.getPrice());
			ps.setString(3, menu.getDescription());
			ps.setString(4, menu.getImagepath());
			ps.setString(5, menu.getIsAvailable());
			ps.setFloat(6, menu.getRatings());
			ps.setInt(8, menu.getMenuId());
			
			int i =ps.executeUpdate();
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void removeMenu(int id) {

		try
		{
			PreparedStatement ps=con.prepareStatement(DELETE_USER);
			int i = ps.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public List<cart> getCartItems(ArrayList<cart> list)
	{
		ArrayList<cart> li = new ArrayList<cart>();
		
		if(list.size()>0)
		{
			for(cart c:list)
			{
				try
				{
					PreparedStatement ps =con.prepareStatement(GET_USER);
					ps.setInt(1, c.getMenuId());
					ResultSet res =ps.executeQuery();
					while(res.next())
					{
						int id = res.getInt("menuId");
						String name = res.getString("name");
						int price = res.getInt("price");
						String imagePath = res.getString("imagepath");
						int quantity = c.getQuantity();
						cart ca=new cart();
						
						ca.setMenuId(id);
						ca.setName(name);
						ca.setQuantity(quantity);
						ca.setPrice(price*(c.getQuantity())   );
						ca.setImagepath(imagePath);
						li.add(ca);
					}
					
					
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return li;
	}
	
	public List<Menu> getbyId(ArrayList<Menu> list)
	{
		
		ArrayList<Menu> li = new ArrayList<Menu>();
		
		
		
		
		if(list!=null)
		{
			
			for(Menu l : list)
			{
				try
				{
					PreparedStatement ps =con.prepareStatement(GET_BY_OWNER_ID);
					ps.setInt(1, l.getRestaurantIdFromMenu());
					ResultSet res =ps.executeQuery();
					while(res.next())
					{
						int id=res.getInt("menuId");
						String name=	res.getString("name");
						int price=res.getInt("price");
						String desc=res.getString("description");
						String image = res.getString("imagepath");
						float rating=	res.getFloat("ratings");
						Menu me=new Menu();
						
						
						me.setMenuId(id);
						me.setName(name);
						me.setPrice(price);
						me.setDescription(desc);
						me.setImagepath(image);
						me.setRatings(rating);
						me.setRestaurantOwnerId(l.getRestaurantOwnerId());
						
						li.add(me);
						
					}
					
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
			
		}
		
		return li;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
