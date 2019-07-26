package com.naveen;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class registration
 */
@WebServlet("/registration")
public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection con;
	private Statement stmt;
   
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		String dburl = context.getInitParameter("dbUrl");
		String dbuser = context.getInitParameter("dbUser");
		String dbclass = context.getInitParameter("dbClass");
		
		try {
			Class.forName(dbclass);
			con = DriverManager.getConnection(dburl, dbuser,"");
			stmt = con.createStatement();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String fname = req.getParameter("textfield");
		String lname = req.getParameter("textfield2");
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		String radio = req.getParameter("radio");
		String Age = req.getParameter("date");
		int age=Integer.parseInt(Age);
		String sql="insert into registration(fname,lname,email,pass,radio,age"
				+ ")Values('"+fname+"','"+lname+"','"+email+"','"+pass+"','"+radio+"','"+age+"')";
		
		try {
			int result=stmt.executeUpdate(sql);
			if(result>0)
			{
				res.setContentType("text/html");
				PrintWriter out = res.getWriter();
				
				out.println("Inserted");
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	
	}

}
