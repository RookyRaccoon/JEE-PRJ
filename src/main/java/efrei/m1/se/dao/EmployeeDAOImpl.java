package efrei.m1.se.dao;

import efrei.m1.se.model.User;

import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Class to easily manipulate {@link User} objects in the database
 */
public class EmployeeDAOImpl implements EmployeeDAO {

	///region JPA Config
	private static final String JPA_PERSISTENCE_UNIT = "EmployeePU";

	private EntityManager entityManager;
	///endregion

	///region JPQL Queries
	private static final String JPQL_FIND_ALL = "SELECT u FROM User u";
	///endregion


	/**
	 * Create a new instance of EmployeeDAOImpl
	 */
	public EmployeeDAOImpl() {
		this.entityManager = Persistence.createEntityManagerFactory(JPA_PERSISTENCE_UNIT).createEntityManager();
	}

	@Override
	public void create(@NonNull User user) throws DAOException {
		try {
			// Prepare a transaction to ensure the changes are written into the database
			EntityTransaction transaction = this.entityManager.getTransaction();
			transaction.begin();

			this.entityManager.persist(user);

			transaction.commit();  // Commit the transaction to write changes to the database
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void update(@NonNull User user, String dbId) throws DAOException {
		try {
			// Gather the employee record to update
			User employeeToUpdate = this.entityManager.find(User.class, dbId);

			// Prepare a transaction to ensure the changes are written into the database
			EntityTransaction transaction = this.entityManager.getTransaction();
			transaction.begin();

			employeeToUpdate.setName(user.getName());
			employeeToUpdate.setSurname(user.getSurname());
			employeeToUpdate.setPersonalPhone(user.getPersonalPhone());
			employeeToUpdate.setMobilePhone(user.getMobilePhone());
			employeeToUpdate.setWorkPhone(user.getWorkPhone());
			employeeToUpdate.setAddress(user.getAddress());
			employeeToUpdate.setCity(user.getCity());
			employeeToUpdate.setEmail(user.getEmail());

			transaction.commit();  // Commit the transaction to write changes to the database
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(@NonNull User user) throws DAOException {
		try {
			// Prepare a transaction to ensure the changes are written into the database
			EntityTransaction transaction = this.entityManager.getTransaction();
			transaction.begin();

			this.entityManager.remove(user);

			transaction.commit();  // Commit the transaction to write changes to the database
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public User findById(String id) throws DAOException {
		User employee;

		try {
			employee = this.entityManager.find(User.class, id);
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
