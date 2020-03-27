package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import tests.TestBase;
import tests.Util;

public class TrackingNumberSettingsReport_Page extends TestBase{
	
	SoftAssert softassert=new SoftAssert();
	
	@FindBy(xpath="//div[@class='pageProgressLoader']")
	private static WebElement loading_wheel;
	
    @FindBy(xpath="//h1[contains(text(),'Tracking Number Settings')]")
	private static WebElement trackingNumberSettings_header;
    
    @FindBy(xpath="//div[contains(text(),'Loading Data...')]")
	private static WebElement loading_data_label;
    
	@FindBy(xpath="//a[@class='btn btn-sm btn-default'][text()='Schedule Report']")
	private static WebElement scheduleReport_button;
	
	@FindBy(xpath="//button[@class='btn btn-sm btn-default btn-last dropdown-toggle']")
	private static WebElement export_button;

	@FindBy(xpath="//span[@class='pull-left ng-binding'][contains(text(),'Showing')]")
	private static WebElement showing_label;
	
	@FindBy(xpath="//input[@id='simpleChart']")
	private static WebElement basic_search_textbox;
	
	@FindBy(xpath="//input[@id='simpleChart']//parent::div//button[1]")
	private static WebElement basic_search_button;

	@FindBy(xpath="//input[@id='simpleChart']//parent::div//button[2]")
	private static WebElement basic_search_cancel_button;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-block btn-adv'][text()='Advanced Filter']")
	private static WebElement advanced_filter_button;	
	
	@FindBy(xpath="//i[@class='fa fa-columns']")
	private static WebElement column_Picker_button;
	
	@FindBy(xpath="//table[@id='classflowDataTable']//thead//tr//th")
	private static List<WebElement> actual_column_names;
	
	String[] expected_column_names={" ID"," Tracking Number Name"," Tracking Number"," Type"," Ring-to Phone Number"," Ad Source"," Status"," Group Name"," Campaign name"," DNI"," Record Call"," Play Disclaimer"," Voice Prompt"," Whisper Message"};

	//Pagination
	@FindBy(xpath="//button[text()='First']")
	private static WebElement first_button;	
	
	@FindBy(xpath="//button[text()='Prev 100']")
	private static WebElement prev_100_button;
	
	@FindBy(xpath="//button[text()='Next 100']")
	private static WebElement next_100_button;	

	@FindBy(xpath="//button[text()='Last']")
	private static WebElement last_button;
	
	@FindBy(xpath="//button[contains(text(),'Showing')]")
	private static WebElement pagination_call_count_label;
	
	@FindBy(xpath="//table[@id='classflowDataTable']//tbody//tr")
	private static List<WebElement> table_call_count;
	
	@FindBy(xpath="//div[@class='advancedf']//select[1]")
	private static WebElement include_exclude_listbox;
	String[] expected_include_exclude_listbox={"Include","Exclude"};
	
	@FindBy(xpath="//div[@class='advancedf']//select[2]")
	private static WebElement advance_filter_elements_listbox;
	String[] expected_advance_filter_elements={"Tracking Number ID","Tracking Number Name","Tracking Number","Tracking Number Type","Ring to phone number","Ad Source","Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5","Tracking Number Status","Group name","Campaign Name","DNI Type","Host Domain","Referring Website","Html Class","Custom Parameters","Play Disclaimer","Voice Prompt","Whisper Message","Record Call","Pre-call webhook","Hunt Type","Voicemail"};
	
	@FindBy(xpath="//button[@class='btn btn-gray']")
	private static WebElement add_advance_filter_button;

	@FindBy(xpath="//div[@class='advancedf']//select[3]//following-sibling::input[1]")
	private static WebElement advance_filter_textbox;
	
	@FindBy(xpath="//button[@class='btn btn-primary'][contains(text(),'Apply')]")
	private static WebElement apply_button;

	@FindBy(xpath="//button[@class='btn btn-default'][contains(text(),'Cancel')]")
	private static WebElement cancel_button;

	@FindBy(xpath="//ul[@id='columnpicker']//li//input")
	private static List<WebElement> column_picker_options_checkboxes;
	
	String[] expected_all_column_picker_options={"ID","Tracking Number Name","Tracking Number","Type","Hunt Type","Ring-to Phone Number","Ad Source","Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5","Status","Group Name","Campaign name","DNI","Host Domain","Referring Website","HTML Class","Custom Params","Record Call","Play Disclaimer","Voice Prompt","Whisper Message","Pre-Call Webhook","Voicemail"};
	
	String[] expected_default_checked_column_picker_options={"ID","Tracking Number Name","Tracking Number","Type","Ring-to Phone Number","Ad Source","Status","Group Name","Campaign name","DNI","Record Call","Play Disclaimer","Voice Prompt","Whisper Message"};
	
	private TrackingNumberSettingsReport_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	static TrackingNumberSettingsReport_Page tn;
	static int counter=0;
	
	public static TrackingNumberSettingsReport_Page instance(){
		if(counter==0){
		tn=new TrackingNumberSettingsReport_Page(driver);
		counter++;
		}
		return tn;
		
	}
	
    public void UIVerification() throws InterruptedException{
		
		wait.until(ExpectedConditions.visibilityOf(trackingNumberSettings_header));
		logger.log(LogStatus.INFO, "verifying if trackingNumberSettings_header is displayed");
		softassert.assertTrue(trackingNumberSettings_header.isDisplayed(),"trackingNumberSettings_header is not displayed or locator changed");
		
				
		logger.log(LogStatus.INFO, "verifying if scheduleReport_button is displayed");
		softassert.assertTrue(scheduleReport_button.isDisplayed(),"scheduleReport_button is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "verifying if export_button is displayed");
		softassert.assertTrue(export_button.isDisplayed(),"export_button is not displayed or locator changed");
	
		logger.log(LogStatus.INFO, "verifying if showing_label is present");
		softassert.assertTrue(showing_label.isDisplayed(),"showing_label is not displayed or locator changed");
		
		
		
		logger.log(LogStatus.INFO, "verifying if basic_search_textbox is displayed");
		softassert.assertTrue(basic_search_textbox.isDisplayed(),"basic_search_textbox is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "verifying if basic_search_button is presnet");
		softassert.assertTrue(basic_search_button.isDisplayed(),"basic_search_button is not present or locator changed");
		
		logger.log(LogStatus.INFO, "verifying if basic_search_cancel_button is present");
		softassert.assertTrue(basic_search_cancel_button.isDisplayed(),"basic_search_cancel_button is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "verifying if advanced_filter_button is present");
		softassert.assertTrue(advanced_filter_button.isDisplayed(),"advanced_filter_button is not displayed or locator chnaged");
		
		logger.log(LogStatus.INFO, "Verifying if column_Picker_button is present");
		softassert.assertTrue(column_Picker_button.isDisplayed(),"column_Picker_button is not displayed or locator changed");
		
		softassert.assertAll();
		
	}  



}

