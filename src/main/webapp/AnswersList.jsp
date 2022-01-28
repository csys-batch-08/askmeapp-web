<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Answer List</title>
</head>
<body style="background-color:powderblue;">
  <p>Answer List</p>
   		<table border="2">
			<thead>
				<tr>
				  <th >Answers</th>
				   <th>Status</th>
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
			<c:forEach var="AnswerList" items="${answerList}">
				<tr>
				<td>${AnswerList.answers}</td>				
				<td>${AnswerList.status}</td>					
								
			</tr>
					</c:forEach>
					</tbody>
		           </table><br><br>
 <li><a href="Admin.jsp">Back to Home Page</a></li>			           
</body>
</html>