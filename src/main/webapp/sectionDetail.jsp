<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang=en>
<head>
<meta charset="ISO-8859-1">
<title>Section Details</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<link rel=stylesheet type=text/css href=assets/css/style1.css>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
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

@import
	url('https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css')
	;

table, thead, tr, tbody, th, td {
	color: white;
	text-align: center;
}

.table td {
	color: white;
	text-align: center;
}
</style>
</head>
<body>
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
	<table class="table">
		<caption></caption>
		<thead>
			<tr>
				<th id="1">Section List</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="SectionList" items="${sectionList}">
				<tr>
					<td><div class="card" style="width: 18rem;">
							<img src="assets/images/${SectionList.sectionName}.jpg"
								class="card-img-top" alt="...">
						</div></td>
					<td>
						<div class="card-body">
							<h5 class="card-title">${SectionList.sectionName}</h5>
							<p class="card-text">${SectionList.description}</p>							<a
								href="SectionContentServlet?secid=${SectionList.sectionId}&sectionname=${SectionList.sectionName}"
								class="btn btn-dark">Go ${SectionList.sectionName}</a>
						</div>
					</td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>