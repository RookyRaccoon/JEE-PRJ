package efrei.m1.se.form;

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
	public void store(String dbId) {
		if (this.getUser() != null) {  // Check if there really is a User to update in the database
			this.getUser().setDbId(dbId);
			this.getUser().updateRecord();
		}
	}
}
