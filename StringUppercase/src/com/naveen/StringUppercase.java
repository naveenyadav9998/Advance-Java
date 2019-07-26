package com.naveen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class StringUppercase extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1=req.getParameter("n1");
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<html><body><h1>"+s1.toUpperCase()+"</h1></body></html>");
		

	}

}
