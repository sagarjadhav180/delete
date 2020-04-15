package pom;

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

public class LegacyScheduledReportsPage extends TestBase {
	
	
	@FindBy(xpath="//div[@ class='pageProgressLoader']")
	private WebElement loadingWheel;
	
	@FindBy(xpath="//h1[contains(text(),'Legacy Scheduled Reports')]")
	private WebElement legacy_scheduled_reports_label;	
	
	@FindBy(xpath="//a[@class='btn btn-sm btn-default'][contains(text(),'Add Scheduled Report')]")
	private WebElement add_scheduled_report_button;	
	
	@FindBy(xpath="//span[contains(text(),'Export as')]")
	private WebElement export_button;	

	@FindBy(xpath="(//span[contains(text(),'Export as')]//parent::button//following-sibling::ul//li//a[contains(text(),'Excel')])[1]")
	private WebElement export_excel_button;	

	@FindBy(xpath="(//span[contains(text(),'Export as')]//parent::button//following-sibling::ul//li//a[contains(text(),'TSV')])[1]")
	private WebElement export_tsv_button;	
	
	@FindBy(xpath="//table[@id='scheduledreportstable']//thead//tr[1]//th")
	private WebElement actual_column_labels;
	
	String[] expected_column_labels={"Name","Report","Creator","Dist List","Freq","Format","Status","Actions"};
	
	//pagination toolbox
	
	@FindBy(xpath="(//button[contains(text(),'First')])[1]")
	private static WebElement first_button;	
		
	@FindBy(xpath="(//button[contains(text(),'Last')])[1]")
	private static WebElement last_button;
		
	@FindBy(xpath="(//button[contains(text(),'Prev')])[1]")
	private static WebElement prev_button;	
		
	@FindBy(xpath="(//button[contains(text(),'Next')])[1]")
	private static WebElement next_button;
		
	@FindBy(xpath="(//button[contains(text(),'Showing')])[1]")
	private static WebElement pagination_count;	
	
	@FindBy(xpath="//table[@id='scheduledreportstable']//tbody//tr")
	private static WebElement table_count;	

	@FindBy(xpath="//button[@class='btn btn-primary'][text()='OK']")
	private static WebElement ok_button_scheduled_report_deletion_message;	

	@FindBy(xpath="//button[@class='btn btn-default'][text()='Cancel']")
	private static WebElement cancel_button_scheduled_report_deletion_message;
	
	@FindBy(xpath="//div[@class='ui-pnotify-text'][text()='Your report is being processed.']")
	private static WebElement send_now_confirmation_message;	
	
	public LegacyScheduledReportsPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}


	//to get action button of desired schedule  
    public void clickAction(String schedule_name,String button_name) throws InterruptedException{
		
		WebElement webelement = driver.findElement(By.xpath("//table[@id='scheduledreportstable']//tbody//tr//td[text()='"+schedule_name+"']//parent::tr//child::button[contains(text(),'"+button_name+"')]"));
		webelement.click();
		if(button_name.contains("Delete")){
			driver.switchTo().activeElement();
			Util.click(ok_button_scheduled_report_deletion_message);
		}
		else if(button_name.contains("Send Now")){
			wait.until(ExpectedConditions.visibilityOf(send_now_confirmation_message));
			logger.log(LogStatus.INFO, "Verifying if mail is sent");
			Assert.assertTrue(send_now_confirmation_message.isDisplayed(),"mail is not sent");
		}
		
		Thread.sleep(2000);
		

    }

    //verification of buttons in top pagination toolbox
    public void paginationToolboxUI(){

    	SoftAssert softassert=new SoftAssert();
    	logger.log(LogStatus.INFO, "verifying presence of buttons in top pagination toolbox");
    	wait.until(ExpectedConditions.visibilityOf(first_button));
    	softassert.assertTrue(first_button.isDisplayed(),"first_button is not present or locator changed");
    	softassert.assertTrue(last_button.isDisplayed(),"last_button is not present or locator changed");	
    	softassert.assertTrue(next_button.isDisplayed(),"next_button is not present or locator changed");	
    	softassert.assertTrue(prev_button.isDisplayed(),"prev_button is not present or locator changed");    	
    }
    
	public void paginationCount(){
		
	}
	
    public void tableCount(){
		
	}
	
    public void headerLabel(){
    	
    }
    
    public void scheduleButton(){
    	
    }
    
    public void exportButton(){
    	
    }
    
    public void exportButtonOptions(){
    	
    }
    
    public void columnNames(){
    	
    }
    
    public void editReport(){
    	
    }
    
    public void deleteReport(){
    	
    }
    
    public void sendNowReport(){
    	
    }
    
    
    
    
    
    
}
