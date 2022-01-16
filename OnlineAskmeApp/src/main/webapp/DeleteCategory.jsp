<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.askmeapp.impl.CategoryDAOImpl"%>   
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Category</title>
</head>
<body style="background-color:powderblue;">
    <h1>Delete Category</h1>
    <p>CategoryList</p>
<%  
		CategoryDAOImpl categoryDao=new CategoryDAOImpl();
        ResultSet rs=categoryDao.showAllCategory();
		%>
	
   		<table border="2">
			<thead>
				<tr>
				   <th >Category Name</th>
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<%
				while(rs.next()){				
				%>
				<tr>	
					 <td><%=rs.getString(2) %></td>					
					
			</tr>
					
			<%} %>
					</tbody>
		           </table><br><br>
		           
 <form name="category" class="category" action="DeleteCategoryServlet"  method="post">
     
      <table>
        <tr>
          <td><label for="name">Enter Category Name</label></td>
          <td><input type="text" name="CategoryName" pattern="[A-Za-z]{10, }" required autofocus></td>
        </tr><br>
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
      </form>
       <li><a href="Admin.jsp">Back to Home Page</a></li>
</body>
</html>