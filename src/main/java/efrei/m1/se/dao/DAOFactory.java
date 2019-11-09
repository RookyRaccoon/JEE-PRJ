package efrei.m1.se.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.NonNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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

	/**
	 * Cleanly build an instance of {@link DAOFactory}
	 * @param propertiesFile {@code db.properties} file
	 * @return A new instance of {@link DAOFactory}
	 * @throws DAOConfigurationException In case of a configuration problem (IO / JDBC)
	 */
	public static DAOFactory getInstance(@NonNull InputStream propertiesFile) throws DAOConfigurationException {
		// Gather database properties
		Properties dbProperties = new Properties();

		try {
			dbProperties.load(propertiesFile);
		} catch (IOException e) {
			throw new DAOConfigurationException("Unable to load database properties file.", e);
		}

		final String dbUrl = dbProperties.getProperty(PROP_URL);
		final String dbUser = dbProperties.getProperty(PROP_USER);
		final String dbPassword = dbProperties.getProperty(PROP_PASSWORD);
		final String jdbcDriver = dbProperties.getProperty(PROP_DRIVER);

		// Load JDBC driver
		try {
			Class.forName(jdbcDriver);
		} catch (ClassNotFoundException e) {
			throw new DAOConfigurationException("Unable to find driver " + jdbcDriver + " in classpath.", e);
		}

		// Create the database connection pooling properties
		HikariConfig cpConfig = new HikariConfig();
		cpConfig.setJdbcUrl(dbUrl);
		cpConfig.setUsername(dbUser);
		cpConfig.setPassword(dbPassword);

		// Return a new instance of DAOFactory only if no initialization step failed
		return new DAOFactory(cpConfig);
	}
	///endregion
}
