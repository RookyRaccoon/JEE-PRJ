package efrei.m1.se.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBActions {
	private static Connection DB_CONNECTION = null;

	/**
	 * Private constructor to make the class "fully static"
	 */
	private DBActions() {}

	public static void initConnection() {
		// Do not reload the database connection if already loaded
		if (DB_CONNECTION != null) {
			return;
		}

		Properties dbProps = DBActions.getDBProperties();
		String url = dbProps.getProperty("dbUrl");
		String user = dbProps.getProperty("dbUser");
		String pwd = dbProps.getProperty("dbPassword");

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

			DB_CONNECTION = DriverManager.getConnection(url, user, pwd);
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
}
