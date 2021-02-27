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
import pom.CampaignBuilderPage;


public class CampaignTests extends TestBase {

	HomePage hp;
	String campaign_name;
	String campaign_name_updated;
	String external_id;
	String external_id_updated;
	int number1; 
	int number2;
	
	
	//navigating to Campaign builder page
	@BeforeClass
	public void goToCampaignPage() throws IOException, InterruptedException{
		
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        logger.assignCategory(Constants.login_page_category);
        lp.validLogin();
        HomePage hp=new HomePage(driver);
        
		try {
			hp.clickAction(Constants.HomePage.campaign_tracking_number_page);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	
	
	
	//Campaign builder page - UI verification
	@Test(priority=1)
	public void campaignBuilderPage_UI_Verification() throws InterruptedException{
		
        logger=extent.startTest("Campaign builder page UI verification..");
		logger.assignCategory(Constants.campaign_category);
        logger.log(LogStatus.INFO, "going to campaign builder page..");
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);	
		CampaignBuilderPage cb=new CampaignBuilderPage(driver, wait);
		
		cp.clickAction("add","");
		cb.campaignBuilderPageUIVerification();
		cb.collapseExpand_collapsible_strip();
		cb.clickAction("list");	
//		Thread.sleep(2000);

	}
	
	
	
	
	//To check if logged in user is displayed in campaign owner dropdown by default
		@Test(priority=2)
		public void campaignDefaultOwnerValidation() throws InterruptedException, IOException{
			logger=extent.startTest("Check if logged in user is displayed in campaign owner dropdown by default");
			logger.assignAuthor(Constants.campaign_category);
			CampaignBuilderPage cb=new CampaignBuilderPage(driver, wait);
			CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);			
			
			cp.clickAction("add","");
			cb.defaultCampaignOwner();
			
			cb.clickAction("list");
		}
	
	//Create Campaign without campaign external ID
	@Test(priority=3)
	public void campaign_Creation_Without_externalID() throws InterruptedException{
		
		logger=extent.startTest("Campaign creation without external ID..");
		logger.assignCategory(Constants.campaign_category);
		CampaignBuilderPage cb=new CampaignBuilderPage(driver, wait);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);			
		
		cp.clickAction("add","");
		number1 = tests.Util.generateRandomNumber();
		campaign_name = "0SJC "+number1;
		cb.create(campaign_name,"",0,0);
		cb.clickAction("list");
//		cp.campaignCreated(campaign_name);
//		Thread.sleep(2000);
	}
		
	//Edit Campaign without campaign external ID
	@Test(priority=4)
	public void campaign_updation_Without_externalID() throws InterruptedException{
		logger=extent.startTest("Campaign updation without external ID..");
		logger.assignCategory(Constants.campaign_category);
		CampaignBuilderPage cb=new CampaignBuilderPage(driver, wait);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);			
	    cp.clickAction("update",campaign_name);
	    campaign_name_updated=campaign_name+"-updated";
	    cb.edit(campaign_name_updated);
		cb.clickAction("list");
//		cp.campaignCreated(campaign_name_updated);
//		Thread.sleep(2000);
	}
	
	
	//Delete Campaign without campaign external ID
	@Test(priority=5)
	public void campaign_deletion_Without_externalID() throws InterruptedException{
	
		logger=extent.startTest("Campaign deletion without external ID..");
		logger.assignCategory(Constants.campaign_category);
		
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);			
	    cp.clickAction("archive",campaign_name);
//		Thread.sleep(10000);
//	    driver.navigate().refresh();
	}
	
	//CreateCampaign with campaign external ID
	@Test(priority=6)
	public void campaign_Creation_With_externalID() throws InterruptedException{
//		hp=new HomePage(driver);
//		hp.clickAction("Home");
//		hp.clickAction("Campaign");
		logger=extent.startTest("Campaign creation with external ID..");
		logger.assignCategory(Constants.campaign_category);
		CampaignBuilderPage cb=new CampaignBuilderPage(driver, wait);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);			
		
		cp.clickAction("add", "");
		 number1 = tests.Util.generateRandomNumber();
		 campaign_name = "0SJC "+number1;
		 number2 = tests.Util.generateRandomNumber();
		 external_id= "external_id "+number2;
		
		cb.create(campaign_name,external_id,0,0);
		cb.clickAction("list");
//		cp.campaignCreated(campaign_name);
		Thread.sleep(2000);
	}
	
	//Edit Campaign with campaign external ID
	@Test(priority=7)
	public void campaign_updation_With_externalID() throws InterruptedException{
		logger=extent.startTest("Campaign updation with external ID..");
		logger.assignCategory(Constants.campaign_category);
		CampaignBuilderPage cb=new CampaignBuilderPage(driver, wait);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);			
	    cp.clickAction("update",campaign_name);
	    campaign_name_updated=campaign_name+"-updated";
	    external_id_updated=external_id+"-updated";
	    cb.edit(campaign_name_updated);
		cb.clickAction("list");
//		cp.campaignCreated(campaign_name_updated);
		Thread.sleep(2000);
	}
	
	//Delete Campaign with campaign external ID
	@Test(priority=8)
	public void campaign_deletion_With_externalID() throws InterruptedException{
		logger=extent.startTest("Campaign deletion without external ID..");
		logger.assignCategory(Constants.campaign_category);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);			
	    cp.clickAction("archive",campaign_name);
//	    driver.navigate().refresh();

	
	}
	
	//CreateCampaignWithFutureStartDateAndNeverEndDate
	@Test(priority=9)
	public void campaignCreationWithFutureStartDateAndNeverEndDate() throws InterruptedException{
		
//		hp=new HomePage(driver);
//		hp.clickAction("Home");
//		hp.clickAction("Campaign");
		logger=extent.startTest("Campaign creation with future start date..");
		logger.assignCategory(Constants.campaign_category);
		CampaignBuilderPage cb=new CampaignBuilderPage(driver, wait);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);			
		
		cp.clickAction("add", "");
		 number1 = tests.Util.generateRandomNumber();
		 campaign_name = "0SJC "+number1;
		 System.out.println("++++++++++++++++++++++++++++++");
		 System.err.println(campaign_name);
		 System.out.println("++++++++++++++++++++++++++++++");		 
		 number2 = tests.Util.generateRandomNumber();
		 external_id= "external_id "+number2;
		
		cb.create(campaign_name,external_id,Util.getDate(),0);
		cb.clickAction("list");
//		cp.campaignCreated(campaign_name);
		Thread.sleep(2000);
	}	
	
	//Edit campaignWithFutureStartDateAndNeverEndDate
	@Test(priority=10)
	public void campaignUpdationWithFutureStartDateAndNeverEndDate() throws InterruptedException{
		logger=extent.startTest("Campaign updation with future start date..");
		logger.assignCategory(Constants.campaign_category);
		CampaignBuilderPage cb=new CampaignBuilderPage(driver, wait);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);			
		cp.clickAction("update",campaign_name);
	    campaign_name_updated=campaign_name+"-updated";
		 System.out.println("++++++++++++++++++++++++++++++");
		 System.err.println(campaign_name_updated);
		 System.out.println("++++++++++++++++++++++++++++++");
	    external_id_updated=external_id+"-updated";
	    cb.edit(campaign_name_updated);
		cb.clickAction("list");
//		cp.campaignCreated(campaign_name_updated);
		
		Thread.sleep(2000);
	}
	
	//Delete campaignWithFutureStartDateAndNeverEndDate
	@Test(priority=11)
	public void campaign_deletion_With_futureStartDate() throws InterruptedException{
     	logger=extent.startTest("Campaign deletion with future start date..");
		logger.assignCategory(Constants.campaign_category);
     	CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);			
	    cp.clickAction("archive",campaign_name);
//	    driver.navigate().refresh();
	 
	}
	
	//Create CampaignWithFutureStartDateAndFutureEndDate
	@Test(priority=12)
	public void campaignCreationWithFutureStartDateAndFutureEndDate() throws InterruptedException{
//		hp=new HomePage(driver);
//		hp.clickAction("Home");
//		hp.clickAction("Campaign");
		logger=extent.startTest("Campaign creation with future start date and future end date..");
		logger.assignCategory(Constants.campaign_category);
		CampaignBuilderPage cb=new CampaignBuilderPage(driver, wait);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);			
		
		cp.clickAction("add", "");
		 number1 = tests.Util.generateRandomNumber();
		 campaign_name = "0SJC "+number1;
		 System.out.println("++++++++++++++++++++++++++++++");
		 System.err.println(campaign_name);
		 System.out.println("++++++++++++++++++++++++++++++");		 
		 number2 = tests.Util.generateRandomNumber();
		 external_id= "external_id "+number2;
		
		cb.create(campaign_name,external_id,Util.getDate(),Util.getDate());
		cb.clickAction("list");
//		cp.campaignCreated(campaign_name);
		Thread.sleep(2000);
	}	
	
	//Edit CampaignWithFutureStartDateAndFutureEndDate
	@Test(priority=13)
	public void campaignUpdationWithFutureStartDateAndFutureEndDate() throws InterruptedException{
		logger=extent.startTest("Campaign updation with future start date And FutureEndDate..");
		logger.assignCategory(Constants.campaign_category);
		CampaignBuilderPage cb=new CampaignBuilderPage(driver, wait);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);			
		cp.clickAction("update",campaign_name);
	    campaign_name_updated=campaign_name+"-updated";
		 System.out.println("++++++++++++++++++++++++++++++");
		 System.err.println(campaign_name_updated);
		 System.out.println("++++++++++++++++++++++++++++++");
	    external_id_updated=external_id+"-updated";
	    cb.edit(campaign_name_updated);
		cb.clickAction("list");
//		cp.campaignCreated(campaign_name_updated);
		
		Thread.sleep(2000);
	}
	
	//Delete CampaignWithFutureStartDateAndFutureEndDate
	@Test(priority=14)
	public void campaign_deletion_With_futureStartDateAndFutureEndDate() throws InterruptedException{
		logger=extent.startTest("Campaign deletion with future start date And Future EndDate ..");
		logger.assignCategory(Constants.campaign_category);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);			
	    cp.clickAction("archive",campaign_name);
//	    driver.navigate().refresh();
	 
	}
	
	//Check if appropriate alert is displayed while creating CampaignWithPastTime--negative scenario
	@Test(priority=15)
	public void campaignCreationWithPastTime() throws InterruptedException{
//		hp=new HomePage(driver);
//		hp.clickAction("Home");
//		hp.clickAction("Campaign");
		logger=extent.startTest("Campaign creation with past start date..");
		logger.assignCategory(Constants.campaign_category);
		CampaignBuilderPage cb=new CampaignBuilderPage(driver, wait);
		CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver);			
		
		cp.clickAction("add", "");
		 number1 = tests.Util.generateRandomNumber();
		 campaign_name = "campaign "+number1;

		
		cb.createPastDateCampaign(campaign_name,Util.getDate());
		
		Thread.sleep(2000);
	}
	
	//Navigating back to Home page
	@AfterClass
	public void goToHomePage(){
        
		HomePage hp=new HomePage(driver);
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
