package pom;

import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import tests.TestBase;
import tests.Util;

public class CampaignAndTrackingNumberPage extends TestBase

{
	@FindBy(xpath="//a[@class='btn btn-sm btn-default addcamp ng-scope']")
	private static WebElement addCampaign_Button;
	String addCampaign_Button_text="Add Campaign";

	@FindBy(xpath="//h1")
	private static WebElement campaignBuilder_Label;		
	String campaignBuilder_Label_text="Campaign and Tracking Number";
	
	@FindBy(xpath="//form/div/div/h4")
	private static WebElement campaignDetails_Label;		
	
	@FindBy(xpath="//i[2]")
	private static WebElement backToCmapaignPage_Link;	
	
	
	//pagination tool box
	@FindBy(xpath="(//button[4])[1]")
	private static WebElement topNextPagination_Button;	

	@FindBy(xpath="(//button[contains(text(),'Prev 100')])[1]")
	private static WebElement topPrevPagination_Button;	
	
	@FindBy(xpath="//div[@class='text-right topPagination']//div//button[1]")
	private static WebElement topFirstPagination_count;	

	@FindBy(xpath="//div[@class='text-right topPagination']//div//button[5]")
	private static WebElement topLastPagination_count;	
	
	@FindBy(xpath="(//button[3])[1]")
	private static WebElement topPagination_count;

	
	@FindBy(xpath="(//button[4])[2]")
	private static WebElement bottomNextPagination_Button;
	
	@FindBy(xpath="(//button[3])[2]")
	private static WebElement bottomPagination_count;
	
	@FindBy(xpath="//div[@class='text-right topPagination']//div//button[5]")
	private static WebElement bottomFirstPagination_count;		
	
	@FindBy(xpath="//table[contains(@class,'table table-hover table-striped table-condensed table-responsive mt10 ng-isolate-scope')]/tbody/tr")
	private static List<WebElement> countOfCamapign;

	@FindBy(xpath="//table[contains(@class,'table table-hover table-striped table-condensed table-responsive mt10 ng-isolate-scope')]/tbody/tr/td/span")
	private static List<WebElement> camapignList;
	
	
	@FindBy(xpath="//h1")
	private static WebElement campaigns_Label;	
	
	
	
	
	String campaign_to_be_archived;
	@FindBy(xpath="//tr/td/span[contains(text(),'1234')]/ancestor::tr/td[9]/span[@class='actions-buttons']/button[1]")
	private static WebElement Archive_Button;	
	
	@FindBy(xpath="//tr/td/span[contains(text(),'1234')]/ancestor::tr/td[9]/span[@class='actions-buttons']/button[2]")
	private static WebElement Edit_Button;	
	
	@FindBy(xpath="//div[@class='bootbox-body' and contains(text(),campaign_to_be_archived)]")
	private static WebElement archiveCampaign_Message;	
	
	@FindBy(xpath="//h1")
	private static WebElement Campaigns_Label;	
	
	@FindBy(xpath="//div[1]/button[1]/span[contains(text(),'Export')]")
	private static WebElement ExportButton;	
	
	String ExportButton_text="Export"; 
	

	@FindBy(xpath="//div/div/div/div/h4[contains(text(),'Campaign List for Rajeev stag 7')]")
	private static WebElement CampaignList;	

	String CampaignList_text="CAMPAIGN LIST FOR RAJEEV STAG 7";
	
	
	@FindBy(xpath="//tr[1]//th")
	private static List<WebElement> Column_Labels;	
	
	@FindBy(xpath="//tr[1]//th[1]")
	private static WebElement common_collapseExpand_button;		
	
	String[] Column_Labels_text={"Campaign","Campaign External ID","Campaign Start","Campaign End","Campaign Status","Tracking Number Quantity","Actions"};

	//column picker
	@FindBy(xpath="//button[@class='btn btn-block btn-default dropdown-toggle']")
	private static WebElement Column_Picker_button;		
	
//	String Column_Picker_options_selected;
	@FindBy(xpath="//ul[@id='columnpicker']/li/label/preceding-sibling::div/input")
	private static List<WebElement> Column_Picker_options_checkbox;	
	
	@FindBy(xpath="//ul[@id='columnpicker']/li/label")
	private static List<WebElement> Column_Picker_options_checkbox_labels;
	

	@FindBy(xpath="//ul[@id='columnpicker']/li/label")
	private static List<WebElement> Column_Picker_options_labels;
	
	@FindBy(xpath="//button[@class='btn btn-block btn-default dropdown-toggle']")
	private static WebElement campaignList;
	
	String[] Expected_Column_Picker_options_labels ={"Ad Source",
			"Call Value",
			"Campaign",
			"Campaign External ID",
			"Campaign Start",
			"Campaign End",
			"Campaign Status",
			"Custom Parameters",
			"Custom Source 1",
			"Custom Source 2",
			"Custom Source 3",
			"Custom Source 4",
			"Custom Source 5",
			"DNI",
			"DNI Type",
			"Host Domain",
			"HTML Class",
			"Play Disclaimer",
			"Pre-call Webhook",
			"Record Call",
			"Referring Website",
			"Repeat Interval",
			"Ring-to Phone Number",
			"Spam Guard",
			"Tracking Number",
			"Tracking Number Name",
			"Tracking Number Quantity",
			"Tracking Number Status",
			"Tracking Number Type",
			"Voice Prompt",
			"Voicemail",
			"Whisper Message"};

	String[] default_selected_Expected_Column_Picker_options ={
			"",
			"",
			"Campaign",
			"Campaign External ID",
			"Campaign Start",
			"Campaign End",
			"Campaign Status",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"Ring-to Phone Number",
			"Spam Guard",
			"Tracking Number",
			"Tracking Number Name",
			"Tracking Number Quantity",
			"Tracking Number Status",
			"Tracking Number Type",
			"",
			"",
			""
			};
	
	int Expected_Column_Picker_options_count=32;
	
	public static WebDriverWait wait1;
	
	SoftAssert Assert1=new SoftAssert();
	
	//db variables
	String countOnUI_pagination;
	String countOnUI_listedcampaigns;
	String dbCount;
	
	
	
	public CampaignAndTrackingNumberPage(WebDriver driver,WebDriverWait wait1){
		
		PageFactory.initElements(driver, this);
        wait=wait1;
		
	}

	
	public void clickAction(String buttonName){
		if(buttonName.contains("add")){
			wait.until(ExpectedConditions.visibilityOf(addCampaign_Button));
			addCampaign_Button.click();

		}
		else if(buttonName.contains("list")){
			wait.until(ExpectedConditions.visibilityOf(campaignList));
			campaignList.click();
			wait.until(ExpectedConditions.visibilityOf(addCampaign_Button));
		}
	}
	public void campaignPageUIVerification()
	{
     
    //label verification
	logger.log(LogStatus.INFO, "Verifying presence campaignBuilder_Label");
	wait.until(ExpectedConditions.visibilityOf(campaignBuilder_Label));
	Assert1.assertEquals(campaignBuilder_Label_text, campaignBuilder_Label.getText(),"locator changed or label not present");
	
	//add campaign button verification
	logger.log(LogStatus.INFO, "Verifying presence addCampaign_Button");
	wait.until(ExpectedConditions.visibilityOf(addCampaign_Button));
	Assert1.assertTrue(addCampaign_Button.isDisplayed(),"locator changed or add campaign button not present");	
	
	//add campaign button text verification
	logger.log(LogStatus.INFO, "Verifying text on addCampaign_Button");
	Assert1.assertEquals(addCampaign_Button_text, addCampaign_Button.getText(),"addCampaign_Button text not present");	
	
	//export button verification
	logger.log(LogStatus.INFO, "Verifying presence ExportButton");
	Assert1.assertTrue(ExportButton.isDisplayed(),"ExportButton is not present or locator has been changed..");		
	
	//export button text verification	
	logger.log(LogStatus.INFO, "Verifying text on ExportButton");	
	Assert1.assertEquals(ExportButton_text, ExportButton.getText(),"text not present");	
	
	//CampaignList title verification
	logger.log(LogStatus.INFO, "Verifying presence CampaignList");
	Assert1.assertTrue(CampaignList.isDisplayed(),"CampaignList header is not present or locator has been changed..");		

	//CampaignList title text verification	
	logger.log(LogStatus.INFO, "Verifying text on CampaignList");
	Assert1.assertTrue(CampaignList.getText().equals(CampaignList_text),"text not present");	

	
	
	//verification of column picker
	logger.log(LogStatus.INFO, "Verifying presence of Column_Picker_button");	
    Assert1.assertTrue(Column_Picker_button.isDisplayed(),"Column_Picker_button is not present or locator changed");
    wait.until(ExpectedConditions.elementToBeClickable(Column_Picker_button));
    
    //Column_Picker_options verifications
    logger.log(LogStatus.INFO, "Verifying presence of Column_Picker_options");
    Util.click(Column_Picker_button);

    for(int i=0;i<Column_Picker_options_labels.size();){
    	for(int j=0;j<Expected_Column_Picker_options_labels.length;j++){
    	    Assert1.assertTrue(Column_Picker_options_labels.get(i).getText().equalsIgnoreCase(Expected_Column_Picker_options_labels[j]));
    	i++;
    	}
    }

//    Column_Picker_options - verifications of by default checked options

 	logger.log(LogStatus.INFO, "verifying by default checked options..");

 	for(int i=0;i<Column_Picker_options_checkbox.size();){

 		for(int j=0;j<Column_Picker_options_checkbox_labels.size();){

 			for(int k=0;k<default_selected_Expected_Column_Picker_options.length;){

 				if(Column_Picker_options_checkbox_labels.get(j).getText().equals(default_selected_Expected_Column_Picker_options[k])){
 					System.out.println("Column_Picker_options_checkbox_labels is "+Column_Picker_options_checkbox_labels.get(j).getText());
 					System.out.println("default_selected_Expected_Column_Picker_options is "+Column_Picker_options_checkbox_labels.get(j).getText());
 					String aria = Column_Picker_options_checkbox.get(i).getAttribute("aria-checked");
 					Assert1.assertEquals(aria, "true");
 					
 				}
 				i++;
 				j++;
 				k++;	
 			}
 			
 		}
 	}
    



    Util.click(Column_Picker_button);
    
	
    
    //verification of presence of column headers 
//    logger.log(LogStatus.INFO, "verifying presence of column headers..");
//    for(int i=1;i<Column_Labels.size();){
//    
//   		Assert1.assertTrue(Column_Labels.get(i).isDisplayed());;
//       	
//    }
     
    //verification of column headers text
 	logger.log(LogStatus.INFO, "verifying column header text..");
    for(int i=1;i<Column_Labels.size();){
    	
    	for(int j=0;j<Column_Labels_text.length;j++){
    		System.out.println("actual "+Column_Labels.get(i).getText());

    		
    		System.out.println("expected "+Column_Labels_text[j]);


    		Assert1.assertEquals(Column_Labels.get(i).getText(),Column_Labels_text[j] );
            i++;
    	}
    }
    
//    verification of common_collapseExpand_button 
 	logger.log(LogStatus.INFO, "verifying common_collapseExpand_button..");    
	wait.until(ExpectedConditions.visibilityOf(common_collapseExpand_button));
	Assert1.assertTrue(common_collapseExpand_button.isDisplayed());
    
    
	//verification of buttons in top pagination toolbox
	logger.log(LogStatus.INFO, "verifying presence of buttons in top pagination toolbox");
	wait.until(ExpectedConditions.visibilityOf(topNextPagination_Button));
	Assert1.assertTrue(topNextPagination_Button.isDisplayed(),"topNextPagination_Button is not present or locator changed");
	Assert1.assertTrue(topPrevPagination_Button.isDisplayed(),"topPrevPagination_Button is not present or locator changed");	
	Assert1.assertTrue(topFirstPagination_count.isDisplayed(),"topFirstPagination_count is not present or locator changed");	
	Assert1.assertTrue(topLastPagination_count.isDisplayed(),"topLastPagination_count is not present or locator changed");	
	
	//verification of count in top pagination toolbox	
	dbCount = Util.readingFromDB("SELECT count(*) as count FROM campaign WHERE campaign_ou_id=24921");
	countOnUI_pagination=topPagination_count.getText().substring(topPagination_count.getText().indexOf('f')+2);
	logger.log(LogStatus.INFO, "verifying count in top pagination toolbox");
	Assert1.assertEquals(dbCount, countOnUI_pagination);
	
	logger.log(LogStatus.INFO, "verifying count of listed campaigns");
	Assert1.assertEquals(dbCount, String.valueOf(countOfCamapign.size()));
	
	//verification of bottom pagination toolbox
        if(countOfCamapign.size()>100){
		Util.scrollFunction(bottomNextPagination_Button);
		wait.until(ExpectedConditions.visibilityOf(bottomNextPagination_Button));
		Assert1.assertTrue(bottomNextPagination_Button.isDisplayed(),"bottomNextPagination_Button is not present or locator changed");			
		Assert1.assertTrue(bottomFirstPagination_count.isDisplayed(),"bottomFirstPagination_count is not present or locator changed");	
        }
    
        //verification of add campaign button is clickable 
    	logger.log(LogStatus.INFO, "verifying if add campaign button is clickable"); 
    	Assert1.assertTrue(addCampaign_Button.isEnabled());
    	
        //verification of Export button is clickable 
    	logger.log(LogStatus.INFO, "verifying if export button is clickable"); 
    	Assert1.assertTrue(ExportButton.isEnabled());    	
    	

    	//verification of top Pagination buttons are clickable
    	logger.log(LogStatus.INFO, "verifying if top Pagination buttons are clickable");
    	Assert1.assertTrue(topNextPagination_Button.isEnabled(),"topNextPagination_Button is not clickable");
    	Assert1.assertTrue(topPrevPagination_Button.isEnabled(),"topPrevPagination_Button is not clickable");	
    	Assert1.assertTrue(topFirstPagination_count.isEnabled(),"topFirstPagination_count is not clickable");	
    	Assert1.assertTrue(topLastPagination_count.isEnabled(),"topLastPagination_count is not clickable");    	

    	//verification of top Pagination buttons are clickable
    	logger.log(LogStatus.INFO, "verifying if column picker button is clickable");    	
    	Assert1.assertTrue(Column_Picker_button.isEnabled(),"Column_Picker_button button is not clickable");
    	
    Assert1.assertAll();
	
	}
	
	
	public void campaignCreated(String campaignName){
		
		wait.until(ExpectedConditions.visibilityOf(CampaignList));
		for(WebElement campaign:camapignList){
			if(campaign.getText().equals(campaignName)){
			Assert1.assertEquals(campaign.getText(), campaignName);
			}
		}
//		Assert1.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
