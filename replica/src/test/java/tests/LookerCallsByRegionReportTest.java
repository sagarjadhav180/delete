package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.CallsByRegionReportPage;
import pom.AnalyticsSummaryReportPage;
import pom.CallLogsReportPage;
import pom.HomePage;
import pom.LoginPage;

public class LookerCallsByRegionReportTest extends TestBase{
	
	HomePage hp;
	CallLogsReportPage clr;
	CallsByRegionReportPage ts; 
	
	@BeforeClass
	public void goToLookerReports() throws Exception{
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
        goToReport();

	}

	public void goToReport() throws Exception{
		ts=new CallsByRegionReportPage(driver);
		clr=new CallLogsReportPage(driver);
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(1000);
		clr.goToReport(Constants.LookerReports.calls_by_region_report);
        Thread.sleep(7000);
		ts.switchToIFrame();
	}
	
	@Test(priority=1)
	public void runButtonVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Run Button Verification Test"); 
		logger.assignCategory(Constants.calls_by_region_category);
        ts=new CallsByRegionReportPage(driver);
		ts.runButton();
	}
	
	@Test(priority=2)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.calls_by_region_category);
        ts=new CallsByRegionReportPage(driver);
		ts.headerLabel();
	}
	
	@Test(priority=3)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.calls_by_region_category);
        ts=new CallsByRegionReportPage(driver);
		ts.presenceOfGearIcon();
	}
	
	@Test(priority=4)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.calls_by_region_category);
        ts=new CallsByRegionReportPage(driver);
        ts.gearIconOptions();
	}
	
	@Test(priority=5)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.calls_by_region_category);
        ts=new CallsByRegionReportPage(driver);
		ts.presenceOfTimeZone();
	}

	@Test(priority=6)
	public void presenceOfCallsByRegionGraphLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Calls By Region Graph Label Verification Test"); 
		logger.assignCategory(Constants.calls_by_region_category);
        ts=new CallsByRegionReportPage(driver);
		ts.callsByRegionGraphLabel();
	}
	
	@Test(priority=7)
	public void presenceOfCallsByRegionGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Calls By Region Graph Verification Test"); 
		logger.assignCategory(Constants.calls_by_region_category);
        ts=new CallsByRegionReportPage(driver);
		ts.callsByRegionGraph();
	}

	@Test(priority=8)
	public void presenceOfTopRegionGraphLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Top Region Graph Label Verification Test"); 
		logger.assignCategory(Constants.calls_by_region_category);
        ts=new CallsByRegionReportPage(driver);
		ts.topRegionGraphLabel();
	}
	
	@Test(priority=9)
	public void presenceOfTopRegionGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Top Region Graph Verification Test"); 
		logger.assignCategory(Constants.calls_by_region_category);
        ts=new CallsByRegionReportPage(driver);
		ts.topRegionGraphLabel();
	}
	
	@Test(priority=10)
	public void presenceOfCallsByStateGraphLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Calls By State Graph Label Verification Test"); 
		logger.assignCategory(Constants.calls_by_region_category);
        ts=new CallsByRegionReportPage(driver);
		ts.callsByStateGraphLabel();
	}
	
	@Test(priority=11)
	public void presenceOfCallsByStateGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Calls By State Graph Verification Test"); 
		logger.assignCategory(Constants.calls_by_region_category);
        ts=new CallsByRegionReportPage(driver);
		ts.callsByStateGraph();
	}
	
	@Test(priority=12)
	public void tableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Table Column Verification Test"); 
		logger.assignCategory(Constants.calls_by_region_category);
        ts=new CallsByRegionReportPage(driver);
		ts.tableColumnVerification();
	}
	
	@Test(priority=13)	
	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.calls_by_region_category);
        ts=new CallsByRegionReportPage(driver);
		ts.filterButton();
	}
	
	@Test(priority=14)
	public void filterButtonElementsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Elements Test"); 
		logger.assignCategory(Constants.calls_by_region_category);
        ts=new CallsByRegionReportPage(driver);
		ts.filterElements();
	}
	
	@AfterClass
	public void loggingOut() throws InterruptedException{
		
		ts=new CallsByRegionReportPage(driver);
		ts.switchToMainWindow();
		
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}
	
	
	
}
