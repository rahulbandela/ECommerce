package com.tap.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tap.model.Menu;
import com.tap.model.Restaurant;
import com.tap.model.User;
import com.tap.userdaoimpl.MenuDaoImpl;
import com.tap.userdaoimpl.RestaurantDaoImpl;
import com.tap.userdaoimpl.UserDaoImpl;

@WebServlet("/callservlet3")

public class servlet3 extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<Menu> list = new ArrayList<Menu>(); 
		HttpSession ses =req.getSession();
		
		
		int id=0;
		int rid=0;
		String id2=req.getParameter("id");
		String rid2 =req.getParameter("Rid");
		
		if(id2 != null && rid2!=null)
		{
			
			 id = Integer.parseInt(id2);
			 rid= Integer.parseInt(rid2);
		}
		else
		{
			
			 id = (int)ses.getAttribute("id");
			 rid= (int)ses.getAttribute("rid");
		}
		
		
		
		
		ses.setAttribute("id", id);
		ses.setAttribute("rid", rid);
		
		Menu menu=new Menu();
		int id1=(int)ses.getAttribute("id");
		int rid1=(int)ses.getAttribute("rid");
		
		menu.setRestaurantIdFromMenu(id1);
		menu.setRestaurantOwnerId(rid1);
		
		
		
		ArrayList<Menu> menu_list=(ArrayList<Menu>)req.getAttribute("menu-list");
		
		
		if(menu_list==null)
		{
			list.add(menu);
			req.setAttribute("menu-list", list);
			RequestDispatcher rd=req.getRequestDispatcher("menu.jsp");
			rd.forward(req, resp);
		}
		
		else
		{
			
			
			list=menu_list;
			boolean exist=false;

			for(Menu me :menu_list)
			{
				if(me.getRestaurantIdFromMenu()==id)
				{
					exist=true;
					RequestDispatcher rd=req.getRequestDispatcher("menu.jsp");
					rd.forward(req, resp);
					
				}
			}
			
			if(!exist)
			{
				list.add(menu);
				resp.sendRedirect("homepage.jsp");
			}
			
			
			
		}
		
		
		
		
	
		
		
		
		
		
		
		
		
	}

}
