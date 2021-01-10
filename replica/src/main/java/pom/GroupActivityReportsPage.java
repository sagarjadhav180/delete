package pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import pom.GroupActivityReportsPage;
import tests.TestBase;
import tests.Util;

public class GroupActivityReportsPage extends TestBase {

	@FindBy(xpath="//div[@class='pageProgressLoader']")
	private static WebElement loading_wheel;
	
    @FindBy(xpath="//label[text()='Secondary Grouping']")
	private static WebElement secondary_grouping_label;
 
    @FindBy(xpath="//div[@id='s2id_autogen1']//span[@class='select2-arrow']")
	private static WebElement secondary_grouping_button;

    String[] expected_secondary_grouping_options={"None","Tracking Number","Campaign"};
    
    @FindBy(xpath="//div[@id='s2id_autogen1']//following-sibling::select")
	private static WebElement secondary_grouping_listbox;
    
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

	@FindBy(xpath="//div[@class='btn-group dropdown']//i[@class='fa fa-columns']")
	private static WebElement column_Picker_button;

	@FindBy(xpath="//table[@id='groupActivityReportDataGrid']//thead//tr[1]//th")
	private static List<WebElement> actual_column_names;
    String[] expected_column_names={"ID","Group","Ext ID","Calls (GMT)","Billable Minutes (GMT)","Leads","Conversions","Call Value","Unique","Voicemail","Answered"};

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
	
	@FindBy(xpath="//table[@id='groupActivityReportDataGrid']//tbody//tr")
	private static List<WebElement> table_call_count;	
	
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
		
		logger.log(LogStatus.INFO, "verifying if groupaactivity_header is displayed");
		softassert.assertTrue(groupactivity_report_header.isDisplayed(),"callDetails_header is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "Verifying if dateRange_filter is displayed");
		softassert.assertTrue(dateRange_filter.isDisplayed(),"dateRange_filter is not displayed or locator changed");
		
//		Util.click(dateRange_filter);
//		logger.log(LogStatus.INFO, "verifying if daterange filter elements are present");
//		
//		for(int i=0;i<actual_dateRange_filter_elements.size();i++){
//			
//			for(int j=0;j<expected_dateRange_filter_elements.length;j++){
//				if(actual_dateRange_filter_elements.get(i).getText().equals(expected_dateRange_filter_elements[j])){
//					
//					logger.log(LogStatus.INFO, "Verifying if "+expected_dateRange_filter_elements[j]+" is present");
//					softassert.assertTrue(actual_dateRange_filter_elements.get(i).getText().equals(expected_dateRange_filter_elements[j]),"filter element "+expected_dateRange_filter_elements[j]+" is not present or locator changed");
//					break;
//				}
//			}
//		}
//
//
//		Util.click(cancel_button_dateRange_filter);
//		Thread.sleep(2000);
		
		logger.log(LogStatus.INFO, "verifying if scheduleReport_button is displayed");
		softassert.assertTrue(scheduleReport_button.isDisplayed(),"scheduleReport_button is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "verifying if export_button is displayed");
		softassert.assertTrue(export_button.isDisplayed(),"export_button is not displayed or locator changed");

		logger.log(LogStatus.INFO, "verifying if secondary grouping label is displayed");
		softassert.assertTrue(secondary_grouping_label.isDisplayed(),"secondary grouping label is not displayed or locator changed");
			
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

				if(tiles_heading.get(i).getText().equalsIgnoreCase(expected_tiles_heading[j])){
					System.out.println(tiles_heading.get(i).getText());
					System.out.println(expected_tiles_heading[j]);
					logger.log(LogStatus.INFO, "Verifying if "+expected_tiles_heading[j]+" tile is present");
					softassert.assertTrue(tiles_heading.get(i).getText().equalsIgnoreCase(expected_tiles_heading[j]),expected_tiles_heading[j]+" tile is not present");
					break;
				}
			}
		}
		
		
		softassert.assertAll();	
	}  

	public void dateRangeFilterSectionUI() throws InterruptedException{
		SoftAssert softassert=new SoftAssert();
		
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
		softassert.assertAll();

	}
	
	public void secondaryGrouping() throws InterruptedException{
		
		SoftAssert softassert=new SoftAssert();
		Util.click(secondary_grouping_button);
		
		Select select=new Select(secondary_grouping_listbox);
		
		List<WebElement> options = select.getOptions();
		
		for(int i=0;i<options.size();i++){
			for(int j=0;j<expected_secondary_grouping_options.length;j++){
				if(options.get(i).getText().equals(expected_secondary_grouping_options[j])){
					logger.log(LogStatus.INFO, "Verifying if "+expected_secondary_grouping_options[j]+" is presnet");
					softassert.assertTrue(options.get(i).getText().equals(expected_secondary_grouping_options[j]),"option "+expected_secondary_grouping_options[j]+" is not presnet");
				}
			}
		}
		
		
		softassert.assertAll();
	}
	
	public void defaultSecondaryOption(String option){
		
		SoftAssert softassert=new SoftAssert();
		Select select=new Select(secondary_grouping_listbox);
		String actual = select.getFirstSelectedOption().getText();
		String expected=option;
		
		logger.log(LogStatus.INFO, "Verifying if by default option selected is None");
		softassert.assertTrue(actual.equalsIgnoreCase(expected),"Default selected option is not "+option);
		softassert.assertAll();
	}
	
	public void secondaryGroupingFeature(List secondaryGroupingOption,String option) throws InterruptedException{
	    SoftAssert softassert=new SoftAssert();
	    
	    Select select=new Select(secondary_grouping_listbox);
	    select.selectByVisibleText(option);
	    Thread.sleep(4000);
		List<Integer> index = new ArrayList<Integer>();
	    
		Util.click(column_Picker_button);
		
	    for(int m=0;m<secondaryGroupingOption.size();){
	    	
	    	for(int j=0;j<all_actual_column_picker_options_labels.size();j++){
	    		
	    		if(secondaryGroupingOption.get(m).equals(all_actual_column_picker_options_labels.get(j).getText())){
					index.add(j);	
	    		}	    			
			}
	    	m++;
		}
	    
		for(int i=0;i<column_picker_options_checkboxes.size();i++){

			for(int k=0;k<index.size();k++){
				if(index.get(k)==i){
					logger.log(LogStatus.INFO, "verifying if secondaryGrouping feature");
					softassert.assertTrue(!(column_picker_options_checkboxes.get(i).isEnabled()),column_picker_options_checkboxes.get(i)+" is enabled");			
				}
			}			
		}
		select.selectByVisibleText("None");
		Thread.sleep(3000);
		softassert.assertAll();
//		Util.click(column_Picker_button);
		Util.Action().sendKeys(Keys.ESCAPE).perform();
	}
	
	public void secondaryGroupingColumn(String groupingOption) throws InterruptedException{
		
		SoftAssert softassert=new SoftAssert();
		
		Select select=new Select(secondary_grouping_listbox);
		
		select.selectByVisibleText(groupingOption);
		
		Thread.sleep(4000);
		
		for(int j=0;j<actual_column_names.size();j++){
			if(actual_column_names.get(j).getText().equals(groupingOption)){
				logger.log(LogStatus.INFO, "Verifying if "+groupingOption+" is displayed");
				softassert.assertTrue(actual_column_names.get(j).isDisplayed(),"column "+groupingOption+" is not displayed");
			}
		}
		
		select.selectByVisibleText("None");
		Thread.sleep(3000);
		softassert.assertAll();
	}
	
	
	
	public void tileCountVerification(){
		
		SoftAssert softassert=new SoftAssert();
		String endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
		String startDateToBeUsed = Util.getDate("yyyy-MM-dd","-7");
		
		for(int i=0;i<tiles_heading.size();i++){
			
			for(int j=i;j<dashboard_tiles_values.size();j++){
				

				
				if((!(tiles_heading.get(i).getText().endsWith("VALUE")))|| (!(dashboard_tiles_values.get(i).getText().startsWith("BILLABLE")))){
					
					if(tiles_heading.get(i).getText().startsWith("TOTAL CALLS")){
						String total_call_count_from_ui = dashboard_tiles_values.get(j).getText();
						String total_call_count_from_db = Util.readingFromDB("SELECT count(*) as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
						System.out.println("SELECT count(*) as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
						System.out.println("total_count_from_ui is "+total_call_count_from_ui);
						System.out.println("total_count_from_db "+total_call_count_from_db);
						logger.log(LogStatus.INFO, "verifying total calls count..");
						if(!((total_call_count_from_db==null)||(total_call_count_from_db.equals("0")))){
							softassert.assertTrue(total_call_count_from_ui.equals(total_call_count_from_db),"total_call_count_from_ui is not matching with db");						
						}
						else{
							softassert.assertTrue(total_call_count_from_ui.equals("0"),"total_call_count_from_ui is not matching with db");												
						}
						break;


					}
					else if(tiles_heading.get(i).getText().endsWith("LEADS")){
						String total_leads__from_ui = dashboard_tiles_values.get(j).getText();
						String total_leads_from_db = Util.readingFromDB("SELECT count(*) as count FROM indicator_score WHERE call_id IN (SELECT call_id FROM call org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59') AND indicator_id='51'");
						System.out.println("total_leads__from_ui is "+total_leads__from_ui);
						System.out.println("total_leads_from_db "+total_leads_from_db);
						logger.log(LogStatus.INFO, "verifying total leads..");
						if(total_leads_from_db==null || total_leads_from_db=="0"){
						softassert.assertTrue("0".equals(total_leads__from_ui),"total_leads__from_ui is not matching with db");
						}
						else{
						softassert.assertTrue(total_leads_from_db.equals(total_leads__from_ui),"total_leads__from_ui is not matching with db");				
						}
						break;
					}
					else if(tiles_heading.get(i).getText().startsWith("CONVERSIONS")){
						String total_conversion_from_ui = dashboard_tiles_values.get(j).getText();
						String total_conversion_from_db = Util.readingFromDB("SELECT score_value as count FROM indicator_score WHERE call_id IN (SELECT call_id FROM call org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59') AND indicator_id='18'");
						System.out.println("total_conversion__from_ui is "+total_conversion_from_ui);
						System.out.println("total_conversion_from_db "+total_conversion_from_db);
						logger.log(LogStatus.INFO, "verifying total conversion..");
						if(total_conversion_from_db==(null) || total_conversion_from_db=="0"){
							softassert.assertTrue(total_conversion_from_ui.equals("0"),"total_conversion__from_ui is not matching with db");	
						}
						else{
							softassert.assertTrue(total_conversion_from_ui.equals(total_conversion_from_db),"total_conversion__from_ui is not matching with db");
						}
						break;
					}
					else if(tiles_heading.get(i).getText().startsWith("UNIQUE")){
						String unique_calls_count_from_ui = dashboard_tiles_values.get(j).getText();
						String unique_calls_count_from_db = Util.readingFromDB("SELECT count(*) as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59' AND repeat_call='false'");
						System.out.println("unique_calls_count_from_ui is "+unique_calls_count_from_ui);
						System.out.println("unique_calls_count_from_db "+unique_calls_count_from_db);
						logger.log(LogStatus.INFO, "verifying unique calls count..");
						if((unique_calls_count_from_db==null) || (unique_calls_count_from_db.equals("0"))){
							softassert.assertTrue(unique_calls_count_from_db.equals("0"),"unique_calls_count_from_ui is not matching with db");											
						}
						else{

							softassert.assertTrue(unique_calls_count_from_ui.equals(unique_calls_count_from_db),"unique_calls_count_from_ui is not matching with db");						
						}
						break;

					}
					
					
				}
			  
			}	
		}
		softassert.assertAll();
	}
	
	public void paginationUI(){
		
		if(table_call_count.size()>100){
			SoftAssert softassert=new SoftAssert();
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
		else{
			logger.log(LogStatus.INFO, "Pagination toolbox is not displayed since records are less than 100");
		}
	  	
	}
	
    public void paginationCount(){
    	
		if(table_call_count.size()>100){
		    SoftAssert softassert=new SoftAssert();			
			String endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
			String startDateToBeUsed = Util.getDate("yyyy-MM-dd","-7");

			String dbCount = Util.readingFromDB("SELECT count(*) as count  FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");

			String countOnUI_pagination = pagination_call_count_label.getText().substring(pagination_call_count_label.getText().indexOf('f')+2);
			System.out.println("dbCount is "+dbCount);
			System.out.println("countOnUI_pagination is "+countOnUI_pagination);

			logger.log(LogStatus.INFO, "verifying count in  pagination toolbox");
			softassert.assertEquals(dbCount, countOnUI_pagination,"count in top pagination toolbox is mimatching with db count");
		
			softassert.assertAll();		

		}
		else{
			logger.log(LogStatus.INFO, "Pagination toolbox is not displayed since records are less than 100");
		}		
	}
    
    public void tableCount() throws InterruptedException{
    	
    	SoftAssert softassert=new SoftAssert();

    	String dbCount = Util.readingFromDB("SELECT COUNT(DISTINCT campaign_ou_id) as count FROM campaign WHERE campaign_ou_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"')");
        System.out.println("SELECT COUNT(DISTINCT campaign_ou_id) as count FROM campaign WHERE campaign_ou_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"')");
    	
		int final_count=table_call_count.size()+0;
		Util.scrollFunction(next_100_button);		
		if(!(next_100_button.getAttribute("class").endsWith("disabled"))){
		
			do {
				Util.click(next_100_button);
				wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
				final_count=final_count+table_call_count.size();
			}while(!(next_100_button.getAttribute("class").endsWith("disabled")));
		}
		
		System.out.println("dbCount is "+dbCount);
		System.out.println("table_call_count is "+final_count);
				
		logger.log(LogStatus.INFO, "verifying count of listed groups");
		softassert.assertEquals(dbCount, String.valueOf(final_count),"count of listed groups is mismtching with db count");
		softassert.assertAll();
		if(Integer.parseInt(dbCount)>100) {
			first_button.click();
		    Thread.sleep(4000);	
		}
		
	}
    
    public void allColumnPickerOptions(){
	    SoftAssert softassert=new SoftAssert();
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
//		Util.click(column_Picker_button);
		Util.Action().sendKeys(Keys.ESCAPE).perform();
	}

    public void defaultColumns(){
	    SoftAssert softassert=new SoftAssert();
        logger.log(LogStatus.INFO, "verifying column names in call detail table");
		
		for(int i=0;i<actual_column_names.size();i++){

			for(int j=0;j<expected_column_names.length;j++){

				if(actual_column_names.get(i).getText().equalsIgnoreCase(expected_column_names[j])){
					logger.log(LogStatus.INFO, "verifying if "+expected_column_names[j]+" is displayed");
					softassert.assertTrue(actual_column_names.get(i).getText().equalsIgnoreCase(expected_column_names[j]),"column "+expected_column_names[j]+" is not present");
					break;
				}
			}
		}
		softassert.assertAll();
	}
    
    
	public void checkAllColumnPickerOptions(){

		Util.click(column_Picker_button);
		for(int i=0;i<column_picker_options_checkboxes.size();i++){
			
			if(!(column_picker_options_checkboxes.get(i).isSelected())){
				Util.click(column_picker_options_checkboxes.get(i));
			}
		}
//		Util.click(column_Picker_button);
		Util.Action().sendKeys(Keys.ESCAPE).perform();	
	}
	
	public void allColumnPickerCheckboxes(){
	    SoftAssert softassert=new SoftAssert();
		Util.click(column_Picker_button);
		for(int i=0;i<column_picker_options_checkboxes.size();i++){

			if(column_picker_options_checkboxes.get(i).isSelected()){
				logger.log(LogStatus.INFO, "verifying if "+all_actual_column_picker_options_labels.get(i)+" is enabled");
				softassert.assertTrue(column_picker_options_checkboxes.get(i).isEnabled(),all_actual_column_picker_options_labels.get(i)+" is not enabled");				
			}

		}
		softassert.assertAll();
//		Util.click(column_Picker_button);
		Util.Action().sendKeys(Keys.ESCAPE).perform();
	}
    
		
	public void allColumns(){
	    SoftAssert softassert=new SoftAssert();
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
    
	public void advancedFilter(){
	    SoftAssert softassert=new SoftAssert();
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
		Util.click(cancel_button);

		softassert.assertAll();
	}
    
    public void basicFilterFeature(String filterelement) throws InterruptedException{
		SoftAssert softassert=new SoftAssert();
	    
    	try{
    	wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
    	}catch(Exception e){
 		   	}

		int index = 0;
		String filter_value="";
		
		for(int i=0;i<actual_column_names.size();i++){
		
			if(actual_column_names.get(i).getText().equals(filterelement)){
				index=i;
				break;
			}
		}
		
		List<WebElement> values = driver.findElements(By.xpath("//table[@id='groupActivityReportDataGrid']//tbody//tr[1]//td"));
		for(int j=0;j<values.size();j++){
		if(index==j){				
			filter_value=values.get(j).getText();
			break;
		}
		}
			
		basic_search_textbox.clear();
		basic_search_textbox.sendKeys(filter_value);
		Util.click(basic_search_button);
//			wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
		Thread.sleep(4000);
		String xPath="//table[@id='groupActivityReportDataGrid']//tbody//tr";
		List<WebElement> filtered_value = driver.findElements(By.xpath(xPath.concat("//td["+String.valueOf(index+1)+"]")));		
		List<String> actual_values =  new ArrayList<String>();
			
		for(WebElement val:filtered_value) {
			actual_values.add(val.getText());
		}
			
		softassert.assertFalse(!actual_values.contains(filter_value));			
		logger.log(LogStatus.INFO, "Verifying if basic filter feture is working for "+filter_value);	
		softassert.assertAll();
			
	}	

    public void advancedFilterFeature(String filterelement) throws InterruptedException{
    		
    	try{
    	wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
    	}catch(Exception e){
 		   	}
    	
		SoftAssert softassert=new SoftAssert();
		int index = 0;
		String filter_value="";
		
		for(int i=0;i<actual_column_names.size();i++){   
	     	if(filterelement.startsWith("Group")){
				if(actual_column_names.get(i).getText().equals("Group")){
					index=i;	
					break;
			    }
	    	}
			
			else if(actual_column_names.get(i).getText().equals(filterelement)){
			index=i;
			System.out.println("actual_column_names.get(i).getText() "+actual_column_names.get(i).getText() );
			break;
			}

		}
		
		List<WebElement> values = driver.findElements(By.xpath("//table[@id='groupActivityReportDataGrid']//tbody//tr[1]//td"));
		for(int j=0;j<values.size();j++){
			if(index==j){

				filter_value=values.get(j).getText();
				System.out.println("filter_value "+filter_value);
				System.out.println("values "+values.get(j).getText());
				break;
			}
		}
		
		advanced_filter_button.click();
		Select select=new Select(advance_filter_elements_listbox);
		select.selectByVisibleText(filterelement);

		if(filterelement.equals("Group Name") || filterelement.equals("Group Ext ID")){
			advance_filter_textbox_for_groupname_and_groupextid.sendKeys(filter_value);
		}
		else{
			advance_filter_textbox_for_rest.sendKeys(filter_value);
		}
		
		Util.click(apply_button);
		Util.getJavascriptExecutor().executeScript("window.scrollBy", "0,200");
		Thread.sleep(3000);
		
		String xPath="//table[@id='groupActivityReportDataGrid']//tbody//tr";
		List<WebElement> filtered_value = driver.findElements(By.xpath(xPath.concat("//td["+String.valueOf(index+1)+"]")));
		List<String> actual_values =  new ArrayList<String>();
			
		for(WebElement val:filtered_value) {
			actual_values.add(val.getText());
		}
			
		softassert.assertFalse(!actual_values.contains(filter_value));			
		
		logger.log(LogStatus.INFO, "Verifying if advanced filter feture is working for "+filter_value);	
		softassert.assertAll();
		
	}

    
    public void dateRangeFilter(String dateRange){
	    SoftAssert softassert=new SoftAssert();
		String endDateToBeUsed ="";
		String startDateToBeUsed ="";
		
		if(dateRange.equalsIgnoreCase("Last 7 days")){
			startDateToBeUsed = Util.getDate("yyyy-MM-dd","-7");
			endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
		}
		else if(dateRange.equalsIgnoreCase("today")){
			startDateToBeUsed = Util.getDate("yyyy-MM-dd","-1");
			endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
		}
		else if(dateRange.equalsIgnoreCase("yesterday")){
			startDateToBeUsed = Util.getDate("yyyy-MM-dd","-2");
			endDateToBeUsed = Util.getDate("yyyy-MM-dd","-1");
		}
		else if(dateRange.equalsIgnoreCase("last 30 days")){
			startDateToBeUsed = Util.getDate("yyyy-MM-dd","-30");
			endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
		}

        
        wait.until(ExpectedConditions.visibilityOf(dateRange_filter));
		Util.click(dateRange_filter);
		
		for(int i=0;i<actual_dateRange_filter_elements.size();i++){
			
			if(dateRange.equalsIgnoreCase(actual_dateRange_filter_elements.get(i).getText())){
		
				Util.Action().moveToElement(actual_dateRange_filter_elements.get(i)).click().perform();
				wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
				break;
			}
		}
		

		String dbCount = Util.readingFromDB("SELECT count(*) as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
        
		if(!(dbCount=="0" || dbCount==null)){
		
		String final_count=dashboard_tiles_values.get(0).getText();
			
		System.out.println("dbCount is "+dbCount);
		System.out.println("call_count is "+final_count);	
		logger.log(LogStatus.INFO, "verifying filtur feature is working for "+dateRange+" date range");
		softassert.assertEquals(dbCount, String.valueOf(final_count),"count  of listed calls is mismatching with db count");
		}
		else{
		logger.log(LogStatus.INFO, "There is no data found");			
		}
		softassert.assertAll();
		
		
	}

    
    
    
    
    
    
    
    
    
}
