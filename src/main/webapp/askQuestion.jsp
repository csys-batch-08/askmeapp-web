<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ask a Question</title>
<style>
       body {
          background-image: url('assets/images/cloud.jpg');
        background-repeat: no-repeat;
         background-attachment: fixed;  
         background-size: cover;
          
       }
        </style>
</head>
<body>
    
		
		 <h1 style=color:white> Question List</h1>
       <c:set var="QuestionList" value="${questionList}"/>
			<c:choose>
			<c:when test="${not empty QuestionList }">
			
   		<table border="2">
			<thead>
				<tr>
				  <th  style=color:white>Questions</th>
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
								
				<tr>
				<c:forEach var="QuestionList"  items="${questionList}">	
				<td>${QuestionList.questions}</td>
				<td><button ><a href="AnswerServlet?quesId=${QuestionList.questionId }&question=${QuestionList.questions}"> View Answer</a></button>	</td>
				    				
			</tr>
				</c:forEach>	
				
					</tbody>
		           </table>
		           </c:when>
		           <c:otherwise>
		           <c:out value="No Questions Found"/>
		           </c:otherwise>
		       </c:choose>   
		            <li><a href="userHome.jsp" style=color:white>Back to Home Page</a></li>
		        
</body>
</html>