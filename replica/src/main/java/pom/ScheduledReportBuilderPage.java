package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import tests.TestBase;
import tests.Util;

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
	
	@FindBy(xpath="//label[@id='report-label']//parent::div//following-sibling::div//span[@class='select2-arrow']")
	private WebElement report_type_button;
	
	@FindBy(xpath="//ul[@class='select2-result-sub']//li")
	private List<WebElement> report_type_listbox;	
	String[] expected_report_type_listbox_options={"Call Details","Group Activity","Tracking Number Settings"};

	@FindBy(xpath="//span[contains(text(),'-- Disabled --')]")
	private WebElement default_option_report_type;
	
	@FindBy(xpath="//div[@class='select2-container ng-pristine ng-untouched ng-valid']//b")
	private WebElement secondary_grouping_button;

	@FindBy(xpath="//span[contains(text(),'None')]")
	private WebElement default_secondary_grouping_option_for_group_activity_report;
	
	@FindBy(xpath="//ul[@class='select2-result-sub']//li//span")
	private List<WebElement> secondary_grouping_listbox;		
	String[] expected_secondary_grouping_listbox_options={"None","Tracking Number","Campaign"};

	@FindBy(xpath="//span[contains(text(),'-- Disabled --')]")
	private WebElement secondary_grouping_disabled;
	
	@FindBy(xpath="(//i[@class='fa fa-calendar'])[1]")
	private WebElement date_range_calender_button;			
	
	@FindBy(xpath="(//div[@class='ranges']//ul)[3]//li")
	private List<WebElement> date_range_calender_options;
    String[] expected_dateRange_filter_elements={"Today","Yesterday","Last 7 Days","Last 30 Days","This Month","Last Month","Custom Range"};
	
	@FindBy(xpath="//div[5]//div[3]//button[1][text()='OK']")
	private WebElement date_range_calender_ok_button;		
	
	@FindBy(xpath="//div[5]//button[2][text()='Cancel']")
	private WebElement date_range_calender_cancel_button;			
	
	@FindBy(xpath="//button[@class='btn btn-default btn-block btn-adv'][text()='Advanced filter']")
	private WebElement advance_filter_button;			
	
	@FindBy(xpath="//button[@class='pull-left btn btn-primary-alt btn-sm'][text()='Save & Preview']")
	private WebElement save_preview_button;				
	
	@FindBy(xpath="//input[@class='btn btn-primary btn-sm mr5 pull-right']")
	private WebElement scheduled_report_save_button;

	@FindBy(xpath="//div[@class='ui-pnotify-text'][text()='Report successfully updated and saved.']")
	private WebElement scheduled_report_update_success_message;

	@FindBy(xpath="//div[@class='ui-pnotify-text'][text()='Report successfully created and saved.']")
	private WebElement scheduled_report_save_success_message;
	
	@FindBy(xpath="//span[@class='glyphicon glyphicon-pause']")
	private WebElement scheduled_report_save_success_message_pause_button;

	@FindBy(xpath="//span[@class='glyphicon glyphicon-remove']")
	private WebElement scheduled_report_save_success_message_close_button;

	@FindBy(xpath="//div[@class='ui-pnotify-text'][text()='Scheduled report saved Successfully.']")
	private WebElement new_scheduled_report_save_success_message;
	
	//advance filter
	@FindBy(xpath="//button[@class='btn btn-default btn-block btn-adv'][text()='Advanced filter']")
	private static WebElement advanced_filter_button;
	
	@FindBy(xpath="//div[@class='advancedf']//select[1]")
	private static WebElement include_exclude_listbox;
	String[] expected_include_exclude_listbox={"Include","Exclude"};
		
	@FindBy(xpath="//div[@class='advancedf']//select[2]")
	private static WebElement advance_filter_elements_listbox;
	
	String[] call_details_expected_advance_filter_elements={"Call ID","Date","Group Name","Campaign Name","Ad Source","Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5","Caller ID","Tracking Number","Destination Name","Destination Number","Duration","Route Name","Tag","Caller/Company Name","Address","City","State/Province","Zip/Postal Code","Disposition","Line Type","Sent to Voicemail","Hunt Type","Tracking Number Type"};
	String[] group_activity_expected_advance_filter_elements={"Group ID","Group Name","Group Ext ID","Calls (GMT)","Billable Minutes (GMT)","Leads","Conversions","Call Value","Unique","Answered"};
	String[] tracking_number_settings_expected_advance_filter_elements={"Tracking Number ID","Tracking Number Name","Tracking Number","Tracking Number Type","Ring to phone number","Ad Source","Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5","Tracking Number Status","Group name","Campaign Name","DNI Type","Host Domain","Referring Website","Html Class","Custom Parameters","Play Disclaimer","Voice Prompt","Whisper Message","Record Call","Pre-call webhook","Hunt Type","Voicemail"};	
	
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
	String[] expected_frequency_listbox_options={"Daily","Weekly","Monthly"};
	
	@FindBy(xpath="//a[@class='btn btn-default'][text()=' Create New']")
	private static WebElement create_new_distribution_list_button;	
	
	@FindBy(xpath="//div[@class='col-md-2'][text()='Distribution List Name']")
	private static WebElement distribution_list_name_label;		

	@FindBy(xpath="//div[@class='col-md-2'][text()='Distribution List Name']//parent::div//following-sibling::div//input")
	private static WebElement distribution_list_name_textbox;			
	
	@FindBy(xpath="//div[@class='col-md-2'][text()='Distribution List Name']//parent::div//following-sibling::div[@class='col-md-4']//button[text()='Save']")
	private static WebElement create_new_distribution_list_save_button;				
	
	@FindBy(xpath="//div[@class='col-md-2'][text()='Distribution List Name']//parent::div//following-sibling::div[@class='col-md-4']//button[text()='Save & Select']")
	private static WebElement create_new_distribution_list_save_select_button;				
	
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
	private static List<WebElement> attachment_listbox;
	String[] expected_attachment_listbox_options={"CSV","HTML"};
	
	@FindBy(xpath="//input[@class='btn btn-primary btn-sm']")
	private static WebElement save_new_distribution_list_button;
	
	@FindBy(xpath="//input[@class='btn btn-default btn-sm']")
	private static WebElement cancel_new_distribution_list_button;	
	
	SoftAssert softassert=new SoftAssert();
	
	public ScheduledReportBuilderPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	static int counter=0;
	public static ScheduledReportBuilderPage intanceScheduleBuilder(){
		
		ScheduledReportBuilderPage sp = null;
		if(counter==0){
			sp=new ScheduledReportBuilderPage(driver);
			return sp;
		}
		else{
		return sp;
		}
	}
	
	
	public void scheduledReportBuilderPageLabel(){
		
		logger.log(LogStatus.INFO, "Verifying header label is displayed");
		softassert.assertTrue(scheduled_report_builder_label.isDisplayed(),"header label is not displayed or locator changed");
	}
	
    public void listButton(){
		
    	logger.log(LogStatus.INFO, "Verifying if List button is displayed");
		softassert.assertTrue(list_button.isDisplayed(),"List Button is not displayed or locator changed");

    	logger.log(LogStatus.INFO, "Verifying if List button is clickable");
		softassert.assertTrue(list_button.isEnabled(),"List Button is not clickable");
	}
	
	public void reportsDetailUIVerification(){
		
		
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
		softassert.assertTrue(scheduled_report_save_button.isDisplayed(),"save button is not displayed or locator changed");		

		logger.log(LogStatus.INFO, "Verifying if advance filter button is displayed");
		softassert.assertTrue(advance_filter_button.isDisplayed(),"advance filter button is not displayed or locator changed");	
		
		softassert.assertAll();
	}
	
	public void defaultReport(){
		
		logger.log(LogStatus.INFO, "Verifying if no report is selected by default");
		softassert.assertTrue(default_option_report_type.isDisplayed(),"by default report type is not selected");
	}
	
	public void secondaryGroupingOptionEnability(String reportType) throws InterruptedException{

		report_type_button.click();
		
		for(int i=0;i<report_type_listbox.size();i++){
			if(report_type_listbox.get(i).getText().equals(reportType)){
				report_type_listbox.get(i).click();
				break;
			}
		}
		
		Thread.sleep(2000);
		if(reportType.equals("Call Details") || reportType.equals("Tracking Number Settings")){
			
			logger.log(LogStatus.INFO, "Verifying if secondary grouping is disabled for report "+reportType);
			softassert.assertTrue(secondary_grouping_disabled.isDisplayed(),"secondary grouping is not disabled for report "+reportType);
		}
		else if(reportType.equals("Group Activity")) {
			logger.log(LogStatus.INFO, "Verifying if secondary grouping is enabled for report "+reportType);
			softassert.assertFalse(secondary_grouping_disabled.isDisplayed(),"secondary grouping is disabled for report "+reportType);			
		}
	}
	
	public void seconadryGroupingOptions(){
		
		logger.log(LogStatus.INFO, "Verifying options pressent in secondary grouping options");
		
		for(int i=0;i<secondary_grouping_listbox.size();i++){
			
			for(int j=0;j<expected_secondary_grouping_listbox_options.length;j++){
				
				if(secondary_grouping_listbox.get(i).getText().equals(expected_secondary_grouping_listbox_options[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_secondary_grouping_listbox_options[j]+" is present");
					softassert.assertTrue(secondary_grouping_listbox.get(i).getText().equals(expected_secondary_grouping_listbox_options[j]),"Secondary grouping option "+expected_secondary_grouping_listbox_options[j]+" is not present");
				}
				
			}
			
		}
		
		softassert.assertAll();
	}
	
	public void dateRangeFilterUI() throws InterruptedException{
		
      logger.log(LogStatus.INFO, "verifying if daterange filter elements are present");
		
		for(int i=0;i<date_range_calender_options.size();i++){
			
			for(int j=0;j<expected_dateRange_filter_elements.length;j++){
				if(date_range_calender_options.get(i).getText().equals(expected_dateRange_filter_elements[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_dateRange_filter_elements[j]+" is present");
					softassert.assertTrue(date_range_calender_options.get(i).getText().equals(expected_dateRange_filter_elements[j]),"filter element "+expected_dateRange_filter_elements[j]+" is not present or locator changed");
					break;
				}
			}
		}


		Util.click(date_range_calender_cancel_button);
		Thread.sleep(2000);
		
	}
	
	public void advanceFilterUI(){
		
        Util.click(advanced_filter_button);
		
		logger.log(LogStatus.INFO, "Verifying if include/exclude listbox displayed");
		softassert.assertTrue(include_exclude_listbox.isDisplayed(),"include/exclude listbox not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "verifying options displayed in include/exclude listbox");
		Select select=new Select(include_exclude_listbox);
		
		for(int i=0;i<select.getOptions().size();i++){
			
			for(int j=0;j<expected_include_exclude_listbox.length;j++){
				if(select.getOptions().get(i).getText().equals(expected_include_exclude_listbox[j])){
					
					logger.log(LogStatus.INFO, "verifying if "+expected_include_exclude_listbox[j]+" is displayed");
					softassert.assertTrue(select.getOptions().get(i).getText().equals(expected_include_exclude_listbox[j]),"element "+expected_include_exclude_listbox[j]+"is not present");
					break;
				}
			}
			
		}
		
		logger.log(LogStatus.INFO, "verifying if filter elements listbox is displayed");
		softassert.assertTrue(advance_filter_elements_listbox.isDisplayed(),"filter element listbox is not displayed or locator changed");
		
				
		logger.log(LogStatus.INFO, "Verifying if add advanced filter button is present");
		softassert.assertTrue(add_advance_filter_button.isDisplayed(),"add advanced filter button is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "Verifying if cancel button is displayed");
		softassert.assertTrue(add_advance_filter_cancel_button.isDisplayed(),"cancel button is not displayed or locator chaanged");
		Util.click(add_advance_filter_cancel_button);

		softassert.assertAll();
	}

	public void advanceFilterOptions(String reportType){
		
        Util.click(advanced_filter_button);
		
        String[] expected_advance_filter_elements=null;
        if(reportType.equals("Call Details")){
        	expected_advance_filter_elements=call_details_expected_advance_filter_elements;
        }
        else if(reportType.equals("Group Activity")){
        	expected_advance_filter_elements=group_activity_expected_advance_filter_elements;
        }
        else if(reportType.equals("Tracking Number Settings")){
        	expected_advance_filter_elements=tracking_number_settings_expected_advance_filter_elements;
        }
        
		Select select1=new Select(advance_filter_elements_listbox);
		
		for(int i=0;i<select1.getOptions().size();i++){
			
			for(int j=0;j<expected_advance_filter_elements.length;j++){
				if(select1.getOptions().get(i).getText().equals(expected_advance_filter_elements[j])){
					System.out.println(expected_advance_filter_elements[j]);
					System.out.println(select1.getOptions().get(i).getText());
					logger.log(LogStatus.INFO, "verifying if "+expected_advance_filter_elements[j]+" is present");
					softassert.assertTrue(select1.getOptions().get(i).getText().equals(expected_advance_filter_elements[j]),"filter element "+expected_advance_filter_elements[j]+" is not present or locator changed");
				}
			}
		}
		
	    Util.click(add_advance_filter_cancel_button);

		softassert.assertAll();
		
		
	}
	
	
	public void createSchedule(String reportType,String reportName) throws InterruptedException{
		
		wait.until(ExpectedConditions.attributeContains(scheduled_report_name_textbox, "tabindex", "0"));
		scheduled_report_name_textbox.sendKeys(reportName);
		description_textbox.sendKeys("test");
		
		report_type_button.click();
		
		for(int i=0;i<report_type_listbox.size();i++){
			if(report_type_listbox.get(i).getText().equals(reportType)){
				report_type_listbox.get(i).click();
				break;
			}
		}
		
		scheduled_report_save_button.click();
		logger.log(LogStatus.INFO, "Verifying if scheduled report is created");
		wait.until(ExpectedConditions.visibilityOf(scheduled_report_save_success_message));
		Assert.assertTrue(scheduled_report_save_success_message.isDisplayed(),"report not created successfully");
		driver.switchTo().activeElement();
		Util.click(scheduled_report_save_success_message_pause_button);
		Util.click(scheduled_report_save_success_message_close_button);
		Util.click(list_button);
		Thread.sleep(2000);
        
	}
	
	public void scheduledDistributionSectionUI() throws InterruptedException{
		
		wait.until(ExpectedConditions.visibilityOf(add_new_scheduled_distribution_button));
		add_new_scheduled_distribution_button.click();
		Thread.sleep(1000);
		
		logger.log(LogStatus.INFO, "Verifying if from label is displayed");
		softassert.assertTrue(from_label.isDisplayed(),"from label is not displayed or locator chaanged");
		
		logger.log(LogStatus.INFO, "Verifying if from textbox is displayed");
		softassert.assertTrue(from_textbox.isDisplayed(),"from textbox is not displayed or locator chaanged");		
		
		logger.log(LogStatus.INFO, "Verifying if choose distribution list label is displayed");
		softassert.assertTrue(choose_distribution_list_label.isDisplayed(),"choose distribution list label is not displayed or locator chaanged");
		
		logger.log(LogStatus.INFO, "Verifying if choose distribution listbox is displayed");
		softassert.assertTrue(choose_distribution_list_listbox.isDisplayed(),"choose distribution listbox is not displayed or locator chaanged");		

		logger.log(LogStatus.INFO, "Verifying if create new button is displayed");
		softassert.assertTrue(create_new_distribution_list_button.isDisplayed(),"create new is not displayed or locator chaanged");		
		
		create_new_distribution_list_button.click();

		logger.log(LogStatus.INFO, "Verifying if distribution list name label is displayed");
		softassert.assertTrue(distribution_list_name_label.isDisplayed(),"distribution list name label is not displayed or locator chaanged");		

		logger.log(LogStatus.INFO, "Verifying if distribution list name textbox is displayed");
		softassert.assertTrue(distribution_list_name_textbox.isDisplayed(),"distribution list name textbox is not displayed or locator chaanged");		

		logger.log(LogStatus.INFO, "Verifying if save button is displayed");
		softassert.assertTrue(create_new_distribution_list_save_button.isDisplayed(),"save button is not displayed or locator chaanged");		
		
		logger.log(LogStatus.INFO, "Verifying if save and select button is displayed");
		softassert.assertTrue(create_new_distribution_list_save_select_button.isDisplayed(),"save and select button is not displayed or locator chaanged");		

		logger.log(LogStatus.INFO, "Verifying if Emails label is displayed");
		softassert.assertTrue(emails_label.isDisplayed(),"Emails label is not displayed or locator chaanged");		
		
		logger.log(LogStatus.INFO, "Verifying if Emails textbox is displayed");
		softassert.assertTrue(emails_textbox.isDisplayed(),"Emails textbox is not displayed or locator chaanged");				
		
		logger.log(LogStatus.INFO, "Verifying if frequency label is displayed");
		softassert.assertTrue(frequency_label.isDisplayed(),"frequency label is not displayed or locator chaanged");				

		logger.log(LogStatus.INFO, "Verifying if frequency listbox is displayed");
		softassert.assertTrue(frequency_listbox.isDisplayed(),"frequency listbox is not displayed or locator chaanged");			
		
		logger.log(LogStatus.INFO, "Verifying if frequency listbox is clickable");
		softassert.assertTrue(frequency_listbox.isEnabled(),"frequency listbox is not clickable");			
		
		logger.log(LogStatus.INFO, "Verifying options displayed in frequency listbox ");
		
		Select select=new Select(frequency_listbox);
		
		for(int i=0;i<select.getOptions().size();i++){
			
			for(int j=0;j>expected_frequency_listbox_options.length;j++){
				
				if(select.getOptions().get(i).getText().equals(expected_frequency_listbox_options[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_frequency_listbox_options[j]+" is present");
					softassert.assertTrue(select.getOptions().get(i).getText().equals(expected_frequency_listbox_options[j]),expected_frequency_listbox_options[j]+" is not present");
				}
			}
			
		}
		logger.log(LogStatus.INFO, "Verifying if message label is displayed");
		softassert.assertTrue(message_label.isDisplayed(),"message label is not displayed");			

		logger.log(LogStatus.INFO, "Verifying if message textbox is displayed");
		softassert.assertTrue(message_textbox.isDisplayed(),"message textbox is not displayed");			
		
		logger.log(LogStatus.INFO, "Verifying if attachment label is displayed");
		softassert.assertTrue(attachment_label.isDisplayed(),"attachment label is not displayed");

		attachment_listbox_button.click();
		logger.log(LogStatus.INFO, "Verifying options displayed in attachment section");

		for(int i=0;i<attachment_listbox.size();i++){
			
			for(int j=0;j<expected_attachment_listbox_options.length;j++){
				
				if(attachment_listbox.get(i).getText().equals(expected_attachment_listbox_options[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_attachment_listbox_options[j]+" is displayed");
					softassert.assertTrue(attachment_listbox.get(i).getText().equals(expected_attachment_listbox_options[j]),expected_attachment_listbox_options[j]+" is not displayed");
					
				}
			}
		}
		
		logger.log(LogStatus.INFO, "Verifying if save button for new distribution list is displayed");
		softassert.assertTrue(save_new_distribution_list_button.isDisplayed(),"save button for new distribution list is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if cancel button for new distribution list is displayed");
		softassert.assertTrue(cancel_new_distribution_list_button.isDisplayed(),"cancel button for new distribution list is not displayed");
		
		softassert.assertAll();
		
	}
	
	
	
	public void createScheduledDistribution(String reportName,String reportType){
		
		wait.until(ExpectedConditions.attributeContains(scheduled_report_name_textbox, "tabindex", "0"));
		scheduled_report_name_textbox.sendKeys(reportName);
		description_textbox.sendKeys("test");
		
		report_type_button.click();
		
		for(int i=0;i<report_type_listbox.size();i++){
			if(report_type_listbox.get(i).getText().equals(reportType)){
				report_type_listbox.get(i).click();
				break;
			}
		}
		
		scheduled_report_save_button.click();
		
		wait.until(ExpectedConditions.attributeContains(add_new_scheduled_distribution_button, "tabindex", "0"));
		add_new_scheduled_distribution_button.click();
		
		from_textbox.sendKeys("test_automation@moentek.com");
		create_new_distribution_list_button.click();
		
		distribution_list_name_textbox.sendKeys("test_automation");
		emails_textbox.sendKeys("sagar.j@moentek.com");
		create_new_distribution_list_save_select_button.click();
		
		Select select=new Select(frequency_listbox);
		
		select.selectByIndex(1);
	
		message_textbox.sendKeys("test");
		attachment_listbox_button.click();
		
		attachment_listbox.get(1).click();
		save_new_distribution_list_button.click();
		
		wait.until(ExpectedConditions.visibilityOf(new_scheduled_report_save_success_message));
		logger.log(LogStatus.INFO, "Verifying if new scheduled report is created");
		Assert.assertTrue(new_scheduled_report_save_success_message.isDisplayed(),"new scheduled report not created");
		
	}
	
	
	
	
}
