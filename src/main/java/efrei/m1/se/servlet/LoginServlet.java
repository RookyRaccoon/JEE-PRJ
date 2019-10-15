package efrei.m1.se.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		this.handleRequest(req, res);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		this.handleRequest(req, res);
	}


	private void handleRequest(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		this.getServletContext().getRequestDispatcher("").forward(req, res);
	}
}
