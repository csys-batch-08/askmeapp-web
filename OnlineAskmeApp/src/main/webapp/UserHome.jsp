<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.askmeapp.impl.CategoryDAOImpl"%>   
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home</title>
<link rel=stylesheet type=text/css href=assets/css/style.css>
 <style>
       body {
          background-image: url('assets/images/Question-answer.jpg');
        background-repeat: no-repeat;
         background-attachment: fixed;  
         background-size: cover;
          
       }
        </style>
</head>
<body>
 <div id="toolbar">
    </div>
    <div id="container">
        <div id=header>
      <img src="images/simpleform.png">
      <ul>
         
          <li><a href="ReadMore.jsp" style=color:white>About Us</a></li>
           <li><a href="Index.jsp" style=color:white>Logout</a></li>
         
         
      </ul>
    </div>
    <div id=head>
    <center>
    <h1 style=color:blanchedalmond ><i> Welcome to Askme</i></h1></div></center>
    <div id=head1>
       <center>  <h3 style=color:blanchedalmond>All Answer At Your FingerTips</h3></div></center>
       <center>   <form action="HomePage.jsp">
           <button type="submit" class="button">Read More....</button></center>
        </form>
        
</body>
</html>