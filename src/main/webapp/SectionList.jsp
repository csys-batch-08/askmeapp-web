<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.chainsys.impl.SectionDAOImpl"%>  
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Section List</title>
</head>
<body style="background-color:powderblue;">
  <h1> Section List</h1>
   
<%  
		SectionDAOImpl sectionDao=new SectionDAOImpl();
        ResultSet rs=sectionDao.showAllSection();
		%>
	
   		<table border="2">
			<thead>
				<tr>
				  <th >Section Name</th>
				   <th >Category Id</th>
				   <th>Status</th>
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
					  <td><%=rs.getInt(3) %></td>	
					  <td><%=rs.getString(5) %></td>	
					
			</tr>
					
			<%} %>
					</tbody>
		           </table><br><br>
 <li><a href="Admin.jsp">Back to Home Page</a></li>
</body>
</html>