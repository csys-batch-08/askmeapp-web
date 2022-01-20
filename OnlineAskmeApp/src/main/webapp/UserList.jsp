<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@page import="com.askmeapp.impl.UserDAOImpl"%> 
  <%@page import="com.askmeapp.model.User"%>  
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body style="background-color:powderblue;">
<p>User List</p>
<%  
		UserDAOImpl userDao=new UserDAOImpl();
        ResultSet rs=userDao.showAllUser();
		%>
	
   		<table border="2">			
			<thead>
				<tr>
				<th>User id</th>
				   <th >User Name</th>
				   <th>Email id</th>
					
					<th>Subscriber</th>
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<%
				while(rs.next()){				
				%>
				<tr>
				<td><%=rs.getInt(1)%></td>	
					 <td><%=rs.getString(2) %></td>					
				    <td><%=rs.getString(3) %></td>
					
				     <td><%=rs.getString(6)%></td>
					
			</tr>
					
			<%} %>
					</tbody>
		           </table>
<br>
<br>
 <li><a href="Admin.jsp">Back to Home Page</a></li>
</body>
</html>