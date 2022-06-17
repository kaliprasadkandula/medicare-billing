<jsp:include page="aheader.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-5 mx-auto mt-2">
				<div class="card shadow">
					<div class="card-header text-center">
						<h5>Add Patient</h5>
					</div>
					<div class="card-body">
						<form method="post" action="registerpatientbyuser">
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
								<label class="col-sm-4 col-form-label">Date of Birth</label>
								<div class="col-sm-8">
									<input type="date" required name="dob" class="form-control form-control-sm" />
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
								<label class="col-sm-4 col-form-label">Patient ID</label>
								<div class="col-sm-8">
									<input type="text" name="patientid" readonly value="${patientid }" class="form-control form-control-sm" />
								</div>
							</div>
							<c:if test="${sessionScope.role =='User' }">
							<div class="form-row">
								<label class="col-sm-4 col-form-label">User ID</label>
								<div class="col-sm-8">
									<input type="text" name="userid" readonly value="${userid }" class="form-control form-control-sm" />
								</div>
							</div>
							 </c:if>
	  
								<div class="form-row">
								<label  class="col-sm-4 col-form-label">Address</label>
								<div class="col-sm-8">
									<input type="text" required name="address" class="form-control form-control-sm" />
								</div>
							</div>
								<div class="form-row">
								<label  class="col-sm-4 col-form-label">Symptoms</label>
								<div class="col-sm-8">
									<input type="text" required name="symptoms" class="form-control form-control-sm" />
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