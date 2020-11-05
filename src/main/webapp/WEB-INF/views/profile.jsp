<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Personal Profile</title>
<%@ include file="commons/css_import.jsp"%>
<link rel="stylesheet" href="<c:url value = "assets/css/profile.css"/>">
</head>
<body>
<div class="container p-0">

    <h1 class="h3 mb-3">Personal Profile</h1>

    <div class="row">
        <div class="col-md-5 col-xl-4">

            <div class="card">
                <div class="card-header">
                    <h5 class="card-title mb-0">Profile Settings</h5>
                </div>

                <div class="list-group list-group-flush" role="tablist">
                    <a class="list-group-item list-group-item-action active" data-toggle="list" href="#account" role="tab">
                      Account
                    </a>
                    <a class="list-group-item list-group-item-action" data-toggle="list" href="#password" role="tab">
                      Change Password
                    </a>
                    <a class="list-group-item list-group-item-action" data-toggle="list" href="#manageposts" role="tab">
                      Manage Posts
                    </a> 
                    <a class="list-group-item list-group-item-action" href="/summarization/logout">
                      Log out
                    </a>
                </div>
            </div>
                 <div class="list-group list-group-flush p-2">
					<table class="table">
						<tr>
							<td class="text-bold"><strong>Posts</strong></td>
							<td class="text-right">${numberOfPosts}</td>
						</tr>
						<tr>
							<td class="text-bold"><strong>Likes</strong></td>
							<td class="text-right">0</td>
						</tr>
						<tr>
							<td class="text-bold"><strong>Shares</strong></td>
							<td class="text-right">0</td>
						</tr>
						<tr>
							<td class="text-bold"><strong>Followers</strong></td>
							<td class="text-right">0</td>
						</tr>						
					</table>
                </div>
        </div>

        <div class="col-md-7 col-xl-8">
            <div class="tab-content">
<!--############################################## START ACCOUNT TAB ##############################################-->            
                <div class="tab-pane fade show active" id="account" role="tabpanel">
                    <div class="card">
                        <div class="card-header">
                            <h5 class="card-title mb-0">Public info</h5>
                        </div>
                        <div class="card-body">
                            <form>
                                <div class="row">
                                    <div class="col-md-8">
                                        <div class="form-group">
                                            <label for="inputUsername">Username</label>
                                            <input type="text" class="form-control" id="inputUsername" placeholder="Username" value="<security:authentication property="principal.username" />" readonly>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputUsername">Biography</label>
                                            <textarea rows="2" class="form-control" id="inputBio" placeholder="Tell something about yourself"></textarea>
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="text-center">
                                            <img alt="Andrew Jones" src="<c:url value = "assets/img/avatar/avatar1.png"/>" class="rounded-circle img-responsive mt-2" width="128" height="128">
                                            <div>
                                                <span class="btn btn-primary mt-3">Upload</span>
                                            </div>
                                            <small>For best results, use an image at least 128px by 128px in .jpg format</small>
                                        </div>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary">Save changes</button>
                            </form>

                        </div>
                    </div>

                    <div class="card">
                        <div class="card-header">
                            <h5 class="card-title mb-0">Private info</h5>
                        </div>
                        <div class="card-body">
                            <form>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputFirstName">Full name</label>
                                        <input type="text" class="form-control" id="inputFirstName" placeholder="First name" value="${profile.fullname}">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputFirstName">Email</label>
                                        <input type="text" class="form-control" id="inputFirstName" placeholder="Email" value="${profile.email}">
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputLastName">Address</label>
                                        <input type="text" class="form-control" id="inputLastName" placeholder="Address" value="${profile.address}">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputCity">Date of birth</label>
                                        <input type="date" class="form-control" id="inputCity" value="${date}">
                                    </div>
                                </div>
                                <div class="form-row">
                                <fmt:formatDate value="${profile.dob}" var="date" type="date" pattern="yyyy-MM-dd"/>
                                </div>
                                <button type="submit" class="btn btn-primary w-5">Edit</button>
                                <button type="submit" class="btn btn-primary">Save changes</button>
                            </form>

                        </div>
                    </div>
                    
                    <div class="card">
                    	<div class="card-header">
                    		<h5 class="card-title mb-0">Follow</h5>
                    	</div>
                    	
                    </div>
                </div>
<!--############################################## END ACCOUNT TAB ##############################################-->    
<!--############################################## START PASSWORD TAB ##############################################-->
                <div class="tab-pane fade" id="password" role="tabpanel">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Change Password</h5>

                            <form>
                                <div class="form-group">
                                    <label for="inputPasswordCurrent">Current password</label>
                                    <input type="password" class="form-control" id="inputPasswordCurrent">
                                    <small><a href="#">Forgot your password?</a></small>
                                </div>
                                <div class="form-group">
                                    <label for="inputPasswordNew">New password</label>
                                    <input type="password" class="form-control" id="inputPasswordNew">
                                </div>
                                <div class="form-group">
                                    <label for="inputPasswordNew2">Verify password</label>
                                    <input type="password" class="form-control" id="inputPasswordNew2">
                                </div>
                                <button type="submit" class="btn btn-primary">Save changes</button>
                            </form>

                        </div>
                    </div>
                </div>
<!--############################################## END PASSWORD TAB ##############################################-->
<!--############################################## START MANAGE POSTS TAB ##############################################-->
                <div class="tab-pane fade" id="manageposts" role="tabpanel">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">Manage Posts</h5>
							<hr>
							<input class="form-control col-3 float-right mb-3" type="text" placeholder="Search" aria-label="Search"  id="myInput" onkeyup="myFunction()">
                            <form method="post" action="/summarization/delete" enctype="application/json">
								<table class="table" id="myTable">
									<tr>
										<th width="5%">#</th>
										<th width="65%">Title</th>
										<th width="20%">Created date</th>
										<th width="10%">Status</th>
										<!-- <th width="15%">Delete</th> -->
									</tr>
									<c:forEach items="${listPosts}" var="post">
										<tr>
											<td><input type="checkbox" id="index" class="mt-3" value="${post.postId}" name="index"></td>
											<td><a href="/summarization/post?id=${post.postId}">${post.title}</a></td>
											<td>${post.createTime}</td>
											<td>${post.statusName}</td>
											<td>
											<!-- <div class="btn-group">
					
											</div>

											</td> -->
										</tr>
									</c:forEach>
								</table>
 								<button type="submit" class="btn btn-primary mt-2 float-right col-2">Delete</button>
                            </form>

                        </div>
                    </div>
                </div>
<!--############################################## START MANAGE POSTS TAB ##############################################-->
            </div>
        </div>
    </div>

</div>
	<%@ include file="commons/js_import.jsp"%>
	<script>
		function myFunction() {
		  // Declare variables
		  var input, filter, table, tr, td, i, txtValue;
		  input = document.getElementById("myInput");
		  filter = input.value.toUpperCase();
		  table = document.getElementById("myTable");
		  tr = table.getElementsByTagName("tr");
		
		  // Loop through all table rows, and hide those who don't match the search query
		  for (i = 0; i < tr.length; i++) {
		    td = tr[i].getElementsByTagName("td")[1];
		    if (td) {
		      txtValue = td.textContent || td.innerText;
		      if (txtValue.toUpperCase().indexOf(filter) > -1) {
		        tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    }
		  }
		}
	</script>
</body>
</html>
