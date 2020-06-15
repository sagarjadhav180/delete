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

	@FindBy(xpath="//div[@class='title-text'][text()='Group Settings']")
	private WebElement group_settings_label;
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[1]//div[@class='ag-header-container']//strong")
	private List<WebElement> group_settings_table_columns;
	
	String[] expected_group_settings_table_columns={"Group","Group Status","External ID","Industry","Phone","City","State/Province","Zip/Postal Code"};

	@FindBy(xpath="//div[@class='title-text'][text()='Campaign Settings']")
	private WebElement campaign_settings_label;

	@FindBy(xpath="(//div[@class='ag-grid-container'])[2]//div[@class='ag-header-container']//strong")
	private List<WebElement> campaign_settings_table_columns;

	String[] expected_campaign_settings_table_columns={"Campaign","Campaign ID","Campaign External Id","Campaign Owner","Campaign Status","Campaign Start Date","Campaign End Date","Group","Referral Period","Referral Number"};
	
	@FindBy(xpath="//div[@class='title-text'][text()='Tracking Number Settings']")
	private WebElement tn_settings_label;

	@FindBy(xpath="(//div[@class='ag-grid-container'])[3]//div[@class='ag-header-container']//strong")
	private List<WebElement> tn_table_columns;
	
	String[] expected_tn_table_columns={"Tracking Number ID","Tracking Number Name","Tracking Number","Group","Campaign","Tracking Number Type","Tracking Number Status","Ring-to Number","Ad Source","Record Call","Play Disclaimer","Voice Prompt (Yes / No)","Whisper Enabled (Yes / No)","DNI"};
	
	@FindBy(xpath="//div[@class='title-text'][text()='Billing Usage']")
	private WebElement billing_usage_label;

	@FindBy(xpath="(//div[@class='ag-grid-container'])[4]//div[@class='ag-header-container']//strong")
	private List<WebElement> billing_usage_table_columns;
	
	String[] expected_billing_usage_table_columns={"Group","Group External Id","Total Calls","Billable Minutes","Local/Toll Free Minutes Actual","Premium Minutes"};

	@FindBy(xpath="//span[@class='looker-vis-context-title-text '][text()='Configurations Summary by Group']")
	private WebElement config_summary_by_group_label;

	@FindBy(xpath="(//div[@class='ag-grid-container'])[5]//div[@class='ag-header-container']//strong")
	private List<WebElement> config_summary_By_group_table_columns;
	
	String[] expected_config_summary_By_group_table_columns={"Group","Group External Id","Total Number","Local/Toll Free Numbers","Premium Numbers","Total Reserved Number","Total Users"};

	@FindBy(xpath="//span[@class='looker-vis-context-title-text '][text()='Usage by Tracking Number']")
	private WebElement usage_by_tn_label;

	@FindBy(xpath="(//div[@class='ag-grid-container'])[6]//div[@class='ag-header-container']//strong")
	private List<WebElement> usage_by_tn_table_columns;
	
	String[] expected_usage_by_tn_table_columns={"Tracking Number Name","Tracking Number","Tracking Number Status","Group","Group External ID","Campaign","Campaign External ID","Number Type","Tracking Number Type","Total Calls","Analyzed Calls","Total Billable Minutes"};

	@FindBy(xpath="//div[@class='title-text'][text()='Call Trends']")
	private WebElement call_trends_label;

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
	
	
	
	
}
