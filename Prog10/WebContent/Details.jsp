<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Airline</title>
</head>
<body>
<%
  PrintWriter ot = response.getWriter();
  try{
	  Class.forName("com.mysql.jdbc.Driver");
	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flight","root","1628");
	  String name=request.getParameter("name");
	  Statement stmt=conn.createStatement();
	  String qu="Select * from Flight where airline_name='"+name+"';";
	  ResultSet rs=stmt.executeQuery(qu);
	  while(rs.next())
	  {
		  ot.append(rs.getString("flight_no")+ "\t");
		  ot.append(rs.getString("weekdays")+ "\t");
	  }
	  conn.close();
	  stmt.close();
  }
  catch(Exception et){
	  et.printStackTrace();
  }
%>
<br><br>
<a href="reserveOnline.jsp">Click here to get Details</a>
</body>
</html>