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
<form name="answer"  action="AddAnswersServlet">
     
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