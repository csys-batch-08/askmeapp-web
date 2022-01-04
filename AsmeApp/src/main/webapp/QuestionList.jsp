<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.askme.dao.QuestionDAOImpl"%>  
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <p>Question List</p>
<%  
		QuestionDAOImpl questionDao=new QuestionDAOImpl();
        ResultSet rs=questionDao.showAllQuestion();
		%>
	
   		<table border="2">
			<thead>
				<tr>
				  <th >Questions</th>
				   
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
					
			</tr>
					
			<%} %>
					</tbody>
		           </table><br><br>
</body>
</html>