package efrei.m1.se.config;

import efrei.m1.se.dao.DAOFactory;
import efrei.m1.se.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DAOFactoryInitializer implements ServletContextListener {
	private DAOFactory daoFactory;

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext context = event.getServletContext();

		this.daoFactory = DAOFactory.getInstance(context.getResourceAsStream(context.getInitParameter("dbPropFilePath")));

		context.setAttribute("daofactory", this.daoFactory);
		User.setEmployeeDAO(this.daoFactory.getEmployeeDAO());
	}
}
