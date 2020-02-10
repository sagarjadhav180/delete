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
	hp=new HomePage(driver);
//    hp.left_hand_navigation_bar_click();
	logger.log(LogStatus.INFO, "going to campaign and tracking number page..");
	hp.clickAction("Campaign & Tracking Number");
		
		
	}
	
	
	//Campaign and tracking number page - UI verification
	@Test(priority=1)
	public void CampaignAndTrackingNumberPage_UI_Verification() throws InterruptedException{
		logger=extent.startTest("Campaign and tracking number page page UI verification..");
		logger.assignCategory("Campaign Suite");
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);	
		logger.log(LogStatus.INFO, "verifying UI of campaign and tracking number page..");
		cp.campaignPageUIVerification();
		
	}
	
	@Test(priority=2)
	public void defaultColumnsDisplayed() throws InterruptedException {
		logger=extent.startTest("Default columns displayed");
		logger.assignCategory("Campaign Suite");
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);	
		cp.clickAction("expand", "Do not delete--expand scenario");
		cp.toCheckDefaultDisplayedColumns();
		cp.clickAction("collapse", "Do not delete--expand scenario");
		Util.getJavascriptExecutor().executeScript("window.scrollBy(0,-1500)","");
		
	}
	
	@Test(priority=3)
	public void allColumnsDisplayed() throws InterruptedException {
		logger=extent.startTest("all columns displayed");
		logger.assignCategory("Campaign Suite");
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);	
		cp.toCheckOptionsFromColumnPicker();
		
		Thread.sleep(2000);

		cp.clickAction("expand", "Do not delete--expand scenario");
		Thread.sleep(10000);
		cp.toCheckAllDisplayedColumns();
		cp.clickAction("collapse", "Do not delete--expand scenario");
		Util.getJavascriptExecutor().executeScript("window.scrollBy(0,-1500)","");
		
	}

	
	
	@AfterClass
	public void goToHomePage(){

        Util.getJavascriptExecutor().executeScript("window.scrollBy(0,-2000)");	
        try {
			hp.clickAction("Home");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
