


<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8"/>

	<!-- Bootstrap -->
	<link type="text/css" rel="stylesheet" href="${architectUI}/main.css"/>

	<title>Login</title>
</head>
<body class="vh-100 bg-light">
<div class="h-100">
	<div class="row h-100 align-items-center">
		<div class="col-sm-8 offset-sm-2 col-xl-6 offset-xl-3">
			<div class="card w-100 bg-white px-5 pt-5 pb-1 ">
				<h1 class="card-title">Goodbye</h1>
				<div class="card-body">
					<p>
						You have been logged off and will be redirected to the login page.
					</p>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	window.addEventListener("DOMContentLoaded", () => {
		setTimeout(() => {
			window.location.href = "${loginUrl}";
		}, 5000);
	});
</script>
</body>
</html>
