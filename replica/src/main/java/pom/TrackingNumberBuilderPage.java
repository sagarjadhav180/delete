package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import tests.TestBase;

public class TrackingNumberBuilderPage extends TestBase {
    
	SoftAssert softassert=new SoftAssert();
	
	//Tracking number list
	
	@FindBy(xpath="//h4[contains(text(),'TRACKING NUMBERS FOR test_automation_campaign')]")
	private static WebElement header;

	@FindBy(xpath="//button[@class='btn btn-info'][contains(text(),'Add Tracking Number')]")
	private static WebElement add_tracking_number_button;	

	@FindBy(xpath="(//button[@id='export_btn'])[1]")
	private static WebElement export_button;
	
	@FindBy(xpath="(//table)[4]//thead//th")
	private static List<WebElement> tracking_number_list_column_headers;
	
	String[] tracking_number_list_column_header_name={"Tracking Number","Name","Ring-to Phone Number","Tracking Number Type","Ad Source","Spam Guard","Status","Actions"};
	
	//pagination toolbox
	@FindBy(xpath="(//button[contains(text(),'First')])[1]")
	private static WebElement top_first_button;	

	@FindBy(xpath="(//button[contains(text(),'Last')])[1]")
	private static WebElement top_last_button;	

	@FindBy(xpath="(//button[contains(text(),'Prev')])[1]")
	private static WebElement top_prev_button;	

	@FindBy(xpath="(//button[contains(text(),'Next')])[1]")
	private static WebElement top_next_button;

	@FindBy(xpath="(//button[contains(text(),'Showing')])[1]")
	private static WebElement top_pagination_count;
	
	@FindBy(xpath="(//table)[4]//tr")
	private static List<WebElement> tracking_numbers_count_in_table;	
	
	//Add tracking number page-basic section

	@FindBy(xpath="//label")
	private static WebElement labels;	
	
	String[] label_names={"CONFIGURE NUMBER","NPA-NXX (Area Code)","Tracking Number Name","Ad Source","Tracking Number","CONFIGURE ROUTING OPTIONS"};
	
	@FindBy(xpath="//label[@class='control-label'][contains(text(),'Activate Voicemail ?')]")
	private static WebElement activate_voicemail_checkbox_label;	

	@FindBy(xpath="//label[@class='control-label'][contains(text(),'Activate Voicemail ?')]//parent::div//following-sibling::div//child::md-checkbox")
	private static WebElement activate_voicemail_checkbox;

	@FindBy(xpath="//label[@class='control-label'][contains(text(),'Activate Voicemail ?')]//parent::div//following-sibling::div//child::p")
	private static WebElement activate_voicemail_note;
	
	@FindBy(xpath="//label[@class='control-label'][contains(text(),'Active?')]")
	private static WebElement active_label;

	@FindBy(xpath="(//label[@class='control-label'][contains(text(),'Active?')]//parent::div/following-sibling::div//child::div[contains(@class,'primary switch')])[1]")
	private static WebElement active_label_checkbox;
	
	@FindBy(xpath="(//label[contains(text(),'Set Caller Id To')])[2]")
	private static WebElement set_caller_id_label;

	@FindBy(xpath="//md-radio-button[@id='optionsRadios1']")
	private static WebElement single_number_label;

	@FindBy(xpath="//md-radio-button[@id='optionsRadios1']/div[2]")
	private static WebElement single_number_button;
	
	@FindBy(xpath="//md-radio-button[@id='optionsRadios2']")
	private static WebElement number_pool_label;

	@FindBy(xpath="//md-radio-button[@id='optionsRadios2']/div[2]")
	private static WebElement number_pool_button;
	
	@FindBy(xpath="//md-radio-button[@id='optionsRadios3']")
	private static WebElement reserved_number_label;

	@FindBy(xpath="//md-radio-button[@id='optionsRadios3']/div[2]")
	private static WebElement reserved_number_button;

	@FindBy(xpath="//label[text()='NPA-NXX (Area Code)']//parent::div//following-sibling::div//input")
	private static WebElement area_code_textbox;
	
	@FindBy(xpath="//label[text()='Tracking Number Name']//parent::div//following-sibling::div//input")
	private static WebElement tracking_number_name_textbox;

	@FindBy(xpath="(//label[text()='Ring to Phone Number']//parent::div//following-sibling::div//input)[3]")
	private static WebElement ring_to_phone_number_textbox;

	@FindBy(xpath="//label[text()='Tracking Number']//parent::div//following-sibling::div//child::select")
	private static WebElement tracking_number_dropdown;

	@FindBy(xpath="(//label[text()='Route Calls By']//parent::div//following-sibling::div//child::select[@id='source'])[1]")
	private static WebElement route_calls_by_dropdown;

	@FindBy(xpath="//label[text()='Ad Source']//parent::div//following-sibling::div//child::select[@id='source']")
	private static WebElement ad_source_dropdown;

	@FindBy(xpath="(//label[contains(text(),'Set Caller Id To')]//parent::div//following-sibling::div//child::select)[2]")
	private static WebElement set_caller_id_dropdown;

	//Add tracking number page-advanced section
	
	String[] trackingNumberLabels={"Call Value","Repeat Interval (hours)",
			"Voicemail","Configure Voicemail Greetings","Pre-call Webhook",
			"Record Call","Play call recording disclaimer","Play whisper message before connecting",
			"Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5",
			"Host Domain","Referring Website","DNI Type","HTML Class","Instant Insights","Key Press",
			"Voice prompt for Call outcome","Record a Sale","Sale amount voice prompt",
			"Record a Lead","Record Agent ID","Agent ID voice prompt","Number of Digits in Agent Id",
			"Voice prompt for Call outcome","Record a Sale","Sale amount voice prompt","Record a Lead"};

	@FindBy(xpath="//label[contains(text(),'Dynamic Number')]")
	private static WebElement dynamic_number_label;
	
	@FindBy(xpath="(//label[text()='Play a voice prompt'])[2]")
	private static WebElement play_a_voice_prompt_label;	
	
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
	
	@FindBy(xpath="(//label[text()='Voice prompt for Call outcome']//parent::*//following-sibling::div//textarea)[1]")
	private WebElement voice_prompt_for_call_outcome_textbox;	
	
	//pending
	
	public static WebDriver wait;
	
	public TrackingNumberBuilderPage(WebDriver driver,WebDriverWait wait1){
		PageFactory.initElements(driver,this);
	}
	
	//to get action button of desired tracking number
    public WebElement getgroup(String tracking_number_name,String button_name){
		
		WebElement webelement = driver.findElement(By.xpath("//span[contains(text(),'"+tracking_number_name+"')]//ancestor::tr//div//button[text()='"+button_name+"']"));
		return webelement;
	}
	
  //verification of buttons in top pagination toolbox
//	logger.log(LogStatus.INFO, "verifying presence of buttons in top pagination toolbox");
//	wait.until(ExpectedConditions.visibilityOf(users_topNextPagination_Button));
//	Assert1.assertTrue(top_first_button.isDisplayed(),"top_first_button is not present or locator changed");
//	Assert1.assertTrue(top_last_button.isDisplayed(),"top_last_button is not present or locator changed");	
//	Assert1.assertTrue(top_next_button.isDisplayed(),"top_next_button is not present or locator changed");	
//	Assert1.assertTrue(top_prev_button.isDisplayed(),"top_prev_button is not present or locator changed");	
	
	//verification of count in top pagination toolbox	
//	dbCount = Util.readingFromDB("SELECT count(*) FROM ce_call_flows WHERE provisioned_route_id IN (SELECT provisioned_route_id FROM campaign_provisioned_route  WHERE campaign_id='404') AND status NOT IN ('suspended')" );
//	
//          countOnUI_pagination=top_pagination_count.getText().substring(top_pagination_count.getText().indexOf('f')+2);
//	logger.log(LogStatus.INFO, "verifying count tracking numbers in top pagination toolbox");
//	Assert1.assertEquals(dbCount, countOnUI_pagination,"count in top pagination toolbox is mismatching with db count");
//	
//	logger.log(LogStatus.INFO, "verifying count of listed tracking numbers");
//	Assert1.assertEquals(dbCount, String.valueOf(tracking_numbers_count_in_table.size()),"count  of listed tracking numbers is mismatching with db count");

    
}
