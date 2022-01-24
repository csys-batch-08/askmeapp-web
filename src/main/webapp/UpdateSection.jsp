<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@page import="com.chainsys.impl.SectionDAOImpl"%>  
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:powderblue;">
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
		           
 <form name="section"  action="UpdateSectionServlet"  method="post">
     
      <table>
        <tr>
          <td><label for="name">Enter old Section Name</label></td>
          <td><input type="text" name="oldSectionName" pattern="[A-Za-z]{10, }"  required autofocus></td>
        </tr><br>
         <tr>
          <td><label for="name">Enter New Section Name</label></td>
          <td><input type="text" name="newSectionName"  pattern="[A-Za-z]{10, }" required autofocus></td>
        </tr>
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
    </form>
     <li><a href="Admin.jsp">Back to Home Page</a></li>
</body>
</html>