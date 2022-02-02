<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title> User Answer</title>
<style>
       body {
          background-image: url('assets/images/cloud.jpg');
        background-repeat: no-repeat;
         background-attachment: fixed;  
         background-size: cover;
          
       }
        </style>
</head>
<body>
 <p style=color:white>Answer List</p>
<c:set var="AnswerList" value="${answerList}"/>
			<c:choose>
			<c:when test="${not empty AnswerList }">
	
	<form action="AskQuestionServlet" method="post">
   		<table border="2">
			<thead>
				<tr>
				  <th style=color:white>Answers</th>
				   
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
			
								
				<tr>
				<c:forEach var="AnswerList"  items="${answerList}">	
				<td>${AnswerList.answers}</td>
				<td colspan="2"><input type="submit"></td> 
				</c:forEach>	
								
			
					</tr>
				
					</tbody>
		           </table>
		           </form>
		            </c:when>
		          
		          
		           <c:otherwise>
		           <c:out value="No Answers Found"/>
		           </c:otherwise>
		   	</c:choose>        
				<a href="userHome.jsp" style=color:white>Back to Home Page</a>
		           
</body>
</html>