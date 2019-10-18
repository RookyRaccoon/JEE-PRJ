package efrei.m1.se.utils;

import javax.servlet.http.HttpServletRequest;

public class Authenticator {
	/**
	 * Make the class "fully static"
	 */
	private Authenticator() {}

	/**
	 * Check whether or not a User is authenticated through its session data
	 * @param req Incoming HTTP request (needed too find the session)
	 * @return Whether the user is authenticated
	 */
	public static boolean isAuthenticated(HttpServletRequest req) {
		String sessionUsername = (String) req.getSession().getAttribute("username");

		return sessionUsername != null && !sessionUsername.isEmpty();
	}
}
