<jsp:include page="aheader.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="card shadow">
	<div class="card-body">
		<h4 class="p-2" style="border-bottom:2px solid green;">Patients List</h4>
		<c:if test="${msg ne null }">
		<div class="alert text-success font-weight-bold">${msg }</div>
		</c:if>
		<table class="table table-bordered table-sm">
			<thead>
				<tr>
					<th>User Id</th>
					<th>User Name</th>
					<th>Date of Birth</th>
					<th>Address</th>
					<th>Gender</th>
					<c:if test="${sessionScope.role =='Doctor' }">
					<th>Action</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${users }">
					<tr>
						<td>${u.patientid }</td>
						<td>${u.fname } ${u.lname }</td>
						<td>${u.dob }</td>
						<td>${u.address }</td>
						<td>${u.gender }</td>
						<c:if test="${sessionScope.role =='Doctor' }">
							<td>
								<a href="/doctests?patid=${u.patientid }" class="btn btn-primary btn-sm">Test Details</a>
								<a href="/treatment?pid=${u.patientid }&pname=${u.fname} ${u.lname}" class="btn btn-primary btn-sm">Add Treatment</a>
							</td>
						</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
	</div>
</div>


<jsp:include page="footer.jsp"></jsp:include>