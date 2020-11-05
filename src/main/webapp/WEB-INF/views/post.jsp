<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="icon" href="/docs/4.1/assets/img/favicons/favicon.ico">
		<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"	rel="stylesheet">
		<title>Blog Template for Bootstrap</title>
	
		<!-- Bootstrap core CSS -->
		<%@include file="commons/css_import.jsp"%>
	
		<!-- Custom styles for this template -->
		<style>

			.heading {
			  font-size: 25px;
			  margin-right: 25px;
			}
			
			.fa {
			  font-size: 25px;
			}
			
			.checked {
			  color: orange;
			}
			
			/* Three column layout */
			.side {
			  float: left;
			  width: 15%;
			  margin-top:10px;
			}
			
			.middle {
			  margin-top:10px;
			  float: left;
			  width: 70%;
			}
			
			/* Place text to the right */
			.right {
			  text-align: right;
			}
			
			/* Clear floats after the columns */
			.row:after {
			  content: "";
			  display: table;
			  clear: both;
			}
			
			/* The bar container */
			.bar-container {
			  width: 100%;
			  background-color: #f1f1f1;
			  text-align: center;
			  color: white;
			}
			
			/* Individual bars */
			.bar-5 {height: 18px; background-color: #4CAF50;}
			.bar-4 {height: 18px; background-color: #2196F3;}
			.bar-3 {height: 18px; background-color: #00bcd4;}
			.bar-2 {height: 18px; background-color: #ff9800;}
			.bar-1 {height: 18px; background-color: #f44336;}
			
			/* Responsive layout - make the columns stack on top of each other instead of next to each other */
			@media (max-width: 400px) {
			  .side, .middle {
			    width: 100%;
			  }
			  .right {
			    display: none;
			  }
			}
		</style>
	
	</head>

	<body>
		<main role="main" class="container">
		<%@ include file="components/header.jsp" %>
			<div class="row mt-5">
				<div class="col-md-8 blog-main">
					<div class="blog-post">
						<h2 class="blog-post-title">${post.title}</h2>
						<p class="blog-post-meta">
							<fmt:formatDate value="${post.createTime}" var="date" type="date" pattern="MMM dd, yyyy HH:mm"/>${date} by <a href="#">${post.author}</a>
						</p>
	
						<p>This blog post shows a few different types of content that's
							supported and styled with Bootstrap. Basic typography, images, and
							code are all supported.</p>
						<hr>
						${post.content}
					</div>
					<!-- /.blog-post -->
					<p>Ratings:</p>
					<%-- <span><%@ include file="components/Rating.jsp"%></span> --%>
	
					<!-- Begin comment text box -->
					<div class="form-group" style="margin-bottom: 70px;">
						<textarea class="form-control mb-2"
							placeholder="Write you comment here" rows="3"></textarea>
						<button type="submit"
							class="btn btn-primary form-control col-3 float-right">Submit</button>
					</div>
					<!-- End comment text box -->
					<hr>
					<!-- Begin user review -->
					<div class="p-4 mb-10">
						<div class="row">
							<div class="side">
								<div>★★★★★</div>
							</div>
							<div class="middle">
								<div class="bar-container">
									<div class="bar-5" style="width: ${listPercentage.star_5}"></div>
								</div>
							</div>
							<div class="side right">
								<div>${listRating.star_5}</div>
							</div>
							<div class="side">
								<div>★★★★</div>
							</div>
							<div class="middle">
								<div class="bar-container">
									<div class="bar-4" style="width: ${listPercentage.star_4}"></div>
								</div>
							</div>
							<div class="side right">
								<div>${listRating.star_4}</div>
							</div>
							<div class="side">
								<div>★★★</div>
							</div>
							<div class="middle">
								<div class="bar-container">
									<div class="bar-3" style="width: ${listPercentage.star_3}"></div>
								</div>
							</div>
							<div class="side right">
								<div>${listRating.star_3}</div>
							</div>
							<div class="side">
								<div>★★</div>
							</div>
							<div class="middle">
								<div class="bar-container">
									<div class="bar-2" style="width: ${listPercentage.star_2}"></div>
								</div>
							</div>
							<div class="side right">
								<div>${listRating.star_2}</div>
							</div>
							<div class="side">
								<div>★</div>
							</div>
							<div class="middle">
								<div class="bar-container">
									<div class="bar-1" style="width: ${listPercentage.star_1}"></div>
								</div>
							</div>
							<div class="side right">
								<div>${listRating.star_1}</div>
							</div>
						</div>
					</div>
					<!-- End user review -->
					<hr>
					<!-- Begin comment show -->
				<div class="card mt-5">
				<c:forEach items = "${listComments}" var = "comment">
					<div class="card-body">
						<div class="row">
							<div class="col-md-2">
								<img src="https://image.ibb.co/jw55Ex/def_face.jpg"
									class="img img-rounded img-fluid" />
								<p class="text-secondary text-center">${comment.createTime}</p>
							</div>
							<div class="col-md-10">
								<p>
									<a class="float-left" href="/summarization/profile/${comment.username}"><strong>${comment.username}</strong></a> 
<!-- 										<span class="float-right"><i
										class="text-warning fa fa-star"></i></span> <span class="float-right"><i
										class="text-warning fa fa-star"></i></span> <span class="float-right"><i
										class="text-warning fa fa-star"></i></span> <span class="float-right"><i
										class="text-warning fa fa-star"></i></span> -->

								</p>
								<div class="clearfix"></div>
								<p>${comment.content}</p>
								<!--                         <p>
                            <a class="float-right btn btn-outline-primary ml-2"> <i class="fa fa-reply"></i> Reply</a>
                            <a class="float-right btn text-white btn-danger"> <i class="fa fa-heart"></i> Like</a>
                        </p> -->
							</div>
						</div>
						<c:forEach items = "${comment.replies}" var = "reply">
	                 <div class="card card-inner ml-3">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-2">
                                <img src="https://image.ibb.co/jw55Ex/def_face.jpg" class="img img-rounded img-fluid"/>
                                <p class="text-secondary text-center">15 Minutes Ago</p>
                            </div>
                            <div class="col-md-10">
                                <p><a href="/summarization/profile/${reply.username}"><strong>${reply.username}</strong></a></p>
                                <p>${reply.content}</p>
<!--                                 <p>
                                    <a class="float-right btn btn-outline-primary ml-2">  <i class="fa fa-reply"></i> Reply</a>
                                    <a class="float-right btn text-white btn-danger"> <i class="fa fa-heart"></i> Like</a>
                                </p> -->
                            </div>
                        </div>
                    </div>
                </div>
                </c:forEach>
					</div>
					<!-- /.card-body -->
					<hr>			
				</c:forEach>
				</div>
				<!-- /.card -->

					<!-- End comment show -->
	
					<!--           <nav class="blog-pagination">
	            <a class="btn btn-outline-primary" href="#">Older</a>
	            <a class="btn btn-outline-secondary disabled" href="#">Newer</a>
	          </nav> -->
	
				</div>
				<!-- /.blog-main -->
				<%@include file="components/SideBar.jsp"%>
			</div>
			<!-- /.row -->
	
	
		</main>
	
		<!-- Bootstrap core JavaScript
	    ================================================== -->
		<!-- Placed at the end of the document so the pages load faster -->
<%-- 		<script>
			window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')
		</script>
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
		<script	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
		<script	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		<script src="<c:url value="/assets/js/holder.min.js" />"></script>
		<script>
			Holder.addTheme('thumb', {
				bg : '#55595c',
				fg : '#eceeef',
				text : 'Thumbnail'
			});
		</script> --%>
		<%@ include file="commons/js_import.jsp" %>
	</body>
</html>
