package efrei.m1.se.form;

import efrei.m1.se.model.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;

/**
 * Describes a form containing fields for all the fields a {@link User} contains
 */
abstract class BaseUserForm {
	private static final String FRM_LAST_NAME = "lastname";
	private static final String FRM_FIRST_NAME = "firstname";
	private static final String FRM_HOME_PHONE = "homephone";
	private static final String FRM_MOBILE_PHONE = "mobilephone";
	private static final String FRM_WORK_PHONE = "workphone";
	private static final String FRM_ADDRESS = "address";
	private static final String FRM_ZIP_CODE = "zipcode";
	private static final String FRM_CITY = "city";
	private static final String FRM_EMAIL = "email";

	@Getter(AccessLevel.PUBLIC) @Setter(AccessLevel.PUBLIC)
	private User user;


	BaseUserForm(HttpServletRequest req) {
		this.processRequest(req);
	}

	/**
	 * Parses a {@link User} from form-contained data in a {@link HttpServletRequest}
	 * @param req {@link HttpServletRequest} to parse {@link User} data from
	 */
	private void processRequest(HttpServletRequest req) {
		this.user = new User(
			req.getParameter(FRM_LAST_NAME),
			req.getParameter(FRM_FIRST_NAME),
			req.getParameter(FRM_HOME_PHONE),
			req.getParameter(FRM_MOBILE_PHONE),
			req.getParameter(FRM_WORK_PHONE),
			req.getParameter(FRM_ADDRESS),
			req.getParameter(FRM_ZIP_CODE),
			req.getParameter(FRM_CITY),
			req.getParameter(FRM_EMAIL)
		);
	}
}
