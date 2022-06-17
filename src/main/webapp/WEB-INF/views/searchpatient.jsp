<jsp:include page="aheader.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-5 mx-auto mt-2">
				<div class="card shadow">
					<div class="card-header text-center">
						<h5>Search Patient</h5>
					</div>
					<div class="card-body">
						<form method="post" action="searchpatientbyid">
							
							<div class="form-row">
								<label class="col-sm-4 col-form-label">Enter Patient ID</label>
								<div class="col-sm-8">
									<input type="text" name="patientid"   class="form-control form-control-sm" />
								</div>
							</div>
													
							<input type="submit" value="Search"
								class="btn btn-primary float-right px-4">
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp"></jsp:include>