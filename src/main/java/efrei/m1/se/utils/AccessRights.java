package efrei.m1.se.utils;

/**
 * Holds different access rights levels
 */
public enum AccessRights {
	/**
	 * Defines a public access : the access is not restricted to anyone
	 */
	PUBLIC,

	/**
	 * Defines a restricted access : only employees and admins can access
	 */
	EMPLOYEE,

	/**
	 * Defines a restricted access : only admins can access
	 */
	ADMIN,

	/**
	 * Defines a mixed restricted access : all logged-in users can access
	 */
	AUTHENTICATED
}
