<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel=stylesheet type=text/css href=assets/css/style.css>
 <style>
 *{
 margin:0;
 padding:0;}
       body {
         background-image: url('assets/images/cloud.jpg');
         background-repeat: no-repeat;
         background-attachment: fixed;  
         background-size: cover;
          
       }
         #box{
     margin-right:10px;
     padding:100px;}
      #box1{
     margin-left:-10px;  
    padding-left:150px;
     margin-top:-100px;   
    }
     
      table, th, td {
                border: 2px solid white;
                text-align:center;
            }
            th, td {
                padding: 12px;
                background-color:none;
            }
            .title{
            padding-left:600px;}
    
       
        </style>
</head>
<body>

 <div id="toolbar">
    </div>
    <div id="container">
        <div id=header>
      <img src="assets/images/simpleform.png">
      <ul>
         <li><a href="userHome.jsp" style=color:white> Home </a></li>
          <li><a href="readMore.jsp" style=color:white>About Us</a></li>
          
         
      </ul>
    </div>
    <div id=head>
    
 <form id="box">    
    

   		<table align="right" >
   		<h2 class="title" align="center">Frequently viewed Section</h2>
			<thead>
			
				<tr>				
				   <th>Section Name</th>
				   <th>Rating</th>
				</tr>
			</thead>
			<br>
			<br>
			<tbody>
			
			<c:forEach var="userRatingList"  items="${userRatingList}">
			
			 <c:set var = "rate"  value="${userRatingList.rating/userRatingList.rateCount}" />			
				<tr>
				<td>${userRatingList.sectionName}</td>
				<td>${rate}</td>
				    				
			</tr>
					</c:forEach>		
				
					</tbody>
		           </table><br><br>
   </form>
   
   
  <form id="box1">    
	
   		<table align="center" >
			<thead>
				<td> <h2>Category List</h2></td>
			</thead>
			<br>
			<br>
			<tbody>
				<c:forEach var="userCategoryList" items="${userCategoryList}">
				<tr>
				
					 <td><a href="SectionDetails.jsp?cusid=${userCategoryList.categoryId}">${userCategoryList.categoryName}</a></td>					
				    		
				    				
			</tr>
					</c:forEach>						
						
			
					</tbody>
		           </table></form><br><br>
 
</body>
</html>