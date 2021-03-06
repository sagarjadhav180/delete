package pom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import tests.TestBase;
import tests.Util;

public class GroupsAndUserPage extends TestBase {
	
	String groupName="Ganesh 5";
	
	SoftAssert softassert=new SoftAssert();
	
	//------ Temporary Xpaths Start-------
	
	@FindBy(xpath="/html/body/header/ul/li[2]/a/span")
	private WebElement user_btn;
	
	@FindBy(xpath="/html/body/header/ul/li[2]/ul/li/ul/li[6]/a")
	private WebElement logout;
	
	//------ Temporary Xpaths End-------
	
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
	private List<WebElement> group_details_strip_labels;
	
	String[] expected_groupDetailsLabels={"Name","External ID","Industry","Phone","City","State/Province","Zip/Postal Code"};
	
	@FindBy(xpath="//button[contains(text(),'Save Group Details')]")
	private WebElement saveGroupDetails_button;	

	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	private WebElement update_groupDetails_success_message;	
	
	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	private WebElement saveGroupDetails_alert;	
	
	@FindBy(xpath="//select[@id='source'][contains(@validate-blur-forza,'State')]")
	private WebElement state_dropdown;	

	String[] expected_states={"Alaska","Hawaii","California","Nevada","Oregon","Washington","Arizona","Colorado","Idaho","Montana","Nebraska","Missouri","New Mexico","North Dakota","Utah","Wyoming","Alabama","Arkansas","Illinois","Iowa","Kansas","Kentucky","Louisiana","Minnesota","Mississippi","Oklahoma","South Dakota","Texas","Tennessee","Wisconsin","Connecticut","Delaware","Florida","Georgia","Indiana","Maine","Maryland","Massachusetts","Michigan","New Hampshire","New Jersey","New York","North Carolina","Ohio","Pennsylvania","Rhode Island","South Carolina","Vermont","Virginia","West Virginia","Alberta","British Columbia","Manitoba","New Brunswick","Newfoundland","Northwest Territories","Nova Scotia","Ontario","Prince Edward Island","Quebec","Saskatchewan","Yukon"};
	
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

	@FindBy(xpath="//label[contains(text(),'Spam Guard') and @aria-hidden='false']")
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

//	@FindBy(xpath="//div[@class='ui-pnotify-closer']")
//	private WebElement tn_settings_alert_close_button;
	
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
	@FindBy(xpath="//div[@class='modal-content']//h3[text()='DNI Custom Parameters']")
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
	@FindBy(xpath="//span[text()=' Action']")
	private WebElement action_label;
	
	@FindBy(xpath="//li[1]//a[text()='Add Action']")
	private WebElement add_action_button;	
	
	@FindBy(xpath="//div[@class='modal-footer']//button[text()='OK']")
	private WebElement delete_call_action_ok_button;	
	
	@FindBy(xpath="//div[text()='Successfully Deleted Call Action']")
	private WebElement delete_call_action_success_message;
	
	@FindBy(xpath="//h3[text()='If']")
	private WebElement if_condtion_label;		

	@FindBy(xpath="//h3[text()='Then']")
	private WebElement then_condtion_label;	

	String[] expected_if_condtion_list={"repeat call","duration","disposition","caller id","missed opportunity","sales inquiry","conversion","lead quality","referring source","referring type","UTM Campaign","UTM Source","UTM Medium","Send to Voicemail"};
	
	@FindBy(xpath="(//h3[text()='If']//ancestor::div[@class='row']//input)[1]")
	private WebElement if_condition_textbox;

	@FindBy(xpath="(//h3[text()='If']//ancestor::div[@class='row']//select)[2]")
	private WebElement if_condition_dropdown;

	@FindBy(xpath="(//h3[text()='If']//ancestor::div[@class='row']//select)[2]/option")
	private List<WebElement> if_condition_options;
	
	@FindBy(xpath="(//h3[text()='If']//ancestor::div[@class='row']//select)[3]")
	private WebElement operator_dropdown;
	
	String[] expected_operator_list_for_repeat_call={"is","is not"};
	String[] expected_operator_list_for_duration={"=","!=",">",">=","<","<="};
	String[] expected_operator_list_for_disposition={"is","is not"};
	String[] expected_operator_list_for_caller_id={"is","is not","contains","does not contain","begins with","ends with"};
	String[] expected_operator_list_for_missed_opportunity={"is","is not"};	
	String[] expected_operator_list_for_sales_inquiry={"is","is not"};
	String[] expected_operator_list_for_conversion={"is","is not"};
	String[] expected_operator_list_for_lead_quality={"is","is not"};
	String[] expected_operator_list_for_referring_source={"is","is not","contains","does not contain"};
	String[] expected_operator_list_for_referring_type={"is","is not"};
	String[] expected_operator_list_for_UTM_Campaign={"is","is not","contains","does not contain","begins with","ends with"};
	String[] expected_operator_list_for_UTM_Source={"is","is not","contains","does not contain","begins with","ends with"};	
	String[] expected_operator_list_for_UTM_Medium={"is","is not","contains","does not contain","begins with","ends with"};
	String[] expected_operator_list_for_Send_to_Voicemail={"is","is not"};
	
	@FindBy(xpath="(//h3[text()='If']//ancestor::div[@class='row']//select)[5]")
	private WebElement and_or_dropdown;

	String[] and_or_list={"AND","OR"};
	
	@FindBy(xpath="(//h3[text()='Then']//ancestor::div[starts-with(@class,'row')]//select)[1]")
	private WebElement then_condition_dropdown;
    String[] expected_then_condition_list={"Send email alert to","Send SMS to","Tag call as","Trigger the webhook","Flag for call back","Send call for Google Analytics"};
	
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

	@FindBy(xpath="//div[starts-with(@ng-show,'callActions')]//following-sibling::button[text()='Save']")
	private WebElement call_action_save_button;

	@FindBy(xpath="//div[starts-with(@ng-show,'callActions')]//following-sibling::button[text()='Reset']")
	private WebElement call_action_reset_button;

	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	private WebElement call_actions_settings_alert;
	
	@FindBy(xpath="//div[@class='ui-pnotify-text'][text()='Successfully Saved Call Action Settings']")
	private WebElement call_actions_settings_success_message;
	
	//sub group section------------------------------------------------------
	@FindBy(xpath="(//div[starts-with(@class,'editable-controls form-group')]//input)[1]")
	private WebElement subgroup_name_textbox;

	@FindBy(xpath="(//div[starts-with(@class,'editable-controls form-group')]//input)[2]")
	private WebElement subgroup_external_id_textbox;
	
	@FindBy(xpath="(//div[starts-with(@class,'editable-controls form-group')]//select)[1]")
	private WebElement subgroup_industry_listbox;

	@FindBy(xpath="(//div[starts-with(@class,'editable-controls form-group')]//input)[3]")
	private WebElement subgroup_phone_textbox;

	@FindBy(xpath="(//div[starts-with(@class,'editable-controls form-group')]//input)[4]")
	private WebElement subgroup_city_textbox;

	@FindBy(xpath="(//div[starts-with(@class,'editable-controls form-group')]//input)[5]")
	private WebElement subgroup_zip_code_textbox;
	
	@FindBy(xpath="//table[@id='table_sub_group']//form[@aria-hidden='false']//button[contains(text(),'Save')]")
	private WebElement save_subgroup_button;

	@FindBy(xpath="//table[@id='table_sub_group']//form[@aria-hidden='false']//button[contains(text(),'Cancel')]")
	private WebElement cancel_subgroup_button;
	
	@FindBy(xpath="(//button[text()=' Add Sub-Group'])[1]")
	private WebElement add_subgroup_button;	

	
	@FindBy(xpath="(//span[text()='Export Groups'])[1]//parent::button")
	private WebElement export_groups_button;	

	@FindBy(xpath="//table[@ id='table_sub_group']//th")
	private List<WebElement> sub_group_columns;
	
	String[] expected_sub_group_columns_names={"OUID","Group Name","External ID","Industry","Phone","City","State/Province","Zip/Postal Code","Actions"};
	
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
	private static List<WebElement> groups_count_in_grid;

	@FindBy(xpath="//div[contains(text(),'created successfully.')]")
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
	

	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	private WebElement saveSubGroupDetails_alert;
	
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
	private WebElement user_roles_listbox;	
	
	String[] expected_roles= {"Admin","Standard","Read-Only"};

	@FindBy(xpath="(//div[@class='editable-controls form-group']//select)[2]")
	private WebElement user_status_listbox;	
	
	@FindBy(xpath="//table[@id='table_group_user']//form[@aria-hidden='false']//button[contains(text(),'Save')]")
	private WebElement save_user_button;

	@FindBy(xpath="//table[@id='table_group_user']//form[@aria-hidden='false']//button[contains(text(),'Cancel')]")
	private WebElement cancel_user_button;

	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	private WebElement user_creation_alert;
	
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
	
	@FindBy(xpath="//div[@class='ui-pnotify-sticker']")
	private WebElement pause_button_success_message;
	
	@FindBy(xpath="//div[@class='ui-pnotify-closer']")
	private WebElement close_button_success_message;

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

	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	private WebElement change_password_alert;
	
	//User Permissions window
	@FindBy(xpath="//div[@class='modal-header']//h4[text()='User Permissions']")
	private WebElement user_permissions_window_label;		

	@FindBy(xpath="//div[@class='modal-body']//p[text()='Access Audio ']")
	private WebElement user_permissions_access_audio_label;		

	@FindBy(xpath="(//div[@class='modal-body']//div[starts-with(@class,'switch-animate switch')])[1]/span")
	private WebElement user_permissions_access_audio_toggle;

	@FindBy(xpath="//div[@class='modal-body']//p[text()='Score Calls']")
	private WebElement user_permissions_score_calls_label;		

	@FindBy(xpath="(//div[@class='modal-body']//div[starts-with(@class,'switch-animate switch')])[2]")
	private WebElement user_permissions_score_calls_toggle;

	@FindBy(xpath="//div[@class='modal-body']//span[text()='Group Access']")
	private WebElement user_permissions_group_access_label;
	
	@FindBy(xpath="//div[@class='modal-body']//span[text()='Reporting Access']")
	private WebElement user_permissions_reporting_access_label;	

	@FindBy(xpath="//div[@class='ui-pnotify-text'][contains(text(),'permission updated successfully')]")
	private WebElement user_permissions_update_success_message;	
	
	@FindBy(xpath="//li[@ng-repeat='group in groupsList']//label")
	private List<WebElement> user_permissions_groups_labels;	

	@FindBy(xpath="//li[@ng-repeat='group in groupsList']//input")
	private List<WebElement> user_permissions_groups_checkboxes;
	
	@FindBy(xpath="//ul[@class='tree-view-wrapper ng-scope']//label")
	private List<WebElement> user_permissions_reports_labels;
	
	@FindBy(xpath="//ul[@class='tree-view-wrapper ng-scope']//input")
	private List<WebElement> user_permissions_reports_checkboxes;	

	@FindBy(xpath="//div[starts-with(@class,'Permissions')]//button[text()='Cancel']")
	private WebElement user_permissions_cancel_button;	

	@FindBy(xpath="//div[starts-with(@class,'Permissions')]//button[text()='Save']")
	private WebElement user_permissions_save_button;
	
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
	private static List<WebElement> users_count_in_grid;
			
//	WebDriver driver;	
	
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
    	
    	WebElement strip ;
    	if(!(stripName.startsWith("Users") || stripName.startsWith("Sub-Groups") || stripName.startsWith("Call Actions"))){

    		strip = TestBase.driver.findElement(By.xpath("//h4[starts-with(text(),'"+stripName.toUpperCase()+"')]"));
    	}
    	
    	else {
    		strip = TestBase.driver.findElement(By.xpath("//h4[starts-with(text(),'"+stripName+"')]"));
    	}
    		
    	wait.until(ExpectedConditions.visibilityOf(strip));
    	
		logger.log(LogStatus.INFO, "Verifying if "+stripName+"is displayed");
    	Assert.assertTrue(strip.isDisplayed(), stripName+"is not displayed or locator changed");
    }

    
    //Group Details UI verification ----------------------------------------------
    public void groupDetailsUI(){
    	
		expandSection(Constants.GroupsAndUser.group_details_strip);    	
    	
//    	for(int i=0;i<group_details_strip_labels.size();i++){
//    		
//    		for(int j=0;j<expected_groupDetailsLabels.length;j++){
//    			
//    			if(group_details_strip_labels.get(i).getText().equals(expected_groupDetailsLabels[j])){
//
//    				logger.log(LogStatus.INFO, "Verifying if "+expected_groupDetailsLabels[j]+" is displayed");
//    				softassert.assertTrue(group_details_strip_labels.get(i).getText().equals(expected_groupDetailsLabels[j]),expected_groupDetailsLabels[j]+" is not displayed");    				
//    			}    
//    		}	
//    	}
    	    	
    	List<String> act_group_details_strip_labels = new ArrayList<String>();
    	List<String> exp_group_details_strip_labels = new ArrayList<String>(Arrays.asList(expected_groupDetailsLabels));

    	for(WebElement group_details_strip_label:group_details_strip_labels) {
    		act_group_details_strip_labels.add(group_details_strip_label.getText());
    	}
    	Collections.sort(act_group_details_strip_labels);
    	Collections.sort(exp_group_details_strip_labels);
    	softassert.assertEquals(act_group_details_strip_labels, exp_group_details_strip_labels,"industry dropdowns not matching with expected");
    	
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

    	//Industry
		logger.log(LogStatus.INFO, "Verifying if Industry dropdown is displayed");
    	softassert.assertTrue(industry_dropdown.isDisplayed(),"Industry dropdown is not displayed");

    	Select select=new Select(industry_dropdown);
    	List<String> act_industry_options = new ArrayList<String>();
    	List<String> exp_industry_options = new ArrayList<String>(Arrays.asList(expected_industry_dropdown));
    	List<WebElement> act_options = new ArrayList<WebElement>();
    	
    	do {
    		act_options = select.getOptions();
    	}while(select.getOptions().size()<2);
    	
    	for(WebElement act_option:act_options) {
    		if(!act_option.getText().equals("-- Select Industry--")) {
        		act_industry_options.add(act_option.getText().trim());	
    		}
    	}
    	Collections.sort(act_industry_options);
    	Collections.sort(exp_industry_options);
    	softassert.assertEquals(act_industry_options, exp_industry_options,"industry dropdowns not matching with expected");
    	
//    	for(int i=0;i<select.getOptions().size();i++){
//    		
//    		for(int j=0;j<expected_industry_dropdown.length;j++){
//    			
//    			if(select.getOptions().get(i).getText().equals(expected_industry_dropdown[j])){
//    				logger.log(LogStatus.INFO, "Verifying if "+expected_industry_dropdown[j]+" is present");
//    				softassert.assertTrue(select.getOptions().get(i).getText().equals(expected_industry_dropdown[j]),expected_industry_dropdown[j]+" is not present");
//    			}	
//    		}
//    	}

    	//States
		logger.log(LogStatus.INFO, "Verifying if State dropdown is displayed");
    	softassert.assertTrue(state_dropdown.isDisplayed(),"State dropdown is not displayed");
 
    	Select select1=new Select(state_dropdown);
    	List<String> act_state_options = new ArrayList<String>();
    	List<String> exp_state_options = new ArrayList<String>(Arrays.asList(expected_states));
    	List<WebElement> act_stat_options = new ArrayList<WebElement>();
    	do {
    		act_stat_options = select1.getOptions();
    	}while(select1.getOptions().size()<2);
    	
    	for(WebElement act_stat_option:act_stat_options) {
    		if(!act_stat_option.getText().equals("--Select--")) {
        		act_state_options.add(act_stat_option.getText().trim());	
    		}
    	}
    	act_state_options.removeAll(Arrays.asList(""));
    	Collections.sort(act_state_options);
    	Collections.sort(exp_state_options);
    	softassert.assertEquals(act_state_options, exp_state_options,"states dropdowns not matching with expected");
    	
    	
//    	for(int i=0;i<select1.getOptions().size();i++){
//    		
//    		for(int j=0;j<expected_states.length;j++){
//    			if(select1.getOptions().get(i).getText().equals(expected_states[j])){
//    				logger.log(LogStatus.INFO, "Verifying if "+expected_states[j]+" is present");
//    				softassert.assertTrue(select1.getOptions().get(i).getText().equals(expected_states[j]),expected_states[j]+" is not present");    				
//    			}
//    		}
//    	}
    	
    	softassert.assertAll();
    }

    
    //Group Details Form Validation    
	public void groupDetailsFormValidation(String validation_textbox) throws InterruptedException{
		
		expandSection(Constants.GroupsAndUser.group_details_strip);
		
		if(validation_textbox.equals("group_name_textbox")){
			String group = groupName_textbox.getAttribute("value");
			wait.until(ExpectedConditions.visibilityOf(groupName_textbox));
			groupName_textbox.clear();
			saveGroupDetails_button.click();
	
			logger.log(LogStatus.INFO, "Verifying if Save Group Details alert is displayed");
			Assert.assertTrue(saveGroupDetails_alert.isDisplayed(),"alert for empty group name not displayed");
			groupName_textbox.sendKeys(group);	
		}
		else if(validation_textbox.equals("phone_number_textbox")){
			phone_textbox.clear();
			phone_textbox.sendKeys("22");
			try {
				saveGroupDetails_button.click();			
			}
			catch(Exception e){
				logger.log(LogStatus.INFO, "Verifying if Save Group Details alert is displayed");
				wait.until(ExpectedConditions.visibilityOf(saveGroupDetails_alert));
				Assert.assertTrue(saveGroupDetails_alert.isDisplayed(),"alert for invalid phone number not displayed");
				phone_textbox.clear();
			}
		}
		
	}
    
	
    //Group Details Updation
	public void groupDetailsUpdate() throws InterruptedException{
		
		expandSection(Constants.GroupsAndUser.group_details_strip);
		
		String external_id = "ext_id"+Util.generateRandomNumber();
		externalID_textbox.clear();
		externalID_textbox.sendKeys(external_id);
		phone_textbox.clear();
		phone_textbox.sendKeys("8018786943");
		logger.log(LogStatus.INFO, "Verifying if Update group Details success message is displayed");
		try {
			saveGroupDetails_button.click();
			wait.until(ExpectedConditions.visibilityOf(update_groupDetails_success_message));
			Assert.assertTrue(update_groupDetails_success_message.isDisplayed(),"group details not updated successfully");
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}

	
    //Feature Settings UI Verification -------------------------------------------
	public void featureSettingsUI(){
		
		expandSection(Constants.GroupsAndUser.feature_settings_strip);
		
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

	
	//Tracking Number Setting UI Validation ----------------------------------------
	@SuppressWarnings("unlikely-arg-type")
	public void tnSettingsUI() throws InterruptedException{
			
		expandSection(Constants.GroupsAndUser.tn_settings_strip);
		
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
            
			//DNI Referring Website dropdown
			Select select=new Select(reffering_website_dropdown);
			for(int j=1;j<select.getOptions().size()-1;j++) {
				
				for(int k=0;k<expected_reffering_website_dropdown.length;k++) {
					if(select.getOptions().get(j).equals(expected_reffering_website_dropdown[k])) {
						logger.log(LogStatus.INFO, "Verifying if "+expected_reffering_website_dropdown[k]+" is present");			
						softassert.assertTrue(select.getOptions().get(j).equals(expected_reffering_website_dropdown[k]),expected_reffering_website_dropdown[k]+" is not present");
					}
				}
			}
			
			//DNI type dropdown
			Select select1=new Select(dni_type_dropdown);
			for(int j=1;j<=select1.getOptions().size()-1;j++) {
				
				for(int k=0;k<expected_dni_types.length;k++) {
					if(select1.getOptions().get(j).equals(expected_dni_types[k])) {
						logger.log(LogStatus.INFO, "Verifying if "+expected_dni_types[k]+" is not present");
						softassert.assertTrue(select1.getOptions().get(j).equals(expected_dni_types[k]),expected_dni_types[k]+" is not present");
					}
				}
			}
			
			//DNI Custom Parameters popup
			if(!DNI_checkbox.getAttribute("aria-checked").equals("true")) {
				Thread.sleep(2000);
				try {
				    Util.customWait(DNI_checkbox);
					Util.click(DNI_checkbox);					
				}catch(Exception e) {
				    Util.customWait(DNI_checkbox);
					DNI_checkbox.click();	
				}

//				DNI_checkbox.click();
			}
				//custom_parameters.click();
			    Util.customWait(custom_parameters);
			    try {
					Util.click(custom_parameters);	
					Util.customWait(dni_custom_parameters_label);
			    }catch(Exception e) {
			    	Thread.sleep(2000);
					Util.click(custom_parameters);	
			    }finally {
					Util.customWait(dni_custom_parameters_label);
			    }
				
				driver.switchTo().activeElement();
				logger.log(LogStatus.INFO, "Verifying UI of DNI Custom Parameters popup");
				softassert.assertTrue(dni_custom_parameters_label.isDisplayed(),"DNI custom parameters label is not present");
				softassert.assertTrue(dni_custom_parameters_note.isDisplayed(),"DNI custom parameters note is not present");
				softassert.assertTrue(dni_custom_parameters_textbox.isDisplayed(),"DNI custom parameters textbox is not present");
				softassert.assertTrue(dni_custom_parameters_save_button.isDisplayed(),"DNI custom parameters Save button is not present");
				softassert.assertTrue(dni_custom_parameters_cancel_button.isDisplayed(),"DNI custom parameters Cancel button is not present");
				dni_custom_parameters_cancel_button.click();
				
			if(DNI_checkbox.getAttribute("aria-checked").equals("true")) {
//			   DNI_checkbox.click();
			   Util.click(DNI_checkbox);
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
	
		
   //DNI and Instant Insights section form validation
   public void dniAndIntantInsightsFormValidations(String section_name) throws InterruptedException {
		
		expandSection(Constants.GroupsAndUser.tn_settings_strip);
		
		if (section_name.equals("dni_section")) {
			
			if(!DNI_checkbox.getAttribute("aria-checked").equals("true")) {
				
				logger.log(LogStatus.INFO, "Verifying HostDomain textbox is not enabled");
				softassert.assertTrue(hostDomain_textbox.getAttribute("aria-disabled").equals("true"),"hostDomain_textbox is enabled");

				logger.log(LogStatus.INFO, "Verifying Htmlclass textbox is not enabled");
				softassert.assertTrue(htmlclass_textbox.getAttribute("aria-disabled").equals("true"),"htmlclass_textbox is enabled");				
				
				logger.log(LogStatus.INFO, "Verifying Reffering Website dropdown is not enabled");				
				softassert.assertTrue(reffering_website_dropdown.getAttribute("aria-disabled").equals("true"),"reffering_website_dropdown is enabled");

				logger.log(LogStatus.INFO, "Verifying DNI type dropdown is not enabled");
				softassert.assertTrue(dni_type_dropdown.getAttribute("aria-disabled").equals("true"),"dni_type_dropdown is enabled");
				
			}
		}
		
		else if (section_name.equals("instant_insights_section")) {
			
			if(!instant_insights_checkbox.isSelected()) {
				
				/*
				 * instant_insights_checkbox.click(); Select select = new
				 * Select(instant_insights_dropdown);
				 * select.selectByVisibleText("Call Outcome (Conversion type)");
				 * Thread.sleep(2000); instant_insights_checkbox.click();
				 */			

				logger.log(LogStatus.INFO, "Verifying Voice prompt for call outcome textbox is not enabled");
				softassert.assertTrue(voice_prompt_for_call_outcome_textbox.getAttribute("aria-disabled").equals("true"),"Voice prompt for call outcome textbox is enabled");

				logger.log(LogStatus.INFO, "Verifying if Sale amount voice prompt textbox is not enabled");
				softassert.assertTrue(sale_amount_voice_prompt_textbox.getAttribute("aria-disabled").equals("true"),"Sale amount voice prompt textbox is enabled");				
				
			}
		}
				
		softassert.assertAll();
	}
	    
   
	//TN settings form validation
	public void tnSettingsFormValidation(String fieldName) throws InterruptedException {

		//Expanding TN settings section
        expandSection(Constants.GroupsAndUser.tn_settings_strip);
        
        //Reseting all settings
//        updateTNSettings();
        
        //DNI section
		if (fieldName.equals("dni_section")) {
			
			Util.click(DNI_checkbox);
			//DNI_checkbox.click();
			hostDomain_textbox.clear();
			htmlclass_textbox.clear();
		}
		
		//Instant Insights section
		else if (fieldName.equals("instant_insights_section")) {
			Util.customWait(instant_insights_checkbox);
			Util.Action().moveToElement(instant_insights_checkbox).perform();
			Util.click(instant_insights_checkbox);
//			instant_insights_checkbox.click();
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
			
			wait.until(ExpectedConditions.visibilityOf(ring_to_number_textbox));
			ring_to_number_textbox.clear();
			ring_to_number_textbox.sendKeys("22");
		}
		
		tracking_number_settings_details_save_Button.click();
		
		logger.log(LogStatus.INFO, "Verifying if alert is displayed for "+fieldName);
		wait.until(ExpectedConditions.visibilityOf(tn_settings_alert));
		Assert.assertTrue(tn_settings_alert.isDisplayed(),"Appropriate alert is not displayed for "+fieldName);
		
//		driver.switchTo().activeElement();
//		Util.click(tn_settings_alert_close_button);
		
		//Reseting all settings
//		updateTNSettings();
	}

	
    // Custom Source UI Validation ------------------------------------------------
	public void custom_Source_UI_Validation(){
		
		//Expanding Custom Source section
        expandSection(Constants.GroupsAndUser.custom_sources_strip);
		
		for (int i=0; i<custom_sources_labels.size(); i++) {
			
			for(int j=0; j<customsources_labels.length; j++) {
							
				if(custom_sources_labels.get(i).getText().equals(customsources_labels[i])) {
					softassert.assertTrue(custom_sources_labels.get(i).getText().equals(customsources_labels[i]), customsources_labels[i] + "is not present");
				}
			}
		}
		
		//Custom Source_Add New Source Textbox validation		
		for(int i=1; i<=5; i++) {
			WebElement cs_textbox = TestBase.driver.findElement(By.xpath("(//input[@placeholder='Add a New Source'])["+i+"]"));
			logger.log(LogStatus.INFO, "verifying if Add Custom source text box is enabled");
			softassert.assertTrue(cs_textbox.isEnabled(), "Add a new source textbox no. " + i +" is not enabled");
		}
		
		logger.log(LogStatus.INFO, "Verifying if Clear button is present");
		softassert.assertTrue(custom_source_clear_button.isDisplayed(), "Clear button is not present");	
		logger.log(LogStatus.INFO, "Verifying if Delete button is present");
		softassert.assertTrue(custom_source_delete_button.isDisplayed(),"Delete button is not present");
				
		softassert.assertAll();
		
	}
	
	
	//Custom Source Add New Source Validation
	
	static String[] custom_sources=new String[6];
	
	public void custom_Source_Add_New_Source() throws InterruptedException{

		
		//Expanding Custom Source section
        expandSection(Constants.GroupsAndUser.custom_sources_strip);
        Thread.sleep(4000);
        
		for(int i=1; i<=5; i++) {
			String cs_to_add="cs-delete"+Util.generateRandomNumber();
			custom_sources[i]=cs_to_add;
			addCustomSource(String.valueOf(i), cs_to_add);
			Thread.sleep(3000);
			logger.log(LogStatus.INFO, "verifying Add New Custom Source functionality & Success Message");
		//  Validating Success Message for each column
			wait.until(ExpectedConditions.visibilityOf(add_custom_source_success_message));
			softassert.assertTrue(add_custom_source_success_message.isDisplayed(), "Source added Success Message Not displayed");
			Thread.sleep(2000);
		}		
		softassert.assertAll();
	}
	
	
	public void custom_Source_delete_Source() throws InterruptedException{
		
		//Expanding Custom Source section
        expandSection(Constants.GroupsAndUser.custom_sources_strip);
        Thread.sleep(4000);
        
		for(int i=1; i<=5; i++) {
			
			clickCheckboxOfCustomSource(custom_sources[i],String.valueOf(i));
			
		}	
		
		custom_source_delete_button.click();
		
		wait.until(ExpectedConditions.visibilityOf(custom_source_deletion_confiramtion_message));
		logger.log(LogStatus.INFO, "verifying Custom Source Deletion Confirmation & Success Messages");
		softassert.assertTrue(custom_source_deletion_confiramtion_message.isDisplayed(), "Custom Source Deletion Confirmation Message not popped up");
		softassert.assertTrue(custom_source_deletion_ok_button.isDisplayed(), "Custom Source Deletion OK button Not present");
		softassert.assertTrue(custom_source_deletion_cancel_button.isDisplayed(), "Custom Source Deletion Cancel button Not present");
		
		driver.switchTo().activeElement();
		custom_source_deletion_ok_button.click();
		
		wait.until(ExpectedConditions.visibilityOf(custom_source_deletion_success_message));
		softassert.assertTrue(custom_source_deletion_success_message.isDisplayed(), "Source Not deleted successfully");
	    Thread.sleep(2000);
		
		
		softassert.assertAll();
	}
	
	// Custom Source verification if duplicate record can be added
	
	  static String[] custom_sources_duplicate=new String[6];
	  
	  public void custom_Source_Add_Duplicate_Source() throws InterruptedException{
	  
	  //Expanding Custom Source section
	  expandSection(Constants.GroupsAndUser.custom_sources_strip);
	  Thread.sleep(4000);
	  
	  for(int i=1; i<=5; i++) { 
		  String cs_to_add="cs-delete"+Util.generateRandomNumber();
		  custom_sources_duplicate[i]=cs_to_add; 
		  WebElement cs_textbox =TestBase.driver.findElement(By.xpath("(//input[@placeholder='Add a New Source'])["+i+"]"));
		  cs_textbox.sendKeys(custom_sources_duplicate[i]); 
		  WebElement add_source_click = TestBase.driver.findElement(By.xpath("//*[@id='customized']/ul/li[3]/a[starts-with(text(),'Add custom sources')]")); 
		  add_source_click.click();
	  
	  //Adding same source again Thread.sleep(4000);
	  cs_textbox.sendKeys(custom_sources_duplicate[i]); 
	  logger.log(LogStatus.PASS,"verifying if duplicate Custom Source getting added"); 
	  try {
	  add_source_click.click();
	  } 
	  catch(Exception e) {
	  System.out.println("Duplicate source isn't getting added"); 
	  }
	  
	  } softassert.assertAll(); }
	 
		 
	/*
	 * static String[] custom_sources_duplicate=new String[6];
	 * 
	 * public void custom_Source_Add_Duplicate_Source() throws InterruptedException{
	 * 
	 * //Expanding Custom Source section
	 * expandSection(Constants.GroupsAndUser.custom_sources_strip);
	 * Thread.sleep(4000);
	 * 
	 * for(int i=1; i<=5; i++) { String
	 * cs_to_add="cs-delete"+Util.generateRandomNumber();
	 * custom_sources_duplicate[i]=cs_to_add; WebElement cs_textbox
	 * =TestBase.driver.findElement(By.
	 * xpath("(//input[@placeholder='Add a New Source'])["+i+"]"));
	 * cs_textbox.sendKeys(custom_sources_duplicate[i]); List <WebElement>
	 * add_source_click = TestBase.driver.findElements(By.
	 * xpath("//*[@id='customized']/ul/li[3]/a[starts-with(text(),'Add custom sources')]"
	 * )); add_source_click.get(0).click();
	 * 
	 * //Adding same source again Thread.sleep(4000);
	 * cs_textbox.sendKeys(custom_sources_duplicate[i]); logger.log(LogStatus.
	 * INFO,"verifying if duplicate Custom Source getting added");
	 * if(add_source_click.size()==1) {
	 * logger.log(LogStatus.PASS,"Duplicate source isn't getting added"); } else
	 * if(add_source_click.size()>1) {
	 * logger.log(LogStatus.FAIL,"Duplicate source isn't getting added"); }
	 * 
	 * } softassert.assertAll(); }
	 */
	
	// Check if able to clear selected custom source checkbox
		
		  static String[] custom_sources_checkbox=new String[6];
		  
		  public void custom_Source_Clear_checkbox() throws InterruptedException{
		  
		  //Expanding Custom Source section
		  expandSection(Constants.GroupsAndUser.custom_sources_strip);
		  Thread.sleep(4000);
		  
		  for(int i=1; i<=5; i++) { 
			  String cs_to_add="cs-delete"+Util.generateRandomNumber();
			  custom_sources_duplicate[i]=cs_to_add; 
			  WebElement cs_textbox =TestBase.driver.findElement(By.xpath("(//input[@placeholder='Add a New Source'])["+i+"]"));
			  cs_textbox.sendKeys(custom_sources_duplicate[i]); 
			  WebElement add_source_click = TestBase.driver.findElement(By.xpath("//*[@id='customized']/ul/li[3]/a[starts-with(text(),'Add custom sources')]")); 
			  wait.until(ExpectedConditions.visibilityOf(add_source_click));
			  add_source_click.click();
			  clickCheckboxOfCustomSource(custom_sources_checkbox[i],String.valueOf(i));
			  }
		  custom_source_clear_button.click();
		  // Verifying the checkboxes of custom sources
		  
		  logger.log(LogStatus.INFO,"verifying if custom source checkboxes are getting cleared after clicking clear button");
		  for(int i=1; i<=5;i++) {
			  WebElement custom_source_1 = TestBase.driver.findElement(By.xpath("//label[text()='Custom Source "+String.valueOf(i)+"']//parent::div//ul//li//span[starts-with(text(),'"+custom_sources_checkbox[i]+"')]/..//preceding-sibling::input"));
			  Assert.assertFalse(custom_source_1.isSelected(), "Custome Source checkbox " + i + " isn't cleared"); 
			  
		  }
		  
		  softassert.assertAll(); 
		}
		
	
	public void custom_Source_clear_Source() throws InterruptedException{
			
		//Expanding Custom Source section
	    expandSection(Constants.GroupsAndUser.custom_sources_strip);
	    Thread.sleep(4000);
	        
	    for(int i=1; i<=5; i++) {
				
			clickCheckboxOfCustomSource(custom_sources[i],String.valueOf(i));
				
		}	
	    
		logger.log(LogStatus.INFO, "verifying if Custom Source clear");			
		custom_source_clear_button.click();
		
		for(int i=1; i<=5; i++) {
			
			Boolean state = stateOfCheckboxOfCustomSource(custom_sources[i],String.valueOf(i));	
			String expected_state="false";
			softassert.assertTrue(state.equals(Boolean.parseBoolean(expected_state)),custom_sources[i]+" checkbox is not cleared");
		}	
		
		softassert.assertAll();
		
	}
	
		
	//to click check-box of required custom source
	public void clickCheckboxOfCustomSource(String custom_source_name,String custom_source_type){
			
		WebElement custom_source = TestBase.driver.findElement(By.xpath("//label[text()='Custom Source "+custom_source_type+"']//parent::div//ul//li//span[starts-with(text(),'"+custom_source_name+"')]/..//preceding-sibling::input"));
		custom_source.click();
	}
	
	
	//to click check-box of required custom source
	public Boolean stateOfCheckboxOfCustomSource(String custom_source_name,String custom_source_type){
		
		Boolean cs_state = null;
		WebElement custom_source = TestBase.driver.findElement(By.xpath("//label[text()='Custom Source "+custom_source_type+"']//parent::div//ul//li//span[starts-with(text(),'"+custom_source_name+"')]/..//preceding-sibling::input"));
			
		try {
			if(custom_source.getAttribute("checked").equals("checked")) {
				cs_state=true;
			}	
		}
		catch(Exception e) {
			cs_state=false;			
		}

		return cs_state;
	}
		
	
	
	public void addCustomSource(String custom_source_type,String cs_name){
			
		WebElement cs_textbox = TestBase.driver.findElement(By.xpath("(//input[@placeholder='Add a New Source'])["+custom_source_type+"]"));
//		WebElement cs_list = TestBase.driver.findElement(By.xpath("//label[text()='Custom Source "+custom_source_type+"']//parent::div//ul//li"));		
		Util.customWait(cs_textbox);
		cs_textbox.sendKeys(cs_name);
		WebElement add_source_click = TestBase.driver.findElement(By.xpath("//*[@id='customized']/ul/li[3]/a[starts-with(text(),'Add custom sources')]"));
		add_source_click.click();
			
	}
	
	    
	//Call Action section UI Verification -----------------------------------------
	@SuppressWarnings("unlikely-arg-type")
	public void callActionSectionUI() throws InterruptedException {
		
		expandSection(Constants.GroupsAndUser.call_actions_strip);
		Thread.sleep(4000);

		deleteAllCations();
		
		logger.log(LogStatus.INFO, "Verifying if Action label is present");
		softassert.assertTrue(action_label.isDisplayed(),"Action label is not displayed");

		logger.log(LogStatus.INFO, "Verifying if If label is present");
		softassert.assertTrue(if_condtion_label.isDisplayed(),"If label is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if Then label is present");
		softassert.assertTrue(then_condtion_label.isDisplayed(),"Then label is not displayed");
	
		logger.log(LogStatus.INFO, "Verifying if Add Action Button is present");
		softassert.assertTrue(add_action_button.isDisplayed(),"Add Action Button is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if Save Button is present");
		softassert.assertTrue(call_action_save_button.isDisplayed(),"Save Button is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if Reset Button is present");
		softassert.assertTrue(call_action_reset_button.isDisplayed(),"Reset Button is not displayed");
	
		//Rules list-box
		Select rules=new Select(if_condition_dropdown);
		
		List<WebElement> options = rules.getOptions();
		
		for(int i=1;i<options.size();i++) {
			
			for(int j=0;j<expected_if_condtion_list.length;j++) {
				
				if(options.get(i).getText().equals(expected_if_condtion_list[j])) {
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_if_condtion_list[j]+" is present");
					softassert.assertTrue(options.get(i).getText().equals(expected_if_condtion_list[j]),expected_if_condtion_list[j]+" is not present");					
				    break;
				}
			}
		}
		
		//Operators for all Rules
		for(int k=0;k<options.size();k++) {
		
			String rule=options.get(k).getText();
			
			logger.log(LogStatus.INFO, "Verifying operators dispalyed for Rule - "+rule);
			ruleOperators(rule,expected_operator_list_for_repeat_call);
			ruleOperators(rule,expected_operator_list_for_duration);
			ruleOperators(rule,expected_operator_list_for_disposition);
			ruleOperators(rule,expected_operator_list_for_caller_id);
			ruleOperators(rule,expected_operator_list_for_missed_opportunity);
			ruleOperators(rule,expected_operator_list_for_sales_inquiry);
			ruleOperators(rule,expected_operator_list_for_conversion);
			ruleOperators(rule,expected_operator_list_for_lead_quality);
			ruleOperators(rule,expected_operator_list_for_referring_source);
			ruleOperators(rule,expected_operator_list_for_referring_type);
			ruleOperators(rule,expected_operator_list_for_UTM_Campaign);
			ruleOperators(rule,expected_operator_list_for_UTM_Source);
			ruleOperators(rule,expected_operator_list_for_UTM_Medium);
			ruleOperators(rule,expected_operator_list_for_Send_to_Voicemail);
			
		}
		
		//And/If operator
//		Select and_if=new Select(and_or_dropdown);
//		
//		logger.log(LogStatus.INFO, "Verifting if And/OR conditions are present");
//		for(int i=0;i<and_if.getOptions().size();i++) {
//			
//			for(int j=0;j<and_or_list.length;j++) {
//				
//				if(and_if.getOptions().get(i).equals(and_or_list[j])) {
//					
//					softassert.assertTrue(and_if.getOptions().get(i).equals(and_or_list[j]),and_or_list[j]+" is not present");
//				}
//			}
//		}
		
		//Action list-box
		
		Select actions=new Select(then_condition_dropdown);
		
		logger.log(LogStatus.INFO, "Verifting options displayed in Action listbox");
		for(int i=0;i<actions.getOptions().size();i++) {
			
			for(int j=0;j<expected_then_condition_list.length;j++) {
				
				if(actions.getOptions().get(i).equals(expected_then_condition_list[j])) {
					
					softassert.assertTrue(actions.getOptions().get(i).equals(expected_then_condition_list[j]),expected_then_condition_list[j]+" is not present");
				}
			}
		}
		
		softassert.assertAll();
		
	}
	
	
	//Rules Operators
	public void ruleOperators(String rule,String[] exp_operator) {

		Select rules=new Select(if_condition_dropdown);
		Select operators=new Select(operator_dropdown);
		
		rules.selectByVisibleText(rule);			
	
		List<WebElement> ops = operators.getOptions();		
		for(int i=1;i<ops.size();i++) {
			
			for(int j=0;j<exp_operator.length;j++) {
								
				if(ops.get(i).getText().equals(exp_operator[j])) {
					
					softassert.assertTrue(ops.get(i).getText().equals(exp_operator[j]),exp_operator[j]+" is not present");
					break;
				}				
			}
			
		}
//		softassert.assertAll();
	}
	
	
	//Call Action Form Validation
	public void callActionFormValidation(String section) {

		expandSection(Constants.GroupsAndUser.call_actions_strip);
		call_action_reset_button.click();
		
		if(section.equals("rule")) {
			//Input for Rule Condition
			Select rules=new Select(if_condition_dropdown);
			rules.selectByVisibleText("duration");

			Select operators=new Select(operator_dropdown);
			operators.selectByVisibleText("=");
			if_condition_textbox.clear();
			if_condition_textbox.sendKeys("10");	
		}
		else if (section.equals("action")) {
			//Input for Rule Condition
			Select rules=new Select(if_condition_dropdown);
			rules.selectByVisibleText("duration");

			Select operators=new Select(operator_dropdown);
			operators.selectByVisibleText("=");
			
			//Input for Action Target
			Select actions=new Select(then_condition_dropdown);
			actions.selectByVisibleText("Flag for call back");
		
		}
		
		
		//Save click
		call_action_save_button.click();
		wait.until(ExpectedConditions.visibilityOf(call_actions_settings_alert));
		logger.log(LogStatus.INFO, "Verifying if alert is displayed");
		Assert.assertTrue(call_actions_settings_alert.isDisplayed(),"Appropriate Alert is npt displayed");
		
	}
	
	
	//Call Actions Reset function
	public void resetCallAction() {
		
		expandSection(Constants.GroupsAndUser.call_actions_strip);
//		call_action_reset_button.click();
		
		//Input for Rule Condition
		Select rules=new Select(if_condition_dropdown);
		rules.selectByVisibleText("duration");

		Select operators=new Select(operator_dropdown);
		operators.selectByVisibleText("=");
		if_condition_textbox.clear();
		if_condition_textbox.sendKeys("10");	
		
		//Input for Action Target
		Select actions=new Select(then_condition_dropdown);
		actions.selectByVisibleText("Flag for call back");
		
		//Reset Button click
		call_action_reset_button.click();
		logger.log(LogStatus.INFO, "Verifyig if call action data is reset");
		
		try {
             Assert.assertTrue(call_actions_settings_success_message.isDisplayed(),"Call action did not reset");
		}catch(Exception e) {
			logger.log(LogStatus.PASS, "");
		}
		
	}

    
	//Call Actions -- Validation for max 10 actions 
	public void add10CallAction() throws InterruptedException{
    	
		expandSection(Constants.GroupsAndUser.call_actions_strip);
		Thread.sleep(4000);
		
    	for(int i=1;i<=10;i++){
    		
    		//Rule
    		WebElement rule = TestBase.driver.findElement(By.xpath("((//h3[text()='If']//ancestor::div[@class='timeline-content'])["+i+"]//select)[2]"));
            
    		wait.until(ExpectedConditions.attributeContains(rule, "aria-disabled", "false"));
    		Select rules=new Select(rule);
    		rules.selectByVisibleText("duration");
    		
    		//operator
    		WebElement operator = TestBase.driver.findElement(By.xpath("((//h3[text()='If']//ancestor::div[@class='timeline-content'])["+i+"]//select)[3]"));
    		Select operators=new Select(operator);
    		operators.selectByVisibleText("=");
    		
    		//rule value
    		WebElement rule_value = TestBase.driver.findElement(By.xpath("((//h3[text()='If']//ancestor::div[@class='timeline-content'])["+i+"]//input)[1]"));
    		rule_value.clear();
    		rule_value.sendKeys("10");
    		
    		//action
    		WebElement action = TestBase.driver.findElement(By.xpath("((//h3[text()='Then']//ancestor::div[@class='timeline-content'])["+i+"]//select)[9]"));
    		Select actions=new Select(action);
    		actions.selectByVisibleText("Flag for call back");
    		
    		//add action button
    		if(i<10){
    			WebElement add_action_button = TestBase.driver.findElement(By.xpath("(//a[text()='Add Action'])["+i+"]"));
        		add_action_button.click();
        		Thread.sleep(2000);
    		}

    		else if(i==10){
				logger.log(LogStatus.INFO, "Verifing if Add action button is not dispalyed after adding 10 call actions");
    			
				try{
        			add_action_button = TestBase.driver.findElement(By.xpath("(//a[text()='Add Action'])["+i+"]"));
    			}
    			catch(Exception e) {
    				logger.log(LogStatus.PASS, "");
    			}

    		}
    	}
//    	driver.navigate().refresh();
//    	Util.waitForLoad(driver);
    	
    }
    

    //Cleanup activity for call actions
    public void deleteAllCations() throws InterruptedException{
    	
//    	driver.navigate().refresh();
//    	Util.waitForLoad(driver);
		expandSection(Constants.GroupsAndUser.call_actions_strip);
		Thread.sleep(4000);
    	List<WebElement> delete_icons = TestBase.driver.findElements(By.xpath("//div[@class='timeline-body']/a[@aria-hidden='false']/i"));
    	
    	if(delete_icons.size()>1) {
    	
    		for(int i=0;i<delete_icons.size();i++){
    			if(i==(delete_icons.size()-1)) {
    				call_action_reset_button.click();
    			}else {
    				Util.customWait(delete_icons.get(i));
        			Util.Action().moveToElement(delete_icons.get(i)).perform();
        			wait.until(ExpectedConditions.elementToBeClickable(delete_icons.get(i)));
            		Util.click(delete_icons.get(i));
            		driver.switchTo().activeElement();
            		wait.until(ExpectedConditions.elementToBeClickable(delete_call_action_ok_button));
            		delete_call_action_ok_button.click();
                    wait.until(ExpectedConditions.visibilityOf(delete_call_action_success_message));
                    logger.log(LogStatus.INFO, "Verifying if Delete call action success message is displayed");
                    softassert.assertTrue(delete_call_action_success_message.isDisplayed(),"call action not deleted successfully");
                    Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);
                    Thread.sleep(500);	
    			}
    			
    		}
        	
        	softassert.assertAll();
    	}
    	
    }
	
    
    //Sub-group section UI ------------------------------------------------------------
    public void subGroupUI() {
    	
    	expandSection(Constants.GroupsAndUser.sub_groups_strip);
    	
    	//Add Sub-group button
    	logger.log(LogStatus.INFO, "Verifying if Add Sub-group button is displayed");
    	softassert.assertTrue(add_subgroup_button.isDisplayed(),"Add Sub-group button is not displayed or locator changed");
    	softassert.assertTrue(add_subgroup_button.isEnabled(),"Add Sub-group button is not clickable");    	

    	//Export Sub-group button
    	logger.log(LogStatus.INFO, "Verifying if Export Sub-group button is displayed");
    	softassert.assertTrue(export_groups_button.isDisplayed(),"Export Sub-group button is not displayed or locator changed");
    	softassert.assertTrue(export_groups_button.isEnabled(),"Add Sub-group button is not clickable");
    	
    	//SUb group section columns
    	logger.log(LogStatus.INFO, "Verifying columns of Sub Group section-------");
    	
    	for(int i=0;i<sub_group_columns.size();i++) {
    		
    		for(int j=0;j<expected_sub_group_columns_names.length;j++) {
    			
    			if(sub_group_columns.get(i).getText().equals(expected_sub_group_columns_names[j])) {
    		    	logger.log(LogStatus.INFO, "Verifying if Column "+expected_sub_group_columns_names[j]+" is diaplayed");    				
    				softassert.assertTrue(sub_group_columns.get(i).getText().equals(expected_sub_group_columns_names[j]),"Column "+expected_sub_group_columns_names[j]+" is not diaplayed");
    			}
    		}
    	}
    	
    	
    }
    
    
    //Sub-group section Pagination Tool-box
	public void subGroupPagiantionToolbox() {

    	expandSection(Constants.GroupsAndUser.sub_groups_strip);
    	
		//verification of buttons in top pagination Tool-box
		String dbCount = Util.readingFromDB("SELECT COUNT(*) as count FROM org_unit WHERE org_unit_parent_id="+TestBase.getOrg_unit_id()+"" );
		
		logger.log(LogStatus.INFO, "verifying presence of buttons in top pagination toolbox");
		wait.until(ExpectedConditions.visibilityOf(groups_topNextPagination_Button));
		
		softassert.assertTrue(groups_topNextPagination_Button.isDisplayed(),"groups_topNextPagination_Button is not present or locator changed");
		softassert.assertTrue(groups_topPrevPagination_Button.isDisplayed(),"groups_topPrevPagination_Button is not present or locator changed");	
		softassert.assertTrue(groups_topFirstPagination_Button.isDisplayed(),"groups_topFirstPagination_count is not present or locator changed");	
		softassert.assertTrue(groups_topLastPagination_Button.isDisplayed(),"groups_topLastPagination_count is not present or locator changed");	
	
		//Next-100 Button and last Button
		if(Integer.parseInt(dbCount)>100) {
			softassert.assertFalse(groups_topLastPagination_Button.getAttribute("class").endsWith("disabled"),"Top Last Pagination button is not clickable");	
			softassert.assertFalse(groups_topNextPagination_Button.getAttribute("class").endsWith("disabled"),"Top Next Pagination button is not clickable");
		}
		
	}
    
	
	//Sub-group pagination count verification
	public void subGroupPaginationCount() {
		
    	expandSection(Constants.GroupsAndUser.sub_groups_strip);
    	
		//verification of count of groups in top pagination tool-box with db	
		String dbCount = Util.readingFromDB("SELECT COUNT(*) as count FROM org_unit WHERE org_unit_parent_id="+TestBase.getOrg_unit_id()+"" );
		String countOnUI_pagination = groups_topPagination_count.getText().substring(groups_topPagination_count.getText().indexOf('f')+2);
	
		logger.log(LogStatus.INFO, "Verifying groups count displeyed in top pagination toolbox with db count");
		softassert.assertEquals(dbCount, countOnUI_pagination,"Count in top pagination toolbox is mismatching with db count");

	}
	

	//Sub-group grid count verification	
	public void subGroupGridCount() {
		
    	expandSection(Constants.GroupsAndUser.sub_groups_strip);
    	
		//verification of count of groups displayed in grid with db
		int final_groups_count=groups_count_in_grid.size()+0;
		String dbCount = Util.readingFromDB("SELECT COUNT(*) as count FROM org_unit WHERE org_unit_parent_id="+TestBase.getOrg_unit_id()+" AND org_unit_status='active'" );
		
		System.out.println("SELECT COUNT(*) as count FROM org_unit WHERE org_unit_parent_id="+TestBase.getOrg_unit_id()+"");
		
		if(!groups_topNextPagination_Button.getAttribute("class").endsWith("disabled")) {
			
			groups_topNextPagination_Button.click();
			final_groups_count=final_groups_count+groups_count_in_grid.size();
		}

		logger.log(LogStatus.INFO, "Verifying count of listed groups in grid with db count");
		softassert.assertEquals(dbCount, String.valueOf(final_groups_count),"Count  of listed groups in grid is mismatching with db count");
		softassert.assertAll();
		
		//Navigating back to first page
		if(!groups_topFirstPagination_Button.getAttribute("class").endsWith("disabled")) {
			groups_topFirstPagination_Button.click();
		}
	}	
	
	
	//Sub-group Validation
	public void subGroupFormValidation(String field) throws InterruptedException {
		
    	expandSection(Constants.GroupsAndUser.sub_groups_strip);
    	Thread.sleep(5000);
    	
    	wait.until(ExpectedConditions.visibilityOf(add_subgroup_button));
//    	add_subgroup_button.click();
    	Util.click(add_subgroup_button);
    	Thread.sleep(2000);
    	
    	if(field.equals("industry")) {
    		subgroup_name_textbox.clear();
    		subgroup_name_textbox.sendKeys("test");
    	}
    	else if ((field.equals("group_name_textbox"))){	
    		subgroup_name_textbox.clear();
    		
    		Select industry=new Select(subgroup_industry_listbox);
    		industry.selectByVisibleText("Advertising: Digital");
    		
    	}
    	
    	//Saving sub-group
    	save_subgroup_button.click();
    	logger.log(LogStatus.INFO, "Verifying if appropriate alert is dispalyed for missing field "+field);
		Assert.assertTrue(saveSubGroupDetails_alert.isDisplayed(),"appropriate alert is not dispalyed for missing field "+field);
		
		//existing from sub-group creation section
//		Util.click(cancel_subgroup_button);
		cancel_subgroup_button.click();
	
	}

	
    //Sub-group Cancel button feature
	public void cancelSubGroup() throws InterruptedException {

	   	expandSection(Constants.GroupsAndUser.sub_groups_strip);
	   	Thread.sleep(5000);
//    	add_subgroup_button.click();
    	Util.click(add_subgroup_button);
    	Thread.sleep(2000);
    	
    	//Entering Sub-group details
    	subgroup_name_textbox.clear();
		subgroup_name_textbox.sendKeys("test");
		Select industry=new Select(subgroup_industry_listbox);
		industry.selectByVisibleText("Advertising: Digital");
		
		//existing from sub-group creation section
		cancel_subgroup_button.click();
		
		logger.log(LogStatus.INFO, "Verifying if sub-group is not created");
		try {
			Assert.assertTrue(subgroup_creation_success_message.isDisplayed(),"sub group created even after clicking on cancel button");
			Assert.fail();
		}
		catch(Exception e) {
			
			logger.log(LogStatus.PASS, "sub group not created after clicking on cancel button");
		}
		
		
	}

	//Sub-group creation
	public void createSubGroup(String groupName) throws InterruptedException{
    	
		expandSection(Constants.GroupsAndUser.sub_groups_strip);
		
    	wait.until(ExpectedConditions.visibilityOf(add_subgroup_button));
//    	add_subgroup_button.click();
    	Util.click(add_subgroup_button);
    	
    	try {
    	
    		//Entering sub-group details
        	subgroup_name_textbox.sendKeys(groupName);
        	Select select=new Select(subgroup_industry_listbox);
        	Thread.sleep(2000);
        	select.selectByIndex(3);  
        	
        	//Saving sub-group details 
            save_subgroup_button.click();

    		
    	}catch(Exception e) {
    		cancel_subgroup_button.click();
    	}
    	
    	String expected_save_sub_group_success_message="Sub-group "+groupName+" is created successfully.";    	
    	logger.log(LogStatus.INFO, "Verifying if Subgroup creation success message is displayed");
    	Assert.assertTrue(subgroup_creation_success_message.getText().equals(expected_save_sub_group_success_message),"Sub group not created successfully.");
      	
    }
	
	
	//Sub-group updation
	public void updateSubGroup(String subGroup,String updated_name) throws InterruptedException {

		expandSection(Constants.GroupsAndUser.sub_groups_strip);
		
		//Editing sub-group to be updated
		clickActionSubGroup(subGroup,Constants.GroupsAndUser.sub_group_edit_button);
		
		try {
			//Updating sub-group details
			subgroup_name_textbox.clear();
	    	subgroup_name_textbox.sendKeys(updated_name);
	    	
	    	//Saving sub-group details 
	        save_subgroup_button.click();
			
		}catch(Exception e) {
			cancel_subgroup_button.click();
		}
		
        
    	logger.log(LogStatus.INFO, "Verifying if Subgroup updation success message is displayed");
    	Assert.assertTrue(subgroup_updation_success_message.isDisplayed(),"Sub group not updated successfully.");
	
	}
	
	
	//Sub-group deletion
	public void subGroupDeletion(String subGroup) throws InterruptedException {
		
        expandSection(Constants.GroupsAndUser.sub_groups_strip);
		
		//Deleting sub-group 
		clickActionSubGroup(subGroup,Constants.GroupsAndUser.sub_group_delete_button);
		
		//Verification
		logger.log(LogStatus.INFO, "Verifying if sub-group deleted successfully");
		wait.until(ExpectedConditions.visibilityOf(subgroup_deletion_success_message));
		Assert.assertTrue(subgroup_deletion_success_message.isDisplayed(),"Sub-group not deleted successfully");
	}
	
	
	//Sub-group navigation
	public void subGroupNavigation(String subGroup) throws InterruptedException {
		
		 expandSection(Constants.GroupsAndUser.sub_groups_strip);
			
		//Selecting newly created group
		clickActionSubGroup(subGroup,Constants.GroupsAndUser.sub_group_select_button);
	    Thread.sleep(5000);
	
		try {
			String strip = TestBase.driver.findElement(By.xpath("//h4[text()='GROUP DETAILS FOR "+subGroup+"']")).toString();
			logger.log(LogStatus.PASS, "Navigated to selected group successfully");
		}catch(Exception e) {
			Assert.fail("Did not navigate to selected group");
		}

		//Navigating back to the previous group
		Breadcrumb bc=new Breadcrumb(driver);
		bc.goToGroup(TestBase.account);
		Thread.sleep(5000);
	
	}
	
	
	//To click action button of desired group
    public void clickActionSubGroup(String group_name,String button_name) throws InterruptedException{
		
		WebElement subGroup;
	
		//sub-group deletion pop-up
		if(button_name.contains("Delete")) {
			subGroup = TestBase.driver.findElement(By.xpath("//span[contains(text(),'"+group_name+"')]//ancestor::tr//div//button[text()='"+button_name+"']"));
			Util.click(subGroup);
			driver.switchTo().activeElement();
			textbox_subgroup_deletion_popup.sendKeys("yes");
			wait.until(ExpectedConditions.elementToBeClickable(ok_button_subgroup_deletion_popup));
			ok_button_subgroup_deletion_popup.click();
//			Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);
			
		}
		else if(button_name.equals("delete_from_selected_group")) {
			subGroup = TestBase.driver.findElement(By.xpath("//a[contains(text(),'Delete')]"));
			Util.click(subGroup);
			driver.switchTo().activeElement();
			textbox_subgroup_deletion_popup.sendKeys("yes");
			wait.until(ExpectedConditions.elementToBeClickable(ok_button_subgroup_deletion_popup));
			Thread.sleep(2000);
			ok_button_subgroup_deletion_popup.click();				

//			Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);
		}
		else {
			//Clicking on desired action button
			subGroup = TestBase.driver.findElement(By.xpath("//span[contains(text(),'"+group_name+"')]//ancestor::tr//div//button[text()='"+button_name+"']"));
	        wait.until(ExpectedConditions.visibilityOf(subGroup));
//			subGroup.click();
			Util.click(subGroup);			
		}
//		wait.until(ExpectedConditions.visibilityOf(saveSubGroupDetails_alert));
//		Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);		
	}
	
    //User section ---------------------------------------------
    //UI Validation
    public void users_UI_Validation() throws InterruptedException{

    	driver.navigate().refresh();
    	Util.waitForLoad(driver);
        expandSection(Constants.GroupsAndUser.user_settings_strip);
        Thread.sleep(4000);
    	
    	logger.log(LogStatus.INFO, "Verifying User Section UI");
//    	Util.customWait(add_user_button);
    	softassert.assertTrue(add_user_button.isEnabled(), "Add User button is not enabled");
//    	Util.customWait(export_users_button);
    	wait.until(ExpectedConditions.attributeToBe(export_users_button, "aria-disabled", "false"));
    	softassert.assertTrue(export_users_button.isEnabled(), "Export Users button is not enabled");
    	
    	for(int i=0; i<users_columns_names.size(); i++) {
    		for(int j=0; j<expected_users_columns_names.length; j++) {
    			
    			if(users_columns_names.get(i).getText().equalsIgnoreCase(expected_users_columns_names[j])) {
    				logger.log(LogStatus.INFO, "Verifying User Page Column labels");
    				softassert.assertTrue(users_columns_names.get(i).getText().equalsIgnoreCase(expected_users_columns_names[j]), expected_users_columns_names + "is not present");	
    				}
    		}
    	}


		softassert.assertAll();
    }

    
    //User section- Pagination tool-box
    public void userpaginationToolbox() {
    	
        expandSection(Constants.GroupsAndUser.user_settings_strip);
    	
		//verification of buttons in top pagination Tool-box
		String dbCount = Util.readingFromDB("SELECT count(*) FROM ct_user WHERE ct_user_ou_id="+TestBase.getOrg_unit_id()+" AND role_id !=4");
		
		logger.log(LogStatus.INFO, "verifying presence of buttons in top pagination toolbox");
		wait.until(ExpectedConditions.visibilityOf(users_topNextPagination_Button));
		
		softassert.assertTrue(users_topNextPagination_Button.isDisplayed(),"Users Top Next Pagination Button is not present or locator changed");
		softassert.assertTrue(users_topPrevPagination_Button.isDisplayed(),"Users Top Previous Pagination Button is not present or locator changed");	
		softassert.assertTrue(users_topFirstPagination_Button.isDisplayed(),"Users Top First Pagination count is not present or locator changed");	
		softassert.assertTrue(users_topLastPagination_Button.isDisplayed(),"Users Top Last Pagination count is not present or locator changed");	
	
		//Next-100 Button and last Button
		if(Integer.parseInt(dbCount)<100) {
			softassert.assertFalse(users_topLastPagination_Button.getAttribute("class").endsWith("disabled"),"Top Last Pagination button is not clickable");	
			softassert.assertFalse(users_topNextPagination_Button.getAttribute("class").endsWith("disabled"),"Top Next Pagination button is not clickable");
		}
    	
    }
    
	
    //User section - pagination count verification
  	public void usersPaginationCount() {
  		
      	expandSection(Constants.GroupsAndUser.user_settings_strip);
      	
  		//Verification of count of users in top pagination tool-box with db	

  		//String dbCount = Util.readingFromDB("SELECT count(*) FROM ct_user WHERE ct_user_ou_id="+TestBase.getOrg_unit_id()+" AND role_id !=4");
  		//String dbCount = Util.readingFromDB("SELECT count(*) FROM ct_user WHERE ct_user_ou_id=70045 AND role_id !=4");

  		String dbCount = Util.readingFromDB("SELECT count(*) AS COUNT FROM ct_user WHERE ct_user_ou_id="+TestBase.getOrg_unit_id()+" AND role_id !=4 AND user_status NOT IN ('deleted')");

  		String countOnUI_pagination = users_topPagination_count.getText().substring(users_topPagination_count.getText().indexOf('f')+2);
  	
  		logger.log(LogStatus.INFO, "Verifying users count displeyed in top pagination toolbox with db count");
  		softassert.assertEquals(dbCount, countOnUI_pagination,"Count in top pagination toolbox is mismatching with db count");
  		
  		softassert.assertAll();

  	}

  	
    //Users section - grid count verification	
  	public void usersGridCount() {
  		
      	expandSection(Constants.GroupsAndUser.user_settings_strip);
      	
  		//verification of count of users displayed in grid with db
  		int final_users_count=users_count_in_grid.size()+0;
  		String dbCount = Util.readingFromDB("SELECT count(*) AS COUNT  FROM ct_user WHERE ct_user_ou_id="+TestBase.getOrg_unit_id()+" AND role_id !=4 AND user_status NOT IN ('deleted')");
  		
  		if(!users_topNextPagination_Button.getAttribute("class").endsWith("disabled")) {
  			
  			users_topNextPagination_Button.click();
  			final_users_count=final_users_count+users_count_in_grid.size();
  		}

  		logger.log(LogStatus.INFO, "Verifying count of listed users in grid with db count");
  		softassert.assertEquals(dbCount, String.valueOf(final_users_count),"Count  of listed users in grid is mismatching with db count");
  		softassert.assertAll();
  		
  		//Navigating back to first page
  		if(!users_topFirstPagination_Button.getAttribute("class").endsWith("disabled")) {
  			users_topFirstPagination_Button.click();
  		}
  	}	
  
  	
    //To check User Roles
  	public void userRoles() throws InterruptedException {
  		
  	  	expandSection(Constants.GroupsAndUser.user_settings_strip);
  	  	//collapseSection(Constants.GroupsAndUser.sub_groups_strip);
  	  	
  	  	wait.until(ExpectedConditions.elementToBeClickable(add_user_button));
  	  	
  	  	Thread.sleep(3000);
  	  
//  	  	add_user_button.click();
  	  	Util.click(add_user_button);
  	   	  	
  	  	logger.log(LogStatus.INFO, "Verifying User Roles");
  	  	
  	  	Select roles=new Select(user_roles_listbox);
  	  	
//  	  	Util.scrollFunction(user_roles_listbox);
  	  	
  	  	for(int i=1;i<roles.getOptions().size();i++) {
  	  		
  	  		for(int j=0;j<expected_roles.length;j++) {
  	  			
  	  			if(roles.getOptions().get(i).equals(expected_roles[j])) {
  	  				
  	  				softassert.assertTrue(roles.getOptions().get(i).equals(expected_roles[j]),"Role - "+expected_roles[j]+" is not present");
  	  				
  	  			}
  	  		}
  	  	}
  	  	
  	  	softassert.assertAll();
  	  	cancel_user_button.click();
  	}
  	
  	
  	//To check if Inactive status is not displayed at the time of user creation
  	public void userStatus() throws InterruptedException {
  		
  		expandSection(Constants.GroupsAndUser.user_settings_strip);
  		//collapseSection(Constants.GroupsAndUser.sub_groups_strip);
  		
  		//Thread.sleep(3000);
    	  
  	  	Util.click(add_user_button);
  	  	
  	  	Select status=new Select(user_status_listbox);
  	  	
  	  	for(int i=0;i<status.getOptions().size();i++) {
  	  		
  	  		softassert.assertFalse(status.getOptions().get(i).equals("Inactive"));
  	  	}
  	  	
  	  	softassert.assertAll();
  	  	cancel_user_button.click();
  	  	
  	}
  	
  	
  	//User creation form validation
  	public void userCreationFormValidation(String field) throws InterruptedException {
  		
  		expandSection(Constants.GroupsAndUser.user_settings_strip);


  	  	Util.click(add_user_button);
  		
  	  	//Entering User details
  	  	first_name_textbox.clear();
  	    first_name_textbox.sendKeys("Automation-Test_user_firstName");
  	  	
  	    last_name_textbox.clear();
  	    last_name_textbox.sendKeys("Automation-Test_user_lastName");
  	    
  	    email_id_textbox.clear();
  	    email_id_textbox.sendKeys("Automation_Test_user@moentek.com");
 
	    Select roles=new Select(user_roles_listbox);
	    roles.selectByVisibleText("Admin");
  	    
  	    //Clearing field
  	    if(field.equals("first_name_textbox")) {
  	    	first_name_textbox.clear();
  	  	}
  	    
  	  	else if(field.equals("last_name_textbox")) {
  	  	    last_name_textbox.clear();
	  	}
  	    
  	  	else if(field.equals("email_id_textbox")) {
  	    	email_id_textbox.clear();
	  	}
  	    
  	    else if(field.equals("role_listbox")) {
  	    	roles.selectByVisibleText("--Select--");
	  	}
  	  	
  	    //Saving User details
  	    Util.click(save_user_button);
  	    
  	    logger.log(LogStatus.INFO, "Verifying if Appropriate alert is displayed for "+field);
  	    wait.until(ExpectedConditions.visibilityOf(user_creation_alert));
  	    Assert.assertTrue(user_creation_alert.isDisplayed(),"Appropriate alert is not dispalyed for "+field);
  	    
  	    //Thread.sleep(5000);
  	    

  	    Util.click(cancel_user_button);
  	    //cancel_user_button.click();
  	}
  	
  	
  	//User section - Cancel feature
  	public void userCancelFeature() throws InterruptedException {
  		
  		int alerts = 0;
  		try {
  			alerts = driver.findElements(By.xpath("//div[@class='ui-pnotify-text']")).size();  		
  		}catch(Exception e) {
  			
  		}finally {
  			if(alerts>0) {
//  				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ui-pnotify-text")));
  				Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);
  			}
  		}

  		expandSection(Constants.GroupsAndUser.user_settings_strip);
    	  
  	  	Util.click(add_user_button);
  	  	Thread.sleep(3000);
  		
  	  	//Entering User details
  	  	first_name_textbox.clear();
  	    first_name_textbox.sendKeys("Automation-Test_user_firstName");
  	  	
  	    last_name_textbox.clear();
  	    last_name_textbox.sendKeys("Automation-Test_user_lastName");
  	    
  	    email_id_textbox.clear();
  	    email_id_textbox.sendKeys("Automation_Test_user@moentek.com");
  	    
	    Select roles=new Select(user_roles_listbox);
	    roles.selectByVisibleText("Admin");
  	    
  	    //Canceling User details
  	    Util.click(cancel_user_button);
  	    
  	    logger.log(LogStatus.INFO, "Verifying if User creation success message is not displayed");    
  	
  	    try {
  	    	Assert.assertTrue(user_creation_alert.isDisplayed());
  	  	    Assert.fail("User creation success message is displayed");
  	    }
  	    catch(Exception e){
  	    	logger.log(LogStatus.PASS, "");
  	    }
  	  
  	}
  	
  	
  	//User creation
    public void createUser(String firstname,String lastname,String email_id,String role) throws InterruptedException{
    	
    	expandSection(Constants.GroupsAndUser.user_settings_strip);
  	  
    	wait.until(ExpectedConditions.visibilityOf(add_user_button));
    	Util.click(add_user_button);
    	//add_user_button.click();
    	
    	//Entering User details
  	  	first_name_textbox.clear();
  	    first_name_textbox.sendKeys(firstname);
  	  	
  	    last_name_textbox.clear();
  	    last_name_textbox.sendKeys(lastname);
  	    
  	    email_id_textbox.clear();
  	    email_id_textbox.sendKeys(email_id);
  	    
	    Select roles=new Select(user_roles_listbox);
	    roles.selectByVisibleText(role);
    	
	    //Saving User Details 
	    Util.click(save_user_button);
    	//save_user_button.click();
    	
    	wait.until(ExpectedConditions.visibilityOf(user_creation_success_message));
    	logger.log(LogStatus.INFO, "Verifying if User creation success message is displayed");
    	Assert.assertTrue(user_creation_success_message.isDisplayed(),"User not created successfully");
    	Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);
    	   	
    }

    
    //User Updation
  	public void updateUser(String user_id,String updated_user_id) throws InterruptedException {
  		
  		expandSection(Constants.GroupsAndUser.user_settings_strip);
  		
  		clickActionUser(user_id,Constants.GroupsAndUser.user_edit_button);
  		
     	//Entering User details
    	wait.until(ExpectedConditions.visibilityOf(email_id_textbox));  		
  	    email_id_textbox.clear();
  	    email_id_textbox.sendKeys(updated_user_id);

  	    //Saving User Details   
    	save_user_button.click();
    	
    	wait.until(ExpectedConditions.visibilityOf(user_updation_success_message));
    	logger.log(LogStatus.INFO, "Verifying if User updation success message is displayed");
    	Assert.assertTrue(user_updation_success_message.isDisplayed(),"User not updated successfully");
  	   
  	}
    
  	
  	//User Deletion
  	public void deleteUser(String user_id) throws InterruptedException {
  		
        expandSection(Constants.GroupsAndUser.user_settings_strip);
  		
        //Deleting user
  		clickActionUser(user_id,Constants.GroupsAndUser.user_delete_button);
  		
  		//verification
  		wait.until(ExpectedConditions.visibilityOf(user_deletion_success_message));
  		logger.log(LogStatus.INFO, "Verifying if User is geting deleted successfully");
  		Assert.assertTrue(user_deletion_success_message.isDisplayed(),"User not deleted successfully");
  		Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);
  	}
  	
  	
  	//User section - Change Password window UI
  	public void changePasswordWindow(String user_id) throws InterruptedException {
  		
  		expandSection(Constants.GroupsAndUser.user_settings_strip);
  		
  		//Opening Change Password window
  		clickActionUser(user_id,Constants.GroupsAndUser.user_change_password_button);
  		
  		//UI Verification
 		wait.until(ExpectedConditions.visibilityOf(change_password_label)); 		
  		logger.log(LogStatus.INFO, "Verifying if Change Password label is present");
  		softassert.assertTrue(change_password_label.isDisplayed(),"Change Password label is not present");

  		logger.log(LogStatus.INFO, "Verifying if Password text-box is present");
  		softassert.assertTrue(change_password_textbox.isDisplayed(),"Password text-box is not present");

  		logger.log(LogStatus.INFO, "Verifying if Change Password OK button is present");
  		softassert.assertTrue(change_password_ok_button.isDisplayed(),"Change Password OK button is not present");
  		
  		logger.log(LogStatus.INFO, "Verifying if Change Password Cancel button is present");
  		softassert.assertTrue(change_password_cancel_button.isDisplayed(),"Change Password Cancel button is not present");
  		
  		softassert.assertAll();
  		
  	    //Closing Change Password window
  		change_password_cancel_button.click();
  	}
  	
  	
  	//User Section - Change password form validation
  	public void changePasswordFormValidation(String user_id) throws InterruptedException {
  		
        expandSection(Constants.GroupsAndUser.user_settings_strip);
  		
  		//Opening Change Password window
  		clickActionUser(user_id,Constants.GroupsAndUser.user_change_password_button);
  		
  		driver.switchTo().activeElement();
  		change_password_textbox.clear();
  		change_password_ok_button.click();
  	
  		//Verification
  		logger.log(LogStatus.INFO, "Verifying if appropriate alert is displayed if password is not entered");
  		Assert.assertTrue(change_password_alert.isDisplayed(),"Appropriate alert is not displayed if password is not entered");
  	
  		Thread.sleep(2000);
  	    //Closing Change Password window
  		try {
  	  		change_password_cancel_button.click();	
  		}catch(Exception e) {
  	  		change_password_cancel_button.click();	  			
  		}
  	}

  	
  	//User Section - Change password cancel feature
  	public void changePasswordCancel(String user_id) throws InterruptedException {
  		
        expandSection(Constants.GroupsAndUser.user_settings_strip);
  		
  		//Opening Change Password window
  		clickActionUser(user_id,Constants.GroupsAndUser.user_change_password_button);
  
  		driver.switchTo().activeElement();
  		change_password_textbox.clear();
  		change_password_textbox.sendKeys("lmc2demo");
  		
  	    //Closing Change Password window
  		change_password_cancel_button.click();
  		
  		//Verification
  		logger.log(LogStatus.INFO, "Verifying if Change password success message is not displayed ");
  		try {
  	  		Assert.assertTrue(change_password_success_message.isDisplayed());
  	  		Assert.fail("Password is changed successfully on clicking cancel button");
  		}
  		catch(Exception e) {
  			logger.log(LogStatus.PASS, "");
  		}
  		
  	}
  	
  	
    //User Section - Change password feature
  	public void changePassword(String user_id) throws InterruptedException {
  		
        expandSection(Constants.GroupsAndUser.user_settings_strip);
  		
  		//Opening Change Password window
  		clickActionUser(user_id,Constants.GroupsAndUser.user_change_password_button);
  		
  		driver.switchTo().activeElement();
  		change_password_textbox.clear();
  		change_password_textbox.sendKeys("lmc2demo");
  		change_password_ok_button.click();
  		
  	    //Verification
  		logger.log(LogStatus.INFO, "Verifying if Change password is working");
  		Assert.assertTrue(change_password_success_message.isDisplayed(),"Password not changed successfully");
  	}
  	
  	
  	//User section - User Permission window UI
  	public void userPermissionUI(String user_id) {
  		
        expandSection(Constants.GroupsAndUser.user_settings_strip);
  		
  		//Opening User Permission window
  		try {
			clickActionUser(user_id,Constants.GroupsAndUser.user_permissions_button);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  		
  		
  		wait.until(ExpectedConditions.visibilityOf(user_permissions_window_label));
  		logger.log(LogStatus.INFO, "Verifying if User Permissions label is present");
  		softassert.assertTrue(user_permissions_window_label.isDisplayed(),"User Permissions label is not present");
  		
  		logger.log(LogStatus.INFO, "Verifying if Access Audio label is present");
  		softassert.assertTrue(user_permissions_access_audio_label.isDisplayed(),"Access Audio label is not present");
  		
  		logger.log(LogStatus.INFO, "Verifying if Access Audio toggle is present");
  		softassert.assertTrue(user_permissions_access_audio_toggle.isDisplayed(),"Access Audio toggle is not present");  		
  		
  		logger.log(LogStatus.INFO, "Verifying if Score Call label is present");
  		softassert.assertTrue(user_permissions_score_calls_label.isDisplayed(),"Score Call label is not present");
  	
  		logger.log(LogStatus.INFO, "Verifying if Score Call toggle is present");
  		softassert.assertTrue(user_permissions_score_calls_toggle.isDisplayed(),"Score Call toggle is not present");

  		logger.log(LogStatus.INFO, "Verifying if Groups Access label is present");
  		softassert.assertTrue(user_permissions_group_access_label.isDisplayed(),"Groups Access label is not present");
 
 		logger.log(LogStatus.INFO, "Verifying if Reporting Access label is present");
  		softassert.assertTrue(user_permissions_reporting_access_label.isDisplayed(),"Reporting Access label is not present");
  		
 		logger.log(LogStatus.INFO, "Verifying if cancel button is present");
  		softassert.assertTrue(user_permissions_cancel_button.isDisplayed(),"Cancel button is not present");

 		logger.log(LogStatus.INFO, "Verifying if Save button is present");
  		softassert.assertTrue(user_permissions_save_button.isDisplayed(),"Save button is not present");
  
  		softassert.assertAll();
  		user_permissions_cancel_button.click();
  		
  	}
  	
  	
  	//User Section - User permission cancel feature
  	public void userPermissionCancelFeature(String user_id) throws InterruptedException {

  	    expandSection(Constants.GroupsAndUser.user_settings_strip);
  		
  	    //Opening User Permission window
  		clickActionUser(user_id,Constants.GroupsAndUser.user_permissions_button);  		
  		
  		user_permissions_access_audio_toggle.click();
  		
  		user_permissions_cancel_button.click();
  	
 		logger.log(LogStatus.INFO, "Verifying if User permissions does not update on clicking cancel button");	
  		try {
  			Assert.assertTrue(user_permissions_update_success_message.isDisplayed());
  			Assert.fail("User permissions updated on clicking cancel button");
  		}
  		catch(Exception e) {
  			logger.log(LogStatus.PASS, "");
  		}
  		
  	}
  	

  	//User Section - Update User permission
  	public void updateUserPermissions(String user_id) throws InterruptedException {
  		
  	    expandSection(Constants.GroupsAndUser.user_settings_strip);
  		
  	    //Opening User Permission window
  		clickActionUser(user_id,Constants.GroupsAndUser.user_permissions_button);  		
  		
  		wait.until(ExpectedConditions.visibilityOf(user_permissions_access_audio_toggle));
//  		user_permissions_access_audio_toggle.click();
  		Util.click(user_permissions_access_audio_toggle);
  		user_permissions_save_button.click();

		wait.until(ExpectedConditions.visibilityOf(user_permissions_update_success_message));
 		logger.log(LogStatus.INFO, "Verifying if User permissions gets updated");	
  		Assert.assertTrue(user_permissions_update_success_message.isDisplayed(),"User permissions not updated successfully");
  		Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);
  		
  	}
  	
  	
  	//To click action button of desired user
    public void clickActionUser(String user_email,String button_name) throws InterruptedException{
		
//		WebElement button = TestBase.driver.findElement(By.xpath("//span[contains(text(),'"+user_email+"')]//ancestor::tr//div//button[text()='"+button_name+"']"));
		WebElement button = null;
		
		for(int i=0;i<100;i++) {
			try {
				button = TestBase.driver.findElement(By.xpath("//span[contains(text(),'"+user_email+"')]//ancestor::tr//div//button[text()='"+button_name+"']"));					
				break;
			}catch(Exception e) {
				Util.click(users_topNextPagination_Button);
				Thread.sleep(2000);
			}	
		}
	
		wait.until(ExpectedConditions.visibilityOf(button));
//		button.click();
		Util.click(button);
		Thread.sleep(3000);
	
		//Deletion pop-up
		if(button_name.contains("Delete")) {
			driver.switchTo().activeElement();
			user_deletion_confiramtion_popup_textbox.sendKeys("yes");
			user_deletion_confiramtion_popup_ok_button.click();
		}	
	if(!users_topFirstPagination_Button.getAttribute("class").endsWith("disbaled")) {
			Util.click(users_topFirstPagination_Button);
			Thread.sleep(4000);
		}
	
    }
    
    
    /*User Section - Clean up Activity
     *use user_email -- delete_automation_user in Test class
     */
    public void cleanUpUsers(String user_email) throws InterruptedException {

        expandSection(Constants.GroupsAndUser.user_settings_strip);
    	
        clickActionUser(user_email,"Delete");
        
        logger.log(LogStatus.INFO, "User section clean up activity");
        Assert.assertTrue(user_deletion_success_message.isDisplayed());
    	
    }
    
    
    //To expand desired section-------------------
    public void expandSection(String section_name){
    	
    	WebElement strip;
    	WebElement strip_state;
    	
    	if(!(section_name.startsWith("Users") || section_name.startsWith("Sub-Groups") || section_name.startsWith("Call Actions"))){

    		strip_state = TestBase.driver.findElement(By.xpath("(//h4[starts-with(text(),'"+section_name.toUpperCase()+"')]//ancestor::div[@class='panel panel-midnightblue']//div)[2]"));
    		strip = TestBase.driver.findElement(By.xpath("//h4[contains(@class,'ng-binding')][starts-with(text(),'"+section_name.toUpperCase()+"')]//parent::div//i[starts-with(@class,'pull-right')]"));
    	}
    	else{

    		strip_state = TestBase.driver.findElement(By.xpath("(//h4[starts-with(text(),'"+section_name+"')]//ancestor::div[@class='panel panel-midnightblue']//div)[2]"));
    		strip = TestBase.driver.findElement(By.xpath("//h4[contains(@class,'ng-binding')][starts-with(text(),'"+section_name+"')]//parent::div//i[starts-with(@class,'pull-right')]"));
    		//Util.scrollFunction(strip);
    	}
    	
    	if(strip_state.getAttribute("aria-hidden").equals("true")){
			wait.until(ExpectedConditions.elementToBeClickable(strip));
			strip.click();
	    	logger.log(LogStatus.INFO, "Verifying if "+section_name+" is expandable");			
	    	Assert.assertTrue(strip_state.getAttribute("aria-hidden").equals("false"),section_name+" is not expandable");
		}
    }

    
    //To collapse desired section-------------------
    public void collapseSection(String section_name){
 
    	WebElement strip;
    	WebElement strip_state;
    	
    	if(!(section_name.startsWith("Users") || section_name.startsWith("Sub-Groups") || section_name.startsWith("Call Actions"))){

    		strip_state = TestBase.driver.findElement(By.xpath("(//h4[starts-with(text(),'"+section_name.toUpperCase()+"')]//ancestor::div[@class='panel panel-midnightblue']//div)[2]"));
    		strip = TestBase.driver.findElement(By.xpath("//h4[contains(@class,'ng-binding')][starts-with(text(),'"+section_name.toUpperCase()+"')]//parent::div//i[starts-with(@class,'pull-right')]"));
    	}
    	else{
    		strip_state = TestBase.driver.findElement(By.xpath("(//h4[starts-with(text(),'"+section_name+"')]//ancestor::div[@class='panel panel-midnightblue']//div)[2]"));
    		strip = TestBase.driver.findElement(By.xpath("//h4[contains(@class,'ng-binding')][starts-with(text(),'"+section_name+"')]//parent::div//i[starts-with(@class,'pull-right')]"));
    	}
    	
    	if(strip_state.getAttribute("aria-hidden").equals("false")){
    		wait.until(ExpectedConditions.elementToBeClickable(strip));
			strip.click();
			
	    	logger.log(LogStatus.INFO, "Verifying if "+section_name+" is collapsible");			
	    	Assert.assertTrue(strip_state.getAttribute("aria-hidden").equals("true"),section_name+" is not collapsible");
		}
	}
 
    
    //Part of Test Data creation------------------------------
    public void updateTNSettings() throws InterruptedException{
    	expandSection(Constants.GroupsAndUser.tn_settings_strip);
//    	Util.scrollFunction(configure_voicemail_greetings_textbox);
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
//			instant_insights_checkbox.click();
			Util.click(instant_insights_checkbox);
		}
		Select select = new Select(instant_insights_dropdown); 
		select.selectByVisibleText("Call Outcome (Conversion type)");
//		instant_insights_checkbox.click();
		Util.click(instant_insights_checkbox);    	
		//DNI section
		if(DNI_checkbox.getAttribute("aria-checked").equals("true")) {
		    Util.click(DNI_checkbox);	
		}
		
		//Ring to number
		ring_to_number_textbox.clear();
		ring_to_number_textbox.sendKeys("1234567891");
		
    	tracking_number_settings_details_save_Button.click();
    	
    	logger.log(LogStatus.INFO, "Verifying if TN settings updation success message is displayed");
    	Assert.assertTrue(tn_settings_success_message.isDisplayed(),"TN settings updation success message is not displayed");
    	Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);
    	Thread.sleep(2000);	
    }
    
    public void closePopup() {
    	try {
    		Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);	
    	}catch(Exception e) {
    		
    	}
    }

    
    
    
    
    
}