<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.askme.impl.AnswerDAOImpl"%>   
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:powderblue;">
<h1>Update Answer</h1>
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
<form name="answer"  action="UpdateAnswerServlet"  method="post">
     
      <table>
        <tr>
          <td><label for="answer">Enter old Answer</label></td>
          <td><input type="text" name="oldanswer"  pattern="[A-Za-z]{10, }" required autofocus></td>
        </tr><br>
         <tr>
          <td><label for="name">Enter New Answer</label></td>
          <td><input type="text" name="newanswer"  pattern="[A-Za-z]{10, }" required autofocus></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
    </form>
     <li><a href="Admin.jsp">Back to Home Page</a></li>
</body>
</html>