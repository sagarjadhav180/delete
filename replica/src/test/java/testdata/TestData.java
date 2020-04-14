package testdata;

import tests.TestBase;
import tests.Util;

public class TestData extends TestBase{
	
	
	public static void createData() throws Exception{
		logger=extent.startTest("Pre Suite Test data creation");
	    logger.assignCategory("Test Data");
		TestDataCreation rd=new TestDataCreation();
		
		String first_name="Automation";
		String last_name="Account";
		String user_name="automation_account@yopmail.com";
		String pass_word="automation_account";
		String group=Util.readingFromDB("SELECT count(*) as count FROM org_unit WHERE org_unit_name LIKE '"+account+"' AND top_ou_id='"+billing_id+"' AND org_unit_status='active'");
		String campaign=Util.readingFromDB("SELECT count(*) as count FROM campaign WHERE campaign_name LIKE '"+campaignToBeEdited+"' AND campaign_ou_id='"+org_unit_id+"'");
		String tracking_number=Util.readingFromDB("SELECT count(*) as count FROM campaign_provisioned_route WHERE campaign_id IN (SELECT campaign_id FROM campaign WHERE campaign_name LIKE '"+campaignToBeEdited+"' AND campaign_ou_id='"+org_unit_id+"') AND provisioned_route_id IN (SELECT provisioned_route_id FROM provisioned_route WHERE provisioned_route_status='active')");
		String geoLocation=Util.readingFromDB("SELECT count(*) as count FROM location WHERE location_name='"+geo_location+"' AND org_unit_id='"+org_unit_id+"'");
		String webHook=Util.readingFromDB("SELECT count(*) as count FROM webhook WHERE org_unit_id='"+org_unit_id+"' AND webhook_name LIKE '"+webhook+"'");
		String user=Util.readingFromDB("SELECT count(*) as count FROM ct_user WHERE username LIKE '"+user_name+"'");
		String record_call_checkbox=Util.readingFromDB("SELECT record_call as count FROM default_provisioned_route WHERE org_unit_id='"+org_unit_id+"'");
		String voice_prompt_checkbox=Util.readingFromDB("SELECT play_voice_prompt_first as count FROM default_provisioned_route WHERE org_unit_id='"+org_unit_id+"'");
		String whisper_checkbox=Util.readingFromDB("SELECT play_whisper_message as count FROM default_provisioned_route WHERE org_unit_id='"+org_unit_id+"' ");
		String time_zone=Util.readingFromDB("SELECT timezone as count FROM ct_user_detail WHERE ct_user_id=(SELECT ct_user_id FROM ct_user WHERE username LIKE '"+user_id+"')");
		
		rd.login();
		
		System.out.println("group "+group);
		if(group.equals("0") || group==null){
			System.out.println("creating group");
			rd.createGroup();
			rd.navigateToGroup();
		}
		
		System.out.println("user "+user);		
		if(user.equals("0") || user==null){
			System.out.println("creating user");
			rd.createUser(first_name,last_name,user_name);
			TestBase.setUser_id(user_name);
			
			
			TestDataCreation tc=new TestDataCreation();
			tc.logOut();
			tc.login();
		}

		System.out.println("campaign "+campaign);
		if(campaign.equals("0") || campaign==null){
			rd.createCampaign();
		}

		System.out.println("tracking_number "+tracking_number);
		if(tracking_number.equals("0") || tracking_number==null){
			rd.createWebhook();
			rd.createGeoLoaction();
			rd.createTrackingNumber();
		}

		System.out.println("geoLocation "+geoLocation);
		if(geoLocation.equals("0") || geoLocation==null){
			rd.createGeoLoaction();
		}

		System.out.println("webHook "+webHook);
		if(webHook.equals("0") || webHook==null){
			rd.createWebhook();
		}
		
		System.out.println("record_call_checkbox "+record_call_checkbox);
		System.out.println("voice_prompt_checkbox "+voice_prompt_checkbox);
		System.out.println("whisper_checkbox "+whisper_checkbox);
		
        if(!(record_call_checkbox.equals("t") && voice_prompt_checkbox.equals("f") && whisper_checkbox.equals("f"))){
    		System.out.println("updating default tn settings");
        	rd.trackingNumberSettings();        	
        }

        if(!(time_zone.equals(account_timezone))){
        	System.out.println("updating time zone");
        	rd.timeZone();		
        }
	    TestBase.test();
		
		rd.logOut();
	}

}
