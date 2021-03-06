<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TruYUM</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-sm bg-primary navbar-dark">
			<a class="navbar-brand" href="/truyum-spring-mvc/">TruYum</a>
			<ul class="nav navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link text-white active"
					href="show-menu-list-admin">Menu</a></li>
			</ul>
		</nav>
	</header>
	<div class="container">
	<h1>Edit Menu Item Status</h1>
	<div class="sandsad alert-success"><strong>${success }</strong></div>
	<div class="sandsad alert-danger"><strong>${error }</strong></div>
			
	</div>
	<!-- Footer -->
	<footer
		class="page-footer font-small bg-primary navbar-dark fixed-bottom">
	<!-- Copyright -->
	<div class="footer-copyright text-center py-3">
		� 2020 Copyright: <a class="text-white nounderline"
			href="/truyum-spring-mvc/"> TruYum.com</a>
	</div>
	<!-- Copyright --> </footer>
	<!-- Footer -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>