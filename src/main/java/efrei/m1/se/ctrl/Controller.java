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
		switch (req.getServletPath()) {
			case "/":
				if (AuthenticatorService.isAuthenticated(req)) {
					this.sendToPage(JSP_HOME, req, res);
				} else {
					this.sendToPage(JSP_LOGIN, req, res);
				}
				break;

			case "/logout":
				if(AuthenticatorService.isAuthenticated(req)) {
					AuthenticatorService.logout(req);
					this.sendToPage(JSP_GOODBYE, req, res);
				} else {
					this.redirectToHome(req, res);
				}
				break;

			default:
				this.redirectToHome(req, res);  // Redirects the user to "/", this URL shouldn't be GET
				break;
		}
	}


	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticatorService.isAuthenticated(req)) {
			// TODO: redirect user to the home page accordingly to his type

			this.sendToPage(JSP_HOME, req, res);
		} else {
			// Check if request was sent to path /login
			if (req.getServletPath().equals("/login")) {
				// TODO: remove the try/catch block once LoginForm.login is fully implemented

						if(!AuthenticatorService.login(req)) {
							this.sendToPage(JSP_LOGIN, req, res);
							return;
						}
					}
				// TODO: remove this line once LoginForm.login is fully implemented
					/*if (!AuthenticatorService.defaultLogin(req)) {  // If authentication failed
						this.sendToPage(JSP_LOGIN, req, res);
						return;  // To avoid errors
					}*/
					}
		this.redirectToHome(req, res);

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
