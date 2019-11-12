package tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import pom.CampaignAndTrackingNumberPage;
import pom.HomePage;
import pom.campaignBuilderPage;


public class CampaignTests extends TestBase {

	HomePage hp;
	String campaign_name;
	int number1; 
	String campaign_name_updated;
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
		
		cp.clickAction("add","");
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
		
		cp.clickAction("add","");
		number1 = tests.Util.generateRandomNumber();
		campaign_name = "campaign "+number1;
		cb.createCampaign(campaign_name);
		cb.clickAction("list");
		cp.campaignCreated(campaign_name);
	
	}
	
	@Test(priority=4)
	public void campaign_updation_Without_externalID() throws InterruptedException{
		logger=extent.startTest("Campaign updation without external ID..");
		campaignBuilderPage cb=new campaignBuilderPage(driver, wait);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);			
	    cp.clickAction("update",campaign_name);
	    campaign_name_updated=campaign_name+"-updated";
	    cb.updateCampaign(campaign_name_updated);
		cb.clickAction("list");
		cp.campaignCreated(campaign_name_updated);
	
	}
	
	@Test(priority=5)
	public void campaign_deletion_Without_externalID() throws InterruptedException{
		logger=extent.startTest("Campaign deletion without external ID..");
		campaignBuilderPage cb=new campaignBuilderPage(driver, wait);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);			
	    cp.clickAction("archive",campaign_name);

	
	}
	
//	@Test(priority=6)
//	public void campaign_Creation_With_externalID() throws InterruptedException{
//		logger=extent.startTest("Campaign creation with external ID..");
//		campaignBuilderPage cb=new campaignBuilderPage(driver, wait);
//		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);			
//		
//		cp.clickAction("add");
//		int number1 = tests.Util.generateRandomNumber();
//		String campaign_name = "campaign "+number1;
//		int number2 = tests.Util.generateRandomNumber();
//		String external_id= "external_id "+number1;
//		
//		cb.createCampaign(campaign_name,external_id);
//		cb.clickAction("list");
//		cp.campaignCreated(campaign_name);
//	
//	}
	
	
	
	
}
