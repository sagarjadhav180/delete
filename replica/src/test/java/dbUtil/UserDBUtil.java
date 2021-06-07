package dbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
					ctUserId = resultSet.getString("ct_user_id");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ctUserId;	
	}
	
	@SuppressWarnings("unused")
	public static List<String> getUsers(String org_unit_id) {
		List<String> users = new ArrayList<String>();
		postgres = new PostgresConnection();
		Connection con = postgres.getConnection();
			
		ResultSet resultSet = postgres.getResultSet("SELECT * FROM ct_user WHERE ct_user_ou_id = '"+org_unit_id+"' AND user_status = 'active' AND role_id IN ('1', '2', '3', '8')");

		try {
    	while(resultSet.next()) {
			String user = resultSet.getArray("username").toString();
			users.add(user);
		}
    	}catch (SQLException e) {
			e.printStackTrace();
		}
		return users;	
	}

	@SuppressWarnings("unused")
	public static List<String> getChildGroupUsers(String org_unit_id) {
		List<String> users = new ArrayList<String>();
		postgres = new PostgresConnection();
		Connection con = postgres.getConnection();
			
		ResultSet resultSet = postgres.getResultSet("SELECT * FROM ct_user WHERE ct_user_ou_id IN (SELECT org_unit_id FROM org_unit WHERE org_unit_parent_id = '"+org_unit_id+"') AND user_status = 'active' AND role_id IN ('1', '2', '3', '8')");

		try {
    	while(resultSet.next()) {
			String user = resultSet.getArray("username").toString();
			users.add(user);
		}
    	}catch (SQLException e) {
			e.printStackTrace();
		}
		return users;	
	}
}
