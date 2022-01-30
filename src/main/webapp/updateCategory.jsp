<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Category</title>
 
</head>
<body style="background-color:powderblue;">
    <h1>Update Category</h1>     		
		           
 <form name="category" class="category" action="UpdateCategoryServlet"  method="post" >
     
      <table>
        <tr>
          <td><label for="name">Enter old Category Name</label></td>
          <td><input type="text" name="oldCategoryName"  pattern="[A-Za-z]{10, }"required autofocus></td>
        </tr><br>
         <tr>
          <td><label for="name">Enter New Category Name</label></td>
          <td><input type="text" name="newCategoryName" pattern="[A-Za-z]{10, }" required autofocus></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
    </form>
     <li><a href="admin.jsp">Back to Home Page</a></li>
</body>
</html>