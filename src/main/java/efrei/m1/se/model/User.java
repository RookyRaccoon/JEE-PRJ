package efrei.m1.se.model;

public class User {

	private static final String DEFAULT_USERNAME = "John Doe";
	private static final String DEFAULT_PASSWORD = "password";

	/**
	 * Unique username allowing to identify a user in the database.
	 */
	private String username;

	/**
	 * Password of the user allowing to authenticate him.
	 */
	private String password;


	/**
	 * No arguments constructor. Water is wet.
	 */
	public User() {
		this.username = DEFAULT_USERNAME;
		this.password = DEFAULT_PASSWORD;
	}


	/**
	 * All arguments constructor. The sky is blue.
	 * @param username Username of the user to instantiate.
	 * @param password Password of the user to instantiate.
	 */
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Get the username of the User.
	 * @return Username of the User.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Set the username of the User.
	 * @param username Username to set to the User.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Get the password of the User.
	 * @return Password of the User.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set the password of the User.
	 * @param password Password to set to the User.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
