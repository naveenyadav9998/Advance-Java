package com.codebootcamp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
 * Servlet implementation class ViewDept
 */
@WebServlet("/ViewDept")
public class ViewDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ServletContext context;
	private Connection con;
	private Statement stmt;
	public void init(ServletConfig config) throws ServletException {
context = config.getServletContext();
		
		String dburl = context.getInitParameter("dbUrl");
		String dbuser = context.getInitParameter("dbUser");
		String dbclass = context.getInitParameter("dbClass");
		

		try {
			Class.forName(dbclass);
			con = DriverManager.getConnection(dburl, dbuser,"");
			stmt = con.createStatement();
			System.out.print(con);
			
			
			
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
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("Running");
		String sql="select * from dept";
		try {
			ResultSet result = stmt.executeQuery(sql);
			
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			
			out.print("<html><body><table border='1'><tr><th>Name</th><th>HOD</th><th>Qualification</th></tr>");
			while(result.next())
			{
				
				out.println("<tr><td>"+result.getString("name")+"</td>");
				out.println("<td>"+result.getString("hod")+"</td>");
				out.println("<td>"+result.getString("qualification")+"</td></tr>");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
