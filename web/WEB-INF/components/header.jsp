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
							<c:choose>
								<c:when test="${sessionScope.isAdmin}">
									<span>Hello, admin</span>
								</c:when>
								<c:when test="${sessionScope.isEmployee}">
									<span>Hello, employee</span>
								</c:when>
							</c:choose>
						</div>
						<div class="widget-content-left">
							<div class="btn-group">
								<!-- Disconnect button -->
								<button type="button" data-toggle="tooltip" title="Disconnect" data-placement="left" class="btn-shadow p-1 btn btn-primary btn-sm" onclick="window.location.href='${logoutUrl}'">
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