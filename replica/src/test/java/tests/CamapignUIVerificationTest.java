package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.CampaignAndTrackingNumberPage;
import pom.HomePage;
import pom.campaignBuilderPage;

public class CamapignUIVerificationTest extends TestBase{

	HomePage hp;
	@BeforeClass
	public void goToCampaignPage() throws InterruptedException{
		hp=new HomePage(driver);
		logger=extent.startTest("Campaign and tracking number page page UI verification..");
		logger.assignCategory("Campaign Suite");
		logger.log(LogStatus.INFO, "going to campaign and tracking number page..");
	hp.clickAction("Campaign");
		
		
	}
	
	@Test(priority=1)
	public void CampaignAndTrackingNumberPage_UI_Verification() throws InterruptedException{
		
        
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);	
		logger.log(LogStatus.INFO, "verifying UI of campaign and tracking number page..");
		cp.campaignPageUIVerification();
//		Thread.sleep(2000);
		
		
	
	}
	
//	@Test(priority=2)
//	public void campaignBuilderPage_UI_Verification() throws InterruptedException{
//		
////		hp=new HomePage(driver);
////		hp.clickAction("Home");
////		hp.clickAction("Campaign");
//		logger=extent.startTest("Campaign builder page UI verification..");
//		logger.log(LogStatus.INFO, "going to campaign builder page..");
//		campaignBuilderPage cb=new campaignBuilderPage(driver, wait);
//		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);			
//		
//		cp.clickAction("add","");
//		cb.campaignBuilderPageUIVerification();
//		cb.collapseExpand_collapsible_strip();
//		cb.clickAction("list");	
////		Thread.sleep(2000);
//
//	}
	
	
	@AfterClass
	public void goToHomePage(){

		System.out.println("in goToHomePage()");
        Util.getJavascriptExecutor().executeScript("window.scrollBy(0,-2000)");	
        try {
			hp.clickAction("Home");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
