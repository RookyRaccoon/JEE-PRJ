package efrei.m1.se.ctrl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import efrei.m1.se.form.LoginForm;
import efrei.m1.se.utils.AuthenticatorService;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static efrei.m1.se.utils.Constants.*;

public class Controller extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticatorService.isAuthenticated(req)) {
			this.sendToPage(JSP_HOME, req, res);
		} else {
			this.sendToPage(JSP_LOGIN, req, res);
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticatorService.isAuthenticated(req)) {
			// TODO: analyze user type

			System.out.println("Logged in user tried to access homepage");

			// TODO: redirect user to the home page accordingly to his type and remove the following line
			this.sendToPage(JSP_HOME, req, res);
		} else {
			// Check if request was sent to path /login
			if (req.getServletPath().equals("/login")) {
				// TODO: remove the try/catch block once LoginForm.login is fully implemented
				try {
					LoginForm.login(req);
				} catch (NotImplementedException e) {
					AuthenticatorService.defaultLogin(req);  // TODO: remove this line once LoginForm.login is fully implemented
				}
			}

			this.redirectToHome(req, res);
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

}
