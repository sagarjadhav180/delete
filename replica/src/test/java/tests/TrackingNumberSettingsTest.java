package tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.CallDetailsReport_Page;
import pom.HomePage;
import pom.LoginPage;
import pom.TrackingNumberSettingsReport_Page;

public class TrackingNumberSettingsTest extends TestBase{
	
	HomePage hp;
	TrackingNumberSettingsReport_Page tn;
	
	@BeforeClass
	public void goToTrackingNumberSettingsPage() throws IOException, InterruptedException{
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        logger.assignCategory("Login Suite");
        lp.validLogin();
        
        hp=new HomePage(driver);
        hp.left_hand_navigation_bar_click();
		hp.clickAction("Legacy Reports");
		
		hp.click_subLink("Tracking Number Settings");
	}
	
	//ui verification of call details page
	@Test(priority=1)
	public void uiVerification() throws InterruptedException{
		logger=extent.startTest("uiVerification Test");
		logger.assignCategory("Tracking Number Settings Test");
			
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.UIVerification();
	}
	
	
	
	
	
	
	
	
	
	

}
