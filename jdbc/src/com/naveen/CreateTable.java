package com.naveen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root","");
			System.out.println("Connected "+con);
			Statement stmt = con.createStatement();
			/*String create="create table Student (fname varchar(25),lname varchar(25), age int, email varchar(25), physics int,chemestry int, mathematic int, total int)";
			  int record=stmt.executeUpdate(create);
			if(record>0)
			{
				System.out.print("Table Created Succesfully");
			}
			
			String insert="insert into Student(fname, lname, age, email, physics, chemenstry, mathematics,total)values ('naveen', 'yadav', 24, 'naveenyadav9998@gmail.com', 80,90, 75,(physics+chemenstry+mathematics)";
			int record=stmt.executeUpdate(insert);
			if(record>0)
			{
				System.out.print("Insertded Succesfully");
			}*/
			
			String sql="select* from Student";
			
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			for(int i=1; i<=rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i)+" ");
			System.out.print(rsmd.getColumnTypeName(i)+" ");
			/*System.out.print(rsmd.getColumnName(2)) ;
			System.out.print(rsmd.getColumnName(3));
			System.out.print(rsmd.getColumnName(4));
			System.out.print(rsmd.getColumnName(5));
			System.out.print(rsmd.getColumnName(6));
			System.out.print(rsmd.getColumnName(7));*/}
			System.out.println();
			
			while(rs.next())
			{
				System.out.print(rs.getString(1)+" ");
				System.out.print(rs.getString(2)+" ");
				System.out.print(rs.getInt(3)+" ");
				System.out.print(rs.getString(4)+" ");
				System.out.print(rs.getInt(5)+" ");
				System.out.print(rs.getInt(6)+" ");
				System.out.print(rs.getInt(7));
				System.out.println();
			}

			
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}

}
