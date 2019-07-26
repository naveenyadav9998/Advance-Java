package com.codebootcamp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PreparedAddDept
 */
@WebServlet("/PreparedAddDept")
public class PreparedAddDept extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private PreparedStatement stmt;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		ServletContext context = config.getServletContext();
		
		String dbClass = context.getInitParameter("dbClass");
		String dbUrl = context.getInitParameter("dbUrl");
		String dbUser = context.getInitParameter("dbUser");
		
		try {
			Class.forName(dbClass);
			con = DriverManager.getConnection(dbUrl, dbUser, "");
			String sql="insert into dept values(?,?,?)";
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
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		String hod = req.getParameter("hod");
		String qualification = req.getParameter("qualification");
		
		try {
			stmt.setString(1, name);
			stmt.setString(2, hod);
			stmt.setString(3, qualification);
			
			int result=stmt.executeUpdate();
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			if(result>0)
			{
				
				out.println("Inserted through Prepared statements");
			}
			else
			{
				out.println("Something went wrong");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
