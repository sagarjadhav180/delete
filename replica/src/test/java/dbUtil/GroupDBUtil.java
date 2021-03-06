package dbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GroupDBUtil {

private static PostgresConnection postgres;
	
	@SuppressWarnings("unused")
	public static List<String> getChildGroups(String org_unit_id) {
		List<String> groups= new ArrayList<String>();
		postgres = new PostgresConnection();
		Connection con = postgres.getConnection();
			
		ResultSet resultSet = postgres.getResultSet("SELECT * FROM org_unit WHERE top_ou_id = '"+org_unit_id+"' AND org_unit_status = 'active'");

		try {
    	while(resultSet.next()) {
			String group = resultSet.getArray("org_unit_name").toString();
			groups.add(group);
		}
    	}catch (SQLException e) {
			e.printStackTrace();
		}
		return groups;	
	}

	@SuppressWarnings("unused")
	public static String getGroupName(String org_unit_id) {
		String group= null;
		postgres = new PostgresConnection();
		Connection con = postgres.getConnection();
			
		ResultSet resultSet = postgres.getResultSet("SELECT * FROM org_unit WHERE org_unit_id = '"+org_unit_id+"'");

		try {
    	while(resultSet.next()) {
			group = resultSet.getArray("org_unit_name").toString();			
		}
    	}catch (SQLException e) {
			e.printStackTrace();
		}
		return group;	
	}
	
	@SuppressWarnings("unused")
	public static String getOrgUnitId(String groupName) {
		String group= null;
		postgres = new PostgresConnection();
		Connection con = postgres.getConnection();
			
		ResultSet resultSet = postgres.getResultSet("SELECT * FROM org_unit WHERE org_unit_name = '"+groupName+"' AND org_unit_status = 'active'");

		try {
    	while(resultSet.next()) {
			group = resultSet.getArray("org_unit_id").toString();			
		}
    	}catch (SQLException e) {
			e.printStackTrace();
		}
		return group;	
	}
	
}
