package efrei.m1.se.dao;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
}
