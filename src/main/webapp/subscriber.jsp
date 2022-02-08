<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Subscriber</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
#box {
	background-image: linear-gradient(rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.2));
	width: 350px;
	margin-right: 900px;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="admin1.jsp">Welcome Admin</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="login.jsp">Home</a></li>

				<li><a href="SubscriberList">Subscribers</a></li>
				<li><a href="CommentsViewServlet">Comment By User</a></li>
				<li><a href="UserList"> User Details</a></li>
				<li><a href="CategoryList">Category Detail</a></li>
				<li><a href="SectionList">Section Detail</a></li>
				<li><a href="QuestionList">Question Detail</a></li>
				<li><a href="AnswerList">Answer Detail</a></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">Category <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="addCategory.jsp">Add Category</a></li>
						<li><a href="updateCategory.jsp">Update Category</a></li>
						<li><a href="deleteCategory.jsp">Delete Category</a></li>

					</ul></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">Section <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="addSection.jsp">Add Section</a></li>
						<li><a href="updateSection.jsp">Update Section</a></li>
					</ul></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">Question <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="addQuestion.jsp">Add Question</a></li>
						<li><a href="updateQuestion.jsp">Update Question</a></li>
					</ul></li>

				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown">Answer <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="addAnswers.jsp">Add Answer</a></li>
						<li><a href="updateAnswer.jsp">Update Answer</a></li>
					</ul></li>

			</ul>
		</div>
	</nav>


	<h2>Subscriber List</h2>

	<table>
		<caption></caption>
		<thead>
			<tr>
				<th id="1">User Name</th>
				<th id="2">Email</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="SubscriberList" items="${subscriberList}">
				<tr>
					<td>${SubscriberList.name}</td>
					<td>${SubscriberList.emailId}</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

	<c:if test="${not empty message}">
		<h1
			style="color: red; background-color: white; font-size: 25px; float: left;">${message}</h1>
	</c:if>
	<form name="subscriber" action="SubscriberServlet1" method="post">
		<fieldset id="box">
			<legend> Add Recent Section Name</legend>
			<table>
				<caption></caption>
				<thead>
					<tr>
						<th id="1"><label for="name">Enter Section Name</label></th>
						<th id="2"><label id="2"><input type="text" name="sectionName" id="name"
							pattern="[A-Za-z]{10, }" required autofocus></label></th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="2"><label id="3"><input type="submit" class="submit" id="3"/></label></td>
					</tr>
				</tbody>
			</table>
		</fieldset>
	</form>

</body>
</html>