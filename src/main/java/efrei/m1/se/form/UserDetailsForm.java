package efrei.m1.se.form;

import efrei.m1.se.dao.DAOException;
import efrei.m1.se.dao.EmployeeDAO;
import efrei.m1.se.model.User;

import javax.servlet.http.HttpServletRequest;

public class UserDetailsForm extends BaseUserForm {
	/**
	 * Create an instance of the user details form
	 * @param employeeDAO Instance of an implementation of {@link EmployeeDAO} to use
	 */
	public UserDetailsForm(EmployeeDAO employeeDAO) {
		super(employeeDAO);
	}

	/**
	 * Update the {@link User} associated with the form data in the database
	 */
	public void store(HttpServletRequest req, String dbId) {
		this.processRequest(req);
		if (this.getUser() != null) {  // Check if there really is a User to update in the database
			this.getUser().setDbId(dbId);
			try {
				this.employeeDAO.update(this.getUser());
			} catch (DAOException ignore) {}
		}
	}
}
