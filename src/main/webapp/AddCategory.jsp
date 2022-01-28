<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body style="background-color:powderblue;">
<h1>Category</h1>
 <form name="category" action="AddCategoryServlet"  method="post">     
      <table>
        <tr>
          <td><label for="name">Category Name</label></td>
          <td><input type="text" name="categoryName"  pattern="[A-Za-z]{10, }"required autofocus></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
    </form>
    <li><a href="Admin.jsp">Back to Home Page</a></li>
</body>
</html>