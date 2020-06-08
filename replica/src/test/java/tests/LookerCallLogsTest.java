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
import pom.LookerTrackingNumberSettingsPage;

@SuppressWarnings("unused")
public class LookerCallLogsTest extends TestBase{

	HomePage hp;
	CallLogsReportPage clr;
	
	@BeforeClass
	public void goToLookerReports() throws InterruptedException, IOException{
		LoginPage lp=new LoginPage(driver);
		clr=new CallLogsReportPage(driver);
//		clr.callDataInsertion();
//		Thread.sleep(60000);
		logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(7000);

		clr.switchToIFrame();

	}
	
	
	@Test(priority=1)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Call logs header Label Verification Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
		clr.headerLabel();
	}
	
	@Test(priority=2)
	public void runButtonVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Run Button Verification Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
		clr.runButton();
	}
	
	@Test(priority=3)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
		clr.presenceOfTimeZone();
	}
	
	@Test(priority=4)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
		clr.presenceOfGearIcon();
	}
	
	@Test(priority=5)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
		clr.gearIconOptions();
	}
	
	@Test(priority=6)
	public void tilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tiles Verification Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.tilesVerification();
	}

	@Test(priority=7)
	public void totalCallsTileValueVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Total Calls Tile Values Verification Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.tileValueVerificationForDefault7DaysFilter(Constants.CallLogsReport.total_calls_tile);
	}
	
	@Test(priority=8)
	public void uniqueCallsTileValueVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Unique Calls Tile Values Verification Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.tileValueVerificationForDefault7DaysFilter(Constants.CallLogsReport.unique_calls_tile);
	}
	
	@Test(priority=9)
	public void answeredCallsTileValueVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Answered Calls Tile Values Verification Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.tileValueVerificationForDefault7DaysFilter(Constants.CallLogsReport.answered_calls_tile);
	}
	
	@Test(priority=10)
	public void averageCallsDurationTileValueVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Average Calls Duration Tile Values Verification Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.tileValueVerificationForDefault7DaysFilter(Constants.CallLogsReport.average_calls_duration_tile);
	}
	
	@Test(priority=11)
	public void totalLeadsTileValueVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Total Leads Tile Values Verification Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.tileValueVerificationForDefault7DaysFilter(Constants.CallLogsReport.leads_tile);
	}
	
	@Test(priority=12)
	public void totalConversionTileValueVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Total Conversion Tile Values Verification Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.tileValueVerificationForDefault7DaysFilter(Constants.CallLogsReport.conversion_tile);
	}
	
	
	
	@Test(priority=13)
	public void presenceOfTotalCallsGraph() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Total Calls Graph Test"); 
		logger.assignCategory(Constants.call_logs_category);
        
        clr=new CallLogsReportPage(driver);
        clr.totalCallsGraph();
	}
	
	@Test(priority=14)
	public void presenceOfUniqueCallsGraph() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Unique Calls Graph Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.totalCallsGraph();
	}
	
	@Test(priority=15)
	public void tableColumnsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Table Columns Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.allColumnVerification();
	}
	
	@Test(priority=16)
	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.filterButton();
	}
	
	@Test(priority=17)
	public void filterButtonElementsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Elements Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.filterElements();
	}
	
	
	@Test(priority=18)
	public void filterFeatureForGroupTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature For Group Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.filterFeature("Group", TestBase.account);
	}
	
	@Test(priority=19)
	public void filterFeatureForCampaignTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature For Campaign Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.filterFeature("Campaign", TestBase.campaignToBeEdited);
	}
	
	@Test(priority=20)
	public void footerNoteTest() throws IOException, InterruptedException{
		logger=extent.startTest("Footer Note Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.footerNote();
	}
	
	@Test(priority=21)
	public void presenceOfDetailedViewTileTest() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Detailed View Tile Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.detailedViewTile();
	}
	
	@Test(priority=22)
	public void detailedViewUIVerificationTest() throws IOException, InterruptedException{
		logger=extent.startTest("Detailed View UI Verification Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.detailedViewUIVerification();
	}
	
	@AfterClass
	public void loggingOut() throws InterruptedException{
		clr=new CallLogsReportPage(driver);
		clr.switchToMainWindow();
		clr.deleteCallRecord();
        LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}
	
}
