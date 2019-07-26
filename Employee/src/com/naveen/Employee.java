package com.naveen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Employee extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ename=req.getParameter("n1");
		String eid=req.getParameter("n2");
		String sallary=req.getParameter("n3");
		int s=Integer.parseInt(sallary);
		
		int hra=(s*5)/100;
		int da=(s*5)/100;
		int pf=(s*5)/100;
		
		int tsallary=s+hra+da+pf;
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		out.println("<html><body><h1>"+ename+"\n"+eid+"\n"+tsallary+"</h1></body></html>");

	}

}
