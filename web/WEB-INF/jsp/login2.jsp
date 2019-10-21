<c:url var="architectUI" value="/static/architect-ui"/>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Language" content="en">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<title>Employees</title>
	<meta name="viewport"
	      content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no, shrink-to-fit=no"/>
	<meta name="description" content="Tables are the backbone of almost all web applications.">
	<meta name="msapplication-tap-highlight" content="no">
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
	<link href="${architectUI}/main.css" rel="stylesheet">

	<link rel="stylesheet" href="${architectUI}/pe-icon-7-stroke/css/pe-icon-7-stroke.css"/>
	<link rel="stylesheet" href="${architectUI}/pe-icon-7-stroke/css/helper.css"/>

	<script src="https://kit.fontawesome.com/05417d287a.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="app-container app-theme-white body-tabs-shadow fixed-sidebar closed-sidebar">

	<!-- Header -->
	<div class="app-header header-shadow">
		<div class="app-header__logo">
			<div class="logo-src"></div>
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

		<!-- Mobile header -->
		<div class="app-header__mobile-menu">
			<div>
				<button type="button" class="hamburger hamburger--elastic mobile-toggle-nav">
          <span class="hamburger-box">
            <span class="hamburger-inner"></span>
          </span>
				</button>
			</div>
		</div>

		<div class="app-header__menu">
      <span>
	      <!-- Mobile disconnect button -->
        <button type="button" class="btn-icon btn-icon-only btn btn-primary btn-sm">
          <span class="btn-icon-wrapper">
            <i class="text-white pe-7s-power pe-2x pr-1 pl-1"></i>
          </span>
        </button>

      </span>
		</div>

		<div class="app-header__content">
			<div class="app-header-left"></div>
			<div class="app-header-right">
				<div class="header-btn-lg pr-0">
					<div class="widget-content p-0">
						<div class="widget-content-wrapper">
							<div class="widget-content-left">
								<div class="btn-group">

									<!-- Disconnect button -->
									<button type="button" class="btn-shadow p-1 btn btn-primary btn-sm show-toastr-example">
										<i class="text-white pe-7s-power pe-2x pr-1 pl-1"></i>
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

			<div class="app-header__menu">
        <span>
          <button type="button" class="btn-icon btn-icon-only btn btn-primary btn-sm mobile-toggle-header-nav">
            <span class="btn-icon-wrapper">
              <i class="fa fa-ellipsis-v fa-w-6"></i>
            </span>
          </button>
        </span>
			</div>


			<div class="scrollbar-sidebar">
				<div class="app-sidebar__inner">
					<ul class="vertical-nav-menu">
						<li class="app-sidebar__heading">Sidebar section title</li>
						<li class="mm-active">
							<a href="${pageContext.request.contextPath}">
								<i class="metismenu-icon pe-7s-users"></i>
								Users
							</a>
						</li>

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
								Users
								<div class="page-title-subheading">
									List of users of the company.
								</div>
							</div>
						</div>
						<div class="page-title-actions">
							<button type="button" data-toggle="tooltip" title="Example Tooltip" data-placement="bottom" class="btn-shadow mr-3 btn btn-dark">
								<i class="fa fa-star"></i>
							</button>
						</div>
					</div>
				</div>

				<div class="row">
					<div class="col-12">
						<div class="main-card mb-3 card">
							<div class="card-body">
								<h5 class="card-title">Table striped</h5>
								<div class="table-responsive">
									<table class="mb-0 table table-striped table-hover">
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
						</div>
					</div>
				</div>
			</div>


			<!-- Footer -->
			<div class="app-wrapper-footer">
				<div class="app-footer">
					<div class="app-footer__inner">
						<div class="app-footer-left">
							<ul class="nav">
								<li class="nav-item">
									<a href="javascript:void(0);" class="nav-link">
										Footer Link 1
									</a>
								</li>
								<li class="nav-item">
									<a href="javascript:void(0);" class="nav-link">
										Footer Link 2
									</a>
								</li>
							</ul>
						</div>
						<div class="app-footer-right">
							<ul class="nav">
								<li class="nav-item">
									<a href="javascript:void(0);" class="nav-link">
										Footer Link 3
									</a>
								</li>
								<li class="nav-item">
									<a href="javascript:void(0);" class="nav-link">
										<div class="badge badge-success mr-1 ml-0">
											<small>NEW</small>
										</div>
										Footer Link 4
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
