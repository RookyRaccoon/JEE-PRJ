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
