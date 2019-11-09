package efrei.m1.se.ctrl;

import efrei.m1.se.dao.DAOException;
import efrei.m1.se.dao.DAOFactory;
import efrei.m1.se.dao.EmployeeDAO;
import efrei.m1.se.form.AddUserForm;
import efrei.m1.se.form.UserDetailsForm;
import efrei.m1.se.model.User;
import efrei.m1.se.service.AuthenticationService;
import efrei.m1.se.utils.NavigationUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static efrei.m1.se.utils.Constants.*;

public class Controller extends HttpServlet {

	private EmployeeDAO employeeDAO;

	@Override
	public void init() throws ServletException {
		this.employeeDAO = ((DAOFactory) this.getServletContext().getAttribute("daofactory")).getEmployeeDAO();
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		// Pick the right action to perform based on the route (URL)
		switch (req.getServletPath()) {
			case "/":
				handleGetRoot(req, res);
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
		AddUserForm form = new AddUserForm(this.employeeDAO);

		try {
			form.store(req);
		} catch (DAOException e) {  // If an error occurs, consider the request to be a bad request
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			NavigationUtils.sendToPage(JSP_ADDUSER, req, res);
			return;
		}

		res.setStatus(HttpServletResponse.SC_CREATED);
		NavigationUtils.redirectToHome(req, res);
	}

	/**
	 * Handles POST requests made to "/login" endpoint.
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handlePostLogin(HttpServletRequest req, HttpServletResponse res) {
		// If user is already logged in, redirect him to home page
		if (AuthenticationService.isAuthenticated(req)) {
			NavigationUtils.redirectToHome(req, res);
			return;
		}

		// Attempt to log the user in
		if(!AuthenticationService.login(req)) {
			NavigationUtils.sendToPage(JSP_LOGIN, req, res);  // Send use to login page if authentication failed
		} else {  // If authentication succeeded
			NavigationUtils.redirectToHome(req, res);
		}
	}

	/**
	 * Handles POST requests made to "/details" endpoint
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handlePostDetails(HttpServletRequest req, HttpServletResponse res) {
		UserDetailsForm form = new UserDetailsForm(this.employeeDAO);
		form.store(req.getParameter(PARAM_EMPLOYEE_ID));

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
		if (AuthenticationService.isAuthenticated(req)) {
			req.setAttribute("employees", User.getAllUsers());
			NavigationUtils.sendToPage(JSP_HOME, req, res);
		} else {
			NavigationUtils.sendToPage(JSP_LOGIN, req, res);
		}
	}

	/**
	 * Handles GET requests made to "/logout" endpoint.
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handleGetLogout(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticationService.isAuthenticated(req)) {
			AuthenticationService.logout(req);
			NavigationUtils.sendToPage(JSP_GOODBYE, req, res);
		} else {
			NavigationUtils.redirectToHome(req, res);
		}
	}

	/**
	 * Handles GET requests made to "/add-user" endpoint.
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handleGetAddUser(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticationService.isAuthenticated(req)) {
			// TODO: check access rights
			NavigationUtils.sendToPage(JSP_ADDUSER, req, res);
		} else {
			NavigationUtils.sendToPage(JSP_LOGIN, req, res);
		}
	}

	/**
	 * Handles GET requests made to "/details" endpoint
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handleGetDetails(HttpServletRequest req, HttpServletResponse res) {
		// Check access rights
		if (!AuthenticationService.isAuthenticated(req)) {
			NavigationUtils.sendToPage(JSP_LOGIN, req, res);
		}

		// Gather queried employee thanks to employeeId passed as URL parameter
		User queriedEmployee = User.withId(req.getParameter(PARAM_EMPLOYEE_ID));

		// Check if request is valid (queried employee exists and has been retrieved)
		if (queriedEmployee == null) {
			NavigationUtils.redirectToHome(req, res);
		} else {
			req.setAttribute("employee", queriedEmployee);

			NavigationUtils.sendToPage(JSP_DETAILS, req, res);
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
		final String employeeId = req.getParameter(PARAM_EMPLOYEE_ID);

		if (User.isDBIdValid(employeeId)) {
			User.deleteRecord(employeeId);
		}

		NavigationUtils.redirectToHome(req, res);
	}
	///endregion
}
