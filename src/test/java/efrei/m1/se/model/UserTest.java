package efrei.m1.se.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserTest {

	private User defaultUser, user;

	private final String defaultUsername = "John Doe";
	private final String defaultPassword = "password";

	@BeforeEach
	void init() {
		this.defaultUser = new User();
		this.user = new User(defaultUsername, defaultPassword);
	}

	@Test
	void getUsername() {
		assertEquals(defaultUsername, this.defaultUser.getUsername(), "Default username");
		assertEquals(defaultUsername, this.user.getUsername(), "Constructor-set username");
	}

	@Test
	void setUsername() {
		final String usernameToSet = "V3ryD4rkPr3d4t0r";
		final String usernameBefore = this.user.getUsername();

		this.user.setUsername(usernameToSet);

		assertNotEquals(usernameBefore, this.user.getUsername());
		assertEquals(usernameToSet, this.user.getUsername());

		this.user.setUsername(usernameBefore);
	}

	@Test
	void getPassword() {
		assertEquals(defaultPassword, this.defaultUser.getPassword(), "Default password");
		assertEquals(defaultPassword, this.user.getPassword(), "Constructor-set password");
	}

	@Test
	void setPassword() {
		final String passwordToSet = "V3ryD4rkPr3d4t0r";
		final String passwordBefore = this.user.getUsername();

		this.user.setUsername(passwordToSet);

		assertNotEquals(passwordBefore, this.user.getUsername());
		assertEquals(passwordToSet, this.user.getUsername());

		this.user.setUsername(passwordBefore);
	}
}
