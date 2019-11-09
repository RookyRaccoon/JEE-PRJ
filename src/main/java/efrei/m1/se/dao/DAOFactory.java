package efrei.m1.se.dao;

import com.zaxxer.hikari.HikariDataSource;

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
}
