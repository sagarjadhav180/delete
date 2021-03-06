package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.CallerActivityReportPage;

import pom.CallLogsReportPage;
import pom.HomePage;
import pom.LoginPage;

public class LookerCallerActivityReportTest extends TestBase{

	HomePage hp;
	CallLogsReportPage clr;
	CallerActivityReportPage ts; 
	
	@BeforeClass
	public void goToLookerReports() throws Exception{
		LoginPage lp=new LoginPage(driver);
		lp.validLogin();
        
        goToReport();

	}

	public void goToReport() throws Exception{
		ts=new CallerActivityReportPage(driver);
		clr=new CallLogsReportPage(driver);
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(1000);
		clr.goToReport(Constants.LookerReports.caller_activity_report);
        Thread.sleep(7000);
		ts.switchToIFrame();
	}
	
	@Test(priority=1)
	public void runButtonVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Run Button Verification Test"); 
		logger.assignCategory(Constants.caller_activity_category);
        ts=new CallerActivityReportPage(driver);
		ts.runButton();
	}
	
	@Test(priority=2)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.caller_activity_category);
        ts=new CallerActivityReportPage(driver);
		ts.headerLabel();
	}
	
	@Test(priority=3)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.caller_activity_category);
        ts=new CallerActivityReportPage(driver);
		ts.presenceOfGearIcon();
	}
	
	@Test(priority=4)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.caller_activity_category);
        ts=new CallerActivityReportPage(driver);
        ts.gearIconOptions();
	}
	
	@Test(priority=5)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.caller_activity_category);
        ts=new CallerActivityReportPage(driver);
		ts.presenceOfTimeZone();
	}

	@Test(priority=6)
	public void presenceOfTopCallersTimeLineLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Top Callers TimeLine Label Verification Test"); 
		logger.assignCategory(Constants.caller_activity_category);
        ts=new CallerActivityReportPage(driver);
		ts.topCallersTimeLineLabel();
	}
	
	@Test(priority=7)
	public void presenceOfTopCallersTimeLineGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Top Callers TimeLine Graph Verification Test"); 
		logger.assignCategory(Constants.caller_activity_category);
        ts=new CallerActivityReportPage(driver);
		ts.topCallersTimeLineGraph();
	}
	
	@Test(priority=8)
	public void topCallersTimeLineTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Top Callers Time Line Table Column Verification Test"); 
		logger.assignCategory(Constants.caller_activity_category);
        ts=new CallerActivityReportPage(driver);
		ts.topCallersTimeLineTableColumnVerification();
	}
	
	@Test(priority=9)
	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.caller_activity_category);
        ts=new CallerActivityReportPage(driver);
        ts.filterButton();
	}
	
	@Test(priority=10)
	public void filterButtonElementsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Elements Test"); 
		logger.assignCategory(Constants.caller_activity_category);
        ts=new CallerActivityReportPage(driver);
		ts.filterElements();
	}
		
	@AfterClass
	public void loggingOut() throws InterruptedException{
		
		ts=new CallerActivityReportPage(driver);
		ts.switchToMainWindow();
		
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}
	
}
