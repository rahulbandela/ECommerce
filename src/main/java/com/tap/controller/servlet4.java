package com.tap.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tap.userdaoimpl.UserDaoImpl;

@WebServlet("/callservlet4")

public class servlet4 extends HttpServlet{
	
	static int i=3;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDaoImpl udi=new UserDaoImpl();
		String uname = req.getParameter("uname");
		String u="";
		
		if(uname != null)
		{
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
			u=s+t;
			String password=udi.getPassword(u);
			 PrintWriter out=	resp.getWriter();
			 resp.setContentType("text/html");
			 String b="false";
			 
			 if(password.equals(req.getParameter("pass")))
			 {
				 b="true";
				 req.setAttribute("login", b);
				 req.setAttribute("uname", uname);
				 RequestDispatcher rd=req.getRequestDispatcher("callservlet1");
				 rd.include(req, resp);
				 
			 }
			 else if(i>0)
				 
			 {
				 i--;
				 
				 
				 req.setAttribute("attemts", i);
				 
				 RequestDispatcher rd=req.getRequestDispatcher("loginfailed.jsp");
				 rd.forward(req, resp);
				 
				 
			 }
			 
			 else
			 {
				 b="false";
				 req.setAttribute("login", b);
				 
				 RequestDispatcher rd=req.getRequestDispatcher("register-again.jsp");
				 rd.forward(req, resp);
				 
			 }
			 
			 
			
			
			
			
		}
		else
		{
			uname="signin";
			
			req.setAttribute("uname", u);
			RequestDispatcher rd=req.getRequestDispatcher("callservlet1");
			rd.forward(req, resp);
			 
			 
			
			
			 
			
			 
		}
		
		}
		
		
		
	
	

}
