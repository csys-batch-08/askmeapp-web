<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Question</title>
</head>
<body style="background-color:powderblue;">
	<h1>Update Question</h1>
    <p>Question List</p>
   		<table border="2">
			<thead>
				<tr>
				  <th>QuestionId</th>
				  <th >Questions</th>
				  <th>Status</th>				   
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<c:forEach var="QuestionList" items="${questionList}">
				<tr>
				<td>${QuestionList.questionId }</td>	
					 <td>${QuestionList.questions}</td>					
				    <td>${QuestionList.status}</td>					
				     			
			</tr>
					</c:forEach>
					</tbody>
		           </table><br><br>
<form name="question"  action="UpdateQuestionServlet"  >
     
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
     <li><a href="admin.jsp">Back to Home Page</a></li>
</body>
</html>