package com.tap.userdaoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.tap.model.Order;
import com.tap.userdao.OrderDao;

public class OrderDaoImpl implements OrderDao{
	Connection con;
	String url = "jdbc:mysql://localhost:3306/tapfoods";
	String uname ="root";
	String pass ="root";
	String ADD_ORDER = "INSERT INTO `order`(amount, modeOfPayment, status)VALUES(?,?,?)";
	String GET_ORDER = "SELECT * FROM `order` WHERE orderId=?";
	String GET_ALL = "SELECT * FROM `order`";
	String UPDATE_ORDER = "UPDATE `order` SET amount=?, modeOfPayment=?, status=? WHERE orderId=? ";
	String DELETE_ORDER = "DELETE `order` WHERE orderId=?";
	

	@Override
	public void addOrder(Order order) {
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection(url,uname,pass);
			PreparedStatement ps =con.prepareStatement(ADD_ORDER);
			ps.setInt(1, order.getAmount());
			ps.setString(2, order.getModeOfPayment());
			ps.setString(3, order.getStatus());
			int i =ps.executeUpdate();
			
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
	public void getOrder(int orderId) {
		
		try
		{
			PreparedStatement ps =con.prepareStatement(GET_ORDER);
			ps.setInt(1, orderId);
			ResultSet res =ps.executeQuery();
			if(res.next())
			{
				int orderId1 = res.getInt("orderId");
				int restaurantId = res.getInt("restaurantId");
				int userId = res.getInt("userId");
				int amount = res.getInt("amount");
				String modeOfPayment = res.getString("modeOfPayment");
				String status = res.getString("status");
				
				Order order =new Order(orderId1, restaurantId, userId, amount, modeOfPayment, status);
				
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<Order> getAllOrders() {
		
		ArrayList<Order> li4 = new ArrayList<Order>();
		try
		{
			Statement stmt =con.createStatement();
			
			ResultSet res =stmt.executeQuery(GET_ALL);
			while(res.next())
			{
				int orderId1 = res.getInt("orderId");
				int restaurantId = res.getInt("restaurantId");
				int userId = res.getInt("userId");
				int amount = res.getInt("amount");
				String modeOfPayment = res.getString("modeOfPayment");
				String status = res.getString("status");
				
				Order order =new Order(orderId1, restaurantId, userId, amount, modeOfPayment, status);
				li4.add(order);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return li4;
	}

	@Override
	public void updateOrders(Order order) {
		
		try
		{
			PreparedStatement ps =con.prepareStatement(UPDATE_ORDER);
			ps.setInt(1, order.getAmount());
			ps.setString(2, order.getModeOfPayment());
			ps.setString(3, order.getStatus());
			ps.setInt(4, order.getOrderId());
			int i =ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void deleteOrder(int orderId) {

		try
		{
			PreparedStatement ps =con.prepareStatement(DELETE_ORDER);
			ps.setInt(1, orderId);
			int i =ps.executeUpdate();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
