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
   <h1>Update Section</h1>
    <p>Section List</p>
   		<table border="2">
			<thead>
				<tr>
				  <th >Section Name</th>
				   <th >Category Id</th>
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
		           
 <form name="section"  action="UpdateSectionServlet"  method="post">
     
      <table>
        <tr>
          <td><label for="name">Enter old Section Name</label></td>
          <td><input type="text" name="oldSectionName" pattern="[A-Za-z]{10, }"  required autofocus></td>
        </tr><br>
         <tr>
          <td><label for="name">Enter New Section Name</label></td>
          <td><input type="text" name="newSectionName"  pattern="[A-Za-z]{10, }" required autofocus></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
    </form>
     <li><a href="admin.jsp">Back to Home Page</a></li>
</body>
</html>