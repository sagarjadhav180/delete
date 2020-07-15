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

public class MarketingDashboardPage extends TestBase{
	
	@FindBy(xpath="//div[@class='title-main']//span[text()='Marketing Dashboard - Enhanced']")
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

	@FindBy(xpath="//div[@class='looker-vis-context-title']//span[text()='Calls Mix']")
	private WebElement call_mix_label;

	@FindBy(xpath="//div[@class='looker-vis-context-title']//span[text()='Highest Converting']")
	private WebElement highest_converting_label;
	
	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[1]")
	private WebElement call_mix_pie_chart;

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[2]")
	private WebElement highest_converting_graph;

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[3]")
	private WebElement total_calls_graph;

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[4]")
	private WebElement unique_calls_graph;

	@FindBy(xpath="//div[@class='centered']//span[@class='looker-vis-context-title-text ']")
	private List<WebElement> marketing_dashboard_tiles;
	
	String[] expected_marketing_dashboard_tiles={"Total Calls","Leads","Conversions"};
	
	@FindBy(xpath="(//div[@class='grid-element']//div[@class='ag-header-row'])[2]//span[@class='column-label']//strong")
	private List<WebElement> marketing_dashboard_table_columns;

	String[] expected_marketing_dashboard_table_columns={"Calls By Group","Total Calls","Leads","Lead % of Calls","Conversions","Conversion % of Calls","Total Duration","Average Duration"};

	@FindBy(xpath="(//span[text()='Detailed View']//parent::div[@class='looker-vis-context-title'])[1]")
	private WebElement marketing_dashboard_detailed_view_button;
	
	@FindBy(xpath="//p[text()='This report is intended for download and/or scheduling only. Due to the amount of data available, it may take longer than usual to load. To increase loading speed, the amount of records available here has been reduced to 100. All records for the Date Range selected will be available on the downloaded or scheduled version.']")
	private WebElement marketing_dashboard_detailed_view_note;

	@FindBy(xpath="//div[@class='centered']")
	private WebElement default_report_tile_marketing_dashboard_detailed_view_page;

	@FindBy(xpath="//div[@class='looker-vis-context-title']//span[text()='Highest Converting']")
	private WebElement highest_converting_map_label;

	@FindBy(xpath="(//div[@class='grid-element']//div[@class='ag-header-row'])[2]//span[@class='column-label']//strong")
	private List<WebElement> website_calls_table_columns;

	String[] expected_website_calls_table_columns={"Calls By Group","Website Number Swaps","Website Calls","% of Website Number Swaps","Leads","Lead % of Website Calls","Conversions","Conversion % of Website Calls","Total Duration","Average Duration"};

	@FindBy(xpath="(//span[text()='Detailed View']//parent::div[@class='looker-vis-context-title'])[2]")
	private WebElement website_calls_detailed_view_button;
	
	@FindBy(xpath="//p[text()='This report is intended for download and/or scheduling only. Due to the amount of data available, it may take longer than usual to load. To increase loading speed, the amount of records available here has been reduced to 100. All records for the Date Range selected will be available on the downloaded or scheduled version.']")
	private WebElement website_calls_detailed_view_note;

	@FindBy(xpath="//div[@class='centered']")
	private WebElement default_report_tile_website_calls_detailed_view_page;
	
	@FindBy(xpath="(//div[@class='looker-vis-context-title']//span[text()='Website Number Swaps'])[3]")
	private WebElement website_number_swaps_label;

	@FindBy(xpath="(//div[@class='looker-vis-context-title']//span[text()='Website Number Swaps'])[3]")
	private WebElement website_calls_label;

	@FindBy(xpath="(//div[@class='looker-vis-context-title']//span[text()='Website Calls'])[2]")
	private WebElement website_calls_map_label;

	@FindBy(xpath="(//div[@class='looker-vis-context-title']//span[text()='Website Number Swaps'])[3]")
	private WebElement website_number_swaps_map_label;

	@FindBy(xpath="(//div[@class='looker-leaflet-container'])[1]")
	private WebElement website_calls_map;

	@FindBy(xpath="(//div[@class='looker-leaflet-container'])[2]")
	private WebElement website_number_swaps_map;
	
	@FindBy(xpath="//table[@class='explore-filters clearfix']//tbody//tr//td[@class='filter-name']")
	private List<WebElement> filter_elements_after_expanding;
	
	String[] expected_filter_elements_after_expanding={"Date Range","Show Columns By","Stack Columns By","Group Calls By","Group Website Calls By","Ad Source","Campaign","Group","Keywords","Referring Source","Referring Type","Ring-to Name","Ring-to Number","Tracking Number Name","Tracking Number"};
	
	@FindBy(xpath="(//div[@class='vis-single-value']//span[@class='looker-vis-context-title-text '][text()='Detailed View'])[1]")
	private WebElement mkt_dashboard__detailed_view_tile;
		
	String[] expected_tile_names_mkt_dashboard={"Total Calls","Leads","Conversions"};

	@FindBy(xpath="(//div[@class='vis-single-value']//span[@class='looker-vis-context-title-text '][text()='Detailed View'])[2]")
	private WebElement website_calls_detailed_view_tile;
	
	String[] expected_tile_names_website_calls={"Website Number Swaps","Website Calls"};
	
	SoftAssert softassert=new SoftAssert(); 

	public MarketingDashboardPage(WebDriver driver){
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
		Assert.assertTrue(header_label.isDisplayed(),"Header label is not displayed or locator changed");
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
    
    public void marketingDahsboardTilesVerification() throws InterruptedException{
    	
    	for(int i=0;i<marketing_dashboard_tiles.size();){
    		
    		for(int j=0;j<expected_marketing_dashboard_tiles.length;j++){
    			
    			if(marketing_dashboard_tiles.get(i).getText().startsWith(expected_marketing_dashboard_tiles[j])){
    				logger.log(LogStatus.INFO, "Verifying if "+expected_marketing_dashboard_tiles[j]+" is present");
    				softassert.assertTrue(marketing_dashboard_tiles.get(i).getText().startsWith(expected_marketing_dashboard_tiles[j]),expected_marketing_dashboard_tiles[j]+" is not present or locator changed");
    			}
    			
    		}
    		i++;
    	}    	
    	softassert.assertAll();
    }

    public void websiteCallsTilesVerification(){
    	
    	for(int i=0;i<marketing_dashboard_tiles.size();){
		
		for(int j=0;j<expected_tile_names_website_calls.length;j++){
			
			if(marketing_dashboard_tiles.get(i).getText().startsWith(expected_tile_names_website_calls[j])){
				logger.log(LogStatus.INFO, "Verifying if "+expected_tile_names_website_calls[j]+" is present");
				softassert.assertTrue(marketing_dashboard_tiles.get(i).getText().startsWith(expected_tile_names_website_calls[j]),expected_tile_names_website_calls[j]+" is not present or locator changed");
			}
			
		}
		i++;
	}    	
	softassert.assertAll();
    	
    	
    	
    }
    
    
    public void callMixLabel(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Call Mix Label is displayed");
    	Assert.assertTrue(call_mix_label.isDisplayed(),"Call Mix Label is not displayed or locator changed");
    }
    
    public void highestConvertingLabel(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Highest Converting Label is displayed");
    	Assert.assertTrue(highest_converting_label.isDisplayed(),"Highest Converting Label Label is not displayed or locator changed");
    }
    
    public void websiteCallsLabel(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Website Calls Label is displayed");
    	Assert.assertTrue(website_calls_label.isDisplayed(),"Website Calls Label is not displayed or locator changed");
    }
    
    public void websiteNumberSwapsMapLabel(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Website Number Swaps Map Label is displayed");
    	Assert.assertTrue(website_number_swaps_map_label.isDisplayed(),"Website Number Swaps Map Label is not displayed or locator changed");
    }
    
    public void websiteCallsMapLabel(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Website Calls Map Label is displayed");
    	Assert.assertTrue(website_calls_map_label.isDisplayed(),"Website Calls Map Label is not displayed or locator changed");
    }
    
    public void callmixPieChart(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Call Mix Pie Chart is displayed");
    	Assert.assertTrue(call_mix_pie_chart.isDisplayed(),"Call Mix Pie Chart is not displayed or locator changed");
    }
    
    public void highestConvertingGraph(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Highest Converting Graph is displayed");
    	Assert.assertTrue(highest_converting_graph.isDisplayed(),"Highest Converting Graph is not displayed or locator changed");
    }
    
    public void totalCallsGraph(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Total Calls Graph is displayed");
    	Assert.assertTrue(total_calls_graph.isDisplayed(),"Total Calls Graph is not displayed or locator changed");
    }
    
    public void uniqueCallsGraph(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Unique Calls Graph is displayed");
    	Assert.assertTrue(unique_calls_graph.isDisplayed(),"Unique Calls Graph is not displayed or locator changed");
    }
    
    public void websiteNumberSwapsMap(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Website Number Swaps Map is displayed");
    	Assert.assertTrue(website_number_swaps_map.isDisplayed(),"Website Number Swaps Map is not displayed or locator changed");
    }
    
    public void websiteCallsMap(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Website Calls Map is displayed");
    	Assert.assertTrue(website_calls_map.isDisplayed(),"Website Calls Map is not displayed or locator changed");
    }
    
    public void marketingDashboardTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<marketing_dashboard_table_columns.size();i++){
			
			for(int j=0;j<expected_marketing_dashboard_table_columns.length;j++){
				
				if(marketing_dashboard_table_columns.get(i).getText().equals(expected_marketing_dashboard_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_marketing_dashboard_table_columns[j]+" is present");
					softassert.assertTrue(marketing_dashboard_table_columns.get(i).getText().equals(expected_marketing_dashboard_table_columns[j]),"Column "+expected_marketing_dashboard_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
    
    public void websiteCallsTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<website_calls_table_columns.size();i++){
			
			for(int j=0;j<expected_website_calls_table_columns.length;j++){
				
				if(website_calls_table_columns.get(i).getText().equals(expected_website_calls_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_website_calls_table_columns[j]+" is present");
					softassert.assertTrue(website_calls_table_columns.get(i).getText().equals(expected_website_calls_table_columns[j]),"Column "+expected_website_calls_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
    
    
    public void tileValueVerificationForDefault7DaysFilter(String tile_name){
		
    	String endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
		String startDateToBeUsed = Util.getDate("yyyy-MM-dd","-7");

		String total_call_count_from_db = Util.readingFromDB("SELECT count(*) as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
		String total_leads_from_db = Util.readingFromDB("SELECT count(*) as count FROM indicator_score WHERE call_id IN (SELECT call_id FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59') AND indicator_id='51'");
		String total_conversion_from_db = Util.readingFromDB("SELECT score_value as count FROM indicator_score WHERE call_id IN (SELECT call_id FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59') AND indicator_id='18'");		
		
		String tile_values=driver.findElement(By.xpath("//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span[text()='"+tile_name+"']//parent::Div//parent::div/preceding-sibling::div//a")).getText();
        
		if(tile_name.startsWith("Total Calls")){
			
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
		
		else if(tile_name.startsWith("Leads")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(total_leads_from_db!=null){
				System.out.println(tile_values);
				System.out.println(total_leads_from_db);
				softassert.assertTrue(tile_values.equals(total_leads_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
		else if(tile_name.startsWith("Conversions")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(total_conversion_from_db!=null){
				System.out.println(tile_values);
				System.out.println(total_conversion_from_db);
				softassert.assertTrue(tile_values.equals(total_conversion_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
		
		softassert.assertAll();
	}
    
    
    
    
    
    
    
    
    
}
