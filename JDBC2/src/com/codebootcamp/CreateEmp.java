package com.codebootcamp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateEmp
 */

public class CreateEmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
	private Statement stmt;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config)  {
		// TODO Auto-generated method stub
		String ClassForName=config.getInitParameter("dbClass");
		String Url=config.getInitParameter("dbUrl");
		String User=config.getInitParameter("dbUser");
		System.out.print(ClassForName+Url+User);
		
		try {
			Class.forName(ClassForName);
			conn = DriverManager.getConnection(Url, User, "");
			stmt = conn.createStatement();
			System.out.print(conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=req.getParameter("t1");
		String Age=req.getParameter("t2");
		String Email=req.getParameter("t3");
		String empid=req.getParameter("t4");
		String pswd=req.getParameter("p1");
		
		int age = Integer.parseInt(Age);
		int Empid = Integer.parseInt(empid);
		
		String sql="Update employee2 SET isActive=0 where Empid=101";
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		try {
			int result = stmt.executeUpdate(sql);
			
			if(result>0)
			{
				
				out.print("Inserted");
			}
			else
			{
				out.println(result);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
