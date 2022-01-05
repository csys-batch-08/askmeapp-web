<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.ResultSet"%>
<%@page import="com.askme.dao.SectionDAOImpl"%>
<%@page import="com.askme.dao.UserRatingDAOImpl"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel=stylesheet type=text/css href=css/style.css>
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
      <img src="images/simpleform.png">
      <ul>
          <li><a href="ReadMore.jsp" style=color:white>About Us</a></li>
          <li><a href="AskmeQuestion.jsp?id3=<%=section_id%>"style=color:white>Ask a question</a></li>
          
         
      </ul>
    </div>
    <div id=head>
<centre>

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
      <center>  
      <label>Click To Read a File</label> 
      <a href="<%=content %>.pdf"><%=content %></a>
        <form action="UserRatingServlet">   
        <h2><b>Place Your Rating</b></h2>
        <h3>From 1....10 </h3>
        <table>
            <thead>
                <tr>
                    <th><input type="text" name="rating" pattern="[0-9]{1,10}" ></th>                   
                </tr>
            </thead>
        </table>
        <button type="submit">Submit Rating</button>
    </form>
    </center>
    
     <h3><a href="Comments.jsp">Leave a Reply</a></h3>
     <br><br>   
          <li><a href="Logout.jsp">Back to Home Page</a></li>
         
      

</body>
</html>