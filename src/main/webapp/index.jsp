<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" charset="UTF-8"
			content="width=device-width, initial-scale=1.0">
		<title>Articles Management System</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/assets/plugins/bootstrap/css/bootstrap.min.css" />" />
		<link rel="stylesheet" type="text/css" href="<c:url value="/assets/css/styles.css" />" />
	</head>
	<body>
		<div class="container-fluid">
			<h1>Summarization tools</h1>
			<a href="<c:url value="/home" />">Word Frequency</a><br>
			<a href="<c:url value="/frequency" />">Latent Semantic Analysis</a>
		</div>
	</body>
</html>
