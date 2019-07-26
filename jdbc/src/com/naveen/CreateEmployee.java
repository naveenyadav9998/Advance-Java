package com.naveen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateEmployee {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		try 
		{
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbc","root","");
			System.out.println("Connected "+con);
			Statement stmt = con.createStatement();
			System.out.println("Input your choice \n for Insert Press :1\n for Update Press :2\n for Delete Press :3\n for view Press :4\n");
			int choice=input.nextInt();
			/*String create="create table Employee (id int,fname varchar(25),lname varchar(25),salary int )";
			int record=stmt.executeUpdate(create);
			if(record>0)
			{
				System.out.print("Table Created Succesfully");
			}*/
			
			switch (choice)
			{
				case 1:
			
			System.out.println("Enter Employee Id: ");
			int id=input.nextInt();
			System.out.println("Enter First Name: ");
			
			String fname=input.next();
			System.out.println("Enter Last Name: ");
			
			String lname=input.next();
			System.out.println("Enter Sallary: ");
			int salary=input.nextInt();
			
			
			
			
			int hra=(25/100)*salary;
			
			
			
			int da=(30/100)*salary;
			
			
			String insert="insert into Employee (id,fname,lname,salary,hra,da,total) values ("+id+",'"+fname+"','"+lname+"',"+salary+",((25/100)*salary),((30/100)*salary),(salary+hra+da))";
			int record=stmt.executeUpdate(insert);
			if(record>0)
			{
				System.out.println("Data Inserted succesfully");
			}
			else
			{
				System.out.println("Data Not Inserted");
			}
			break;
				case 2:
			System.out.println("Enter Employee Id: ");
			 id=input.nextInt();
			System.out.println("Enter First Name: ");
			
			 fname=input.next();
			System.out.println("Enter Last Name: ");
			 lname=input.next();
			
			System.out.println("Enter Sallary: ");
			int sallary=input.nextInt();
			
			System.out.println("Enter WHERE ID: ");
			int cid=input.nextInt();
			
			String update="update employee set id="+id+",fname='"+fname+"',lname='"+lname+"',salary="+sallary+" where id="+cid+"";
			 record=stmt.executeUpdate(update);
			if(record>0)
			{
				System.out.println("Record updated");
			}
			else
			{
				System.out.println("Record not Updated");
			}
			break;
				case 3:
			System.out.println("Enter WHERE ID: ");
			 cid=input.nextInt();
			
			String delete="delete from Employee where id="+cid+"";
			 record=stmt.executeUpdate(delete);
			if(record>0)
			{
				System.out.println("Record Deleted ");
			}
			else
			{
				System.out.println("Record not found for delete/not deleted");
			}
			break;
				case 4:
String sql="select* from employee";
			
			ResultSet rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			
			for(int i=1; i<=rsmd.getColumnCount(); i++) {
			System.out.print(rsmd.getColumnName(i)+" ");
			System.out.print(rsmd.getColumnTypeName(i)+" ");
			}
System.out.println();
			
			while(rs.next())
			{
				System.out.print(rs.getInt(1)+" ");
				System.out.print(rs.getString(2)+" ");
				System.out.print(rs.getString(3)+" ");
				System.out.print(rs.getInt(4)+" ");
				System.out.print(rs.getInt(5)+" ");
				System.out.print(rs.getInt(6)+" ");
				System.out.print(rs.getInt(7));
				System.out.println();
			}
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
