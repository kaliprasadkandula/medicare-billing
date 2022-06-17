<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Screen</title>
<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/jquery-3.4.1.js"></script>
</head> 
<body style="height:100vh;background-image:url(images/bg.jpg);background-size:100% 100%;">
	<div class="jumbotron text-center p-3 mb-0 bg-transparent shadow text-white rounded-0">
		<h5>Hospital</h5>
		<h6>Register Screen</h6>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-4 mx-auto mt-2">
				<div class="form-row">
					<label class="col-form-label col-sm-4">Select Role</label>
					<div class="col-sm-8">
						<select class="form-control form-control-sm" id="role">
						<option ${param.role ==null ?'selected' : '' }>Select</option>
							<option ${param.role =='User' ? 'selected' : '' }>User</option>
							<option ${param.role =='FrontDesk' ? 'selected' : '' }>FrontDesk</option>
							<!--<option ${param.role =='Patient' ? 'selected' : '' }>Patient</option>
							<option ${param.role =='Doctor' ? 'selected' : '' }>Doctor</option>-->
							
						</select>
					</div>
				</div>
				
				
				
				
				<c:if test="${param.role == 'FrontDesk' }">
				<div class="card shadow">
					<div class="card-header text-center bg-info text-white">
						<h5>FrontDesk Register Screen</h5>
					</div>
					<div class="card-body">					
						<form method="post" action="registerfd">
						<!-- post action goes to admin controller along with all the data -->
							<div class="form-row">
								<label class="col-sm-4 col-form-label">First Name</label>
								<div class="col-sm-8">
									<input type="text" required name="fname" class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label  class="col-sm-4 col-form-label">Last Name</label>
								<div class="col-sm-8">
									<input type="text" required name="lname" class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label  class="col-sm-4 col-form-label">Password</label>
								<div class="col-sm-8">
									<input type="text" required name="pwd" class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label class="col-sm-4 col-form-label">Gender</label>
								<div class="col-sm-8">
									<select name="gender" required class="form-control form-control-sm">
										<option value="">-- select Gender --</option>
										<option value="Male">Male</option>
										<option value="Female">Female</option>
									</select>
								</div>
							</div>
							
							<div class="form-row">
								<label class="col-sm-4 col-form-label">Contact No</label>
								<div class="col-sm-8">
									<input type="text" pattern="[0-9]{10,10}" required name="phone" maxlength="10"
										class="form-control form-control-sm" />
								</div>
							</div>
						   <div class="form-row">
								<label class="col-sm-4 col-form-label">Date of Birth</label>
								<div class="col-sm-8">
									<input type="date" required name="dob" class="form-control form-control-sm" />
								</div>
							</div>
							
							<div class="form-row">
								<label class="col-sm-4 col-form-label">Email</label>
								<div class="col-sm-8">
									<input type="text" required name="email"
										pattern=".+@+.+mail\.com" class="form-control form-control-sm" />
								</div>
							</div>
							
							<div class="form-row">
								<label class="col-sm-4 col-form-label">FrontDesk ID</label>
								<div class="col-sm-8">
									<input type="text" name="frontdeskid" readonly value="${frontdeskid }" class="form-control form-control-sm" />
								</div>
							</div>
							
							
							<input type="submit" value="Register"
								class="btn btn-primary float-right px-4">
						</form>

					</div>
				</div>
				</c:if>
				
				
				<c:if test="${param.role == 'User' }">
				<div class="card shadow">
					<div class="card-header text-center bg-info text-white">
						<h5>User Register Screen</h5>
					</div>
					<div class="card-body">					
						<form method="post" action="registeruser">
						
							<div class="form-row">
								<label class="col-sm-4 col-form-label">First Name</label>
								<div class="col-sm-8">
									<input type="text" required name="fname" class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label  class="col-sm-4 col-form-label">Last Name</label>
								<div class="col-sm-8">
									<input type="text" required name="lname" class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label  class="col-sm-4 col-form-label">Password</label>
								<div class="col-sm-8">
									<input type="text" required name="pwd" class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label  class="col-sm-4 col-form-label">Fav pet</label>
								<div class="col-sm-8">
									<input type="text" required name="favpet" class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label  class="col-sm-4 col-form-label">Fav number</label>
								<div class="col-sm-8">
									<input type="text" required name="favnumber" class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label  class="col-sm-4 col-form-label">Fav colour</label>
								<div class="col-sm-8">
									<input type="text" required name="favcolour" class="form-control form-control-sm" />
								</div>
							</div> 
							<div class="form-row">
								<label class="col-sm-4 col-form-label">User ID</label>
								<div class="col-sm-8">
									<input type="text" name="userid" readonly value="${userid }" class="form-control form-control-sm" />
								</div>
							</div>
							
							
							<input type="submit" value="Register"
								class="btn btn-primary float-right px-4">
						</form>

					</div>
				</div>
				</c:if>
				
				<c:if test="${param.role ne null and param.role =='Patient' }">
				<div class="card shadow">
					<div class="card-header text-center bg-success text-white">
						<h5>Patient Register Screen</h5>
					</div>
					<div class="card-body">					
						<form method="post" action="registerpat">
							<div class="form-row">
								<label class="col-sm-4 col-form-label">First Name</label>
								<div class="col-sm-8">
									<input type="text" name="fname" required class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label class="col-sm-4 col-form-label">Last Name</label>
								<div class="col-sm-8">
									<input type="text" name="lname" required class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label class="col-sm-4 col-form-label">Contact No</label>
								<div class="col-sm-8">
									<input type="text" name="phone" required maxlength="10"
										pattern="[1-9]{1}[0-9]{9}" class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label class="col-sm-4 col-form-label">Address</label>
								<div class="col-sm-8">
									<input type="text" name="address" required
										class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label class="col-sm-4 col-form-label">Date of Birth</label>
								<div class="col-sm-8">
									<input type="date" name="dob" required class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label class="col-sm-4 col-form-label">Patient ID</label>
								<div class="col-sm-8">
									<input type="text" name="patientid" readonly="true" value="${patid }" class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label class="col-sm-4 col-form-label">Password</label>
								<div class="col-sm-8">
									<input type="password" name="pwd" required class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label class="col-sm-4 col-form-label">Gender</label>
								<div class="col-sm-8">
									<select name="gender" required class="form-control form-control-sm">
										<option value="">-- select Gender --</option>
										<option value="Male">Male</option>
										<option value="Female">Female</option>
									</select>
								</div>
							</div>
							<input type="submit" value="Register"
								class="btn btn-primary btn-sm float-right px-4">
						</form>

					</div>
				</div>
				</c:if>
			</div>
		</div>
	</div>
	<script>
	$(function(){
		$("#role").change(function(){
			let role=$(this).val();
			console.log(role);
			if(role==="Patient"){
				location.href="register?role=Patient";
				
			}
			else if(role==="FrontDesk"){
				location.href="register?role=FrontDesk";
				
			}
			else if(role==="User"){
				location.href="register?role=User";
				
			}
			else{
				location.href="register?role=Doctor";
				
			}
		});
	})
	</script>
</body>
</html>