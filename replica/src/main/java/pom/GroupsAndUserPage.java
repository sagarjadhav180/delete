package pom;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.LogStatus;

import tests.TestBase;
import tests.Util;

public class GroupsAndUserPage extends TestBase {
	
	String groupName="Ganesh 5";
	
	
	@FindBy(xpath="//div[@ class='groupDetailsProgressLoader']")
	private WebElement loadingWheel;
	
	@FindBy(xpath="//h1[contains(text(),'Group and User')]")
	private WebElement groupsAndUserPage_label;

	@FindBy(xpath="//div[@class='table-to-scrape']//button[1]//span[contains(text(),'Export')]")
	private WebElement exportGroupsUsers_button;

	//Sections
	@FindBy(xpath="//h4[contains(@class,'ng-binding')]")
	private List<WebElement> section_labels;
	
	//all labels
	@FindBy(xpath="//label")
	private List<WebElement> all_labels;
	
	
	//Group Details 
	String[] groupDetailsLabels={"Name","External ID","Industry","Phone","City","State/Province","Zip/Postal Code"};
	
	@FindBy(xpath="//button[contains(text(),'Save Group Details')]")
	private WebElement saveGroupDetails_button;	
	
	@FindBy(xpath="//select[@id='source'][contains(@validate-blur-forza,'State')]")
	private WebElement state_dropdown;	

	String[] states={"Alaska","Hawaii","California","Nevada","Oregon","Washington","Arizona","Colorado","Idaho","Montana","Nebraska","New Mexico","North Dakota","Utah","Wyoming","Alabama","Arkansas","Illinois","Iowa","Kansas","Kentucky","Louisiana","Minnesota","Mississippi","Oklahoma","South Dakota","Texas","Tennessee","Wisconsin","Connecticut","Delaware","Florida","Georgia","Indiana","Maine","Maryland","Massachusetts","Michigan","New Hampshire","New Jersey","New York","North Carolina","Ohio","Pennsylvania","Rhode Island","South Carolina","Vermont","Virginia","West Virginia","Alberta","British Columbia","Manitoba","New Brunswick","Newfoundland","Northwest Territories","Nova Scotia","Ontario","Prince Edward Island","Quebec","Saskatchewan","Yukon"};
	
	
	@FindBy(xpath="//select[@ng-model='industry']")
	private WebElement industry_dropdown;
	
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

	@FindBy(xpath="//tr[11]//td[9]//form[1]//button[contains(text(),'Save')]")
	private WebElement save_subgroup;

	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	private WebElement save_subgroup_success_message;
	
	//Feature Settings Details 
	@FindBy(xpath="//div [@class='primary switch ats-switch ng-isolate-scope ng-valid ng-dirty ng-touched']")
	private WebElement CA_toggle;	
	
	@FindBy(xpath="//div[@ class='primary switch ats-switch ng-isolate-scope disabled ng-valid']")
	private WebElement spamGuard_toggle;	
	
	@FindBy(xpath="(//div[@ class='primary switch ats-switch ng-isolate-scope ng-valid'])[2]")
	private WebElement shareDNI_toggle;


	//Tracking Number Settings Details 
	
	@FindBy(xpath="//form[@id='ouForm2']//div//button[@class='btn btn-primary'][contains(text(),'Save')]")
	private WebElement tracking_number_settings_details_saveButton;	

	@FindBy(xpath="//form[@id='ouForm2']//div//button[@class='reset btn'][contains(text(),'Reset')]")
	private WebElement tracking_number_settings_details_resetButton;
	
	String[] trackingNumberLabels={"Call Value","Repeat Interval (in hours)","Activate Voicemail?","Voicemail","Configure Voicemail Greetings","Overflow","Ring-to Phone Number","Host Domain","Referring Website","DNI Type","HTML Class"};
	String[] checkBoxLabels_forTN={"Record Call","Play a voice prompt","Play whisper message before connecting",""};
	String[] instantInsights_labels_for_call_outcome={"Key Press","Voice prompt for Call outcome","Record a Sale","Sale amount voice prompt","Record a Lead"};
	String[] instantInsights_labels_for_agentID={"Record Agent ID","Agent ID voice prompt","Number of Digits in Agent Id",""};
	
	@FindBy(xpath="//span[contains(text(),'Dynamic Number')]")
	private WebElement DNI_checkbox_label;
	
	@FindBy(xpath="//label//parent::*//input[@id='showDNI']")
	private WebElement hostDomain_textbox;	
	
	@FindBy(xpath="//label//parent::*//input[@name='dni_element']")
	private WebElement htmlclass_textbox;	

	@FindBy(xpath="//label[text()='Referring Website']//parent::*//select")
	private WebElement reffering_website_dropdown;

	@FindBy(xpath="//label[text()='DNI Type']//parent::*//select")
	private WebElement dni_type_dropdown;

	String[] dni_types={"URL","Source"};
	
	@FindBy(xpath="//a[text()='Custom Parameters']//parent::div")
	private WebElement custom_parameters;
	
	@FindBy(xpath="//label[contains(text(),'Instant Insights')]")
	private WebElement instant_insights_label;
	
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
	
	
	@FindBy(xpath="//label[contains(text(),'Call Value')]//parent::*//following-sibling::div//input")
	private WebElement call_value_textbox;

	@FindBy(xpath="//md-checkbox[@class='ng-pristine ng-untouched ng-valid md-checked']//div[@class='md-icon']")
	private WebElement record_call_checkbox;

	@FindBy(xpath="(//md-checkbox[@class='ng-valid ng-dirty ng-valid-parse ng-touched']//div[@class='md-icon'])[1]")
	private WebElement voice_prompt_checkbox;

	@FindBy(xpath="(//md-checkbox[@class='ng-valid ng-dirty ng-valid-parse ng-touched']//div[@class='md-icon'])[2]")
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
	private WebElement ringtonumber_textbox;
	
	
	//Custom Sources Section
	
	@FindBy(xpath="//p[text()='With your own custom sources, you can easily categorize your calls. When created, it becomes available to be applied for that group and any sub-groups below.']")
	private WebElement custom_sources_note;	
	
	String[] customsources_labels={"Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5"};
	
	@FindBy(xpath="(//input[@placeholder='Add a New Source'])[1]")
	private WebElement custom_source1_textbox;		

	@FindBy(xpath="//label[text()='Custom Source 1']//parent::div//ul//li")
	private WebElement custom_source1_list;	
	
	@FindBy(xpath="(//input[@placeholder='Add a New Source'])[2]")
	private WebElement custom_source2_textbox;

	@FindBy(xpath="//label[text()='Custom Source 2']//parent::div//ul//li")
	private WebElement custom_source2_list;	
	
	@FindBy(xpath="(//input[@placeholder='Add a New Source'])[3]")
	private WebElement custom_source3_textbox;
	
	@FindBy(xpath="//label[text()='Custom Source 3']//parent::div//ul//li")
	private WebElement custom_source3_list;	
	
	@FindBy(xpath="(//input[@placeholder='Add a New Source'])[4]")
	private WebElement custom_source4_textbox;
	
	@FindBy(xpath="//label[text()='Custom Source 4']//parent::div//ul//li")
	private WebElement custom_source4_list;	
	
	@FindBy(xpath="(//input[@placeholder='Add a New Source'])[5]")
	private WebElement custom_source5_textbox;
	
	@FindBy(xpath="//label[text()='Custom Source 5']//parent::div//ul//li")
	private WebElement custom_source5_list;	

	@FindBy(xpath="//button[contains(text(),'Clear')]")
	private WebElement custom_source_clear_button;	

	@FindBy(xpath="//button[contains(text(),'Selected')]")
	private WebElement custom_source_delete_button;	
	
	
	//Call Action Settings Section
	//all xpaths are written for first call action
	@FindBy(xpath="//li[1]//div[2]//div[2]//div[1]//div[2]//div[1]//div[2]//div[1]//select[1]")
	private WebElement if_condtion_dropdown;		

	String[] if_condtion_list={"repeat call","duration","disposition","caller id","missed opportunity","sales inquiry","conversion","lead quality","referring source","referring type","UTM Campaign","UTM Source","UTM Medium","Send to Voicemail"};
	
	@FindBy(xpath="//li[1]//div[2]//div[2]//div[1]//div[2]//div[1]//div[2]//div[2]//select[1]")
	private WebElement operator_dropdown;

	String[] operator_list={"is","is not"};
	
	@FindBy(xpath="//li[1]//div[2]//div[2]//div[1]//div[2]//div[1]//div[2]//div[3]//select[1]")
	private WebElement if_condtion_dropdown_value;

	String[] if_condtion_dropdown_list={"true","false"};
	
	@FindBy(xpath="//div[@class='col-lg-2 col-md-2 col-sm-2 col-xs-2 col-sm-offset-1']//div//select[@class='form-control ng-pristine ng-untouched ng-valid ng-isolate-scope']")
	private WebElement and_or_dropdown;

	String[] and_or_list={"AND","OR"};
	
	@FindBy(xpath="//li[1]//div[@ class='col-sm-4 col-xs-3 callactionresponsive']//select")
	private WebElement then_condition_dropdown;

    String[] then_condition_list={"Send email alert to","Send SMS to","Tag call as","Trigger the webhook","Flag for call back","Send call for Google Analytics"};
	
	@FindBy(xpath="//div[@ class='col-sm-8 col-xs-8 callactionresponsive']//span//preceding-sibling::input")
	private WebElement then_condition_for_email;
	
	@FindBy(xpath="//div[@ class='col-sm-8 col-xs-8 callactionresponsive']//input[@id='smsNumber']")
	private WebElement then_condition_for_sms;

	@FindBy(xpath="//div[@ class='col-sm-8 col-xs-8 callactionresponsive']//ul[@class='select2-choices']")
	private WebElement then_condition_for_tag_call;

	@FindBy(xpath="//div[@ class='col-sm-8 col-xs-8 callactionresponsive']//select[@id='triggerWebhook']")
	private WebElement then_condition_for_webhook;

	@FindBy(xpath="//div[@ class='col-sm-8 col-xs-8 callactionresponsive']//select[@id='triggerWebhook']//following-sibling::a//i")
	private WebElement jump_to_webhook_settings_link;

	
	//sub group section
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

	@FindBy(xpath="//form[@class='form-buttons form-inline ng-pristine ng-valid']//button[@class='btn btn-sm btn-primary'][contains(text(),'Save')]")
	private WebElement save_user_button;
	
	@FindBy(xpath="(//div[@class='editable-controls form-group']//select)[1]")
	private WebElement roles_listbox;	

	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	private WebElement user_creation_success_message;
	
	@FindBy(xpath="(//span[text()='Export Users'])[1]//parent::button")
	private WebElement export_users_button;	

	@FindBy(xpath="//table[@ id='table_group_user']//th")
	private List<WebElement> users_columns;

    String[] users_names={"First Name","Last Name","Email","Agent Ring-to","Agent ID","Role","Status","Actions"};

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
    	
    	for(int i=0;i<section_labels.size();i++){
    		if(section_labels.get(i).getText().startsWith(section)){
    			section_labels.get(i).click();
    		}
    	}
    	
    }
    
    public void createGroup(String groupName){
    	
    	wait.until(ExpectedConditions.visibilityOf(add_subgroup_button));
    	add_subgroup_button.click();
    	groupName_textbox.sendKeys(groupName);	
    	
    	Select select=new Select(industry_dropdown);
    	select.selectByIndex(3);
    	save_subgroup.click();
    	
    	String expected_save_sub_group_success_message="Sub-group "+groupName+" is created successfully.";
    	
    	logger.log(LogStatus.INFO, "Verifying if sub-group is created successfully");
    	Assert.assertTrue("Sub group not created successfully.",save_subgroup_success_message.getText().equals(expected_save_sub_group_success_message));
      	
    }
    
    public void createUser(String firstname,String lastname,String email_id,String role){
    	
    	wait.until(ExpectedConditions.visibilityOf(add_user_button));
    	add_user_button.click();
    	
    	first_name_textbox.sendKeys(firstname);
    	last_name_textbox.sendKeys(lastname);
    	email_id_textbox.sendKeys(email_id);
    	
    	Select select=new Select(roles_listbox);
    	select.selectByVisibleText(role);
    	
    	save_user_button.click();
    	
    	logger.log(LogStatus.INFO, "Verifying if "+role+"user is created successfully");
    	String expected_user_creation_success_message="User "+firstname.concat(" ").concat(lastname)+" successfully created.";
    	
    	Assert.assertTrue("User not created successfully",user_creation_success_message.getText().equals(expected_user_creation_success_message));
    }
    
    public void updateTNSettings(){
    	wait.until(ExpectedConditions.visibilityOf(record_call_checkbox));
    	if(!(record_call_checkbox.isSelected())){
    		Util.click(record_call_checkbox);
    	}
    	
    	wait.until(ExpectedConditions.visibilityOf(voice_prompt_checkbox));
    	if(voice_prompt_checkbox.isSelected()){
    		Util.click(record_call_checkbox);
    	}
    	
    	wait.until(ExpectedConditions.visibilityOf(whisper_checkbox));
    	if(whisper_checkbox.isSelected()){
    		Util.click(whisper_checkbox);
    	}
    }
}
