package efrei.m1.se.form;

import javax.servlet.http.HttpServletRequest;

public final class LoginForm {
	private static final String USERNAME_FIELD = "username";
	private static final String PASSWORD_FIELD = "password";

	private LoginForm() {}


	public static void login(HttpServletRequest req) {
		final String username = req.getParameter(USERNAME_FIELD);
		final String password = req.getParameter(PASSWORD_FIELD);

		// TODO: log the user in using database entries;

		req.setAttribute("connectionFailed", true);
	}
}
