package pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GroupsAndUserPage {
	
	String groupName="Ganesh 5";
	
	
	@FindBy(xpath="//div[@ class='groupDetailsProgressLoader']")
	private WebElement loadingWheel;
	
	@FindBy(xpath="//h1[contains(text(),'Group and User')]")
	private WebElement groupsAndUserPage_label;

	@FindBy(xpath="//div[@class='table-to-scrape']//button[1]//span[contains(text(),'Export')]")
	private WebElement exportGroupsUsers_button;

	//Sections
	@FindBy(xpath="//h4[contains(@class,'ng-binding')]")
	private List<WebElement> section_labels;
	
	//all labels
	@FindBy(xpath="//label")
	private List<WebElement> all_labels;
	
	
	//Group Details 
	String[] groupDetailsLabels={"Name","External","Industry","Phone","City","State","Zip"};
	
	@FindBy(xpath="//button[contains(text(),'Save Group Details')]")
	private List<WebElement> saveGroupDetails_button;	
	
	@FindBy(xpath="//select[@id='source'][contains(@validate-blur-forza,'State')]")
	private WebElement state_dropdown;	
	
	@FindBy(xpath="//select[@ng-model='industry']")
	private WebElement industry_dropdown;
	
	@FindBy(xpath="//label[contains(text(),'Name')]/..//input")
	private WebElement groupName_textbox;

	@FindBy(xpath="//label[contains(text(),'External')]/..//input")
	private WebElement externalID_textbox;
	
	@FindBy(xpath="//label[contains(text(),'Phone')]/..//input")
	private WebElement phone_textbox;

	@FindBy(xpath="//label[contains(text(),'City')]/..//input")
	private WebElement city_textbox;
	
	@FindBy(xpath="//label[contains(text(),'Zip')]/..//input")
	private WebElement zip_textbox;

	//Feature Settings Details 
	@FindBy(xpath="//div [@class='primary switch ats-switch ng-isolate-scope ng-valid ng-dirty ng-touched']")
	private WebElement CA_toggle;	
	
	@FindBy(xpath="//div[@ class='primary switch ats-switch ng-isolate-scope disabled ng-valid']")
	private WebElement spamGuard_toggle;	
	
	@FindBy(xpath="(//div[@ class='primary switch ats-switch ng-isolate-scope ng-valid'])[2]")
	private WebElement DNI_toggle;


	//Tracking Number Settings Details 
//	@FindBy(xpath="(//span[contains(text(),'Disabled')])[1]")
//	private WebElement CA_toggle;















}
