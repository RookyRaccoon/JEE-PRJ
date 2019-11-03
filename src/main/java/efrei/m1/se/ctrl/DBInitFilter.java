package efrei.m1.se.ctrl;

import efrei.m1.se.utils.DBActions;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Filter responsible for database connection initialization.<br />
 *
 * This filter performs the database connection initialization if it has not already been established.<br />
 *
 * This filter is to be mapped to all URLs which need a database connection.<br />
 */
public class DBInitFilter implements Filter {
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		// Check if database connection has already been established
		if (!DBActions.isReady()) {
			// Convert the generic servletRequest to HttpServletRequest to be able to access the ServletContext
			HttpServletRequest req = (HttpServletRequest) servletRequest;
			final ServletContext ctx = req.getServletContext();
			final String propsPath = ctx.getInitParameter("dbPropFilePath");

			// Establish a database connection according to the properties of the db.properties file
			DBActions.init(ctx.getResourceAsStream(propsPath));
		}

		// Forward all requests (no need to block any)
		filterChain.doFilter(servletRequest, servletResponse);
	}
}
