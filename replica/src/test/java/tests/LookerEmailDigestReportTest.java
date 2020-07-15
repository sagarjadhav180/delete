package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.CallLogsReportPage;
import pom.CallerActivityReportPage;
import pom.EmailDigestReportPage;
import pom.HomePage;
import pom.LoginPage;
import pom.TagsSummaryPage;

public class LookerEmailDigestReportTest extends TestBase {

	HomePage hp;
	CallLogsReportPage clr;
	EmailDigestReportPage ts; 
	
	@BeforeClass
	public void goToLookerReports() throws Exception{
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
        goToReport();

	}

	public void goToReport() throws Exception{
		ts=new EmailDigestReportPage(driver);
		clr=new CallLogsReportPage(driver);
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(1000);
		clr.goToReport(Constants.LookerReports.email_digest_report);
        Thread.sleep(7000);
		ts.switchToIFrame();
	}

	@Test(priority=1)
	public void runButtonVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Run Button Verification Test"); 
		logger.assignCategory(Constants.email_digest_category);
        ts=new EmailDigestReportPage(driver);
		ts.runButton();
	}
	
	@Test(priority=2)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.email_digest_category);
        ts=new EmailDigestReportPage(driver);
		ts.headerLabel();
	}
	
	@Test(priority=3)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.email_digest_category);
        ts=new EmailDigestReportPage(driver);
		ts.presenceOfGearIcon();
	}
	
	@Test(priority=4)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.email_digest_category);
        ts=new EmailDigestReportPage(driver);
        ts.gearIconOptions();
	}
	
	@Test(priority=5)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.email_digest_category);
        ts=new EmailDigestReportPage(driver);
		ts.presenceOfTimeZone();
	}
	
	@Test(priority=6)
	public void presenceOfSummaryOfCallsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Summary Of Calls Label Verification Test"); 
		logger.assignCategory(Constants.email_digest_category);
        ts=new EmailDigestReportPage(driver);
		ts.summaryOfCallsLabel();
	}
	
	@Test(priority=7)
	public void summaryOfCallsTableColumnsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Summary Of Calls Table Columns Verification Test"); 
		logger.assignCategory(Constants.email_digest_category);
        ts=new EmailDigestReportPage(driver);
		ts.summaryOfCallsTableColumnVerification();
	}
	
	@Test(priority=8)
	public void presenceOfCoachableCallsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Coachable Calls Label Verification Test"); 
		logger.assignCategory(Constants.email_digest_category);
        ts=new EmailDigestReportPage(driver);
		ts.coachableCallsLabel();
	}
	
	@Test(priority=9)
	public void coachableCallsTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Coachable Calls Table Column Verification Test"); 
		logger.assignCategory(Constants.email_digest_category);
        ts=new EmailDigestReportPage(driver);
		ts.coachableCallsTableColumnVerification();
	}
	
	@Test(priority=10)
	public void presenceOfGoodCallsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Good Calls Label Verification Test"); 
		logger.assignCategory(Constants.email_digest_category);
        ts=new EmailDigestReportPage(driver);
		ts.goodCallsLabel();
	}

	@Test(priority=11)
	public void goodCallsTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Good Calls Table Column Verification Test"); 
		logger.assignCategory(Constants.email_digest_category);
        ts=new EmailDigestReportPage(driver);
		ts.goodCallsTableColumnVerification();
	}
	
	@Test(priority=12)
	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.email_digest_category);
        ts=new EmailDigestReportPage(driver);
        ts.filterButton();
	}
	
	@Test(priority=13)
	public void filterButtonElementsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Elements Test"); 
		logger.assignCategory(Constants.email_digest_category);
        ts=new EmailDigestReportPage(driver);
		ts.filterElements();
	}
	
	@Test(priority=14)
	public void filterFeatureForGroupTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature Group Test"); 
		logger.assignCategory(Constants.email_digest_category);
        ts=new EmailDigestReportPage(driver);
        ts.filterFeatureForCallsTable(Constants.LookerEmailDigestReport.group_filter);
	}
	
	@AfterClass
	public void loggingOut() throws InterruptedException{
		
		ts=new EmailDigestReportPage(driver);
		ts.switchToMainWindow();
		
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}
	
	
	
}
