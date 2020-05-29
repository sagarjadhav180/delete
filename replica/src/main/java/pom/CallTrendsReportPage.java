package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class CallTrendsReportPage extends TestBase{
	
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
	
	String[] expected_filter_elements_after_expanding={"Date Range","Stack Columns By","Group Pie Chart By","Campaign","Group","Tracking Number Name","Tracking Number"};
	
	@FindBy(xpath="(//div[@class='title-main']//span[text()='Call Trends'])")
	private WebElement header_label;
	
	@FindBy(xpath="//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span")
	private List<WebElement> tiles_names;
	
	String [] expected_tiles_names={"Total Calls","Unique Calls","Answered Calls","Unanswered Calls","Peak Day","Peak Hour","Longest Call","Average Call Duration"};
	
	@FindBy(xpath="//div[@class='vis-header']//span[text()='Calls Over Time by Day']")
	private WebElement calls_over_time_by_day_label;	
	
	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[1]")
	private WebElement calls_over_time_by_day_graph;	
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[1]//div[@class='ag-header-container']//strong")
	private List<WebElement> calls_over_time_by_day_table_columns;

	String[] expected_calls_over_time_by_day_table_columns={"Days","Repeat Calls","Unique Calls"};
	
	@FindBy(xpath="(//div[@class='vis-header']//span[text()='Calls Over Time by Hour'])[1]")
	private WebElement calls_over_time_by_hour_label;

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[2]")
	private WebElement calls_over_time_by_hour_graph;	

	@FindBy(xpath="(//div[@class='ag-grid-container'])[2]//div[@class='ag-header-container']//strong")
	private List<WebElement> calls_over_time_by_hour_table_columns;

	String[] expected_calls_over_time_by_hour_table_columns={"Hours","Repeat Calls","Unique Calls"};
	
	@FindBy(xpath="(//div[@class='vis-header']//span[text()='Calls-Mix'])")
	private WebElement calls_mix_label;

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[3]")
	private WebElement calls_mix_graph;	

	@FindBy(xpath="(//div[@class='ag-grid-container'])[3]//div[@class='ag-header-container']//strong")
	private List<WebElement> calls_mix_table_columns;
	
	String[] expected_calls_mix_table_columns={"Call Type","Group","Campaign","Tracking Number Name","Tracking Number","Total Calls","Total Calls"};
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[3]//span[text()='No Results']")
	private WebElement no_results_label_for_call_mix_table;	
	
	SoftAssert softassert=new SoftAssert(); 

	public CallTrendsReportPage(WebDriver driver){
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
    			
    			if(tiles_names.get(i).getText().equals(expected_tiles_names[j])){
    				
    				logger.log(LogStatus.INFO, "Verifying if "+expected_tiles_names[j]+" is present");
    				softassert.assertTrue(tiles_names.get(i).getText().equals(expected_tiles_names[j]),"Tile "+expected_tiles_names[j]+" is not present");
    			}
    		}
    		
    	}
    	softassert.assertAll();
    }
    
    
//  pg queris
    
    String endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
	String startDateToBeUsed = Util.getDate("yyyy-MM-dd","-7");

	String total_call_count_from_db = Util.readingFromDB("SELECT COUNT(*) AS count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
	String unique_calls_count_from_db = Util.readingFromDB("SELECT COUNT(*) AS count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59' AND repeat_call='false'");
	String answered_calls_count_from_db = Util.readingFromDB("SELECT COUNT(*) AS count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59' AND disposition IN ('ANSWERED')");
	String avg_call_duration_from_db = Util.readingFromDB("SELECT ROUND(AVG(duration)) AS count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
	String unanswered_calls_count_from_db = Util.readingFromDB("SELECT COUNT(*) AS count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59' AND disposition IN ('NO ANSWER')");
	String longest_call_duration_from_db = Util.readingFromDB("SELECT MAX(duration) AS count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");

//  -------------------------------------------------------------------------------------------------------------------- 

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
			else if(tile_name.equals("Unique Calls")){
				
				
				logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
				if(unique_calls_count_from_db!=null){
					System.out.println(tile_values);
					System.out.println(unique_calls_count_from_db);
					softassert.assertTrue(tile_values.equals(unique_calls_count_from_db),"Tile count doest match with db count");			
				}
				else{
					softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
				}
				
			}
				
			else if(tile_name.equals("Answered Calls")){
				
				logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
				if(answered_calls_count_from_db!=null){
					System.out.println(tile_values);
					System.out.println(answered_calls_count_from_db);
					softassert.assertTrue(tile_values.equals(answered_calls_count_from_db),"Tile count doest match with db count");			
				}
				else{
					softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
				}
				
			}
			else if(tile_name.equals("Unanswered Calls")){
				
				logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
				if(unanswered_calls_count_from_db!=null){
					System.out.println(tile_values);
					System.out.println(unanswered_calls_count_from_db);
					softassert.assertTrue(tile_values.equals(unanswered_calls_count_from_db),"Tile count doest match with db count");			
				}
				else{
					softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
				}
				
			}
			else if(tile_name.equals("Average Call Duration")){
				int sec = 0;
				int min = Integer.valueOf(tile_values.substring(0,tile_values.indexOf('m')-1));
		        if(min<=9){
		        	sec = Integer.valueOf(tile_values.substring(6,8));    	
		        }
		        else{
		        	sec = Integer.valueOf(tile_values.substring(7,9));    	        	
		        }
		        min=min*60;
				int final_count=sec+min;
				tile_values=String.valueOf(final_count);

				logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
				if(avg_call_duration_from_db!=null){
					System.out.println(tile_values);
					System.out.println(avg_call_duration_from_db);
					softassert.assertTrue(tile_values.equals(avg_call_duration_from_db),"Tile count doest match with db count");			
				}
				else{
					softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
				}
				
			}
			else if(tile_name.equals("Longest Call")){
				int sec = 0;
				int min = Integer.valueOf(tile_values.substring(0,tile_values.indexOf('m')-1));
		        if(min<=9){
		        	sec = Integer.valueOf(tile_values.substring(6,8));    	
		        }
		        else{
		        	sec = Integer.valueOf(tile_values.substring(7,9));    	        	
		        }
		        min=min*60;
				int final_count=sec+min;
				tile_values=String.valueOf(final_count);

				logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
				if(longest_call_duration_from_db!=null){
					System.out.println(tile_values);
					System.out.println(longest_call_duration_from_db);
					softassert.assertTrue(tile_values.equals(longest_call_duration_from_db),"Tile count doest match with db count");			
				}
				else{
					softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
				}
				
			}

			
			softassert.assertAll();
	}	
    
    public void callsOverTimebyDayLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if Calls Over Time by Day Label is present");
		Assert.assertTrue(calls_over_time_by_day_label.isDisplayed(),"Calls Over Time by Day label is not present or locator has been changed.");
	}
	
    public void callsOverTimebyDayGraph(){
		
    	if(Integer.parseInt(total_call_count_from_db)>0){
    		logger.log(LogStatus.INFO, "Verifying if Calls Over Time by Day Graph is present");
    		Assert.assertTrue(calls_over_time_by_day_graph.isDisplayed(),"Calls Over Time by Day Graph is not present or locator has been changed.");    		
    	}
    	else{
    		logger.log(LogStatus.INFO, "Calls Over Time by Day Graph is not present since total calls are 0");
    	}

	}
    
    public void callsOverTimebyDayTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<calls_over_time_by_day_table_columns.size();i++){
			
			for(int j=0;j<expected_calls_over_time_by_day_table_columns.length;j++){
				
				if(calls_over_time_by_day_table_columns.get(i).getText().equals(expected_calls_over_time_by_day_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_calls_over_time_by_day_table_columns[j]+" is present");
					softassert.assertTrue(calls_over_time_by_day_table_columns.get(i).getText().equals(expected_calls_over_time_by_day_table_columns[j]),"Column "+expected_calls_over_time_by_day_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
    
    public void callsOverTimebyHourLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if Calls Over Time by Hour Label is present");
		Assert.assertTrue(calls_over_time_by_hour_label.isDisplayed(),"Calls Over Time by Hour label is not present or locator has been changed.");
	}
    
    public void callsOverTimebyHourGraph(){
		
    	if(Integer.parseInt(total_call_count_from_db)>0){
    		logger.log(LogStatus.INFO, "Verifying if Calls Over Time by Hour Graph is present");
    		Assert.assertTrue(calls_over_time_by_hour_graph.isDisplayed(),"Calls Over Time by Hour Graph is not present or locator has been changed.");    		
    	}
    	else{
    		logger.log(LogStatus.INFO, "Calls Over Time by Hour Graph is not present since total calls are 0");
    	}

	}

    public void callsOverTimebyHourTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<calls_over_time_by_hour_table_columns.size();i++){
			
			for(int j=0;j<expected_calls_over_time_by_hour_table_columns.length;j++){
				
				if(calls_over_time_by_hour_table_columns.get(i).getText().equals(expected_calls_over_time_by_hour_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_calls_over_time_by_hour_table_columns[j]+" is present");
					softassert.assertTrue(calls_over_time_by_hour_table_columns.get(i).getText().equals(expected_calls_over_time_by_hour_table_columns[j]),"Column "+expected_calls_over_time_by_hour_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
    
    public void callsMixLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if Call Mix Label is present");
		Assert.assertTrue(calls_mix_label.isDisplayed(),"Call Mix label is not present or locator has been changed.");
	}
    
    public void callMixGraph(){
		
    	if(Integer.parseInt(total_call_count_from_db)>0){
    		logger.log(LogStatus.INFO, "Verifying if Call Mix Graph is present");
    		Assert.assertTrue(calls_mix_graph.isDisplayed(),"Call Mix Graph is not present or locator has been changed.");    		
    	}
    	else{
    		logger.log(LogStatus.INFO, "Call Mix Graph is not present since total calls are 0");
    	}

	}    
    
    public void callMixTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<calls_mix_table_columns.size();i++){
			
			for(int j=0;j<expected_calls_mix_table_columns.length;j++){
				
				if(calls_mix_table_columns.get(i).getText().equals(expected_calls_mix_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_calls_mix_table_columns[j]+" is present");
					softassert.assertTrue(calls_mix_table_columns.get(i).getText().equals(expected_calls_mix_table_columns[j]),"Column "+expected_calls_mix_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}    
    
    public void filterFeatureForCallMixTable(String filterName) throws InterruptedException{

    	if(total_call_count_from_db.equals("0")){
    		
    		logger.log(LogStatus.INFO, "Verifying if no results label is displayed since there is no data to filter");
    		Assert.assertTrue(no_results_label_for_call_mix_table.isDisplayed(),"no results label is not displayed or locator changed");
    	}
    	else{
    		int index=0;
            String filterValue;
    		for(int i=0;i<calls_mix_table_columns.size();i++){
    			
    			if(filterName.equals(calls_mix_table_columns.get(i).getText())){
    				
    				index=i+1;
    				break;
    			}
    		}
    		List<WebElement> value_to_be_filtered = driver.findElements(By.xpath("(//div[@class='ag-grid-container'])[3]//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]"));		
    		filterValue=value_to_be_filtered.get(0).getText();
    		
    		filter_button.click();
    		
    		String xpath="//table[@class='explore-filters clearfix']//tbody//tr//td[@class='filter-name'][text()='"+filterName+"']";
    		
    		WebElement filter_textbox = driver.findElement(By.xpath(""+xpath+"//parent::tr//select//following-sibling::span"));
    	
    		wait.until(ExpectedConditions.visibilityOf(filter_textbox));
            Util.Action().moveToElement(filter_textbox).perform();
            Util.Action().click().perform();
    	    Util.Action().sendKeys(filterValue).perform();
    	    Util.Action().sendKeys(Keys.ESCAPE).perform();	
    		
    		run_button.click();
    		filter_button.click();
    		Thread.sleep(5000);
    		
    	
    		List<WebElement> filtered_values = driver.findElements(By.xpath("(//div[@class='ag-grid-container'])[3]//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]"));
    		System.out.println("(//div[@class='ag-grid-container'])[3]//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]");
    		for(int j=0;j<filtered_values.size();j++){
    			
    			System.out.println(filtered_values.get(j).getText());
    			System.out.println(filterValue);
    			logger.log(LogStatus.INFO, "Verifying if "+filtered_values.get(j).getText()+" is matching with "+filterValue);
    			softassert.assertTrue(filtered_values.get(j).getText().equals(filterValue),"value "+filtered_values.get(j).getText()+" is not filtered value");
    		}
    		
    		
    		softassert.assertAll();

            filter_button.click();
    		
    		wait.until(ExpectedConditions.visibilityOf(filter_textbox));
            Util.Action().moveToElement(filter_textbox).perform();
            Util.Action().click().perform();
            Thread.sleep(1000);
    	    Util.Action().sendKeys(Keys.BACK_SPACE).perform();
            Util.Action().sendKeys(Keys.BACK_SPACE).perform();
    		Util.Action().sendKeys(Keys.ESCAPE).perform();	
    	
    		filter_button.click();
    	}
    	        
	}	
    
    
    
    
}
