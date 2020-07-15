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

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
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
		
	//Group Details------------------------------------------------------------------
	@FindBy(xpath="(//label[@class='control-label'])[position()>1 and position()<9]")
	private List<WebElement> group_details_labels;
	
	String[] expected_groupDetailsLabels={"Name","External ID","Industry","Phone","City","State/Province","Zip/Postal Code"};
	
	@FindBy(xpath="//button[contains(text(),'Save Group Details')]")
	private WebElement saveGroupDetails_button;	

	@FindBy(xpath="//div[@class='ui-pnotify-text'][text()='Automation Account updated.']")
	private WebElement update_groupDetails_success_message;	
	
	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	private WebElement saveGroupDetails_alert;	
	
	@FindBy(xpath="//select[@id='source'][contains(@validate-blur-forza,'State')]")
	private WebElement state_dropdown;	

	String[] expected_states={"Alaska","Hawaii","California","Nevada","Oregon","Washington","Arizona","Colorado","Idaho","Montana","Nebraska","New Mexico","North Dakota","Utah","Wyoming","Alabama","Arkansas","Illinois","Iowa","Kansas","Kentucky","Louisiana","Minnesota","Mississippi","Oklahoma","South Dakota","Texas","Tennessee","Wisconsin","Connecticut","Delaware","Florida","Georgia","Indiana","Maine","Maryland","Massachusetts","Michigan","New Hampshire","New Jersey","New York","North Carolina","Ohio","Pennsylvania","Rhode Island","South Carolina","Vermont","Virginia","West Virginia","Alberta","British Columbia","Manitoba","New Brunswick","Newfoundland","Northwest Territories","Nova Scotia","Ontario","Prince Edward Island","Quebec","Saskatchewan","Yukon"};
	
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

	//Feature Settings Details ---------------------------------------------------------
	@FindBy(xpath="(//label[contains(text(),'Conversation Analytics')])[2]")
	private WebElement CA_label;	
	
	@FindBy(xpath="//label[contains(text(),'Conversation Analytics')]//parent::div//preceding-sibling::div//div[@class='toggle']/div")
	private WebElement CA_toggle;	

	@FindBy(xpath="//label[contains(text(),'Spam Guard')][1]")
	private WebElement spamGuard_label;	
	
	@FindBy(xpath="//label[contains(text(),'Spam Guard')]//parent::div//preceding-sibling::div//div[@class='toggle']/div")
	private WebElement spamGuard_toggle;	

	@FindBy(xpath="//label[contains(text(),'Share DNI (Website Call Tracking) code with Sub-Groups')]")
	private WebElement share_dni_label;	
	
	@FindBy(xpath="//label[contains(text(),'Share DNI (Website Call Tracking) code with Sub-Groups')]//parent::div//preceding-sibling::div//div[@class='toggle']/div")
	private WebElement shareDNI_toggle;

	@FindBy(xpath="//label[contains(text(),'Share DNI (Website Call Tracking) code with Sub-Groups')]//parent::div//preceding-sibling::div//div[@class='toggle']/div")
	private WebElement feature_settings_save_button;
	
	@FindBy(xpath="//label[contains(text(),'Share DNI (Website Call Tracking) code with Sub-Groups')]//parent::div//preceding-sibling::div//div[@class='toggle']/div")
	private WebElement feature_settings_reset_button;
	
	//Tracking Number Settings Details------------------------------------------------
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

	@FindBy(xpath="(//label[contains(text(),'Activate Voicemail?')]//parent::div//following-sibling::div//md-checkbox)[1]")
	private WebElement activate_voicemail_checkbox;
	
	//09/07/2020 --- Please update Xpath....using the default one for now
	
	@FindBy(xpath= "//*[@id=\"ouForm2\"]/div/accordion/accordion-group/div/div[2]/div[1]/div[4]/div[2]/select")
	private WebElement voicemail_dropdown;
	
	@FindBy(xpath ="//*[@id=\"ouForm2\"]/div/accordion/accordion-group/div/div[2]/div[1]/div[6]/div[2]/select")
	private WebElement overflow_dropdown;

	//---------------------------End of temporary xpaths------
	
	@FindBy(xpath="//label[contains(text(),'Configure Voicemail Greetings')]/parent::*//following-sibling::div//textarea")
	private WebElement configure_voicemail_greetings_textbox;	
	
	@FindBy(xpath="//label[contains(text(),'Repeat Interval (in hours)')]//parent::*//following-sibling::div//input")
	private WebElement repeat_interval_textbox;

	@FindBy(xpath="(//div[contains(text(),'Play a voice prompt')]//parent::div//following-sibling::div//md-checkbox)[1]")
	private WebElement play_voice_prompt_checkbox;
	
	@FindBy(xpath="(//div[contains(text(),'voice prompt')]//parent::*//following-sibling::div//textarea)[1]")
	private WebElement play_voice_prompt_textbox;

	@FindBy(xpath="(//div[contains(text(),'Play whisper message before connecting')]//parent::div//following-sibling::div//md-checkbox)[1]")
	private WebElement play_whisper_message_checkbox;
	
	@FindBy(xpath="(//div[contains(text(),'voice prompt')]//parent::*//following-sibling::div//textarea)[2]")
	private WebElement play_whisper_message_textbox;

	@FindBy(xpath="(//label[contains(text(),'Ring-to Phone Number')]//parent::*//following-sibling::div//input)")
	private WebElement ring_to_number_textbox;

	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	private WebElement tn_settings_alert;
	
	//DNI-------------------------------------------------------
	@FindBy(xpath="//span[contains(text(),'Dynamic Number')]/..//following-sibling::div//md-checkbox")
	private WebElement DNI_checkbox;
	
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
	String[] expected_dni_types={"URL","Source"};
	
	@FindBy(xpath="//a[text()='Custom Parameters']//parent::div/a")
	private WebElement custom_parameters;
	
	//DNI custom parameters-----------------------------------------------------------------
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
	
	//Instant Insights--------------------------------------------------------------------------------------------------------
	@FindBy(xpath="//label[contains(text(),'Instant Insights')]/..//following-sibling::div//md-checkbox")
	private WebElement instant_insights_checkbox;

	@FindBy(xpath="//select[@name='postIVRType']")
	private WebElement instant_insights_dropdown;
	String[] expected_instant_insights_dropdown= {"Call Outcome (Conversion type)","Agent ID","Call Outcome and Agent ID"};
	
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

	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	private WebElement tn_settings_success_message;
	
	@FindBy(xpath="//form[@id='ouForm2']//div//button[@class='reset btn'][contains(text(),'Reset')]")
	private WebElement tracking_number_settings_details_reset_Button;
	
	//Custom Sources Section-----------------------------------------------------------
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
	
	//Call Action Settings Section---------------------------------------------------
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
	
	//sub group section------------------------------------------------------
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
	

	//users section--------------------------------------------------------------
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

	//Change password popup-------------------------------------------
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

	@FindBy(xpath="//div[@class='ui-pnotify-text'][text()='User's permission updated successfully']")
	private WebElement user_permissions_update_success_message;	
	
	@FindBy(xpath="//li[@ng-repeat='group in groupsList']//label")
	private List<WebElement> user_permissions_groups_labels;	

	@FindBy(xpath="//li[@ng-repeat='group in groupsList']//input")
	private List<WebElement> user_permissions_groups_checkboxes;
	
	@FindBy(xpath="//ul[@class='tree-view-wrapper ng-scope']//label")
	private List<WebElement> user_permissions_reports_labels;
	
	@FindBy(xpath="//ul[@class='tree-view-wrapper ng-scope']//input")
	private List<WebElement> user_permissions_reports_checkboxes;	
	
    //------------------------------------------------------------------------------//
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
	
	//Groups And User Header Label verification
    public void groupsAndUserHeaderLabel(){
		
		wait.until(ExpectedConditions.visibilityOf(groupsAndUserPage_label));
		
		logger.log(LogStatus.INFO, "Verifying if Groups and User page Label is displayed");
		Assert.assertTrue(groupsAndUserPage_label.isDisplayed(),"Groups and User page Label is not displayed or locator changed");
	}
	
    //Export Groups And User Button verification
    public void exportGroupsAndUserButton(){
		
		wait.until(ExpectedConditions.visibilityOf(exportGroupsUsers_button));

		logger.log(LogStatus.INFO, "Verifying if Export Groups and User button is displayed");
		softassert.assertTrue(exportGroupsUsers_button.isDisplayed(),"Export Groups and User button is not displayed or locator changed");

		logger.log(LogStatus.INFO, "Verifying if Export Groups and User button is enabled");
		softassert.assertTrue(exportGroupsUsers_button.isEnabled(),"Export Groups and User button is not clickable");
		
		softassert.assertAll();
	}

    //Strips verification
    public void Strip(String stripName){
    	
    	WebElement strip = driver.findElement(By.xpath("//h4[starts-with(text(),'"+stripName+"')]"));
	
    	wait.until(ExpectedConditions.visibilityOf(strip));
    	
		logger.log(LogStatus.INFO, "Verifying if "+stripName+"is displayed");
    	Assert.assertTrue(strip.isDisplayed(), stripName+"is not displayed or locator changed");
    }

    //Group Details UI verification
    public void groupDetailsUI(){
    	
		expandSection(Constants.GroupsAndUser.group_details);    	
    	
		
    	for(int i=0;i<group_details_labels.size();i++){
    		
    		for(int j=0;j<expected_groupDetailsLabels.length;j++){
    			
    			if(group_details_labels.get(i).getText().equals(expected_groupDetailsLabels[j])){

    				logger.log(LogStatus.INFO, "Verifying if "+expected_groupDetailsLabels[j]+" is displayed");
    				softassert.assertTrue(group_details_labels.get(i).getText().equals(expected_groupDetailsLabels[j]),expected_groupDetailsLabels[j]+" is not displayed");    				
    			}    
    		}	
    	}
    	
		logger.log(LogStatus.INFO, "Verifying if groupName textbox is displayed");
    	softassert.assertTrue(groupName_textbox.isDisplayed(),"groupName textbox is not displayed");

		logger.log(LogStatus.INFO, "Verifying if external ID textbox is displayed");
    	softassert.assertTrue(externalID_textbox.isDisplayed(),"external ID textbox is not displayed");    	

		logger.log(LogStatus.INFO, "Verifying if Phone textbox is displayed");
    	softassert.assertTrue(phone_textbox.isDisplayed(),"Phone textbox is not displayed");    	    	

		logger.log(LogStatus.INFO, "Verifying if City textbox is displayed");
    	softassert.assertTrue(city_textbox.isDisplayed(),"city textbox is not displayed");

		logger.log(LogStatus.INFO, "Verifying if Zip textbox is displayed");
    	softassert.assertTrue(zip_textbox.isDisplayed(),"zip textbox is not displayed");
    	
		logger.log(LogStatus.INFO, "Verifying if Industry dropdown is displayed");
    	softassert.assertTrue(industry_dropdown.isDisplayed(),"Industry dropdown is not displayed");

    	Select select=new Select(industry_dropdown);
    	
    	for(int i=0;i<select.getOptions().size();i++){
    		
    		for(int j=0;j<expected_industry_dropdown.length;j++){
    			
    			if(select.getOptions().get(i).getText().equals(expected_industry_dropdown[j])){
    				logger.log(LogStatus.INFO, "Verifying if "+expected_industry_dropdown[j]+" is present");
    				softassert.assertTrue(select.getOptions().get(i).getText().equals(expected_industry_dropdown[j]),expected_industry_dropdown[j]+" is not present");
    			}	
    		}
    	}

		logger.log(LogStatus.INFO, "Verifying if State dropdown is displayed");
    	softassert.assertTrue(state_dropdown.isDisplayed(),"State dropdown is not displayed");

    	Select select1=new Select(state_dropdown);
    	
    	for(int i=0;i<select1.getOptions().size();i++){
    		
    		for(int j=0;j<expected_states.length;j++){
    			if(select1.getOptions().get(i).getText().equals(expected_states[j])){
    				logger.log(LogStatus.INFO, "Verifying if "+expected_states[j]+" is present");
    				softassert.assertTrue(select1.getOptions().get(i).getText().equals(expected_states[j]),expected_states[j]+" is not present");    				
    			}
    		}
    	}
    	
    	softassert.assertAll();
    }

    //Group Details Form Validation    
	public void groupDetailsFormValidation(String validation_textbox){
		
		expandSection(Constants.GroupsAndUser.group_details);
		
		if(validation_textbox.equals("group_name_textbox")){
			String group = groupName_textbox.getAttribute("value");
			groupName_textbox.clear();
			saveGroupDetails_button.click();
	
			logger.log(LogStatus.INFO, "Verifying if Save Group Details alert is displayed");
			Assert.assertTrue(saveGroupDetails_alert.isDisplayed(),"alert for empty group name not displayed");
			groupName_textbox.sendKeys(group);	
		}
		else if(validation_textbox.equals("phone_number_textbox")){
			phone_textbox.clear();
			phone_textbox.sendKeys("22");
			saveGroupDetails_button.click();

			logger.log(LogStatus.INFO, "Verifying if Save Group Details alert is displayed");
			Assert.assertTrue(saveGroupDetails_alert.isDisplayed(),"alert for invalid phone number not displayed");
			phone_textbox.clear();
		}
		
	}
    
    //Group Details Updattion
	public void groupDetailsUpdate(){
		
		expandSection(Constants.GroupsAndUser.group_details);
		
		String external_id = "ext_id"+Util.generateRandomNumber();
		externalID_textbox.clear();
		externalID_textbox.sendKeys(external_id);
		phone_textbox.clear();
		phone_textbox.sendKeys("8018786943");
		saveGroupDetails_button.click();
		wait.until(ExpectedConditions.visibilityOf(update_groupDetails_success_message));
		
		logger.log(LogStatus.INFO, "Verifying if Update group Details success message is displayed");
		Assert.assertTrue(update_groupDetails_success_message.isDisplayed(),"group details not updated successfully");
		
	}

    //Feature Settings UI Verification
	public void featureSettingsUI(){
		
		expandSection(Constants.GroupsAndUser.feature_settings);
		
		//CA 
		logger.log(LogStatus.INFO, "Verifying UI of Call Analytics section");
		softassert.assertTrue(CA_label.isDisplayed(),"CA label is not present");
		softassert.assertTrue(CA_toggle.isDisplayed(),"CA toggle is not present");
		softassert.assertTrue(CA_toggle.isEnabled(),"CA toggle is not clickable");
	
		//Spam guard
		logger.log(LogStatus.INFO, "Verifying UI of Spam Guard section");
		softassert.assertTrue(spamGuard_label.isDisplayed(),"Spam Guard label is not present");
		softassert.assertTrue(spamGuard_toggle.isDisplayed(),"Spam Guard toggle is not present");
		softassert.assertTrue(spamGuard_toggle.isEnabled(),"Spam Guard toggle is not clickable");
		
		//Share DNI
		logger.log(LogStatus.INFO, "Verifying UI of DNI section");
		softassert.assertTrue(share_dni_label.isDisplayed(),"Share DNI label is not present");
		softassert.assertTrue(shareDNI_toggle.isDisplayed(),"Share DNI toggle is not present");
		softassert.assertTrue(shareDNI_toggle.isEnabled(),"Share DNI toggle is not clickable");
		
		//Feature Settings section
		logger.log(LogStatus.INFO, "Verifying UI of Feature Settings section");		
		softassert.assertTrue(feature_settings_save_button.isDisplayed(),"Feature settings save button is not dipslayed");
		softassert.assertTrue(feature_settings_save_button.isEnabled(),"Feature settings save button is not enabled");
		softassert.assertTrue(feature_settings_reset_button.isDisplayed(),"Feature settings reset button is not dipslayed");
		softassert.assertTrue(feature_settings_reset_button.isEnabled(),"Feature settings reset button is not emabled");
        
		softassert.assertAll();
	}

	
	//Tracking Number Setting UI Validation
	public void TNSettingsUI(){
			
			for (int i=0; i<tn_settings_labels.size(); i++) {
				
				for(int j=0; j<expected_tn_settings_labels.length; j++) {
					
	    			if(tn_settings_labels.get(i).getText().equals(expected_tn_settings_labels[j])){
	    				logger.log(LogStatus.INFO, "Verifying if "+expected_tn_settings_labels[j]+" is present");	    				
	        			softassert.assertTrue(tn_settings_labels.get(i).getText().equals(expected_tn_settings_labels[j]),expected_tn_settings_labels[j] +" is not present"); 
				}
				
				}
			}
			
			// TNSetting Page Controls validation
			logger.log(LogStatus.INFO, "Verifying TNSetting Page Controls validation");
			softassert.assertTrue(call_value_textbox.isDisplayed(),"call value textbox is not present");
			softassert.assertTrue(repeat_interval_textbox.isDisplayed(),"Repeat Interval textbox is not present");
			softassert.assertTrue(activate_voicemail_checkbox.isDisplayed(),"Activated Voicemail checkbox is not present");
			softassert.assertTrue(voicemail_dropdown.isDisplayed(), "Voicemail dropdown is not present");
			softassert.assertTrue(overflow_dropdown.isDisplayed(), "Overflow dropdown is not present");
			softassert.assertTrue(configure_voicemail_greetings_textbox.isDisplayed(), "Configure Voicemail Greeting textbox is not present");
			softassert.assertTrue(record_call_checkbox.isDisplayed(),"Record Call checkbox is not present");
			softassert.assertTrue(play_voice_prompt_checkbox.isDisplayed(),"Play a Voice prompt checkbox is not present");
			softassert.assertTrue(play_whisper_message_checkbox.isDisplayed(),"Play whishper message before connecting checkbox is not present");
			softassert.assertTrue(ring_to_number_textbox.isDisplayed(),"Ring-to Phone Number textbox is not present");
			
			// TNSettings--DYNAMIC NUMBER section control validation
			logger.log(LogStatus.INFO, "Verifying TNSettings--DYNAMIC NUMBER section control validation");			
			softassert.assertTrue(DNI_checkbox_label.isDisplayed(),"Dynamic Number checkbox is not present");
			softassert.assertTrue(hostDomain_textbox.isDisplayed(),"Host Domain textbox is not present");
			softassert.assertTrue(reffering_website_dropdown.isDisplayed(),"Referring Website dropdown is not present");
			softassert.assertTrue(dni_type_dropdown.isDisplayed(),"DNI Type dropdown is not present");
			softassert.assertTrue(htmlclass_textbox.isDisplayed(),"HTML Class textbox is not present");
            
			//DNI Reffering Website dropdown
			Select select=new Select(reffering_website_dropdown);
			for(int j=0;j<select.getOptions().size();j++) {
				
				for(int k=0;k<expected_reffering_website_dropdown.length;k++) {
					if(select.getOptions().get(j).equals(expected_reffering_website_dropdown[j])) {
						logger.log(LogStatus.INFO, "Verifying if "+expected_reffering_website_dropdown[j]+" is present");			
						softassert.assertTrue(select.getOptions().get(j).equals(expected_reffering_website_dropdown[j]),expected_reffering_website_dropdown[j]+" is not present");
					}
				}
			}
			
			//DNI type dropdown
			Select select1=new Select(dni_type_dropdown);
			for(int j=0;j<select1.getOptions().size();j++) {
				
				for(int k=0;k<expected_dni_types.length;k++) {
					if(select1.getOptions().get(j).equals(expected_dni_types[j])) {
						logger.log(LogStatus.INFO, "Verifying if "+expected_dni_types[j]+" is not present");
						softassert.assertTrue(select1.getOptions().get(j).equals(expected_dni_types[j]),expected_dni_types[j]+" is not present");
					}
				}
			}
			
			//DNI Custom Parameters popup
			if(!DNI_checkbox.isSelected()) {
				DNI_checkbox.click();
			}
				custom_parameters.click();
				
				driver.switchTo().activeElement();
				logger.log(LogStatus.INFO, "Verifying UI of DNI Custom Parameters popup");
				softassert.assertTrue(dni_custom_parameters_label.isDisplayed(),"DNI custom parameters label");
				softassert.assertTrue(dni_custom_parameters_note.isDisplayed(),"DNI custom parameters note");
				softassert.assertTrue(dni_custom_parameters_textbox.isDisplayed(),"DNI custom parameters textbox");
				softassert.assertTrue(dni_custom_parameters_save_button.isDisplayed(),"DNI custom parameters Save button");
				softassert.assertTrue(dni_custom_parameters_cancel_button.isDisplayed(),"DNI custom parameters Cancel button");
				dni_custom_parameters_cancel_button.click();
				
			if(DNI_checkbox.isSelected()) {
			   DNI_checkbox.click();
			}
			
			//TNSettings--Instant Insights section control validation
			
			Select select2=new Select(instant_insights_dropdown);
			for(int l=0;l<select2.getOptions().size();l++) {
				
				for(int m=0;m<expected_instant_insights_dropdown.length;m++) {
					if(select2.getOptions().get(l).equals(expected_instant_insights_dropdown[m])) {
						logger.log(LogStatus.INFO, "Verifying if "+expected_instant_insights_dropdown[m]+" is present");
						softassert.assertTrue(select2.getOptions().get(l).equals(expected_instant_insights_dropdown[m]),expected_instant_insights_dropdown[m]+" is not present");
					}
				}
			}
			
			logger.log(LogStatus.INFO, "Verifying TNSettings--Instant Insights section control validation");			
			softassert.assertTrue(instant_insights_checkbox.isDisplayed(),"Instant Insights checkbox is not present");			
			softassert.assertTrue(voice_prompt_for_call_outcome_textbox.isDisplayed(),"Voice Prompt for Call Outcome textbox is not present");	
			softassert.assertTrue(voice_prompt_for_call_outcome_addfile_button.isDisplayed(),"Voice Prompt for Call Outcome Add File Button is not present");	
			softassert.assertTrue(voice_prompt_for_call_outcome_play_button.isDisplayed(),"Voice Prompt for Call Outcome play button is not present");	
			softassert.assertTrue(sale_amount_voice_prompt_textbox.isDisplayed(),"Sale Amount Voice Prompt textbox is not present");
			softassert.assertTrue(sale_amount_voice_prompt_addfile_button.isDisplayed(),"Sale Amount Voice Prompt Add File button is not present");	
			softassert.assertTrue(sale_amount_voice_prompt_play_button.isDisplayed(),"Sale Amount Voice Prompt play button is not present");
			
			//TNSetting Save & Reset Button Controls

			logger.log(LogStatus.INFO, "Verifying TNSetting Save & Reset Button Controls");
			softassert.assertTrue(tracking_number_settings_details_save_Button.isDisplayed(),"Save button is not present");	
			softassert.assertTrue(tracking_number_settings_details_reset_Button.isDisplayed(),"Reset button is not present");	

			softassert.assertAll();
   }
	
		
   //DNI and Instant Insights section form validation-------------
   public void dniAndIntantInsightsFormValidations(String section_name) {
		
		expandSection(Constants.GroupsAndUser.tn_settings);
		
		if (section_name.equals("dni_section")) {
			
			if(!DNI_checkbox.isSelected()) {
				
				logger.log(LogStatus.INFO, "Verifying HostDomain textbox is not enabled");
				softassert.assertTrue(hostDomain_textbox.getAttribute("aria-diabled").equals("true"),"hostDomain_textbox is enabled");

				logger.log(LogStatus.INFO, "Verifying Htmlclass textbox is not enabled");
				softassert.assertTrue(htmlclass_textbox.getAttribute("aria-diabled").equals("true"),"htmlclass_textbox is enabled");				
				
				logger.log(LogStatus.INFO, "Verifying Reffering Website dropdown is not enabled");				
				softassert.assertTrue(reffering_website_dropdown.getAttribute("aria-diabled").equals("true"),"reffering_website_dropdown is enabled");

				logger.log(LogStatus.INFO, "Verifying DNI type dropdown is not enabled");
				softassert.assertTrue(dni_type_dropdown.getAttribute("aria-diabled").equals("true"),"dni_type_dropdown is enabled");
				
			}
		}
		
		else if (section_name.equals("instant_insights_section")) {
			
			if(!instant_insights_checkbox.isSelected()) {
				
				instant_insights_checkbox.click();
				Select select = new Select(instant_insights_dropdown); 
				select.deselectByVisibleText("Call Outcome (Conversion type)");
				instant_insights_checkbox.click();				

				logger.log(LogStatus.INFO, "Verifying Voice prompt for call outcome textbox is not enabled");
				softassert.assertTrue(voice_prompt_for_call_outcome_textbox.getAttribute("aria-diabled").equals("true"),"Voice prompt for call outcome textbox is enabled");

				logger.log(LogStatus.INFO, "Verifying if Sale amount voice prompt textbox is not enabled");
				softassert.assertTrue(sale_amount_voice_prompt_textbox.getAttribute("aria-diabled").equals("true"),"Sale amount voice prompt textbox is enabled");				
				
			}
		}
				
		softassert.assertAll();
	}
	    
	//TN settings form validation-------------------
	public void tnSettingsFormValidation(String fieldName) throws InterruptedException {

		//Expanding TN settings section
        expandSection(Constants.GroupsAndUser.tn_settings);
        
        //Reseting all settings
        updateTNSettings();
        
        //DNI section
		if (fieldName.equals("dni_section")) {
			
			DNI_checkbox.click();
			hostDomain_textbox.clear();
			htmlclass_textbox.clear();
		}
		
		//Instant Insights section
		else if (fieldName.equals("instant_insights_section")) {
			
			instant_insights_checkbox.click();
			voice_prompt_for_call_outcome_textbox.clear();
			sale_amount_voice_prompt_textbox.clear();
		}
		
		//Repeat Interval text-box
		else if(fieldName.equals("repeat_interval_textbox")) {
			
			repeat_interval_textbox.clear();
		}
		
		//Play Voice Prompt text-box
		else if(fieldName.equals("play_voice_prompt_textbox")) {
			play_voice_prompt_checkbox.click();
			play_voice_prompt_textbox.clear();
		}
		
		//Whisper message text-box
		else if(fieldName.equals("play_whisper_message_before_connecting_textbox")) {
			play_whisper_message_checkbox.click();
			play_whisper_message_textbox.clear();
		}
		
		//Ring to number text-box
		else if(fieldName.equals("ring_to_phone_number_textbox")) {
			
			ring_to_number_textbox.clear();
			ring_to_number_textbox.sendKeys("22");
		}
		
		tracking_number_settings_details_save_Button.click();
		wait.until(ExpectedConditions.invisibilityOf(tn_settings_alert));
		
		logger.log(LogStatus.INFO, "Verifying if alert is displayed for "+fieldName);
		Assert.assertTrue(tn_settings_alert.isDisplayed(),"Appropriate alert is not displayed for "+fieldName);
		
		//Reseting all settings
		updateTNSettings();
	}

	    
	//to get check-box of required custom source
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
    
    public void expandSection(String section_name){
    	
    	WebElement strip;
    	WebElement strip_state;
    	
    	if(!(section_name.startsWith("Users") || section_name.startsWith("Sub-Groups") || section_name.startsWith("Call Actions"))){

    		strip_state = driver.findElement(By.xpath("(//h4[starts-with(text(),'"+section_name.toUpperCase()+"')]//ancestor::div[@class='panel panel-midnightblue']//div)[2]"));
    		strip = driver.findElement(By.xpath("//h4[contains(@class,'ng-binding')][starts-with(text(),'"+section_name.toUpperCase()+"')]//parent::div//i[starts-with(@class,'pull-right')]"));
    	}
    	else{
    		strip_state = driver.findElement(By.xpath("(//h4[starts-with(text(),'"+section_name+"')]//ancestor::div[@class='panel panel-midnightblue']//div)[2]"));
    		strip = driver.findElement(By.xpath("//h4[contains(@class,'ng-binding')][starts-with(text(),'"+section_name+"')]//parent::div//i[starts-with(@class,'pull-right')]"));
    	}
    	
    	if(strip_state.getAttribute("aria-hidden").equals("true")){
			strip.click();
			
	    	logger.log(LogStatus.INFO, "Verifying if "+section_name+" is expandable");			
	    	Assert.assertTrue(strip_state.getAttribute("aria-hidden").equals("false"),section_name+" is not expandable");
		}
    }
    
    public void collpaseSection(String section_name){
 
    	WebElement strip;
    	WebElement strip_state;
    	
    	if(!(section_name.startsWith("Users") || section_name.startsWith("Sub-Groups") || section_name.startsWith("Call Actions"))){

    		strip_state = driver.findElement(By.xpath("(//h4[starts-with(text(),'"+section_name.toUpperCase()+"')]//ancestor::div[@class='panel panel-midnightblue']//div)[2]"));
    		strip = driver.findElement(By.xpath("//h4[contains(@class,'ng-binding')][starts-with(text(),'"+section_name.toUpperCase()+"')]//parent::div//i[starts-with(@class,'pull-right')]"));
    	}
    	else{
    		strip_state = driver.findElement(By.xpath("(//h4[starts-with(text(),'"+section_name+"')]//ancestor::div[@class='panel panel-midnightblue']//div)[2]"));
    		strip = driver.findElement(By.xpath("//h4[contains(@class,'ng-binding')][starts-with(text(),'"+section_name+"')]//parent::div//i[starts-with(@class,'pull-right')]"));
    	}
    	
    	if(strip_state.getAttribute("aria-hidden").equals("false")){
			strip.click();
			
	    	logger.log(LogStatus.INFO, "Verifying if "+section_name+" is collapsible");			
	    	Assert.assertTrue(strip_state.getAttribute("aria-hidden").equals("true"),section_name+" is not collapsible");
		}
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

    	logger.log(LogStatus.INFO, "Verifying if Subgroup creation success message is displayed");
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
    	
    	logger.log(LogStatus.INFO, "Verifying if User creation success message is displayed");
    	Assert.assertTrue(user_creation_success_message.isDisplayed(),"User not created successfully");
    }

    
    public void updateTNSettings() throws InterruptedException{
    	
    	Util.scrollFunction(configure_voicemail_greetings_textbox);
    	Thread.sleep(5000);
    	wait.until(ExpectedConditions.visibilityOf(record_call_checkbox));
    	
    	//Activate voice mail check-box
    	if(!(activate_voicemail_checkbox.getAttribute("aria-checked").equals("true"))){
    		Util.click(activate_voicemail_checkbox);
    	}
    	
    	//Record Call check-box
    	if(!(record_call_checkbox.getAttribute("aria-checked").equals("true"))){
    		Util.click(record_call_checkbox);
    	}
    	
    	//Voice prompt check-box
    	if(voice_prompt_checkbox.getAttribute("aria-checked").equals("true")){
    		Util.click(voice_prompt_checkbox);
    	}
    	
    	//Whisper check-box
    	if(whisper_checkbox.getAttribute("aria-checked").equals("true")){
    		Util.click(whisper_checkbox);
    	}
    	
    	//Instant insights section
    	if(!instant_insights_checkbox.isSelected()) {
			instant_insights_checkbox.click();
		}
		Select select = new Select(instant_insights_dropdown); 
		select.deselectByVisibleText("Call Outcome (Conversion type)");
		instant_insights_checkbox.click();
    	
		//DNI section
		if(DNI_checkbox.isSelected()) {
		    DNI_checkbox.click();	
		}
		
		//Ring to number
		ring_to_number_textbox.clear();
		ring_to_number_textbox.sendKeys("1234567891");
		
    	tracking_number_settings_details_save_Button.click();
    	
    	logger.log(LogStatus.INFO, "Verifying if TN settings updation success message is displayed");
    	Assert.assertTrue(tn_settings_success_message.isDisplayed(),"TN settings updation success message is not displayed");
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
				logger.log(LogStatus.INFO, "Verifing if Add action button is not dispalyed after adding 10 call actions");
    			List<WebElement> add_action_button = null;
    			try{
        			add_action_button = driver.findElements(By.xpath("(//h3[text()='Then']//ancestor::div[@class='timeline-content'])["+i+"]//following-sibling::div[@class='timeline-footer text-right']//a"));
        		    Assert.fail("Add Button is dispalyed to add 11th call action");	
    			}
    			catch(Exception e) {
    				logger.log(LogStatus.PASS, "");
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
            logger.log(LogStatus.INFO, "Verifying if Delete call action success message is displayed");
            softassert.assertTrue(delete_call_action_success_message.isDisplayed(),"call action not deleted successfully");
    	}
    	
    	softassert.assertAll();
    }
    
    
    
    
    
    
    
    
}
