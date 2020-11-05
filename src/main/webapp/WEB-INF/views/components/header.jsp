<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" charset="UTF-8"
	content="width=device-width, initial-scale=1.0">
<%@include file="../commons/css_import.jsp"%>

</head>
<body>
	<header class="blog-header py-3">
		<div
			class="row flex-nowrap justify-content-between align-items-center">
			<div class="col-4">
				<a class="blog-header-logo text-dark" href="#">The online
					article</a>
			</div>
		</div>
	</header>
	<nav class="navbar navbar-expand-lg navbar-light bg-light rounded">
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="/summarization/home"><i class="fas fa-home" style="font-size: 25px;"></i> <span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Categories</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false"> Dropdown link </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="#">Action</a> <a
							class="dropdown-item" href="#">Another action</a> <a
							class="dropdown-item" href="#">Something else here</a>
					</div></li>
				<!-- <li class="nav-item"><input type="text" name="search" placeholder="Search..."></li> -->
				<li class="nav-item ml-5"></li>
			</ul>
			<div class="dropdown mr-4">
				<security:authorize access="!isAuthenticated()">
					<a href="/summarization/login"><button
							class="btn btn-outline-primary mr-2" data-toggle="modal"
							data-target="#myModal">Login</button> </a>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
						Hello, <security:authentication property="principal.username" />
					<a
					class="dropdown-toggle" href="#"
					id="accountControl" role="button" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false">
						<img src="<c:url value="assets/img/avatar/avatar1.png" />" class="avatar">
					</a>
					<div class="dropdown-menu" aria-labelledby="accountControl">
						<a class="dropdown-item" href="/summarization/profile">Profile</a> <a
							class="dropdown-item" href="#">Another action</a> <a
							class="dropdown-item" href="/summarization/logout">Logout</a>
					</div>
<!-- 					<a href="/summarization/logout"><button
							class="btn btn-outline-primary mr-2">Logout</button></a> -->
				</security:authorize>
			</div>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<!-- 						<button class="btn btn-outline-secondary my-2 my-sm-0"
							type="submit">Search</button> -->
			</form>

		</div>
	</nav>
	<%-- <%@ include file="../commons/js_import.jsp" %> --%>
	<script type="text/javascript">
		$("#showModal").on("click", () => {
			$("#myModal").modal({
				backdrop: 'static',
				keyboard : false
			})
		});
	</script>
</body>
</html>