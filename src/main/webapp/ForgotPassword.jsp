<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Forgot Password</title>
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
  
  .forgotpassword {
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
  
  .forgotpassword input,
  .forgotpassword select,
  .forgotpassword textarea {
    border: none;
    padding: 5px;
    margin-top: 10px;
    font-family: sans-serif;
  }
  
  .forgotpassword input:focus,
  .forgotpassword textarea:focus {
    box-shadow: 3px 3px 10px rgb(228, 228, 228), -3px -3px 10px rgb(224, 224, 224);
  }
  
  .forgotpassword .submit {
    width: 100%;
    padding: 8px 0;
    font-size: 20px;
    color: rgb(44, 44, 44);
    background-color: #ffffff;
    border-radius: 5px;
  }
  
  .forgotpassword .submit:hover {
    box-shadow: 3px 3px 6px rgb(255, 214, 176);
  }
</style>

   
  <div class="container">
    <h1 style=color:white>Forgot Password</h1>
    <form name="forgotPassword"  class="forgotpassword" action="ForgotPasswordServlet"  method="post">
      <table>       
        <tr>
          <td><label for="newPassword">Enter  New Password:</label></td>
          <td><input type="password" name="password"  pattern="[A-Za-z0-9]{8,10}" required></td>
        </tr>
        <tr>
          <td><label for="email">Your Email Id:</label></td>
          <td><input type="text" name="email"  pattern="[a-z0-9]+[@][a-z]+[.][a-z]+" required></td>
        </tr>         
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr><br><br>
        
      </table>
      
    </form>	
     
	</div>	
	
</body>
</html>