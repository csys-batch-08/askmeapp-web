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
</head>
<body>
<div id="toolbar">
    </div>
    <div id="container">
        <div id=header>
      <img src="images/simpleform.png">
      <ul>
          <li><a href="ReadMore.jsp">About Us</a></li>
          <li><a href="AskQuestion.jsp">Ask a question</a></li>
          <li><a href="Comment.jsp">Comments</a></li>
         
      </ul>
    </div>
    <div id=head>
<%int secid = Integer.parseInt(request.getParameter("secid"));
SectionDAOImpl sectionDAOImpl = new SectionDAOImpl();

%>
  <%
 			String content= request.getParameter("sectionname");
            String file = application.getRealPath("/SectionDetail/") + content+".txt";
            File fileObject = new File(file);

            char data[] = new char[(int) fileObject.length()];
            FileReader filereader = new FileReader(file);

            int charsread = filereader.read(data);
            out.println(new String(data, 0 , charsread));

            filereader.close();
        %>
     
     <br><br>   
          <li><a href="Index.jsp">Back to Home Page</a></li>
         
      

</body>
</html>