<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.ResultSet"%>
<%@page import="com.askmeapp.impl.SectionDAOImpl"%>
<%@page import="com.askmeapp.impl.UserRatingDAOImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Section Content</title>
<link rel=stylesheet type=text/css href=assets/css/style.css>
<style>
*{margin:0;
padding:0;}
 #box{
     margin-right:10px;
     padding:50px;}
      #box1{
     margin-left:-10px;  
    padding-left:150px;
     margin-top:-100px;   
    }
       table, th, td {
                border: 2px solid black;
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
     <%String content= request.getParameter("sectionname");
    int section_id= Integer.parseInt(request.getParameter("id1"));
						session.setAttribute("sectionName", content);
						session.setAttribute("secid",section_id);%>
            
   
    <div id="container">
        <div id=header>
      <img src="assets/images/simpleform.png">
      <ul>
            <li><a href="UserHome.jsp" style=color:white> Home </a></li>
            <li><a href="ReadMore.jsp" style=color:white>About Us</a></li>          	  
           <li><a href="AskmeQuestion.jsp?id3=<%=section_id%>"style=color:white>Ask a question</a></li>
            <li> <a href="Comments.jsp" style=color:white>Leave a Reply</a></li>         
      </ul>
    </div>
    <div id=head>

<form id="box">
 <%  
		UserRatingDAOImpl userRatingDao=new UserRatingDAOImpl();
        ResultSet rs2=userRatingDao.showRating();
		%>	
 <table  align="right">
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
  <form id="box1" action="UserRatingServlet" method="post">   
     
      <label>Click To Read a File: </label> 
      <a href="<%=content %>.pdf"><%=content %></a><br><br>
     <center>   
       <h2><b>Place Your Rating</b></h2>
        <h3>From 1....10 </h3>
        <input type="text" name="rating" pattern="[0-9]{1,10}" >                   
                
        <button type="submit">Submit Rating</button>
        </center>
    </form>
   
    
    
        

</body>
</html>