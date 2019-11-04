package efrei.m1.se.form;

import efrei.m1.se.model.User;

import javax.servlet.http.HttpServletRequest;

public class AddUserForm extends BaseUserForm {

	/**
	 * Create an instance of the form directly with the incoming {@link HttpServletRequest}
	 * @param req Incoming {@link HttpServletRequest} to parse the {@link User} data from
	 */
	public AddUserForm(HttpServletRequest req) {
		super(req);
	}

	/**
	 * Store a {@link User} in the database
	 * @return Number of database rows affected ({@code -1} if a problem occurs)
	 */
	public int store() {
		if (this.getUser() != null) {  // Perform only if the User property exists and has been set
			return this.getUser().createRecord();
		}

		return -1;  // By default, if the user is not correctly set
	}
}
