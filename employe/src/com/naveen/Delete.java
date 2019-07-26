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
 * Servlet implementation class Delete
 */
@WebServlet("/Delete")
public class Delete extends HttpServlet {
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
		
		String fname = request.getParameter("n1");
		
		String delete="delete from emp where fname='"+fname+"'";
		try {
			int res = stmt.executeUpdate(delete);
			if(res>0)
			{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("Data Deleted");
			}
			else
			{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("Error...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void destroy()
	{
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
