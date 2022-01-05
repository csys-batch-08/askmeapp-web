<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.askme.dao.CategoryDAOImpl"%>   
      <%@page import="com.askme.dao.UserRatingDAOImpl"%>   
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log out</title>
<link rel=stylesheet type=text/css href=css/style.css>
 <style>
       body {
          background-image: url('images/askQuestion.jpg');
        background-repeat: no-repeat;
         background-attachment: fixed;  
         background-size: cover;
          
       }
       box{
       margin-left:550px;
       margin-top:300px;
       
       }
       
       
        </style>
</head>
<body>

 <div id="toolbar">
    </div>
    <div id="container">
        <div id=header>
      <img src="images/simpleform.png">
      <ul>
          <li><a href="Index.jsp" style=color:white>Log out</a></li>        
         
      </ul>
    </div>
    <div id=head>
    
 <form id="box">    
    
<%  
		UserRatingDAOImpl userRatingDao=new UserRatingDAOImpl();
        ResultSet rs=userRatingDao.showRating();
		%>	
   		<table border="5" align="right">
			<thead>
			<tr><th><h2>Frequently viewed Section</h2></th></tr>
				<tr>				
				   <th>Section Name</th>
				   <th>Rating</th>
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<%
				while(rs.next()){				
				%>
				<tr>	
									
					<td><%=rs.getString(1) %></td>	
					<td><%=rs.getInt(2) %></td>		
				
			</tr>					
			<%} %>
					</tbody>
		           </table><br><br>
   </form>
    <center>
   
    
<%  
		CategoryDAOImpl categoryDao=new CategoryDAOImpl();
        ResultSet rs1=categoryDao.showAllCategory();
		%>	
   		<table border="5" align="center"  >
			<thead>
				<td> <h2>Category List</h2></td>
			</thead>
			<br>
			<br>
			<tbody>
				<%
				while(rs1.next()){				
				%>
				<tr>	
									
					<td><a href="SectionDetails.jsp?cusid=<%=rs1.getInt(1)%>"><%=rs1.getString(2)%></a></td>		
				
			</tr>					
			<%} %>
					</tbody>
		           </table><br><br>
  </center> 
</body>
</html>