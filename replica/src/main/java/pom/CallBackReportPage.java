package pom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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


public class CallBackReportPage extends TestBase{
	
//	------------------------------------------------------------------------------------------------
	@FindBy(xpath="(//div[@class='Space-zsz5hl-0 hzbCpE']//div[starts-with(@class,'Icon-sc')])[1]")
	private WebElement run_button;

	@FindBy(xpath="(//div[@class='Space-zsz5hl-0 hzbCpE']//div[starts-with(@class,'Icon-sc')])[1]//parent::button//div[text()='Cancel']")
	private WebElement cancel_button;

	@FindBy(xpath="(//div[@class='Space-zsz5hl-0 hzbCpE']//div[starts-with(@class,'Icon-sc')])[1]//parent::button//div[text()='Reload']")
	private WebElement reload_button;
	
	@FindBy(xpath="(//div[@class='Space-zsz5hl-0 hzbCpE']//div[starts-with(@class,'Icon-sc')])[3]")
	private WebElement dashboard_actions_button;	
	
	@FindBy(xpath="//div[text()='Dashboard actions']//parent::button")
	private WebElement dashboard_actions_link;	
	
	@FindBy(xpath="//ul[@class='MenuList-sc-1m0jggd-0 dQxuQg']//li//button[@role='menuitem']/span")
	private List<WebElement> dashboard_actions_pup_up_options;	
	
	String[] expected_dashboard_actions_pup_up_options = {"Clear cache and refresh","Download","Schedule delivery"};
	
	@FindBy(xpath="//h1[text()='Call Back']")
	private WebElement header_label;

	@FindBy(xpath="//div[@aria-label='Filters Section']//h6")
	private List<WebElement> filter_elements_after_expanding;
	
	String[] expected_filter_elements_after_expanding={"Date Range","Stack Column By","Ad Source","Call ID","Campaign","Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5","Duration","Group","Indicator","Ring-to Name","Ring-to Number","Tags","Tracking Number Name","Tracking Number","User"};
	
	@FindBy(xpath="(//div[@class='Space-zsz5hl-0 hzbCpE']//div[starts-with(@class,'Icon-sc')])[2]")
	private WebElement filter_button;	

	@FindBy(xpath="//div[@class='react-grid-layout']//div[@data-testid='test-single-value-container']//div[@overflow='hidden']")
	private List<WebElement> tiles_names;	
	
	String[] expected_tiles_names={"Total Calls","Answered Calls","Average Call Duration","Missed Opportunity Calls%of Total Analyzed Calls","Tagged as Call Back"};
	
	@FindBy(xpath="//div[text()='Missed Opportunity Over Time']")
	private WebElement missed_opportunity_over_time_label;	

	@FindBy(xpath="//div[@class='highcharts-container ']//span[text()='Missed Opportunity Calls']")
	private WebElement missed_opportunity_call_legend;	
	
	@FindBy(xpath="//div[@class='highcharts-container ']//span[text()='Total Calls']")
	private WebElement total_calls_legend;	

	@FindBy(xpath="//div[text()='Missed Opportunity Summary']")
	private WebElement missed_opportunity_summary_label;
	
	@FindBy(xpath="//div[text()='Missed Opportunity Summary']//ancestor::div[starts-with(@class,'CardContent-sc-21xesl-0 leFvbf')]//div[@class='ag-header-container']//strong")
	private List<WebElement> missed_opportunity_summary_table_columns;
	
	String[] expected_missed_opportunity_summary_table_columns={"Play Call","Caller Id","Date/Time","Duration","Repeat Call","Group","Group External Id","Campaign","Campaign External Id","Tracking Number Name","Tracking Number","Ad Source","Ring-to Name","Ring-to Number","Number Of Repeat Calls"};
	
	@FindBy(xpath="//div[text()='Missed Opportunity Summary']//ancestor::div[@aria-label='Dashboard Tile']//p[text()='No results.']")
	private WebElement no_results_label_for_missed_opportunity_summary_table;	
	
	@FindBy(xpath="//div[text()='Tagged as Call Back']//ancestor::div[@aria-label='Dashboard Tile']//p[text()='No results.']")
	private WebElement no_results_label_for_tagged_as_callback_table;
	
	@FindBy(xpath="//div[text()='Tagged as Call Back']")
	private WebElement tagged_as_callback_table_label;

	@FindBy(xpath="//div[text()='Tagged as Call Back']//ancestor::div[starts-with(@class,'CardContent-sc-21xesl-0 leFvbf')]//div[@class='ag-header-container']//strong")
	private List<WebElement> tagged_as_callback_table_columns;
	
	String[] expected_tagged_as_callback_table_columns={"Actions","Play Call","Caller Id","Date/Time","Type","Group","Group External Id","Campaign","Campaign External Id","Ad Source","Tracking Number Name","Tracking Number","Duration","Identified Agent","Tags","Comment"};
	
	@FindBy(xpath="//input[starts-with(@id,'listbox')][@placeholder='any value']")
	private WebElement filter_text_box;	
	
//	--------------------------------------------------------------------------------------------------------
	
	@FindBy(xpath="//div[@class='dropdown-toggle button-xs']/i")
	private WebElement gear_icon;

	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-wide pull-right']//li//a")
	private List<WebElement> gear_icon_options;
	
	String[] expected_gear_icon_options={"Download as PDF...","Download as CSVs","Send","Schedule","Move to Trash"};

	@FindBy(xpath="//span[@class='timezone']")
	private WebElement timezone;
	
	@FindBy(xpath="//div[starts-with(@id,'highcharts')]")
	private WebElement missed_opportunity_over_time_graph;	
			
	@FindBy(xpath="//iframe[@id='looker']")
	private WebElement reports_iframe;
	
	SoftAssert softassert=new SoftAssert(); 

	public CallBackReportPage(WebDriver driver){
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
		Assert.assertTrue(header_label.isDisplayed(),"header label is not displayed or locator changed");
	}

	public void runButton(){

		wait.until(ExpectedConditions.visibilityOf(run_button));
		logger.log(LogStatus.INFO, "verifying if run_button is present");
		Assert.assertTrue(run_button.isDisplayed(),"run_button is not displayed or locator has been chamged..");
		logger.log(LogStatus.INFO, "verifying if run_button is enabled");
		Assert.assertTrue(run_button.isEnabled(),"run_button is not enabled");
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
    
    public void tilesVerification(){
    	
//    	for(int i=0;i<tiles_names.size();i++){
//    		
//    		for(int j=0;j<expected_tiles_names.length;j++){
//    			
//    			if(tiles_names.get(i).getText().equals(expected_tiles_names[j])){
//    				
//    				logger.log(LogStatus.INFO, "Verifying if "+expected_tiles_names[j]+" is present");
//    				softassert.assertTrue(tiles_names.get(i).getText().equals(expected_tiles_names[j]),"Tile "+expected_tiles_names[j]+" is not present");
//    			}
//    		}
//    		
//    	}
//    	softassert.assertAll();
    	
    	List<String> exp_tiles = new ArrayList<String>(Arrays.asList(expected_tiles_names));
		List<String> act_tiles = new ArrayList<String>();
		
		for(WebElement tiles_name:tiles_names) {
			act_tiles.add(tiles_name.getText().replaceAll("\\d", ""));
		}
		
		Collections.sort(exp_tiles);
		Collections.sort(act_tiles);
		
		Assert.assertEquals(act_tiles, exp_tiles);
    }
     
    //pg queris
    String endDateToBeUsed = null;
	String startDateToBeUsed = null;

	String total_call_count_from_db = null;
	String answered_calls_count_from_db = null;
	String avg_call_duration_from_db = null;
	String missed_opportuntity_from_db = null;
	String tagged_as_call_back_from_db = null;

    public void tileValueVerification(String tile_name){

        endDateToBeUsed = Util.getDate("yyyy-MM-dd","1");
    	startDateToBeUsed = Util.getDate("yyyy-MM-dd","-6");

    	total_call_count_from_db = Util.readingFromDB("SELECT count(*) as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 05:00' AND '"+endDateToBeUsed+" 04:00'");
    	answered_calls_count_from_db = Util.readingFromDB("SELECT count(*) as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 05:00' AND '"+endDateToBeUsed+" 04:00' AND disposition IN ('ANSWERED')");
    	avg_call_duration_from_db = Util.readingFromDB("SELECT AVG(duration) as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 05:00' AND '"+endDateToBeUsed+" 04:00'");
    	missed_opportuntity_from_db = Util.readingFromDB("SELECT count(*) as count FROM indicator_score WHERE call_id IN (SELECT call_id FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 05:00' AND '"+endDateToBeUsed+" 04:00') AND indicator_id='2065'");
    	tagged_as_call_back_from_db = Util.readingFromDB("SELECT COUNT(*) AS count FROM call_tag WHERE tag_id='9' AND call_tag_created BETWEEN '"+startDateToBeUsed+" 05:00' AND '"+endDateToBeUsed+" 04:00'");
    	
    	String tile_values= null;
	
		if(tile_name.equals("Missed Opportunity")) {
			tile_values = driver.findElement(By.xpath("//div[@class='react-grid-layout']//div[@data-testid='test-single-value-container']//div[@overflow='hidden']//span[starts-with(text(),'"+tile_name+"')]//ancestor::div[@class='Box-sc-5738oh-0 sc-dvCyap ceoGuo']//p/span")).getText();
		}else {
			tile_values = driver.findElement(By.xpath("//div[@class='react-grid-layout']//div[@data-testid='test-single-value-container']//div[@overflow='hidden']//p[text()='"+tile_name+"']//parent::div//parent::div//parent::div//span")).getText();			
		}
		
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
        
        else if(tile_name.equals("Missed Opportunity Calls")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(missed_opportuntity_from_db!=null){
				System.out.println(tile_values);
				System.out.println(missed_opportuntity_from_db);
				softassert.assertTrue(tile_values.equals(missed_opportuntity_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
        
        else if(tile_name.equals("Tagged as Call Back")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(tagged_as_call_back_from_db!=null){
				System.out.println(tile_values);
				System.out.println(tagged_as_call_back_from_db);
				softassert.assertTrue(tile_values.equals(tagged_as_call_back_from_db),"Tile count doest match with db count");			
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
				System.out.println(avg_call_duration_from_db.substring(0,avg_call_duration_from_db.indexOf('.')));
				softassert.assertTrue(tile_values.equals(avg_call_duration_from_db.substring(0,avg_call_duration_from_db.indexOf('.'))),"Tile count doest match with db count");			
			}
			else{
				System.out.println(tile_values);
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}

		softassert.assertAll();		
	}
    
    public void presenceOfMissedOpportunityOverTimeLabel(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Missed Opportunity Over Time Label is displayed");
    	Assert.assertTrue(missed_opportunity_over_time_label.isDisplayed(),"Missed Opportunity Over Time Label not displayed or locator changed");
    }
    
    public void presenceOfMissedOpportunityOverTimeGraph(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Missed Opportunity Over Time Graph is displayed");
    	softassert.assertTrue(missed_opportunity_over_time_graph.isDisplayed(),"Missed Opportunity Over Time Graph not displayed or locator changed");
    	softassert.assertTrue(missed_opportunity_call_legend.isDisplayed(),"missed_opportunity_call_legend is not present or locator changed");
    	softassert.assertTrue(total_calls_legend.isDisplayed(),"total_calls_legend is not present or locator changed");
    	softassert.assertAll();
    }
    
    public void presenceOfMissedOpportunitySummaryLabel(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Missed Opportunity Summary Label is displayed");
    	Assert.assertTrue(missed_opportunity_summary_label.isDisplayed(),"Missed Opportunity Summary Label not displayed or locator changed");
    }
    
    public void presenceOfTaggedAsCallBackLabel(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Tagged As Call Back Label is displayed");
    	Assert.assertTrue(tagged_as_callback_table_label.isDisplayed(),"Tagged As Call Back Label not displayed or locator changed");
    }
    
    public void filterButton(){
		
		wait.until(ExpectedConditions.visibilityOf(filter_button));
	    logger.log(LogStatus.INFO, "verifying if filter_button is present");
	    softassert.assertTrue(filter_button.isDisplayed(), "filter_button is not present");

	    logger.log(LogStatus.INFO, "verifying if filter_button is enabled");
	    softassert.assertTrue(filter_button.isEnabled(), "filter_button is not enabled");	    
	}
    
    public void filterElements(){

    	expandFilterSection();
    	List<String> exp_filter_elements_after_expanding = new ArrayList<String>(Arrays.asList(expected_filter_elements_after_expanding));
	    List<String> act_filter_elements_after_expanding = new ArrayList<String>();
	    
	    for(WebElement filter_element_after_expanding:filter_elements_after_expanding) {
	    	act_filter_elements_after_expanding.add(filter_element_after_expanding.getText());
	    }
	    
	    Collections.sort(exp_filter_elements_after_expanding);
	    Collections.sort(act_filter_elements_after_expanding);
	    
	    Assert.assertEquals(act_filter_elements_after_expanding, exp_filter_elements_after_expanding);
    	collpaseFilterSection();
    }
    
    public void missedOppTableColumnVerification() throws InterruptedException{
    	
		Thread.sleep(2000);
		if(missed_opportuntity_from_db != null) {
			List<String> exp_missed_opportunity_summary_table_columns = new ArrayList<String>(Arrays.asList(expected_missed_opportunity_summary_table_columns));
		    List<String> act_missed_opportunity_summary_table_columns = new ArrayList<String>();
		    
		    for(WebElement missed_opportunity_summary_table_column:missed_opportunity_summary_table_columns) {
		    	act_missed_opportunity_summary_table_columns.add(missed_opportunity_summary_table_column.getText());
		    }
		    
		    Collections.sort(exp_missed_opportunity_summary_table_columns);
		    Collections.sort(act_missed_opportunity_summary_table_columns);
		    
		    Assert.assertEquals(act_missed_opportunity_summary_table_columns, exp_missed_opportunity_summary_table_columns);	
		}else {
			logger.log(LogStatus.INFO, "No data found in table");
		}
		
	}

    
    public void taggedAsCallBackTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		if(tagged_as_call_back_from_db != null) {
			List<String> exp_tagged_as_callback_table_columns = new ArrayList<String>(Arrays.asList(expected_tagged_as_callback_table_columns));
		    List<String> act_tagged_as_callback_table_columns = new ArrayList<String>();
		    
		    for(WebElement tagged_as_callback_table_column:tagged_as_callback_table_columns) {
		    	act_tagged_as_callback_table_columns.add(tagged_as_callback_table_column.getText());
		    }
		    
		    Collections.sort(exp_tagged_as_callback_table_columns);
		    Collections.sort(act_tagged_as_callback_table_columns);
		    
		    Assert.assertEquals(act_tagged_as_callback_table_columns, exp_tagged_as_callback_table_columns);	
		}else {
			logger.log(LogStatus.INFO, "No data found in table");			
		}		
	}

    public void filterFeatureForTaggedAsCallBack(String filterName) throws InterruptedException{

    	if(tagged_as_call_back_from_db != null ){
    		
    		if(tagged_as_call_back_from_db.equals("0")) {
        		logger.log(LogStatus.INFO, "Verifying if no results label is displayed since there is no data to filter");
        		Assert.assertTrue(no_results_label_for_tagged_as_callback_table.isDisplayed(),"no results label is not displayed or locator changed");    			
    		}else {
        		//getting value from grid
        		int index=0;
                String filterValue;
        		for(int i=0;i<tagged_as_callback_table_columns.size();i++){
        			
        			if(filterName.equals(tagged_as_callback_table_columns.get(i).getText())){
        				
        				index=i+1;
        				break;
        			}
        		}
        		List<WebElement> value_to_be_filtered = driver.findElements(By.xpath("//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]"));		
        		filterValue=value_to_be_filtered.get(0).getText();
        		
        		//expanding filter section
        		expandFilterSection();
        		
        		//applying filter value
        		WebElement filter_link = driver.findElement(By.xpath("//h6[text()='"+filterName+"']//parent::div//following-sibling::span")); 
        		wait.until(ExpectedConditions.visibilityOf(filter_link));
                Util.Action().moveToElement(filter_link).perform();
                Util.Action().click().perform();
                Util.enterText(filter_text_box, filterValue);
                
                //re running for applied filter
        		run_button.click();
        		
        		//collapsing filter section
        		collpaseFilterSection();
        		waitTillReportLoad();

        		//checking populated values
        		List<WebElement> filtered_values = driver.findElements(By.xpath("//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]"));
        		System.out.println("//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]");
        		for(int j=0;j<filtered_values.size();j++){
        			
        			System.out.println(filtered_values.get(j).getText());
        			System.out.println(filterValue);
        			logger.log(LogStatus.INFO, "Verifying if "+filtered_values.get(j).getText()+" is matching with "+filterValue);
        			softassert.assertTrue(filtered_values.get(j).getText().equals(filterValue),"value "+filtered_values.get(j).getText()+" is not filtered value");
        		}
        		
        		softassert.assertAll();

        		//expanding filter
        		expandFilterSection();
        		
        		//clearing applied filter
        		filter_link = driver.findElement(By.xpath("//h6[text()='"+filterName+"']//parent::div//following-sibling::span"));
        		Util.customWait(filter_link);
                Util.Action().moveToElement(filter_link).perform();
                Util.Action().click().perform();
                Thread.sleep(1000);
                Util.Action().moveToElement(filter_text_box).perform();
        	    Util.Action().sendKeys(Keys.BACK_SPACE).perform();
                Util.Action().sendKeys(Keys.BACK_SPACE).perform();
        		Util.Action().sendKeys(Keys.ESCAPE).perform();	
        	
        		//collapsing filter section
        		collpaseFilterSection();
    		}

    	}
    	else{
    		logger.log(LogStatus.INFO, "Verifying if no results label is displayed since there is no data to filter");
    		Assert.assertTrue(no_results_label_for_tagged_as_callback_table.isDisplayed(),"no results label is not displayed or locator changed");    			
    	}
    	        
	}
    
    
    public void filterFeatureForMissedOppSummary(String filterName) throws InterruptedException{

    	if(missed_opportuntity_from_db != null){
    		
    		if(missed_opportuntity_from_db.equals("0")) {
        		logger.log(LogStatus.INFO, "Verifying if no results label is displayed since there is no data to filter");
        		Assert.assertTrue(no_results_label_for_missed_opportunity_summary_table.isDisplayed(),"no results label is not displayed or locator changed");    			
    		}else {
    			//getting value from grid
        		int index=0;
                String filterValue;
        		for(int i=0;i<tagged_as_callback_table_columns.size();i++){
        			
        			if(filterName.equals(tagged_as_callback_table_columns.get(i).getText())){
        				
        				index=i+1;
        				break;
        			}
        		}
        		List<WebElement> value_to_be_filtered = driver.findElements(By.xpath("//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]"));		
        		filterValue=value_to_be_filtered.get(0).getText();
        		
        		//expanding filter section
        		expandFilterSection();
        		
        		//applying filter value
        		WebElement filter_link = driver.findElement(By.xpath("x")); 
        		wait.until(ExpectedConditions.visibilityOf(filter_link));
                Util.Action().moveToElement(filter_link).perform();
                Util.Action().click().perform();
                Util.enterText(filter_text_box, filterValue);
                
                //re running for applied filter
        		run_button.click();
        		
        		//collapsing filter section
        		collpaseFilterSection();
        		waitTillReportLoad();

        		//checking populated values
        		List<WebElement> filtered_values = driver.findElements(By.xpath("//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]"));
        		System.out.println("//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]");
        		for(int j=0;j<filtered_values.size();j++){
        			
        			System.out.println(filtered_values.get(j).getText());
        			System.out.println(filterValue);
        			logger.log(LogStatus.INFO, "Verifying if "+filtered_values.get(j).getText()+" is matching with "+filterValue);
        			softassert.assertTrue(filtered_values.get(j).getText().equals(filterValue),"value "+filtered_values.get(j).getText()+" is not filtered value");
        		}
        		
        		softassert.assertAll();

        		//expanding filter
        		expandFilterSection();
        		
        		//clearing applied filter
        		filter_link = driver.findElement(By.xpath("//h6[text()='"+filterName+"']//parent::div//following-sibling::span"));
        		Util.customWait(filter_link);
                Util.Action().moveToElement(filter_link).perform();
                Util.Action().click().perform();
                Thread.sleep(1000);
                Util.Action().moveToElement(filter_text_box).perform();
        	    Util.Action().sendKeys(Keys.BACK_SPACE).perform();
                Util.Action().sendKeys(Keys.BACK_SPACE).perform();
        		Util.Action().sendKeys(Keys.ESCAPE).perform();	
        	
        		//collapsing filter section
        		collpaseFilterSection();
    		}

    	}
    
    	else{
    		logger.log(LogStatus.INFO, "Verifying if no results label is displayed since there is no data to filter");
    		Assert.assertTrue(no_results_label_for_missed_opportunity_summary_table.isDisplayed(),"no results label is not displayed or locator changed");   
    	}
    	
	}
    
    public void expandFilterSection() {
		if(filter_button.getAttribute("class").endsWith("kqUKfT")) {
			filter_button.click();
		}
	}
	
	
	public void collpaseFilterSection() {
		if(filter_button.getAttribute("class").endsWith("OSCdE")) {
			filter_button.click();
		}
	}
	
	public void waitTillReportLoad() {
		
		wait.until(ExpectedConditions.visibilityOf(reload_button));
		
	}
    
    
}
