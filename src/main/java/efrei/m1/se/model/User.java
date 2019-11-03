package efrei.m1.se.model;

import efrei.m1.se.utils.DBActions;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static efrei.m1.se.utils.Constants.*;

public class User {
	private String dbId;
	private String name;
	private String surname;
	private String personalPhone;
	private String mobilePhone;
	private String workPhone;
	private String address;
	private String postalCode;
	private String city;
	private String email;

	public User() {
		name = "";
		surname = "";
		personalPhone = "";
		mobilePhone = "";
		workPhone = "";
		address = "";
		postalCode = "";
		city = "";
		email = "";
		dbId = "";
	}

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

	public String getDbId() {
		return dbId;
	}

	public void setDbId(String dbId) {
		this.dbId = dbId;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public String getPersonalPhone() {
		return this.personalPhone;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public String getWorkPhone() {
		return this.workPhone;
	}

	public String getAddress() {
		return this.address;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public String getCity() {
		return this.city;
	}

	public String getEmail() {
		return this.email;
	}

	public void setName(String nom) {
		this.name = nom;
	}

	public void setSurname(String prenom) {
		this.surname = prenom;
	}

	public void setPersonalPhone(String phone) {
		this.personalPhone = phone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "USER : \n**IDENTITY** \n| Name : " + this.name + "\n| Surname : " + this.surname + "\n"
			+ "**PHONES** \n| Personal phone : " + personalPhone + "\n| Mobile phone " + mobilePhone + "\n| Work Phone : " + workPhone + "\n"
			+ "**ADRESS**\n| Street : " + address + "\n| Code : " + postalCode + "\n| City : " + city + "\n"
			+ "**CONTACT** \n|Mail : " + email + "\n\n";
	}

	/**
	 * Create a user record in the database
	 * @return Status of the request (number of rows affected), <code>-1</code> if an error occurs
	 */
	public int createRecord() {
		try {
			final PreparedStatement stmt = DBActions.getPreparedStatement(SQL_PREP_INSERT_EMPLOYEE);

			stmt.setString(1, this.name);
			stmt.setString(2, this.surname);
			stmt.setString(3, this.personalPhone);
			stmt.setString(4, this.mobilePhone);
			stmt.setString(5, this.workPhone);
			stmt.setString(6, this.address);
			stmt.setString(7, this.postalCode);
			stmt.setString(8, this.city);
			stmt.setString(9, this.email);

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
				u.setDbId(rs.getString("employee_id"));
				u.setName(rs.getString("name"));
				u.setSurname(rs.getString("firstname"));
				u.setPersonalPhone(rs.getString("homephone"));
				u.setWorkPhone(rs.getString("workphone"));
				u.setMobilePhone(rs.getString("mobilephone"));
				u.setAddress(rs.getString("address"));
				u.setPostalCode(rs.getString("postal"));
				u.setCity(rs.getString("city"));
				u.setEmail(rs.getString("email"));

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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
