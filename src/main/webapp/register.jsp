<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
 <style>
  * {
    margin: 0;
    padding:0;
  }
        body {
          background-image: url('assets/images/app.jpg');
          background-repeat: no-repeat;
          background-attachment: fixed;  
          background-size: cover;
          
        }
        </style>
</head>
<body>
 <style>
  
  .container {
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    height: 100vh;
    background-image: url('bg.jpg');
   
  }
  
  .container h1 {
    color: white;
    font-family: sans-serif;
    margin: 20px;
  }
  
  .registartion-form {
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
  
  .registartion-form input,
  .registartion-form select,
  .registartion-form textarea {
    border: none;
    padding: 5px;
    margin-top: 10px;
    font-family: sans-serif;
  }
  
  .registartion-form input:focus,
  .registartion-form textarea:focus {
    box-shadow: 3px 3px 10px rgb(228, 228, 228), -3px -3px 10px rgb(224, 224, 224);
  }
  
  .registartion-form .submit {
    width: 100%;
    padding: 8px 0;
    font-size: 20px;
    color: rgb(44, 44, 44);
    background-color: #ffffff;
    border-radius: 5px;
  }
  
  .registartion-form .submit:hover {
    box-shadow: 3px 3px 6px rgb(255, 214, 176);
  }
</style>
 
  <div class="container">
    <h1 style=color:white>Registration Form</h1>
    <form name="registration" class="registartion-form" action="RegisterServlet"  method="post">
      <table>
      <caption></caption>
      <thead>
      
        <tr>
          <th id="1"><label for="name">User Name:</label></th>
          <th id="2"><input type="text" name="name" id="name"  pattern="[A-Za-z0-9]{3,10}" title="Only enter A-Z ,a-z,0-9 and enter  min 3 to max 40 " required autofocus></th>
        </tr>
        <tr>
          <th id="3"><label for="email">Enter Email:</label></th>
          <th id="4"><input type="text" name="email" id="email"pattern="[a-z0-9]+[@][a-z]+[.][a-z]+"  title="Enter valid email ex(example12@gmail.com)" required></th>
        </tr>
        <tr>
          <th id="5"><label for="password">Enter Password:</label></th>
          <th id="6"><input type="password" name="password" id="password" pattern="((?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Enter atleast one upper case and one lower case and one number ,and atleast 8 or more character"required></th>
        </tr>     
       </thead>
       <tbody>
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>   
        </tbody>   
       
      </table>
    </form>
    <br>
    
      <p style=color:white>Already have an account? <a href="login.jsp" style=color:white>Sign in</a></p>
    </div>

   <c:if test="${not empty invalid}">
<h1 style="color:red;background-color:white;font-size:25px;float:left;">${invalid}</h1>
</c:if>  
  

</body>
</html>