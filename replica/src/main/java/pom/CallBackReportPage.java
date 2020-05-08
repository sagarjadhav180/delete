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

@SuppressWarnings("unused")
public class CallBackReportPage extends TestBase{
	
	@FindBy(xpath="//button[@class='btn run-button embed-view btn-primary'][text()='Run']")
	private WebElement run_button;

	@FindBy(xpath="(//div[@class='title-main']//span[text()='Call Back'])")
	private WebElement header_label;
	
	@FindBy(xpath="//div[@class='dropdown-toggle button-xs']/i")
	private WebElement gear_icon;

	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-wide pull-right']//li//a")
	private List<WebElement> gear_icon_options;
	
	String[] expected_gear_icon_options={"Download as PDF...","Download as CSVs","Send","Schedule","Move to Trash"};

	@FindBy(xpath="//span[@class='timezone']")
	private WebElement timezone;
	
	@FindBy(xpath="//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span")
	private List<WebElement> tiles_names;	
	
	String[] expected_tiles_names={"Total Calls","Answered Calls","Average Call Duration","Missed Opportunity Calls","Tagged as Call Back"};
	
	@FindBy(xpath="//span[text()='Missed Opportunity Over Time']")
	private WebElement missed_opportunity_over_time_label;	
	
	@FindBy(xpath="//div[starts-with(@id,'highcharts')]")
	private WebElement missed_opportunity_over_time_graph;	

	@FindBy(xpath="(//span[text()='Missed Opportunity Calls'])[3]")
	private WebElement missed_opportunity_call_legend;	
	
	@FindBy(xpath="(//span[text()='Total Calls'])[3]")
	private WebElement total_calls_legend;	

	@FindBy(xpath="//span[text()='Missed Opportunity Summary']")
	private WebElement missed_opportunity_summary_label;	

	@FindBy(xpath="(//div[@class='grid-element'][7]//div[@class='ag-header-row'])[2]//span[@class='column-label']//strong")
	private List<WebElement> missed_opportunity_summary_table_columns;	
	
	String[] expected_missed_opportunity_summary_table_columns={"Play Call","Caller Id","Date/Time","Duration","Repeat Call","Group","Group External Id","Campaign","Campaign External Id","Tracking Number Name","Tracking Number","Ad Source","Ring-to Name","Ring-to Number","Number Of Repeat Calls"};

	@FindBy(xpath="//div[@class='grid-element'][7]//span[text()='No Results']")
	private WebElement no_results_label_for_missed_opportunity_summary_table;	

	@FindBy(xpath="(//span[text()='Tagged as Call Back'])[2]")
	private WebElement tagged_as_callback_table_label;	

	@FindBy(xpath="(//div[@class='grid-element'][7]//div[@class='ag-header-row'])[2]//span[@class='column-label']//strong")
	private List<WebElement> tagged_as_callback_table_columns;
	
	String[] expected_tagged_as_callback_table_columns={"Actions","Play Call","Caller Id","Date/Time","Type","Group","Group External Id","Campaign","Campaign External Id","Ad Source","Tracking Number Name","Tracking Number","Duration","Identified Agent","Tags","Comment"};
	
	@FindBy(xpath="//div[@class='grid-element'][8]//span[text()='No Results']")
	private WebElement no_results_label_for_tagged_as_callback_table;
	
	@FindBy(xpath="//strong[@class='filter-section-title']//i")
	private WebElement filter_button;
	
	@FindBy(xpath="//table[@class='explore-filters clearfix']//tbody//tr//td[@class='filter-name']")
	private List<WebElement> filter_elements_after_expanding;
	
	String[] expected_filter_elements_after_expanding={"Date Range","Stack Column By","Ad Source","Call ID","Campaign","Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5","Duration","Group","Indicator","Ring-to Name","Ring-to Number","Tags","Tracking Number Name","Tracking Number","User"};
	
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
        
    String endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
	String startDateToBeUsed = Util.getDate("yyyy-MM-dd","-7");

	String total_call_count_from_db = Util.readingFromDB("SELECT count(*) as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
	String answered_calls_count_from_db = Util.readingFromDB("SELECT count(*) as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59' AND disposition IN ('ANSWERED')");
	String avg_call_duration_from_db = Util.readingFromDB("SELECT ROUND(AVG(duration)) as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
	String missed_opportuntity_from_db = Util.readingFromDB("SELECT count(*) as count FROM indicator_score WHERE call_id IN (SELECT call_id FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59') AND indicator_id='2065'");
	String tagged_as_call_back_from_db = Util.readingFromDB("SELECT COUNT(*) AS count FROM call_tag WHERE tag_id='9' AND call_tag_created BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");

    
    public void tileValueVerification(String tile_name){
		
    	
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
				System.out.println(avg_call_duration_from_db);
				softassert.assertTrue(tile_values.equals(avg_call_duration_from_db),"Tile count doest match with db count");			
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
    
    public void missedOppTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<missed_opportunity_summary_table_columns.size();i++){
			
			for(int j=0;j<expected_missed_opportunity_summary_table_columns.length;j++){
				
				if(missed_opportunity_summary_table_columns.get(i).getText().equals(expected_missed_opportunity_summary_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_missed_opportunity_summary_table_columns[j]+" is present");
					softassert.assertTrue(missed_opportunity_summary_table_columns.get(i).getText().equals(expected_missed_opportunity_summary_table_columns[j]),"Column "+expected_missed_opportunity_summary_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}

    public void taggedAsCallBackTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<tagged_as_callback_table_columns.size();i++){
			
			for(int j=0;j<expected_tagged_as_callback_table_columns.length;j++){
				
				if(tagged_as_callback_table_columns.get(i).getText().equals(expected_tagged_as_callback_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_tagged_as_callback_table_columns[j]+" is present");
					softassert.assertTrue(tagged_as_callback_table_columns.get(i).getText().equals(expected_tagged_as_callback_table_columns[j]),"Column "+expected_tagged_as_callback_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}

    public void filterFeatureForTaggedAsCallBack(String filterName) throws InterruptedException{

    	if(tagged_as_call_back_from_db.equals("0")){
    		
    		logger.log(LogStatus.INFO, "Verifying if no results label is displayed since there is no data to filter");
    		Assert.assertTrue(no_results_label_for_tagged_as_callback_table.isDisplayed(),"no results label is not displayed or locator changed");
    	}
    	else{
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
    		
    	
    		List<WebElement> filtered_values = driver.findElements(By.xpath("//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]"));
    		System.out.println("//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]");
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
    
    public void filterFeatureForMissedOppSummary(String filterName) throws InterruptedException{

    	if(missed_opportuntity_from_db.equals("0")){
    		logger.log(LogStatus.INFO, "Verifying if no results label is displayed since there is no data to filter");
    		Assert.assertTrue(no_results_label_for_missed_opportunity_summary_table.isDisplayed(),"no results label is not displayed or locator changed");
    	}
    
    	else{
    		int index=0;
            String filterValue;
    		for(int i=0;i<missed_opportunity_summary_table_columns.size();i++){
    			
    			if(filterName.equals(missed_opportunity_summary_table_columns.get(i).getText())){
    				
    				index=i+1;
    				break;
    			}
    		}
    		List<WebElement> value_to_be_filtered = driver.findElements(By.xpath("//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]"));		
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
    		
    	
    		List<WebElement> filtered_values = driver.findElements(By.xpath("//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]"));
    		System.out.println("//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]");
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
