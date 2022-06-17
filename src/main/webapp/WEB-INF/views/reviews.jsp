<jsp:include page="aheader.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="card shadow">
	<div class="card-body">
		<c:if test="${sessionScope.role =='User' }">
		<a href="/addreview" class="btn btn-primary btn-sm float-right mt-1">Create Review</a>
		</c:if>
		<h4 class="p-2" style="border-bottom:2px solid green;">Reviews</h4>
		<c:if test="${msg ne null }">
		<div class="alert text-success font-weight-bold">${msg }</div>
		</c:if>
		<table class="table table-bordered table-sm">
			<thead>
				<tr>
					<th>user id</th>
					<th>review</th>
					</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${reviews }">
					<tr>
					<td>${s.userid }</td>
					<td>${s.review }</td>
					
					</tr>
				</c:forEach>
			</tbody>
		</table>	
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>