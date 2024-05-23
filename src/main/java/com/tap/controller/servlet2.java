package com.tap.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.Restaurant;
import com.tap.model.User;
import com.tap.userdaoimpl.RestaurantDaoImpl;

@WebServlet("/callservlet2")

public class servlet2 extends  HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<Restaurant> li = new ArrayList<Restaurant>();
		
		String imagepath = null;
		float ratings = 4.5f;
		int id = Integer.parseInt(req.getParameter("id"));
		String name =req.getParameter("name");
		String eta =req.getParameter("eta");
		String cuisinetype =req.getParameter("cuisinetype");
		String address =req.getParameter("address");
		String isactive =req.getParameter("isactive");
		int restaurantownerid =Integer.parseInt(req.getParameter("restaurantownerid"));
		Restaurant rest=new Restaurant(id,name, imagepath, ratings, eta, cuisinetype, address, isactive, restaurantownerid);
		RestaurantDaoImpl rdi=new RestaurantDaoImpl();
		rdi.addRestaurant(rest);
		
		HttpSession ses =req.getSession();
		li.add(rest);
		
		ses.setAttribute("restaurant", li);
		
		
		
		
		
		RequestDispatcher rd=req.getRequestDispatcher("homepage.jsp");
		rd.include(req, resp);
		
	}

}
