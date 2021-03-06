package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.CampaignAndTrackingNumberPage;
import pom.HomePage;
import pom.LoginPage;

public class CamapignUIVerificationTest extends TestBase{

	HomePage hp;
		
	
	@BeforeClass
	public void goToCampaignPage() throws InterruptedException, IOException{

	LoginPage lp=new LoginPage(driver);

	

	
//	LoginPage lp=new LoginPage(driver);
    logger=extent.startTest(Constants.login_page_category); 
    logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
    logger.assignCategory(Constants.login_page_category);
    lp.validLogin();		
	hp=new HomePage(driver);
    logger.log(LogStatus.INFO, "going to campaign and tracking number page..");
	hp.clickAction(Constants.HomePage.campaign_tracking_number_page);

		
		
	}
	
	//Campaign and tracking number page - UI verification
	@Test(priority=1)
	public void CampaignAndTrackingNumberPage_UI_Verification() throws InterruptedException{
		logger=extent.startTest("Campaign and tracking number page page UI verification..");
		logger.assignCategory(Constants.campaign_category);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);	
		logger.log(LogStatus.INFO, "verifying UI of campaign and tracking number page..");
		cp.campaignPageUIVerification();
		
	}
	
	@Test(priority=2)
	public void defaultColumnsDisplayed() throws InterruptedException {
		logger=extent.startTest("Default columns displayed");
		logger.assignCategory(Constants.campaign_category);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);	
		cp.clickAction("expand", campaignToBeEdited);
		cp.toCheckDefaultDisplayedColumns();
		cp.clickAction("collapse", campaignToBeEdited);
		Util.getJavascriptExecutor().executeScript("window.scrollBy(0,-1500)","");
		
	}
	
	//To check by default displayed tracking number columns
//	@Test(priority=2)
//	public void defaultTrackingNumberColumnLabels() throws InterruptedException{
//			
//
//	logger=extent.startTest("default Tracking Number Column Labels..");
//    logger.assignCategory(Constants.campaign_category);
//
//    CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);	
//	campaignBuilderPage cb=new campaignBuilderPage(driver, wait);
//    cp.clickAction("expand", campaignToBeEdited);	
//    cp.defaultDisplayedTrackingNumberColumns();
//    cp.clickAction("collapse",campaignToBeEdited);
//    Util.getJavascriptExecutor().executeScript("window.scrollBy(0,-1500)");
//    
//
//	}

	//To check all tracking number columns are displayed after checking them from column picker
	@Test(priority=3)
	public void allColumnsDisplayed() throws InterruptedException {
		logger=extent.startTest("all columns displayed");
		logger.assignCategory(Constants.campaign_category);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);	
		cp.toCheckOptionsFromColumnPicker();
		
		Thread.sleep(2000);

		cp.clickAction("expand",campaignToBeEdited);
		Thread.sleep(10000);
		cp.toCheckAllDisplayedColumns();
		cp.clickAction("collapse", campaignToBeEdited);
		Util.getJavascriptExecutor().executeScript("window.scrollBy(0,-1500)","");
		
	}

	

	
	@AfterClass
	public void goToHomePage(){

		
		hp=new HomePage(driver);
        Util.getJavascriptExecutor().executeScript("window.scrollBy(0,-2000)");	
        try {
			hp.clickAction("Home");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
        
	}
	
	
}
