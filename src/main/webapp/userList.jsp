<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>

</head>
<body style="background-color:powderblue;">
<p>User List</p>
   		<table border="2">			
			<thead>
				<tr>
				<th>User Id</th>
				   <th >User Name</th>
				   <th>Email Id</th>					
					<th>Subscriber</th>
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<c:forEach var="UserList" items="${userList}">
				<tr>
				<td>${UserList.userId }</td>	
					 <td>${UserList.name}</td>					
				    <td>${UserList.emailId}</td>					
				     <td>${UserList.subscriber}</td>					
			</tr>
					</c:forEach>
			
					</tbody>
		           </table>
<br>
<br>
 <li><a href="admin.jsp">Back to Home Page</a></li>
</body>
</html>