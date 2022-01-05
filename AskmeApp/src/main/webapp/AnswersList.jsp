<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.askme.dao.AnswerDAOImpl"%>  
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:powderblue;">
  <p>Answer List</p>
<%  
		AnswerDAOImpl answerDao=new AnswerDAOImpl();
        ResultSet rs=answerDao.showAllAnswer();
		%>
	
   		<table border="2">
			<thead>
				<tr>
				  <th >Answers</th>
				   
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
					
			</tr>
					
			<%} %>
					</tbody>
		           </table><br><br>
 <li><a href="Admin.jsp">Back to Home Page</a></li>			           
</body>
</html>