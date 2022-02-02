<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Category List</title>
</head>
<body style="background-color:powderblue;">
	<p>CategoryList</p>

	
   		<table border="2">
			<thead>
				<tr>
				<th>Category Id</th>
				   <th >Category Name</th>
				   <th>Status</th>
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
			<c:forEach var="cList" items="${categoryList}">
				<tr>
				
					 <td>${cList.categoryId}</td>					
				    <td>${cList.categoryName}</td>	
				     <td>${cList.status}</td>					
				    				
			</tr>
					</c:forEach>			
					</tbody>
		           </table><br><br>
 <li><a href="admin.jsp">Back to Home Page</a></li>		           
</body>
</html>