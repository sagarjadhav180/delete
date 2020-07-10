package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.TestBase;

public class LegacyScheduledReportsPage extends TestBase {
	
	
	@FindBy(xpath="//div[@ class='pageProgressLoader']")
	private WebElement loadingWheel;
	
	@FindBy(xpath="//h1[contains(text(),'Legacy Scheduled Reports')]")
	private WebElement header_label;	
	
	@FindBy(xpath="//a[@class='btn btn-sm btn-default'][contains(text(),'Add Scheduled Report')]")
	private WebElement add_scheduled_report_button;	
	
	@FindBy(xpath="//span[contains(text(),'Export as')]")
	private WebElement export_button;	

	@FindBy(xpath="(//span[contains(text(),'Export as')]//parent::button//following-sibling::ul//li//a[contains(text(),'Excel')])[1]")
	private WebElement export_excel_button;	

	@FindBy(xpath="(//span[contains(text(),'Export as')]//parent::button//following-sibling::ul//li//a[contains(text(),'TSV')])[1]")
	private WebElement export_tsv_button;	
	
	@FindBy(xpath="//table[@id='scheduledreportstable']//thead//tr[1]//th")
	private WebElement actual_header_labels;
	
	String[] expected_header_labels={"Name","Report","Creator","Dist List","Freq","Format","Status","Actions"};
	
	//pagination toolbox
	//top
	@FindBy(xpath="(//button[contains(text(),'First')])[1]")
	private static WebElement top_first_button;	
		
	@FindBy(xpath="(//button[contains(text(),'Last')])[1]")
	private static WebElement top_last_button;
		
	@FindBy(xpath="(//button[contains(text(),'Prev')])[1]")
	private static WebElement top_prev_button;	
		
	@FindBy(xpath="(//button[contains(text(),'Next')])[1]")
	private static WebElement top_next_button;
		
	@FindBy(xpath="(//button[contains(text(),'Showing')])[1]")
	private static WebElement top_pagination_count;	
	
//  verification of buttons in top pagination toolbox
//	logger.log(LogStatus.INFO, "verifying presence of buttons in top pagination toolbox");
//	wait.until(ExpectedConditions.visibilityOf(users_topNextPagination_Button));
//	Assert1.assertTrue(top_first_button.isDisplayed(),"top_first_button is not present or locator changed");
//	Assert1.assertTrue(top_last_button.isDisplayed(),"top_last_button is not present or locator changed");	
//	Assert1.assertTrue(top_next_button.isDisplayed(),"top_next_button is not present or locator changed");	
//	Assert1.assertTrue(top_prev_button.isDisplayed(),"top_prev_button is not present or locator changed");	
	
	
	
	
	
	
	
	
	public LegacyScheduledReportsPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}


	//to get action button of desired schedule  
    public WebElement getScoreacrd(String schedule_name,String button_name){
		
		WebElement webelement = driver.findElement(By.xpath("//table[@id='scheduledreportstable']//tbody//tr//td[text()='"+schedule_name+"']//parent::tr//child::button[contains(text(),'"+button_name+"')]"));
		return webelement;
	}

}
