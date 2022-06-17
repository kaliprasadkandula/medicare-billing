<jsp:include page="aheader.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="card shadow">
	<div class="card-body">
	<c:if test="${sessionScope.role =='User' }">
		<a href="/addticket" class="btn btn-primary btn-sm float-right mt-1">Create Ticket</a>
		</c:if>
		<h4 class="p-2" style="border-bottom:2px solid green;">Tickets</h4>
		<c:if test="${msg ne null }">
		<div class="alert text-success font-weight-bold">${msg }</div>
		</c:if>
		<table class="table table-bordered table-sm">
			<thead>
				<tr>
					<th>user id</th>
					<th>query</th>
					<th>resolution</th>
					<c:if test="${sessionScope.role =='Admin' }">
					<th>Action</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${tickets }">
					<tr>
					<td>${s.userid }</td>
					<td>${s.query }</td>
					<td>${s.resolution }</td>
					<c:if test="${sessionScope.role =='Admin' }">
					<td>
					
					<a href="edittkt?userid=${s.userid }" class="btn btn-primary btn-sm">Resolve</a>
					
					</td>
					</c:if>
					</tr>
				</c:forEach>
			</tbody>
		</table>	
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>