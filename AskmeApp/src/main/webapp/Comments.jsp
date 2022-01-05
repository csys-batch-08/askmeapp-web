<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comments</title>
</head>
<body>

	
   <form name="comment" action="CommentServlet" method="post">
      <table>
        <tr>
          <td><label for="name">Enter your Comments:</label></td>
          <td><input type="text" name="comment" pattern="[A-Za-z]{10,}+" required autofocus></td>
        </tr>      
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
    </form>			
</body>
</html>