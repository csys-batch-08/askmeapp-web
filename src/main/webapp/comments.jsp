<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Comments</title>
<link rel=stylesheet type=text/css href=assets/css/style.css>
<style>
       body {
          background-image: url('assets/images/master1.jpg');
        background-repeat: no-repeat;
         background-attachment: fixed;  
         background-size: cover;
          
       }
   
</style>
</head>
<body>

<style>
    
  * {
    margin: 0
  }
  
  .container {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    height: 100vh;
   
   
  }
  
  .container h1 {
    color: white;
    font-family: sans-serif;
    margin: 20px;
  }
  
  .comment {
    display: flex;
    justify-content: center;
    align-items: center;
    width: 600px;
    color: rgb(255, 255, 255);
    font-size: 18px;
    font-family: sans-serif;
    background-color:crimson;
    padding: 20px;
  }
  
  .comment input,
  .comment select,
  .comment textarea {
    border: none;
    padding: 5px;
    margin-top: 10px;
    font-family: sans-serif;
  }
  
  .comment input:focus,
  .comment textarea:focus {
    box-shadow: 3px 3px 10px rgb(228, 228, 228), -3px -3px 10px rgb(224, 224, 224);
  }
  
  .comment .submit {
    width: 100%;
    padding: 8px 0;
    font-size: 20px;
    color: rgb(44, 44, 44);
    background-color: #ffffff;
    border-radius: 5px;
  }
  
  .comment .submit:hover {
    box-shadow: 3px 3px 6px rgb(255, 214, 176);
  }
</style>
<div id="toolbar">
    </div>
    <div id="container">
        <div id=header>
      <img src="assets/images/simpleform.png">
      <ul>
         
          <li><a href="userHome.jsp" style=color:white>Home</a></li>
           <li><a href="index.jsp" style=color:white>Logout</a></li>
         
         
      </ul>
    </div>
    <div id=head> 
   <div class="container">	
 <form name="comment" action="CommentServlet"  method="post">
  
      <table>
        <tr>
          <td><label for="name" style=color:white>Enter your Comments:</label></td>
          <td><input type="text" name="comment" pattern="[A-Za-z]{10,}+" required autofocus></td>
        </tr>      
        <tr>
       <td colspan="2"><input type="submit" class="submit" />Click</td>  
        </tr>      
       
      </table>
      </div>
   </form>
   
    </div>	
   <a href="userHome.jsp">Back to Home Page</a>
</body>
</html>