<jsp:include page="aheader.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-5 mx-auto mt-2">
				<div class="card shadow">
					<div class="card-header text-center">
						<h5>Edit FrontDesk</h5>
					</div>
					<div class="card-body">
						<form method="post" action="editfdbyadmin">
							<div class="form-row">
								<label class="col-sm-4 col-form-label">FrontDesk ID</label>
								<div class="col-sm-8">
									<input type="text" name="frontdeskid" readonly value="${frontdeskid }" class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label class="col-sm-4 col-form-label">First name</label>
								<div class="col-sm-8">
									<input type="text" name="fname" value="${fname }" class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label class="col-sm-4 col-form-label">Last name</label>
								<div class="col-sm-8">
									<input type="text" name="lname" value="${lname }" class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label class="col-sm-4 col-form-label">Status</label>
								<div class="col-sm-8">
									<select name="status" required class="form-control form-control-sm">
										<option value="not approved">not approved</option>
										<option value="approved">approved</option>
										<option value="rejected">rejected</option>
									</select>
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