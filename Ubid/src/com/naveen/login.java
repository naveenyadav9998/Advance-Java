package com.naveen;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */

public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection con;
	private PreparedStatement stmt;
  
	public void init(ServletConfig config) throws ServletException 
	{
		System.out.println("This has Initialized");
		ServletContext context = config.getServletContext();
		
		String dbClass=context.getInitParameter("dbClass");
		String user = context.getInitParameter("dbUser");
		String url = context.getInitParameter("dbUrl");
		
		try {
			Class.forName(dbClass);
			
			con = DriverManager.getConnection(url, user,"");
			
			String sql="select * from registration where email=? and pass=?"; 
			stmt = con.prepareStatement(sql);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=req.getParameter("textfield");
		String pass=req.getParameter("password");
		
		RequestDispatcher rd=req.getRequestDispatcher("/HomeServlet");
		try {
			stmt.setString(1, email);
			stmt.setString(2, pass);
			
			ResultSet result = stmt.executeQuery();
			
			res.setContentType("text/html");
			
			PrintWriter out = res.getWriter();
			
			if(result.next())
				
			{
				String name=result.getString("fname");
				
				req.setAttribute("Message", "Welcome "+name);
				rd.forward(req, res);
		      //out.println("You Loged IN");
			}
			else 
		   {
				out.println("<p style=color:white; font-size:20px>Error not found details</p>");
			RequestDispatcher rd1 = req.getRequestDispatcher("/login.html");	
		    rd1.include(req, res);
		   }
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			con.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
