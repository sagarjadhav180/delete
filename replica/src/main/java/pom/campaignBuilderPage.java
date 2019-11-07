package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import tests.TestBase;

public class campaignBuilderPage extends TestBase {

	//labels
	String[] all_labels={"Campaign Name","Campaign External ID","Campaign Owner","Active?","Start Date and Time (ET)","End Date and Time (ET)"};
	static String label_name;
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
	
	
	@FindBy(xpath="//input[@id='s2id_autogen2_search']")
	private static WebElement campaignOwner_TextBox;	
	
	@FindBy(xpath="//li/ul/li[1]/div")
	private static WebElement Searched_CampaignOwner;	
	
	@FindBy(id="s2id_autogen4")
	private static WebElement assignUser_Section;		
		
	

	String campaignName_TextBox_placeholder="Type Campaign Name";
	@FindBy(xpath="//input[@placeholder='Type Campaign Name']")
	private static WebElement campaignName_TextBox;

	String campaignID_TextBox_placeholder="Type Campaign External ID (Optional)";
	@FindBy(xpath="//input[@placeholder='Type Campaign External ID (Optional)']")
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
	
	@FindBy(xpath="//a[@class='btn btn-default hidden-xs']")
	private static WebElement campaignList;		
	
	WebDriverWait wait;
	SoftAssert Assert1=new SoftAssert();
	
	public campaignBuilderPage(WebDriver driver,WebDriverWait wait1){
		PageFactory.initElements(driver, this);
		wait=wait1;
	}
	
	
	
	public void clickAction(String buttonName){
		if(buttonName.contains("list")){
			campaignList.click();
		}
	}
	
	
	
	public void campaignBuilderPageUIVerification() throws InterruptedException{
		
		//verification of header
		logger.log(LogStatus.INFO, "verification of header");
		wait.until(ExpectedConditions.visibilityOf(header));
		Assert1.assertTrue(header.isDisplayed(),"header is not displayed");
		
		//verification of collapsible_strip
		logger.log(LogStatus.INFO, "verification of collapsible_strip");
		Assert1.assertTrue(collapsible_strip.isDisplayed(),"collapsible_strip is not displayed");
		
		//verification of labels
		logger.log(LogStatus.INFO, "verification of labels");		
		for(int i=0;i<all_labels.length;i++){
			System.out.println("expected label is-- "+all_labels[i]);
			label_name=all_labels[i];
			
			System.out.println("actual label--"+label);

			Assert1.assertTrue(label.isDisplayed()," label-- "+all_labels[i]+" is not displayed");
			
		}

		
		
		
		
		
		//verification of active/inactive toggle button
		logger.log(LogStatus.INFO, "verification of active/inactive toggle button");				
		Assert1.assertTrue(active_InactiveCampaign_Button.isDisplayed(),"active_InactiveCampaign_Button is not displayed");
		Assert1.assertTrue(active_InactiveCampaign_Button.isEnabled(),"active_InactiveCampaign_Button is not enabled");
		
		//verification of campaignOwner_DropDown
		logger.log(LogStatus.INFO, "verification of campaignOwner_DropDown");
		Assert1.assertTrue(campaignOwner_DropDown.isDisplayed(),"campaignOwner_DropDown is not displayed");
		Assert1.assertTrue(campaignOwner_DropDown.isEnabled(),"campaignOwner_DropDown is not enabled()");
		
		//verification of campaignName_TextBox
		logger.log(LogStatus.INFO, "verification of campaignName_TextBox");
		Assert1.assertTrue(campaignName_TextBox.isDisplayed(),"campaignName_TextBox is not displayed");
		
		//verification of campaignName_TextBox placeholder
		logger.log(LogStatus.INFO, "verification of campaignName_TextBox placeholder");
		Assert1.assertEquals(campaignName_TextBox.getAttribute("placeholder"), campaignName_TextBox_placeholder,"campaignName_TextBox_placeholder is not displayed");
	
		//verification of campaignID_TextBox
		logger.log(LogStatus.INFO,"verification of campaignID_TextBox");
		Assert1.assertTrue(campaignID_TextBox.isDisplayed(),"campaignID_TextBox is not displayed");
		
		//verification of campaignID_TextBox placeholder
		logger.log(LogStatus.INFO, "verification of campaignID_TextBox placeholder");
		Assert1.assertEquals(campaignID_TextBox.getAttribute("placeholder"), "campaignID_TextBox_placeholder","campaignID_TextBox_placeholder is not displayed");
		
		//verification of startDate_Calender
		logger.log(LogStatus.INFO, "verification of startDate_Calender");
		Assert1.assertTrue(startDate_Calender.isDisplayed(),"startDate_Calender is not displayed");

		//verification of endDate_Calender
		logger.log(LogStatus.INFO, "verification of endDate_Calender");
		Assert1.assertTrue(endDate_Calender.isDisplayed(),"endDate_Calender is not displayed");
		Assert1.assertAll();
		
	}
	
	public void collapseExpand_collapsible_strip(){
		wait.until(ExpectedConditions.visibilityOf(collapsible_strip));
		
		try{
			collapsible_strip.click();
			Assert1.assertFalse(SaveCampaignDetails_Button.isDisplayed(),"SaveCampaignDetails_Button is not displayed");
			collapsible_strip.click();			
			Assert1.assertTrue(SaveCampaignDetails_Button.isDisplayed(),"SaveCampaignDetails_Button is not displayed");
		}
		catch(Exception e){
			System.out.println("collapsible_strip is not working..");
		}
		Assert1.assertAll();
	}
	
	//to verify campaign is getting created without external id
	public String createCampaign_WithoutCampaignExternalID(){
		
		int number1 = tests.Util.generateRandomNumber();
		String campaign = "campaign "+number1;
		campaignName_TextBox.sendKeys(campaign);
		SaveCampaignDetails_Button.click();
		return campaign;
		
	}
	
	
	
	
}
