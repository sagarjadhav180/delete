package pom;

import java.util.List;

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

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[1]")
	private WebElement call_mix_pie_chart;

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[2]")
	private WebElement highest_converting_graph;

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[3]")
	private WebElement total_calls_graph;

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[4]")
	private WebElement unique_calls_graph;

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
	private WebElement mkt_dashboard_tile;
		
	String[] expected_tile_names_mkt_dashboard={"Total Calls","Leads","Conversions"};

	@FindBy(xpath="(//div[@class='vis-single-value']//span[@class='looker-vis-context-title-text '][text()='Detailed View'])[2]")
	private WebElement website_calls_tile;
	
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
    
	public void headerLabel(){

		
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
    

}
