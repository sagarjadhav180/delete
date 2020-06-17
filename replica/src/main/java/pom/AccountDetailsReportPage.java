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

public class AccountDetailsReportPage extends TestBase{

	@FindBy(xpath="(//div[@class='title-main']//span[text()='Account Details'])")
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

	String[] expected_filter_elements_after_expanding={"Date Range","Stack Columns By","Group Pie Chart By","Campaign","Campaign Status","Group","Group Status","Hunt Type","Ring-to Number","Tracking Number Name","Tracking Number","Tracking Number Status","Tracking Number Type"};
	
	@FindBy(xpath="//div[@class='title-text'][text()='Group Settings']")
	private WebElement group_settings_label;
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[1]//div[@class='ag-header-container']//strong")
	private List<WebElement> group_settings_table_columns;
	
	String[] expected_group_settings_table_columns={"Group","Group Status","External ID","Industry","Phone","City","State/Province","Zip/Postal Code"};

	@FindBy(xpath="//div[@class='title-text'][text()='Campaign Settings']")
	private WebElement campaign_settings_label;

	@FindBy(xpath="//div[@class='grid-element'][position()>=4 and not (position()>7)]//div[@class='vis-single-value-title']//span[@class='looker-vis-context-title-text ']")
	private List<WebElement> campaign_settings_tiles;
	
	String[] expected_campaign_settings_tiles={"Active Campaigns","Pending Campaigns","Referral Campaigns","Inactive Campaigns"};
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[2]//div[@class='ag-header-container']//strong")
	private List<WebElement> campaign_settings_table_columns;

	String[] expected_campaign_settings_table_columns={"Campaign","Campaign ID","Campaign External Id","Campaign Owner","Campaign Status","Campaign Start Date","Campaign End Date","Group","Referral Period","Referral Number"};
	
	@FindBy(xpath="//div[@class='title-text'][text()='Tracking Number Settings']")
	private WebElement tn_settings_label;

	@FindBy(xpath="//div[@class='grid-element'][position()>=8 and not (position()>11)]//div[@class='vis-single-value-title']//span[@class='looker-vis-context-title-text ']")
	private List<WebElement> tn_settings_tiles;
	
	String[] expected_tn_settings_tiles={"Active Tracking Number","Inactive Tracking Number"};
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[3]//div[@class='ag-header-container']//strong")
	private List<WebElement> tn_table_columns;
	
	String[] expected_tn_table_columns={"Tracking Number ID","Tracking Number Name","Tracking Number","Group","Campaign","Tracking Number Type","Tracking Number Status","Ring-to Number","Ad Source","Record Call","Play Disclaimer","Voice Prompt (Yes / No)","Whisper Enabled (Yes / No)","DNI"};
	
	@FindBy(xpath="//div[@class='title-text'][text()='Billing Usage']")
	private WebElement billing_usage_label;

	@FindBy(xpath="//div[@class='grid-element'][position()>=13 and not (position()>21)]//div[@class='vis-single-value-title']//span[@class='looker-vis-context-title-text ']")
	private List<WebElement> billing_usage_tiles;
	
	String[] expected_billing_usage_tiles={"Total Numbers","Local/Toll-free Numbers","Premium Numbers","Reserved Numbers","Total Calls","Total Billable Minutes","Local/Toll Free Minutes","Premium Minutes"};
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[4]//div[@class='ag-header-container']//strong")
	private List<WebElement> usage_summary_by_group_table_columns;
	
	String[] expected_usage_summary_by_group_table_columns={"Group","Group External Id","Total Calls","Billable Minutes","Local/Toll Free Minutes Actual","Premium Minutes"};

	@FindBy(xpath="//span[@class='looker-vis-context-title-text '][text()='Usage Summary by Group']")
	private WebElement usage_summary_by_group_label;
	
	@FindBy(xpath="//span[@class='looker-vis-context-title-text '][text()='Configurations Summary by Group']")
	private WebElement config_summary_by_group_label;

	@FindBy(xpath="(//div[@class='ag-grid-container'])[5]//div[@class='ag-header-container']//strong")
	private List<WebElement> config_summary_By_group_table_columns;
	
	String[] expected_config_summary_By_group_table_columns={"Group","Group External Id","Total Number","Local/Toll Free Numbers","Premium Numbers","Total Reserved Number","Total Users"};

	@FindBy(xpath="//span[@class='looker-vis-context-title-text '][text()='Usage by Tracking Number']")
	private WebElement usage_by_tn_label;

	@FindBy(xpath="//div[@class='grid-element'][position()>=25 and not (position()>29)]//div[@class='vis-single-value-title']//span[@class='looker-vis-context-title-text ']")
	private List<WebElement> usage_by_tn_tiles;
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[6]//div[@class='ag-header-container']//strong")
	private List<WebElement> usage_by_tn_table_columns;
	
	String[] expected_usage_by_tn_table_columns={"Tracking Number Name","Tracking Number","Tracking Number Status","Group","Group External ID","Campaign","Campaign External ID","Number Type","Tracking Number Type","Total Calls","Analyzed Calls","Total Billable Minutes"};

	@FindBy(xpath="//div[@class='title-text'][text()='Call Trends']")
	private WebElement call_trends_label;

	@FindBy(xpath="//div[@class='grid-element'][position()>=25 and not (position()>35)]//div[@class='vis-single-value-title']//span[@class='looker-vis-context-title-text ']")
	private List<WebElement> call_trends_tiles;
	
	String [] expected_call_trends_tiles={"Total Calls","Unique Calls","Answered Calls","Unanswered Calls","Peak Day","Peak Hour","Longest Call","Average Call Duration"};
	
	@FindBy(xpath="//div[@class='title-text'][text()='Call Trends']")
	private WebElement calls_over_time_by_day_label;
	
	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[1]")
	private WebElement calls_over_time_by_day_graph;	
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[7]//div[@class='ag-header-container']//strong")
	private List<WebElement> calls_over_time_by_day_table_columns;
	
	String[] expected_calls_over_time_by_day_table_columns={"Days","Repeat Calls","Unique Calls"};
	
	@FindBy(xpath="(//div[@class='vis-header']//span[text()='Calls Over Time by Hour'])[1]")
	private WebElement calls_over_time_by_hour_label;
	
	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[2]")
	private WebElement calls_over_time_by_hour_graph;
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[8]//div[@class='ag-header-container']//strong")
	private List<WebElement> calls_over_time_by_hour_table_columns;
	
	String[] expected_calls_over_time_by_hour_table_columns={"Hours","Repeat Calls","Unique Calls"};
	
	@FindBy(xpath="(//div[@class='vis-header']//span[text()='Calls-Mix'])")
	private WebElement calls_mix_label;
	
	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[3]")
	private WebElement calls_mix_graph;	
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[9]//div[@class='ag-header-container']//strong")
	private List<WebElement> calls_mix_table_columns;
	
	String[] expected_calls_mix_table_columns={"Call Type","Group","Campaign","Tracking Number Name","Tracking Number","Total Calls","Total Calls"};
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[9]//span[text()='No Results']")
	private WebElement no_results_label_for_call_mix_table;	
	
	
	SoftAssert softassert=new SoftAssert(); 

	public AccountDetailsReportPage(WebDriver driver){
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

	public void runButton(){

		wait.until(ExpectedConditions.visibilityOf(run_button));
		logger.log(LogStatus.INFO, "verifying if run_button is present");
		Assert.assertTrue(run_button.isDisplayed(),"run_button is not displayed or locator has been chamged..");
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
    
    public void groupSettingsLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if Group Settings Label is present");
		Assert.assertTrue(group_settings_label.isDisplayed(),"Group Settings label is not present or locator has been changed.");
	}
	
    public void groupSettingsTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<group_settings_table_columns.size();i++){
			
			for(int j=0;j<expected_group_settings_table_columns.length;j++){
				
				if(group_settings_table_columns.get(i).getText().equals(expected_group_settings_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_group_settings_table_columns[j]+" is present");
					softassert.assertTrue(group_settings_table_columns.get(i).getText().equals(expected_group_settings_table_columns[j]),"Column "+expected_group_settings_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
    
    public void campaignSettingsLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if Campaign Settings Label is present");
		Assert.assertTrue(campaign_settings_label.isDisplayed(),"Campaign Settings label is not present or locator has been changed.");
	}
    
    public void campaignSettingstilesVerification(){
    	
    	for(int i=0;i<campaign_settings_tiles.size();i++){
    		
    		for(int j=0;j<expected_campaign_settings_tiles.length;j++){
    			
    			if(campaign_settings_tiles.get(i).getText().startsWith(expected_campaign_settings_tiles[j])){
    				
    				logger.log(LogStatus.INFO, "Verifying if "+expected_campaign_settings_tiles[j]+" is present");
    				softassert.assertTrue(campaign_settings_tiles.get(i).getText().startsWith(expected_campaign_settings_tiles[j]),"Tile "+expected_campaign_settings_tiles[j]+" is not present");
    			}
    		}
    		
    	}
    	softassert.assertAll();
    }
    
    public void campaignAndTNTileValueVerification(String tile_name){
		
		String active_campaigns_count_from_db = Util.readingFromDB("SELECT COUNT (DISTINCT(campaign_id)) AS count FROM campaign_provisioned_route WHERE campaign_id IN (SELECT campaign_id FROM campaign WHERE campaign_ou_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND campaign_status='active')");
		String active_tracking_numbers_count_from_db = Util.readingFromDB("SELECT COUNT (provisioned_route_id) AS count FROM campaign_provisioned_route WHERE campaign_id IN (SELECT campaign_id FROM campaign WHERE campaign_ou_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND campaign_status='active') AND provisioned_route_id IN (SELECT provisioned_route_id FROM provisioned_route WHERE provisioned_route_status='active' )");
		String inactive_campaigns_count_from_db = Util.readingFromDB("SELECT COUNT (DISTINCT(campaign_id)) AS count FROM campaign_provisioned_route WHERE campaign_id IN (SELECT campaign_id FROM campaign WHERE campaign_ou_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND campaign_status='inactive')");
		String inactive_tracking_numbers_count_from_db = Util.readingFromDB("SELECT COUNT (provisioned_route_id) AS count FROM campaign_provisioned_route WHERE campaign_id IN (SELECT campaign_id FROM campaign WHERE campaign_ou_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND campaign_status='active') AND provisioned_route_id IN (SELECT provisioned_route_id FROM provisioned_route WHERE provisioned_route_status='inactive')");
		
		String tile_values=driver.findElement(By.xpath("//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span[text()='"+tile_name+"']//parent::Div//parent::div/preceding-sibling::div//a")).getText();
	
		if(tile_name.equals("Active Campaigns")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(active_campaigns_count_from_db!=null){
				System.out.println(tile_values);
				System.out.println(active_campaigns_count_from_db);
				softassert.assertTrue(tile_values.equals(active_campaigns_count_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
		else if(tile_name.equals("Active Tracking Numbers")){
			
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(active_tracking_numbers_count_from_db!=null){
				System.out.println(tile_values);
				System.out.println(active_tracking_numbers_count_from_db);
				softassert.assertTrue(tile_values.equals(active_tracking_numbers_count_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
		else if(tile_name.equals("Inactive Campaigns")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(inactive_campaigns_count_from_db!=null){
				System.out.println(tile_values);
				System.out.println(inactive_campaigns_count_from_db);
				softassert.assertTrue(tile_values.equals(inactive_campaigns_count_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
		else if(tile_name.equals("Inactive Tracking Numbers")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(inactive_tracking_numbers_count_from_db!=null){
				System.out.println(tile_values);
				System.out.println(inactive_tracking_numbers_count_from_db);
				softassert.assertTrue(tile_values.equals(inactive_tracking_numbers_count_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}

			
			
		}
		
		softassert.assertAll();		

	}
    
    
    public void campaignSettingsTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<campaign_settings_table_columns.size();i++){
			
			for(int j=0;j<expected_campaign_settings_table_columns.length;j++){
				
				if(campaign_settings_table_columns.get(i).getText().equals(expected_campaign_settings_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_campaign_settings_table_columns[j]+" is present");
					softassert.assertTrue(campaign_settings_table_columns.get(i).getText().equals(expected_campaign_settings_table_columns[j]),"Column "+expected_campaign_settings_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
    
    public void tnSettingsLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if Tracking Number Settings Label is present");
		Assert.assertTrue(tn_settings_label.isDisplayed(),"Tracking Number Settings label is not present or locator has been changed.");
	}
    
    public void tnSettingstilesVerification(){
    	
    	for(int i=0;i<tn_settings_tiles.size();i++){
    		
    		for(int j=0;j<expected_tn_settings_tiles.length;j++){
    			
    			if(tn_settings_tiles.get(i).getText().startsWith(expected_tn_settings_tiles[j])){
    				
    				logger.log(LogStatus.INFO, "Verifying if "+expected_tn_settings_tiles[j]+" is present");
    				softassert.assertTrue(tn_settings_tiles.get(i).getText().startsWith(expected_tn_settings_tiles[j]),"Tile "+expected_tn_settings_tiles[j]+" is not present");
    			}
    		}
    		
    	}
    	softassert.assertAll();
    }
    
    public void tnSettingsTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<tn_table_columns.size();i++){
			
			for(int j=0;j<expected_tn_table_columns.length;j++){
				
				if(tn_table_columns.get(i).getText().equals(expected_tn_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_tn_table_columns[j]+" is present");
					softassert.assertTrue(tn_table_columns.get(i).getText().equals(expected_tn_table_columns[j]),"Column "+expected_tn_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
    
    public void billingUsageLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if Billing Usage Label is present");
		Assert.assertTrue(billing_usage_label.isDisplayed(),"Billing Usage label is not present or locator has been changed.");
	}
    
    public void billingUsagetilesVerification(){
    	
    	for(int i=0;i<billing_usage_tiles.size();i++){
    		
    		for(int j=0;j<expected_billing_usage_tiles.length;j++){
    			
    			if(billing_usage_tiles.get(i).getText().startsWith(expected_billing_usage_tiles[j])){
    				
    				logger.log(LogStatus.INFO, "Verifying if "+expected_billing_usage_tiles[j]+" is present");
    				softassert.assertTrue(billing_usage_tiles.get(i).getText().startsWith(expected_billing_usage_tiles[j]),"Tile "+expected_billing_usage_tiles[j]+" is not present");
    			}
    		}
    		
    	}
    	softassert.assertAll();
    }
    
    public void usageSummaryByGroupLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if Usage Summary By Group Label is present");
		Assert.assertTrue(usage_summary_by_group_label.isDisplayed(),"Usage Summary By Group label is not present or locator has been changed.");
	}
    
    public void usageSummaryByGroupTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<usage_summary_by_group_table_columns.size();i++){
			
			for(int j=0;j<expected_usage_summary_by_group_table_columns.length;j++){
				
				if(usage_summary_by_group_table_columns.get(i).getText().equals(expected_usage_summary_by_group_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_usage_summary_by_group_table_columns[j]+" is present");
					softassert.assertTrue(usage_summary_by_group_table_columns.get(i).getText().equals(expected_usage_summary_by_group_table_columns[j]),"Column "+expected_usage_summary_by_group_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
    
    public void configurationSummaryByGroupLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if Configuration Summary By Group Label is present");
		Assert.assertTrue(config_summary_by_group_label.isDisplayed(),"Configuration Summary By Group label is not present or locator has been changed.");
	}
    
    public void configSummaryByGroupTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<config_summary_By_group_table_columns.size();i++){
			
			for(int j=0;j<expected_config_summary_By_group_table_columns.length;j++){
				
				if(config_summary_By_group_table_columns.get(i).getText().equals(expected_config_summary_By_group_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_config_summary_By_group_table_columns[j]+" is present");
					softassert.assertTrue(config_summary_By_group_table_columns.get(i).getText().equals(expected_config_summary_By_group_table_columns[j]),"Column "+expected_config_summary_By_group_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
    
    public void usageByTrackingNumberLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if Usage By Tracking Number Label is present");
		Assert.assertTrue(usage_by_tn_label.isDisplayed(),"Usage By Tracking Number label is not present or locator has been changed.");
	}
    
    public void usageByTrackingNumberTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<usage_by_tn_table_columns.size();i++){
			
			for(int j=0;j<expected_usage_by_tn_table_columns.length;j++){
				
				if(usage_by_tn_table_columns.get(i).getText().equals(expected_usage_by_tn_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_usage_by_tn_table_columns[j]+" is present");
					softassert.assertTrue(usage_by_tn_table_columns.get(i).getText().equals(expected_usage_by_tn_table_columns[j]),"Column "+expected_usage_by_tn_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
    
    public void callTrendsLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if Call Trends Label is present");
		Assert.assertTrue(call_trends_label.isDisplayed(),"Call Trends label is not present or locator has been changed.");
	}
    
    public void tilesVerification(){
    	
    	for(int i=0;i<call_trends_tiles.size();i++){
    		
    		for(int j=0;j<expected_call_trends_tiles.length;j++){
    			
    			if(call_trends_tiles.get(i).getText().startsWith(expected_call_trends_tiles[j])){
    				
    				logger.log(LogStatus.INFO, "Verifying if "+expected_call_trends_tiles[j]+" is present");
    				softassert.assertTrue(call_trends_tiles.get(i).getText().startsWith(expected_call_trends_tiles[j]),"Tile "+expected_call_trends_tiles[j]+" is not present");
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
	String avg_call_duration_from_db = Util.readingFromDB("SELECT AVG(duration) AS count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
	String unanswered_calls_count_from_db = Util.readingFromDB("SELECT COUNT(*) AS count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59' AND disposition IN ('NO ANSWER')");
	String longest_call_duration_from_db = Util.readingFromDB("SELECT MAX(duration) AS count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");

//  -------------------------------------------------------------------------------------------------------------------- 

	public void callTrendsTileValueVerificationForDefault7DaysFilter(String tile_name){
			
			
			String tile_values=driver.findElement(By.xpath("//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span[text()='"+tile_name+"']//parent::Div//parent::div/preceding-sibling::div//a")).getText();
		
			if(tile_name.equals("Total Calls")){
				
				tile_values=driver.findElement(By.xpath("(//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span[text()='Total Calls'])[2]//parent::Div//parent::div/preceding-sibling::div//a")).getText();
				
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
					System.out.println(avg_call_duration_from_db.substring(0,avg_call_duration_from_db.indexOf('.')));
					softassert.assertTrue(tile_values.equals(avg_call_duration_from_db.substring(0,avg_call_duration_from_db.indexOf('.'))),"Tile count doest match with db count");			
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
    
    
    
    
    
    
    
    
}
