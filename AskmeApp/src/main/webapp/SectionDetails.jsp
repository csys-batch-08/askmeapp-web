<%@page import="java.sql.ResultSet"%>
<%@page import="com.askme.dao.SectionDAOImpl"%>
<%@page import="com.askme.dao.UserRatingDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Section Details</title>
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
          <li><a href="ReadMore.jsp" style=color:white>About Us</a></li>
          
         
      </ul>
    </div>
    <div id=head>
  

 <%  
		UserRatingDAOImpl userRatingDao=new UserRatingDAOImpl();
        ResultSet rs2=userRatingDao.showRating();
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
				while(rs2.next()){				
				%>
				<tr>	
									
					<td><%=rs2.getString(1) %></td>	
					<td><%=rs2.getInt(2) %></td>		
				
			</tr>					
			<%} %>
					</tbody>
		           </table><br><br>
<%int cid = Integer.parseInt(request.getParameter("cusid"));
 session.setAttribute("category_id", cid);
SectionDAOImpl sectionDAOImpl = new SectionDAOImpl();
ResultSet rs = sectionDAOImpl.showSectionName(cid);
 %>		           
<table border="2" align="left">
			<thead>
				<tr>
				   <th >Section Name</th>
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
				<%
				while(rs.next()){				
				%>
				<tr>	
									
					<td><a href="SectionContent.jsp?id1=<%=rs.getInt(1)%>&sectionname=<%=rs.getString(2)%>"><%=rs.getString(2)%></a></td>
					
				
			</tr>
					
			<%} %>
					</tbody>
		           </table><br><br>


</body>
</html>