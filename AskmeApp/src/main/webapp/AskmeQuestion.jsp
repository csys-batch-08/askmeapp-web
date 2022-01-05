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
    
<% int s_id = Integer.parseInt(request.getParameter("id3"));
		QuestionDAOImpl questionDao=new QuestionDAOImpl();
		ResultSet rs=questionDao.showQuestion(s_id);%>
		 <h1> Question List</h1>
	   
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
				<td><%=rs.getString(2)%></td>
				<td>><button><a href="Answer.jsp?quesId=<%=rs.getInt(1)%>"> View Answer</a></button>		
			</tr>
					
			<%} %>
					</tbody>
		           </table><br><br>
		        
</body>
</html>