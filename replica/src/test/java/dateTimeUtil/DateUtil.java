package dateTimeUtil;

import java.util.HashMap;
import java.util.Map;

import tests.Util;

public class DateUtil {
	
	public static Map getDefaultDateRange(String range) {
		
		Map<String, String> dateRange = new HashMap<String, String>();
		
		switch(range) {
		case "Today":
		    String endDateToBeUsedForToday = Util.getDate("yyyy-MM-dd","1");
			String startDateToBeUsedForToday = Util.getDate("yyyy-MM-dd","0");
			dateRange.put("endDateToBeUsed", endDateToBeUsedForToday);
			dateRange.put("startDateToBeUsed", startDateToBeUsedForToday);
			break;
		case "Yesterday":
		    String endDateToBeUsedForYesterday = Util.getDate("yyyy-MM-dd","0");
			String startDateToBeUsedForYesterday = Util.getDate("yyyy-MM-dd","-1");
			dateRange.put("endDateToBeUsed", endDateToBeUsedForYesterday);
			dateRange.put("startDateToBeUsed", startDateToBeUsedForYesterday);
			break;
		case "Last 7 Days":
		    String endDateToBeUsedForLast7Days = Util.getDate("yyyy-MM-dd","1");
			String startDateToBeUsedForLast7Days = Util.getDate("yyyy-MM-dd","-6");
			dateRange.put("endDateToBeUsed", endDateToBeUsedForLast7Days);
			dateRange.put("startDateToBeUsed", startDateToBeUsedForLast7Days);
			break;
		case "Last 30 Days":
		    String endDateToBeUsedForLast30Days = Util.getDate("yyyy-MM-dd","1");
			String startDateToBeUsedForLast30Days = Util.getDate("yyyy-MM-dd","-29");
			dateRange.put("endDateToBeUsed", endDateToBeUsedForLast30Days);
			dateRange.put("startDateToBeUsed", startDateToBeUsedForLast30Days);
			break;
		case "This Month":
			break;		
		case "Last Month":
			break;			
		}
		return dateRange;
	}
	
	//yet to right logic
    public Map getCustomDateRange(String range) {
		
		Map<String, String> dateRange = new HashMap<String, String>();
		
		
		return dateRange;
	}

}
