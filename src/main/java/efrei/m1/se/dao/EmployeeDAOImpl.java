package efrei.m1.se.dao;

import efrei.m1.se.model.User;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;

		try {
			con = this.daoFactory.getConnection();

			// Init a prepared statement with the INSERT query and the User's object properties
			preparedStatement = DAOUtils.initPreparedStatement(con, SQL_INSERT_ONE, true,
				user.getName(),
				user.getSurname(),
				user.getPersonalPhone(),
				user.getMobilePhone(),
				user.getWorkPhone(),
				user.getAddress(),
				user.getPostalCode(),
				user.getCity(),
				user.getEmail());

			// Execute statement and gather number of rows affected (status)
			int insertStatus = preparedStatement.executeUpdate();
			if (insertStatus == 0) {  // If no row were affected (no record inserted into the database)
				throw new DAOException("Unable to create Employee record in the database, 0 rows added.");
			}

			// Gather generated keys (ID of the inserted Employee)
			generatedKeys = preparedStatement.getGeneratedKeys();
			if (!generatedKeys.next()) {  // If no generated key was returned, then the Employee was not inserted in the database
				throw new DAOException("Unable to create Employee record in the database: no ID obtained.");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtils.silentClose(generatedKeys, preparedStatement, con);
		}
	}

	@Override
	public void update(@NonNull User user) throws DAOException {
		Connection con = null;
		PreparedStatement preparedStatement = null;

		// Check if User object has a valid id property (otherwise it will be impossible to update a record in the database)
		if (user.getDbId() == null || user.getDbId().isEmpty()) {
			throw new DAOException("Cannot update a database record without its ID");
		}

		try {
			con = this.daoFactory.getConnection();

			preparedStatement = DAOUtils.initPreparedStatement(con, SQL_UPDATE_ONE, false,
				user.getName(),
				user.getSurname(),
				user.getPersonalPhone(),
				user.getMobilePhone(),
				user.getWorkPhone(),
				user.getAddress(),
				user.getPostalCode(),
				user.getCity(),
				user.getEmail(),
				user.getDbId());

			// Execute update and get the number of affected rows (updateStatus) to check if update succeeded
			int updateStatus = preparedStatement.executeUpdate();
			if (updateStatus == 0) {  // If no rows were affected, update failed
				throw new DAOException("Unable to update Employee record in the database, 0 rows affected.");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtils.silentClose(preparedStatement, con);
		}
	}

	@Override
	public void delete(@NonNull User user) throws DAOException {

	}

	@Override
	public User findById(@NonNull String id) throws DAOException {
		return null;
	}
}
