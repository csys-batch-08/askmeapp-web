<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <title>Login</title>
  <style>
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
  * {
    margin: 0
  }
  
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
  
  .loginform {
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
  
  .loginform input,
  .loginform select,
  .loginform textarea {
    border: none;
    padding: 5px;
    margin-top: 10px;
    font-family: sans-serif;
  }
  
  .loginform input:focus,
  .loginform textarea:focus {
    box-shadow: 3px 3px 10px rgb(228, 228, 228), -3px -3px 10px rgb(224, 224, 224);
  }
  
  .loginform .submit {
    width: 100%;
    padding: 8px 0;
    font-size: 20px;
    color: rgb(44, 44, 44);
    background-color: #ffffff;
    border-radius: 5px;
  }
  
  .loginform .submit:hover {
    box-shadow: 3px 3px 6px rgb(255, 214, 176);
  }
</style>
	<c:if test="${not empty invalid}">
<h1 style="color:red;background-color:white;font-size:25px;float:left;">${invalid}</h1>
</c:if>
   
  <div class="container">
    <h1 style=color:white>Login</h1>
    <form name="login" class="loginform" action="LoginServlet" >
      <table>
      <caption></caption>  
      <thead>
      <th id="1"></th></thead> 
      <tbody>    
        <tr>
          <td><label for="email">Enter Email</label></td>
          <td><input type="text" name="email" id="email" pattern="[a-z0-9]+[@][a-z]+[.][a-z]+" title="Enter valid email ex(example12@gmail.com)" required></td>
        </tr>
        <tr>
          <td><label for="password">Enter Password:</label></td>
          <td><input type="password" name="password" id="password" pattern="((?=.*\d)(?=.*[@#$%*!^()_+])(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Enter atleast one upper case and one lower case and one number ,and atleast 8 or more character" required></td>
        </tr>         
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>
       </tbody> 
      </table>
      
    </form>	
      <div>
       <a href="forgotPassword.jsp" style=color:white>Forgot password?</a>
       </div>
	</div>	
	
		
</body>
</html>