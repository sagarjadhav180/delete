package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import tests.TestBase;

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

	@FindBy(xpath="//div[text()='Successfully updated location.']")
	private WebElement success_message_for_main_location_updation;
	
	@FindBy(xpath="//div[text()='Successfully deleted the list']")
	private WebElement success_message_for_main_location_deletion;		
	
	@FindBy(xpath="//button[contains(text(),'OK')]")
	private WebElement main_location_deletion_ok_button;		
	
	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private WebElement main_location_deletion_cancel_button;	
	
	
	
	
	
	
	
	
	//to get action button of desired Main Location 
    public WebElement getMainLocation(String main_location_name,String button_name){
		
		WebElement webelement = driver.findElement(By.xpath("//table[@id='table_geo_route']//tbody//tr//td//span[text()='"+main_location_name+"']//ancestor::tr//td//button[contains(text(),'"+button_name+"')]"));
		return webelement;
	}

}
