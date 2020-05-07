package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.BlockedCallsReportPage;
import pom.CallBackReportPage;
import pom.CallLogsReportPage;
import pom.HomePage;
import pom.LoginPage;
import pom.LookerTrackingNumberSettingsPage;

public class CallBackReportTest extends TestBase {

	HomePage hp;
	CallLogsReportPage clr;
	CallBackReportPage cb;
	
	@BeforeClass
	public void goToLookerReports() throws Exception{
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
        goToReport();
	}
	
	public void goToReport() throws Exception{
		cb=new CallBackReportPage(driver);
		clr=new CallLogsReportPage(driver);
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(1000);
		clr.goToReport(Constants.LookerReports.call_back_report);
        Thread.sleep(7000);
		cb.switchToIFrame();
	}

	@Test(priority=1)
	public void runButtonVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Run Button Verification Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
		cb.runButton();
	}
	
	@Test(priority=2)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
		cb.headerLabel();
	}
	
	@Test(priority=3)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
		cb.presenceOfGearIcon();
	}

	@Test(priority=4)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
        cb.gearIconOptions();
	}
	
	@Test(priority=5)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
		cb.presenceOfTimeZone();
	}

	@Test(priority=6)
	public void tilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tiles Verification Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
		cb.tilesVerification();
	}
	
	@Test(priority=7)
	public void toalCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Toal Calls Count Verification Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
		cb.tileValueVerification(Constants.LookerCallBackReport.total_calls_tile);
	}
	
	@Test(priority=8)
	public void AnsweredCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Answered Calls Count Verification Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
		cb.tileValueVerification(Constants.LookerCallBackReport.answered_calls_tile);
	}
	
	@Test(priority=9)
	public void avgCallDurationVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Avg Call Duration Verification Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
		cb.tileValueVerification(Constants.LookerCallBackReport.average_calls_duration_tile);
	}
	
	@Test(priority=10)
	public void missedOppCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Missed Opp Calls Count Verification Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
		cb.tileValueVerification(Constants.LookerCallBackReport.missed_opportunity_tile);
	}
	
	@Test(priority=11)
	public void taggedAsCallBackCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tagged As Call Back Count Verification Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
		cb.tileValueVerification(Constants.LookerCallBackReport.call_back_tag_tile);
	}
	
	@Test(priority=12)
	public void presenceOfMissedOpportunityOverTimeLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Missed Opportunity Over Time Label Verification Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
		cb.presenceOfMissedOpportunityOverTimeLabel();
	}
	
	@Test(priority=13)
	public void presenceOfMissedOpportunityOverTimeGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Missed Opportunity Over Time Graph Verification Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
		cb.presenceOfMissedOpportunityOverTimeGraph();
	}
	
	@Test(priority=14)
	public void presenceOfMissedOpportunitySummaryLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Missed Opportunity Summary Label Verification Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
		cb.presenceOfMissedOpportunitySummaryLabel();
	}
	
	@Test(priority=15)
	public void missedOpportunitySummaryTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Missed Opportunity Summary Table Column Verification Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
		cb.missedOppTableColumnVerification();
	}
	
	@Test(priority=16)
	public void presenceOfTaggedAsCallBackLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Tagged As Call Back Label Verification Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
		cb.presenceOfTaggedAsCallBackLabel();
	}
	
	@Test(priority=17)
	public void taggedAsCallBackTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tagged As Call Back Table Column Verification Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
		cb.taggedAsCallBackTableColumnVerification();
	}
	
	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
        cb.filterButton();
	}
	
	public void filterButtonElementsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Elements Test"); 
		logger.assignCategory(Constants.call_back_category);
        cb=new CallBackReportPage(driver);
        cb.filterElements();
	}
	
	@AfterClass
	public void loggingOut() throws InterruptedException{
		cb=new CallBackReportPage(driver);
		cb.switchToMainWindow();
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}

}
