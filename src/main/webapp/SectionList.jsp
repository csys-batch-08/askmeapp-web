<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Section List</title>
</head>
<body style="background-color:powderblue;">
  <h1> Section List</h1>
   
   		<table border="2">
			<thead>
				<tr>
				  <th >Section Id</th>
				   <th >Section Name</th>
				   <th>Status</th>
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<c:forEach var="SectionList" items="${sectionList}">
				<tr>
				<td>${SectionList.sectionId }</td>	
					 <td>${SectionList.sectionName}</td>					
				    <td>${SectionList.status}</td>					
								
			</tr>
					</c:forEach>
					</tbody>
		           </table>
		           <br><br>
 <li><a href="Admin.jsp">Back to Home Page</a></li>
</body>
</html>