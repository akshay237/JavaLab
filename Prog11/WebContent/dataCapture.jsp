<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IncomeTax</title>
</head>
<body>
<%
  PrintWriter ot=response.getWriter();
  HashMap<String,String> hm = new HashMap<String,String>();
  hm.put("Akshay","123");
  hm.put("Shashwat","1234");
  hm.put("Vivek","12345");
  hm.put("Dr.Saibha","1628");
  String name=request.getParameter("name");
  String pass=(request.getParameter("pass"));
  if(hm.containsKey(name)&&(pass.equals(hm.get(name)))){
	  ot.println("<h1>Welcome "+ name +"</h1>");
	  %>
	  <br><br>
	  <form action="CalculateTax.jsp",method="post">
	  Place Of Work:<select name="pow">
	  <option>Engineer</option>
	  <option>Teacher</option>
	  <option>Doctor</option>
	  </select><br>
	  Gender:<select name="gender">
	  <option>Male</option>
	  <option>Female</option>
	  </select><br>
	  AnnualIncome:<input type="text" name="salary"/><br>
	  <input type="submit" value="Calculate"/>
	  </from>
	  <%}
  else { %>
  <jsp:forward page="inserthtml.html"></jsp:forward>
  <%} %>
  </body>
  </html>