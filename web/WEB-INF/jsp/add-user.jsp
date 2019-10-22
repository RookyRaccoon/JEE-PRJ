<c:url var="architectUI" value="/static/architect-ui"/>
<c:url var="logoutUrl" value="/logout" />

<c:url var="logoutUrl" value="/logout" />

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

	<%--	<script src="https://kit.fontawesome.com/05417d287a.js" crossorigin="anonymous"></script>--%>  <!-- TODO: determine if needed -->

	<title>Employee Details</title>
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
        <button type="button" class="btn-icon btn-icon-only btn btn-primary btn-sm" onclick="window.location.href='${logoutUrl}'">
          <span class="btn-icon-wrapper text-center">
            <i class="text-white pe-7s-power pe-inverse pe-2x px-1 align-middle"></i>
          </span>
	        </a>
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
									<button type="button" data-toggle="tooltip" title="Disconnect" data-placement="left" class="btn-shadow p-1 btn btn-primary btn-sm" onclick="window.location.href='${logoutUrl}'">
										<i class="text-white pe-7s-power pe-2x p-1 align-middle"></i>
										</a>
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
								<i class="pe-7s-user icon-gradient bg-happy-itmeo"></i>
							</div>
							<div>
								<span>
									Add a new employee
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
								<!-- TODO: populate the form with the data of the employee -->
								<form action="#" method="post" class="row">
									<div class="form-group col-12 col-lg-6">
										<label for="lastname-input">Last name</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text">
													<i class="pe-7s-user"></i>
												</span>
											</div>
											<input id="lastname-input" type="text" class="form-control form-control-lg" placeholder="Doe" required />
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
											<input id="firstname-input" type="text" class="form-control form-control-lg" placeholder="John" required />
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
											<input id="homephone-input" type="tel" class="form-control" placeholder="0112345678" required />
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
											<input id="mobilephone-input" type="tel" class="form-control" placeholder="0612345678" required />
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
											<input id="workphone-input" type="tel" class="form-control" placeholder="0912345678" required />
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
											<input id="address-input" type="text" class="form-control" placeholder="742 Evergreen Terrace" required />
										</div>

									</div>

									<div class="form-group col-5 col-lg-2">
										<label for="zipcode-input">ZIP Code</label>
										<input id="zipcode-input" type="text" class="form-control" placeholder="89011" required />
									</div>

									<div class="form-group col-7 col-lg-4">
										<label for="city-input">City</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text">
													<i class="pe-7s-map"></i>
												</span>
											</div>
											<input id="city-input" type="text" class="form-control" placeholder="Springfield" required />
										</div>
									</div>

									<div class="form-group col-12 col-lg-8">
										<label for="email-input">Email</label>
										<div class="input-group">
											<div class="input-group-prepend">
												<span class="input-group-text">@</span>
											</div>
											<input id="email-input" type="email" class="form-control form-control-lg" placeholder="jdoe@mail.com" required />
										</div>
									</div>

									<div class="form-group col-12 text-center text-md-right">
										<a href="#" class="btn btn-lg btn-outline-secondary mx-2 px-3">Cancel</a>
										<input type="submit" value="Save" class="btn btn-primary btn-lg px-4" />
									</div>
								</form>
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
