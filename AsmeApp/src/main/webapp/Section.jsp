<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form name="section" class="section" action="Section" return formValidation()" method="post">
      <table>
        <tr>
          <td><label for="name">Section Name:</label></td>
          <td><input type="text" name="sectionName" id="name" placeholder="sectionName"required autofocus></td>
        </tr>
       
          <td><label for="categoryName">Category Name</label></td>
          <td><input type="text" name="categoryName" id="categoryName" required></td>
        </tr>     
       
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
    </form>
</body>
</html>