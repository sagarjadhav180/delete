package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.CampaignAndTrackingNumberPage;
import pom.HomePage;
import pom.LoginPage;
import pom.campaignBuilderPage;

public class CamapignUIVerificationTest extends TestBase{

	HomePage hp;
	@BeforeClass
	public void goToCampaignPage() throws InterruptedException, IOException{
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        logger.assignCategory("Login Suite");
        lp.validLogin();
        HomePage hp=new HomePage(driver);
//        hp.left_hand_navigation_bar_click();
		
		try {
			hp.clickAction("Campaign & Tracking Number");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
	logger.log(LogStatus.INFO, "going to campaign and tracking number page..");
	hp.clickAction("Campaign");
		
		
	}
	
	//Campaign and tracking number page - UI verification
	@Test(priority=1)
	public void CampaignAndTrackingNumberPage_UI_Verification() throws InterruptedException{
		logger=extent.startTest("Campaign and tracking number page page UI verification..");
		logger.assignCategory("Campaign Suite");
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);	
		logger.log(LogStatus.INFO, "verifying UI of campaign and tracking number page..");
		cp.campaignPageUIVerification();
//		Thread.sleep(2000);
		
		
	
	}
	
	//To check by default displayed tracking number columns
	@Test(priority=2)
	public void defaultTrackingNumberColumnLabels() throws InterruptedException{
			
	String campaignToBeEdited="Do not delete--expand scenario";	
	logger=extent.startTest("default Tracking Number Column Labels..");
    logger.assignCategory("Campaign Suite");

    CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);	
	campaignBuilderPage cb=new campaignBuilderPage(driver, wait);
    cp.clickAction("expand", campaignToBeEdited);	
    cp.defaultDisplayedTrackingNumberColumns();
    cp.clickAction("collapse",campaignToBeEdited);
    Util.getJavascriptExecutor().executeScript("window.scrollBy(0,-1500)");
    

	}

	//To check all tracking number columns are displayed after checking them from column picker
	@Test(priority=3)
	public void allTrackingNumberColumnLabels() throws InterruptedException{
			
	String campaignToBeEdited="Do not delete--expand scenario";	
	logger=extent.startTest("all Tracking Number Column Labels..");
    logger.assignCategory("Campaign Suite");

    CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);	
	campaignBuilderPage cb=new campaignBuilderPage(driver, wait);
    cp.selectAllColumnPickerOptions();
	cp.clickAction("expand", campaignToBeEdited);	
    cp.allDisplayedTrackingNumberColumns();
    cp.clickAction("collapse",campaignToBeEdited);
    Util.getJavascriptExecutor().executeScript("window.scrollBy(0,-1500)");
    

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
	}
	
	
}
