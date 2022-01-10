<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Message</title>
<style>
body{
  background-image: url('images/master1.jpg');
        background-repeat: no-repeat;
         background-attachment: fixed;  
         background-size: cover;
}
div{
	text-align:center;
	margin-top:300px;
}
</style>
</head>
<body>
<%String message= request.getParameter("message");
String url= request.getParameter("url"); %>
<div>
<h1 style=color:white><%=message %></h1>
<a href="<%=url %>"><button>Go Back</button></a>
</div>
</body>
</html>