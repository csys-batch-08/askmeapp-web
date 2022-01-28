<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.chainsys.impl.UserDAOImpl"%>   
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import=" javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subscriber Message</title>
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
          <li><a href="UserHome.jsp" style=color:white> Go Home </a></li>
          <li><a href="ReadMore.jsp" style=color:white>About Us</a></li>
          
         
      </ul>
    </div>
    <div id=head>
  
 <%    int user_Id=Integer.parseInt(session.getAttribute("userid").toString());
		UserDAOImpl userDao=new UserDAOImpl();
		//System.out.println("id"+user_Id);
        ResultSet rs=userDao.showAllSection(user_Id);%>	
		<center> <h2 style=color:yellow>Welcome Subscriber<h1>&#128512;</h1></h2></center>
		
      <table border="5" >
 	<h2 >Recently Post!!!</h2>
			<thead>
			
				<tr>				
				   <th>Section Name<h1>&#128071;</h1></th>
				   
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
						
				
			</tr>					
			<%} %>
					</tbody>
		           </table>
		         
		           
</body>
</html>