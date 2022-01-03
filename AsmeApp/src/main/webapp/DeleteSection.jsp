<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.askme.dao.SectionDAOImpl"%>  
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Section</title>
</head>
<body>
	 <h1>Update Section</h1>
    <p>Section List</p>
<%  
		SectionDAOImpl sectionDao=new SectionDAOImpl();
        ResultSet rs=sectionDao.showAllSection();
		%>
	
   		<table border="2">
			<thead>
				<tr>
				  <th >Section Name</th>
				   <th >Category Id</th>
				   
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
					
			</tr>
					
			<%} %>
					</tbody>
		           </table><br><br>
<form name="section"  action="DeleteSectionServlet"  method="post">
     
      <table>
        <tr>
          <td><label for="name">Enter Section Name</label></td>
          <td><input type="text" name="SectionName"  placeholder="SectionName"required autofocus></td>
        </tr><br>
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
      </form>	
</body>
</html>