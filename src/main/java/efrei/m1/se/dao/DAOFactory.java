package efrei.m1.se.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.NonNull;

public class DAOFactory {
	///region Properties
	///////////////////////////////////////////////////////////////////////////
	// STATIC PROPERTIES
	///////////////////////////////////////////////////////////////////////////
	private static final String PROP_URL = "jdbcUrl";
	private static final String PROP_USER = "user";
	private static final String PROP_PASSWORD = "password";
	private static final String PROP_DRIVER = "driver";

	///////////////////////////////////////////////////////////////////////////
	// INSTANCE PROPERTIES
	///////////////////////////////////////////////////////////////////////////
	/**
	 * Connection Pooling data source
	 */
	private HikariDataSource dataSource;
	///endregion


	///region Initializers (constructor + getInstance)
	///////////////////////////////////////////////////////////////////////////
	// CONSTRUCTORS & INSTANTIATING METHODS
	///////////////////////////////////////////////////////////////////////////

	/**
	 * Set the data source to use for connection pooling
	 * <br /><br />
	 * <i>This method is private to enforce use of Factory method pattern</i>
	 * @param config Configuration of the data source
	 */
	private DAOFactory(@NonNull HikariConfig config) {
		this.dataSource = new HikariDataSource(config);
	}

	///endregion
}
