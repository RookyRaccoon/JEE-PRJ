package efrei.m1.se.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Static class to help navigation across the application
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class NavigationUtils {
	/**
	 * Redirects the user to the home page (list of users).
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	public static void redirectToHome(HttpServletRequest req, HttpServletResponse res) {
		try {
			res.sendRedirect(req.getContextPath());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Redirects the user to the login page.
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	public static void redirectToLogin(HttpServletRequest req, HttpServletResponse res) {
		try {
			res.sendRedirect(req.getContextPath() + "/login");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Makes a forwarding to the passed in JSP
	 * @param jspPath Path to the JSP to redirect to
	 * @param req Incoming request.
	 * @param res Outgoing response.
	 */
	public static void displayJSP(String jspPath, HttpServletRequest req, HttpServletResponse res) {
		try {
			req.getServletContext().getRequestDispatcher(jspPath).forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
