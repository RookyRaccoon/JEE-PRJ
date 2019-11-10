<jsp:useBean id="employee" scope="request" type="efrei.m1.se.model.User"/>

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
	<jsp:include page="../components/head-content.jsp" />

	<title>Employee Details</title>
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
						<li class="">
							<a href="${homeUrl}">
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
								<i class="pe-7s-user icon-gradient bg-happy-itmeo"></i>
							</div>
							<div>
								<span>
									Details of employee <c:out value="${employee.surname} ${employee.name}" />
								</span>
							</div>
						</div>
						<div class="page-title-actions">
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-12">
						<div class="main-card mb-3 card">
							<div class="card-body p-5">
								<form action="#" method="post" class="row">
									<div class="form-group col-12 col-lg-6">
										<label for="lastname-input">Last name</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text">
													<i class="pe-7s-user"></i>
												</span>
											</div>
											<input id="lastname-input" name="lastname" value="${fn:escapeXml(employee.name)}" type="text" class="form-control form-control-lg" placeholder="Doe" required />
										</div>
									</div>

									<div class="form-group col-12 col-lg-6">
										<label for="firstname-input">First name</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text">
													<i class="pe-7s-user"></i>
												</span>
											</div>
											<input id="firstname-input" name="firstname" value="${fn:escapeXml(employee.surname)}" type="text" class="form-control form-control-lg" placeholder="John" required />
										</div>
									</div>

									<div class="form-group col-12 col-lg-4">
										<label for="homephone-input">Home phone</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text">
													<i class="pe-7s-call"></i>
												</span>
											</div>
											<input id="homephone-input" name="homephone" value="${fn:escapeXml(employee.personalPhone)}" type="tel" class="form-control" placeholder="0112345678" required />
										</div>
									</div>

									<div class="form-group col-12 col-lg-4">
										<label for="mobilephone-input">Mobile phone</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text">
													<i class="pe-7s-phone"></i>
												</span>
											</div>
											<input id="mobilephone-input" name="mobilephone" value="${fn:escapeXml(employee.mobilePhone)}" type="tel" class="form-control" placeholder="0612345678" required />
										</div>
									</div>

									<div class="form-group col-12 col-lg-4">
										<label for="workphone-input">Work phone</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text">
													<i class="pe-7s-call"></i>
												</span>
											</div>
											<input id="workphone-input" name="workphone" value="${fn:escapeXml(employee.workPhone)}" type="tel" class="form-control" placeholder="0912345678" required />
										</div>
									</div>

									<div class="form-group col-12 col-lg-6">
										<label for="address-input">Address</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text">
													<i class="pe-7s-home"></i>
												</span>
											</div>
											<input id="address-input" name="address" value="${fn:escapeXml(employee.address)}" type="text" class="form-control" placeholder="742 Evergreen Terrace" required />
										</div>

									</div>

									<div class="form-group col-5 col-lg-2">
										<label for="zipcode-input">ZIP Code</label>
										<input id="zipcode-input" name="zipcode" value="${fn:escapeXml(employee.postalCode)}" type="text" class="form-control" placeholder="89011" required />
									</div>

									<div class="form-group col-7 col-lg-4">
										<label for="city-input">City</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text">
													<i class="pe-7s-map"></i>
												</span>
											</div>
											<input id="city-input" name="city" value="${fn:escapeXml(employee.city)}" type="text" class="form-control" placeholder="Springfield" required />
										</div>
									</div>

									<div class="form-group col-12 col-lg-8">
										<label for="email-input">Email</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text">@</span>
											</div>
											<input id="email-input" name="email" value="${fn:escapeXml(employee.email)}" type="email" class="form-control form-control-lg" placeholder="jdoe@mail.com" required />
										</div>
									</div>

									<div class="form-group col-12 text-center text-md-right">
										<a href="${homeUrl}" class="btn btn-lg btn-outline-secondary mx-2 px-3">Cancel</a>
										<input type="submit" value="Save" class="btn btn-primary btn-lg px-4" />
									</div>
								</form>
							</div>
						</div>
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
