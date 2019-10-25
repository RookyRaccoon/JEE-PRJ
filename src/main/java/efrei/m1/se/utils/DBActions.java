package efrei.m1.se.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBActions {
	private static Connection dbConnection = null;

	/**
	 * Private constructor to make the class "fully static"
	 */
	private DBActions() {}

	private static void initConnection() {
		// Do not reload the database connection if already loaded
		if (dbConnection != null) {
			return;
		}

		Properties dbProps = DBActions.getDBProperties();
		String url = dbProps.getProperty("dbUrl");
		String user = dbProps.getProperty("dbUser");
		String pwd = dbProps.getProperty("dbPassword");

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

			dbConnection = DriverManager.getConnection(url, user, pwd);
		} catch (ClassNotFoundException e) {
			System.out.println("An error occurred while instantiating Derby JDBC driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("An error occurred while gathering a database connection");
			e.printStackTrace();
		}
	}


	/**
	 * Get a {@link Properties} object representing database connection information
	 * @return {@link Properties} object representing database connection information
	 */
	private static Properties getDBProperties() {
		Properties dbProps = new Properties();

		try {
			FileInputStream propsFile = new FileInputStream(Constants.DB_PROP_FILE_PATH);

			dbProps.load(propsFile);

		} catch (FileNotFoundException e) {
			System.err.println("Unable to find db.properties file");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("Unable to read database properties file");
			e.printStackTrace();
		}

		return dbProps;
	}


	/**
	 * Executes an update type query (INSERT, UPDATE, DELETE) on the database
	 * @param query SQL query to execute
	 * @return Status of the query
	 */
	public static int executeUpdate(final String query) {
		DBActions.initConnection();

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
		DBActions.initConnection();

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
		DBActions.initConnection();

		return dbConnection.prepareStatement(sql);
	}
}
