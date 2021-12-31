<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <title>Login</title>
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
<%
String loggedInAsAdmin = (String) session.getAttribute("LOGGED_IN_ADMIN");
String loggedInAsUser = (String) session.getAttribute("LOGGED_IN_USER");
String error  = (String) session.getAttribute("Error");
%>		
   
  <div class="container">
    <h1 style=color:black>Login</h1>
    <form name="login" class="login-form" action="Login" onclick="Validation()" method="post">
      <table>
       
        <tr>
          <td><label for="email">Enter Email Id:</label></td>
          <td><input type="text" name="email" id="email" placeholder="your email"required></td>
        </tr>
        <tr>
          <td><label for="password">Enter Password:</label></td>
          <td><input type="password" name="password" id="password" required></td>
        </tr>         
        <tr>
          <td colspan="2"><input type="submit" class="submit" /></td>
        </tr>      
       
      </table>
    
				
				<%
			
			String emailId = request.getParameter("email");%>
			
		  <% 
      	if(error!=null){%>
      		        <p><%= session.getAttribute("Error")%> </p>

      	<%} %>

        <% session.removeAttribute("Error");%>	
		
  
  
  
   
   </form>
   </div> 
     <script>
		    function validation()
		    {
		    	let emailId = document.getElementById("email").value;
		    	
		    	
		    if(emailId == "")
		    {
		    	 alert("Please enter the Email Id");  
                 
		    }
		    else 	
		    {
		    	return true;
		    }
		         
		    return false;  
		    }
		
    <br>
</body>
</html>