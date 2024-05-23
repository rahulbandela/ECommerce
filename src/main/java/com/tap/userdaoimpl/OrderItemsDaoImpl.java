package com.tap.userdaoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.model.OrderItems;
import com.tap.userdao.OrderItemsDao;

public class OrderItemsDaoImpl implements OrderItemsDao{
	Connection con;
	String url = "jdbc:mysql://localhost:3306/tapfoods";
	String uname ="root";
	String pass ="root";
	String ADD_ORDERITEM  = "INSERT INTO `orderitems`(itemName, rating, quantity, price)VALUES(?,?,?,?)";
	String GET_ORDER_ITEM = "SELECT * FROM `orderitems` WHERE orderItemId=?";
	String GET_ALL_ORDERITEMS = "SELECT * FROM `orderitems`";
	String UPDATE_ORDER_ITEMS = "UPDATE `orderitems` SET itemName=?, rating=?, quantity=?, price=? WHERE orderItemId=?";
	String DELETE_ORDER_ITEM = "DELETE `orderitems` WHERE orderItemId=?";
	

	@Override
	public void addOrderItems(OrderItems orderitems) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pass);
			PreparedStatement ps= con.prepareStatement(ADD_ORDERITEM);
			ps.setString(1, orderitems.getItemName());
			ps.setFloat(2, orderitems.getRating());
			ps.setInt(3, orderitems.getQuantity());
			ps.setInt(4, orderitems.getPrice());
			int i = ps.executeUpdate();
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void getOrderItems(int id) {
		
		try
		{
			
			PreparedStatement ps =con.prepareStatement(GET_ORDER_ITEM);
			ps.setInt(1, id);
			ResultSet res =ps.executeQuery();
			if(res.next())
			{
				int orderItemId = res.getInt("orderItemId");
				int userId = res.getInt("userId");
				int menuId = res.getInt("menuId");
				String itemName=res.getString("itemName");
				float rating = res.getFloat("rating");
				int quantity = res.getInt("quantity");
				int price =res.getInt("price");
				
				OrderItems orderitems=new OrderItems(orderItemId, userId, menuId, itemName, rating, quantity, price);
				
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<OrderItems> getAllOrderItems() {
		
		ArrayList<OrderItems> li5 = new ArrayList<OrderItems>();
		try
		{
			Statement stmt =con.createStatement();
			ResultSet res =stmt.executeQuery(GET_ALL_ORDERITEMS);
			while(res.next())
			{
				int orderItemId = res.getInt("orderItemId");
				int userId = res.getInt("userId");
				int menuId = res.getInt("menuId");
				String itemName=res.getString("itemName");
				float rating = res.getFloat("rating");
				int quantity = res.getInt("quantity");
				int price =res.getInt("price");
				
				OrderItems orderitems=new OrderItems(orderItemId, userId, menuId, itemName, rating, quantity, price);
				li5.add(orderitems);
				
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return li5;
		
	}

	@Override
	public void updateOrderItems(OrderItems orderitems) {
		try
		{
			PreparedStatement ps= con.prepareStatement(ADD_ORDERITEM);
			ps.setString(1, orderitems.getItemName());
			ps.setFloat(2, orderitems.getRating());
			ps.setInt(3, orderitems.getQuantity());
			ps.setInt(4, orderitems.getPrice());
			ps.setInt(5, orderitems.getOrderItemsId());
			int i = ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void deleteOrderItems(int id) {
		
		try
		{
			PreparedStatement ps =con.prepareStatement(DELETE_ORDER_ITEM);
			ps.setInt(1, id);
			int i =ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

}
