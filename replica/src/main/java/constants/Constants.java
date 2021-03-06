package constants;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import io.Directory;

import tests.TestBase;

public class Constants {

	public static final String groupHeirarchyAgency1="1";
	public static final String groupHeirarchyCompany="2";
	public static final String groupHeirarchyLocation="3";
	public static final String PROJECT_DIR = System.getProperty("user.dir") + File.separator;
	public static final String TEST_DATA_DIR = "TestData";
	public static final String RESOURCES = "resources";
	public static final String CONF_DIR = "conf";
	public static final String DYNAMIC_TD_FILE = "DynamicTestData";
	public static final String CALLFLOW_TEMPLETE = "CallFlowTemplete.yaml";
	public static final String POSTGRES_CONFIG = "PostgresConfig.properties";
	public static final String DRIVER = "driver";
	public static final String CHROME_DRIVER = "chromedriver";
	public static final String PHANTOM_DRIVER = "phantomjs";
	public static final String HTTPS = "https://";
	
	
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
	public static final String groups_and_user_category="Groups & User Suite";
	public static final String call_details_report_category="Call Details Reports Suite";		
	public static final String tracking_number_settings_report_category="Tracking Number Settings Reports Suite";	
	public static final String legacy_scheduled_report_category="Legacy Scheduled Report Suite";	
	public static final String webhook_category="Webhook Suite";

	public static final String manage_scorecard_category="Manage Scorecard Suite";
	public static final String select_and_score_category="Select and Score Suite";
	
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
		public static final String scoreacrd_page="Scorecard";		    	
    	
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
		public static final String manage_scoreacrd_page="Manage Scorecard";
		public static final String select_and_score_page="Select & Score";
	
	}
    
    public static class LoginPage{
    	
    }
    
    public static class Campaign{
    	
    }
   
	public static class TrackingNumber{
		
	}
	
    public static class GroupsAndUser{
		
    	public static final String group_details_strip="Group Details";
    	public static final String feature_settings_strip="Feature Settings";
    	public static final String tn_settings_strip="Tracking Number";
    	public static final String custom_sources_strip="Custom Source";
    	public static final String call_actions_strip="Call Actions";
    	public static final String sub_groups_strip="Sub-Groups";
    	public static final String user_settings_strip="Users";
    	
    	
    	//User section
    	public static final String admin_role="Admin";
    	public static final String standard_role="Standard";    	
    	public static final String readonly_role="Read-Only";    	
    	
    	//Sub-Group Section
    	public static final String sub_group_edit_button="Edit";
    	public static final String sub_group_delete_button="Delete";    	
    	public static final String sub_group_select_button="Select";    	    
    	
    	//User Section
    	public static final String user_edit_button="Edit";
    	public static final String user_delete_button="Delete";    	
    	public static final String user_permissions_button="User Permissions";
    	public static final String user_change_password_button="Change Password";
    	
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

    public static class AccountDetailsReport{

    	//tiles
    	public static final String active_campaigns_tile="Active Campaigns";
    	public static final String inactive_campaigns_tile="Inactive Campaigns";
    	public static final String active_tracking_numbers_tile="Active Tracking Numbers";
    	public static final String inactive_tracking_numbers_tile="Inactive Tracking Numbers";
    	public static final String total_calls_tile="Total Calls";
    	public static final String unique_calls_tile="Unique Calls";
    	public static final String answered_calls_tile="Answered Calls";
    	public static final String unanswered_calls_tile="Unanswered Calls";
    	public static final String average_calls_duration_tile="Average Call Duration";
    	public static final String longest_call_duration_tile="Longest Call";
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
    
    public static class LookerAnalyticsSummaryReport{
    	
    	public static final String total_call_tile="Total Calls";
    	public static final String total_analyzed_calls_tile="Total Analyzed Calls";
    
    }
    
    public static class LookerEmailDigestReport{
    	
    	public static final String group_filter="Group Name";
    
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
    
    public static class ManageScorecardPage{	
    	//Action Buttons
    	public static final String edit_scorecard_button = "Edit";
    	public static final String archive_scorecard_button = "Archive";
    	//score card creation
    	public static final String basic_scorecard = "basic";
    	public static final String __60_criteria_scorecard = "60 criteria";
    	public static final String __61_criteria_scorecard = "61 criteria";
    	public static final String all_criteria_scorecard = "all criteria";
    	public static final String scorecard_without_self_group = "uncheckSelfGroup";
    	//score card creation validations
    	public static final String scorecard_cancel_feature = "cancelFeature";
    	public static final String scorecard_check_all_groups = "checkaAllGroups";
    	public static final String scorecard_uncheck_all_groups = "uncheckAllGroups";
    	public static final String scorecard_skip_mandatory_fields = "skipMandatoryFields";
    	public static final String scorecard_delete_criteria = "deleteCriteria";
    }
        
    public static class SelectAndScorePage{	
    	//Action Buttons
		public static final String play_audio_button = "play";
		public static final String i_call_button = "i";
		public static final String edit_call_button = "edit";
		public static final String download_call_button = "download";
		public static final String mail_call_button = "mail";
		
		//info section buttons
		public static final String info_call_button = "Info";
		public static final String comment_call_button = "Comments";
		public static final String tag_call_button = "Tags";
		    	
    	//Date Range picker button
		public static final String date_range_for_today = "Today";
		public static final String date_range_for_yesterday = "Yesterday";
		public static final String date_range_for_last_7_days = "Last 7 Days";
		public static final String date_range_for_last_30_days = "Last 30 Days";
		public static final String date_range_for_this_month = "This Month";
		public static final String date_range_for_last_month = "Last Month";
		public static final String date_range_for_custom_Range = "Custom Range";
		
		//Status 
		public static final String status_checkbox_for_need_scoreacard = "Need Scorecard";
		public static final String status_checkbox_for_unscored = "Unscored";
		public static final String status_checkbox_for_scored = "Scored";
		public static final String status_checkbox_for_reviewed = "Reviewed";
		
		//advance filter
		public static final String advance_filter_for_duration = "Duration";
		public static final String advance_filter_for_group = "Group";
		public static final String advance_filter_for_score = "Score";
		public static final String advance_filter_for_call_title = "Call Title";
		public static final String advance_filter_for_call_tag = "Tag";
		public static final String advance_filter_for_Comments = "Comments";	
		public static final String advance_filter_for_identified_agent = "Identified Agent";	
		public static final String advance_filter_for_Scorecard = "Scorecard";	
		
		//score call type
		public static final String score_call_only_optional_criteria = "scoreOnlyOptionalCriteria";
		public static final String score_call_only_manadatory_criteria = "scoreOnlyMandatoryCriteria";
		public static final String score_call_all_criteria = "scoreAllCriteria";
    }
 
    public static String getPostgresConfigFile() {
		String filePath = Directory.projectDir + Constants.POSTGRES_CONFIG;
		return filePath;
	}
    
    public static class PostGresConfigConstants {
		public static final String CONNECTION_URL = "connection_url";
		public static final String DATABASE = "database";
		public static final String USERNAME = "username";
		public static final String PASSWORD = "password";
		public static final String DRIVER = "driver";
	}
    
}

	
	

