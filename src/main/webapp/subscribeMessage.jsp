<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Subscriber Message</title>
<link rel=stylesheet type=text/css href=assets/css/style.css>
 <style>
 *{
 margin:0;
 padding:0;}
       body {
         background-image: url('assets/images/cloud.jpg');
         background-repeat: no-repeat;
         background-attachment: fixed;  
         background-size: cover;
          
       }
         #box{
     margin-right:10px;
     padding:100px;}
      #box1{
     margin-left:-10px;  
    padding-left:150px;
     margin-top:-100px;   
    }
     
      table, th, td {
                border: 2px solid white;
                text-align:center;
            }
            th, td {
                padding: 12px;
                background-color:none;
            }
            .title{
            padding-left:600px;}
    
       
        </style>
</head>
<body>
 <div id="toolbar">
    </div>
    <div id="container">
        <div id=header>
      <img src="assets/images/simpleform.png">
      <ul>
          <li><a href="userHome.jsp" style=color:white> Go Home </a></li>
          <li><a href="readMore.jsp" style=color:white>About Us</a></li>
          
         
      </ul>
    </div>
    <div id=head>
<center> <h2 style=color:yellow>Welcome Subscriber<h1>&#128512;</h1></h2></center>
		
      <table border="5" >
      <form action="UserSubscriber" align="center"><br><br>
      <center><button type="submit" class="button">Recently Post!!!</button></form> </center>
 	
		           
</body>
</html>