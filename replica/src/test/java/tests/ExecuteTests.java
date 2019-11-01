package tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import pom.CampaignAndTrackingNumberPage;
import pom.HomePage;



  


public class ExecuteTests extends TestBase {

	
	
	
	@Test(priority=1)
	public void test1() throws InterruptedException{
		
		HomePage hp=new HomePage(driver);
		logger=extent.startTest("Campaign builder page UI verification..");
		logger.assignCategory("Campaign Suite");
		logger.log(LogStatus.INFO, "going to campaign builder page..");
		hp.clickAction("Campaign");
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);	
		logger.log(LogStatus.INFO, "verifying UI of campaign builder page..");
		cp.campaignPageUIVerification();
	
	}
	
	@Test(priority=2)
	public void test2(){
		
	}
}
