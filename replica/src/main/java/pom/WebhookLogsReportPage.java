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

public class WebhookLogsReportPage extends TestBase{
	
	@FindBy(xpath="(//div[@class='title-main']//span[text()='Webhook Logs'])")
	private WebElement header_label;
	
	@FindBy(xpath="//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span")
	private List<WebElement> tiles_names;
	
	String [] expected_tiles_names={"Total Calls","Pre-call Webhooks Sent","Post-call Webhooks Sent"};
	
	@FindBy(xpath="//div[@class='vis-header']//span[text()='Webhook Summary']")
	private WebElement webhook_summary_label;	

	@FindBy(xpath="(//div[@class='ag-grid-container'])[1]//div[@class='ag-header-container']//strong")
	private List<WebElement> webhook_summary_table_columns;	
	
	String[] expected_webhook_summary_table_columns={"Webhook","End Point URL","Times Executed"};
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[1]//span[text()='No Results']")
	private WebElement no_results_label_for_webhhok_summary_table;
	
	@FindBy(xpath="//div[@class='vis-header']//span[text()='Webhook Logs']")
	private WebElement webhook_logs_label;	

	@FindBy(xpath="(//div[@class='ag-grid-container'])[2]//div[@class='ag-header-container']//strong")
	private List<WebElement> webhook_logs_table_columns;
	
	String[] expected_webhook_logs_table_columns={"Webhook","Date/Time Executed","Type","End Point URL","Status"};

	@FindBy(xpath="(//div[@class='ag-grid-container'])[2]//span[text()='No Results']")
	private WebElement no_results_label_for_webhhok_logs_table;
	
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
	
	String[] expected_filter_elements_after_expanding={"Date Range","Webhook","Webhook Status"};
	
	SoftAssert softassert=new SoftAssert(); 

	public WebhookLogsReportPage(WebDriver driver){
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

    public void runButton(){

		wait.until(ExpectedConditions.visibilityOf(run_button));
		logger.log(LogStatus.INFO, "verifying if run_button is present");
		Assert.assertTrue(run_button.isDisplayed(),"run_button is not displayed or locator has been chamged..");
		logger.log(LogStatus.INFO, "verifying if run_button is enabled");
		Assert.assertTrue(run_button.isEnabled(),"run_button is not enabled");
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

	String total_call_count_from_db = Util.readingFromDB("SELECT count(*) AS count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
	String pre_call_webhook_count_from_db = Util.readingFromDB("SELECT count(*) AS count FROM v_webhook_logs WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND log_date BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59' AND type LIKE 'Pre Call Webhook'");
	String post_call_webhook_count_from_db = Util.readingFromDB("SELECT count(*) AS count FROM v_webhook_logs WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND log_date BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59' AND type LIKE 'Post Call Webhook'");
//  -------------------------------------------------------------------------------------------------------------------- 
   
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
        
        else if(tile_name.equals("Pre-call Webhooks Sent")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(pre_call_webhook_count_from_db!=null){
				System.out.println(tile_values);
				System.out.println(pre_call_webhook_count_from_db);
				softassert.assertTrue(tile_values.equals(pre_call_webhook_count_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
        
        else if(tile_name.equals("Post-call Webhooks Sent")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(post_call_webhook_count_from_db!=null){
				System.out.println(tile_values);
				System.out.println(post_call_webhook_count_from_db);
				softassert.assertTrue(tile_values.equals(post_call_webhook_count_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}	
		}
      
    	softassert.assertAll();		
    	    	
	}
    
    public void webhookSummaryLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if Webhook Summary Label is present");
		Assert.assertTrue(webhook_summary_label.isDisplayed(),"Webhook Summary is not present or locator has been changed.");
	}
    
    public void webhookLogsLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if Webhook Logs Label is present");
		Assert.assertTrue(webhook_logs_label.isDisplayed(),"Webhook Logs is not present or locator has been changed.");
	}
    
    public void webhookSummaryTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<webhook_summary_table_columns.size();i++){
			
			for(int j=0;j<expected_webhook_summary_table_columns.length;j++){
				
				if(webhook_summary_table_columns.get(i).getText().equals(expected_webhook_summary_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_webhook_summary_table_columns[j]+" is present");
					softassert.assertTrue(webhook_summary_table_columns.get(i).getText().equals(expected_webhook_summary_table_columns[j]),"Column "+expected_webhook_summary_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
    
    public void webhookLogsTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<webhook_logs_table_columns.size();i++){
			
			for(int j=0;j<expected_webhook_logs_table_columns.length;j++){
				
				if(webhook_logs_table_columns.get(i).getText().equals(expected_webhook_logs_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_webhook_logs_table_columns[j]+" is present");
					softassert.assertTrue(webhook_logs_table_columns.get(i).getText().equals(expected_webhook_logs_table_columns[j]),"Column "+expected_webhook_logs_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
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
    
    public void filterFeatureForWebhookSummaryTable(String filterName) throws InterruptedException{

    	if(pre_call_webhook_count_from_db.equals("0")){
    		
    		logger.log(LogStatus.INFO, "Verifying if no results label is displayed since there is no data to filter");
    		Assert.assertTrue(no_results_label_for_webhhok_summary_table.isDisplayed(),"no results label is not displayed or locator changed");
    	}
    	else{
    		int index=0;
            String filterValue;
    		for(int i=0;i<webhook_summary_table_columns.size();i++){
    			
    			if(filterName.equals(webhook_summary_table_columns.get(i).getText())){
    				
    				index=i+1;
    				break;
    			}
    		}
    		List<WebElement> value_to_be_filtered = driver.findElements(By.xpath("(//div[@class='ag-grid-container'])[1]//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]"));		
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
    		
    	
    		List<WebElement> filtered_values = driver.findElements(By.xpath("(//div[@class='ag-grid-container'])[1]//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]"));
    		System.out.println("(//div[@class='ag-grid-container'])[1]//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]");
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

    public void filterFeatureForWebhookLogsTable(String filterName) throws InterruptedException{

    	if(pre_call_webhook_count_from_db.equals("0")){
    		
    		logger.log(LogStatus.INFO, "Verifying if no results label is displayed since there is no data to filter");
    		Assert.assertTrue(no_results_label_for_webhhok_logs_table.isDisplayed(),"no results label is not displayed or locator changed");
    	}
    	else{
    		int index=0;
            String filterValue;
    		for(int i=0;i<webhook_logs_table_columns.size();i++){
    			
    			if(filterName.endsWith(webhook_logs_table_columns.get(i).getText())){
    				
    				index=i+1;
    				break;
    			}
    		}
    		List<WebElement> value_to_be_filtered = driver.findElements(By.xpath("(//div[@class='ag-grid-container'])[2]//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]"));		
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
    		
    	
    		List<WebElement> filtered_values = driver.findElements(By.xpath("(//div[@class='ag-grid-container'])[2]//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]"));
    		System.out.println("(//div[@class='ag-grid-container'])[2]//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]");
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
