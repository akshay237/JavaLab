<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculation of Tax for Working Employees</title>
</head>
<body>
<%
  PrintWriter pw = response.getWriter();
  double tax=0;
  double Salary=Double.parseDouble(request.getParameter("salary"));
  if(Salary<100000)
	  pw.println("No Income Tax to be paid");
  if(Salary>100000&&Salary<500000)
	  tax=0.15*Salary;
  if(Salary>500000)
	  tax=0.3*Salary;
  pw.println("Tax is :"+tax);
%>
</body>
</html>
