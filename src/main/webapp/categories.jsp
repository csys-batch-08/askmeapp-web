<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Category</title>
</head>
<body style="background-color:powderblue;">
     <center><h1>Categories</h1></centre>
    <form action="addCategory.jsp">
    <button type="submit">Add Category</button></form><br><br>
    <form action="updateCategory.jsp" >
    <button type="submit">Update Category</button></form><br><br>
    <form action="deleteCategory.jsp">
    <button type="submit">Delete Category</button></form><br><br>
    <form action="CategoryList" method="post">
    <button type="submit">Category List</button></form><br><br> 
    <li><a href="admin.jsp">Back to Home Page</a></li>  
</body>
</html>