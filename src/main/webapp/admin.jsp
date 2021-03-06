<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Admin</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="admin.jsp">Welcome Admin</a>
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

	<c:if test="${not empty message}">
		<h1
			style="color: red; background-color: white; font-size: 25px; float: left;">${message}</h1>
	</c:if>
</body>
</html>


