<jsp:include page="aheader.jsp"></jsp:include>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<div class="card shadow">
	<div class="card-body">
		<h4 class="p-2" style="border-bottom:2px solid green;">Consultancies</h4>
		<table class="table table-bordered table-sm">
			<thead>
				<tr>
					<th>Consultancy type</th>
					<th>price (in rupees)</th>
					</tr>
			</thead>
			<tbody>
				<c:forEach var="s" items="${consultancies }">
					<tr>
					<td>${s.consultansytype }</td>
					<td>${s.price }</td>
					
					</tr>
				</c:forEach>
			</tbody>
		</table>	
	</div>
</div>

<jsp:include page="footer.jsp"></jsp:include>