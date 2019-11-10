<table class="mb-0 table table-striped table-hover" id="users-table">
	<thead>
	<tr>
		<th></th>
		<th>First Name</th>
		<th>Last Name</th>
		<th>Email</th>
		<th>Home phone</th>
		<th>Work phone</th>
		<th>Mobile phone</th>
		<th>Address</th>
		<th>ZIP Code</th>
		<th>City</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${requestScope.employees}" var="employee" varStatus="status">
		<jsp:include page="./employees-table-row.jsp" />
	</c:forEach>
	</tbody>
</table>