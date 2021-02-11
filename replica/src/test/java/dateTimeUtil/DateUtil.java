package dateTimeUtil;

import java.util.HashMap;
import java.util.Map;

import tests.Util;

public class DateUtil {
	
	public static Map getDefaultDateRange(String range) {
		
		Map<String, String> dateRange = new HashMap<String, String>();
		
		switch(range) {
		case "today":
		    String endDateToBeUsedForToday = Util.getDate("yyyy-MM-dd","1");
			String startDateToBeUsedForToday = Util.getDate("yyyy-MM-dd","0");
			dateRange.put("endDateToBeUsed", endDateToBeUsedForToday);
			dateRange.put("startDateToBeUsed", startDateToBeUsedForToday);
			break;
		case "yesterday":
		    String endDateToBeUsedForYesterday = Util.getDate("yyyy-MM-dd","-1");
			String startDateToBeUsedForYesterday = Util.getDate("yyyy-MM-dd","0");
			dateRange.put("endDateToBeUsed", endDateToBeUsedForYesterday);
			dateRange.put("startDateToBeUsed", startDateToBeUsedForYesterday);
			break;
		case "last 7 days":
		    String endDateToBeUsedForLast7Days = Util.getDate("yyyy-MM-dd","1");
			String startDateToBeUsedForLast7Days = Util.getDate("yyyy-MM-dd","-6");
			dateRange.put("endDateToBeUsed", endDateToBeUsedForLast7Days);
			dateRange.put("startDateToBeUsed", startDateToBeUsedForLast7Days);
			break;
		case "last 30 days":
		    String endDateToBeUsedForLast30Days = Util.getDate("yyyy-MM-dd","1");
			String startDateToBeUsedForLast30Days = Util.getDate("yyyy-MM-dd","-29");
			dateRange.put("endDateToBeUsed", endDateToBeUsedForLast30Days);
			dateRange.put("startDateToBeUsed", startDateToBeUsedForLast30Days);
			break;
		case "this month":
			break;		
		case "last month":
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
