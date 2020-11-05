<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="/docs/4.1/assets/img/favicons/favicon.ico">

<title>Blog Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<%@include file="../commons/css_import.jsp"%>

<!-- Custom styles for this template -->

</head>

<body>
	<aside class="col-md-4 blog-sidebar">
		<div class="p-3 mb-3 bg-light rounded">
			<h4 class="font-italic">About</h4>
			<p class="mb-0">
				Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis
				consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla
				sed consectetur.
			</p>
		</div>

		<div class="p-3">
			<h4 class="font-italic">All years</h4>
			<ol class="list-unstyled mb-0">
				<c:forEach items="${listYears}" var="year">
					<li><span class="badge badge-danger">${year.numberOfPosts}</span><a href="/summarization/home?year=${year.year}" class="ml-2"><c:out value="${year.year}"></c:out></a></li>
				</c:forEach>

			</ol>
		</div>

		<div class="p-3">
			<h4 class="font-italic">Categories</h4>
			<ol class="list-unstyled">
			<c:forEach items="${allCategories}" var="category">
				<li><span class="badge badge-danger">${category.numberOfPosts}</span><a href="/summarization/home?category=${category.categoryName}" class="ml-2">${category.categoryName}</a></li>
			</c:forEach>
				
			</ol>
		</div>
	</aside>
	<!-- /.blog-sidebar -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
<%-- 	<script src="<c:url value="/assets/js/holder.min.js" />"></script>
	<script>
		Holder.addTheme('thumb', {
			bg : '#55595c',
			fg : '#eceeef',
			text : 'Thumbnail'
		});
	</script> --%>
</body>
</html>
