package efrei.m1.se.ctrl;

import efrei.m1.se.dao.DAOException;
import efrei.m1.se.dao.EmployeeDAO;
import efrei.m1.se.dao.EmployeeDAOImpl;
import efrei.m1.se.form.AddUserForm;
import efrei.m1.se.form.UserDetailsForm;
import efrei.m1.se.model.User;
import efrei.m1.se.service.AuthenticationService;
import efrei.m1.se.utils.AccessRights;
import efrei.m1.se.utils.NavigationUtils;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static efrei.m1.se.utils.Constants.*;

public class Controller extends HttpServlet {

	private EmployeeDAO employeeDAO;

	@Override
	public void init() {
		this.employeeDAO = new EmployeeDAOImpl();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		// Pick the right action to perform based on the route (URL)
		switch (req.getServletPath()) {
			case "/":
				handleGetRoot(req, res);
				break;

			case "/login":
				handleGetLogin(req, res);
				break;

			case "/logout":
				handleGetLogout(req, res);
				break;

			case "/add-user":
				handleGetAddUser(req, res);
				break;

			case "/delete":
				handleUserDeletion(req, res);
				break;

			case "/details":
				handleGetDetails(req, res);
				break;

			default:
				NavigationUtils.redirectToHome(req, res);  // Redirects the user to "/", this URL shouldn't be GET
				break;
		}
	}


	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		// Pick the right action to perform based on the route (URL)
		switch(req.getServletPath()) {
			case "/login":
				handlePostLogin(req, res);
				break;

			case "/add-user":
				handlePostAddUser(req, res);
				break;

			case "/delete":
				handleUserDeletion(req, res);
				break;

			case "/details":
				handlePostDetails(req, res);
				break;

			default:  // Redirect all unbound requests to home page ("/") as a GET request
				NavigationUtils.redirectToHome(req, res);
				break;
		}
	}

	///region POST requests handlers
	/**
	 * Handles POST requests made to "/add-user" endpoint
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handlePostAddUser(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticationService.canAccess(req, AccessRights.ADMIN)) {
			AddUserForm form = new AddUserForm(this.employeeDAO);

			try {
				form.store(req);
			} catch (DAOException e) {  // If an error occurs, consider the request to be a bad request
				NavigationUtils.displayJSP(JSP_ADDUSER, req, res);
				return;
			}
		}

		NavigationUtils.redirectToHome(req, res);
	}

	/**
	 * Handles POST requests made to "/login" endpoint.
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handlePostLogin(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticationService.canAccess(req, AccessRights.AUTHENTICATED)) {
			NavigationUtils.redirectToHome(req, res);
		} else {
			// Attempt to log the user in
			if(!AuthenticationService.login(req)) {
				NavigationUtils.displayJSP(JSP_LOGIN, req, res);  // Send user to login page if authentication failed
			} else {  // If authentication succeeded
				NavigationUtils.redirectToHome(req, res);
			}
		}
	}

	/**
	 * Handles POST requests made to "/details" endpoint
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handlePostDetails(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticationService.canAccess(req, AccessRights.ADMIN)) {
			UserDetailsForm form = new UserDetailsForm(this.employeeDAO);
			form.store(req, req.getParameter(PARAM_EMPLOYEE_ID));
		}

		NavigationUtils.redirectToHome(req, res);
	}
	///endregion

	///region GET requests handlers
	/**
	 * Handles GET requests made to "/" endpoint.
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handleGetRoot(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticationService.canAccess(req, AccessRights.AUTHENTICATED)) {
			req.setAttribute("employees", this.employeeDAO.findAll());
			NavigationUtils.displayJSP(JSP_HOME, req, res);
		} else {
			NavigationUtils.redirectToLogin(req, res);
		}
	}

	/**
	 * Handles GET requests made to "/login" endpoint.
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handleGetLogin(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticationService.canAccess(req, AccessRights.AUTHENTICATED)) {
			NavigationUtils.redirectToHome(req, res);
		} else {
			NavigationUtils.displayJSP(JSP_LOGIN, req, res);
		}
	}

	/**
	 * Handles GET requests made to "/logout" endpoint.
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handleGetLogout(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticationService.canAccess(req, AccessRights.AUTHENTICATED)) {
			AuthenticationService.logout(req);
			NavigationUtils.displayJSP(JSP_GOODBYE, req, res);
		} else {
			NavigationUtils.redirectToLogin(req, res);
		}
	}

	/**
	 * Handles GET requests made to "/add-user" endpoint.
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handleGetAddUser(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticationService.canAccess(req, AccessRights.ADMIN)) {
			NavigationUtils.displayJSP(JSP_ADDUSER, req, res);
		} else {
			NavigationUtils.redirectToHome(req, res);
		}
	}

	/**
	 * Handles GET requests made to "/details" endpoint
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handleGetDetails(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticationService.canAccess(req, AccessRights.ADMIN)) {
			// Gather queried employee thanks to employeeId passed as URL parameter
			User queriedEmployee = this.employeeDAO.findById(req.getParameter(PARAM_EMPLOYEE_ID));

			// Check if request is valid (queried employee exists and has been retrieved)
			if (queriedEmployee == null) {
				NavigationUtils.redirectToHome(req, res);
			} else {
				req.setAttribute("employee", queriedEmployee);

				NavigationUtils.displayJSP(JSP_DETAILS, req, res);
			}
		} else {
			NavigationUtils.redirectToHome(req, res);
		}
	}
	///endregion

	///region Mixed requests handlers
	/**
	 * Handles all requests made to "/delete" endpoint
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handleUserDeletion(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticationService.canAccess(req, AccessRights.ADMIN)) {
			final String employeeId = req.getParameter(PARAM_EMPLOYEE_ID);

			try {
				User employeeToDelete = this.employeeDAO.findById(employeeId);

				this.employeeDAO.delete(employeeToDelete);
			} catch (DAOException ignore) {}
		}

		NavigationUtils.redirectToHome(req, res);
	}
	///endregion
}
