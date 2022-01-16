<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.askmeapp.impl.QuestionDAOImpl"%>  
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		         <form name="answer"  action="AddAnswersServlet"  method="post">
     
      <table>
        <tr>
          <td><label for="answer">Enter Answer</label></td>
          <td><input type="text" name="answer" pattern="[A-Za-z]{10, }" required autofocus></td>
        </tr><br>
         <tr>
          <td><label for="question">Question</label></td>
          <td><input type="text" name="question" pattern="[A-Za-z]+[?]{10, }"  required autofocus></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
    </form>  
 <li><a href="Admin.jsp">Back to Home Page</a></li>
</body>
</html>