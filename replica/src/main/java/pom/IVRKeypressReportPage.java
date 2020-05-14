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

public class IVRKeypressReportPage extends TestBase{

	@FindBy(xpath="//div[@class='title-main']//span[text()='IVR Keypress']")
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
	
	String[] expected_filter_elements_after_expanding={"Date Range","Caller ID","Campaign","Destination","Group","Tracking Number Name","Tracking Number","Ring-to Number","Calls with Agent ID","Agent ID","Calls with Call Outcome","Sale Amount"};
	
	@FindBy(xpath="//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span")
	private List<WebElement> tiles_names_ivr;	
	
	String[] expected_tiles_names_ivr={"Total Call","IVR Calls","Average Time in Menu","Abandoned Calls","Number Of Unused Paths"};
	
	@FindBy(xpath="//div[@class='looker-vis-context-title']//span[text()='Path Performance']")
	private WebElement path_performance_table_title;

	@FindBy(xpath="(//div[@class='ag-header-row'])[2]//strong")
	private List<WebElement> path_performance_table_column;
	
	String[] expected_path_performance_table_column={"Group|External ID","Campaign|External ID","Tracking Number | Tracking Number Name","Tracking Number Type","IVR Path","Total Calls","Average Call Duration","Abandoned Calls","Abandoned Rate"};

	@FindBy(xpath="(//div[@class='ag-grid-container'])[1]//span[text()='No Results']")
	private WebElement no_result_label_path_performance_table;
	
	@FindBy(xpath="//div[@class='looker-vis-context-title']//span[text()='Unused Paths']")
	private WebElement unused_path_table_title;

	@FindBy(xpath="(//div[@class='ag-header-row'])[5]//strong")
	private List<WebElement> unused_path_table_column;

	String[] expected_unused_path_table_column={"Group|External ID","Campaign|External ID","Tracking Number | Tracking Number Name","Tracking Number Type","IVR Path"};
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[2]//span[text()='No Results']")
	private WebElement no_result_label_unused_path_table;
	
	@FindBy(xpath="//div[@class='looker-vis-context-title']//span[text()='Calls']")
	private WebElement calls_table_title;

	@FindBy(xpath="(//div[@class='ag-header-row'])[8]//strong")
	private List<WebElement> calls_table_column;

	String[] expected_calls_table_column={"Play Call","Date/Time","Group|External ID","Campaign|External ID","Tracking Number | Tracking Number Name","Caller Id","Keypress","Ring to Phone Number","Total Duration","Total Time in Menu"};
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[3]//span[text()='No Results']")
	private WebElement no_result_label_calls_table;
	
	@FindBy(xpath="//div[@class='title-text'][text()='Instant Insights']")
	private WebElement instants_insights_title;	

	@FindBy(xpath="(//div[@class='ag-header-row'])[11]//strong")
	private List<WebElement> instants_insights_table_column;

	String[] expected_instants_insights_table_column={"Play Call","Duration","Date/Time","Group|External ID","Campaign|External ID","Tracking Number | Tracking Number Name","Caller Id","Agent ID","Lead","Sale"};	
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[4]//span[text()='No Results']")
	private WebElement no_result_label_instants_insights_table;
	
	@FindBy(xpath="//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span")
	private List<WebElement> tiles_names_instants_insights;		
	
	String[] expected_tiles_names_instants_insights={"Total Calls","Calls with Instant Insights","Calls with Agent ID","Calls with Call Outcome"};
	
	SoftAssert softassert=new SoftAssert(); 

	public IVRKeypressReportPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
    public void switchToIFrame(){
		
		driver.switchTo().frame(reports_iframe);
		
	}
    
    public void switchToMainWindow(){
		
		driver.switchTo().window(driver.getWindowHandle());
		
	}
    
	public void headerLabel(){

		logger.log(LogStatus.INFO, "Verifying if header label is present");
		Assert.assertTrue(header_label.isDisplayed(),"header label is not present or locator has been changed.");
		
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
    }
	
    public void presenceOfTimeZone(){
		
		logger.log(LogStatus.INFO, "Verifying if Time Zone is present");
		Assert.assertTrue(timezone.isDisplayed(),"Time Zone is not present or locator has been changed.");
	}

	public void runButton(){

		wait.until(ExpectedConditions.visibilityOf(run_button));
		logger.log(LogStatus.INFO, "verifying if run_button is present");
		Assert.assertTrue(run_button.isDisplayed(),"run_button is not displayed or locator has been chamged..");
		logger.log(LogStatus.INFO, "verifying if run_button is enabled");
		Assert.assertTrue(run_button.isEnabled(),"run_button is not enabled");
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
    
	public void pathPerformanceLabelVerification(){
		logger.log(LogStatus.INFO, "verifying if path performance label is present");
		Assert.assertTrue(path_performance_table_title.isDisplayed(),"path performance label is not displayed or locator has been chamged..");
	}
	
	public void ususedPathLabelVerification(){
		logger.log(LogStatus.INFO, "verifying if Unused Path label is present");
		Assert.assertTrue(unused_path_table_title.isDisplayed(),"Unused Path label is not displayed or locator has been chamged..");
	}
	
	public void callsLabelVerification(){
		logger.log(LogStatus.INFO, "verifying if Calls label is present");
		Assert.assertTrue(calls_table_title.isDisplayed(),"Calls label is not displayed or locator has been chamged..");
	}
	
	public void instantInsightsLabelVerification(){
		logger.log(LogStatus.INFO, "verifying if Instant Insights label is present");
		Assert.assertTrue(instants_insights_title.isDisplayed(),"Instant Insights label is not displayed or locator has been chamged..");
	}
	
    public void pathPerformanceTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<path_performance_table_column.size();i++){
			
			for(int j=0;j<expected_path_performance_table_column.length;j++){
				
				if(path_performance_table_column.get(i).getText().equals(expected_path_performance_table_column[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_path_performance_table_column[j]+" is present");
					softassert.assertTrue(path_performance_table_column.get(i).getText().equals(expected_path_performance_table_column[j]),"Column "+expected_path_performance_table_column[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
	
    public void unusedPathTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<unused_path_table_column.size();i++){
			
			for(int j=0;j<expected_unused_path_table_column.length;j++){
				
				if(unused_path_table_column.get(i).getText().equals(expected_unused_path_table_column[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_unused_path_table_column[j]+" is present");
					softassert.assertTrue(unused_path_table_column.get(i).getText().equals(expected_unused_path_table_column[j]),"Column "+expected_unused_path_table_column[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
    
    public void callsTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<calls_table_column.size();i++){
			
			for(int j=0;j<expected_calls_table_column.length;j++){
				
				if(calls_table_column.get(i).getText().equals(expected_calls_table_column[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_calls_table_column[j]+" is present");
					softassert.assertTrue(calls_table_column.get(i).getText().equals(expected_calls_table_column[j]),"Column "+expected_calls_table_column[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
    
    public void instantInsightsTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<instants_insights_table_column.size();i++){
			
			for(int j=0;j<expected_instants_insights_table_column.length;j++){
				
				if(instants_insights_table_column.get(i).getText().equals(expected_instants_insights_table_column[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_instants_insights_table_column[j]+" is present");
					softassert.assertTrue(instants_insights_table_column.get(i).getText().equals(expected_instants_insights_table_column[j]),"Column "+expected_instants_insights_table_column[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
    
    public void tilesVerificationForIVR(){
    	
    	for(int i=0;i<tiles_names_ivr.size();i++){
    		
    		for(int j=0;j<expected_tiles_names_ivr.length;j++){
    			
    			if(tiles_names_ivr.get(i).getText().equals(expected_tiles_names_ivr[j])){
    				
    				logger.log(LogStatus.INFO, "Verifying if "+expected_tiles_names_ivr[j]+" is present");
    				softassert.assertTrue(tiles_names_ivr.get(i).getText().equals(expected_tiles_names_ivr[j]),"Tile "+expected_tiles_names_ivr[j]+" is not present");
    			}
    		}
    		
    	}
    	softassert.assertAll();
    }
    
    public void tilesVerificationForInstantInghts(){
    	
    	for(int i=0;i<tiles_names_instants_insights.size();i++){
    		
    		for(int j=0;j<expected_tiles_names_instants_insights.length;j++){
    			
    			if(tiles_names_instants_insights.get(i).getText().equals(expected_tiles_names_instants_insights[j])){
    				
    				logger.log(LogStatus.INFO, "Verifying if "+expected_tiles_names_instants_insights[j]+" is present");
    				softassert.assertTrue(tiles_names_instants_insights.get(i).getText().equals(expected_tiles_names_instants_insights[j]),"Tile "+expected_tiles_names_instants_insights[j]+" is not present");
    			}
    		}
    		
    	}
    	softassert.assertAll();
    }
    
    //-----------------------------------------------------------------------

    String endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
	String startDateToBeUsed = Util.getDate("yyyy-MM-dd","-7");
    
    //total calls
    String total_calls_from_db=Util.readingFromDB("SELECT COUNT(*) AS count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
	
    //ivr calls
    String ivr_calls_from_db=Util.readingFromDB("SELECT COUNT(*) AS count FROM call_detail WHERE call_id IN (SELECT call_id FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"')AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59' AND tracking IN (SELECT dnis FROM ce_call_flows WHERE routable_type LIKE 'IvrRoute2' )) AND menu_time IS NOT NULL");
    
    //avg time in menu
    String avg_time_menu_from_db_without_roundoff=Util.readingFromDB("SELECT (AVG(menu_time)) AS count FROM call_detail WHERE call_id IN (SELECT call_id FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59' AND tracking IN (SELECT dnis FROM ce_call_flows WHERE routable_type LIKE 'IvrRoute2' ))");
   
    //abandon calls
    String abandon_calls_from_db=Util.readingFromDB("SELECT COUNT(*) AS count FROM call WHERE call_id IN (SELECT call_id FROM call_detail WHERE call_id IN (SELECT call_id FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"')AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59' AND tracking IN (SELECT dnis FROM ce_call_flows WHERE routable_type LIKE 'IvrRoute2')) AND menu_time IS NOT NULL) AND ring_to='abandon'");
    
    //instants insight call
    String instants_insight_calls_from_db=Util.readingFromDB("SELECT COUNT(*) AS count FROM post_call_ivr_responses WHERE call_id IN (SELECT call_id FROM call WHERE call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59' AND tracking IN (SELECT dnis FROM ce_call_flows WHERE postcall_ivr_enabled=true) AND org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"'))");

    //calls with agent id
    String calls_with_agent_id_from_db=Util.readingFromDB("SELECT COUNT(*) AS count FROM post_call_ivr_responses  WHERE call_id IN (SELECT call_id FROM call WHERE call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59' AND org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"')) AND sales IS NULL AND lead IS NULL AND agent_id IS NOT NULL");
    
    //calls with outcome
    String calls_with_outcome_from_db=Util.readingFromDB("SELECT COUNT(*) AS count FROM post_call_ivr_responses WHERE call_id IN (SELECT call_id FROM call WHERE call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59' AND org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"')) AND sales IS NOT NULL AND lead IS NOT NULL AND agent_id IS NULL");
    
    //---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------    
    
    
    public void tileValueVerificationForIVR(String tile_name){
		
    	long roundoff = Math.round(Double.valueOf(avg_time_menu_from_db_without_roundoff.substring(6)));
    	
    	String without_sec = avg_time_menu_from_db_without_roundoff.substring(0,6);
    	
    	String avg_time_menu_from_db = without_sec.concat(String.valueOf(roundoff));
    	
		String tile_values=driver.findElement(By.xpath("//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span[text()='"+tile_name+"']//parent::Div//parent::div/preceding-sibling::div//a")).getText();
	
        if(tile_name.equals("Total Call")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(total_calls_from_db!=null){
				System.out.println(tile_values);
				System.out.println(total_calls_from_db);
				softassert.assertTrue(tile_values.equals(total_calls_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
        
        else if(tile_name.equals("IVR Calls")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(ivr_calls_from_db!=null){
				System.out.println(tile_values);
				System.out.println(ivr_calls_from_db);
				softassert.assertTrue(tile_values.equals(ivr_calls_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
        
        else if(tile_name.equals("Average Time in Menu")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(avg_time_menu_from_db!=null){
				System.out.println(tile_values);
				System.out.println(avg_time_menu_from_db);
				softassert.assertTrue(tile_values.equals(avg_time_menu_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
        
        else if(tile_name.equals("Abandoned Calls")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(abandon_calls_from_db!=null){
				System.out.println(tile_values);
				System.out.println(abandon_calls_from_db);
				softassert.assertTrue(tile_values.equals(abandon_calls_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
        
		softassert.assertAll();		
	}
     
    public void tileValueVerificationForInstantInsights(String tile_name){
		
		String tile_values=driver.findElement(By.xpath("//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span[text()='"+tile_name+"']//parent::Div//parent::div/preceding-sibling::div//a")).getText();
	
        if(tile_name.equals("Total Calls")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(total_calls_from_db!=null){
				System.out.println(tile_values);
				System.out.println(total_calls_from_db);
				softassert.assertTrue(tile_values.equals(total_calls_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
        
        else if(tile_name.equals("Calls with Instant Insights")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(instants_insight_calls_from_db!=null){
				System.out.println(tile_values);
				System.out.println(instants_insight_calls_from_db);
				softassert.assertTrue(tile_values.equals(instants_insight_calls_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
        
        else if(tile_name.equals("Calls with Agent ID")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(calls_with_agent_id_from_db!=null){
				System.out.println(tile_values);
				System.out.println(calls_with_agent_id_from_db);
				softassert.assertTrue(tile_values.equals(calls_with_agent_id_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
        
        else if(tile_name.equals("Calls with Call Outcome")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(calls_with_outcome_from_db!=null){
				System.out.println(tile_values);
				System.out.println(calls_with_outcome_from_db);
				softassert.assertTrue(tile_values.equals(calls_with_outcome_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
        
		softassert.assertAll();		
	}
    
    

}
