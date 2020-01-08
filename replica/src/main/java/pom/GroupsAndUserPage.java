package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroupsAndUserPage {
	
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
	
	@FindBy(xpath="//label[contains(text(),'Call Value')]//parent::*//following-sibling::div//input")
	private WebElement call_value_textbox;

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

	@FindBy(xpath="//li[1]//div[2]//div[2]//div[1]//div[2]//div[1]//div[2]//div[2]//select[1]")
	private WebElement operator_dropdown;

	@FindBy(xpath="//li[1]//div[2]//div[2]//div[1]//div[2]//div[1]//div[2]//div[3]//select[1]")
	private WebElement if_condtion_dropdown_value;

	@FindBy(xpath="//div[@class='col-lg-2 col-md-2 col-sm-2 col-xs-2 col-sm-offset-1']//div//select[@class='form-control ng-pristine ng-untouched ng-valid ng-isolate-scope']")
	private WebElement and_or_dropdown;

	@FindBy(xpath="//li[1]//div[@ class='col-sm-4 col-xs-3 callactionresponsive']//select")
	private WebElement then_condition_dropdown;


	//pending
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

	
	//wherever select class is used need to write values in it to use select.selectbyname
	//whereever select class is used from dropdown store all options in string for verification purposecmd
	
	
	WebDriver driver;	
	
	public GroupsAndUserPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCheckboxOfCustomSource(String csa,String custom_source_type){
		
		WebElement webelement = driver.findElement(By.xpath("//label[text()='Custom Source "+custom_source_type+"']//parent::div//ul//li//span[text()="+csa+"]/..//preceding-sibling::input"));
		return webelement;
	}
	
}
