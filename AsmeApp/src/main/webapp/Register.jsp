<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
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
    <h1 style=color:black>Registration Form</h1>
    <form name="registration" class="registartion-form" action="RegisterServlet" return formValidation()" method="post">
      <table>
        <tr>
          <td><label for="name">User Name:</label></td>
          <td><input type="text" name="name" id="name"  pattern="[A-Za-z0-9]{3,10}"required autofocus></td>
        </tr>
        <tr>
          <td><label for="email">Email:</label></td>
          <td><input type="text" name="email" id="email"pattern="[a-z0-9]+[@][a-z]+[.][a-z]+"required></td>
        </tr>
        <tr>
          <td><label for="password">Password:</label></td>
          <td><input type="password" name="password" id="password" pattern="[A-Za-z0-9]{8,10}"required></td>
        </tr>     
       
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
    </form>
    <br>
    
      <p>Already have an account? <a href="Login.jsp">Sign in</a></p>
    </div>

   
  

</body>
</html>