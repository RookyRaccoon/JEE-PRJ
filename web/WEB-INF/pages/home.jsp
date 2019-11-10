<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<!--
	=========================================================
	* ArchitectUI HTML Theme Dashboard - v1.0.0
	=========================================================
	* Product Page: https://dashboardpack.com
	* Copyright 2019 DashboardPack (https://dashboardpack.com)
	* Licensed under MIT (https://github.com/DashboardPack/architectui-html-theme-free/blob/master/LICENSE)
	=========================================================
	* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
-->
<head>
	<jsp:include page="../components/head-content.jsp"/>

<%--	<script src="https://kit.fontawesome.com/05417d287a.js" crossorigin="anonymous"></script>--%>  <!-- TODO: determine if needed -->

	<title>Employees</title>
</head>
<body>
<div class="app-container app-theme-white body-tabs-shadow fixed-sidebar closed-sidebar closed-sidebar-mobile fixed-header">

	<jsp:include page="../components/header.jsp" />


	<div class="app-main">
		<!-- Sidebar -->
		<div class="app-sidebar sidebar-shadow">
			<jsp:include page="../components/sidebar-start.jsp" />

			<div class="scrollbar-sidebar">
				<div class="app-sidebar__inner">
					<ul class="vertical-nav-menu">
						<li class="app-sidebar__heading">Employees management</li>
						<li class="mm-active">
							<a href="#">
								<i class="metismenu-icon pe-7s-users"></i>
								List of employees
							</a>
						</li>

						<li>
							<a href="${addUserUrl}">
								<i class="metismenu-icon pe-7s-add-user"></i>
								Add a user
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<!-- Main content -->
		<div class="app-main__outer">
			<div class="app-main__inner">
				<div class="app-page-title">
					<div class="page-title-wrapper">

						<!-- Page title -->
						<div class="page-title-heading">
							<div class="page-title-icon">
								<i class="pe-7s-users icon-gradient bg-happy-itmeo"></i>
							</div>
							<div>
								<span>
									List of employees
								</span>
							</div>
						</div>
						<div class="page-title-actions">
							<!-- "Add a user" button -->
							<button type="button" data-toggle="tooltip" title="Add a user" data-placement="left" class="btn-shadow mr-lg-3 btn btn-dark" onclick="window.location.href='${addUserUrl}'">
								<i class="pe-7s-add-user pe-2x align-middle"></i>
							</button>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-12">
						<form method="get" class="main-card mb-3 card">
							<div class="card-body">
								<h5 class="card-title">Employees</h5>
								<div class="table-responsive">
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
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>

							<div class="card-footer">
								<input type="submit" formaction="${deleteUserUrl}" value="Delete" class="btn btn-outline-danger mr-1" />
								<input type="submit" formaction="${userDetailsUrl}" value="Details" class="btn btn-outline-secondary mx-1" />
								<a href="${addUserUrl}" class="btn btn-outline-primary ml-1">Add</a>
							</div>
						</form>
					</div>
				</div>
			</div>


			<jsp:include page="../components/footer.jsp" />
		</div>
	</div>
</div>
<script type="text/javascript" src="${architectUI}/assets/scripts/main.js"></script>
</body>
</html>
