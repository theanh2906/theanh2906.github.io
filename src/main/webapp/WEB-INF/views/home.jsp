<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="icon" href="/docs/4.1/assets/img/favicons/favicon.ico">

<title>Blog Template for Bootstrap</title>

<!-- <link rel="canonical" href="https://getbootstrap.com/docs/4.1/examples/blog/"> -->

<!-- Bootstrap core CSS -->
<%@include file="commons/css_import.jsp"%>

<!-- Custom styles for this template -->
<link href="blog.css" rel="stylesheet">
</head>

<body>
	<div class="container">

		<!-- Navbar -->
		<%@ include file="components/header.jsp" %>
		<!-- End Navbar -->
		<div>
			<%@ include file="components/jumbotron.jsp" %>
		</div>
		
		<div class="row mb-2">
			<div class="col-md-6">
				<div class="card flex-md-row mb-4 shadow-sm h-md-250">
					<div class="card-body d-flex flex-column align-items-start">
						<strong class="d-inline-block mb-2 text-primary">World</strong>
						<h3 class="mb-0">
							<a class="text-dark" href="#">Featured post</a>
						</h3>
						<div class="mb-1 text-muted">Nov 12</div>
						<p class="card-text mb-auto">This is a wider card with
							supporting text below as a natural lead-in to additional content.
						</p>
						<a href="#">Continue reading</a>
					</div>
					<img class="card-img-right flex-auto d-none d-lg-block"
						data-src="holder.js/200x250?theme=thumb" alt="Card image cap">
				</div>
			</div>
			<div class="col-md-6">
				<div class="card flex-md-row mb-4 shadow-sm h-md-250">
					<div class="card-body d-flex flex-column align-items-start">
						<strong class="d-inline-block mb-2 text-success">Design</strong>
						<h3 class="mb-0">
							<a class="text-dark" href="#">Post title</a>
						</h3>
						<div class="mb-1 text-muted">Nov 11</div>
						<p class="card-text mb-auto">This is a wider card with
							supporting text below as a natural lead-in to additional content.</p>
						<a href="#">Continue reading</a>
					</div>
					<img class="card-img-right flex-auto d-none d-lg-block"
						data-src="holder.js/200x250?theme=thumb" alt="Card image cap">
				</div>
			</div>
		</div>
	</div>

    <main role="main" class="container">
      <div class="row">
        <div class="col-md-8 blog-main">
	      <c:if test="${not empty message}">
		      <h1>${message}</h1>
		      <hr class="mb-5">
	      </c:if>
        <c:forEach items="${listPost}" var="post">
        	<div class="blog-post">
            <a href="/summarization/home?category=${post.categoryName}"><span id = "cat" class="badge badge-pill p-2" style="background-color: ${post.code};color:white;font-size:14px;font-weight:500">${post.categoryName}</span></a><h2 class="blog-post-title">${post.title}</h2>
            <p class="blog-post-meta"><fmt:formatDate value="${post.createTime}" var="date" type="date" pattern="MMM dd, yyyy HH:mm"/>${date} by <a href="#">${post.author}</a></p>

            <p>${post.abstracts}</p>
            <a href="/summarization/post?id=${post.postId}">Click here to view details...</a>
            <hr>
			<%-- ${article.content} --%>
          </div><!-- /.blog-post -->
        	
        </c:forEach>

 <!--          <div class="blog-post">
            <h2 class="blog-post-title">Another blog post</h2>
            <p class="blog-post-meta">December 23, 2013 by <a href="#">Jacob</a></p>

            <p>Cum sociis natoque penatibus et magnis <a href="#">dis parturient montes</a>, nascetur ridiculus mus. Aenean eu leo quam. Pellentesque ornare sem lacinia quam venenatis vestibulum. Sed posuere consectetur est at lobortis. Cras mattis consectetur purus sit amet fermentum.</p>
            <blockquote>
              <p>Curabitur blandit tempus porttitor. <strong>Nullam quis risus eget urna mollis</strong> ornare vel eu leo. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
            </blockquote>
            <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
            <p>Vivamus sagittis lacus vel augue laoreet rutrum faucibus dolor auctor. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit. Morbi leo risus, porta ac consectetur ac, vestibulum at eros.</p>
          </div>/.blog-post

          <div class="blog-post">
            <h2 class="blog-post-title">New feature</h2>
            <p class="blog-post-meta">December 14, 2013 by <a href="#">Chris</a></p>

            <p>Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Aenean lacinia bibendum nulla sed consectetur. Etiam porta sem malesuada magna mollis euismod. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
            <ul>
              <li>Praesent commodo cursus magna, vel scelerisque nisl consectetur et.</li>
              <li>Donec id elit non mi porta gravida at eget metus.</li>
              <li>Nulla vitae elit libero, a pharetra augue.</li>
            </ul>
            <p>Etiam porta <em>sem malesuada magna</em> mollis euismod. Cras mattis consectetur purus sit amet fermentum. Aenean lacinia bibendum nulla sed consectetur.</p>
            <p>Donec ullamcorper nulla non metus auctor fringilla. Nulla vitae elit libero, a pharetra augue.</p>
          </div>/.blog-post -->

          <nav class="blog-pagination">
            <a class="btn btn-outline-primary" href="#">Older</a>
            <a class="btn btn-outline-secondary disabled" href="#">Newer</a>
          </nav>

        </div><!-- /.blog-main -->

		<%@include file="components/SideBar.jsp"%>

      </div><!-- /.row -->
      

    </main><!-- /.container -->
	<!-- /.container -->
	<%@include file="components/footer.jsp"%>

	<!-- Bootstrap core JavaScript -->
	<%@ include file="commons/js_import.jsp" %>
	<script type="text/javascript">
	  /* AOS.init(); */
	  
	  $("#cat").on("click", function() {
		  console.log(document.getElementById("cat").value);
/* 		  var value = $("#cat").val();
		  window.location.href="/summarization/home?category="+value+""; */
	  })
	</script>
	
</body>
</html>
