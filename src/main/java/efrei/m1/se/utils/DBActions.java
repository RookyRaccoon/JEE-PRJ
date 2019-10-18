package efrei.m1.se.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBActions {
	private static String DB_USERNAME;
	private static String DB_PASSWORD;
	private static String DB_URL;

	private static Connection DB_CONNECTION = null;

	/**
	 * Private constructor to make the class "fully static"
	 */
	private DBActions() {}


	public static void initConnection(String url, String username, String password) {
		// Do not (re)load the database if not necessary
		if (DB_CONNECTION != null) {
			return;
		}

		DB_URL = url;
		DB_USERNAME = username;
		DB_PASSWORD = password;

		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("An error occurred while instantiating Derby JDBC driver");
			e.printStackTrace();
		}

		try {
			DB_CONNECTION = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (SQLException e) {
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
