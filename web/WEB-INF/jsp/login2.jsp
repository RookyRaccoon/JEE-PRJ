<c:url var="architectUI" value="/static/architect-ui"/>

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
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Language" content="en">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no"/>

	<link href="${architectUI}/main.css" rel="stylesheet">

	<link rel="stylesheet" href="${architectUI}/pe-icon-7-stroke/css/pe-icon-7-stroke.css"/>
	<link rel="stylesheet" href="${architectUI}/pe-icon-7-stroke/css/helper.css"/>

	<script src="https://kit.fontawesome.com/05417d287a.js" crossorigin="anonymous"></script>

	<title>Employees</title>
</head>
<body>
<div class="app-container app-theme-white body-tabs-shadow fixed-sidebar closed-sidebar closed-sidebar-mobile fixed-header">

	<!-- Header -->
	<div class="app-header header-shadow">

		<div class="app-header__mobile-menu">
			<div>
				<button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
          <span class="hamburger-box">
            <span class="hamburger-inner"></span>
          </span>
				</button>
			</div>
		</div>

		<!-- Mobile header content -->
		<div class="app-header__menu">
      <span>
	      <!-- Mobile disconnect button -->
        <button type="button" class="btn-icon btn-icon-only btn btn-primary btn-sm">
          <span class="btn-icon-wrapper text-center">
            <i class="text-white pe-7s-power pe-inverse pe-2x px-1 align-middle"></i>
          </span>
        </button>
      </span>
		</div>

		<!-- Header content -->
		<div class="app-header__content">
			<div class="app-header-left"></div>
			<div class="app-header-right">
				<div class="header-btn-lg pr-0">
					<div class="widget-content p-0">
						<div class="widget-content-wrapper">
							<div class="widget-content-left mr-4">
								<span>Hello, $username</span>  <!-- TODO: update $username here -->
							</div>
							<div class="widget-content-left">
								<div class="btn-group">
									<!-- Disconnect button -->
									<button type="button" data-toggle="tooltip" title="Disconnect" data-placement="left" class="btn-shadow p-1 btn btn-primary btn-sm">
										<i class="text-white pe-7s-power pe-2x p-1 align-middle"></i>
									</button>
								</div>
							</div>
							<div class="widget-content-right header-user-info ml-3"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div class="app-main">
		<!-- Sidebar -->
		<div class="app-sidebar sidebar-shadow">
			<div class="app-header__logo">
				<div class="header__pane ml-auto">
					<div>
						<button type="button" class="hamburger close-sidebar-btn hamburger--elastic" data-class="closed-sidebar">
              <span class="hamburger-box">
                <span class="hamburger-inner"></span>
              </span>
						</button>
					</div>
				</div>
			</div>

			<div class="app-header__mobile-menu">
				<div>
					<button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
            <span class="hamburger-box">
              <span class="hamburger-inner"></span>
            </span>
					</button>
				</div>
			</div>


			<div class="scrollbar-sidebar">
				<div class="app-sidebar__inner">
					<ul class="vertical-nav-menu">
						<li class="app-sidebar__heading">Employees management</li>  <!-- TODO: update this title -->
						<li class="mm-active">
							<a href="${pageContext.request.contextPath}">
								<i class="metismenu-icon pe-7s-users"></i>
								Users  <!-- TODO: update this title -->
							</a>
						</li>

						<!-- TODO: update this navigation item -->
						<li>
							<a href="${pageContext.request.contextPath}">
								<i class="metismenu-icon pe-7s-note2"></i>
								Dashboard Boxes
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
									Users  <!-- TODO: update page title -->
								</span>
							</div>
						</div>
						<div class="page-title-actions">
							<!-- "Add a user" button -->
							<!-- TODO: make this button navigate to user creation page -->
							<button type="button" data-toggle="tooltip" title="Add a user" data-placement="left" class="btn-shadow mr-lg-3 btn btn-dark">
								<i class="pe-7s-plus pe-2x align-middle"></i>
							</button>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-12">
						<div class="main-card mb-3 card">
							<div class="card-body">
								<h5 class="card-title">Users</h5>  <!-- TODO: update the table header -->
								<div class="table-responsive">
									<!-- TODO: put the right data inside this table -->
									<table class="mb-0 table table-striped table-hover" id="users-table">
										<thead>
											<tr>
												<th>#</th>
												<th>First Name</th>
												<th>Last Name</th>
												<th>Username</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<th scope="row">1</th>
												<td>Mark</td>
												<td>Otto</td>
												<td>@mdo</td>
											</tr>
											<tr>
												<th scope="row">2</th>
												<td>Jacob</td>
												<td>Thornton</td>
												<td>@fat</td>
											</tr>
											<tr>
												<th scope="row">3</th>
												<td>Larry</td>
												<td>the Bird</td>
												<td>@twitter</td>
											</tr>
										</tbody>
									</table>
								</div>
							</div>

							<!-- TODO: bind actions to these buttons -->
							<div class="card-footer">
								<button href="#" class="btn btn-outline-danger mr-1">Delete</button>
								<button href="#" class="btn btn-outline-secondary mx-1">Details</button>
								<button href="#" class="btn btn-outline-primary ml-1">Add</button>
							</div>
						</div>
					</div>
				</div>
			</div>


			<!-- Footer -->
			<div class="app-wrapper-footer">
				<div class="app-footer">
					<div class="app-footer__inner">
						<div class="app-footer-left"></div>
						<div class="app-footer-right">
							<ul class="nav">
								<li class="nav-item">
									<a href="https://github.com/" class="nav-link align-middle" target="_blank">
										<i class="pe-7s-link mr-1 align-bottom"></i>
										<span>Repo</span>
									</a>
								</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript" src="${architectUI}/assets/scripts/main.js"></script>
</body>
</html>
