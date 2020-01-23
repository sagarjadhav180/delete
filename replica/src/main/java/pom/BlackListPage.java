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
	
	
	
	
	
	
	
	
	
	
}
