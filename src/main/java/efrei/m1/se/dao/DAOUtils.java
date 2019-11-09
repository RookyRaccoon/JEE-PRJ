package efrei.m1.se.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.*;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DAOUtils {
	/**
	 * Get a {@link PreparedStatement} with all the needed parameters already set
	 * @param conn Database connection to use
	 * @param sql SQL Query to prepare
	 * @param returnGeneratedKeys Whether to return the generated keys
	 * @param queryParameters Parameters of the SQL Query (replacing the {@code ?} in the SQL Query string)
	 */
	public static PreparedStatement initPreparedStatement(@NonNull Connection conn, @NonNull final String sql, final boolean returnGeneratedKeys, Object... queryParameters) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);

		// Set query parameters inside the prepared statement
		for (int i = 0; i < queryParameters.length; i++) {
			ps.setObject(i+1, queryParameters[i]);
		}

		return ps;
	}


	/**
	 * Silently close a {@link Statement}
	 * @param statement Statement to close
	 */
	public static void silentClose(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException ignore) {}
		}
	}

	/**
	 * Silently close a {@link ResultSet}
	 * @param rs ResultSet to close
	 */
	public static void silentClose(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException ignore) {}
		}
	}

	/**
	 * Silently close a {@link Connection}
	 * @param conn Connection to close
	 */
	public static void silentClose(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException ignore) {}
		}
	}

	/**
	 * Silently close a {@link Statement} and a {@link Connection}
	 * @param statement Statement to close
	 * @param conn Connection to close
	 */
	public static void silentClose(Statement statement, Connection conn) {
		silentClose(statement);
		silentClose(conn);
	}

	/**
	 * Silently close a {@link ResultSet}, a {@link Statement} and a {@link Connection}
	 * @param rs ResultSet to close
	 * @param statement Statement to close
	 * @param conn Connection to close
	 */
	public static void silentClose(ResultSet rs, Statement statement, Connection conn) {
		silentClose(rs);
		silentClose(statement, conn);
	}
}
