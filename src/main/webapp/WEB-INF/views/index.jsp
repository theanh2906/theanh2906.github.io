<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" charset="UTF-8"
	content="width=device-width, initial-scale=1.0">
<title>Summarization</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/plugins/bootstrap/css/bootstrap.min.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="/assets/css/styles.css" />" />
</head>
<body>
	<div class="container-fluid">
		<h1>Summarization tools</h1>
		<form:form method="POST"
			action="${pageContext.request.contextPath}/home/submit"
			modelAttribute="input" acceptCharset="UTF-8">
			<div class="form-group">
				<label for="textInput">Input your text here: </label>
				<form:textarea id="textInput" path="textInput" class="form-control"
					rows="7"></form:textarea>
			</div>
			<div class="form-group">
				<label for="sentenceNum">Number of sentences: </label>
				<form:input type="text" path="sentenceNum" />
			</div>
			<div class="form-group">
				<label for="textOutput">Output: </label>
				<textarea id="textOutput" class="form-control" rows="7" readonly><c:out
						value="${requestScope.summary }"></c:out></textarea>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
			<form:button type="reset" class="btn btn-primary">Reset</form:button>
		</form:form>
	</div>
</body>