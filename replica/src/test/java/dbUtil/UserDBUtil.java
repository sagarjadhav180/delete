package dbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDBUtil {
	  private static PostgresConnection postgres;
	
	@SuppressWarnings("unused")
	public static String getCTUserId(String username) {
		  String ctUserId= "";
			postgres = new PostgresConnection();
			Connection con = postgres.getConnection();
			
			ResultSet resultSet = postgres.getResultSet("SELECT * FROM ct_user WHERE username LIKE '"+username+"'");

			try {
				while(resultSet.next()) {
					ctUserId = resultSet.getString("scorecards_count");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ctUserId;	
	}

}
