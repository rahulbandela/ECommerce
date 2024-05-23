package com.tap.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.cart;
@WebServlet("/call-paymentPage")

public class PaymentServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<cart> li = new ArrayList<cart>();
		int price =Integer.parseInt(req.getParameter("price"));
		
		
		HttpSession ses =req.getSession();
		cart ca =new cart();
		
		ArrayList<cart> cart_list=(ArrayList<cart>)ses.getAttribute("cart-list");
		
		if(cart_list != null)
		{
			for(cart c : cart_list)
			{
				c.setPrice(price);
				
			}
			resp.sendRedirect("paymentPage.jsp");
		}
		
		else
		{
			
			ca.setPrice(price);
			li.add(ca);
			ses.setAttribute("cart-list", li);
			resp.sendRedirect("paymentPage.jsp");
			
			
		}
		
	}

}
