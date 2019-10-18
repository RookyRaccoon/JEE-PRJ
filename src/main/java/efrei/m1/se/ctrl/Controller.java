package efrei.m1.se.ctrl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import efrei.m1.se.form.LoginForm;
import static efrei.m1.se.utils.Constants.*;

public class Controller extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		try {
			this.handleRequest(req, res);
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) {
		LoginForm.login(req);

		try {
			this.handleRequest(req, res);
		} catch (IOException | ServletException e) {
			e.printStackTrace();
		}
	}


	private void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		this.getServletContext().getRequestDispatcher(JSP_LOGIN).forward(req, res);
	}
}
