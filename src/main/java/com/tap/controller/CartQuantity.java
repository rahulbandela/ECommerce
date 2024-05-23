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
@WebServlet("/callquantity")

public class CartQuantity extends HttpServlet 
{
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action=req.getParameter("action");
		int id = Integer.parseInt(req.getParameter("id"));
		HttpSession ses=req.getSession();
		
		ArrayList<cart> cart_list = (ArrayList<cart>) ses.getAttribute("cart-list");
		
		
		if(cart_list!=null && id>=1)
		{
			if( action.equals("inc") )
			{
				for(cart ca : cart_list)
				{
					if(ca.getMenuId()==id)
					{
						int quan=ca.getQuantity();
						quan++;
						ca.setQuantity(quan);
						resp.sendRedirect("cart.jsp");
					}
				}
			}
			if(action.equals("dec"))
			{
				for(cart ca:cart_list)
				{
					if(ca.getMenuId()==id && ca.getQuantity()>1)
					{
						int quan=ca.getQuantity();
						quan--;
						ca.setQuantity(quan);
						resp.sendRedirect("cart.jsp");
					}
				}
			}
				
		}
		else
		{
			resp.sendRedirect("cart.jsp");
		}
		
		
		
	}

}
