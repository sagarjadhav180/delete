package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class campaignBuilderPage {

	//labels
	String[] all_labels={"Campaign Name","Campaign External ID","Campaign Owner","Active?","Start Date and Time (ET)","End Date and Time (ET)"};
	String label_name;
	@FindBy(xpath="//label[contains(text(),label_name)]")
	private static WebElement label;		

	//header 
	@FindBy(xpath="//h1[contains(text(),'Campaign Builder')]")
	private static WebElement header;
	
	@FindBy(xpath="//h4[contains(text(),' Rajeev stag 7')]")
	private static WebElement collapsible_strip;
	
	//active/inactive toggle
	@FindBy(xpath="(//span[@class='knob ng-binding ng-scope'])[2]")
	private static WebElement active_InactiveCampaign_Button;
	
	@FindBy(xpath="(//span[@class='switch-right ng-binding ng-scope' and contains(text(),'No')])[2]")
	private static WebElement NO;	

	@FindBy(xpath="(//span[@class='switch-left ng-binding ng-scope' and contains(text(),'Yes')])[2]")
	private static WebElement Yes;

	
	
	@FindBy(xpath="//div/a/span")
	private static WebElement campaignOwner_DropDown;	
	
	
	@FindBy(xpath="//input[@id='s2id_autogen23_search']")
	private static WebElement campaignOwner_TextBox;	
	
	@FindBy(xpath="//li/ul/li[1]/div")
	private static WebElement Searched_CampaignOwner;	
	
	@FindBy(id="s2id_autogen4")
	private static WebElement assignUser_Section;		
		
	

	
	@FindBy(xpath="//div[2]/div/div[2]/div/input")
	private static WebElement campaignName_TextBox;

	@FindBy(xpath="//div[3]/div/input")
	private static WebElement campaignID_TextBox;

	
    //calendar
	@FindBy(xpath="(//md-input-container/button)[1]")
	private static WebElement startDate_Calender;	
	
	@FindBy(xpath="(//md-input-container/button)[2]")
	private static WebElement endDate_Calender;
	
	@FindBy(xpath="(//sm-date-picker[@id='Start DatePicker']//div//div[@class='date-picker']/div[2]/div/button[contains(@class,'md-icon-button scroll-button')])[1]")
	private static WebElement startDateCalender_leftArrow;
	
	@FindBy(xpath="(//sm-date-picker[@id='Start DatePicker']//div//div[@class='date-picker']/div[2]/div/button[contains(@class,'md-icon-button scroll-button')])[2]")
	private static WebElement StartCalender_rightArrow;

	@FindBy(xpath="(//sm-date-picker[@id='End DatePicker']//div//div[@class='date-picker']/div[2]/div/button[contains(@class,'md-icon-button scroll-button')])[1]")
	private static WebElement endDateCalender_leftArrow;
	
	@FindBy(xpath="(//sm-date-picker[@id='End DatePicker']//div//div[@class='date-picker']/div[2]/div/button[contains(@class,'md-icon-button scroll-button')])[2]")
	private static WebElement endCalender_rightArrow;
	
	@FindBy(xpath="(//*[@id='Start DatePicker']/div/md-content/div/div[3]/button)[1]")
	private static WebElement startdatePicker_cancel_Button;	

	@FindBy(xpath="(//*[@id='Start DatePicker']/div/md-content/div/div[3]/button)[2]")
	private static WebElement startdatePicker_ok_Button;

	@FindBy(xpath="(//*[@id='End DatePicker']/div/md-content/div/div[3]/button)[2]")
	private static WebElement enddatePicker_ok_Button;

	@FindBy(xpath="(//*[@id='End DatePicker']/div/md-content/div/div[3]/button)[1]")
	private static WebElement enddatePicker_cancel_Button;
	
	@FindBy(xpath="//form/div/div[3]/button")
	private static WebElement SaveCampaignDetails_Button;	

	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	private static WebElement campaignCreatedSuccessfully_Message;
	
	@FindBy(xpath="//*[contains(text(), 'Successfully updated campaign')]")
	private static WebElement campaignUpdated_SuccessfullyMessage;	
	
	WebDriverWait wait;
	SoftAssert Assert1=new SoftAssert();
	
	public campaignBuilderPage(WebDriver driver,WebDriverWait wait1){
		PageFactory.initElements(driver, this);
		wait=wait1;
	}
	
	public void campaignBuilderPageUIVerification(){
		
		
		
	}
	
	
	
	
}
