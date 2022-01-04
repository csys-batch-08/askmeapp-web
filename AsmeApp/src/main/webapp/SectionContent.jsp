<%@page import="java.io.FileReader"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.ResultSet"%>
<%@page import="com.askme.dao.SectionDAOImpl"%>
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
    <%      int secid = Integer.parseInt(request.getParameter("secid"));
		%>
    <div id="container">
        <div id=header>
      <img src="images/simpleform.png">
      <ul>
          <li><a href="ReadMore.jsp" style=color:white>About Us</a></li>
          <li><a href="AskmeQuestion.jsp?sectionid=<%=secid%>" style=color:white>Ask a question</a></li>
          
         
      </ul>
    </div>
    <div id=head>
<centre>

  <%
 			String content= request.getParameter("sectionname");
						session.setAttribute("sectionName", content);%>
            <a href="<%=content %>.pdf"><%=content %></a>
         
        <form action="UserRatingServlet">   
        <h2><b>Place Your Rating</b></h2>
        <h3>From 1....10 </h3>
        <table>
            <thead>
                <tr>
                    <th><input type="text" name="rating" ></th>                   
                </tr>
            </thead>
        </table>
        <button type="submit">Submit Rating</button>
    </form>
     </form>
     <h2><li><a href="Comments.jsp?section_id=<%=secid%>">Leave a Reply</a></li></h2>
     <br><br>   
          <li><a href="Index.jsp">Back to Home Page</a></li>
         
      

</body>
</html>