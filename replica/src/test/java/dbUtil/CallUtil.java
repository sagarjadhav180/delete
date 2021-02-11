package dbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import dateTimeUtil.DateUtil;
import tests.TestBase;
import utilConstants.UtilityConstants;

public class CallUtil {
private static PostgresConnection postgres;
	
	@SuppressWarnings("unused")
	public static String getCallRecordsCount(String dateRange, String org_unit_id) {
		  String calls= null;
			postgres = new PostgresConnection();
			Connection con = postgres.getConnection();
			
			//get start date and end date
			Map<String, String> range = DateUtil.getDefaultDateRange(dateRange);
			String startDateToBeUsed = range.get("startDateToBeUsed");
			String endDateToBeUsed = range.get("endDateToBeUsed");
			
			ResultSet resultSet = postgres.getResultSet("SELECT count(*) as calls_count  FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+org_unit_id+"') AND call_started BETWEEN '"+startDateToBeUsed+" 05:00' AND '"+endDateToBeUsed+" 04:00'");

			try {
				while(resultSet.next()) {
					calls = resultSet.getString("calls_count");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return calls;	
	}
	

	
}
