package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.TestBase;

public class ManageScorecardPage extends TestBase {
	
	
	@FindBy(xpath="//div[@ class='pageProgressLoader']")
	private WebElement loadingWheel;

	@FindBy(xpath="//h1[contains(text(),'Scorecards')]")
	private WebElement scorecard_header_label;

	@FindBy(xpath="//button[@class='btn btn-sm btn-default']")
	private WebElement add_scorecard_button;

	@FindBy(xpath="(//span[text()='Export']//parent::button)[1]")
	private WebElement export_button;

	@FindBy(xpath="//table/thead//tr[1]//th")
	private WebElement actual_column_names;
	
	String[] expected_column_names={"Scorecard Name","Created By","Date Created","Modified Date","Group","Actions"};
	
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
	
	//bottom
	@FindBy(xpath="(//button[contains(text(),'First')])[2]")
	private static WebElement bottom_first_button;	

	@FindBy(xpath="(//button[contains(text(),'Last')])[2]")
	private static WebElement bottom_last_button;	

	@FindBy(xpath="(//button[contains(text(),'Prev')])[2]")
	private static WebElement bottom_prev_button;	

	@FindBy(xpath="(//button[contains(text(),'Next')])[2]")
	private static WebElement bottom_next_button;

	@FindBy(xpath="(//button[contains(text(),'Showing')])[2]")
	private static WebElement bottom_pagination_count;

	@FindBy(xpath="//table[@id='scorecardtable']//tbody//tr")
	private static List<WebElement> scorecards_count_in_table;

//  verification of buttons in top pagination toolbox
//	logger.log(LogStatus.INFO, "verifying presence of buttons in top pagination toolbox");
//	wait.until(ExpectedConditions.visibilityOf(users_topNextPagination_Button));
//	Assert1.assertTrue(top_first_button.isDisplayed(),"top_first_button is not present or locator changed");
//	Assert1.assertTrue(top_last_button.isDisplayed(),"top_last_button is not present or locator changed");	
//	Assert1.assertTrue(top_next_button.isDisplayed(),"top_next_button is not present or locator changed");	
//	Assert1.assertTrue(top_prev_button.isDisplayed(),"top_prev_button is not present or locator changed");	
	
//	dbCount = Util.readingFromDB("SELECT COUNT(*) FROM score_cards WHERE org_unit_id='70135'" );
//	
//      countOnUI_pagination=top_pagination_count.getText().substring(top_pagination_count.getText().indexOf('f')+2);
//	logger.log(LogStatus.INFO, "verifying count scorecards in top pagination toolbox");
//	Assert1.assertEquals(dbCount, countOnUI_pagination,"count in top pagination toolbox is mismatching with db count");
//	
//	logger.log(LogStatus.INFO, "verifying count of listed scorecards");
//	Assert1.assertEquals(dbCount, String.valueOf(scorecards_count_in_table.size()),"count  of listed tracking numbers is mismatching with db count");
	
	
	public ManageScorecardPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	//to get action button of desired scorecard 
    public WebElement getScoreacrd(String scorecard_name,String button_name){
		
		WebElement webelement = driver.findElement(By.xpath("//table//tbody//tr//td[text()='"+scorecard_name+"']//ancestor::tr//child::button[contains(text(),'"+button_name+"')]"));
		return webelement;
	}
    
    
    
	
	
}
