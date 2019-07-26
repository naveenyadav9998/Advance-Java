package com.naveen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase 
{
	public static void main(String[] args) 
	{
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root","");
			System.out.println("Connecting"+con);
			Statement stmt = con.createStatement();
			String insert="insert into Account(accno,Fname,Lname,bal)values(200,'Nitish','ojha',40000)";
			int record=stmt.executeUpdate(insert);
			if(record>0)
			{
				System.out.print("Insertded Succesfully");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
