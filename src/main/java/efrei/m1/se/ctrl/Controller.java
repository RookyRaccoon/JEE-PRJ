package efrei.m1.se.ctrl;

import efrei.m1.se.form.AddUserForm;
import efrei.m1.se.utils.AuthenticatorService;
import efrei.m1.se.utils.DBActions;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

import static efrei.m1.se.utils.Constants.*;

public class Controller extends HttpServlet {
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

			default:
				this.redirectToHome(req, res);  // Redirects the user to "/", this URL shouldn't be GET
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

			default:  // Redirect all unbound requests to home page ("/") as a GET request
				this.redirectToHome(req, res);
				break;
		}
	}



	/**
	 * Makes a forwarding to the passed in JSP
	 * @param jspPath Path to the JSP to redirect to
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void sendToPage(String jspPath, HttpServletRequest req, HttpServletResponse res) {
		try {
			this.getServletContext().getRequestDispatcher(jspPath).forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Redirects the user to the home page (list of users).
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void redirectToHome(HttpServletRequest req, HttpServletResponse res) {
		try {
			res.sendRedirect(req.getContextPath());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}


	/**
	 * Handles POST requests made to "/add-user" endpoint
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handlePostAddUser(HttpServletRequest req, HttpServletResponse res) {
		if (!DBActions.isReady()) {
			final String propsPath = this.getServletContext().getInitParameter("dbPropFilePath");
			InputStream props = this.getServletContext().getResourceAsStream(propsPath);
			DBActions.init(props);
		}

		AddUserForm form = new AddUserForm(req);
		int rowsAffected = form.store();

		// Set status code of the response if
		if (rowsAffected != 1) {  // (We expect only 1 row to be affected since we use an INSERT statement)
			res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			this.sendToPage(JSP_ADDUSER, req, res);
		} else {
			this.redirectToHome(req, res);
		}
	}

	/**
	 * Handles POST requests made to "/login" endpoint.
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handlePostLogin(HttpServletRequest req, HttpServletResponse res) {
		// If user is already logged in, redirect him to home page
		if (AuthenticatorService.isAuthenticated(req)) {
			this.redirectToHome(req, res);
			return;
		}

		// Attempt to log the user in
		if(!AuthenticatorService.login(req)) {
			this.sendToPage(JSP_LOGIN, req, res);  // Send use to login page if authentication failed
		} else {  // If authentication succeeded
			this.redirectToHome(req, res);
		}
	}


	/**
	 * Handles GET requests made to "/" endpoint.
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handleGetRoot(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticatorService.isAuthenticated(req)) {
			// TODO: check access rights
			this.sendToPage(JSP_HOME, req, res);
		} else {
			this.sendToPage(JSP_LOGIN, req, res);
		}
	}

	/**
	 * Handles GET requests made to "/logout" endpoint.
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handleGetLogout(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticatorService.isAuthenticated(req)) {
			AuthenticatorService.logout(req);
			this.sendToPage(JSP_GOODBYE, req, res);
		} else {
			this.redirectToHome(req, res);
		}
	}

	/**
	 * Handles GET requests made to "/add-user" endpoint.
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	private void handleGetAddUser(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticatorService.isAuthenticated(req)) {
			// TODO: check access rights
			this.sendToPage(JSP_ADDUSER, req, res);
		} else {
			this.sendToPage(JSP_LOGIN, req, res);
		}
	}
}
