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

public class CallDetailsReport_Page extends TestBase{

	
    SoftAssert softassert=new SoftAssert();

	String org_unit_id = "70045";
	
	
    @FindBy(xpath="//h1[contains(text(),'Call Details')]")
	private static WebElement callDetails_header;
	
    @FindBy(xpath="//div[contains(text(),'Loading Data...')]")
	private static WebElement loading_data_label;
    
	//date range
    @FindBy(xpath="//button[@class='btn btn-lg btn-default ng-isolate-scope']")
	private static WebElement dateRange_filter;

    @FindBy(xpath="//div[@class='ranges']//ul//li")
	private static List<WebElement> actual_dateRange_filter_elements;    

    @FindBy(xpath="//div[6]//button[1][text()='OK']")
	private static WebElement ok_button_dateRange_filter;

    @FindBy(xpath="//div[6]//button[2][text()='Cancel']")
	private static WebElement cancel_button_dateRange_filter;
    
    String[] expected_dateRange_filter_elements={"Today","Yesterday","Last 7 Days","Last 30 Days","This Month","Last Month","Custom Range"};
    
	@FindBy(xpath="//a[@class='btn btn-sm btn-default'][text()='Schedule Report']")
	private static WebElement scheduleReport_button;
	
	@FindBy(xpath="//button[@class='btn btn-sm btn-default btn-last dropdown-toggle']")
	private static WebElement export_button;

	@FindBy(xpath="//div[@class='col-md-3 col-lg-2 mb10 noDataSelector ng-binding'][contains(text(),'Showing')]")
	private static WebElement showing_label;

	@FindBy(xpath="//input[@id='simpleChart']")
	private static WebElement basic_search_textbox;
	
	@FindBy(xpath="//input[@id='simpleChart']//parent::div//button[1]")
	private static WebElement basic_search_button;
	
	@FindBy(xpath="//input[@id='simpleChart']//parent::div//button[2]")
	private static WebElement basic_search_cancel_button;

	@FindBy(xpath="//button[@class='btn btn-default btn-block btn-adv'][text()='Advanced Filter']")
	private static WebElement advanced_filter_button;	
	
	@FindBy(xpath="//button[@class='btn btn-block btn-default pulse dropdown-toggle']")
	private static WebElement column_Picker_button;

	@FindBy(xpath="//table[@id='calldetailstable']//thead//tr//th")
	private static List<WebElement> actual_column_names;

	String[] expected_column_names={"Date/Time","Group Name","Campaign","Ad Source","Caller ID","Tracking Number","Destination Name | No.","Duration","Disposition","Line Type","Agent","Actions"};

	@FindBy(xpath="(//table[@id='calldetailstable']//tbody//tr[1]//td//button)[1]")
	private static WebElement play_call_button;	
	
	@FindBy(xpath="(//table[@id='calldetailstable']//tbody//tr[1]//td//button)[2]")
	private static WebElement information_button;		

	@FindBy(xpath="(//table[@id='calldetailstable']//tbody//tr[1]//td//button)[3]")
	private static WebElement blockcall_button;		

	@FindBy(xpath="(//table[@id='calldetailstable']//tbody//tr[1]//td//button)[4]")
	private static WebElement downloadcall_button;		

	@FindBy(xpath="(//table[@id='calldetailstable']//tbody//tr[1]//td//button)[5]")
	private static WebElement email_button;		
	
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

	@FindBy(xpath="//table[@id='calldetailstable']//tbody//tr")
	private static List<WebElement> table_call_count;	

	@FindBy(xpath="//div[@class='advancedf']//select[1]")
	private static WebElement include_exclude_listbox;
	
	@FindBy(xpath="//div[@class='advancedf']//select[1]")
	private static WebElement advance_filter_elements_listbox;

	@FindBy(xpath="//button[@class='btn btn-gray']")
	private static WebElement add_advance_filter_button;

	@FindBy(xpath="//button[@class='btn btn-primary'][contains(text(),'Apply')]")
	private static WebElement apply_button;

	@FindBy(xpath="//button[@class='btn btn-default'][contains(text(),'Cancel')]")
	private static WebElement cancel_button;
	
	@FindBy(xpath="//ul[@id='columnpicker']//li//label")
	private static List<WebElement> all_actual_column_picker_options_labels;

	@FindBy(xpath="//ul[@id='columnpicker']//li//input")
	private static List<WebElement> column_picker_options_checkboxes;

	String[] expected_all_column_picker_options={"Date/Time","Group Name","Campaign","Ad Source","Caller ID","Tracking Number","Destination Name | No.","Duration","Disposition","Line Type","Agent","Actions"};
	
	String[] expected_default_checked_column_picker_options={"Date/Time","Group Name","Campaign","Ad Source","Caller ID","Tracking Number","Destination Name | No.","Duration","Disposition","Line Type","Agent","Actions"};
	
	public CallDetailsReport_Page(WebDriver driver){
	  PageFactory.initElements(driver, this);
    }
	
	static CallDetailsReport_Page cd;
	static int counter=0;
	
	public static CallDetailsReport_Page instance(){
		if(counter==0){
		cd=new CallDetailsReport_Page(driver);
		counter++;
		}
		return cd;
		
	}
	
	public void UIVerification() throws InterruptedException{
		
		wait.until(ExpectedConditions.visibilityOf(callDetails_header));
		logger.log(LogStatus.INFO, "verifying if callDetails_header is displayed");
		softassert.assertTrue(callDetails_header.isDisplayed(),"callDetails_header is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "Verifying if dateRange_filter is displayed");
		softassert.assertTrue(dateRange_filter.isDisplayed(),"dateRange_filter is not displayed or locator changed");
		
		Util.click(dateRange_filter);
		logger.log(LogStatus.INFO, "verifying if daterange filter elements are present");
		
		for(int i=0;i<actual_dateRange_filter_elements.size();i++){
			
			for(int j=0;j<expected_dateRange_filter_elements.length;j++){
				if(actual_dateRange_filter_elements.get(i).getText().equals(expected_dateRange_filter_elements[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_dateRange_filter_elements[j]+" is present");
					softassert.assertTrue(actual_dateRange_filter_elements.get(i).getText().equals(expected_dateRange_filter_elements[j]),"filter element "+expected_dateRange_filter_elements[j]+" is not present or locator changed");
					break;
				}
			}
		}


		Util.click(dateRange_filter);
		Thread.sleep(2000);
		
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
		

		logger.log(LogStatus.INFO, "verifying column names in call detail table");
		
		for(int i=0;i<actual_column_names.size();i++){
			
			for(int j=0;j<expected_column_names.length;j++){
				if(actual_column_names.get(i).getText().equals(expected_column_names[j])){
					logger.log(LogStatus.INFO, "verifying if "+expected_column_names[j]+" is displayed");
					softassert.assertTrue(actual_column_names.get(i).getText().equals(expected_column_names[j]),"column "+expected_column_names[j]+" is not present");
					break;
				}
			}
		}

		
		logger.log(LogStatus.INFO, "verifying play_call_button is present");
		softassert.assertTrue(play_call_button.isDisplayed(),"play_call_button is not displayed or locator changed");
        
		logger.log(LogStatus.INFO, "verifying if information_button is displayed");
		softassert.assertTrue(information_button.isDisplayed(),"information_button is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "verifying blockcall_button is displayed");
		softassert.assertTrue(blockcall_button.isDisplayed(),"blockcall_button is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "verifying if downloadcall_button is displayed");
		softassert.assertTrue(downloadcall_button.isDisplayed(),"downloadcall_button is not displayedd or locator changed");
		
		logger.log(LogStatus.INFO, "verifying if email_button is displayed");
		softassert.assertTrue(email_button.isDisplayed(),"email_button is not displayed or locator changed");
			
	}
	
	public void pagination(){

		//verifying if all buttons are displayed in pagination toolbox 
		logger.log(LogStatus.INFO, "verifying presence of buttons in pagination toolbox");
		wait.until(ExpectedConditions.visibilityOf(first_button));
        logger.log(LogStatus.INFO, "verifying if next_100_button is present"); 
		softassert.assertTrue(next_100_button.isDisplayed(),"next 100 button is not present or locator changed");
        logger.log(LogStatus.INFO, "verifying if prev_100_button is present");
		softassert.assertTrue(prev_100_button.isDisplayed(),"prev 100 button is not present or locator changed");	
		logger.log(LogStatus.INFO, "verifying if prev_100_button is present");
		softassert.assertTrue(first_button.isDisplayed(),"first button is not present or locator changed");	
		logger.log(LogStatus.INFO, "verifying if last_button is present");
		softassert.assertTrue(last_button.isDisplayed(),"last button is not present or locator changed");	
		

		//verification of count in pagination toolbox	
		String endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
		String startDateToBeUsed = Util.getDate("yyyy-MM-dd","-7");

		String dbCount = Util.readingFromDB("SELECT count(*) as count  FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+org_unit_id+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");

		String countOnUI_pagination = pagination_call_count_label.getText().substring(pagination_call_count_label.getText().indexOf('f')+2);
		System.out.println("dbCount is "+dbCount);
		System.out.println("countOnUI_pagination is "+countOnUI_pagination);
		System.out.println("table_call_count is "+table_call_count.size());
		logger.log(LogStatus.INFO, "verifying count in  pagination toolbox");
		softassert.assertEquals(dbCount, countOnUI_pagination,"count in top pagination toolbox is mimatching with db count");
		
		logger.log(LogStatus.INFO, "verifying count of listed calls");
		softassert.assertEquals(dbCount, String.valueOf(table_call_count.size()),"count  of listed campaigns is mimatching with db count");
	}
	

	
	
}
