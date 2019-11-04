package efrei.m1.se.form;

import efrei.m1.se.model.User;

import javax.servlet.http.HttpServletRequest;

public class UserDetailsForm extends BaseUserForm {
	/**
	 * Create an instance of the form directly with the incoming {@link HttpServletRequest}
	 * @param req Incoming {@link HttpServletRequest} to parse the {@link User} data from
	 */
	public UserDetailsForm(HttpServletRequest req) {
		super(req);
	}

	/**
	 * Update the {@link User} associated with the form data in the database
	 * @return Number of rows affected by the operation
	 */
	public int store(String dbId) {
		if (this.getUser() != null) {  // Check if there really is a User to update in the database
			this.getUser().setDbId(dbId);
			return this.getUser().updateRecord();
		}

		return -1;
	}
}
