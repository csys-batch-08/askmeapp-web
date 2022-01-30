<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subscriber</title>
</head>
<body style="background-color:powderblue;">
<center><h2>Subscriber List</h2></center>
<table border="2">
<thead>
	<tr>  		
		<th>User Name</th>
		<th>Email</th>
	</tr>
	</thead>
<tbody>
<c:forEach var="SubscriberList" items="${subscriberList}">
<tr>					
					 <td>${SubscriberList.name}</td>					
				    <td>${SubscriberList.emailId}</td>					    				
			</tr>
</c:forEach>

</tbody>
</table>
 <form name="subscriber"  action="SubscriberServlet1"  method="post">
     
      <table>
        <tr>
          <td><label for="name">Recent Section Name</label></td>
          <td><input type="text" name="sectionName" pattern="[A-Za-z]{10, }" required autofocus></td>
        </tr><br><br>
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
      </form>
 <li><a href="admin.jsp">Back to Home Page</a></li>
</body>
</html>