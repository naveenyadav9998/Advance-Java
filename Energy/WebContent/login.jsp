<html>
<base target="_self">

<body bgcolor=#FFFFFF>
<%@ page import="java.sql.*"%>
<%
 
try
{
   Class.forName("com.mysql.cj.jdbc.Driver");
   Connection con=DriverManager.getConnection("jdbc:mysql://localhost/power","root","");
%>
<% 
	String uname=request.getParameter("uname");
    String s2=request.getParameter("password");
   
  session.setAttribute("uname",uname);

   Statement st=con.createStatement();
   Statement st1=con.createStatement();
   
   ResultSet rs=st.executeQuery("select * from logindetails where uname='"+uname+"' and password='"+s2+"'");

   if(rs.next())
	{
	   String s3= rs.getString(3);
	   
		if(s3.equals("admin"))
		  {
			response.sendRedirect("admin.jsp ");
		  }
	}


ResultSet rs1=st1.executeQuery("select * from consumer where uname='"+uname+"' and pass='"+s2+"'");
if(rs1.next())
	{
response.sendRedirect("consumer.jsp");
	}
	else 
   {
    response.sendRedirect("error.html");
   }
}
catch(Exception e)
{
System.out.println(e);
}
%>
</body>
                                                                                        </html>