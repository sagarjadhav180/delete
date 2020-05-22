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

public class TagsSummaryPage extends TestBase {

	@FindBy(xpath="//button[@class='btn run-button embed-view btn-primary'][text()='Run']")
	private WebElement run_button;

	@FindBy(xpath="(//div[@class='title-main']//span[text()='Tags Summary'])")
	private WebElement header_label;
	
	@FindBy(xpath="//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span")
	private List<WebElement> tiles_names;	
	
	@FindBy(xpath="//div[@class='vis-header']//span[text()='Tags Over Time']")
	private WebElement tags_over_time_label;	

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[1]")
	private WebElement tags_over_time_graph;	

	@FindBy(xpath="//div[@class='vis-header']//span[text()='Tags Mix']")
	private WebElement tags_mix_label;	

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[2]")
	private WebElement tags_mix_graph;	

	@FindBy(xpath="(//div[@class='dashboard-element'])[6]//div[@class='ag-header-container']//strong")
	private List<WebElement> calls_table_columns;	
	
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

	@FindBy(xpath="(//div[@class='dashboard-element'])[7]//div[@class='ag-header-container']//strong")
	private List<WebElement> tags_table_columns;	

	
	SoftAssert softassert=new SoftAssert(); 

	public TagsSummaryPage(WebDriver driver){
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
		gear_icon.click();
    }    
	
    public void presenceOfTimeZone(){
		
		logger.log(LogStatus.INFO, "Verifying if Time Zone is present");
		Assert.assertTrue(timezone.isDisplayed(),"Time Zone is not present or locator has been changed.");
	}


}
