<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.chainsys.impl.CategoryDAOImpl"%>   
     <%@page import="com.chainsys.impl.SectionDAOImpl"%>   
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Section</title>
</head>
<body style="background-color:powderblue;">
 
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
 <form name="section"  action="AddSectionServlet"  method="post">
     
      <table>
       <tr>
          <td><label for="name">Select your Category Name</label></td>
          <td><input type="text" name="selectCategoryName" pattern="[A-Za-z]{10, }"required autofocus></td>
        </tr>
        <tr>
          <td><label for="name">Enter Section Name</label></td>
          <td><input type="text" name="sectionName"  pattern="[A-Za-z]{10, }"required autofocus></td>
        </tr>
        <tr>
       <td> <label for="picture">Image</label></td>
       <td><input type="file" name="picture" ></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>             
      </table>
    </form>
 <li><a href="Admin.jsp">Back to Home Page</a></li>
</body>
</html>