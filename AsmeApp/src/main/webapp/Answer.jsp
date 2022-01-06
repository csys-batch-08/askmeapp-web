<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="com.askme.impl.AnswerDAOImpl"%>  
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> User Answer</title>
</head>
<body>
 <p>Answer List</p>
<%     int questionId=Integer.parseInt(request.getParameter("quesId"));
		AnswerDAOImpl answerDao=new AnswerDAOImpl();
        ResultSet rs=answerDao.showAnswer(questionId);
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
</body>
</html>