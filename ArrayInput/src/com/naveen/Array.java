package com.naveen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Array extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1=req.getParameter("n1");
		String s2=req.getParameter("n2"),s3=req.getParameter("n3"),s4=req.getParameter("n4"),s5=req.getParameter("n5");
		
		int arr[],size=5;
		arr=new int [size];
		
		arr[0]=Integer.parseInt(s1);
		arr[1]=Integer.parseInt(s2);
		arr[2]=Integer.parseInt(s3);
		arr[3]=Integer.parseInt(s4);
		arr[4]=Integer.parseInt(s5);
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		
		for(int i=0;i<arr.length;i++)
		{
			out.println("<html><body><h1>Your Element is: "+arr[i]+"</h1></body></html>");
		}
		
		int max=0;
		for(int i=0;i<arr.length;i++)
		{
			if(max<arr[i])
			{
				int temp=arr[i];
				arr[i]=max;
				max=temp;
			}
		
		}
		out.println("<html><body><h1>"+"\n Max Element IS:"+max+"</h1></body></html>");
	}

}
