package tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import pom.CampaignAndTrackingNumberPage;
import pom.HomePage;
import pom.campaignBuilderPage;


public class CampaignTests extends TestBase {
	
	@Test(priority=1)
	public void test1() throws InterruptedException{
		
		HomePage hp=new HomePage(driver);
		logger=extent.startTest("Campaign and tracking number page page UI verification..");
		logger.assignCategory("Campaign Suite");
		logger.log(LogStatus.INFO, "going to campaign builder page..");
		hp.clickAction("Campaign");
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);	
		logger.log(LogStatus.INFO, "verifying UI of campaign builder page..");
		cp.campaignPageUIVerification();
	
	}
	
	@Test(priority=2)
	public void test2() throws InterruptedException{
		logger=extent.startTest("Campaign builder page UI verification..");
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);			
		cp.clickAction("add");
		campaignBuilderPage cb=new campaignBuilderPage(driver, wait);
		cb.campaignBuilderPageUIVerification();
		cb.collapseExpand_collapsible_strip();
		cp.clickAction("list");
		
		
	}
	
	@Test(priority=3)
	public void test3() throws InterruptedException{
		logger=extent.startTest("Campaign creation without external ID..");
		campaignBuilderPage cb=new campaignBuilderPage(driver, wait);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);			
		cp.clickAction("add");
		String campaign = cb.createCampaign_WithoutCampaignExternalID();
		CampaignAndTrackingNumberPage ctp=new CampaignAndTrackingNumberPage(driver, wait);
		cb.clickAction("list");
		ctp.campaignCreated(campaign);
		
	}
	
	
	
}
