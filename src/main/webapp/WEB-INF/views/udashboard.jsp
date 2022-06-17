<jsp:include page="aheader.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="card shadow">
	<div class="card-body">
		<c:if test="${sessionScope.role =='User' }">
		<a href="/patientregbyuser" class="btn btn-primary btn-sm float-right mt-1">Create Patient</a>
		</c:if>
		<h4 class="p-2" style="border-bottom:2px solid green;">Patients</h4>
		<c:if test="${msg ne null }">
		<div class="alert text-success font-weight-bold">${msg }</div>
		</c:if>
		<table class="table table-bordered table-sm">
			<thead>
				<tr>
					<th>Id</th>
					<th>first Name</th>
					<th>last Name</th>
					<th>Gender</th>
					<th>Symptoms</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${users }">
					<tr>
					<td>${s.patientid }</td>
					<td>${s.fname }</td>
					<td>${s.lname }</td>
					<td>${s.gender }</td>
					<td>${s.symptoms }</td>
					
					<!-- <td>
					<c:if test="${sessionScope.role =='Admin' }">
					<a href="editfd?frontdeskid=${s.frontdeskid }" class="btn btn-primary btn-sm">Edit</a>
					</c:if>
					<c:if test="${sessionScope.role =='Patient' }">
					<a href="detailds?frontdeskid=${s.frontdeskid }" class="btn btn-primary btn-sm">Details</a>
					</c:if>
					</td> -->
					</tr>
				</c:forEach>
			</tbody>
		</table>	
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>