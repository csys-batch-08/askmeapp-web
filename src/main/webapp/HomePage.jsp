<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.text.DecimalFormat"%>
     <%@page import="com.chainsys.impl.CategoryDAOImpl"%>   
      <%@page import="com.chainsys.impl.UserRatingDAOImpl"%>   
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
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
     margin-top:-100px;   
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
        ResultSet rs=userRatingDao.showRating();
		%>	
   		<table align="right" >
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
			<%DecimalFormat df = new DecimalFormat("0.00");%>
				<%
				while(rs.next()){	
					Double rating=(double)(rs.getInt(2)/rs.getInt(3));
					double rating1=Double.parseDouble(df.format(rating));
				%>
				<tr>	
									
					<td ><%=rs.getString(1) %></td>	
					<td ><%=rating1%></td>		
				
			</tr>					
			<%} %>
					</tbody>
		           </table><br><br>
   </form>
   
   
  <form id="box1">    
<%  
		CategoryDAOImpl categoryDao=new CategoryDAOImpl();
        ResultSet rs1=categoryDao.showAllCategory();
		%>	
   		<table align="center" >
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
		           </table></form><br><br>
 
</body>
</html>