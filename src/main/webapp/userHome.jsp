<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.chainsys.impl.CategoryDAOImpl"%>   
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Home</title>
<link rel=stylesheet type=text/css href=assets/css/style.css>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <style>
 *{margin:0;
 padding:0;}
       body {
          background-image: url('assets/images/cloud.jpg');
        background-repeat: no-repeat;
         background-attachment: fixed;  
         background-size: cover;
          
       }
       .btn {
  background-color: #f4511e;
  border: none;
  color: white;
  padding: 16px 32px;
  text-align: center;
  font-size: 16px;
  margin-top:200px;
  margin-right:20px;
  padding:10px;
  opacity: 1;
  transition: 0.3s;
}

.btn:hover {opacity: 0.6}
        </style>
</head>
<body>
 <div id="toolbar">
    </div>
    <div id="container">
        <div id=header>
      <img src="assets/images/simpleform.png">
      <ul>
         
          <li><a href="ReadMore.jsp" style=color:white>About Us</a></li>          
          
           <li><a href="Index.jsp" style=color:white>Logout</a></li>
         
         
      </ul>
    </div>
    <div id=head>
    <center>
   <br><br> <h1 style=color:blanchedalmond ><i> Welcome to Askme</i></h1></div></center><br><br>
    <div id=head1>
       <center>  <h3 style=color:blanchedalmond>All Answer At Your FingerTips</h3></div></center>
       <center>   <form action="HomePage.jsp"><br><br>
           <button type="submit" class="button">Read More....</button></center>
        </form>
   
   <form action="SubscribeServle1" method="get">
   <button type="submit"  class=" btn" style="float:right" ><i style="font-size:24px" class="fa">&#xf0f3;</i>Subscribe Here</button>
   </form>
   
    
</body>


</html>