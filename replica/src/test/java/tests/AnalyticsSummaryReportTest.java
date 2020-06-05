package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.CallLogsReportPage;
import pom.CallTrendsReportPage;
import pom.AnalyticsSummaryReportPage;
import pom.HomePage;
import pom.LoginPage;

public class AnalyticsSummaryReportTest extends TestBase{

	HomePage hp;
	CallLogsReportPage clr;
	AnalyticsSummaryReportPage ts; 
	
	@BeforeClass
	public void goToLookerReports() throws Exception{
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
        goToReport();

	}

	public void goToReport() throws Exception{
		ts=new AnalyticsSummaryReportPage(driver);
		clr=new CallLogsReportPage(driver);
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(1000);
		clr.goToReport(Constants.LookerReports.analytics_summary_report);
        Thread.sleep(7000);
		ts.switchToIFrame();
	}
	
	@Test(priority=1)
	public void runButtonVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Run Button Verification Test"); 
		logger.assignCategory(Constants.analytics_summary_category);
        ts=new AnalyticsSummaryReportPage(driver);
		ts.runButton();
	}
	
	@Test(priority=2)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.analytics_summary_category);
        ts=new AnalyticsSummaryReportPage(driver);
		ts.headerLabel();
	}
	
	@Test(priority=3)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.analytics_summary_category);
        ts=new AnalyticsSummaryReportPage(driver);
		ts.presenceOfGearIcon();
	}
	
	@Test(priority=4)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.analytics_summary_category);
        ts=new AnalyticsSummaryReportPage(driver);
        ts.gearIconOptions();
	}
	
	@Test(priority=5)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.analytics_summary_category);
        ts=new AnalyticsSummaryReportPage(driver);
		ts.presenceOfTimeZone();
	}

	@Test(priority=6)
	public void tilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tiles Verification Test"); 
		logger.assignCategory(Constants.analytics_summary_category);
        ts=new AnalyticsSummaryReportPage(driver);
		ts.tilesVerification();
	}
	
	@Test(priority=7)
	public void totalCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Total Calls Count Verification Test"); 
		logger.assignCategory(Constants.analytics_summary_category);
        ts=new AnalyticsSummaryReportPage(driver);
		ts.tileValueVerificationForDefault7DaysFilter(Constants.LookerAnalyticsSummaryReport.total_call_tile);
	}
	
	@Test(priority=8)
	public void analyzedCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Analyzed Calls Count Verification Test"); 
		logger.assignCategory(Constants.analytics_summary_category);
        ts=new AnalyticsSummaryReportPage(driver);
		ts.tileValueVerificationForDefault7DaysFilter(Constants.LookerAnalyticsSummaryReport.total_analyzed_calls_tile);
	}
	
	@Test(priority=9)
	public void presenceOfIndicatorGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Indicator Graph Verification Test"); 
		logger.assignCategory(Constants.analytics_summary_category);
        ts=new AnalyticsSummaryReportPage(driver);
		ts.hitMissGraph();
	}
	
	@Test(priority=10)
	public void presenceOfIndicatorsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Indicators Verification Test"); 
		logger.assignCategory(Constants.analytics_summary_category);
        ts=new AnalyticsSummaryReportPage(driver);
		ts.hitMissGraphindicatorVerification();
	}
	
	@Test(priority=11)
	public void hitMissTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Hit Miss Table Column Verification Test"); 
		logger.assignCategory(Constants.analytics_summary_category);
        ts=new AnalyticsSummaryReportPage(driver);
		ts.hitMixTableColumnVerification();
	}
	
	@Test(priority=12)
	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.analytics_summary_category);
        ts=new AnalyticsSummaryReportPage(driver);
		ts.filterButton();
	}
	
	@Test(priority=13)
	public void filterButtonElementsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Elements Test"); 
		logger.assignCategory(Constants.analytics_summary_category);
        ts=new AnalyticsSummaryReportPage(driver);
		ts.filterElements();
	}
	
	@AfterClass
	public void loggingOut() throws InterruptedException{
		
		ts=new AnalyticsSummaryReportPage(driver);
		ts.switchToMainWindow();
		
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}
	
}
