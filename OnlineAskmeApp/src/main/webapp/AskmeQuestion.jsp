<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.askmeapp.impl.QuestionDAOImpl"%>  
    
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ask a Question</title>
<style>
       body {
          background-image: url('images/useit.jpg');
        background-repeat: no-repeat;
         background-attachment: fixed;  
         background-size: cover;
          
       }
        </style>
</head>
<body>
    
<% int s_id = Integer.parseInt(request.getParameter("id3"));
		QuestionDAOImpl questionDao=new QuestionDAOImpl();
		ResultSet rs=questionDao.showQuestion(s_id);
		ResultSet rs1=questionDao.showQuestion(s_id);	
		if(rs1.next()){
		%>
		
		
		 <h1 style=color:white> Question List</h1>

   		<table border="2">
			<thead>
				<tr>
				  <th style=color:white>Questions</th>
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<%
				while(rs.next()){				
				%>
			<tr>	
				<h2><td style=color:white><%=rs.getString(2)%></td></h2>
				
				<td><button ><a href="Answer.jsp?quesId=<%=rs.getInt(1)%>&question=<%=rs.getString(2)%>"> View Answer</a></button>	</td>	
			</tr>
					
			<%} %>
					</tbody>
		           </table>
		           <br><br>
		           <%}else{
		        	   %>
		        	   <h1>No Questions Found</h1>
		        <% }%>   
		            <li><a href="UserHome.jsp" style=color:white>Back to Home Page</a></li>
		        
</body>
</html>