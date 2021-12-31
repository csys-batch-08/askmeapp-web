<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body>
<h1>Category</h1>
 <form name="category" class="category" action="CategoryName" return formValidation()" method="post">
      <table>
        <tr>
          <td><label for="name">Category Name</label></td>
          <td><input type="text" name="categoryName" id="categoryName" placeholder="CategoryName"required autofocus></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
    </form>
</body>
</html>