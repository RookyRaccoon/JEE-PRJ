package efrei.m1.se.form;

import efrei.m1.se.model.User;

import javax.servlet.http.HttpServletRequest;

public class AddUserForm {

	private static final String FRM_LASTNAME = "lastname";
	private static final String FRM_FIRSTNAME = "firstname";
	private static final String FRM_HOMEPHONE = "homephone";
	private static final String FRM_MOBILEPHONE = "mobilephone";
	private static final String FRM_WORKPHONE = "workphone";
	private static final String FRM_ADDRESS = "address";
	private static final String FRM_ZIPCODE = "zipcode";
	private static final String FRM_CITY = "city";
	private static final String FRM_EMAIL = "email";

	private User user;

	public AddUserForm() {
		user = null;
	}

	/**
	 * Create an instance of the form directly with the incoming {@link HttpServletRequest}
	 * @param req
	 */
	public AddUserForm(HttpServletRequest req) {
		this.processRequest(req);
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Create the {@link User} corresponding to the form
	 * @param req Incoming HTTP request.
	 */
	public void processRequest(HttpServletRequest req) {
		this.user = new User(
			req.getParameter(FRM_LASTNAME),
			req.getParameter(FRM_FIRSTNAME),
			req.getParameter(FRM_HOMEPHONE),
			req.getParameter(FRM_MOBILEPHONE),
			req.getParameter(FRM_WORKPHONE),
			req.getParameter(FRM_ADDRESS),
			req.getParameter(FRM_ZIPCODE),
			req.getParameter(FRM_CITY),
			req.getParameter(FRM_EMAIL)
		);
	}


	public int store() {
		if (this.user != null) {
			return this.user.createRecord();
		}

		return -1;  // By default, if the user is not correctly set
	}
}
