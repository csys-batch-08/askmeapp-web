<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.chainsys.impl.QuestionDAOImpl"%>  
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question List</title>
</head>
<body style="background-color:powderblue;">
  <p>Question List</p>
<%  
		QuestionDAOImpl questionDao=new QuestionDAOImpl();
        ResultSet rs=questionDao.showAllQuestion();
		%>
	
   		<table border="2">
			<thead>
				<tr>
				  <th >Questions</th>
				  <th>Status</th>
				   
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<%
				while(rs.next()){				
				%>
				<tr>	
					 <td><%=rs.getString(2) %></td>	
					 <td><%=rs.getString(4) %></td>						
					
			</tr>
					
			<%} %>
					</tbody>
		           </table><br><br>
		            <li><a href="Admin.jsp">Back to Home Page</a></li>
</body>
</html>