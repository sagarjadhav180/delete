package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import pom.GroupActivityReportsPage;
import tests.TestBase;
import tests.Util;

public class GroupActivityReportsPage extends TestBase {

	@FindBy(xpath="//div[@class='pageProgressLoader']")
	private static WebElement loading_wheel;
	
    @FindBy(xpath="//h1[contains(text(),'Group Activity')]")
	private static WebElement groupactivity_report_header;
    
    //tiles
    @FindBy(xpath="//div[@id='summaryWidgets']//div[@class='col-xs-6 col-sm-4 col-md-4 chartizzle ng-scope col-lg-2']//tile-heading")
	private static List<WebElement> tiles_heading;
    String[] expected_tiles_heading={"Total Calls (GMT)","Billable Minutes (GMT)","Total Leads","Conversions","Total Call Value","Unique Calls"};
    
    @FindBy(xpath="//div[@id='summaryWidgets']//div[@class='col-xs-6 col-sm-4 col-md-4 chartizzle ng-scope col-lg-2']//div[@class='tiles-body']//span[@id='colorMap']")
	private static List<WebElement> dashboard_tiles_values;
    
    //date range
    @FindBy(xpath="//button[@class='btn btn-lg btn-default ng-isolate-scope']")
	private static WebElement dateRange_filter;

    @FindBy(xpath="//div[@class='ranges']//ul//li")
	private static List<WebElement> actual_dateRange_filter_elements;   

    @FindBy(xpath="//div[@class='ranges']//button[text()='OK']")
	private static WebElement ok_button_dateRange_filter;

    @FindBy(xpath="//div[@class='ranges']//button[text()='Cancel']")
	private static WebElement cancel_button_dateRange_filter;

    String[] expected_dateRange_filter_elements={"Today","Yesterday","Last 7 Days","Last 30 Days","This Month","Last Month","Custom Range"};

	@FindBy(xpath="//a[@class='btn btn-sm btn-default'][text()='Schedule Report']")
	private static WebElement scheduleReport_button;

	@FindBy(xpath="//button[@class='btn btn-sm btn-default btn-last dropdown-toggle']")
	private static WebElement export_button;

	//basic search
	@FindBy(xpath="//input[@id='simpleChart']")
	private static WebElement basic_search_textbox;
	
	@FindBy(xpath="//input[@id='simpleChart']//parent::div//button[1]")
	private static WebElement basic_search_button;

	@FindBy(xpath="//input[@id='simpleChart']//parent::div//button[2]")
	private static WebElement basic_search_cancel_button;

	@FindBy(xpath="//i[@class='fa fa-columns']")
	private static WebElement column_Picker_button;

	@FindBy(xpath="//table[@id='groupActivityReportDataGrid']//thead//tr[1]//th")
	private static List<WebElement> actual_column_names;
    String[] expected_column_names={" ID"," Group"," Ext ID"," Calls (GMT)"," Billable Minutes (GMT)"," Leads"," Conversions"," Call Value"," Unique"," Voicemail"," Answered"};

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
	
	//advance filter
	@FindBy(xpath="//button[@class='btn btn-default btn-block btn-adv'][text()='Advanced Filter']")
	private static WebElement advanced_filter_button;
  	
	@FindBy(xpath="//div[@class='advancedf']//select[1]")
	private static WebElement include_exclude_listbox;
	String[] expected_include_exclude_listbox={"Include","Exclude"};

	@FindBy(xpath="//div[@class='advancedf']//select[2]")
	private static WebElement advance_filter_elements_listbox;
	String[] expected_advance_filter_elements={"Group ID","Group Name","Group Ext ID","Calls (GMT)","Billable Minutes (GMT)","Leads","Conversions","Call Value","Unique","Answered"};

	@FindBy(xpath="//button[@class='btn btn-gray']")
	private static WebElement add_advance_filter_button;
	
	@FindBy(xpath="//div[@class='advancedf']//select[3]//following-sibling::input[1]")
	private static WebElement advance_filter_textbox_for_groupname_and_groupextid;
	
	@FindBy(xpath="//div[@class='advancedf']//select[3]//following-sibling::input[2]")
	private static WebElement advance_filter_textbox_for_rest;	

	@FindBy(xpath="//button[@class='btn btn-primary'][contains(text(),'Apply')]")
	private static WebElement apply_button;
	
	@FindBy(xpath="//button[@class='btn btn-default'][contains(text(),'Cancel')]")
	private static WebElement cancel_button;
	
	@FindBy(xpath="//ul[@id='columnpicker']//li//label")
	private static List<WebElement> all_actual_column_picker_options_labels;
	
	@FindBy(xpath="//ul[@id='columnpicker']//li//input")
	private static List<WebElement> column_picker_options_checkboxes;
	
	String[] expected_all_column_picker_options={"ID","Group","Ext ID","Campaign","Campaign Ext ID","Tracking Number","Calls (GMT)","Billable Minutes (GMT)","Leads","Conversions","Call Value","Unique","Voicemail","Answered"};
	
	String[] expected_default_checked_column_picker_options={"ID","Group","Ext ID","Calls (GMT)","Billable Minutes (GMT)","Leads","Conversions","Call Value","Unique","Voicemail","Answered"};
	
	private GroupActivityReportsPage(WebDriver driver){
	   PageFactory.initElements(driver, this);
	}
	
	static GroupActivityReportsPage ga;
	static int counter=0;
	
	public static GroupActivityReportsPage instance(){
		if(counter==0){
		ga=new GroupActivityReportsPage(driver);
		counter++;
		}
		return ga;
		
	}
	
	public void UIVerification() throws InterruptedException{
	    SoftAssert softassert=new SoftAssert();		
		wait.until(ExpectedConditions.visibilityOf(groupactivity_report_header));
		logger.log(LogStatus.INFO, "verifying if callDetails_header is displayed");
		softassert.assertTrue(groupactivity_report_header.isDisplayed(),"callDetails_header is not displayed or locator changed");
		
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


		Util.click(cancel_button_dateRange_filter);
		Thread.sleep(2000);
		
		logger.log(LogStatus.INFO, "verifying if scheduleReport_button is displayed");
		softassert.assertTrue(scheduleReport_button.isDisplayed(),"scheduleReport_button is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "verifying if export_button is displayed");
		softassert.assertTrue(export_button.isDisplayed(),"export_button is not displayed or locator changed");
	
	
		
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
		
		//tiles
		for(int i=0;i<tiles_heading.size();i++){
			for(int j=0;j<expected_tiles_heading.length;j++){
				if(tiles_heading.get(i).getText().equals(expected_tiles_heading[j])){
					logger.log(LogStatus.INFO, "Verifying if "+expected_tiles_heading[j]+" tile is present");
					softassert.assertTrue(tiles_heading.get(i).getText().equals(expected_tiles_heading[j]),expected_tiles_heading[j]+" tile is not present");
					break;
				}
			}
		}
		
		
		softassert.assertAll();	
	}  
	
	public void tileCountVerification(){
		
		SoftAssert softassert=new SoftAssert();
		String endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
		String startDateToBeUsed = Util.getDate("yyyy-MM-dd","-8");
		
		for(int i=0;i<dashboard_tiles_values.size();i++){
			
			if((!(dashboard_tiles_values.get(i).getText().endsWith("Value")))|| (!(dashboard_tiles_values.get(i).getText().startsWith("Billable")))){
				
				if(dashboard_tiles_values.get(i).getText().startsWith("Total Calls")){
					String total_call_count_from_ui = dashboard_tiles_values.get(i).getText();
					String total_call_count_from_db = Util.readingFromDB("SELECT count(*) as count FROM call WHERE org_unit_id="+org_unit_id+" AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
					System.out.println("SELECT count(*) as count FROM call WHERE org_unit_id='"+org_unit_id+"' AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
					System.out.println("total_count_from_ui is "+total_call_count_from_ui);
					System.out.println("total_count_from_db "+total_call_count_from_db);
					logger.log(LogStatus.INFO, "verifying total calls count..");
					softassert.assertTrue(total_call_count_from_ui.equals(total_call_count_from_db),"total_call_count_from_ui is not matching with db");

				}
				else if(dashboard_tiles_values.get(i).getText().endsWith("Leads")){
					String total_leads__from_ui = dashboard_tiles_values.get(i).getText();
					String total_leads_from_db = Util.readingFromDB("SELECT count(*) as count FROM indicator_score WHERE call_id IN (SELECT call_id FROM call WHERE org_unit_id='"+org_unit_id+"' AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59') AND indicator_id='51'");
					System.out.println("total_leads__from_ui is "+total_leads__from_ui);
					System.out.println("total_leads_from_db "+total_leads_from_db);
					logger.log(LogStatus.INFO, "verifying total leads..");
					if(total_leads_from_db=="null" || total_leads_from_db=="0"){
					softassert.assertTrue("0".equals(total_leads__from_ui),"total_leads__from_ui is not matching with db");
					}
					else{
					softassert.assertTrue(total_leads_from_db.equals(total_leads__from_ui),"total_leads__from_ui is not matching with db");				
					}
				}
				else if(dashboard_tiles_values.get(i).getText().startsWith("Conversions")){
					String total_conversion__from_ui = dashboard_tiles_values.get(i).getText();
					String total_conversion_from_db = Util.readingFromDB("SELECT score_value as count FROM indicator_score WHERE call_id IN (SELECT call_id FROM call WHERE org_unit_id='"+org_unit_id+"' AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'') AND indicator_id='18'");
					System.out.println("total_conversion__from_ui is "+total_conversion__from_ui);
					System.out.println("total_conversion_from_db "+total_conversion_from_db);
					logger.log(LogStatus.INFO, "verifying total conversion..");
					if(total_conversion_from_db=="null" || total_conversion_from_db.equals("0")){
						softassert.assertTrue(total_conversion__from_ui.equals("0"),"total_conversion__from_ui is not matching with db");	
					}
					else{
						softassert.assertTrue(total_conversion__from_ui.equals(total_conversion_from_db),"total_conversion__from_ui is not matching with db");
					}
					
				}
				else if(dashboard_tiles_values.get(i).getText().startsWith("Unique")){
					String unique_calls_count_from_ui = dashboard_tiles_values.get(1).getText();
					String unique_calls_count_from_db = Util.readingFromDB("SELECT count(*) as count FROM call WHERE org_unit_id="+org_unit_id+" AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59' AND repeat_call='false'");
					System.out.println("unique_calls_count_from_ui is "+unique_calls_count_from_ui);
					System.out.println("unique_calls_count_from_db "+unique_calls_count_from_db);
					logger.log(LogStatus.INFO, "verifying unique calls count..");
					if(!(unique_calls_count_from_db.equals("null") || unique_calls_count_from_db.equals("0"))){
					  softassert.assertTrue(unique_calls_count_from_db.equals(unique_calls_count_from_db),"unique_calls_count_from_ui is not matching with db");						
					}
					else{
						  softassert.assertTrue(unique_calls_count_from_db.equals("0"),"unique_calls_count_from_ui is not matching with db");												
					}

				}
				
				
			}
		}
	}
	
	public void paginationUI(){
		
	}
	
    public void paginationCount(){
		
	}
    
    public void tableCount(){
		
	}


}
