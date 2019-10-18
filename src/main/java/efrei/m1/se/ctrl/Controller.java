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
		this.sendToLoginPage(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		if (AuthenticatorService.isAuthenticated(req)) {
			// TODO: analyze user type

			System.out.println("Logged in user tried to access homepage");

			// TODO: redirect user to the home page accordingly to his type and remove the following line
			this.sendToLoginPage(req, res);
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

			this.sendToLoginPage(req, res);
		}
	}


	private void sendToLoginPage(HttpServletRequest req, HttpServletResponse res) {
		try {
			this.getServletContext().getRequestDispatcher(JSP_LOGIN).forward(req, res);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
