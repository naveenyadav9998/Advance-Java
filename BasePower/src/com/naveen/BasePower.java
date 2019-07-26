package com.naveen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BasePower extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1=req.getParameter("n1");
		String s2=req.getParameter("n2");
		
		int base=Integer.parseInt(s1);
		int power=Integer.parseInt(s2);
		int result = 1;
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<html><body><table border=5><th>");
		
		for(int i=1;i<=power;i++)
		{
			result=result*base;
		}
		
		out.println("<h1>"+result+"</table></h1></body></html>");

	}

}
