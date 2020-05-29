package constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tests.TestBase;

public class Constants {

	public static final String call_logs_category="Call Logs Report Suite";
	public static final String call_back_category="Call Back Report Suite";
	public static final String account_details_category="Account Details Report Suite";
	public static final String analytics_summary_category="Analytics Summary Report Suite";
	public static final String billing_usage_category="Billing Usage Report Suite";
	public static final String blocked_calls_category="Blocked Calls Report Suite";
	public static final String caller_activity_category="Caller Activity Report Suite";
	public static final String calls_by_region_category="Calls by Region Report Suite";
	public static final String call_trends_category="Call Trends Report Suite";
	public static final String email_digest_category="Email Digest Report Suite";
	public static final String ivr_keypress_category="IVR Keypress Report Suite";
	public static final String marketing_dashboard_category="Marketing Dashboard Report Suite";
	public static final String tags_summary_category="Tags Summary Report Suite";
	public static final String tracking_number_settings_category="Tracking Number Settings Report Suite";
	public static final String user_logs_category="User Logs Report Suite";
	
	public static final String webhook_logs_report_category="Webhook Logs Report Suite";
	public static final String tracking_number_category="Tracking Number Suite";	
	public static final String campaign_category="Campaign Suite";	
	public static final String login_page_category="Login Page Suite";
	public static final String home_page_category="Home Page Suite";
	public static final String group_activity_report_category="Group Activity Reports Suite";	
	public static final String call_details_report_category="Call Details Reports Suite";		
	public static final String tracking_number_settings_report_category="Tracking Number Settings Reports Suite";	
	public static final String legacy_scheduled_report_category="Legacy Scheduled Report Suite";	
	public static final String webhook_category="Webhook Suite";
	
    public static class LookerReports{
    	
    	public static final String call_back_report="Call Back";
    	public static final String account_details_report="Account Details";
    	public static final String analytics_summary_report="Analytics Summary";
    	public static final String billing_usage_report="Billing Usage";
    	public static final String blocked_calls_report="Blocked Calls";
    	public static final String caller_activity_report="Caller Activity";
    	public static final String calls_by_region_report="Calls by Region";
    	public static final String call_trends_report="Call Trends";
    	public static final String email_digest_report="Email Digest";
    	public static final String ivr_keypress_report="IVR Keypress";
    	public static final String marketing_dashboard_report="Marketing Dashboard";
    	public static final String tags_summary_report="Tags Summary";
    	public static final String tracking_number_settings_report="Tracking Number Settings";
    	public static final String user_logs_report="User Logs";    	
    	public static final String webhook_logs_report="Webhook Logs";
    	
    }

	
	
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
		public static final String last_7_days="Last 7 days";
		public static final String last_30_days="Last 30 days";
		
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
    
        
    public static class CallLogsReport{

    	public static final String total_calls_tile="Total Calls";
    	public static final String unique_calls_tile="Unique Calls";
    	public static final String answered_calls_tile="Answered Calls";
    	public static final String average_calls_duration_tile="Average Call Duration";
    	public static final String leads_tile="Total Leads";
    	public static final String conversion_tile="Total Conversion";
    	
    	//data to be inserted in call table
    	public static final String group=TestBase.getOrg_unit_id();
    	public static final String campaign=TestBase.campaignToBeEdited;   	
    	public static final String tracking_number="1111111111";
    	public static final String tracking_number_type="simple";
    	public static final String hunt_type="rollover";
    	public static final String ring_to_phone_number="8018786943 | Voicemail";
    	public static final String source="3852502145";
    	public static final String disposition="ANSWERED";
    	public static final String duration="30";
    	public static final String repeat_call="true";
    	public static final String location_route_id="-1";

    	
    }
    
    public static class MarketingDashboardReport{

    	public static final String total_calls_tile="Total Calls";
    	public static final String leads_tile="Leads";
    	public static final String conversion_tile="Conversions";
    	
    }

    
    public static class LookerTrackingNumberSettingsReport{
    	
    	public static final String active_campaigns_tile="Active Campaigns";
    	public static final String inactive_campaigns_tile="Inactive Campaigns";
    	public static final String active_tracking_numbers_tile="Active Tracking Numbers";
    	public static final String inactive_tracking_numbers_tile="Inactive Tracking Numbers";

    	//filter section
    	public static final String campaign_filter="Campaign";
    	public static final String group_filter="Group";    	
    	public static final String ring_to_number_filter="Ring-to Number";    	
    	public static final String send_to_voicemail_filter="Send to Voicemail";    	
    	public static final String tracking_number_name_filter="Tracking Number Name";    	
    	public static final String tracking_number_filter="Tracking Number";    	
    	public static final String tracking_number_status_filter="Tracking Number Status";    	
    	public static final String tracking_number_type_filter="Tracking Number Type";    	
    	
    		
    }

    public static class LookerCallBackReport{
    
    	public static final String total_calls_tile="Total Calls";
    	public static final String answered_calls_tile="Answered Calls";
    	public static final String average_calls_duration_tile="Average Call Duration";
    	public static final String missed_opportunity_tile="Missed Opportunity Calls";
       	public static final String call_back_tag_tile="Tagged as Call Back";
        
       	//filter section
       	public static final String group_filter="Group";
       	public static final String campaign_filter="Campaign";
       	public static final String tracking_number_name_filter="Tracking Number Name";
       	public static final String tracking_number_filter="Tracking Number";
        
    }
    	   
    public static class LookerBlockedCallReport{
    	
    	public static final String calls_checked_tile="Calls Checked";
    	public static final String blocked_call_tile="Blocked Call";
    	
    	//filter section
    	public static final String group_filter="Group";
       	public static final String campaign_filter="Campaign";
       	public static final String tracking_number_name_filter="Tracking Number Name";
       	public static final String tracking_number_filter="Tracking Number";
    			
    }
    
    public static class LookerWebhookLogsReport{
    	
    	public static final String total_call_tile="Total Calls";
    	public static final String pre_call_webhook_tile="Pre-call Webhooks Sent";
    	public static final String post_call_webhook_tile="Post-call Webhooks Sent";
    	
    	//filter section
    	public static final String webhhok_filter="Webhook";
    	public static final String status_filter="Webhook Status";
    	
    }
    
    public static class LookerUserLogsReport{
    	
    	//filter section
    	public static final String user_filter="User";
    	public static final String group_filter="Group";
    	public static final String activity_filter="Activity";
    	
    }
    
    public static class LookerTagsSummaryReport{
    	
    	public static final String total_call_tile="Total Calls";
    	public static final String tagged_calls_tile="Tagged Calls";
    	public static final String tags_used_tile="Tags Used";
    	
    	//filter section
    	public static final String group_filter="Group";
    	public static final String Tag_filter="Tag";
    	
    }
    
    public static class LookerCallTrendsReport{

    	//tiles
    	public static final String total_calls_tile="Total Calls";
    	public static final String unique_calls_tile="Unique Calls";
    	public static final String answered_calls_tile="Answered Calls";
    	public static final String unanswered_calls_tile="Unanswered Calls";
    	public static final String average_calls_duration_tile="Average Call Duration";
    	public static final String longest_call_duration_tile="Longest Call";
    	
    	//filter section
    	public static final String group_filter="Group";
       	public static final String campaign_filter="Campaign";
       	public static final String tracking_number_name_filter="Tracking Number Name";
       	public static final String tracking_number_filter="Tracking Number";    	
    
    }
    
    public static class LookerIVRKeypressReport{
    	
    	//IVR tiles
    	public static final String total_call_tile="Total Calls";
    	public static final String ivr_calls_tile="IVR Calls";
    	public static final String avg_time_tile="Average Time in Menu";
    	public static final String abandoned_calls_tile="Abandoned Calls";
    	public static final String unused_path_tile="Number Of Unused Paths";
    	
    	//Instant Insights tiles
    	public static final String total_call_tile_instnat_insights="Total Calls";
    	public static final String calls_with_instant_insights_tile="Calls with Instant Insights";    	
    	public static final String calls_with_agent_id_tile="Calls with Agent ID";    	
    	public static final String calls_with_call_outcome_tile="Calls with Call Outcome";        	
    	
   	
    }
    
    
    
    
    
    
}

	
	

