package tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import pom.CampaignAndTrackingNumberPage;
import pom.HomePage;
import pom.campaignBuilderPage;


public class CampaignTests extends TestBase {

	HomePage hp;
	
	@Test(priority=1)
	public void CampaignAndTrackingNumberPage_UI_Verification() throws InterruptedException{
		
        hp=new HomePage(driver);
		logger=extent.startTest("Campaign and tracking number page page UI verification..");
		logger.assignCategory("Campaign Suite");
		logger.log(LogStatus.INFO, "going to campaign and tracking number page..");
		hp.clickAction("Campaign");
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);	
		logger.log(LogStatus.INFO, "verifying UI of campaign and tracking number page..");
		cp.campaignPageUIVerification();
		Thread.sleep(2000);
		
	}
	@Test(priority=2)
	public void campaignBuilderPage_UI_Verification() throws InterruptedException{
		
		logger=extent.startTest("Campaign builder page UI verification..");
		logger.log(LogStatus.INFO, "going to campaign builder page..");
		campaignBuilderPage cb=new campaignBuilderPage(driver, wait);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);			
		cp.clickAction("add");
		cb.campaignBuilderPageUIVerification();
		cb.collapseExpand_collapsible_strip();
		cb.clickAction("list");	
		Thread.sleep(2000);
	
	}
	
	@Test(priority=3)
	public void campaign_Creation_Without_externalID() throws InterruptedException{
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
