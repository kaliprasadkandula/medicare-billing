<jsp:include page="aheader.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-5 mx-auto mt-2">
				<div class="card shadow">
					<div class="card-header text-center">
						<h5>Resolve Ticket</h5>
					</div>
					<div class="card-body">
						<form method="post" action="edittktbyadmin">
							<div class="form-row">
								<label class="col-sm-4 col-form-label">User ID</label>
								<div class="col-sm-8">
									<input type="text" name="userid" readonly value="${userid }" class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label class="col-sm-4 col-form-label">Query</label>
								<div class="col-sm-8">
									<input type="text" name="query" readonly value="${query }" class="form-control form-control-sm" />
								</div>
							</div>
							<div class="form-row">
								<label class="col-sm-4 col-form-label">Resolution</label>
								<div class="col-sm-8">
								<textarea name="resolution" class="form-control form-control-sm" placeholder="enter resolution here"></textarea>
									
								</div>
							</div>
							
							
							<input type="submit" value="Save"
								class="btn btn-primary float-right px-4">
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="footer.jsp"></jsp:include>