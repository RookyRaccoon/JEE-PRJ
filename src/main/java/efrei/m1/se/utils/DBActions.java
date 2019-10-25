package efrei.m1.se.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBActions {
	private static Connection dbConnection = null;

	private static Properties dbProperties = null;

	/**
	 * Private constructor to make the class "fully static"
	 */
	private DBActions() {}

	public static boolean isReady() {
		return !(dbProperties == null || dbConnection == null);
	}

	public static void init(final InputStream dbPropsInputStream) {
		// No need to initialize the database connection multiple times
		if (isReady()) {
			return;
		}

		try {
			// Load the database properties
			DBActions.dbProperties = new Properties();
			DBActions.dbProperties.load(dbPropsInputStream);

			final String url = dbProperties.getProperty("dbUrl");
			final String user = dbProperties.getProperty("dbUser");
			final String pwd = dbProperties.getProperty("dbPassword");

			// Initialize database connection
			try {
				Class.forName("com.mysql.jdbc.Driver");

				DBActions.dbConnection = DriverManager.getConnection(url, user, pwd);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * Executes an update type query (INSERT, UPDATE, DELETE) on the database
	 * @param query SQL query to execute
	 * @return Status of the query
	 */
	public static int executeUpdate(final String query) {
		if (!DBActions.isReady()) {
			return -1;
		}

		try {
			Statement stmt = dbConnection.createStatement();

			return stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}

	/**
	 * Executes a read type query (SELECT) on the database
	 * @param query SQL query to execute
	 * @return Matching rows
	 */
	public static ResultSet executeRead(final String query) {
		if (!DBActions.isReady()) {
			return null;
		}

		try {
			Statement stmt = dbConnection.createStatement();
			return stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * Produces a prepared statement linked to the database
	 * @param sql SQL prepared statement query string
	 * @return Prepared statement connected to the database
	 * @throws SQLException In case of an error with the SQL
	 */
	public static PreparedStatement getPreparedStatement(final String sql) throws SQLException {
		if (!DBActions.isReady()) {
			return null;
		}

		return dbConnection.prepareStatement(sql);
	}
}
