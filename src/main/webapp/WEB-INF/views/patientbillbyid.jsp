<jsp:include page="aheader.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="card shadow">
	<div class="card-body">
		
		<h4 class="p-2" style="border-bottom:2px solid green;">Patient Bill Details</h4>
		<c:if test="${msg ne null }">
		<div class="alert text-success font-weight-bold">${msg }</div>
		</c:if>
		<table class="table table-bordered table-sm">
			<thead>
				<tr>
					<th>Patient Id</th>
					<th>consultancy_bill</th>
					<th>room_bill</th>
					<th>service_bill</th>
					<th>medication_bill</th>
					<th>Total_bill</th>
					<th>bill_status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				
					<tr>
					<td>${patient.patientid }</td>
					<td>${patient.consultancy_bill }</td>
					<td>${patient.room_bill}</td>
					<td>${patient.service_bill}</td>
					<td>${patient.medication_bill}</td>
					<td>${patient.consultancy_bill +patient.room_bill+patient.service_bill+patient.medication_bill}</td>
					<td>${patient.bill_status}</td>
					
					<td>
					<c:if test="${sessionScope.role =='FrontDesk' }">
					<a href="editpd?patientid=${patient.patientid }" class="btn btn-primary btn-sm">Edit</a>
					</c:if>
					<c:if test="${sessionScope.role =='User' }">
					<a href="detailpd?patientid=${s.patientid }" class="btn btn-primary btn-sm">Details</a>
					</c:if>
					</td> 
					</tr>
				
			</tbody>
		</table>	
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>