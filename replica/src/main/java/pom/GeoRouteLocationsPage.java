package pom;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import tests.TestBase;
import tests.Util;

public class GeoRouteLocationsPage extends TestBase {
	
	@FindBy(xpath="//div[@ class='pageProgressLoader']")
	private WebElement loadingWheel;

	@FindBy(xpath="//h1[contains(text(),'GeoRoute Locations')]")
	private WebElement header_label;

	@FindBy(xpath="//h1[contains(text(),'GeoRoute Locations')]")
	private WebElement location_lists_label;

	@FindBy(xpath="//button[@class='btn btn-sm btn-default btn-primary'][contains(text(),' Add GeoRoute List')]")
	private WebElement add_geo_location_list_button;

	@FindBy(xpath="//label[contains(text(),'Add a location list then edit them to add location')]")
	private WebElement add_geo_location_list_note;

	String expected_note="Add a location list then edit them to add locations to each list. IVR can be configured at individual location when a location is added to the list.";

	@FindBy(xpath="//table[@id='table_geo_route']//thead//tr[1]//th")
	private WebElement actual_table_columns;

	String[] expected_column_names={"Name","Location","Created","Modified","Action"};

	@FindBy(xpath="//div[text()='Successfully added location.']")
	private WebElement success_message_for_main_location_creation;

	@FindBy(xpath="//div[@class='ui-pnotify-sticker']")
	private WebElement pause_button_success_message_for_main_location_creation;
	
	@FindBy(xpath="//div[@class='ui-pnotify-closer']")
	private WebElement close_button_success_message_for_main_location_creation;

	@FindBy(xpath="//div[text()='Successfully updated location.']")
	private WebElement success_message_for_main_location_updation;
	
	@FindBy(xpath="//div[text()='Successfully deleted the list']")
	private WebElement success_message_for_main_location_deletion;		
	
	@FindBy(xpath="//input[contains(@class,'editable-input form-control')]")
	private WebElement main_location_name_textbox;			

	@FindBy(xpath="//form[@class='form-buttons form-inline ng-pristine ng-valid']//button[@class='btn btn-sm btn-primary'][contains(text(),'Save')]")
	private WebElement main_location_save_button;			
	
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement main_location_deletion_ok_button;		
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement main_location_deletion_cancel_button;	
	
	//sub location
	@FindBy(xpath="//div[@id='locationeditor']//div[@class='form-group']//a")
	private WebElement sub_location_add_button;	
	
	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[1]")
	private WebElement sub_location_name_textbox;		
	
	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[2]")
	private WebElement sub_location_address_textbox;			
	
	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[3]")
	private WebElement sub_location_city_textbox;				
	
	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[4]")
	private WebElement sub_location_state_textbox;			
	
	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[5]")
	private WebElement sub_location_zip_textbox;
	
	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[6]")
	private WebElement sub_location_phone_textbox;

	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[7]")
	private WebElement sub_location_claimed_state_textbox;
	
	@FindBy(xpath="(//div[@class='editable-controls form-group']//input)[8]")
	private WebElement sub_location_claimed_zip_textbox;
	
	@FindBy(xpath="(//div[@class='editable-controls form-group'])//ancestor::tr//td[@class='text-right']//form//button[text()='Save']")
	private WebElement sub_location_save_button;
	
	@FindBy(xpath="(//div[@class='editable-controls form-group'])//ancestor::tr//td[@class='text-right']//form//button[text()='Cancel']")
	private WebElement sub_location_cancel_button;

	@FindBy(xpath="//div[text()='Successfully created location']")
	private WebElement success_message_for_sub_location_creation;
	
	
	//sub location details
	String loc_name = "Olathe";
	String loc_address = "15208 West 119th Street";
	String loc_city = "Olathe";
	String loc_state = "KS";
	String loc_zip = "66062";
	String loc_phone_number = "(111) 111-1111";
	String loc_claimed_state = "SC,UT";
	String loc_claimed_zip = "84116";
	
	public GeoRouteLocationsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		
	}

	//to get action button of desired Main Location 
    public WebElement getMainLocation(String main_location_name,String button_name){
		
		WebElement webelement = driver.findElement(By.xpath("//table[@id='table_geo_route']//tbody//tr//td//span[text()='"+main_location_name+"']//ancestor::tr//td//button[contains(text(),'"+button_name+"')]"));
		return webelement;
	}
    
    public void addMainLocation(String location_name) throws InterruptedException{
    	
    	wait.until(ExpectedConditions.visibilityOf(add_geo_location_list_button));
		wait.until(ExpectedConditions.attributeContains(add_geo_location_list_button, "aria-disabled", "false"));
    	add_geo_location_list_button.click();
    	
    	wait.until(ExpectedConditions.visibilityOf(main_location_name_textbox));
    	main_location_name_textbox.sendKeys(location_name);
    	main_location_save_button.click();
    	wait.until(ExpectedConditions.visibilityOf(success_message_for_main_location_creation));    	
    	Assert.assertTrue(success_message_for_main_location_creation.isDisplayed()," location not created");   
//    	driver.switchTo().activeElement();
//    	pause_button_success_message_for_main_location_creation.click();
//    	close_button_success_message_for_main_location_creation.click();
    	
    	Util.closeBootstrapPopup(pause_button_success_message_for_main_location_creation, close_button_success_message_for_main_location_creation);
    	
//    	Util.click(close_button_success_message_for_main_location_creation);
//    	close_button_success_message_for_main_location_creation.click();
   
  }
   
    
    public void addSubLocation(String location_name) throws InterruptedException{
 	    
    	WebElement locationsButton = driver.findElement(By.xpath("//table[@id='table_geo_route']//tbody//tr//td//span[text()='"+location_name+"']/ancestor::tr//td[@class='text-right']//div[@class='buttons']//button[text()='Locations']"));
    	
    	locationsButton.click();
    	wait.until(ExpectedConditions.visibilityOf(sub_location_add_button));
    	sub_location_add_button.click();
    	Thread.sleep(1000);
    	
    	try {
    		sub_location_add_button.click();
    		//adding sub location details
    		fillSubLocationDeatils();
        	//submitting form
        	sub_location_save_button.click();
        	wait.until(ExpectedConditions.visibilityOf(success_message_for_sub_location_creation));    		
    	}catch(Exception e) {
    		sub_location_add_button.click();
        	Thread.sleep(2000);	
        	//adding sub location details
    		fillSubLocationDeatils();
        	//submitting form
        	sub_location_save_button.click();
        	wait.until(ExpectedConditions.visibilityOf(success_message_for_sub_location_creation));    	
    	}finally {
        	Assert.assertTrue(success_message_for_sub_location_creation.isDisplayed(),"sub location not created"); 
    	}
    }
    
    public void fillSubLocationDeatils() {
    	wait.until(ExpectedConditions.visibilityOf(sub_location_name_textbox));
    	Util.Action().moveToElement(sub_location_name_textbox).perform();
    	sub_location_name_textbox.sendKeys(loc_name);
    	
//    	wait.until(ExpectedConditions.visibilityOf(sub_location_address_textbox));
    	Util.Action().moveToElement(sub_location_address_textbox).perform();
    	sub_location_address_textbox.sendKeys(loc_address);
    	
//    	wait.until(ExpectedConditions.visibilityOf(sub_location_city_textbox));
    	Util.Action().moveToElement(sub_location_city_textbox).perform();
    	sub_location_city_textbox.sendKeys(loc_city);
    	
//    	wait.until(ExpectedConditions.visibilityOf(sub_location_state_textbox));
       	Util.Action().moveToElement(sub_location_state_textbox).perform();
    	sub_location_state_textbox.sendKeys(loc_state);
    	
//    	wait.until(ExpectedConditions.visibilityOf(sub_location_zip_textbox));
       	Util.Action().moveToElement(sub_location_zip_textbox).perform();
    	sub_location_zip_textbox.sendKeys(loc_zip);
    	
//    	wait.until(ExpectedConditions.visibilityOf(sub_location_phone_textbox));
       	Util.Action().moveToElement(sub_location_phone_textbox).perform();
//    	sub_location_phone_textbox.sendKeys(loc_phone_number);
    	Util.enterText(sub_location_phone_textbox, loc_phone_number);
    	
    	System.out.println(sub_location_phone_textbox.getAttribute("value"));
    	
//    	wait.until(ExpectedConditions.visibilityOf(sub_location_claimed_state_textbox));
       	Util.Action().moveToElement(sub_location_claimed_state_textbox).perform();
    	sub_location_claimed_state_textbox.sendKeys(loc_claimed_state);
    	
//    	wait.until(ExpectedConditions.visibilityOf(sub_location_claimed_zip_textbox));
       	Util.Action().moveToElement(sub_location_claimed_zip_textbox).perform();
    	sub_location_claimed_zip_textbox.sendKeys(loc_claimed_zip);		
    }

}
