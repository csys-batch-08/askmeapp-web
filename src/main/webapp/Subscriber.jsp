<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.chainsys.impl.UserDAOImpl"%> 
  <%@page import="com.chainsys.model.User"%>  
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subscriber</title>
</head>
<body style="background-color:powderblue;">
<center><h2>Subscriber List</h2></center>
<%UserDAOImpl userDao=new UserDAOImpl();
   List<User> userList=new ArrayList<User>();
   userList=userDao.subscribeUser();
%>
<table>
<thead>
	<tr>
  		<th>S.no</th>
		<th>User Name</th>
		<th>Email</th>
	</tr>
	</thead>
<tbody>
<%
int i = 0;
for (User user: userList ) {
i++;
%>
<tr>


<td><%=i%></td>
<td> <%=user.getName()%></td>
<td> <%=user.getEmailId()%></td>
</tr>

<%
}
%>
</tbody>
</table>
 <form name="subscriber"  action="SubscriberServlet1"  method="post">
     
      <table>
        <tr>
          <td><label for="name">Recent Section Name</label></td>
          <td><input type="text" name="sectionName" pattern="[A-Za-z]{10, }" required autofocus></td>
        </tr><br><br>
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
      </form>
 <li><a href="Admin.jsp">Back to Home Page</a></li>
</body>
</html>