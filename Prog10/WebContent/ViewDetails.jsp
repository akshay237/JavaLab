<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
</head>
<body>
<%
PrintWriter p = response.getWriter();
try{
	  Class.forName("com.mysql.jdbc.Driver");
	  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flight","root","1628");
	  Statement stmt=conn.createStatement();
	  String name=request.getParameter("name");
	  int cno=Integer.parseInt(request.getParameter("num"));
	  String date=request.getParameter("date");
	  int fno=Integer.parseInt(request.getParameter("flightno"));
	  int sno=new Random().nextInt(500)+1;
	  p.append(name + "\n"+cno+"\n"+date+"\n"+fno+"\n"+sno+"\n");
	  int c=stmt.executeUpdate("insert into Seat values("+fno+",'"+date+"',"+sno+",'"+name+"',"+cno+");");
	  p.append(" Row affected:" +c);
	  conn.close();
	  stmt.close();
}
catch(Exception e){
	e.printStackTrace();
}

%>
<br><br>
<a href="reserveOnline.jsp">To Reserve or Serach Click here</a>
</body>
</html>