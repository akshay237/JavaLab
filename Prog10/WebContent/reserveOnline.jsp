<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ViewDetails.jsp">
Name:<input type="text" name="name"/><br>
Number:<input type="text" name="num"/><br>
Date:<input type="text" name="date"/><br>
FlightNo:<input type="text" name="flightno"/><br>
<input type="submit" value="Reserve"/>
</form>
<br><br>
For Flight Search:<br>
<form action="Details.jsp">
Name:<input type="text" name="name"/><br>
<input type="submit" value="Search"/><br>
</form>
</body>
</html>