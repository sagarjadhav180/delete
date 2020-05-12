package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import tests.TestBase;

public class IVRKeypressReportPage extends TestBase{

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
	private List<WebElement> tiles_names;	
	
	String[] expected_tiles_names={"Total Call","IVR Calls","Average Time in Menu","Abandoned Calls","Number Of Unused Paths"};
	
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

	String[] expected_call_table_column={"Play Call","Date/Time","Group|External ID","Campaign|External ID","Tracking Number | Tracking Number Name","Caller Id","Keypress","Ring to Phone Number","Total Duration","Total Time in Menu"};
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[3]//span[text()='No Results']")
	private WebElement no_result_label_calls_table;
	
	@FindBy(xpath="//div[@class='title-text'][text()='Instant Insights']")
	private WebElement instants_insights_title;	

	@FindBy(xpath="(//div[@class='ag-header-row'])[11]//strong")
	private List<WebElement> instants_insights_table_column;

	String[] expected_instants_insights_table_column={"Play Call","Duration","Date/Time","Group|External ID","Campaign|External ID","Tracking Number | Tracking Number Name","Caller Id","Agent ID","Lead","Sale"};	
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[4]//span[text()='No Results']")
	private WebElement no_result_label_instants_insights_table;
	
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

	
	
}
