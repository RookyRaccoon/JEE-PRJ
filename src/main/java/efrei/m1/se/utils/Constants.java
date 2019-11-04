package efrei.m1.se.utils;

public class Constants {
	/**
	 * Make the class "fully static"
	 */
	private Constants() {}

	public static final String JSP_LOGIN = "/WEB-INF/pages/login.jsp";
	public static final String JSP_DETAILS = "/WEB-INF/pages/details.jsp";
	public static final String JSP_HOME = "/WEB-INF/pages/home.jsp";
	public static final String JSP_GOODBYE = "/WEB-INF/pages/goodbye.jsp";
	public static final String JSP_ADDUSER = "/WEB-INF/pages/add-user.jsp";

	public static final String PARAM_EMPLOYEE_ID = "employeeId";

	public static final String DEFAULT_ADMIN_USERNAME = "admin";
	public static final String DEFAULT_ADMIN_PASSWORD = "admin";

	public static final String SQL_PREP_INSERT_EMPLOYEE = "INSERT INTO employees(name, firstname, homephone, mobilephone, workphone, address, postal, city, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String SQL_PREP_DELETE_EMPLOYEE = "DELETE FROM employees WHERE employee_id=?";
	public static final String SQL_PREP_UPDATE_EMPLOYEE = "UPDATE employees SET name = ?, firstname = ?, homephone = ?, mobilephone = ?, workphone = ?, address = ?, postal = ?, city = ?, email = ? WHERE employee_id = ?";
	public static final String SQL_PREP_SELECT_EMPLOYEE_WITH_ID = "SELECT employee_id, name, firstname, homephone, mobilephone, workphone, address, postal, city, email FROM employees WHERE employee_id = ?";
	public static final String SQL_SELECT_ALL_EMPLOYEES = "SELECT employee_id, name, firstname, homephone, mobilephone, workphone, address, postal, city, email FROM employees";
}
