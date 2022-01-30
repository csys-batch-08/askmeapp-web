<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CommentView</title>
</head>
<body style="background-color:powderblue;">
    <p>Comments by User</p>

   		<table border="2">
			<thead>
				<tr>
				<th>Email Id</th>
				  <th >Comments</th>				   
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<c:forEach var="CommentList" items="${commentList}">
				<tr>
				<td>${CommentList.email }</td>					
					 <td>${CommentList.comment}</td>					
				    <c:set var="comment" value="${CommentList.comment}"/>				
				    <td><a href="editAnswer.jsp">Edit</a> 				 					
					
			</tr>
					
			</c:forEach>
					</tbody>
		           </table><br><br>
     <li><a href="admin.jsp">Back to Home Page</a></li>
</body>
</html>