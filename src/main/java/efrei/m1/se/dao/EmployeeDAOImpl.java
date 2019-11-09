package efrei.m1.se.dao;

import efrei.m1.se.model.User;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * Class to easily manipulate {@link User} objects in the database
 */
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeDAOImpl implements EmployeeDAO {

	///region SQL Queries
	///////////////////////////////////////////////////////////////////////////
	// SQL Queries
	///////////////////////////////////////////////////////////////////////////
	private static final String SQL_SELECT_BY_ID = "SELECT ID, NAME, FIRSTNAME, HOMEPHONE, MOBILEPHONE, WORKPHONE, ADDRESS, POSTALCODE, CITY, EMAIL FROM Employees WHERE ID = ?";
	private static final String SQL_INSERT_ONE   = "INSERT INTO Employees(NAME, FIRSTNAME, HOMEPHONE, MOBILEPHONE, WORKPHONE, ADDRESS, POSTALCODE, CITY, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_DELETE_ONE   = "DELETE FROM Employees WHERE ID=?";
	private static final String SQL_UPDATE_ONE   = "UPDATE Employees SET NAME = ?, FIRSTNAME = ?, HOMEPHONE = ?, MOBILEPHONE = ?, WORKPHONE = ?, ADDRESS = ?, POSTALCODE = ?, CITY = ?, EMAIL = ? WHERE ID = ?";
	///endregion

	/**
	 * Needed to get connections to the database
	 */
	private DAOFactory daoFactory;

	@Override
	public void create(@NonNull User user) throws DAOException {

	}

	@Override
	public void update(@NonNull User user) throws DAOException {

	}

	@Override
	public void delete(@NonNull User user) throws DAOException {

	}

	@Override
	public User findById(@NonNull String id) throws DAOException {
		return null;
	}
}
