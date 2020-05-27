package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.CallLogsReportPage;
import pom.HomePage;
import pom.LoginPage;
import pom.TagsSummaryPage;
import pom.WebhookLogsReportPage;

public class WebhookReportTest extends TestBase{
	
	HomePage hp;
	CallLogsReportPage clr;
	WebhookLogsReportPage ts; 
	
	@BeforeClass
	public void goToLookerReports() throws Exception{
		LoginPage lp=new LoginPage(driver);
		ts=new WebhookLogsReportPage(driver);
		logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
        goToReport();

	}

	public void goToReport() throws Exception{
		ts=new WebhookLogsReportPage(driver);
		clr=new CallLogsReportPage(driver);
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(1000);
		clr.goToReport(Constants.LookerReports.webhook_logs_report);
        Thread.sleep(7000);
		ts.switchToIFrame();
	}

	@Test(priority=1)
	public void runButtonVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Run Button Verification Test"); 
		logger.assignCategory(Constants.webhook_category);
        ts=new WebhookLogsReportPage(driver);
		ts.runButton();
	}
	
	@Test(priority=2)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.webhook_category);
        ts=new WebhookLogsReportPage(driver);
		ts.headerLabel();
	}
	
	@Test(priority=3)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.webhook_category);
        ts=new WebhookLogsReportPage(driver);
		ts.presenceOfGearIcon();
	}
	
	@Test(priority=4)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.webhook_category);
        ts=new WebhookLogsReportPage(driver);
        ts.gearIconOptions();
	}
	
	@Test(priority=5)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.webhook_category);
        ts=new WebhookLogsReportPage(driver);
		ts.presenceOfTimeZone();
	}
	
	public void tilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tiles Verification Test"); 
		logger.assignCategory(Constants.webhook_category);
        ts=new WebhookLogsReportPage(driver);
		ts.tilesVerification();
	}
	
	public void toalCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Toal Calls Count Verification Test"); 
		logger.assignCategory(Constants.webhook_category);
        ts=new WebhookLogsReportPage(driver);
		ts.tileValueVerification(Constants.LookerWebhookLogsReport.total_call_tile);
	}
	
	public void preCallWebhookCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Pre Call Webhook Count Verification Test"); 
		logger.assignCategory(Constants.webhook_category);
        ts=new WebhookLogsReportPage(driver);
		ts.tileValueVerification(Constants.LookerWebhookLogsReport.pre_call_webhook_tile);
	}
	
	public void postCallWebhookCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Post Call Webhook Count Verification Test"); 
		logger.assignCategory(Constants.webhook_category);
        ts=new WebhookLogsReportPage(driver);
		ts.tileValueVerification(Constants.LookerWebhookLogsReport.post_call_webhook_tile);
	}
	
	public void presenceOfWebhookSummaryLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of WebhookSummary Label Verification Test"); 
		logger.assignCategory(Constants.webhook_category);
		ts=new WebhookLogsReportPage(driver);
		ts.webhookSummaryLabel();
	}
	
	public void webhookSummaryTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Webhook Summary Table Column Verification Test"); 
		logger.assignCategory(Constants.webhook_category);
		ts=new WebhookLogsReportPage(driver);
		ts.webhookSummaryTableColumnVerification();
	}
	
	public void presenceOfWebhookLogsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Webhook Logs Label Verification Test"); 
		logger.assignCategory(Constants.webhook_category);
		ts=new WebhookLogsReportPage(driver);
		ts.webhookLogsLabel();
	}
	
	public void webhookLogsTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Webhook Logs Table Column Verification Test"); 
		logger.assignCategory(Constants.webhook_category);
		ts=new WebhookLogsReportPage(driver);
		ts.webhookLogsTableColumnVerification();
	}
	
	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.webhook_category);
		ts=new WebhookLogsReportPage(driver);
		ts.filterButton();
	}
	
	public void filterButtonElementsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Elements Test"); 
		logger.assignCategory(Constants.webhook_category);
		ts=new WebhookLogsReportPage(driver);
		ts.filterElements();
	}
	
	public void filterFeatureForWebhookSummaryTableWebhookTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature For Webhook Summary Table Webhook Test"); 
		logger.assignCategory(Constants.webhook_category);
		ts=new WebhookLogsReportPage(driver);
		ts.filterFeatureForWebhookSummaryTable(Constants.LookerWebhookLogsReport.webhhok_filter);
	}
	
	public void filterFeatureForWebhookLogsTableWebhookTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature For Webhook Logs Table Webhook Test"); 
		logger.assignCategory(Constants.webhook_category);
		ts=new WebhookLogsReportPage(driver);
		ts.filterFeatureForWebhookLogsTable(Constants.LookerWebhookLogsReport.webhhok_filter);
	}
	
	public void filterFeatureForWebhookLogsTableWebhookStatusTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature For Webhook Logs Table Webhook Status Test"); 
		logger.assignCategory(Constants.webhook_category);
		ts=new WebhookLogsReportPage(driver);
		ts.filterFeatureForWebhookLogsTable(Constants.LookerWebhookLogsReport.status_filter);
	}
	
	@AfterClass
	public void loggingOut() throws InterruptedException{
		
		ts=new WebhookLogsReportPage(driver);
		ts.switchToMainWindow();
		
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}

}
