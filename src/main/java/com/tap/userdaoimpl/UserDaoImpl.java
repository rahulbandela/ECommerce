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
import com.tap.model.User;
import com.tap.userdao.UserDao;

public class UserDaoImpl implements UserDao
{
	
	Connection con;
	String url="jdbc:mysql://localhost:3306/tapfoods";
	String uname="root";
	String pass="root";
	String ADD_USER = "INSERT INTO `user`(name, email, phoneNo, address, userName, password)VALUES(?,?,?,?,?,?)";
	String GET_USER = "SELECT * FROM `user` WHERE userId=?";
	String GET_ALL = "SELECT * FROM `user`";
	String UPDATE_USER = "UPDATE `user` SET name=?, email=?, phoneNo=?, address=?, userName=?, password=? WHERE userId=?";
	String DELETE_USER = "DELETE FROM `user` WHERE userId=?";
	String GET_UNAME = "SELECT `password` FROM `user` WHERE userName=?";
	
	 public UserDaoImpl()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con= DriverManager.getConnection(url,uname,pass);
			
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
	public void addUser(User user) {
		
		try {
			
			PreparedStatement ps=con.prepareStatement(ADD_USER);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setLong(3, user.getPhoneNo());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getUserName());
			ps.setString(6, user.getPassword());
			
			int i = ps.executeUpdate();
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		

		
		
		
	}

	@Override
	public User getUser(int userid) {
		User user=null;
		try {
			
			PreparedStatement ps= con.prepareStatement(GET_USER);
			ps.setInt(1, userid);
			ResultSet res =ps.executeQuery();
			if(res.next())
			{
				String name = res.getString("name");
				String email = res.getString("email");
				Long PhoneNo = res.getLong("pnoneNo");
				String address = res.getString("address");
				String userName = res.getString("userName");
				String password = res.getString("password");
				String role = res.getString("role");
				
				
				 user=new User(name, email, PhoneNo, address, userName, password, role);
				
			}
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return user;
		
	}

	@Override
	public List<User> getAll() {
		
		ArrayList<User> li1= new ArrayList<User>();
		
		try
		{
			Statement stmt=con.createStatement();
			ResultSet res=stmt.executeQuery(GET_ALL);
			
			while(res.next());
			{
				String name = res.getString("name");
				String email = res.getString("email");
				Long PhoneNo = res.getLong("pnoneNo");
				String address = res.getString("address");
				String userName = res.getString("userName");
				String password = res.getString("password");
				String role = res.getString("role");
				
				
				User user=new User(name, email, PhoneNo, address, userName, password, role);
				li1.add(user);
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return li1;

		
	}

	@Override
	public void updateUser(User user) {

		try
		{
			PreparedStatement ps =con.prepareStatement(UPDATE_USER);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setLong(3, user.getPhoneNo());
			ps.setString(4, user.getAddress());
			ps.setString(5, user.getUserName());
			ps.setString(6, user.getPassword());
			ps.setInt(7, user.getUserId());
			
			int i =ps.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(int id) {
		
		try
		{
			PreparedStatement ps =con.prepareStatement(DELETE_USER);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public String getPassword(String s)
	{
		String t="";
		try
		{
			PreparedStatement ps=con.prepareStatement(GET_UNAME);
			ps.setString(1, s);
			ResultSet res=ps.executeQuery();
			if(res.next())
			{
				 t=res.getString("password");
			}
			
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return t;
	}
	
	
	
	
	
	
}



