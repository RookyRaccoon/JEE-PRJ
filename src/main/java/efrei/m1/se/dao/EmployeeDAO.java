package efrei.m1.se.dao;

import efrei.m1.se.model.User;

import lombok.NonNull;

import java.util.ArrayList;

/**
 * Interface describing all methods
 */
public interface EmployeeDAO {
	/**
	 * Create a {@link User} database record
	 * @param user User to store in the database
	 * @throws DAOException If an error occurs with the database
	 */
	void create(@NonNull User user) throws DAOException;

	/**
	 * Update a {@link User} database record
	 * @param user User to update in the database
	 * @param dbId
	 * @throws DAOException If an error occurs with the database
	 */
	void update(@NonNull User user, String dbId) throws DAOException;

	/**
	 * Delete a {@link User} database record
	 * @param user User to delete from the database
	 * @throws DAOException If an error occurs with the database
	 */
	void delete(@NonNull User user) throws DAOException;

	/**
	 * Find a {@link User} database record by its id
	 * @param id ID to look for in the database
	 * @return Instance of {@link User} if record found, {@code null} otherwise
	 * @throws DAOException If an error occurs with the database
	 */
	User findById(@NonNull String id) throws DAOException;

	/**
	 * Get a list of all {@link User}s in the database
	 * @return {@link ArrayList} of {@link User}s contained in the database
	 * @throws DAOException If an error occurs with the database
	 */
	ArrayList<User> findAll() throws DAOException;
}
