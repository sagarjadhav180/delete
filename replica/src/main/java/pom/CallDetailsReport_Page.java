package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    @FindBy(xpath="//button[2][text()='Cancel']")
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
	
	@FindBy(xpath="//i[@class='fa fa-columns']")
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
	String[] expected_include_exclude_listbox={"Include","Exclude"};
	
	@FindBy(xpath="//div[@class='advancedf']//select[2]")
	private static WebElement advance_filter_elements_listbox;
	String[] expected_advance_filter_elements={"Call ID","Date","Group Name","Campaign Name","Ad Source","Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5","Caller ID","Tracking Number","Destination Name","Destination Number","Duration","Route Name","Tag","Caller/Company Name","Address","City","State/Province","Zip/Postal Code","Disposition","Line Type","Sent to Voicemail","Hunt Type","Tracking Number Type"};

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

	String[] expected_all_column_picker_options={"Date/Time","Group Name","Campaign","Ad Source","Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5","Caller ID","Tracking Number","Hunt Type","Number Type","Destination Name | No.","Duration","Caller Name","Company Name","Address","City","State/Province","Disposition","Line Type","Sent to Voicemail","Agent","Actions"};
	
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


		Util.click(cancel_button_dateRange_filter);
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
		softassert.assertAll();	
	}  

	public void paginationButtons(){

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
		softassert.assertAll();

	}
	
	public void paginationCallCount(){
		//verification of count in pagination toolbox	
	    String endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
		String startDateToBeUsed = Util.getDate("yyyy-MM-dd","-7");

		String dbCount = Util.readingFromDB("SELECT count(*) as count  FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+org_unit_id+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");

		String countOnUI_pagination = pagination_call_count_label.getText().substring(pagination_call_count_label.getText().indexOf('f')+2);
		System.out.println("dbCount is "+dbCount);
		System.out.println("countOnUI_pagination is "+countOnUI_pagination);

		logger.log(LogStatus.INFO, "verifying count in  pagination toolbox");
		softassert.assertEquals(dbCount, countOnUI_pagination,"count in top pagination toolbox is mimatching with db count");
		softassert.assertAll();		

	}
	
	public void tableCallCount(){
		//verification of count in pagination toolbox	
	    String endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
		String startDateToBeUsed = Util.getDate("yyyy-MM-dd","-7");

		String dbCount = Util.readingFromDB("SELECT count(*) as count  FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+org_unit_id+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");

		System.out.println("dbCount is "+dbCount);
		System.out.println("table_call_count is "+table_call_count.size());
				
		logger.log(LogStatus.INFO, "verifying count of listed calls");
		softassert.assertEquals(dbCount, String.valueOf(table_call_count.size()),"count  of listed campaigns is mimatching with db count");
		softassert.assertAll();
	}
	
	public void allColumnPickerOptions(){
		Util.click(column_Picker_button);
		
		for(int i=0;i<all_actual_column_picker_options_labels.size();i++){
			for(int j=0;j<expected_all_column_picker_options.length;j++){
				
				if(all_actual_column_picker_options_labels.get(i).getText().equals(expected_all_column_picker_options[j])){
					logger.log(LogStatus.INFO, "Verifying if "+expected_all_column_picker_options[j]+" is present ");
					softassert.assertTrue(all_actual_column_picker_options_labels.get(i).getText().equals(expected_all_column_picker_options[j]),"column picker option "+expected_all_column_picker_options[j]+" is not displayed or locator changed");
				}
			}
		}
		softassert.assertAll();
		Util.click(column_Picker_button);
	}
	
	public void defaultColumns(){
	
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
		softassert.assertAll();
	}
	
	public void allColumns(){
		
        logger.log(LogStatus.INFO, "verifying column names in call detail table");
		
		for(int i=0;i<actual_column_names.size();i++){
			
			for(int j=0;j<expected_all_column_picker_options.length;j++){

	
				if(actual_column_names.get(i).getText().equals(expected_all_column_picker_options[j])){
					
					logger.log(LogStatus.INFO, "verifying if "+expected_all_column_picker_options[j]+" is displayed");
					softassert.assertTrue(actual_column_names.get(i).getText().equals(expected_all_column_picker_options[j]),"column "+expected_all_column_picker_options+" is not present");
					break;					
				}

			}
		}
		softassert.assertAll();
	}
	
	
	
	public void allColumnPickerCheckboxes(){
		
		Util.click(column_Picker_button);
		for(int i=0;i<column_picker_options_checkboxes.size();i++){
			
			logger.log(LogStatus.INFO, "verifying if "+column_picker_options_checkboxes.get(i).getText()+" is enabled");
			softassert.assertTrue(column_picker_options_checkboxes.get(i).isEnabled(),column_picker_options_checkboxes.get(i) +" is not enabled");
			
		}
		softassert.assertAll();
		Util.click(column_Picker_button);
	}
	
	public void checkAllColumnPickerOptions(){
		
		Util.click(column_Picker_button);
		for(int i=0;i<column_picker_options_checkboxes.size();i++){
			
			if(!(column_picker_options_checkboxes.get(i).isSelected())){
				Util.click(column_picker_options_checkboxes.get(i));
			}
		}
		Util.click(column_Picker_button);
	}
	
	public void advancedFilter(){
		
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
		
		logger.log(LogStatus.INFO, "Verifying if add advanced filter button is present");
		softassert.assertTrue(add_advance_filter_button.isDisplayed(),"add advanced filter button is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "Verifying if ok button is displayed");
		softassert.assertTrue(apply_button.isDisplayed(),"apply button is not displayed or locator chaanged");

		logger.log(LogStatus.INFO, "Verifying if cancel button is displayed");
		softassert.assertTrue(cancel_button.isDisplayed(),"cancel button is not displayed or locator chaanged");
		Util.click(advanced_filter_button);

		softassert.assertAll();
	}
	
}
