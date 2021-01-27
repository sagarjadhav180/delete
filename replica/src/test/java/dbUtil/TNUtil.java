package dbUtil;

import tests.Util;

public class TNUtil {

	
	public static String getTN(String org_unit_id) {
		
		String tn = Util.readingFromDB("SELECT dnis AS count FROM ce_call_flows WHERE dnis IS NOT NULL AND ouid IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id ='"+org_unit_id+"') AND status IN ('active')  ORDER BY dnis  DESC LIMIT 1");
		return tn;
	}
	
	
    public static String getCampaignId(String dnis) {
		
		String campaign_id = Util.readingFromDB("SELECT campaign_id AS count FROM campaign_provisioned_route WHERE provisioned_route_id IN (SELECT provisioned_route_id FROM ce_call_flows WHERE dnis = '"+dnis+"')");
		return campaign_id;
	}
}
