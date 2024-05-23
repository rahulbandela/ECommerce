package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.tap.model.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

@WebServlet("/cart-servlet")

public class CartServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out=resp.getWriter();
		ArrayList<cart> li = new ArrayList<>();
		
		int id = Integer.parseInt(req.getParameter("id"));
		cart cm=new cart();
		cm.setMenuId(id);
		cm.setQuantity(1);
		
		HttpSession ses=req.getSession();
		ArrayList<cart> li1=(ArrayList<cart>) ses.getAttribute("cart-list");
		
		if(li1 == null)
		{
			li.add(cm);
			ses.setAttribute("cart-list", li);
			resp.sendRedirect("callservlet3");
			
		}
		else
		{
			li=li1;
			boolean exist=false;
			
			
			for(cart c:li1)
			{
				if(c.getMenuId()==id)
				{
					exist=true;
					resp.sendRedirect("cart.jsp");
					
				}
				
			}
			if(!exist)
			{
				li.add(cm);
				resp.sendRedirect("callservlet3");
			}
		}
		
		
	}

}
