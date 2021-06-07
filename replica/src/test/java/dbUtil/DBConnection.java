package dbUtil;

import java.sql.Connection;
import java.sql.ResultSet;

public interface DBConnection {
	public Connection getConnection();
	public ResultSet getResultSet(String query);
}
