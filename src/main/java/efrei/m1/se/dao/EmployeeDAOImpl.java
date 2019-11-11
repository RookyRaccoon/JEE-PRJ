package efrei.m1.se.dao;

import efrei.m1.se.model.User;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class to easily manipulate {@link User} objects in the database
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EmployeeDAOImpl implements EmployeeDAO {

	///region JPA Config
	private static final String JPA_PERSISTENCE_UNIT = "EmployeePU";

	private EntityManager entityManager;
	///endregion

	///region JPQL Queries
	private static final String JPQL_FIND_ALL = "SELECT u FROM User u";
	private static final String JPQL_FIND_BY_ID = "SELECT u FROM User u WHERE u.id=:employeeId";
	///endregion

	///region SQL Table Columns
	///////////////////////////////////////////////////////////////////////////
	// SQL TABLE COLUMNS
	///////////////////////////////////////////////////////////////////////////
	static final String DB_COL_NAME = "NAME";
	static final String DB_COL_SURNAME = "FIRSTNAME";
	static final String DB_COL_PERSONALPHONE = "HOMEPHONE";
	static final String DB_COL_MOBILEPHONE = "MOBILEPHONE";
	static final String DB_COL_WORKPHONE = "WORKPHONE";
	static final String DB_COL_ADDRESS = "ADDRESS";
	static final String DB_COL_POSTALCODE = "POSTALCODE";
	static final String DB_COL_CITY = "CITY";
	static final String DB_COL_EMAIL = "EMAIL";
	static final String DB_COL_ID = "ID";
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

	/**
	 *
	 * @param daoFactory DAOFactory to use
	 */
	EmployeeDAOImpl(@NonNull DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
		this.entityManager = Persistence.createEntityManagerFactory(JPA_PERSISTENCE_UNIT).createEntityManager();
	}

	@Override
	public void create(@NonNull User user) throws DAOException {
		try {
			this.entityManager.persist(user);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void update(@NonNull User user) throws DAOException {
		try {
			this.entityManager.persist(user);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(@NonNull User user) throws DAOException {
		try {
			this.entityManager.remove(user);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public User findById(@NonNull String id) throws DAOException {
		User employee;

		// Setting up the JPQL query responsible for selection by id
		TypedQuery<User> findByIdQuery = this.entityManager.createQuery(JPQL_FIND_BY_ID, User.class);
		findByIdQuery.setParameter("employeeId", id);

		try {
			employee = findByIdQuery.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} catch (Exception e) {
			throw new DAOException(e);
		}

		return employee;
	}

	@Override
	public ArrayList<User> findAll() throws DAOException {
		ArrayList<User> employees;

		TypedQuery<User> findAllQuery = this.entityManager.createQuery(JPQL_FIND_ALL, User.class);

		try {
			employees = (ArrayList<User>) findAllQuery.getResultList();
		} catch (NoResultException e) {
			return new ArrayList<>();
		} catch (Exception e) {
			throw new DAOException(e);
		}

		return employees;
	}
}
