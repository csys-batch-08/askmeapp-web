<%@page import="java.sql.ResultSet"%>
<%@page import="com.askme.dao.SectionDAOImpl"%>
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
  <center>
<%int cid = Integer.parseInt(request.getParameter("cusid"));
 session.setAttribute("category_id", cid);
SectionDAOImpl sectionDAOImpl = new SectionDAOImpl();
ResultSet rs = sectionDAOImpl.showSectionName(cid);
 %>
<table border="2">
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
									
					<td><a href="SectionContent.jsp?secid=<%=rs.getInt(1)%>&sectionname=<%=rs.getString(2)%>"><%=rs.getString(2)%></a></td>
					
				
			</tr>
					
			<%} %>
					</tbody>
		           </table><br><br>


</body>
</html>