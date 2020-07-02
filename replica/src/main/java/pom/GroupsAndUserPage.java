package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import tests.TestBase;
import tests.Util;

public class GroupsAndUserPage extends TestBase {
	
	String groupName="Ganesh 5";
	
	SoftAssert softassert=new SoftAssert();
	
	@FindBy(xpath="//div[@class='panel-body collapse in table-responsive ng-isolate-scope']")
	private WebElement window;
	
	@FindBy(xpath="//div[@ class='groupDetailsProgressLoader']")
	private WebElement loadingWheel;
	
	@FindBy(xpath="//h1[contains(text(),'Group and User')]")
	private WebElement groupsAndUserPage_label;

	@FindBy(xpath="//div[@class='table-to-scrape']//button[1]//span[contains(text(),'Export')]")
	private WebElement exportGroupsUsers_button;
		
	//Group Details 
	@FindBy(xpath="(//label[@class='control-label'])[position()>1 and position()<9]")
	private List<WebElement> group_details_labels;
	
	String[] groupDetailsLabels={"Name","External ID","Industry","Phone","City","State/Province","Zip/Postal Code"};
	
	@FindBy(xpath="//button[contains(text(),'Save Group Details')]")
	private WebElement saveGroupDetails_button;	
	
	@FindBy(xpath="//select[@id='source'][contains(@validate-blur-forza,'State')]")
	private WebElement state_dropdown;	

	String[] states={"Alaska","Hawaii","California","Nevada","Oregon","Washington","Arizona","Colorado","Idaho","Montana","Nebraska","New Mexico","North Dakota","Utah","Wyoming","Alabama","Arkansas","Illinois","Iowa","Kansas","Kentucky","Louisiana","Minnesota","Mississippi","Oklahoma","South Dakota","Texas","Tennessee","Wisconsin","Connecticut","Delaware","Florida","Georgia","Indiana","Maine","Maryland","Massachusetts","Michigan","New Hampshire","New Jersey","New York","North Carolina","Ohio","Pennsylvania","Rhode Island","South Carolina","Vermont","Virginia","West Virginia","Alberta","British Columbia","Manitoba","New Brunswick","Newfoundland","Northwest Territories","Nova Scotia","Ontario","Prince Edward Island","Quebec","Saskatchewan","Yukon"};
	
	@FindBy(xpath="//select[@ng-model='industry']")
	private WebElement industry_dropdown;
	
	String[] expected_industry_dropdown={"Advertising:Digital","Advertising:Direct","Automotive:Dealership","Automotive:Service","Education:Institution","Education:Marketing","Financial:Insurance","Financial:Mortgage","Home Services:Home Improvement","Home Services:Electrician","Home Services:Plumber/HVAC","Home Services:Housekeeping","Home Services:Pest Control","Hospitality:Accomodations","Hospitality:Travel Agency","Medical:Cosmetic","Medical:Chiropractor","Medical:Dental","Medical:Home Healthcare","Medical:Other","Other:Other","Personal Care:Gym/Fitness","Personal Care:Spa","Real Estate:Sales","Real Estate:Property Management","Rental:Party/Event","Rental:Heavy Equipment","Rental:Furniture/Electronics","Rental:Other"};
	
	@FindBy(xpath="//label[contains(text(),'Name')]/..//input")
	private WebElement groupName_textbox;

	@FindBy(xpath="//label[contains(text(),'External')]/..//input")
	private WebElement externalID_textbox;
	
	@FindBy(xpath="//label[contains(text(),'Phone')]/..//input")
	private WebElement phone_textbox;

	@FindBy(xpath="//label[contains(text(),'City')]/..//input")
	private WebElement city_textbox;
	
	@FindBy(xpath="//label[contains(text(),'Zip')]/..//input")
	private WebElement zip_textbox;

	
	
	//Feature Settings Details 	
	@FindBy(xpath="//label[contains(text(),'Conversation Analytics')]//parent::div//preceding-sibling::div//div[@class='toggle']/div")
	private WebElement CA_toggle;	
	
	@FindBy(xpath="//label[contains(text(),'Spam Guard')]//parent::div//preceding-sibling::div//div[@class='toggle']/div")
	private WebElement spamGuard_toggle;	
	
	@FindBy(xpath="//label[contains(text(),'Share DNI (Website Call Tracking) code with Sub-Groups')]//parent::div//preceding-sibling::div//div[@class='toggle']/div")
	private WebElement shareDNI_toggle;

	@FindBy(xpath="//label[contains(text(),'Share DNI (Website Call Tracking) code with Sub-Groups')]//parent::div//preceding-sibling::div//div[@class='toggle']/div")
	private WebElement feature_settings_save_button;

	@FindBy(xpath="//label[contains(text(),'Share DNI (Website Call Tracking) code with Sub-Groups')]//parent::div//preceding-sibling::div//div[@class='toggle']/div")
	private WebElement feature_settings_reset_button;
	
	//Tracking Number Settings Details 
	@FindBy(xpath="//form[@id='ouForm2']//label")
	private List<WebElement> tn_settings_labels;
	String[] expected_tn_settings_labels={"Call Value","Repeat Interval (in hours)","Activate Voicemail?","Voicemail","Configure Voicemail Greetings","Overflow","Ring-to Phone Number","Host Domain","Referring Website","DNI Type","HTML Class","Instant Insights","Record Agent ID","Agent ID voice prompt","Number of Digits in Agent Id","Key Press - Record Call Outcome","Voice prompt for Call outcome","Record a Sale","Sale amount voice prompt","Record a Lead"}; 
	
	@FindBy(xpath="//label[contains(text(),'Call Value')]//parent::*//following-sibling::div//input")
	private WebElement call_value_textbox;

	@FindBy(xpath="//div[starts-with(@class,'col-lg-')][contains(text(),'Record Call')]")
	private WebElement record_call_checkbox_label;
	
	@FindBy(xpath="(//div[contains(text(),'Record Call')]//parent::div//following-sibling::div//md-checkbox)[1]")
	private WebElement record_call_checkbox;

	@FindBy(xpath="//div[starts-with(@class,'col-lg-')][contains(text(),'Play a voice prompt')]")
	private WebElement voice_prompt_checkbox_label;
	
	@FindBy(xpath="(//div[contains(text(),'Play a voice prompt')]//parent::div//following-sibling::div//md-checkbox)[1]")
	private WebElement voice_prompt_checkbox;

	@FindBy(xpath="//div[starts-with(@class,'col-lg-')][contains(text(),'Play whisper message before connecting')]")
	private WebElement whisper_checkbox_label;
	
	@FindBy(xpath="(//div[contains(text(),'Play a voice prompt')]//parent::div//following-sibling::div//md-checkbox)[2]")
	private WebElement whisper_checkbox;
	
	@FindBy(xpath="//label[contains(text(),'Configure Voicemail Greetings')]/parent::*//following-sibling::div//textarea")
	private WebElement configure_voicemail_greetings_textbox;	
	
	@FindBy(xpath="//label[contains(text(),'Repeat Interval (in hours)')]//parent::*//following-sibling::div//input")
	private WebElement repeat_interval_textbox;

	@FindBy(xpath="(//div[contains(text(),'voice prompt')]//parent::*//following-sibling::div//textarea)[1]")
	private WebElement play_voice_prompt_textbox;

	@FindBy(xpath="(//div[contains(text(),'voice prompt')]//parent::*//following-sibling::div//textarea)[2]")
	private WebElement play_whisper_message_textbox;

	@FindBy(xpath="(//label[contains(text(),'Ring-to Phone Number')]//parent::*//following-sibling::div//input)")
	private WebElement ring_to_number_textbox;
	
	//DNI
	@FindBy(xpath="//span[contains(text(),'Dynamic Number')]")
	private WebElement DNI_checkbox_label;
	
	@FindBy(xpath="//label//parent::*//input[@id='showDNI']")
	private WebElement hostDomain_textbox;	
	
	@FindBy(xpath="//label//parent::*//input[@name='dni_element']")
	private WebElement htmlclass_textbox;	

	@FindBy(xpath="//label[text()='Referring Website']//parent::*//select")
	private WebElement reffering_website_dropdown;
	String[] expected_reffering_website_dropdown={"Add New","Any","Bing","Google (Paid)","Google (Organic)","Yahoo (Paid)","Yahoo (Organic)"};
	
	@FindBy(xpath="//label[text()='DNI Type']//parent::*//select")
	private WebElement dni_type_dropdown;
	String[] dni_types={"URL","Source"};
	
	@FindBy(xpath="//a[text()='Custom Parameters']//parent::div/a")
	private WebElement custom_parameters;
	
	//DNI custom parameters 
	@FindBy(xpath="//a[text()='Custom Parameters']//parent::div/a")
	private WebElement dni_custom_parameters_label;

	@FindBy(xpath="//label[@class='control-label ng-binding'][starts-with(text(),'Capture Custom')]")
	private WebElement dni_custom_parameters_note;

	@FindBy(xpath="//textarea[@class='form-control ng-pristine ng-untouched ng-isolate-scope ng-invalid ng-invalid-required ng-valid-pattern']")
	private WebElement dni_custom_parameters_textbox;

	@FindBy(xpath="//div[@class='modal-footer ng-scope']//button[text()='Save']")
	private WebElement dni_custom_parameters_save_button;

	@FindBy(xpath="//div[@class='modal-footer ng-scope']//button[text()='Cancel']")
	private WebElement dni_custom_parameters_cancel_button;
	
	//Instant Insights
	@FindBy(xpath="(//label[text()='Voice prompt for Call outcome']//parent::*//following-sibling::div//textarea)[1]")
	private WebElement voice_prompt_for_call_outcome_textbox;	

	@FindBy(xpath="(//label[text()='Voice prompt for Call outcome']//parent::*//following-sibling::div[@class='col-sm-12 col-lg-1 col-md-1 col-xs-12 mt10 mb10']//a)[1]")
	private WebElement voice_prompt_for_call_outcome_addfile_button;	

	@FindBy(xpath="(//label[text()='Voice prompt for Call outcome']//parent::*//following-sibling::div[@class='col-sm-12 col-lg-1 col-md-1 col-xs-12 mt10 mb10']//a)[3]")
	private WebElement voice_prompt_for_call_outcome_play_button;
	
	@FindBy(xpath="//label[text()='Sale amount voice prompt']//parent::*//following-sibling::div//textarea")
	private WebElement sale_amount_voice_prompt_textbox;
	
	@FindBy(xpath="(//label[text()='Sale amount voice prompt']//parent::*//following-sibling::div[@class='col-sm-12 col-lg-1 col-md-1 col-xs-12 mt10 mb10']//a)[1]")
	private WebElement sale_amount_voice_prompt_addfile_button;

	@FindBy(xpath="(//label[text()='Sale amount voice prompt']//parent::*//following-sibling::div[@class='col-sm-12 col-lg-1 col-md-1 col-xs-12 mt10 mb10']//a)[3]")
	private WebElement sale_amount_voice_prompt_play_button;

	@FindBy(xpath="//label[text()='Agent ID voice prompt']//parent::div//following-sibling::div//textarea")
	private WebElement agent_ID_voice_prompt_textbox;
	
	@FindBy(xpath="(//label[text()='Agent ID voice prompt']//parent::*//following-sibling::div[@class='col-sm-12 col-lg-1 col-md-1 col-xs-12 mt10 mb10']//a)[1]")
	private WebElement agent_ID_voice_prompt_addfile_button;	

	@FindBy(xpath="(//label[text()='Agent ID voice prompt']//parent::*//following-sibling::div[@class='col-sm-12 col-lg-1 col-md-1 col-xs-12 mt10 mb10']//a)[3]")
	private WebElement agent_ID_voice_prompt_play_button;

	@FindBy(xpath="//label[text()='Number of Digits in Agent Id']//parent::div//following-sibling::div//select")
	private WebElement number_of_digits_in_agent_Id_dropdown;
	
	String[] number_of_digits_in_agent_Id_list={"1","2","3","4","5","6","7","8","9"};

	@FindBy(xpath="//form[@id='ouForm2']//div//button[@class='btn btn-primary'][contains(text(),'Save')]")
	private WebElement tracking_number_settings_details_save_Button;	

	@FindBy(xpath="//form[@id='ouForm2']//div//button[@class='reset btn'][contains(text(),'Reset')]")
	private WebElement tracking_number_settings_details_reset_Button;
	
	//Custom Sources Section
	@FindBy(xpath="(//label[@class='control-label'])[position()>19 and position()<25]")
	private List<WebElement> custom_sources_labels;
	String[] customsources_labels={"Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5"};
	
	@FindBy(xpath="//p[text()='With your own custom sources, you can easily categorize your calls. When created, it becomes available to be applied for that group and any sub-groups below.']")
	private WebElement custom_sources_note;	
	
	@FindBy(xpath="//button[contains(text(),'Clear')]")
	private WebElement custom_source_clear_button;	

	@FindBy(xpath="//a[starts-with(text(),'Add custom sources')]")
	private WebElement add_custom_source_button;	

	@FindBy(xpath="//div[text()='Successfully Created Custom Source']")
	private WebElement add_custom_source_success_message;	
	
	@FindBy(xpath="//button[contains(text(),'Selected')]")
	private WebElement custom_source_delete_button;	
	
	@FindBy(xpath="//div[@class='bootbox-body'][text()='Custom Source is associated with a tracking number. Are you sure you want to delete this Custom Source?']")
	private WebElement custom_source_deletion_confiramtion_message;	

	@FindBy(xpath="//div[@class='modal-footer']//button[text()='Cancel']")
	private WebElement custom_source_deletion_cancel_button;	

	@FindBy(xpath="//div[@class='modal-footer']//button[text()='OK']")
	private WebElement custom_source_deletion_ok_button;	

	@FindBy(xpath="//div[text()='Successfully deleted the custom source']")
	private WebElement custom_source_deletion_success_message;	
	
	//Call Action Settings Section
	//all xpaths are written for first call action
	@FindBy(xpath="//button[@class='btn btn-primary'][text()='OK']")
	private WebElement add_action_button;	
	
	@FindBy(xpath="")
	private WebElement delete_call_action_ok_button;	
	
	@FindBy(xpath="//div[text()='Successfully Deleted Call Action']")
	private WebElement delete_call_action_success_message;
	
	@FindBy(xpath="//h3[text()='If']")
	private WebElement if_condtion_label;		
	
	@FindBy(xpath="(//h3[text()='If']//ancestor::div[@class='row']//select)[2]")
	private WebElement if_condtion_dropdown;		

	String[] expected_if_condtion_list={"repeat call","duration","disposition","caller id","missed opportunity","sales inquiry","conversion","lead quality","referring source","referring type","UTM Campaign","UTM Source","UTM Medium","Send to Voicemail"};
	
	@FindBy(xpath="(//h3[text()='If']//ancestor::div[@class='row']//select)[3]")
	private WebElement operator_dropdown;

	String[] expected_operator_list_for_repeat_call={"is","is not"};
	String[] expected_operator_list_for_duration={"=","!=",">",">=","<","<="};
	String[] expected_operator_list_for_disposition={"is","is not"};
	String[] expected_operator_list_for_caller_id={"is","is not","contains","does not contain","begins with","ends with"};
	String[] expected_operator_list_for_missed_opp={"is","is not"};	
	String[] expected_operator_list_for_sales_enquiry={"is","is not"};
	String[] expected_operator_list_for_conversion={"is","is not"};
	String[] expected_operator_list_for_lead_quality={"is","is not"};
	String[] expected_operator_list_for_reff_source={"is","is not","contains","does not contain"};
	String[] expected_operator_list_for_reff_type={"is","is not"};
	String[] expected_operator_list_for_utm_campaign={"is","is not","contains","does not contain","begins with","ends with"};
	String[] expected_operator_list_for_utm_source={"is","is not","contains","does not contain","begins with","ends with"};	
	String[] expected_operator_list_for_utm_medium={"is","is not","contains","does not contain","begins with","ends with"};
	String[] expected_operator_list_for_vm={"is","is not"};
	
	@FindBy(xpath="(//h3[text()='If']//ancestor::div[@class='row']//select)[5]")
	private WebElement and_or_dropdown;

	String[] and_or_list={"AND","OR"};
	
	@FindBy(xpath="(//h3[text()='Then']//ancestor::div[starts-with(@class,'row')]//select)[1]")
	private WebElement then_condition_dropdown;
    String[] then_condition_list={"Send email alert to","Send SMS to","Tag call as","Trigger the webhook","Flag for call back","Send call for Google Analytics"};
	
	@FindBy(xpath="//div[@ class='col-sm-8 col-xs-8 callactionresponsive']//span//preceding-sibling::input")
	private WebElement then_condition_textbox_for_email;
	
	@FindBy(xpath="//div[@ class='col-sm-8 col-xs-8 callactionresponsive']//input[@id='smsNumber']")
	private WebElement then_condition_textbox_for_sms;

	@FindBy(xpath="//div[@ class='col-sm-8 col-xs-8 callactionresponsive']//ul[@class='select2-choices']")
	private WebElement then_condition_for_tag_textbox_call;

	@FindBy(xpath="//div[@ class='col-sm-8 col-xs-8 callactionresponsive']//select[@id='triggerWebhook']")
	private WebElement then_condition_listbox_for_webhook;

	@FindBy(xpath="//div[@ class='col-sm-8 col-xs-8 callactionresponsive']//select[@id='triggerWebhook']//following-sibling::a//i")
	private WebElement jump_to_webhook_settings_link;
	
	//sub group section
	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[1]")
	private WebElement subgroup_name_textbox;

	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[2]")
	private WebElement subgroup_external_id_textbox;
	
	@FindBy(xpath="(//div[@class='editable-controls form-group']//select)[1]")
	private WebElement subgroup_industry_listbox;

	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[3]")
	private WebElement subgroup_phone_textbox;

	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[4]")
	private WebElement subgroup_city_textbox;

	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[4]")
	private WebElement subgroup_zip_code_textbox;
	
	@FindBy(xpath="(//div[@class='panel-body collapse in table-responsive ng-isolate-scope'])[1]//tr//td[@class='text-right']//form[@class='form-buttons form-inline ng-pristine ng-valid']//button[contains(text(),'Save')]")
	private WebElement save_subgroup;
	
	@FindBy(xpath="(//button[text()=' Add Sub-Group'])[1]")
	private WebElement add_subgroup_button;	

	@FindBy(xpath="(//span[text()='Export Groups'])[1]//parent::button")
	private WebElement export_groups_button;	

	@FindBy(xpath="//table[@ id='table_sub_group']//th")
	private List<WebElement> sub_group_columns;
	
	String[] sub_group_columns_names={"OUID","Group Name","External ID","Industry","Phone","City","State/Province","Zip/Postal Code","Actions"};
	
	@FindBy(xpath="(//button[4])[1]")
	private static WebElement groups_topNextPagination_Button;	

	@FindBy(xpath="(//button[contains(text(),'Prev 100')])[1]")
	private static WebElement groups_topPrevPagination_Button;	
	
	@FindBy(xpath="(//button[contains(text(),'First')])[1]")
	private static WebElement groups_topFirstPagination_Button;		

	@FindBy(xpath="(//button[contains(text(),'Last')])[1]")
	private static WebElement groups_topLastPagination_Button;
	
	@FindBy(xpath="(//button[contains(text(),'Showing')])[1]")
	private static WebElement groups_topPagination_count;

	@FindBy(xpath="//table[@id='table_sub_group']//tbody//tr")
	private static WebElement groups_countOf_groups;

	@FindBy(xpath="Sub-group t is created successfully.")
	private WebElement subgroup_creation_success_message;	

	@FindBy(xpath="//div[contains(text(),'updated successfully.')]")
	private WebElement subgroup_updation_success_message;	

	@FindBy(xpath="//form[@class='bootbox-form']//input")
	private WebElement textbox_subgroup_deletion_popup;	

	@FindBy(xpath="//div[@class='modal-footer']//button[text()='OK']")
	private WebElement ok_button_subgroup_deletion_popup;

	@FindBy(xpath="//div[@class='modal-footer']//button[text()='Cancel']")
	private WebElement cancel_button_subgroup_deletion_popup;

	@FindBy(xpath="//div[text()='Group deleted.']")
	private WebElement subgroup_deletion_success_message;	
	
	//verification of buttons in top pagination toolbox
//		logger.log(LogStatus.INFO, "verifying presence of buttons in top pagination toolbox");
//		wait.until(ExpectedConditions.visibilityOf(groups_topNextPagination_Button));
//		Assert1.assertTrue(groups_topNextPagination_Button.isDisplayed(),"groups_topNextPagination_Button is not present or locator changed");
//		Assert1.assertTrue(groups_topPrevPagination_Button.isDisplayed(),"groups_topPrevPagination_Button is not present or locator changed");	
//		Assert1.assertTrue(groups_topFirstPagination_Button.isDisplayed(),"groups_topFirstPagination_count is not present or locator changed");	
//		Assert1.assertTrue(groups_topLastPagination_Button.isDisplayed(),"groups_topLastPagination_count is not present or locator changed");	
		
		//verification of count in top pagination toolbox	
//		dbCount = Util.readingFromDB("SELECT count(*) as count FROM org_unit WHERE org_unit_parent_id=70135" );
//		countOnUI_pagination=groups_topPagination_count.getText().substring(groups_topPagination_count.getText().indexOf('f')+2);
//		logger.log(LogStatus.INFO, "verifying count in top pagination toolbox");
//		Assert1.assertEquals(dbCount, groups_countOnUI_pagination,"count in top pagination toolbox is mismatching with db count");
//		
//		logger.log(LogStatus.INFO, "verifying count of listed groups");
//		Assert1.assertEquals(dbCount, String.valueOf(groups_countOf_groups.size()),"count  of listed groups is mismatching with db count");
	

	//users section
	@FindBy(xpath="(//button[text()=' Add User'])[1]")
	private WebElement add_user_button;	

	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[1]")
	private WebElement first_name_textbox;	
	
	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[2]")
	private WebElement last_name_textbox;	
	
	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[3]")
	private WebElement email_id_textbox;	

	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[4]")
	private WebElement agent_ring_to_textbox;	

	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[5]")
	private WebElement agent_id_textbox;	
	
	@FindBy(xpath="(//div[@class='editable-controls form-group']//select)[1]")
	private WebElement roles_listbox;	
	
	@FindBy(xpath="//form[@class='form-buttons form-inline ng-pristine ng-valid']//button[@class='btn btn-sm btn-primary'][contains(text(),'Save')]")
	private WebElement save_user_button;
	
	@FindBy(xpath="//div[@class='ui-pnotify-text'][contains(text(),'successfully created.')]")
	private WebElement user_creation_success_message;
	
	@FindBy(xpath="//div[@class='ui-pnotify-text'][contains(text(),'successfully updated.')]")
	private WebElement user_updation_success_message;

	@FindBy(xpath="//div[@class='ui-pnotify-text'][contains(text(),'has been removed.')]")
	private WebElement user_deletion_success_message;

	@FindBy(xpath="//form[@class='bootbox-form']//input")
	private WebElement user_deletion_confiramtion_popup_textbox;

	@FindBy(xpath="//h4[@class='modal-title'][starts-with(text(),'Deleting this User will also delete all scheduled Reports by this user.')]")
	private WebElement user_deletion_confiramtion_popup_note;

	@FindBy(xpath="//div[@class='modal-footer']//button[text()='OK']")
	private WebElement user_deletion_confiramtion_popup_ok_button;

	@FindBy(xpath="//div[@class='modal-footer']//button[text()='Cancel']") 	
	private WebElement user_deletion_confiramtion_popup_cancel_button;

	//Change password popup
	@FindBy(xpath="//h3[@class='modal-title'][text()='Change Password']")
	private WebElement change_password_label;	

	@FindBy(xpath="//form[@id='updateUserPassword']//input")
	private WebElement change_password_textbox;	

	@FindBy(xpath="//form[@id='updateUserPassword']//button[text()='OK']")
	private WebElement change_password_ok_button;	

	@FindBy(xpath="//form[@id='updateUserPassword']//a[text()='Cancel']")
	private WebElement change_password_cancel_button;

	@FindBy(xpath="//div[@class='ui-pnotify-text'][text()='Password updated successfully.']")
	private WebElement change_password_success_message;	
	
	//User Permissions window
	@FindBy(xpath="//div[@class='modal-header']//h4[text()='User Permissions']")
	private WebElement user_permissions_window_label;		

	@FindBy(xpath="//div[@class='modal-body']//p[text()='Access Audio ']")
	private WebElement user_permissions_access_audio_label;		

	@FindBy(xpath="(//div[@class='modal-body']//div[starts-with(@class,'switch-animate switch')])[1]")
	private WebElement user_permissions_access_audio_toggle;

	@FindBy(xpath="//div[@class='modal-body']//p[text()='Score Calls']")
	private WebElement user_permissions_score_calls_label;		

	@FindBy(xpath="(//div[@class='modal-body']//div[starts-with(@class,'switch-animate switch')])[2]")
	private WebElement user_permissions_score_calls_toggle;

	@FindBy(xpath="//div[@class='modal-body']//span[text()='Group Access']")
	private WebElement user_permissions_group_access_label;
	
	@FindBy(xpath="//div[@class='modal-body']//span[text()='Reporting Access']")
	private WebElement user_permissions_reporting_access_label;	

	@FindBy(xpath="//li[@ng-repeat='group in groupsList']//label")
	private WebElement user_permissions_groups_list;	

	@FindBy(xpath="//ul[@class='tree-view-wrapper ng-scope']//label")
	private WebElement user_permissions_reports_list;
	
	//----------------------------------------------------------------//
	@FindBy(xpath="(//span[text()='Export Users'])[1]//parent::button")
	private WebElement export_users_button;	

	@FindBy(xpath="//table[@ id='table_group_user']//th")
	private List<WebElement> users_columns_names;

    String[] expected_users_columns_names={"First Name","Last Name","Email","Agent Ring-to","Agent ID","Role","Status","Actions"};

	@FindBy(xpath="(//button[4])[3]")
	private static WebElement users_topNextPagination_Button;

	@FindBy(xpath="(//button[contains(text(),'Prev 100')])[3]")
	private static WebElement users_topPrevPagination_Button;

	@FindBy(xpath="(//button[contains(text(),'First')])[3]")
	private static WebElement users_topFirstPagination_Button;

	@FindBy(xpath="(//button[contains(text(),'Last')])[3]")
	private static WebElement users_topLastPagination_Button;

	@FindBy(xpath="(//button[contains(text(),'Showing')])[3]")
	private static WebElement users_topPagination_count;

	@FindBy(xpath="//table[@id='table_group_user']//tbody//tr")
	private static WebElement users_countOf_groups;
		

//verification of buttons in top pagination toolbox
//		logger.log(LogStatus.INFO, "verifying presence of buttons in top pagination toolbox");
//		wait.until(ExpectedConditions.visibilityOf(users_topNextPagination_Button));
//		Assert1.assertTrue(users_topNextPagination_Button.isDisplayed(),"users_topNextPagination_Button is not present or locator changed");
//		Assert1.assertTrue(users_topPrevPagination_Button.isDisplayed(),"users_topPrevPagination_Button is not present or locator changed");	
//		Assert1.assertTrue(users_topFirstPagination_Button.isDisplayed(),"users_topFirstPagination_count is not present or locator changed");	
//		Assert1.assertTrue(users_topLastPagination_Button.isDisplayed(),"users_topLastPagination_count is not present or locator changed");	
		
		//verification of count in top pagination toolbox	
//		dbCount = Util.readingFromDB("SELECT count(*) FROM ct_user WHERE ct_user_ou_id=70135 AND role_id !=4" );
//		countOnUI_pagination=users_topPagination_count.getText().substring(users_topPagination_count.getText().indexOf('f')+2);
//		logger.log(LogStatus.INFO, "verifying count in top pagination toolbox");
//		Assert1.assertEquals(dbCount, users_countOnUI_pagination,"count in top pagination toolbox is mismatching with db count");
//		
//		logger.log(LogStatus.INFO, "verifying count of listed groups");
//		Assert1.assertEquals(dbCount, String.valueOf(users_countOf_groups.size()),"count  of listed users is mismatching with db count");


	
	WebDriver driver;	
	
	public GroupsAndUserPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	
	//to get checkbox of required custom source
	public WebElement getCheckboxOfCustomSource(String csa,String custom_source_type){
		
		WebElement webelement = driver.findElement(By.xpath("//label[text()='Custom Source "+custom_source_type+"']//parent::div//ul//li//span[text()="+csa+"]/..//preceding-sibling::input"));
		return webelement;
	}
	
    public void addCustomSource(String custom_source_type,String cs_name){
		
		WebElement cs_textbox = driver.findElement(By.xpath("(//input[@placeholder='Add a New Source'])["+custom_source_type+"]"));
		WebElement cs_list = driver.findElement(By.xpath("//label[text()='Custom Source "+custom_source_type+"']//parent::div//ul//li"));		
		cs_textbox.sendKeys(cs_name);
		
	}
	
	
	//to get action button of desired group
    public WebElement getgroup(String group_name,String button_name){
		
		WebElement webelement = driver.findElement(By.xpath("//span[contains(text(),'"+group_name+"')]//ancestor::tr//div//button[text()='"+button_name+"']"));
		return webelement;
	}
	
  //to get action button of desired user
    public WebElement getUser(String user_email,String button_name){
		
		WebElement webelement = driver.findElement(By.xpath("//span[contains(text(),'"+user_email+"')]//ancestor::tr//div//button[text()='"+button_name+"']"));
		return webelement;
	}
    
    public void expandSection(String section){
 
		WebElement we = driver.findElement(By.xpath("//h4[contains(@class,'ng-binding')][starts-with(text(),'"+section+"')]//parent::div//i[starts-with(@class,'pull-right')]")); 
		we.click();
	}
    
    public void collpaseSection(String section){
 
		WebElement we = driver.findElement(By.xpath("//h4[contains(@class,'ng-binding')][starts-with(text(),'"+section+"')]//parent::div//i[starts-with(@class,'pull-right')]")); 
		we.click();
	}
 
    
    
    public void createGroup(String groupName) throws InterruptedException{
    	Util.scrollFunction(add_subgroup_button);
    	Util.getJavascriptExecutor().executeScript("window.scrollBy(0,-200)", "");
    	wait.until(ExpectedConditions.visibilityOf(add_subgroup_button));
    	add_subgroup_button.click();
    	subgroup_name_textbox.sendKeys(groupName);
    	
    	Select select=new Select(subgroup_industry_listbox);
    	Thread.sleep(2000);
    	select.selectByIndex(3);           
        save_subgroup.click();
    	String expected_save_sub_group_success_message="Sub-group "+groupName+" is created successfully.";
    	
    	Assert.assertTrue(subgroup_creation_success_message.getText().equals(expected_save_sub_group_success_message),"Sub group not created successfully.");
      	
    }
    
    public void createUser(String firstname,String lastname,String email_id,String role) throws InterruptedException{
    	
    	Util.scrollFunction(add_user_button);
    	Util.getJavascriptExecutor().executeScript("window.scrollBy(0,-100)", "");
    	wait.until(ExpectedConditions.visibilityOf(add_user_button));
    	add_user_button.click();
    	
    	first_name_textbox.sendKeys(firstname);
    	last_name_textbox.sendKeys(lastname);
    	email_id_textbox.sendKeys(email_id);
    	
    	Select select=new Select(roles_listbox);
    	select.selectByVisibleText(role);
    	
    	save_user_button.click();
    	
    	Assert.assertTrue(user_creation_success_message.isDisplayed(),"User not created successfully");
    }
    
    public void updateTNSettings() throws InterruptedException{
    	Util.scrollFunction(configure_voicemail_greetings_textbox);
    	Thread.sleep(5000);
    	wait.until(ExpectedConditions.visibilityOf(record_call_checkbox));
    	if(!(record_call_checkbox.getAttribute("aria-checked").equals("true"))){
    		Util.click(record_call_checkbox);
    	}
    	
    	if(voice_prompt_checkbox.getAttribute("aria-checked").equals("true")){
    		Util.click(voice_prompt_checkbox);
    	}
    	
    	if(whisper_checkbox.getAttribute("aria-checked").equals("true")){
    		Util.click(whisper_checkbox);
    	}
    	
    	tracking_number_settings_details_save_Button.click();
    }
    
    public void add10CallAction(){
    	
    	for(int i=1;i<=10;i++){
    		
    		//Rule
    		WebElement rule = driver.findElement(By.xpath("((//h3[text()='If']//ancestor::div[@class='timeline-content'])["+i+"]//select)[2]"));
    		Select rules=new Select(rule);
    		rules.selectByIndex(i);
    		
    		//operator
    		WebElement operator = driver.findElement(By.xpath("((//h3[text()='If']//ancestor::div[@class='timeline-content'])["+i+"]//select)[3]"));
    		Select select=new Select(operator);
    		select.selectByIndex(1);
    		
    		//rule value
    		WebElement rule_value = driver.findElement(By.xpath("((//h3[text()='If']//ancestor::div[@class='timeline-content'])["+i+"]//select)[4]"));
    		Select select1=new Select(rule_value);
    		select1.selectByIndex(1);
    		
    		//action
    		WebElement action = driver.findElement(By.xpath("((//h3[text()='Then']//ancestor::div[@class='timeline-content'])["+i+"]//select)[9]"));
    		Select select2=new Select(action);
    		select2.selectByVisibleText("Trigger the webhook");
    		
    		//action_value
    		WebElement action_value = driver.findElement(By.xpath("((//h3[text()='Then']//ancestor::div[@class='timeline-content'])["+i+"]//select)[12]"));
    		Select select3=new Select(action_value);
    		select3.selectByIndex(1);
    		
    		//add action button
    		if(i<10){
    			WebElement add_action_button = driver.findElement(By.xpath("(//h3[text()='Then']//ancestor::div[@class='timeline-content'])["+i+"]//following-sibling::div[@class='timeline-footer text-right']//a"));
        		add_action_button.click();
    		}
    		else if(i==10){
    			List<WebElement> add_action_button = null;
    			try{
        			add_action_button = driver.findElements(By.xpath("(//h3[text()='Then']//ancestor::div[@class='timeline-content'])["+i+"]//following-sibling::div[@class='timeline-footer text-right']//a"));
        			
    			}
    			catch(Exception e){
    				Assert.assertTrue(add_action_button.isEmpty(),"Add Button is dispalyed to add 11th call action");
    			}

    		}
    	}
    	
    }
    
    public void deleteAllCations(){
    	
    	List<WebElement> delete_icons = driver.findElements(By.xpath("//div[@class='timeline-body']/a/i"));

    	for(int i=0;i<delete_icons.size();i++){
    		delete_icons.get(i).click();
    		driver.switchTo().activeElement();
    		delete_call_action_ok_button.click();
            wait.until(ExpectedConditions.visibilityOf(delete_call_action_success_message));
            softassert.assertTrue(delete_call_action_success_message.isDisplayed(),"call action not deleted successfully");
    	}
    	
    	softassert.assertAll();
    }
    
    
    
    
    
    
    
    
}
