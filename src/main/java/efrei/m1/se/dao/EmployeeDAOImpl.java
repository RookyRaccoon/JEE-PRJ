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
import java.util.ArrayList;

/**
 * Class to easily manipulate {@link User} objects in the database
 */
@AllArgsConstructor @NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeDAOImpl implements EmployeeDAO {

	///region SQL Table Columns
	///////////////////////////////////////////////////////////////////////////
	// SQL TABLE COLUMNS
	///////////////////////////////////////////////////////////////////////////
	public static final String DB_COL_NAME = "NAME";
	public static final String DB_COL_SURNAME = "FIRSTNAME";
	public static final String DB_COL_PERSONALPHONE = "HOMEPHONE";
	public static final String DB_COL_MOBILEPHONE = "MOBILEPHONE";
	public static final String DB_COL_WORKPHONE = "WORKPHONE";
	public static final String DB_COL_ADDRESS = "ADDRESS";
	public static final String DB_COL_POSTALCODE = "POSTALCODE";
	public static final String DB_COL_CITY = "CITY";
	public static final String DB_COL_EMAIL = "EMAIL";
	public static final String DB_COL_ID = "ID";
	///endregion


	///region SQL Queries
	///////////////////////////////////////////////////////////////////////////
	// SQL Queries
	///////////////////////////////////////////////////////////////////////////
	private static final String SQL_SELECT_BY_ID = "SELECT ID, NAME, FIRSTNAME, HOMEPHONE, MOBILEPHONE, WORKPHONE, ADDRESS, POSTALCODE, CITY, EMAIL FROM Employees WHERE ID = ?";
	private static final String SQL_INSERT_ONE   = "INSERT INTO Employees(NAME, FIRSTNAME, HOMEPHONE, MOBILEPHONE, WORKPHONE, ADDRESS, POSTALCODE, CITY, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String SQL_DELETE_ONE   = "DELETE FROM Employees WHERE ID=?";
	private static final String SQL_UPDATE_ONE   = "UPDATE Employees SET NAME = ?, FIRSTNAME = ?, HOMEPHONE = ?, MOBILEPHONE = ?, WORKPHONE = ?, ADDRESS = ?, POSTALCODE = ?, CITY = ?, EMAIL = ? WHERE ID = ?";
	private static final String SQL_SELECT_ALL   = "SELECT ID, NAME, FIRSTNAME, HOMEPHONE, MOBILEPHONE, WORKPHONE, ADDRESS, POSTALCODE, CITY, EMAIL FROM Employees";
	///endregion

	/**
	 * Needed to get connections to the database
	 */
	private DAOFactory daoFactory;

	@Override
	public void create(@NonNull User user) throws DAOException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet generatedKeys = null;

		try {
			conn = this.daoFactory.getConnection();

			// Init a prepared statement with the INSERT query and the User's object properties
			preparedStatement = DAOUtils.initPreparedStatement(conn, SQL_INSERT_ONE, true,
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
			DAOUtils.silentClose(generatedKeys, preparedStatement, conn);
		}
	}

	@Override
	public void update(@NonNull User user) throws DAOException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		// Check if User object has a valid id property (otherwise it will be impossible to update a record in the database)
		if (user.getDbId() == null || user.getDbId().isEmpty()) {
			throw new DAOException("Cannot update a database record without its ID");
		}

		try {
			conn = this.daoFactory.getConnection();

			// Init a prepared statement with the UPDATE query and the User's object properties
			preparedStatement = DAOUtils.initPreparedStatement(conn, SQL_UPDATE_ONE, false,
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
			DAOUtils.silentClose(preparedStatement, conn);
		}
	}

	@Override
	public void delete(@NonNull User user) throws DAOException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;

		// Check if User object has a valid id property (otherwise it will be impossible to delete a record from the database)
		if (user.getDbId() == null || user.getDbId().isEmpty()) {
			throw new DAOException("Cannot delete a database record without its ID");
		}

		try {
			conn = this.daoFactory.getConnection();

			// Init a prepared statement with the DELETE query and the User's object id
			preparedStatement = DAOUtils.initPreparedStatement(conn, SQL_DELETE_ONE, false, user.getDbId());

			// Execute update and check number of affected rows (deleteStatus) to check if deletion is successful
			int deleteStatus = preparedStatement.executeUpdate();
			if (deleteStatus == 0) {  // If no rows were affected, deletion failed
				throw new DAOException("Unable to delete Employee record from the database, 0 rows affected.");
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtils.silentClose(preparedStatement, conn);
		}
	}

	@Override
	public User findById(@NonNull String id) throws DAOException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		User employee = null;

		try {
			conn = this.daoFactory.getConnection();

			// Init a prepared statement with the SELECT query and the id passed as a parameter to look for
			preparedStatement = DAOUtils.initPreparedStatement(conn, SQL_SELECT_BY_ID, false, id);

			resultSet = preparedStatement.executeQuery();

			// Check if result set is not empty and gather the first row of user data returned
			if (resultSet.next()) {
				employee = DAOUtils.mapUser(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DAOUtils.silentClose(resultSet, preparedStatement, conn);
		}

		return employee;
	}

	@Override
	public ArrayList<User> findAll() throws DAOException {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<User> employees = new ArrayList<>();

		try {
			conn = this.daoFactory.getConnection();

			// Using a prepared statement here to benefit from precompiled statements greater speed
			preparedStatement = DAOUtils.initPreparedStatement(conn, SQL_SELECT_ALL, false);

			resultSet = preparedStatement.executeQuery();

			// Add all employees returned by the query to the ArrayList of User
			while (resultSet.next()) {
				employees.add(DAOUtils.mapUser(resultSet));
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			DAOUtils.silentClose(resultSet, preparedStatement, conn);
		}

		return employees;
	}
}
