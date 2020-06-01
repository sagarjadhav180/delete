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
import pom.CallTrendsReportPage;

public class CallTrendsReportTest extends TestBase{

	HomePage hp;
	CallLogsReportPage clr;
	CallTrendsReportPage ts; 
	
	@BeforeClass
	public void goToLookerReports() throws Exception{
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
        goToReport();

	}

	public void goToReport() throws Exception{
		ts=new CallTrendsReportPage(driver);
		clr=new CallLogsReportPage(driver);
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(1000);
		clr.goToReport(Constants.LookerReports.call_trends_report);
        Thread.sleep(7000);
		ts.switchToIFrame();
	}

	@Test(priority=1)
	public void runButtonVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Run Button Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.runButton();
	}
	
	@Test(priority=2)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.headerLabel();
	}
	
	@Test(priority=3)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.presenceOfGearIcon();
	}
	
	@Test(priority=4)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
        ts.gearIconOptions();
	}
	
	@Test(priority=5)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.presenceOfTimeZone();
	}
	
	public void tilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tiles Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.tilesVerification();
	}
	
	public void totalCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Total Calls Count Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.tileValueVerificationForDefault7DaysFilter(Constants.LookerCallTrendsReport.total_calls_tile);
	}
	
	public void uniqueCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Unique Calls Count Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.tileValueVerificationForDefault7DaysFilter(Constants.LookerCallTrendsReport.unique_calls_tile);
	}
	
	public void answeredCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Answered Calls Count Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.tileValueVerificationForDefault7DaysFilter(Constants.LookerCallTrendsReport.answered_calls_tile);
	}
	
	public void unAnsweredCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Unanswered Calls Count Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.tileValueVerificationForDefault7DaysFilter(Constants.LookerCallTrendsReport.unanswered_calls_tile);
	}
	
	public void longestCallDurationVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Longest Call Duration Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.tileValueVerificationForDefault7DaysFilter(Constants.LookerCallTrendsReport.longest_call_duration_tile);
	}
	
	public void averageCallDurationVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Average Call Duration Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.tileValueVerificationForDefault7DaysFilter(Constants.LookerCallTrendsReport.average_calls_duration_tile);
	}
	
	public void presenceOfCallsOverTimebyDayLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Calls Over Time by Day Label Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.callsOverTimebyDayLabel();
	}

	public void presenceOfCallsOverTimebyDayGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Calls Over Time by Day Graph Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.callsOverTimebyDayGraph();
	}
	
	public void callsOverTimebyDayTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Calls Over Time by Day Table Column Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.callsOverTimebyDayTableColumnVerification();
	}
	
	public void presenceOfCallsOverTimebyHourLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Calls Over Time by Hour Label Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.callsOverTimebyHourLabel();
	}
	
	public void presenceOfCallsOverTimebyHourGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Calls Over Time by Hour Graph Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.callsOverTimebyHourGraph();
	}
	
	public void callsOverTimebyHourTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Calls Over Time by Hour Table Column Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.callsOverTimebyHourTableColumnVerification();
	}
	
	public void presenceOfCallMixLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Call Mix Label Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.callsMixLabel();
	}
	
	public void presenceOfCallMixGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Call Mix Graph Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.callMixGraph();
	}
	
	public void callMixTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Call Mix Table Column Verification Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.callMixTableColumnVerification();
	}
	
	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.filterButton();
	}
	
	public void filterButtonElementsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Elements Test"); 
		logger.assignCategory(Constants.call_trends_category);
        ts=new CallTrendsReportPage(driver);
		ts.filterElements();
	}
	
	@AfterClass
	public void loggingOut() throws InterruptedException{
		
		ts=new CallTrendsReportPage(driver);
		ts.switchToMainWindow();
		
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}
	
}
