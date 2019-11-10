<jsp:useBean id="employee" scope="request" type="efrei.m1.se.model.User"/>
<tr>
	<td>
		<input type="radio" name="employeeId" value="${employee.dbId}" />
	</td>
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