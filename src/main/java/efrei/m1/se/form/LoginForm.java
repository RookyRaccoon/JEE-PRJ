package efrei.m1.se.form;

import javax.servlet.http.HttpServletRequest;

import static efrei.m1.se.utils.Constants.*;

public final class LoginForm {
	private static final String USERNAME_FIELD = "username";
	private static final String PASSWORD_FIELD = "password";

	private String username;
	private String password;

	private LoginForm() {}


	public LoginForm(String username, String password) {
		this.username = username;
		this.password = password;
	}


	public static void login(HttpServletRequest req) {
		final String username = req.getParameter(USERNAME_FIELD);
		final String password = req.getParameter(PASSWORD_FIELD);

		// TODO: log the user in using database entries

		if (username.equals(DEFAULT_ADMIN_USERNAME) && password.equals(DEFAULT_ADMIN_PASSWORD)) {
			req.setAttribute("connectionFailed", false);
			// TODO: set the session and redirect the user

			return;
		}

		req.setAttribute("connectionFailed", true);
	}


	public boolean checkCredentials() {
		// Check if user matches the default admin credentials
		if (this.username.equals(DEFAULT_ADMIN_USERNAME) && this.password.equals(DEFAULT_ADMIN_PASSWORD)) {
			return true;
		}

		return false;
	}
}
