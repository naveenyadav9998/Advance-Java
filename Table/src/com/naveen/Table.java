package com.naveen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Table extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		String s1=req.getParameter("n1");
		int x=Integer.parseInt(s1);
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html><body><TABLE border=1> <!-- start of table --><CAPTION>Table Caption</CAPTION> <!-- caption for the table --> <!-- start of header row -->");
		for(int i=1;i<=10;i++)
		{
			int table=x*i;
			out.println("<TR><TH> "+table+" </TH></TR>");
		}
		out.println("</TABLE> <!-- end of table --></body></html>");

	}

}
