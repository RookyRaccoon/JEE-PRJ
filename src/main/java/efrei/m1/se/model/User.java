package efrei.m1.se.model;

import efrei.m1.se.utils.DBActions;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static efrei.m1.se.utils.Constants.*;

@NoArgsConstructor @ToString
public class User {
	@Getter @Setter @ToString.Exclude
	transient private String dbId;

	@Getter @Setter
	private String name;

	@Getter @Setter
	private String surname;

	@Getter @Setter
	private String personalPhone;

	@Getter @Setter
	private String mobilePhone;

	@Getter @Setter
	private String workPhone;

	@Getter @Setter
	private String address;

	@Getter @Setter
	private String postalCode;

	@Getter @Setter
	private String city;

	@Getter @Setter
	private String email;

	public User(String name, String surname, String personalPhone, String mobilePhone, String workPhone, String address, String postalCode, String city, String email) {
		this.name = name;
		this.surname = surname;
		this.personalPhone = personalPhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.address = address;
		this.postalCode = postalCode;
		this.city = city;
		this.email = email;
		this.dbId = "";
	}

	/**
	 * Retrieve a single {@link User} from the database based upon its {@code id}
	 * @param id Id of the {@link User} to retrieve from the database
	 * @return {@link User} object for the matching database record
	 */
	public static User withId(String id) {
		User user = null;

		// No need to perform a DB read if no id was provided
		if (id == null) {
			return null;
		}

		try {
			PreparedStatement ps = DBActions.getPreparedStatement(SQL_PREP_SELECT_EMPLOYEE_WITH_ID);

			if (ps != null) {
				ps.setString(1, id);

				ResultSet rs = ps.executeQuery();

				// Check if a user was found and use it as a return value
				if (rs.next()) {
					user = User.castFromResultSetRow(rs);
				}

				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	/**
	 * Create a user record in the database
	 * @return Status of the request (number of rows affected), <code>-1</code> if an error occurs
	 */
	public int createRecord() {
		try {
			final PreparedStatement stmt = DBActions.getPreparedStatement(SQL_PREP_INSERT_EMPLOYEE);

			if (stmt == null) {
				return -1;
			}

			setPreparedStatementStrings(stmt);

			int rowsAffected = stmt.executeUpdate();
			stmt.close();

			return rowsAffected;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}


	/**
	 * Get all users from the database as an {@link ArrayList} of {@link User}. Water is wet.
	 * @return {@link ArrayList} of {@link User}
	 */
	public static ArrayList<User> getAllUsers() {
		ArrayList<User> users = new ArrayList<>();

		try {
			ResultSet rs = DBActions.executeRead(SQL_SELECT_ALL_EMPLOYEES);
			if (rs != null) {
				while (rs.next()) {
					users.add(User.castFromResultSetRow(rs));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	/**
	 * Cast a {@link ResultSet} row to a {@link User} object
	 * @param rs {@link ResultSet} row to cast
	 * @return {@link User} casted from {@code rs}
	 */
	private static User castFromResultSetRow(ResultSet rs) {
		User u = new User();

		if (rs != null) {
			try {
				u.setDbId(rs.getString("ID"));
				u.setName(rs.getString("NAME"));
				u.setSurname(rs.getString("FIRSTNAME"));
				u.setPersonalPhone(rs.getString("HOMEPHONE"));
				u.setWorkPhone(rs.getString("WORKPHONE"));
				u.setMobilePhone(rs.getString("MOBILEPHONE"));
				u.setAddress(rs.getString("ADDRESS"));
				u.setPostalCode(rs.getString("POSTALCODE"));
				u.setCity(rs.getString("CITY"));
				u.setEmail(rs.getString("EMAIL"));

				return u;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	/**
	 * Check if the passed in {@code id} is a valid database id
	 * @param id Id to check
	 * @return Whether the id is a valid id
	 */
	public static boolean isDBIdValid(String id) {
		return id != null && id.matches("\\d+");
	}

	/**
	 * Securely handles the deletion of a User record in the database
	 * @param id Id of the user to delete
	 */
	public static void deleteRecord(String id) {
		try {
			PreparedStatement ps = DBActions.getPreparedStatement(SQL_PREP_DELETE_EMPLOYEE);

			// Check if prepared statement is OK
			if (ps != null) {
				ps.setString(1, id);
				ps.executeUpdate();
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Update a {@link User} record in the database
	 */
	public int updateRecord() {
		int rowsAffected = -1;

		try {
			final PreparedStatement ps = DBActions.getPreparedStatement(SQL_PREP_UPDATE_EMPLOYEE);

			if (ps != null) {
				setPreparedStatementStrings(ps);
				ps.setString(10, this.dbId);  // Set DB ID to update the correct record

				rowsAffected = ps.executeUpdate();
				ps.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rowsAffected;
	}

	/**
	 * Refactored method to avoid duplicated prepared statement string setting code
	 * @param ps Prepared statement to set
	 * @throws SQLException If there is a SQL problem with the prepared statement (shouldn't happen)
	 */
	private void setPreparedStatementStrings(PreparedStatement ps) throws SQLException {
		DBActions.initPreparedStatement(ps,
			this.name,
			this.surname,
			this.personalPhone,
			this.mobilePhone,
			this.workPhone,
			this.address,
			this.postalCode,
			this.city,
			this.email
			);
	}
}
