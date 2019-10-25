package efrei.m1.se.utils;

import efrei.m1.se.form.LoginForm;

import javax.servlet.http.HttpServletRequest;

import static efrei.m1.se.utils.Constants.DEFAULT_ADMIN_PASSWORD;
import static efrei.m1.se.utils.Constants.DEFAULT_ADMIN_USERNAME;

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


	public static boolean defaultLogin(HttpServletRequest req) {
		final String username = req.getParameter("username");
		final String password = req.getParameter("password");

		if (username.equals(DEFAULT_ADMIN_USERNAME) && password.equals(DEFAULT_ADMIN_PASSWORD)) {
			req.setAttribute("connectionFailed", false);

			req.getSession().setAttribute("username", username);

			return true;
		}

		req.setAttribute("connectionFailed", true);
		return false;
	}

	public static boolean login(HttpServletRequest req){
		final String username = req.getParameter("username");
		final String password = req.getParameter("password");

		if (isAdmin(req, username, password)){
			req.setAttribute("connectionFailed", false);
			req.getSession().setAttribute("username", username);
				return true;
		}
		req.setAttribute("connectionFailed", true);
		return false;
	}

	/**
	 * Logs a user out
	 * @param req Incoming request.
	 */
	public static void logout(HttpServletRequest req) {
		req.getSession().invalidate();
	}

	/**
	 * For admin users
	 * @param req
	 * @param username
	 * @param password
	 * @return true if the field is the context param value we put in our web xml
	 *
	 */
	public static boolean isAdmin (HttpServletRequest req, String username, String password){

		String adminlogin = req.getServletContext().getInitParameter("adminLogin");
		String pwrdlogin = req.getServletContext().getInitParameter("adminPwd");
		if ((adminlogin.equals(req.getParameter(LoginForm.USERNAME_FIELD))) && (pwrdlogin.equals(req.getParameter(LoginForm.PASSWORD_FIELD)))){
			return true;
		}
		 return false;
	}

	/**
	 * Same but for employees
	 * @param req
	 * @return
	 */
	public static boolean isEmployee (HttpServletRequest req){

		String employeelogin = req.getServletContext().getInitParameter("employeeLogin");
		String pwrdlogin = req.getServletContext().getInitParameter("employeePwd");
		if ((employeelogin.equals(req.getParameter(LoginForm.USERNAME_FIELD))) && pwrdlogin.equals(req.getParameter(LoginForm.PASSWORD_FIELD))){
			return true;
		}
		return false;
	}
}
