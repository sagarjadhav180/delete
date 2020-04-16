package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import tests.TestBase;

public class ScheduledReportBuilderPage extends TestBase {

	
	@FindBy(xpath="//h1[contains(text(),'Scheduled Report Builder')]")
	private WebElement scheduled_report_builder_label;
	
	@FindBy(xpath="//a[@class='btn btn-default hidden-xs']")
	private WebElement list_button;
	
	@FindBy(xpath="//h4[contains(text(),'Report Details')]")
	private WebElement report_detail_label;	

	@FindBy(xpath="//label[contains(text(),'Active?')]")
	private WebElement active_label;	
	
	@FindBy(xpath="//label[contains(text(),'Scheduled Report Name')]")
	private WebElement scheduled_report_name_label;		

	@FindBy(xpath="//label[contains(text(),'Description')]")
	private WebElement description_label;		
	
	@FindBy(xpath="//label[contains(text(),'Report Type')]")
	private WebElement report_type_label;			

	@FindBy(xpath="//label[contains(text(),'Date Range')]")
	private WebElement date_range_label;
	
	@FindBy(xpath="//label[contains(text(),'Secondary Grouping')]")
	private WebElement secondary_grouping_label;	
	
	@FindBy(xpath="(//span[@class='knob ng-binding ng-scope'])[2]")
	private WebElement report_status_toggle;	

	@FindBy(xpath="//label[contains(text(),'Scheduled Report Name')]//parent::div//div//input")
	private WebElement scheduled_report_name_textbox;
	
	@FindBy(xpath="//label[contains(text(),'Description')]//parent::div//div//input")
	private WebElement description_textbox;	
	
	@FindBy(xpath="//div[@class='input-group']//input[@id='simpleChart']")
	private WebElement basic_search_textbox;	

	@FindBy(xpath="//button[@class='btn btn-primary'][1]")
	private WebElement basic_search_button;

	@FindBy(xpath="//button[@class='btn btn-primary'][2]")
	private WebElement basic_search_clear_button;
	
	@FindBy(xpath="//ul[@class='select2-result-sub']//li//span")
	private List<WebElement> report_type_listbox;	
	String[] expected_report_type_listbox_options={"Call Details","Group Activity","Tracking Number Settings"};
	 
	@FindBy(xpath="//ul[@class='select2-result-sub']//li//span")
	private List<WebElement> secondary_grouping_listbox;		
	String[] expected_secondary_grouping_listbox_options={"None","Tracking Number","Campaign"};
	
	@FindBy(xpath="(//i[@class='fa fa-calendar'])[1]")
	private WebElement date_range_calender_button;			
	
	@FindBy(xpath="(//div[@class='ranges']//ul)[3]//li")
	private WebElement date_range_calender_options;		

	@FindBy(xpath="//div[5]//div[3]//button[1][text()='OK']")
	private WebElement date_range_calender_ok_button;		
	
	@FindBy(xpath="//div[5]//button[2][text()='Cancel']")
	private WebElement date_range_calender_cancel_button;			
	
	@FindBy(xpath="//button[@class='btn btn-default btn-block btn-adv'][text()='Advanced filter']")
	private WebElement advance_filter_button;			
	
	@FindBy(xpath="//button[@class='pull-left btn btn-primary-alt btn-sm'][text()='Save & Preview']")
	private WebElement save_preview_button;				
	
	@FindBy(xpath="//input[@class='btn btn-primary btn-sm mr5 pull-right']")
	private WebElement save_button;
	
	//advance filter
	@FindBy(xpath="//div[@class='advancedf']//select[1]")
	private static WebElement include_exclude_listbox;
	String[] expected_include_exclude_listbox={"Include","Exclude"};
		
	@FindBy(xpath="//div[@class='advancedf']//select[2]")
	private static WebElement advance_filter_elements_listbox;
	
	String[] call_details_expected_advance_filter_elements={"Call ID","Date","Group Name","Campaign Name","Ad Source","Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5","Caller ID","Tracking Number","Destination Name","Destination Number","Duration","Route Name","Tag","Caller/Company Name","Address","City","State/Province","Zip/Postal Code","Disposition","Line Type","Sent to Voicemail","Hunt Type","Tracking Number Type"};
	String[] group_activity_expected_advance_filter_elements={"Group ID","Group Name","Group Ext ID","Calls (GMT)","Billable Minutes (GMT)","Leads","Conversions","Call Value","Unique","Answered"};
	String[] expected_advance_filter_elements={"Tracking Number ID","Tracking Number Name","Tracking Number","Tracking Number Type","Ring to phone number","Ad Source","Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5","Tracking Number Status","Group name","Campaign Name","DNI Type","Host Domain","Referring Website","Html Class","Custom Parameters","Play Disclaimer","Voice Prompt","Whisper Message","Record Call","Pre-call webhook","Hunt Type","Voicemail"};	
	
	@FindBy(xpath="//button[@class='btn btn-gray']")
	private static WebElement add_advance_filter_button;

	@FindBy(xpath="//button[@class='btn btn-default'][text()='Cancel']")
	private static WebElement add_advance_filter_cancel_button;

	//schedule distribution
	@FindBy(xpath="//h4[contains(text(),'Scheduled Distribution')][text()='Scheduled Distribution']")
	private static WebElement scheduled_distribution_label;
	
	@FindBy(xpath="//a[@class='btn btn-default mb20'][text()=' Add New Scheduled Distribution']")
	private static WebElement add_new_scheduled_distribution_button;

	@FindBy(xpath="//table[@class='table table-striped table-hover ng-scope']//thead//tr[1]//th")
	private static List<WebElement> add_new_scheduled_distribution_columns;
	String[] expected_add_new_scheduled_distribution_columns_names={"Name","Frequency","Format","Actions"};
	
	@FindBy(xpath="//label[@class='col-sm-2 control-label'][contains(text(),'From')]")
	private static WebElement from_label;	
	
	@FindBy(xpath="//label[@class='col-sm-2 control-label'][contains(text(),'From')]//parent::div//following-sibling::div//input")
	private static WebElement from_textbox;	
	
	@FindBy(xpath="//label[contains(text(),'Choose a Distribution List:')]")
	private static WebElement choose_distribution_list_label;		

	@FindBy(xpath="//label[contains(text(),'Choose a Distribution List:')]//parent::div//following-sibling::div//select")
	private static WebElement choose_distribution_list_listbox;	

	@FindBy(xpath="//label[contains(text(),'Frequency:')]")
	private static WebElement frequency_label;	
	
	@FindBy(xpath="(//label[contains(text(),'Frequency:')]//parent::div//following-sibling::div//select)[1]")
	private static WebElement frequency_listbox;		
	
	@FindBy(xpath="//a[@class='btn btn-default'][text()=' Create New']")
	private static WebElement create_new_distribution_list_button;	
	
	@FindBy(xpath="//div[@class='col-md-2'][text()='Distribution List Name']")
	private static WebElement distribution_list_name_label;		

	@FindBy(xpath="//div[@class='col-md-2'][text()='Distribution List Name']//parent::div//following-sibling::div//input")
	private static WebElement distribution_list_name_textbox;			
	
	@FindBy(xpath="//div[@class='col-md-2'][text()='Distribution List Name']//parent::div//following-sibling::div[@class='col-md-4']//button[text()='Save']")
	private static WebElement distribution_list_save_button;				
	
	@FindBy(xpath="//div[@class='col-md-2'][text()='Distribution List Name']//parent::div//following-sibling::div[@class='col-md-4']//button[text()='Save & Select']")
	private static WebElement distribution_list_save_select_button;				
	
	@FindBy(xpath="//label[contains(text(),'Emails:')]")
	private static WebElement emails_label;					
	
	@FindBy(xpath="//label[contains(text(),'Emails:')]//parent::div//following-sibling::div//input")
	private static WebElement emails_textbox;				

	@FindBy(xpath="//label[contains(text(),'Message:')]")
	private static WebElement message_label;
	
	@FindBy(xpath="//label[contains(text(),'Message:')]//parent::div//following-sibling::div//textarea")
	private static WebElement message_textbox;
	
	@FindBy(xpath="//label[contains(text(),'Attachment:')]")
	private static WebElement attachment_label;	

	@FindBy(xpath="//ul[@class='select2-choices']")
	private static WebElement attachment_listbox_button;
	
	@FindBy(xpath="//ul[@class='select2-results']//li//div")
	private static WebElement attachment_listbox;
	
	@FindBy(xpath="//input[@class='btn btn-primary btn-sm']")
	private static WebElement save_distribution_list_button;
	
	@FindBy(xpath="//input[@class='btn btn-default btn-sm']")
	private static WebElement cancel_distribution_list_button;	
	
	
	public ScheduledReportBuilderPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	public void scheduled_report_builder_page_label(){
		
	}
	
    public void listButton(){
		
	}
	
	public void reportsDetailUIVerification(){
		
		SoftAssert softassert=new SoftAssert();
		
		logger.log(LogStatus.INFO, "Verifying if active label is displayed");
		softassert.assertTrue(active_label.isDisplayed(),"active label is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "Verifying if active checkbox is displayed");
		softassert.assertTrue(report_status_toggle.isDisplayed(),"active inactive toggle is not dispalyed or locator changed");
		
		logger.log(LogStatus.INFO, "Verifying if schedule report name label is displayed");
		softassert.assertTrue(scheduled_report_name_label.isDisplayed(),"schedule report name label is not displayed or locator changed");

		logger.log(LogStatus.INFO, "Verifying if schedule report name textbox is displayed");
		softassert.assertTrue(scheduled_report_name_textbox.isDisplayed(),"schedule report name textbox is not displayed or locator changed");

		logger.log(LogStatus.INFO, "Verifying if description label is displayed");
		softassert.assertTrue(description_label.isDisplayed(),"description label is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "Verifying if description textbox is displayed");
		softassert.assertTrue(description_textbox.isDisplayed(),"description textbox is not displayed or locator changed");		

		logger.log(LogStatus.INFO, "Verifying if report type label is displayed");
		softassert.assertTrue(report_type_label.isDisplayed(),"report type label is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "Verifying if options displayed in report type listbox");

		for(int i=0;i<report_type_listbox.size();i++){
			
			for(int j=0;j<expected_report_type_listbox_options.length;j++){
				if(report_type_listbox.get(i).getText().equals(expected_report_type_listbox_options[j])){
					logger.log(LogStatus.INFO, "verifying if "+expected_report_type_listbox_options[j]+"is present");
					softassert.assertTrue(report_type_listbox.get(i).getText().equals(expected_report_type_listbox_options[j]),expected_report_type_listbox_options[j]+"is not present");
				}
			}
			
		}
		
		logger.log(LogStatus.INFO, "Verifying if date range label is displayed");
		softassert.assertTrue(date_range_label.isDisplayed(),"Date range label is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "Verifying secondary grouping label is displayed");
		softassert.assertTrue(secondary_grouping_label.isDisplayed(),"secondary grouping label is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "Verifying if basic search textbox is displayed");
		softassert.assertTrue(basic_search_textbox.isDisplayed(),"Basic search textbox is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "Verifying if basic search -search button is displayed");
		softassert.assertTrue(basic_search_button.isDisplayed(),"Basic search-search button is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "Verifying if basic search -clear button is displayed");
		softassert.assertTrue(basic_search_clear_button.isDisplayed(),"Basic search-clear button is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "Verifying if save and preview button is displayed");
		softassert.assertTrue(save_preview_button.isDisplayed(),"save and preview button is not displayed or locator changed");		
		
		logger.log(LogStatus.INFO, "Verifying if save button is displayed");
		softassert.assertTrue(save_button.isDisplayed(),"save button is not displayed or locator changed");		

		logger.log(LogStatus.INFO, "Verifying if advance filter button is displayed");
		softassert.assertTrue(advance_filter_button.isDisplayed(),"advance filter button is not displayed or locator changed");	
		
		softassert.assertAll();
	}
	
}
