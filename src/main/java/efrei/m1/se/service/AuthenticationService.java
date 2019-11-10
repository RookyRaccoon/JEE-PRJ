package efrei.m1.se.service;

import efrei.m1.se.form.LoginForm;
import efrei.m1.se.utils.AccessRights;

import static efrei.m1.se.utils.Constants.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Simple authentication service to handle authentication checking as well as login users in and out
 */
public class AuthenticationService {
	/**
	 * Make the class "fully static"
	 */
	private AuthenticationService() {}

	/**
	 * Check whether or not a User is authenticated through its session data
	 * @param req Incoming HTTP request (needed too find the session)
	 * @return Whether the user is authenticated
	 */
	public static boolean isAuthenticated(HttpServletRequest req) {
		if (req.getSession().getAttribute(SESS_IS_EMPLOYEE) != null) {
			return (boolean) req.getSession().getAttribute(SESS_IS_EMPLOYEE);
		}

		return false;
	}

	/**
	 * Log a user in thanks to form data
	 * @param req Incoming request containing login form data
	 * @return Whether the authentication succeeded
	 */
	public static boolean login(HttpServletRequest req) {
		if (isEmployee(req)) {
			req.setAttribute(REQ_CONNECTION_FAILED, false);

			req.getSession().setAttribute(SESS_IS_EMPLOYEE, true);

			return true;
		}

		if (isAdmin(req)) {
			req.setAttribute(REQ_CONNECTION_FAILED, false);

			req.getSession().setAttribute(SESS_IS_EMPLOYEE, true);
			req.getSession().setAttribute(SESS_IS_ADMIN, true);

			return true;
		}

		req.setAttribute(REQ_CONNECTION_FAILED, true);
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
	 * @param req Incoming request.
	 * @return true if the field is the context param value we put in our web xml
	 *
	 */
	private static boolean isAdmin(HttpServletRequest req){

		String adminlogin = req.getServletContext().getInitParameter("adminLogin");
		String pwrdlogin = req.getServletContext().getInitParameter("adminPwd");
		if ((adminlogin.equals(req.getParameter(LoginForm.USERNAME_FIELD))) && (pwrdlogin.equals(req.getParameter(LoginForm.PASSWORD_FIELD)))){
			return true;
		}
		 return false;
	}

	/**
	 * Same but for employees
	 * @param req Incoming request containing form data.
	 * @return Whether the form data corresponds to an employee record.
	 */
	private static boolean isEmployee (HttpServletRequest req){

		String employeelogin = req.getServletContext().getInitParameter("employeeLogin");
		String pwrdlogin = req.getServletContext().getInitParameter("employeePwd");
		if ((employeelogin.equals(req.getParameter(LoginForm.USERNAME_FIELD))) && pwrdlogin.equals(req.getParameter(LoginForm.PASSWORD_FIELD))){
			req.getSession().setAttribute(SESS_IS_EMPLOYEE, true);
			return true;
		}
		return false;
	}

	/**
	 * Chooses to allow or disallow access based on the content of the session
	 * @param req Incoming request (holding the session to check)
	 * @param requiredRights Minimum access level needed to access the resource
	 * @return Whether the user has the ability to access the resource
	 */
	public static boolean canAccess (HttpServletRequest req, AccessRights requiredRights) {
		if (requiredRights.equals(AccessRights.PUBLIC)) {
			return true;
		}

		if (req.getSession().getAttribute(SESS_IS_EMPLOYEE) != null) {
			if (requiredRights.equals(AccessRights.AUTHENTICATED) || requiredRights.equals(AccessRights.EMPLOYEE)) {
				return true;
			}

			return req.getSession().getAttribute(SESS_IS_ADMIN) != null && (boolean) req.getSession().getAttribute(SESS_IS_ADMIN);
		}

		return false;
	}
}
