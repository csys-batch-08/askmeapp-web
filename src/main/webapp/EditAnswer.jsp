<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.chainsys.impl.QuestionDAOImpl"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Answer</title>
</head>
<body style="background-color:powderblue;">
<%String ques=request.getParameter("question");
session.setAttribute("questions",ques);%>
   <form action="EditAnswerServlet" method="post">   
        <table>
            <thead>
                <tr>
                    <th>Answer<input type="text" name="answer" pattern="[A-Za-z]{10, }" ></th>                   
                </tr>
            </thead>
        </table>
        <button type="submit">Submit Answer</button>
    </form>
</body>
</html>