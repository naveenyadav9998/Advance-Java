package com.naveen;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private Statement stmt;
   
	public void init()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","");
			stmt=con.createStatement();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String pname=request.getParameter("n0");
		String fname = request.getParameter("n1");
		String lname = request.getParameter("n2");
		String email = request.getParameter("n3");
		String password = request.getParameter("n4");
		String a = request.getParameter("n5");
		int age = Integer.parseInt(a);
		
		String update="update emp set fname='"+fname+"',lname='"+lname+"',email='"+email+"',password='"+password+"',age='"+age+"' where fname='"+pname+"'";
		
		try {
			int res=stmt.executeUpdate(update);
			if(res>0)
			{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("Date Updateed");
			}
			else
			{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("Error");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
