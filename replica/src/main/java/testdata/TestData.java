package testdata;

import java.util.Objects;

import apiEndpoints.CallUpload;
import tests.TestBase;
import tests.Util;

@SuppressWarnings("unused")
public class TestData extends TestBase{
		
	public static void createData() throws Exception{
		logger=extent.startTest("Pre Suite Test data creation");
	    logger.assignCategory("Test Data");
		TestDataCreation rd=new TestDataCreation();
		
		String first_name="Automation";
		String last_name="Account";
		String first_last_name="Automation Account";
		String user_name="automation_account@yopmail.com";
		String pass_word="automation_account";

		//logging in 
		rd.login();
		
		//setting group_id
		String group=Util.readingFromDB("SELECT ct_user_ou_id AS count FROM ct_user WHERE username LIKE '"+TestBase.getUser_id()+"'");
		System.out.println("group "+group);
		TestBase.setOrg_unit_id(group);
		TestBase.setCampaign_ou_id(group);
		
		//group
//		String group=Util.readingFromDB("SELECT org_unit_id as count FROM org_unit WHERE org_unit_name LIKE '"+account+"' AND org_unit_status='active'");
//		System.out.println("group "+group);
//		if(group!=null){
//			TestBase.setOrg_unit_id(group);
//		    TestBase.setCampaign_ou_id(group);
//		}  
//		else{
//			System.out.println("creating group");
//			rd.createGroup();
//			rd.navigateToGroup();
//			String orgUnitID=Util.readingFromDB("SELECT org_unit_id as count FROM org_unit WHERE org_unit_name LIKE '"+account+"' AND top_ou_id='"+org_unit_id+"' AND org_unit_status='active'");
//		    TestBase.setOrg_unit_id(orgUnitID);
//		    TestBase.setCampaign_ou_id(orgUnitID);
//		}
		
		//user
//		String user=Util.readingFromDB("SELECT count(*) as count FROM ct_user WHERE username LIKE '"+user_name+"'");
//		System.out.println("user "+user);		
//		if(user!=null){
//
//			TestBase.setFirst_name(first_name);
//			TestBase.setLast_name(last_name);
//			TestBase.setFirst_last_name(first_last_name);
//		}
//		else{
//			System.out.println("creating user");
//			rd.createUser(first_name,last_name,user_name);
//			TestBase.setUser_id(user_name);
//			TestBase.setFirst_name(first_name);
//			TestBase.setLast_name(last_name);
//			TestBase.setFirst_last_name(first_last_name);
//			
//			TestDataCreation tc=new TestDataCreation();
//			tc.logOut();
//			tc.login();
//		}
		
		//campaign
		System.out.println("SELECT campaign_id as count FROM campaign WHERE campaign_name LIKE '"+campaignToBeEdited+"' AND campaign_ou_id='"+TestBase.getOrg_unit_id()+"' AND campaign_status='active'");
		String campaign=Util.readingFromDB("SELECT campaign_id as count FROM campaign WHERE campaign_name LIKE '"+campaignToBeEdited+"' AND campaign_ou_id='"+TestBase.getOrg_unit_id()+"' AND campaign_status='active'");
		System.out.println("campaign "+campaign);
		if(campaign!=null){
			TestBase.setCampaign_id(campaign);			
		}
		else{
			rd.createCampaign();
			String campaignID=Util.readingFromDB("SELECT campaign_id as count FROM campaign WHERE campaign_name='"+campaignToBeEdited+"' AND campaign_ou_id='"+org_unit_id+"' AND campaign_status='active'");
		    TestBase.setCampaign_id(campaignID);
		}
		
		//geo location
		String geoLocation=Util.readingFromDB("SELECT count(*) as count FROM location WHERE location_name='"+geo_location+"' AND org_unit_id='"+TestBase.getOrg_unit_id()+"' AND location_active='t'");
		System.out.println("geoLocation "+geoLocation);
		if(geoLocation.equals("0") ){
			rd.createGeoLoaction();
		}System.out.println();
		
		//webhook
		String webHook=Util.readingFromDB("SELECT count(*) as count FROM webhook WHERE org_unit_id='"+TestBase.getOrg_unit_id()+"' AND webhook_name LIKE '"+webhook+"'");
		System.out.println("webHook "+webHook);
		if(webHook.equals("0")){
			rd.createWebhook();
		}

		
		//tracking number
		String tracking_number=Util.readingFromDB("SELECT count(*) as count FROM campaign_provisioned_route WHERE campaign_id IN (SELECT campaign_id FROM campaign WHERE campaign_name LIKE '"+campaignToBeEdited+"' AND campaign_ou_id='"+TestBase.getOrg_unit_id()+"') AND provisioned_route_id IN (SELECT provisioned_route_id FROM provisioned_route WHERE provisioned_route_status='active')");
		System.out.println("tracking_number "+tracking_number);
		if((tracking_number.equals("0"))){
			rd.createTrackingNumber();	
		}
		
		//call upload
		CallUpload callUpload = new CallUpload();
		callUpload.uploadCalls();

		//groups n user settings
		String record_call_checkbox=Util.readingFromDB("SELECT record_call as count FROM default_provisioned_route WHERE org_unit_id='"+TestBase.getOrg_unit_id()+"'");
		String voice_prompt_checkbox=Util.readingFromDB("SELECT play_voice_prompt_first as count FROM default_provisioned_route WHERE org_unit_id='"+TestBase.getOrg_unit_id()+"'");
		String whisper_checkbox=Util.readingFromDB("SELECT play_whisper_message as count FROM default_provisioned_route WHERE org_unit_id='"+TestBase.getOrg_unit_id()+"' ");

		
		System.out.println("record_call_checkbox "+record_call_checkbox);
		System.out.println("voice_prompt_checkbox "+voice_prompt_checkbox);
		System.out.println("whisper_checkbox "+whisper_checkbox);
		
		if(record_call_checkbox!=null) {
			if(!(record_call_checkbox.equals("t") && voice_prompt_checkbox.equals("f") && whisper_checkbox.equals("f"))){	
    		System.out.println("updating default tn settings");
        	rd.trackingNumberSettings();        	
        }
		}else {
			System.out.println("updating default tn settings");
        	rd.trackingNumberSettings();	
		}
        
        
        //Time zone settings
		String time_zone=Util.readingFromDB("SELECT timezone as count FROM ct_user_detail WHERE ct_user_id=(SELECT ct_user_id FROM ct_user WHERE username LIKE '"+user_id+"')");

        if(!(time_zone.equals(account_timezone))){
        	System.out.println("updating time zone");
        	rd.timeZone();		
        }

		//logging out
		rd.logOut();
	}

}
