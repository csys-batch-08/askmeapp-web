
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Section Content</title>
<link rel=stylesheet type=text/css href=assets/css/style.css>
<style>
*{margin:0;
padding:0;}
 #box{
     margin-right:10px;
     padding:50px;}
      #box1{
     margin-left:-10px;  
    padding-left:150px;
     margin-top:-100px;   
    }
       table, th, td {
                border: 2px solid black;
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
            <li><a href="userHome.jsp" style=color:white> Home </a></li>
            <li><a href="readMore.jsp" style=color:white>About Us</a></li>          	  
           <li><a href="AskMeQuestionServlet"style=color:white>Ask a question</a></li>
            <li> <a href="comments.jsp" style=color:white>Leave a Reply</a></li>         
      </ul>
    </div>
    <div id=head>

<form id="box">
 
 <table  align="right">
 <h2 class="title" align="center">Frequently viewed Section</h2>
			<thead>
			
				<tr>				
				   <th>Section Name</th>
				   <th>Rating</th>
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
			<c:forEach var="userRatingList"  items="${userRatingList}">
			
			 <c:set var = "rate"  value="${userRatingList.rating/userRatingList.rateCount}" />			
				<tr>
				<td>${userRatingList.sectionName}</td>
				<td>${rate}</td>
				    				
			</tr>
					</c:forEach>
					</tbody>
		           </table></form><br><br>
 <c:set var="content" value="${sectionName }"></c:set>
  <form id="box1" action="UserRatingServlet?sName=${sectionName}" method="post">   
     
      <label>Click To Read a File: </label> 
      <a href="assets/images/${content}.pdf">${content}</a><br><br>
       <center>   
       <h2><b>Place Your Rating</b></h2>
        <h3>From 1....10 </h3>
        <input type="text" name="rating" pattern="[0-9]{1,10}">                 
        <button type="submit">Submit Rating</button>
        </center>
        </form>
   
    
    
        

</body>
</html>