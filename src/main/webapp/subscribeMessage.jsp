<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Subscriber Message</title>
<link rel=stylesheet type=text/css href=assets/css/style1.css>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity=''></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity=''></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	background-image: url('assets/images/plain.jpg');
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
}

h1 {
	text-align: center;
}

h2 {
	text-align: center;
}

.container {
	text-align: center;
	width: 800px;
	height: 200px;
	margin-left: 550px;
	padding-top: 25px;
}
</style>
</head>
<body>
	<div id="toolbar"></div>
	<div id="toolbar"></div>
	<div class="w-auto p-3">
		<nav class="navbar navbar-dark bg-success">
			<div class="container-fluid">
				<a href="#" class="navbar-brand"> <img
					src="assets/images/simpleform.png" height="100" alt="Show Image">
				</a>
				<button type="button" class="navbar-toggler"
					data-bs-toggle="collapse" data-bs-target="#navbarCollapse">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarCollapse">
					<div class="navbar-nav">
						<a href="userHome.jsp" class="nav-item nav-link">Home</a> <a
							href="readMore.jsp" class="nav-item nav-link">About Us</a> <a
							href="MostViewedSectionServlet" class="nav-item nav-link">Frequently
							viewed Section</a> <a href="#" class="nav-item nav-link disabled"
							tabindex="-1">Ask a Question</a>
					</div>
					<div class="navbar-nav ms-auto">
						<a href="index.jsp" class="nav-item nav-link">Logout</a> <a
							href="#" class="nav-item nav-link"></a> <a href="#"
							class="nav-item nav-link"></a>
					</div>
				</div>
			</div>
		</nav>
	</div>
	<h2 style="color: yellow">
		Welcome Subscriber
		<h1>&#128512;</h1>
	</h2>
	<div class="container">
		<form action="UserSubscriber" method="post">
			<button type="submit" class="button">Recently Post!!!</button>
		</form>
	</div>

</body>
</html>