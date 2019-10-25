package efrei.m1.se.utils;

public class Constants {
	/**
	 * Make the class "fully static"
	 */
	private Constants() {}

	public static final String JSP_LOGIN = "/WEB-INF/jsp/login.jsp";
	public static final String JSP_DETAILS = "/WEB-INF/jsp/details.jsp";
	public static final String JSP_HOME = "/WEB-INF/jsp/home.jsp";
	public static final String JSP_GOODBYE = "/WEB-INF/jsp/goodbye.jsp";
	public static final String JSP_ADDUSER = "/WEB-INF/jsp/add-user.jsp";


	public static final String DEFAULT_ADMIN_USERNAME = "admin";
	public static final String DEFAULT_ADMIN_PASSWORD = "admin";

	public static final String DB_PROP_FILE_PATH = "/WEB-INF/db.properties";

	public static final String SQL_PREP_INSERT_EMPLOYEE = "INSERT INTO employees(name, firstname, homephone, mobilephone, workphone, address, postal, city, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
