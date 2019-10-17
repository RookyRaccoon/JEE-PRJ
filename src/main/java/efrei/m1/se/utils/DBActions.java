package efrei.m1.se.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBActions {
	private static String DB_USERNAME;
	private static String DB_PASSWORD;
	private static String DB_URL;

	private static Connection DB_CONNECTION = null;


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
}
