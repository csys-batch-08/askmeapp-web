<%@page import="java.sql.ResultSet"%>
<%@page import="com.askmeapp.impl.SectionDAOImpl"%>
<%@page import="com.askmeapp.impl.UserRatingDAOImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Section Details</title>
<link rel=stylesheet type=text/css href=assets/css/style.css>
 <style>
  *{
 margin:0;
 padding:0;}
       body {
          background-image: url('assets/images/cloud.jpg');
        background-repeat: no-repeat;
         background-attachment: fixed;  
         background-size: cover;
          
       }
       #box{
     margin-right:10px;
     padding:100px;}
      #box1{
     margin-left:-10px;  
    padding-left:150px;
     margin-top:-200px;   
    }
     
      table, th, td {
                border: 2px solid white;
                text-align:center;
            }
            th, td {
                padding: 12px;
                background-color:none;
            }
            .title{
            padding-left:600px;}
    
        </style>
</head>
<body>
 <div id="toolbar">
    </div>
    <div id="container">
        <div id=header>
      <img src="assets/images/simpleform.png">
      <ul>
          <li><a href="UserHome.jsp" style=color:white> Home </a></li>
          <li><a href="ReadMore.jsp" style=color:white>About Us</a></li>
          
         
      </ul>
    </div>
    <div id=head>
  
<form id="box">
 <%  
		UserRatingDAOImpl userRatingDao=new UserRatingDAOImpl();
        ResultSet rs2=userRatingDao.showRating();
		%>	
 <table border="5" align="right">
 	<h2 class="title" align="center">Frequently viewed Section</h2>
			<thead>
			
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
		           </table></form><br><br>
<%int cid = Integer.parseInt(request.getParameter("cusid"));
 session.setAttribute("category_id", cid);
SectionDAOImpl sectionDAOImpl = new SectionDAOImpl();
ResultSet rs = sectionDAOImpl.showSectionName(cid);
 %>	<form id="box1">           
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

</form>	
</body>
</html>