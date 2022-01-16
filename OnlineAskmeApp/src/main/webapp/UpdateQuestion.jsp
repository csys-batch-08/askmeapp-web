<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@page import="com.askmeapp.impl.QuestionDAOImpl"%>  
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Question</title>
</head>
<body style="background-color:powderblue;">
	<h1>Update Question</h1>
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
<form name="question"  action="UpdateQuestionServlet"  method="post">
     
      <table>
        <tr>
          <td><label for="question">Enter old Question</label></td>
          <td><input type="text" name="oldquestion"  pattern="[A-Za-z]+[?]{10, }" required autofocus></td>
        </tr><br>
         <tr>
          <td><label for="name">Enter New Question</label></td>
          <td><input type="text" name="newquestion"  pattern="[A-Za-z]+[?]{10, }" required autofocus></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
    </form>
     <li><a href="Admin.jsp">Back to Home Page</a></li>
</body>
</html>