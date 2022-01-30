<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Question</title>
</head>
<body style="background-color:powderblue;">
 <h1> Section List</h1>
      		<table border="2">
			<thead>
				<tr>
				  <th >Section Id</th>
				  <th>Section Name</th>
				  <th>Status</th>
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<c:forEach var="SectionList" items="${sectionList}">
				<tr>
				<td>${SectionList.sectionId }</td>	
					 <td>${SectionList.sectionName}</td>					
				    <td>${SectionList.status}</td>					
								
			</tr>
					</c:forEach>
					</tbody>
		           </table><br><br>
   <form name="question" class="question" action="AddQuestionServlet" >
      <table>
        <tr>
          <td><label for="name">Enter Question:</label></td>
          <td><input type="text" name="question"  pattern="[A-Za-z]+[?]{10, }"required autofocus></td>
        </tr> 
        <tr>      
          <td><label for="sectionName">Select your Section Name</label></td>
          <td><input type="text" name="sectionName" pattern="[A-Za-z]{10, }" required></td>
        </tr>     
       
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
    </form>
    <li><a href="admin.jsp">Back to Home Page</a></li>
</body>
</html>