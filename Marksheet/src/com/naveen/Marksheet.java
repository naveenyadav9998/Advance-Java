package com.naveen;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class Marksheet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=req.getParameter("n1");
		String s1=req.getParameter("n2");
		int rollno=Integer.parseInt(s1);
		String s2=req.getParameter("n3");
		int m=Integer.parseInt(s2);
		String s3=req.getParameter("n4");
		int p=Integer.parseInt(s3);
		String s4=req.getParameter("n5");
		int c=Integer.parseInt(s4);
		String s5=req.getParameter("n6");
		int h=Integer.parseInt(s5);
		String s6=req.getParameter("n7");
		int e=Integer.parseInt(s6);
		
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
				out.print("<html>\r\n" +  
				"<body>\r\n" + 
				"<table width=\"636\" height=\"299\" border=\"1\">\r\n" + 
				"  <tbody>\r\n" + 
				"    <tr>\r\n" + 
				"      <td height=\"45\" colspan=\"3\"><h1>Name: "+name+"</h1></td>\r\n" + 
				"      <td height=\"45\"><h1>Rollno: "+rollno+"</h1></td>\r\n" + 
				"    </tr>\r\n" + 
				"    <tr>\r\n" + 
				"      <td width=\"142\" height=\"32\">SUBJECT</td>\r\n" + 
				"      <td width=\"130\">MAX MARKS</td>\r\n" + 
				"      <td width=\"130\">MIN MARKS</td>\r\n" + 
				"      <td width=\"206\">Marks Obtain</td>\r\n" + 
				"    </tr>\r\n" + 
				"    <tr>\r\n" + 
				"      <td height=\"23\"><h1>Mathematics</td>\r\n" + 
				"      <td>100</td>\r\n" + 
				"      <td>33</td>\r\n" + 
				"      <td><h1>"+m+"</h1></td>\r\n" + 
				"    </tr>\r\n" + 
				"    <tr>\r\n" + 
				"      <td><h1>Physics</h1></td>\r\n" + 
				"      <td>100</td>\r\n" + 
				"      <td>33</td>\r\n" + 
				"      <td><h1>"+p+"</h1></td>\r\n" + 
				"    </tr>\r\n" + 
				"    <tr>\r\n" + 
				"      <td><h1>Chemistry</h1></td>\r\n" + 
				"      <td>100</td>\r\n" + 
				"      <td>33</td>\r\n" + 
				"      <td><h1>"+c+"</h1></td>\r\n" + 
				"    </tr>\r\n" + 
				"    <tr>\r\n" + 
				"      <td height=\"23\"><h1>Hindi</h1></td>\r\n" + 
				"      <td>100</td>\r\n" + 
				"      <td>33</td>\r\n" + 
				"      <td><h1>"+h+"</h1></td>\r\n" + 
				"    </tr>\r\n" + 
				"    <tr>\r\n" + 
				"      <td height=\"23\"><h1>English</h1></td>\r\n" + 
				"      <td>100</td>\r\n" + 
				"      <td>33</td>\r\n" + 
				"      <td><h1>"+e+"</h1></td>\r\n" + 
				"    </tr>\r\n" );
		int grade=(p+c+m+h+e)/5;
		if(grade>=60 && grade<=100)
		{
			 out.println("<tr>\r\n" + 
			 		"      <td height=\"87\" colspan=\"3\"><h1>FirstDivision</h1></td>");
		}
		else if(grade>=45 && grade<=59)
		{
			 out.println("<tr>\r\n" + 
			 		"      <td height=\"87\" colspan=\"3\"><h1>Secound Devision</h1></td>");
		}
		
		else if(grade>=33 && grade<=44)
		{
			 out.println("<tr>\r\n" + 
			 		"      <td height=\"87\" colspan=\"3\"><h1>Third Devision</h1></td>");
		}
		
		else
		{
			out.println("<tr>\r\n" + 
			 		"      <td height=\"87\" colspan=\"3\"><h1>Failed</h1></td>");
		}
		
		out.println("<td><h1>total marks: "+grade+"</h1></td>\r\n" + 
				"    </tr>\r\n" + 
				"  </tbody>\r\n" + 
				"</table>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

}
