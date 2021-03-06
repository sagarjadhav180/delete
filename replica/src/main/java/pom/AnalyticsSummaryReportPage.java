package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import tests.TestBase;
import tests.Util;

public class AnalyticsSummaryReportPage extends TestBase{

	@FindBy(xpath="//div[@class='title-main']//span[text()='Analytics Summary']")
	private WebElement header_label;
	
	@FindBy(xpath="//button[@class='btn run-button embed-view btn-primary'][text()='Run']")
	private WebElement run_button;

	@FindBy(xpath="//div[@class='dropdown-toggle button-xs']/i")
	private WebElement gear_icon;

	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-wide pull-right']//li//a")
	private List<WebElement> gear_icon_options;
	
	String[] expected_gear_icon_options={"Download as PDF...","Download as CSVs","Send","Schedule","Move to Trash"};

	@FindBy(xpath="//span[@class='timezone']")
	private WebElement timezone;
	
	@FindBy(xpath="//iframe[@id='looker']")
	private WebElement reports_iframe;
	
	@FindBy(xpath="//strong[@class='filter-section-title']//i")
	private WebElement filter_button;
	
	@FindBy(xpath="//table[@class='explore-filters clearfix']//tbody//tr//td[@class='filter-name']")
	private List<WebElement> filter_elements_after_expanding;

	String[] expected_filter_elements_after_expanding={"Date Range","Campaign","Group","Indicator","Tracking Number Name","Tracking Number","User"};
	
	SoftAssert softassert=new SoftAssert(); 

	@FindBy(xpath="//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span")
	private List<WebElement> tiles_names;
	
	String[] expected_tiles_names={"Total Calls","Total Analyzed Calls"};

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[1]")
	private WebElement hit_miss_graph;	
	
	@FindBy(xpath="//div[@class='highcharts-axis-labels highcharts-xaxis-labels']//span")
	private List<WebElement> indicator_names;
	
	String[] expected_indicator_names={"Acquired Address ","Acquired Email ","Acquired Name ","Acquired Phone Number ","Agent Empathy ","Agent Politeness ","All Conversion ","Appointment Set ","Ask for Business ","Build Credibility ","Buyer Confusion ","Cancellation ","Commitment to Buy ","Complaints ","Compliments ","Determine Needs ","Dissatisfaction ","Escalation Request ","Existing Customer ","Initial Purchase ","Leads ","Missed Opportunity ","Ownership Language ","Payment Language ","Phone Etiquette ","Politeness ","Promotion Mention ","Requested Lead Source ","Reservation Made ","Restate Needs ","Sales Inquiry ","Set Phone Appointment ","Transfer Permission ","Trial Close ","Voice Message "};
	
	@FindBy(xpath="//div[text()='No Results']")
	private WebElement no_results_label_for_hit_miss_graph;		
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[1]//div[@class='ag-header-container']//strong")
	private List<WebElement> hit_miss_table_columns;
	
	String[] expected_hit_miss_table_columns={"Indicator","Analyzed Calls","Total Hits","Hit Percent","Total Misses","Miss Percent"};
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[1]//span[text()='No Results']")
	private WebElement no_results_label_for_hit_miss_table;		
	
	public AnalyticsSummaryReportPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
    public void switchToIFrame(){
		
		driver.switchTo().frame(reports_iframe);
		
	}

    public void switchToMainWindow(){
		
		driver.switchTo().window(driver.getWindowHandle());
	  	
	}
    
    public void runButton(){

		wait.until(ExpectedConditions.visibilityOf(run_button));
		logger.log(LogStatus.INFO, "verifying if run_button is present");
		Assert.assertTrue(run_button.isDisplayed(),"run_button is not displayed or locator has been chamged..");
		logger.log(LogStatus.INFO, "verifying if run_button is enabled");
		Assert.assertTrue(run_button.isEnabled(),"run_button is not enabled");
	}
    
	public void headerLabel(){
		logger.log(LogStatus.INFO, "Verifying if header label is present");
		Assert.assertTrue(header_label.isDisplayed(),"Header label is not present or locator has been changed.");
	}
    
    public void presenceOfGearIcon(){
		
		logger.log(LogStatus.INFO, "Verifying if gear icon is present");
		Assert.assertTrue(gear_icon.isDisplayed(),"Gear icon is not present or locator has been changed.");
	}

    public void gearIconOptions(){
		
		logger.log(LogStatus.INFO, "Verifying options present in gear icon");
        
		gear_icon.click();
		for(int i=0;i<gear_icon_options.size();i++){
			
			for(int j=0;j<expected_gear_icon_options.length;j++){
				
				if(gear_icon_options.get(i).getText().equals(expected_gear_icon_options[j])){
					logger.log(LogStatus.INFO, "Verifying if "+expected_gear_icon_options[j]+" is present");
					softassert.assertTrue(gear_icon_options.get(i).getText().equals(expected_gear_icon_options[j]),"Gear icon "+expected_gear_icon_options[j]+" is present");
				}
			}
		}
    
		softassert.assertAll();
		gear_icon.click();
    }

    public void presenceOfTimeZone(){
		
		logger.log(LogStatus.INFO, "Verifying if Time Zone is present");
		Assert.assertTrue(timezone.isDisplayed(),"Time Zone is not present or locator has been changed.");
	}
    
    public void filterButton(){
		
		wait.until(ExpectedConditions.visibilityOf(filter_button));
	    logger.log(LogStatus.INFO, "verifying if filter_button is present");
	    softassert.assertTrue(filter_button.isDisplayed(), "filter_button is not present");

	    logger.log(LogStatus.INFO, "verifying if filter_button is enabled");
	    softassert.assertTrue(filter_button.isEnabled(), "filter_button is not enabled");	    
	}
    
    public void filterElements(){
        
    	Util.click(filter_button);
        
        for(int k=0;k<filter_elements_after_expanding.size();){
        	for(int j=0;j<expected_filter_elements_after_expanding.length;j++){

        		if(filter_elements_after_expanding.get(k).getText().equals(expected_filter_elements_after_expanding[j])){
    	    			    			    		
        		wait.until(ExpectedConditions.visibilityOf(filter_elements_after_expanding.get(k)));	    		
        		System.out.println("we-"+filter_elements_after_expanding.get(k).getText());
        		System.out.println("array-"+expected_filter_elements_after_expanding[j]);		
        		logger.log(LogStatus.INFO,"verifying if "+expected_filter_elements_after_expanding[j]+" filter is present");
        	    softassert.assertEquals(filter_elements_after_expanding.get(k).getText(),expected_filter_elements_after_expanding[j],expected_filter_elements_after_expanding[j]+" filter element is npt present");
        		}
        		}
        	k++;
        }

        softassert.assertAll();
    	//collapsing filter section
    	Util.click(filter_button);

    }
    
    public void tilesVerification(){
    	
    	for(int i=0;i<tiles_names.size();i++){
    		
    		for(int j=0;j<expected_tiles_names.length;j++){
    			
    			if(tiles_names.get(i).getText().startsWith(expected_tiles_names[j])){
    				
    				logger.log(LogStatus.INFO, "Verifying if "+expected_tiles_names[j]+" is present");
    				softassert.assertTrue(tiles_names.get(i).getText().startsWith(expected_tiles_names[j]),"Tile "+expected_tiles_names[j]+" is not present");
    			}
    		}
    		
    	}
    	softassert.assertAll();
    }
    
//  pg queris
    
    String endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
	String startDateToBeUsed = Util.getDate("yyyy-MM-dd","-7");

	String total_call_count_from_db = Util.readingFromDB("SELECT COUNT(*) AS count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
	String total_analyzed_call_count_from_db = Util.readingFromDB("SELECT COUNT(*) AS count FROM call_detail WHERE call_id IN (SELECT call_id FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59') AND call_mine_status='mined'");
    
	public void tileValueVerificationForDefault7DaysFilter(String tile_name){
		
		String tile_values=driver.findElement(By.xpath("//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span[text()='"+tile_name+"']//parent::Div//parent::div/preceding-sibling::div//a")).getText();
	
		if(tile_name.equals("Total Calls")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(total_call_count_from_db!=null){
				System.out.println(tile_values);
				System.out.println(total_call_count_from_db);
				softassert.assertTrue(tile_values.equals(total_call_count_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
		else if(tile_name.equals("Total Analyzed Calls")){
						
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(total_analyzed_call_count_from_db!=null){
				System.out.println(tile_values);
				System.out.println(total_analyzed_call_count_from_db);
				softassert.assertTrue(tile_values.equals(total_analyzed_call_count_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
						
		}

		softassert.assertAll();
    }	
    
    public void hitMissGraph(){
		
    	if(Integer.parseInt(total_analyzed_call_count_from_db)>0){
    		logger.log(LogStatus.INFO, "Verifying if Calls Over Time by Day Graph is present");
    		Assert.assertTrue(hit_miss_graph.isDisplayed(),"Hit Miss Graph is not present or locator has been changed.");    		
    	}
    	else{
    		logger.log(LogStatus.INFO, "Hit Miss Graph is not present since total calls are 0");
    	}

	}
	
    public void hitMissGraphindicatorVerification() throws InterruptedException{
	
    	if(Integer.parseInt(total_analyzed_call_count_from_db)>0){
    		Thread.sleep(2000);
    		
    		for(int i=0;i<indicator_names.size();i++){
    			
    			for(int j=0;j<expected_indicator_names.length;j++){
    				
    				if(indicator_names.get(i).getText().equals(expected_indicator_names[j])){
    					
    					logger.log(LogStatus.INFO, "Verifying if "+expected_indicator_names[j]+" is present");
    					softassert.assertTrue(indicator_names.get(i).getText().equals(expected_indicator_names[j]),"Indicator "+expected_indicator_names[j]+" is not present");
    				}
    			}
    		}
    			
    		softassert.assertAll();
    	}
    	else{
    		logger.log(LogStatus.INFO, "Verifying if no results label is displayed since there is no data");
    		Assert.assertTrue(no_results_label_for_hit_miss_graph.isDisplayed(),"No results label is not displayed when there is no data");
    	}
    	
		
	}
    
    public void hitMixTableColumnVerification() throws InterruptedException{
		
    	if(Integer.parseInt(total_analyzed_call_count_from_db)>0){
    		Thread.sleep(2000);
    		
    		for(int i=0;i<hit_miss_table_columns.size();i++){
    			
    			for(int j=0;j<expected_hit_miss_table_columns.length;j++){
    				
    				if(hit_miss_table_columns.get(i).getText().equals(expected_hit_miss_table_columns[j])){
    					
    					logger.log(LogStatus.INFO, "Verifying if "+expected_hit_miss_table_columns[j]+" is present");
    					softassert.assertTrue(hit_miss_table_columns.get(i).getText().equals(expected_hit_miss_table_columns[j]),"Column "+expected_hit_miss_table_columns[j]+" is not present");
    				}
    			}
    			
    		}
    			
    		softassert.assertAll();
    	}
    	else{
    		logger.log(LogStatus.INFO, "Verifying if no results label is displayed since there is no data");
    		Assert.assertTrue(no_results_label_for_hit_miss_table.isDisplayed(),"No results label is not displayed when there is no data");
    	}
    	
	}
    
    
    
}
