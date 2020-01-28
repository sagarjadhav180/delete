package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import tests.TestBase;

public class BlackListPage extends TestBase {
	
	@FindBy(xpath="//div[@ class='pageProgressLoader']")
	private WebElement loadingWheel;

	@FindBy(xpath="//h1[contains(text(),'Blacklist')]")
	private WebElement header_label;	

	@FindBy(xpath="//label[contains(text(),'Block unwanted calls with Blacklist. Once a number')]")
	private WebElement actual_blacklist_note;	
   
	String expected_blacklist_note="Block unwanted calls with Blacklist. Once a number is added to the Blacklist, calls are automatically blocked for that Caller ID. The Blacklist applies to all the Groups the logged in user has access to. You can opt to manage your Blacklist from this page, or block individual numbers from the Legacy Reports > Call Details page. To start receiving calls from a Blacklisted number, simply remove that Caller ID from the Blacklist.";

	@FindBy(xpath="//label[@class='containerNew'][text()='Select All']")
	private WebElement select_all_label;	

	@FindBy(xpath="//label[@class='containerNew'][text()='Select All']//span")
	private WebElement select_all_checkbox;	

	@FindBy(xpath="//span[text()='Delete']//parent::button")
	private WebElement delete_button;	

	@FindBy(xpath="//input[@placeholder='Search Caller ID']")
	private WebElement serach_caller_id_textbox;	
	
	@FindBy(xpath="//input[@placeholder='Search Caller ID']//parent::div//following-sibling::div//button")
	private WebElement serach_caller_id_button;		
	
	@FindBy(xpath="//div[@id='txtNumber']//label")
	private WebElement blacklisted_numbers;	
	
	@FindBy(xpath="//div[@id='txtNumber']//label//following-sibling::a[contains(text(),'Blocked for Groups')]")
	private WebElement blocked_for_groups_label;	
	
	@FindBy(xpath="//button[text()=' Add Number To Blacklist']")
	private WebElement  add_number_to_blacklist_button;	
	
	@FindBy(xpath="//button[text()=' Add Number To Blacklist']//parent::div//preceding-sibling::div//child::input")
	private WebElement  add_number_to_blacklist_textbox;		
	
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
	
	
}
