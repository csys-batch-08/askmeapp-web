<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:powderblue;">
<h1>Update Answer</h1>
    <p>Answer List</p>
	
   		<table border="2">
			<thead>
				<tr>
				  <th >Answers</th>
				  <th>question Id</th>
				   <th>Status</th>
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<c:forEach var="AnswerList" items="${answerList}">
				<tr>
				<td>${AnswerList.answers}</td>	
					 <td>${AnswerList.questionId}</td>					
				    <td>${AnswerList.status}</td>					
								
			</tr>
					</c:forEach>
					</tbody>
		           </table><br><br>
<form name="answer"  action="UpdateAnswerServlet" >
     
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