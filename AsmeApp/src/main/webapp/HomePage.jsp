<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.askme.dao.CategoryDAOImpl"%>   
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel=stylesheet type=text/css href=css/style.css>
 <style>
       body {
          background-image: url('images/askQuestion.jpg');
        background-repeat: no-repeat;
         background-attachment: fixed;  
         background-size: cover;
          
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
          <li><a href="ReadMore.jsp">About Us</a></li>
          <li><a href="AskmeQuestion.jsp">Ask a Question</a></li>
          <li><a href="Comment.jsp">Leave a Reply</a></li>
         
      </ul>
    </div>
    <div id=head>
    <center>
    <h1>Category List</h1>
    
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
									
					<td><a href="SectionDetails.jsp?cusid=<%=rs.getInt(1)%>"><%=rs.getString(2)%></a></td>		
				
			</tr>					
			<%} %>
					</tbody>
		           </table><br><br>
   
</body>
</html>