package com.naveen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StringReverse extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1=req.getParameter("n1");
        String rev=new String();
		
		for(int i=s1.length()-1;i>=0;i--)
		{
			char c=s1.charAt(i);
			rev=rev+c;
		}
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body><h1>"+rev+"</h1></body></html>");

	}

}
