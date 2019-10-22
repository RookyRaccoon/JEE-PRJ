package efrei.m1.se.form;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.http.HttpServletRequest;

import static efrei.m1.se.utils.Constants.*;

public final class LoginForm {
	public static final String USERNAME_FIELD = "username";
	public static final String PASSWORD_FIELD = "password";

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

		// TODO: log user in using database records
		throw new NotImplementedException();
	}


	public boolean checkCredentials() {
		// Check if user matches the default admin credentials
		if (this.username.equals(DEFAULT_ADMIN_USERNAME) && this.password.equals(DEFAULT_ADMIN_PASSWORD)) {
			return true;
		}

		return false;
	}
}
