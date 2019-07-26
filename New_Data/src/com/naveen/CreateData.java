package com.naveen;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateData
 */
@WebServlet(urlPatterns="/CreateData",initParams= {@WebInitParam (name="dbUrl", value = "jdbc:mysql://localhost/jdbc"), @WebInitParam (name="user",value="root"),
@WebInitParam (name="dbClass", value="com.mysql.cj.jdbc.Driver")})

public class CreateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private Statement stmt;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		
		try {
			
			String url=config.getInitParameter("dbUrl");
			String user=config.getInitParameter("user");
			
			Class.forName(config.getInitParameter("dbClass"));
			con = DriverManager.getConnection(url, user, "");
			stmt = con.createStatement();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
			String empid = req.getParameter("n1");
			String Name = req.getParameter("t1");
			String Age = req.getParameter("t2");
			String Email = req.getParameter("t3");
			String pswd = req.getParameter("p1");
				int id = Integer.parseInt(empid);
				int age = Integer.parseInt(Age);
				
				String sql="INSERT INTO employee2(Empid, Name, Age, Email, password) VALUES ("+id+",'"+Name+"',"+age+",'"+Email+"','"+pswd+"')";
			
		int result;
		try {
			result = stmt.executeUpdate(sql);
			if(result!=0)
			{
				res.setContentType("text/html");
				PrintWriter out = res.getWriter();
				out.print("Inserted");
			}
			
			else
			{
				System.out.checkError();
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
	}
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
