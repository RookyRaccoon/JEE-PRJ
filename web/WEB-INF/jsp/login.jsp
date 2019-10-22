<c:url var="architectUI" value="/static/architect-ui"/>
<c:url var="loginUrl" value="/login"/>

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
					<h1 class="card-title">Login</h1>
					<form method="post" action="${loginUrl}" class="card-body px-0 pb-0">
						<div class="form-group">
							<label for="username-input">Username</label>
							<input type="text" id="username-input" name="username" placeholder="Username" class="form-control form-control-lg" required />
						</div>

						<div class="form-group">
							<label for="password-input">Password</label>
							<input type="password" id="password-input" name="password" placeholder="Password" class="form-control form-control-lg" required />
						</div>

						<div class="form-group text-right p-0 m-0 mt-4 mb-2">
							<input type="submit" value="Login" class="btn btn-lg btn-primary" />
						</div>

						<c:if test="${requestScope.connectionFailed}">
							<div class="container alert-danger my-4 py-3 px-4 rounded-lg text-center">
								Connection failed. Verify your login/password and try again.
							</div>
						</c:if>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
