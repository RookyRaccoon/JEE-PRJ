package efrei.m1.se.model;

import efrei.m1.se.dao.DAOException;
import efrei.m1.se.dao.EmployeeDAO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;


@Entity @Table(name = "Employees")
@NoArgsConstructor @ToString
public class User {

	/**
	 * {@link EmployeeDAO} implementation used to handle interaction with database
	 */
	@Getter @Setter
	private static EmployeeDAO employeeDAO;

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "ID")
	@Getter @Setter @ToString.Exclude
	private String dbId;

	@Column(name = "NAME")
	@Getter @Setter
	private String name;

	@Column(name = "FIRSTNAME")
	@Getter @Setter
	private String surname;

	@Column(name = "HOMEPHONE")
	@Getter @Setter
	private String personalPhone;

	@Column(name = "MOBILEPHONE")
	@Getter @Setter
	private String mobilePhone;

	@Column(name = "WORKPHONE")
	@Getter @Setter
	private String workPhone;

	@Column(name = "ADDRESS")
	@Getter @Setter
	private String address;

	@Column(name = "POSTALCODE")
	@Getter @Setter
	private String postalCode;

	@Column(name = "CITY")
	@Getter @Setter
	private String city;

	@Column(name = "EMAIL")
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
		// No need to perform a DB read if no id was provided
		if (id == null) {
			return null;
		}

		try {
			return User.employeeDAO.findById(id);
		} catch (DAOException ignore) {}

		return null;
	}

	/**
	 * Create a user record in the database
	 */
	public void createRecord() {
		try {
			User.employeeDAO.create(this);
		} catch (DAOException ignore) {}
	}


	/**
	 * Get all users from the database as an {@link ArrayList} of {@link User}. Water is wet.
	 * @return {@link ArrayList} of {@link User}
	 */
	public static ArrayList<User> getAllUsers() {
		return User.employeeDAO.findAll();
	}


	/**
	 * Securely handles the deletion of a User record in the database
	 * @param id Id of the user to delete
	 */
	public static void deleteRecord(String id) {
		try {
			User u = User.employeeDAO.findById(id);
			if (u != null) {
				User.employeeDAO.delete(u);
			}
		} catch (DAOException ignore) {}
	}


	/**
	 * Update a {@link User} record in the database
	 */
	public void updateRecord() {
		try {
			User.employeeDAO.update(this);
		} catch (DAOException ignore) {}
	}
}
