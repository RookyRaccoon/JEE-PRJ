package efrei.m1.se.form;

import efrei.m1.se.dao.DAOException;
import efrei.m1.se.dao.EmployeeDAO;
import efrei.m1.se.model.User;

import javax.servlet.http.HttpServletRequest;

public class AddUserForm extends BaseUserForm {

	/**
	 * Create an instance of the add user form
	 * @param employeeDAO Instance of an implementation of {@link EmployeeDAO} to use
	 */
	public AddUserForm(EmployeeDAO employeeDAO) {
		super(employeeDAO);
	}

	/**
	 * Store a {@link User} in the database
	 */
	public void store(HttpServletRequest req) throws DAOException {
		this.processRequest(req);
		if (this.getUser() != null) {  // Perform only if the User property exists and has been set
			this.employeeDAO.create(this.getUser());
		}
	}
}
