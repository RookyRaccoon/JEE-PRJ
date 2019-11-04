package efrei.m1.se.form;

import efrei.m1.se.model.User;

import javax.servlet.http.HttpServletRequest;

public class UserDetailsForm extends BaseUserForm {
	/**
	 * Create an instance of the form directly with the incoming {@link HttpServletRequest}
	 * @param req Incoming {@link HttpServletRequest} to parse the {@link User} data from
	 */
	UserDetailsForm(HttpServletRequest req) {
		super(req);
	}


}
