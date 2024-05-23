package com.tap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.model.User;
import com.tap.userdaoimpl.UserDaoImpl;

@WebServlet("/callservlet5")

public class servlet5 extends HttpServlet{
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDaoImpl udi = new UserDaoImpl();
		String name = req.getParameter("name1");
		String email = req.getParameter("email1");
		long num1 = Long.parseLong(req.getParameter("num1"));
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		
		char []ar = new char[uname.length()];
		String s="";
		String t="";
		ar=uname.toCharArray();
		
		for(int i=0;i<ar.length;i++)
		{
			if((ar[i] >='a' && ar[i]<='z')||(ar[i]>='A' && ar[i]<='Z'))
			{
				
				char ch1=((char)(ar[i]+3));
				
				s=s+ch1;
			}
			
			else if(ar[i]>=48 && ar[i]<=57)
			{
				
				char ch2 = ((char)(ar[i]+3));
				t = t+ch2;
				
			}
		}
		
		String u = s+t;
		
		
		
		
		
		
		
		
		
		User user = new User(name, email,num1, "",  u, pass, pass);
		udi.addUser(user);
		
		RequestDispatcher rd=req.getRequestDispatcher("login.jsp");
		rd.forward(req, resp);
		
	}

}
