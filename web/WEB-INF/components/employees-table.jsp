<table class="mb-0 table table-striped table-hover" id="users-table">
	<thead>
	<tr>
		<c:if test="${sessionScope.isAdmin}">
			<th></th>
		</c:if>
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
		<tr>
			<c:if test="${sessionScope.isAdmin}">
				<td>
					<input type="radio" name="employeeId" value="${employee.dbId}"/>
				</td>
			</c:if>
			<td><c:out value="${employee.surname}" /></td>
			<td><c:out value="${employee.name}" /></td>
			<td><c:out value="${employee.email}" /></td>
			<td><c:out value="${employee.personalPhone}" /></td>
			<td><c:out value="${employee.workPhone}" /></td>
			<td><c:out value="${employee.mobilePhone}" /></td>
			<td><c:out value="${employee.address}" /></td>
			<td><c:out value="${employee.postalCode}" /></td>
			<td><c:out value="${employee.city}" /></td>
		</tr>
	</c:forEach>
	</tbody>
</table>