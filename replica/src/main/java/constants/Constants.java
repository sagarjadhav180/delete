package constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {

	public static final String call_logs_category="Call Logs Suite";
	public static final String webhook_category="WebHook Suite";
	public static final String tracking_number_category="Tracking Number Suite";	
	public static final String campaign_category="Campaign Suite";	
	public static final String login_page_category="Login Page Suite";
	public static final String home_page_category="Home Page Suite";
	public static final String group_activity_report_category="Group Activity Reports Suite";	
	public static final String call_details_report_category="Call Details Reports Suite";		
	public static final String tracking_number_settings_report_category="Tracking Number Settings Reports Suite";	
	public static final String legacy_scheduled_report_category="Legacy Scheduled Report Suite";	
	
	public static class LegacyReports{
		
		//call details
		//Action section
		public static final String play_button="Listen to call";
		public static final String inforamtion_icon_button="Toggle Call Info";
		public static final String block_number="Block Number";
		public static final String download_audio="Download Audio File";
		public static final String email_call="Email Call";
		public static final String default_mail_id_from="no-reply@messages.services";
		public static final String default_mail_id_to="sagar.j@yopmail.com";
		public static final String default_mail_id_message="Test Automation call mail";
		
		//filters
		public static final String ad_source="Ad Source";
		public static final String caller_id="Caller ID";
		public static final String tracking_number="Tracking Number";		
		public static final String duration="Duration";
		public static final String group_name="Group Name";
		public static final String disposition="Disposition";
		public static final String line_type="Line Type";
		
		//Date range
		public static final String today="Today";
		public static final String yesterday="Yesterday";
		public static final String last_7_days="Last 7 Days";
		public static final String last_30_days="Last 30 Days";
		
		//Group Activity Reports
		public static final String basic_group_filter="Group";
		public static final String group_filter_advanced="Group Name";
		public static final String conversions="Conversions";
		public static final String answered_calls="Answered";		
		public static final String calls="Calls (GMT)";
		public static final String leads="Leads";
		public static final List<String> none=new ArrayList<String>(Arrays.asList("Campaign","Campaign Ext ID","Tracking Number"));
		public static final List<String> campaign=new ArrayList<String>(Arrays.asList("Tracking Number"));
		public static final List<String> trackingnumber=new ArrayList<String>(Arrays.asList("Campaign","Campaign Ext ID"));
	
	
	}
	
    public static class HomePage{
		
    	//main tabs
		public static final String home_page="Home";
		public static final String looker_reports="Reports";
		public static final String legacy_reports="Legacy Reports";
		public static final String campaign_tracking_number_page="Campaign & Tracking Number";
		public static final String group_User_page="Group & User";
		public static final String settings_section="Settings";
		    	
    	
    	//sub tabs
		public static final String call_details_report="Call Details";
		public static final String group_activity_report="Group Activity";
		public static final String tracking_number_settings_report="Tracking Number Settings";
		public static final String looker_schedule_report="My Scheduled Reports";		
		public static final String legacy_schedule_report="Legacy Scheduled Reports";
		public static final String cutomization="Customization";		
		public static final String blacklist="Blacklist";
		public static final String dni="DNI";
		public static final String geo_locations="GeoRoute";
		public static final String legacy_distribution_list="Legacy Distribution Lists";
		public static final String tags="Tags ";
		public static final String webhook="Webhook";
		public static final String integration="Integration";
		public static final String acquiso="Acquisio";
		public static final String data_append="Data Append";
		public static final String double_click="DoubleClick";
		public static final String google_analytics="Google Analytics";
	
	}
    
    public static class LoginPage{
    	
    }
    
    public static class Campaign{
    	
    }
   
	public static class TrackingNumber{
		
	}
	
    public static class GroupsAndUser{
		
    	public static final String group_details="GROUP DETAILS";
    	public static final String feature_settings="FEATURE SETTINGS";
    	public static final String tn_settings="TRACKING NUMBER";
    	public static final String custom_sources="CUSTOM SOURCES";
    	public static final String call_actions="Call Actions";
    	public static final String sub_groups="Sub-Groups";
    	public static final String user_settings="Users";
    	
    	
    	//User section
    	public static final String admin_role="Admin";
    	public static final String standard_role="Standard";    	
    	public static final String readonly_role="Read-Only";    	
    	
    	
	}
    
    
    public static class LegacyScheduledReport{
       	
    	public static final String edit_scheduled_report_button="Edit";
    	public static final String delete_scheduled_report_button="Delete";
    	public static final String send_now_scheduled_report_button="Send Now";
    	public static final String export_button="Export as";
    	public static final String add_scheduled_report_button="Add Scheduled Report";
    	public static final String secondary_grouping_for_call_details="Call Details";    	
    	public static final String secondary_grouping_for_tracking_number_settings="Tracking Number Settings";
    	public static final String secondary_grouping_for_group_activity="Group Activity";    	
    	
	}
    
    
    
	
}

	
	

