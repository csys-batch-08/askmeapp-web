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
<style>
       body {
          background-image: url('images/question.jpg');
        background-repeat: no-repeat;
         background-attachment: fixed;  
         background-size: cover;
          
       }
        </style>
</head>
<body>
 <p style=color:white>Answer List</p>
<%     int questionId=Integer.parseInt(request.getParameter("quesId"));
    session.setAttribute("quesId",questionId);
		AnswerDAOImpl answerDao=new AnswerDAOImpl();
        ResultSet rs=answerDao.showAnswer(questionId);
        ResultSet rs1=answerDao.showAnswer(questionId);
        if(rs1.next()){
		%>
	<form action="AskQuestionServlet" method="post">
   		<table border="2">
			<thead>
				<tr>
				  <th style=color:white>Answers</th>
				   
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<%
				while(rs.next()){				
				%>
				<tr>	
					 <td style=color:white><%=rs.getString(1) %></td>						
					 <td colspan="2"><input type="submit"></td> 	
			</tr>
					
			<%} %>
					</tbody>
		           </table></form><br><br>
		            <%}else{
		        	   %>
		        	   <h1>No Answer Found</h1>
		        <% }%>   
		            <li><a href="UserHome.jsp" style=color:white>Back to Home Page</a></li>
</body>
</html>