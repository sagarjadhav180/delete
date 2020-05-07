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

public class CallBackReportPage extends TestBase{
	
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
	
	SoftAssert softassert=new SoftAssert(); 

	public CallBackReportPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void headerLabel(){

		
	}
	
    public void switchToIFrame(){
		
		driver.switchTo().frame(reports_iframe);
		
	}
    
    
    
    public void presenceOfGearIcon(){
		
		logger.log(LogStatus.INFO, "Verifying if gear icon is present");
		Assert.assertTrue(gear_icon.isDisplayed(),"Gear icon is not present or locator has been changed.");
	}
	
    public void switchToMainWindow(){
		
		driver.switchTo().window(driver.getWindowHandle());
		
	}

    public void gearIconOptions(){
		
		logger.log(LogStatus.INFO, "Verifying options present in gear icon");
        
		gear_icon.click();
		for(int i=0;i<gear_icon_options.size();i++){
			
			for(int j=0;j<expected_gear_icon_options.length;j++){
				
				if(gear_icon_options.get(i).equals(expected_gear_icon_options[j])){
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
