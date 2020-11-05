<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.rate {
	height: 46px;
	padding: 0 10px;
}

.rate:not(:checked)>input {
	position: absolute;
	/* top: -9999px; */
}

.rate:not(:checked)>label {
	float: right;
	width: 1em;
	overflow: hidden;
	white-space: nowrap;
	cursor: pointer;
	font-size: 30px;
	color: #ccc;
}

.rate:not(:checked)>label:before {
	content: '★ ';
}

.rate>input:checked ~ label {
	color: #ffc700;
}

.rate:not(:checked)>label:hover, .rate:not(:checked)>label:hover ~ label
	{
	color: #deb217;
}

.rate>input:checked+label:hover, .rate>input:checked+label:hover ~ label,
	.rate>input:checked ~ label:hover, .rate>input:checked ~ label:hover ~
	label, .rate>label:hover ~ input:checked ~ label {
	color: #c59b08;
}
</style>
</head>
<body>
	<div class="rate">
		<input type="radio" id="star5" name="rate" value="5" /> <label
			for="star5" title="text">5 stars</label> <input type="radio"
			id="star4" name="rate" value="4" /> <label for="star4" title="text">4
			stars</label> <input type="radio" id="star3" name="rate" value="3" /> <label
			for="star3" title="text">3 stars</label> <input type="radio"
			id="star2" name="rate" value="2" /> <label for="star2" title="text">2
			stars</label> <input type="radio" id="star1" name="rate" value="1" /> <label
			for="star1" title="text">1 star</label>
	</div>
</body>
</html>
