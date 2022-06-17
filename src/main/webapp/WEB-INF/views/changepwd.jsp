<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Screen</title>
<link rel="stylesheet" href="css/bootstrap.css">
</head>
<body style="height:100vh;background-image:url(images/bg.jpg);background-size:100% 100%;">
<div class="jumbotron text-center p-4 mb-0 bg-transparent text-black rounded-0 shadow">
	<h5>Hospital</h5>
	<h6>Login Screen</h6>
</div>
<div class="container-fluid">
	<div class="row">
		<div class="col-sm-4 mx-auto mt-5">
		
			<div class="card shadow bg-transparent">
				<div class="card-header text-center bg-info text-white">
					<h5>Change PWD</h5>
				</div>
				<div class="card-body">
				
				<!--goes to admin controller when login button pressed-->
				
					<form method="post" action="savechanges">
						<div class="form-group">
						<label>User ID</label>
						<input type="text" name="userid" readonly value=${userid }  class="form-control">
						</div>
						<div class="form-group">
						<label>Enter new pwd </label>
						<input type="text" name="pwd"  value=${user.pwd} required class="form-control">
						</div>
												
						
						<input type="submit" value="save changes" class="btn btn-primary float-right px-4">
						
					</form>
					<div class="clearfix"></div>
					<c:if test="${msg ne null }">
						<div class="alert text-success font-weight-bold">${msg }</div>
					</c:if>
					<c:if test="${error ne null }">
						<div class="alert text-danger font-weight-bold">${error }</div>
					</c:if>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>