package dbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dbUtil.PostgresConnection;

public class ScorecardDBUtil {
private static PostgresConnection postgres;
	
	@SuppressWarnings("unused")
	public static int getScorecardsRecords(String ct_user_id) {
		  int scorecards= 0;
			postgres = new PostgresConnection();
			Connection con = postgres.getConnection();
			
			ResultSet resultSet = postgres.getResultSet("SELECT COUNT(*) as scorecards_count FROM score_cards WHERE created_by = '"+ct_user_id+"' AND scorecard_status = 'active'");

			try {
				while(resultSet.next()) {
					scorecards = resultSet.getInt("scorecards_count");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return scorecards;	
	}
	
	
}
