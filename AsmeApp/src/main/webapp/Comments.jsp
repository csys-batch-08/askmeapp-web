<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Comments</title>
</head>
<body>
<%      int s_id = Integer.parseInt(request.getParameter("section_id"));
		session.setAttribute("sections_id", s_id);
		%>
	
   <form name="comment" action="CommentServlet" method="post">
      <table>
        <tr>
          <td><label for="name">Enter your Comments:</label></td>
          <td><input type="text" name="comment" required autofocus></td>
        </tr>      
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
    </form>			
</body>
</html>