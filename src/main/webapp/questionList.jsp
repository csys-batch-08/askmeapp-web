<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question List</title>
</head>
<body style="background-color:powderblue;">
  <p>Question List</p>
   		<table border="2">
			<thead>
				<tr>
				<th>QuestionId</th>
				  <th >Questions</th>
				  <th>Status</th>
				   
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<c:forEach var="QuestionList" items="${questionList}">
				<tr>
				<td>${QuestionList.questionId }</td>	
					 <td>${QuestionList.questions}</td>					
				    <td>${QuestionList.status}</td>					
				     			
			</tr>
					</c:forEach>
					</tbody>
		           </table><br><br>
		            <li><a href="admin.jsp">Back to Home Page</a></li>
</body>
</html>