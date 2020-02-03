package tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.CampaignAndTrackingNumberPage;
import pom.HomePage;
import pom.LoginPage;
import pom.TrackingNumberBuilderPage;
import pom.campaignBuilderPage;

public class TrackingNumberTest extends TestBase{
	
	
	//navigating to Campaign builder page
		@BeforeClass
		public void goToCampaignPage() throws IOException, InterruptedException{
			
			LoginPage lp=new LoginPage(driver);
	        logger=extent.startTest("validLogin"); 
	        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
	        logger.assignCategory("Login Suite");
	        lp.validLogin();
	        HomePage hp=new HomePage(driver);
	        hp.left_hand_navigation_bar_click();
			
			try {
				hp.clickAction("Campaign & Tracking Number");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
	

	//create tracking number
		@Test(priority=1)
		public void trakingNumberCreation() throws InterruptedException{
			logger=extent.startTest("Tracking number creation..");
			logger.assignCategory("Tracking number suite");
			
			campaignBuilderPage cb=new campaignBuilderPage(driver, wait);
			CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);			
		    cp.clickAction("update","SJC-1");
		    TrackingNumberBuilderPage tn=new TrackingNumberBuilderPage(driver);
		    int number1 = tests.Util.generateRandomNumber();
		    String tracking_number_name="SJ TN-"+String.valueOf(number1);
		    tn.createSimpleNumber(tracking_number_name);
		    Thread.sleep(2000);
		    cb.clickAction("list");
		}
		

}
