<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.askme.impl.AdminCommentViewDAOImpl"%>  
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CommentView</title>
</head>
<body style="background-color:powderblue;">
    <p>Comments by User</p>
<%  AdminCommentViewDAOImpl commentDao=new AdminCommentViewDAOImpl();
		 ResultSet rs=commentDao.selectEmail();
		%>	
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
				<%
				while(rs.next()){				
				%>
				<tr>
					<td><%=rs.getString(1) %></td>	
					 <td><%=rs.getString(2) %></td>	
					 <%System.out.println("jsp"+rs.getString(2)); %>
					 <td><a href="EditAnswer.jsp?question=<%=rs.getString(2)%>">Edit</a>					
					
			</tr>
					
			<%} %>
					</tbody>
		           </table><br><br>
     <li><a href="Admin.jsp">Back to Home Page</a></li>
</body>
</html>