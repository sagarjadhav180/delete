package dbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

	@SuppressWarnings("unused")
	public static String getCallId(String callTitle) {
		String callID= null;
			postgres = new PostgresConnection();
			Connection con = postgres.getConnection();
			
			ResultSet resultSet = postgres.getResultSet("SELECT * FROM call_fields WHERE call_title = '"+callTitle+"' ");

			try {
				while(resultSet.next()) {
					callID = resultSet.getString("call_id");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return callID;	
	}

	@SuppressWarnings("unused")
	public static String getCallScore(String callID) {
		String callScore= null;
			postgres = new PostgresConnection();
			Connection con = postgres.getConnection();
			
			ResultSet resultSet = postgres.getResultSet("SELECT * FROM score_card_calls WHERE call_id = '"+callID+"'");

			try {
				while(resultSet.next()) {
					callScore = resultSet.getString("final_score");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return callScore;	
	}
	
	@SuppressWarnings("unused")
	public static List<String> getScorecardsIds(String org_unit_id) {
		  List<String> scorecardIds = null;
			postgres = new PostgresConnection();
			Connection con = postgres.getConnection();
			
			ResultSet resultSet = postgres.getResultSet("SELECT * FROM score_cards WHERE '"+org_unit_id+"' = ANY(groups_list) AND scorecard_status = 'active'");

			try {
				while(resultSet.next()) {
					String scorecardId = resultSet.getArray("score_card_id").toString();
					scorecardIds.add(scorecardId);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return scorecardIds;	
	}

	@SuppressWarnings("unused")
	public static List<String> getScorecardsNames(String org_unit_id) {
		  List<String> scorecardNames = null;
			postgres = new PostgresConnection();
			Connection con = postgres.getConnection();
			
			ResultSet resultSet = postgres.getResultSet("SELECT * FROM score_cards WHERE '"+org_unit_id+"' = ANY(groups_list) AND scorecard_status = 'active'");

			try {
				while(resultSet.next()) {
					String scorecardId = resultSet.getArray("score_card_title").toString();
					scorecardNames.add(scorecardId);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return scorecardNames;	
	}
	
	
	
}
