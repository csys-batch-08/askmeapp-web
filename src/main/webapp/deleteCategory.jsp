<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Delete Category</title>
</head>
<body style="background-color:powderblue;">
    <h1>Delete Category</h1>
    <p>CategoryList</p>	
   		<table border="2">
			<thead>
				<tr>
				   <th>Category Id</th>
				   <th >Category Name</th>
				   <th>Status</th>
				   
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<c:forEach var="CategoryList" items="${categoryList}">
				<tr>
				
					 <td>${CategoryList.categoryId}</td>					
				    <td>${CategoryList.categoryName}</td>	
				     <td>${CategoryList.status}</td>					
				    				
			</tr>
					</c:forEach>	
					</tbody>
		           </table><br><br>
		           
 <form name="category" class="category" action="DeleteCategoryServlet"  method="post">
     
      <table>
        <tr>
          <td><label for="name">Enter Category Name</label></td>
          <td><input type="text" name="CategoryName1" pattern="[A-Za-z]{10, }" required autofocus></td>
        </tr><br><br>
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
      </form>
       <li><a href="admin.jsp">Back to Home Page</a></li>
</body>
</html>