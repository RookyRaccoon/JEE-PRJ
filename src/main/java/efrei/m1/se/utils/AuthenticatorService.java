package efrei.m1.se.utils;

import javax.servlet.http.HttpServletRequest;

import static efrei.m1.se.utils.Constants.*;

public class AuthenticatorService {
	/**
	 * Make the class "fully static"
	 */
	private AuthenticatorService() {}

	/**
	 * Check whether or not a User is authenticated through its session data
	 * @param req Incoming HTTP request (needed too find the session)
	 * @return Whether the user is authenticated
	 */
	public static boolean isAuthenticated(HttpServletRequest req) {
		String sessionUsername = (String) req.getSession().getAttribute("username");

		return sessionUsername != null && !sessionUsername.isEmpty();
	}


	public static void defaultLogin(HttpServletRequest req) {
		final String username = req.getParameter("username");
		final String password = req.getParameter("password");

		if (username.equals(DEFAULT_ADMIN_USERNAME) && password.equals(DEFAULT_ADMIN_PASSWORD)) {
			req.setAttribute("connectionFailed", false);

			req.getSession().setAttribute("username", username);

			return;
		}

		req.setAttribute("connectionFailed", true);
	}

	/**
	 * Logs a user out
	 * @param req Incoming request.
	 */
	public static void logout(HttpServletRequest req) {
		req.getSession().invalidate();
	}
}
