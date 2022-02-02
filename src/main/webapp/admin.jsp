<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
   
</head>
<body style="background-color:powderblue;">
<center><h1>Welcome Admin</h1></center>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  width: 200px;
  background-color: #f1f1f1;
}

li a {
  display: block;
  color: #000;
  padding: 8px 16px;
  text-decoration: none;
}

li a.active {
  background-color:#0099FF;
  color: white;
}

li a:hover:not(.active) {
  background-color: #555;
  color: white;
}
</style>

<ul>
  <li><a class="active" href="Admin.jsp">Home</a></li>
  <li><a href="SubscriberList">Subscribers</a></li>
  <li><a href="user.jsp">User</a></li>
  <li><a href="categories.jsp">Category</a></li>
  <li><a href="section.jsp">Section</a></li>
   <li><a href="question.jsp">Questions</a></li>
    <li><a href="answers.jsp">Answers</a></li>
    <li><a href="CommentsViewServlet">Comment_by_User</a></li>
    <li><a href="login.jsp">Logout</a></li>
</ul>


 
 

    
</body>
</html>