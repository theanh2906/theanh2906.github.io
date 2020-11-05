<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Title</title>
<%@include file="../commons/css_import.jsp"%>
<style type="text/css">

div#OR {
	height: 30px;
	width: 30px;
	border: 1px solid #C2C2C2;
	border-radius: 50%;
	font-weight: bold;
	line-height: 28px;
	text-align: center;
	font-size: 12px;
	float: right;
	position: absolute;
	right: -16px;
	top: 40%;
	z-index: 1;
	background: #DFDFDF;
}
</style>
</head>
<body>
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<!-- <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> -->
<!-- 					<h4 class="modal-title" id="myModalLabel">
						Login/Registration
					</h4> -->
				</div>
				<div class="modal-body">
					<div class="row">
						<div class="col-md-8" style="border-right: 1px dotted #C2C2C2; padding-right: 30px;">
							<!-- Nav tabs -->
							<nav>
							<div class="nav nav-tabs mt-3" id="nav-tab" role="tablist">
								<a class="nav-item nav-link active" 
								   id="nav-login-tab" 
								   data-toggle="tab" 
								   href="#nav-login" 
								   role="tab" 
								   aria-controls="nav-login" 
								   aria-selected="true">Login</a>
								<a class="nav-item nav-link" 
								   id="nav-registration-tab" 
								   data-toggle="tab" 
								   href="#nav-register" 
								   role="tab" 
								   aria-controls="nav-register" 
								   aria-selected="false">Registration</a>
							</div>
							</nav>

							<!-- Tab panes -->
							<div class="tab-content mt-3 mb-3">
								<div class="tab-pane active" id="nav-login">
									<form role="form" class="form-horizontal">
										<div class="form-group">
											<label for="username" class="col-sm-2 control-label">
												Username</label>
											<div class="col-sm-10">
												<input type="text" name="username" class="form-control" id="username"
													placeholder="Username" />
											</div>
										</div>
										<div class="form-group">
											<label for="exampleInputPassword1"
												class="col-sm-2 control-label"> Password</label>
											<div class="col-sm-10">
												<input type="password" name="password" class="form-control"
													id="exampleInputPassword1" placeholder="Password" id="password"/>
											</div>
										</div>
										<div class="row mt-4">
											<div class="col-sm-2"></div>
											<div class="col-sm-10">
												<button type="submit" class="btn btn-primary btn-sm">
													Submit</button>
												<a href="javascript:;" class = "ml-2">Forgot your password?</a>
											</div>
										</div>
									</form>
								</div>
								<div class="tab-pane" id="nav-register">
									<form role="form" class="form-horizontal">
										<div class="form-group">
											<label for="email" class="col-sm-2 control-label">
												Name</label>
											<div class="col-sm-10">
												<div class="row">
													<div class="col-md-3">
														<select class="form-control">
															<option>Mr.</option>
															<option>Ms.</option>
															<option>Mrs.</option>
														</select>
													</div>
													<div class="col-md-9">
														<input type="text" class="form-control" placeholder="Name" />
													</div>
												</div>
											</div>
										</div>
										<div class="form-group">
											<label for="email" class="col-sm-2 control-label">
												Email</label>
											<div class="col-sm-10">
												<input type="email" class="form-control" id="email"
													placeholder="Email" />
											</div>
										</div>
										<div class="form-group">
											<label for="mobile" class="col-sm-2 control-label">
												Mobile</label>
											<div class="col-sm-10">
												<input type="email" class="form-control" id="mobile"
													placeholder="Mobile" />
											</div>
										</div>
										<div class="form-group">
											<label for="password" class="col-sm-2 control-label">
												Password</label>
											<div class="col-sm-10">
												<input type="password" class="form-control" id="password"
													placeholder="Password" />
											</div>
										</div>
										<div class="row mt-4">
											<div class="col-sm-2"></div>
											<div class="col-sm-10">
												<button type="button" class="btn btn-primary btn-sm">
													Save & Continue</button>
												<button type="button" class="btn btn-primary btn-sm">
													Cancel</button>
											</div>
										</div>
									</form>
								</div>
							</div>
							<div id="OR" class="hidden-xs">OR</div>
						</div>
						<div class="col-md-4">
							<div class="row text-center sign-with">
								<div class="col-md-12">
									<h3>Sign in with</h3>
								</div>
								<div class="col-md-12">
									<div class="btn-group btn-group-justified">
										<a href="#" class="btn btn-primary">Facebook</a> <a href="#"
											class="btn btn-danger"> Google</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="../commons/js_import.jsp" %>
</body>
</html>
