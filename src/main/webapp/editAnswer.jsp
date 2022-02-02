<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Edit Answer</title>
</head>
<body style="background-color:powderblue;">


   <form action="EditAnswerServlet1" method="post">   
        <table>
            <thead>
                <tr>
                    <th>Answer<input type="text" name="answer" pattern="[A-Za-z]{10, }" ></th>                   
                </tr>
            </thead>
        </table>
        <button type="submit">Submit Answer</button>
    </form>
    
    <li><a href="admin.jsp">Back to Home Page</a></li>
</body>
</html>