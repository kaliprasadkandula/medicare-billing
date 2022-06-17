<jsp:include page="aheader.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-5 mx-auto mt-2">
				<div class="card shadow">
					<div class="card-header text-center">
						<h5>Add FrontDesk</h5>
					</div>
					<div class="card-body">
						<form method="post" action="registerfdbyadmin">
							<div class="form-group form-row">
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
								<label  class="col-sm-4 col-form-label">Email</label>
								<div class="col-sm-8">
									<input type="text" required name="email" class="form-control form-control-sm" />
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
								<label class="col-sm-4 col-form-label">Status</label>
								<div class="col-sm-8">
									<select name="status" required class="form-control form-control-sm">
										<option value="">-- select Status --</option>
										<option value="not approved">Waiting list</option>
										<option value="rejected">reject</option>
										<option value="approved">approve</option>
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
								<label class="col-sm-4 col-form-label">FrontDesk ID</label>
								<div class="col-sm-8">
									<input type="text" name="frontdeskid" readonly value="${frontdeskid }" class="form-control form-control-sm" />
								</div>
							</div>
							
							<input type="submit" value="Submit"
								class="btn btn-primary float-right px-4">
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp"></jsp:include>