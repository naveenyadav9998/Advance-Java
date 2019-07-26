package com.naveen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PrimeRange extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1=req.getParameter("n1");
		String s2=req.getParameter("n2");
		
		int snum=Integer.parseInt(s1);
		int lnum=Integer.parseInt(s2);
		int i;
		
	
		
		
		for( i=snum;i<=lnum;i++)
		{
			int count=0;
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
				{
					count++;
					break;
				}
				
			}
			if(count==1 || snum==1 || snum==0 || snum<0 )
			{/*
				res.setContentType("html/text");
				
				PrintWriter out = res.getWriter();
				out.println("<html><body><h1>number is not prime "+i+"</h1></body></html>");
				
				
			*/}
			else
			{
				res.setContentType("text/html");
			
			PrintWriter out = res.getWriter();
				out.println("<html><body><h1>number is  prime "+i+"</h1></body></html>");
				
			}
			
			
		}
		
	

	}

}
