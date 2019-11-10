<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="../components/head-content.jsp" />

	<title>Login</title>
</head>
<body class="vh-100 bg-light">
	<div class="h-100">
		<div class="row h-100 align-items-center">
			<div class="col-sm-8 offset-sm-2 col-xl-6 offset-xl-3">
				<div class="card w-100 bg-white px-5 pt-5 pb-1 ">
					<h1 class="card-title">Login</h1>
					<jsp:include page="../forms/login-form.jsp" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>
