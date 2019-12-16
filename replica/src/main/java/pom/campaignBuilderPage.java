package pom;

import static org.testng.Assert.fail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import tests.TestBase;
import tests.Util;

public class campaignBuilderPage extends TestBase {

	//labels
	String[] all_labels={"Campaign Name","Campaign External ID","Campaign Owner","Active?","Start Date and Time (ET)","End Date and Time (ET)"};
	static String label_name;
	@FindBy(xpath="(//div[ @class='form-group row'])[1]/div/div/div/label")
	private static List<WebElement> labels;		

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

	
	
	@FindBy(xpath="//label[contains(text(),'Campaign Owner')]/..//following-sibling::div//span[contains(@class,'select2-chosen')]")
	private static WebElement campaignOwner_DropDown;	
	
	
	@FindBy(xpath="//input[@id='s2id_autogen2_search']")
	private static WebElement campaignOwner_TextBox;	
	
	@FindBy(xpath="//li/ul/li[1]/div")
	private static WebElement Searched_CampaignOwner;	
	
	@FindBy(id="s2id_autogen4")
	private static WebElement assignUser_Section;		
		
	

	String campaignName_TextBox_placeholder="Type Campaign Name";
	@FindBy(xpath="//label[contains(text(),'Campaign Name')]/..//following-sibling::div//input")
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
	
	@FindBy(xpath="//button[contains(text(),'Save Campaign Details')]")
	private static WebElement SaveCampaignDetails_Button;	

	@FindBy(xpath="//div[@class='ui-pnotify-text']")
	private static WebElement campaignCreatedSuccessfully_Message;
	
	@FindBy(xpath="//*[contains(text(), 'Successfully updated campaign')]")
	private static WebElement campaignUpdated_SuccessfullyMessage;	
	
	@FindBy(xpath="//a[@class='btn btn-default hidden-xs']")
	private static WebElement campaignList;		
	
	@FindBy(xpath="//div[@class='alert ui-pnotify-container alert-success ui-pnotify-shadow']/div[contains(text(),'Campaign created successfully')]")
	private static WebElement createCampaign_success_message;		

	@FindBy(xpath="//div[@class='ui-pnotify-text' and contains(text(),'Campaign updated successfully.')]")
	private static WebElement updateCampaign_success_message;	
			
	
			
			
	WebDriverWait wait;
	SoftAssert Assert1=new SoftAssert();
	
	public campaignBuilderPage(WebDriver driver,WebDriverWait wait1){
		PageFactory.initElements(driver, this);
		wait=wait1;
	}
	
	
	
	public void clickAction(String buttonName){
		if(buttonName.contains("list")){
			wait.until(ExpectedConditions.elementToBeClickable(campaignList));
			tests.Util.click(campaignList);
			
		}
	}
	
	
	
	public void campaignBuilderPageUIVerification() throws InterruptedException{
		
		//verification of header
		logger.log(LogStatus.INFO, "verification of header");
		wait.until(ExpectedConditions.visibilityOf(header));
		Assert1.assertTrue(header.isDisplayed(),"header is not displayed or locator changed");
		
		//verification of collapsible_strip
		logger.log(LogStatus.INFO, "verification of collapsible_strip");
		Assert1.assertTrue(collapsible_strip.isDisplayed(),"collapsible_strip is not displayed or locator changed");
		
		//verification of labels
		logger.log(LogStatus.INFO, "verification of labels");		
		for(int i=0;i<all_labels.length;){

			label_name=all_labels[i];
			for(int j=0;j<labels.size()-2;j++){
				System.out.println("expected label is-- "+all_labels[i]);
				System.out.println("actual label is-- "+labels.get(j).getText());
				Assert1.assertTrue(labels.get(j).getText().equals(all_labels[i])," label-- "+all_labels[i]+" is not displayed or locator changed");
				i++;
			}

//			Assert1.assertTrue(labels," label-- "+all_labels[i]+" is not displayed or locator changed");
			
		}

		
		
		
		
		
		//verification of active/inactive toggle button
		logger.log(LogStatus.INFO, "verification of active/inactive toggle button");				
		Assert1.assertTrue(active_InactiveCampaign_Button.isDisplayed(),"active_InactiveCampaign_Button is not displayed or locator changed");
		Assert1.assertTrue(active_InactiveCampaign_Button.isEnabled(),"active_InactiveCampaign_Button is not enabled");
		
		//verification of campaignOwner_DropDown
		logger.log(LogStatus.INFO, "verification of campaignOwner_DropDown");
		Assert1.assertTrue(campaignOwner_DropDown.isDisplayed(),"campaignOwner_DropDown is not displayed or locator changed");
		Assert1.assertTrue(campaignOwner_DropDown.isEnabled(),"campaignOwner_DropDown is not enabled()");
		
		//verification of campaignName_TextBox
		logger.log(LogStatus.INFO, "verification of campaignName_TextBox");
		Assert1.assertTrue(campaignName_TextBox.isDisplayed(),"campaignName_TextBox is not displayed or locator changed");
		
		//verification of campaignName_TextBox placeholder
		logger.log(LogStatus.INFO, "verification of campaignName_TextBox placeholder");
		Assert1.assertEquals(campaignName_TextBox.getAttribute("placeholder"), campaignName_TextBox_placeholder,"campaignName_TextBox_placeholder is not displayed or locator changed");
	
		//verification of campaignID_TextBox
		logger.log(LogStatus.INFO,"verification of campaignID_TextBox");
		Assert1.assertTrue(campaignID_TextBox.isDisplayed(),"campaignID_TextBox is not displayed or locator changed");
		
		//verification of campaignID_TextBox placeholder
		logger.log(LogStatus.INFO, "verification of campaignID_TextBox placeholder");
		Assert1.assertEquals(campaignID_TextBox.getAttribute("placeholder"), campaignID_TextBox_placeholder,"campaignID_TextBox_placeholder is not displayed or locator changed");
		
		//verification of startDate_Calender
		logger.log(LogStatus.INFO, "verification of startDate_Calender");
		Assert1.assertTrue(startDate_Calender.isDisplayed(),"startDate_Calender is not displayed or locator changed");

		//verification of endDate_Calender
		logger.log(LogStatus.INFO, "verification of endDate_Calender");
		Assert1.assertTrue(endDate_Calender.isDisplayed(),"endDate_Calender is not displayed or locator changed");
		Assert1.assertAll();
		
	}
	
	public void collapseExpand_collapsible_strip(){
		wait.until(ExpectedConditions.visibilityOf(collapsible_strip));
		
		try{
			collapsible_strip.click();
			Assert1.assertFalse(SaveCampaignDetails_Button.isDisplayed(),"SaveCampaignDetails_Button is not displayed or locator changed");
			collapsible_strip.click();			
			Assert1.assertTrue(SaveCampaignDetails_Button.isDisplayed(),"SaveCampaignDetails_Button is not displayed or locator changed");
		}
		catch(Exception e){
			System.out.println("collapsible_strip is not working..");
		}
		Assert1.assertAll();
	}
	
	//to verify campaign is getting created without external id
	public void createCampaign(String campaign_name) throws InterruptedException{
		
		wait.until(ExpectedConditions.visibilityOf(campaignName_TextBox));
		System.out.println("------------"+campaign_name+"----------");
		wait.until(ExpectedConditions.elementToBeClickable(campaignName_TextBox));
		campaignName_TextBox.clear();
		campaignName_TextBox.sendKeys(campaign_name);
		wait.until(ExpectedConditions.visibilityOf(SaveCampaignDetails_Button));
		SaveCampaignDetails_Button.click();
		
		wait.until(ExpectedConditions.visibilityOf(createCampaign_success_message));
		Assert1.assertTrue(createCampaign_success_message.isDisplayed(),"campaign not created");
		Thread.sleep(2000);
				
	}
	
	
	
	
	//to verify campaign is getting created with external id
		public void createCampaign(String campaign_name,String externalID) throws InterruptedException{
			

			wait.until(ExpectedConditions.visibilityOf(campaignName_TextBox));
			campaignName_TextBox.clear();
			campaignName_TextBox.sendKeys(campaign_name);
			campaignID_TextBox.clear();
			campaignID_TextBox.sendKeys(externalID);
			wait.until(ExpectedConditions.visibilityOf(SaveCampaignDetails_Button));
			SaveCampaignDetails_Button.click();
			
			wait.until(ExpectedConditions.visibilityOf(createCampaign_success_message));
			Assert1.assertTrue(createCampaign_success_message.isDisplayed(),"campaign not created");
			Thread.sleep(2000);
					
		}
		
		//createCampaignWithFutureStartDateAndNeverEndDate
		public void createCampaign(String campaign_name,String externalID,int futureStartDate) throws InterruptedException{
			
            wait.until(ExpectedConditions.visibilityOf(campaignName_TextBox));
            wait.until(ExpectedConditions.elementToBeClickable(campaignName_TextBox));
            campaignName_TextBox.clear();
            campaignName_TextBox.sendKeys(campaign_name);
            campaignID_TextBox.clear();
            campaignID_TextBox.sendKeys(externalID);
			startDate_Calender.click();
			WebElement element;
			int startdate;
			String startDateToBeSelected;
			if(futureStartDate<26){
			startdate =futureStartDate+2;
			startDateToBeSelected=String.valueOf(startdate);
			element=driver.findElement(By.xpath("(//sm-date-picker[@id='Start DatePicker']//div//sm-calender[@class='ng-pristine ng-untouched ng-valid ng-isolate-scope']//span[@class='ng-binding ng-scope'][text()="+startDateToBeSelected+"])"));
			
			}else {
                Util.Action().moveToElement(StartCalender_rightArrow).click().perform();
                startdate=2;
				startDateToBeSelected=String.valueOf(startdate);
				element = driver.findElement(By.xpath("(//sm-date-picker[@id='Start DatePicker']//div//sm-calender[@class='ng-pristine ng-untouched ng-valid ng-isolate-scope']//span[@class='ng-binding ng-scope'][text()="+startDateToBeSelected+"])"));
			}
			Util.Action().moveToElement(element).click().perform();
			Util.Action().moveToElement(startdatePicker_ok_Button).click().perform();
			wait.until(ExpectedConditions.visibilityOf(SaveCampaignDetails_Button));
			SaveCampaignDetails_Button.click();
			
			wait.until(ExpectedConditions.visibilityOf(createCampaign_success_message));
			Assert1.assertTrue(createCampaign_success_message.isDisplayed(),"campaign not created");
			Thread.sleep(2000);
					
		}
		
		//createCampaignWithFutureStartDateAndFutureEndDate
		public void createCampaign(String campaign_name,String externalID,int futureStartDate,int futureEndDate) throws InterruptedException{
			
            wait.until(ExpectedConditions.visibilityOf(campaignName_TextBox));
            campaignName_TextBox.clear();
            campaignName_TextBox.sendKeys(campaign_name);
            campaignID_TextBox.clear();
            campaignID_TextBox.sendKeys(externalID);
			startDate_Calender.click();
			
			WebElement element;
			int startDate;
			String startDateToBeSelected;
			if(futureStartDate<26){
			startDate =futureStartDate+2;
			startDateToBeSelected=String.valueOf(startDate);
			element=driver.findElement(By.xpath("(//sm-date-picker[@id='Start DatePicker']//div//sm-calender[@class='ng-pristine ng-untouched ng-valid ng-isolate-scope']//span[@class='ng-binding ng-scope'][text()="+startDateToBeSelected+"])"));
			
			
			}else {
                Util.Action().moveToElement(StartCalender_rightArrow).click().perform();
                startDate=2;
                startDateToBeSelected=String.valueOf(startDate);
				element = driver.findElement(By.xpath("(//sm-date-picker[@id='Start DatePicker']//div//sm-calender[@class='ng-pristine ng-untouched ng-valid ng-isolate-scope']//span[@class='ng-binding ng-scope'][text()="+startDateToBeSelected+"])"));
			}
			Util.Action().moveToElement(element).click().perform();
			Util.Action().moveToElement(startdatePicker_ok_Button).click().perform();
			
			wait.until(ExpectedConditions.visibilityOf(endDate_Calender));
				endDate_Calender.click();
			
			WebElement element1;
			int endDate = 0;
			String endDateToBeSelected;
			if(futureEndDate<26){
			endDate =futureEndDate+3;
			endDateToBeSelected=String.valueOf(endDate);
			element1=driver.findElement(By.xpath("(//sm-date-picker[@id='End DatePicker']//div//sm-calender[@class='ng-pristine ng-untouched ng-valid ng-isolate-scope']//span[@class='ng-binding ng-scope'][text()="+endDateToBeSelected+"])"));
			
			
			}else {
                Util.Action().moveToElement(endCalender_rightArrow).click().perform();
                endDate=3;
                endDateToBeSelected=String.valueOf(endDate);
				element1 = driver.findElement(By.xpath("(//sm-date-picker[@id='End DatePicker']//div//sm-calender[@class='ng-pristine ng-untouched ng-valid ng-isolate-scope']//span[@class='ng-binding ng-scope'][text()="+endDateToBeSelected+"])"));
			}
			Util.Action().moveToElement(element1).click().perform();
			Util.Action().moveToElement(enddatePicker_ok_Button).click().perform();
			
			
			wait.until(ExpectedConditions.visibilityOf(SaveCampaignDetails_Button));
			SaveCampaignDetails_Button.click();
			
			wait.until(ExpectedConditions.visibilityOf(createCampaign_success_message));
			Assert1.assertTrue(createCampaign_success_message.isDisplayed(),"campaign not created");
			Thread.sleep(2000);
					
		}

           public void EditCampaign(String campaign_name_updated,String externalID,int futureStartDate,int futureEndDate) throws InterruptedException{
			

			wait.until(ExpectedConditions.visibilityOf(campaignName_TextBox));

		    Thread.sleep(3000);
			System.out.println(campaignName_TextBox);
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+campaign_name_updated+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			campaignName_TextBox.clear();
			campaignName_TextBox.sendKeys(campaign_name_updated);
			campaignID_TextBox.clear();
			campaignID_TextBox.sendKeys(externalID);
			
			startDate_Calender.click();
			WebElement element;
			int startDate;
			String startDateToBeSelected;
			if(futureStartDate<26){
			startDate =futureStartDate+2;
			startDateToBeSelected=String.valueOf(startDate);
			element=driver.findElement(By.xpath("(//sm-date-picker[@id='Start DatePicker']//div//sm-calender[@class='ng-pristine ng-untouched ng-valid ng-isolate-scope']//span[@class='ng-binding ng-scope'][text()="+startDateToBeSelected+"])"));
			
			
			}else {
                Util.Action().moveToElement(StartCalender_rightArrow).click().perform();
                startDate=3;
                startDateToBeSelected=String.valueOf(startDate);
				element = driver.findElement(By.xpath("(//sm-date-picker[@id='Start DatePicker']//div//sm-calender[@class='ng-pristine ng-untouched ng-valid ng-isolate-scope']//span[@class='ng-binding ng-scope'][text()="+startDateToBeSelected+"])"));
			}
			Util.Action().moveToElement(element).click().perform();
			Util.Action().moveToElement(startdatePicker_ok_Button).click().perform();
			
			try{
				endDate_Calender.click();
			}catch(Exception e){
				e.printStackTrace();
			}
			WebElement element1;
			int endDate;
			String endDateToBeSelected;
			if(futureEndDate<26){
			endDate =futureEndDate+2;
			endDateToBeSelected=String.valueOf(endDate);
			element1=driver.findElement(By.xpath("(//sm-date-picker[@id='End DatePicker']//div//sm-calender[@class='ng-pristine ng-untouched ng-valid ng-isolate-scope']//span[@class='ng-binding ng-scope'][text()="+endDateToBeSelected+"])"));
			
			
			}else {
                Util.Action().moveToElement(endCalender_rightArrow).click().perform();
                endDate=6;
                endDateToBeSelected=String.valueOf(endDate);
				element1 = driver.findElement(By.xpath("(//sm-date-picker[@id='End DatePicker']//div//sm-calender[@class='ng-pristine ng-untouched ng-valid ng-isolate-scope']//span[@class='ng-binding ng-scope'][text()="+endDateToBeSelected+"])"));
			}
			Util.Action().moveToElement(element1).click().perform();
			Util.Action().moveToElement(enddatePicker_ok_Button).click().perform();
			
            
			
			wait.until(ExpectedConditions.visibilityOf(SaveCampaignDetails_Button));
			SaveCampaignDetails_Button.click();
			
			wait.until(ExpectedConditions.visibilityOf(updateCampaign_success_message));
			Assert1.assertTrue(updateCampaign_success_message.isDisplayed(),"campaign not updated ");
			Thread.sleep(2000);
					
		}

		
		
		
		
		public void EditCampaign(String campaign_name_updated,String externalID,int futureStartDate) throws InterruptedException{
			

			wait.until(ExpectedConditions.visibilityOf(campaignName_TextBox));

		    Thread.sleep(3000);
			System.out.println(campaignName_TextBox);
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+campaign_name_updated+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			campaignName_TextBox.clear();
			campaignName_TextBox.sendKeys(campaign_name_updated);
			campaignID_TextBox.clear();
			campaignID_TextBox.sendKeys(externalID);
			
			startDate_Calender.click();
			WebElement element;
			int date;
			String dateToBeSelected;
			if(futureStartDate<26){
			date =futureStartDate+1;
			dateToBeSelected=String.valueOf(date);
			element=driver.findElement(By.xpath("(//sm-date-picker[@id='Start DatePicker']//div//sm-calender[@class='ng-pristine ng-untouched ng-valid ng-isolate-scope']//span[@class='ng-binding ng-scope'][text()="+dateToBeSelected+"])"));
			
			}else {
				StartCalender_rightArrow.click();
				date=4;
				dateToBeSelected=String.valueOf(date);
				element = driver.findElement(By.xpath("(//sm-date-picker[@id='Start DatePicker']//div//sm-calender[@class='ng-pristine ng-untouched ng-valid ng-isolate-scope']//span[@class='ng-binding ng-scope'][text()="+dateToBeSelected+"])"));
			}
			Util.Action().moveToElement(element).click().perform();
			Util.Action().moveToElement(startdatePicker_ok_Button).click().perform();
            
			
			wait.until(ExpectedConditions.visibilityOf(SaveCampaignDetails_Button));
			SaveCampaignDetails_Button.click();
			
			wait.until(ExpectedConditions.visibilityOf(updateCampaign_success_message));
			Assert1.assertTrue(updateCampaign_success_message.isDisplayed(),"campaign not updated ");
			Thread.sleep(2000);
					
		}

		//to verify campaign is getting edited without external id
		public void EditCampaign(String campaign_name_updated) throws InterruptedException{
			

			wait.until(ExpectedConditions.visibilityOf(campaignName_TextBox));

		    Thread.sleep(3000);
			System.out.println(campaignName_TextBox);
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+campaign_name_updated+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			campaignName_TextBox.clear();
			campaignName_TextBox.sendKeys(campaign_name_updated);
			wait.until(ExpectedConditions.visibilityOf(SaveCampaignDetails_Button));
			SaveCampaignDetails_Button.click();
			
			wait.until(ExpectedConditions.visibilityOf(updateCampaign_success_message));
			Assert1.assertTrue(updateCampaign_success_message.isDisplayed(),"campaign not updated ");
			Thread.sleep(2000);
					
		}
		
		//to verify campaign is getting edited with external id
		public void EditCampaign(String campaign_name_updated,String externalID) throws InterruptedException{
			

			wait.until(ExpectedConditions.visibilityOf(campaignName_TextBox));

		    Thread.sleep(3000);
			System.out.println(campaignName_TextBox);
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<"+campaign_name_updated+">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			campaignName_TextBox.clear();
			campaignName_TextBox.sendKeys(campaign_name_updated);
			campaignID_TextBox.clear();
			campaignID_TextBox.sendKeys(externalID);
			wait.until(ExpectedConditions.visibilityOf(SaveCampaignDetails_Button));
			SaveCampaignDetails_Button.click();
			
			wait.until(ExpectedConditions.visibilityOf(updateCampaign_success_message));
			Assert1.assertTrue(updateCampaign_success_message.isDisplayed(),"campaign not updated ");
			Thread.sleep(2000);
					
		}
		
		
		
		
	
}
