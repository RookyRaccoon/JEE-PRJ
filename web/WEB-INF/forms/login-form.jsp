<form method="post" action="${loginUrl}" class="card-body px-0 pb-5">
	<div class="form-group">
		<label for="username-input">Username</label>
		<input type="text" id="username-input" name="username" placeholder="Username" class="form-control form-control-lg" required />
	</div>

	<div class="form-group">
		<label for="password-input">Password</label>
		<input type="password" id="password-input" name="password" placeholder="Password" class="form-control form-control-lg" required />
	</div>

	<c:if test="${requestScope.connectionFailed}">
		<div class="container-fluid p-0 m-0">
			<div class="row">
				<div class="col-8 offset-2 container alert-danger my-4 py-3 px-4 rounded-lg text-center">
					Connection failed. Verify your login/password and try again.
				</div>
			</div>
		</div>

	</c:if>

	<div class="form-group text-right p-0 m-0 mt-4 mb-2">
		<input type="submit" value="Login" class="btn btn-lg btn-primary" />
	</div>
</form>