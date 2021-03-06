package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.BlockedCallsReportPage;
import pom.CallLogsReportPage;
import pom.HomePage;
import pom.LoginPage;
import pom.LookerTrackingNumberSettingsPage;

public class LookerBlockedCallReportTest extends TestBase{
	
	HomePage hp;
	CallLogsReportPage clr;
	BlockedCallsReportPage bc;
	
	@BeforeClass
	public void goToLookerReports() throws Exception{
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
        goToReport();
	}
	
	public void goToReport() throws Exception{
		bc=new BlockedCallsReportPage(driver);
		clr=new CallLogsReportPage(driver);
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(1000);
		clr.goToReport(Constants.LookerReports.blocked_calls_report);
        Thread.sleep(7000);
		bc.switchToIFrame();
	}

    @Test(priority=1)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.blocked_calls_category);
        bc=new BlockedCallsReportPage(driver);
		bc.headerLabel();
	}
	
    @Test(priority=2)
	public void runButtonVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Run Button Verification Test"); 
		logger.assignCategory(Constants.blocked_calls_category);
        bc=new BlockedCallsReportPage(driver);
		bc.runButton();
	}
	
    @Test(priority=3)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.blocked_calls_category);
        bc=new BlockedCallsReportPage(driver);
		bc.presenceOfGearIcon();
	}
	
    @Test(priority=4)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.blocked_calls_category);
        bc=new BlockedCallsReportPage(driver);
		bc.gearIconOptions();
	}
	
    @Test(priority=5)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.blocked_calls_category);
        bc=new BlockedCallsReportPage(driver);
		bc.presenceOfTimeZone();
	}
	
    @Test(priority=6)
	public void tilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tiles Verification Test"); 
		logger.assignCategory(Constants.blocked_calls_category);
		bc=new BlockedCallsReportPage(driver);
		bc.tilesVerification();
	}
    
    public void callsCheckedCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Calls Checked Count Verification Test"); 
		logger.assignCategory(Constants.blocked_calls_category);
		bc=new BlockedCallsReportPage(driver);
		bc.tileValueVerification(Constants.LookerBlockedCallReport.calls_checked_tile);
	}
	
    public void blockedCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Blocked Calls Count Verification Test"); 
		logger.assignCategory(Constants.blocked_calls_category);
		bc=new BlockedCallsReportPage(driver);
		bc.tileValueVerification(Constants.LookerBlockedCallReport.blocked_call_tile);
	}
    
    @Test(priority=7)
	public void blockedNumbersTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Blocked Numbers Table Column Verification Test"); 
		logger.assignCategory(Constants.blocked_calls_category);
		bc=new BlockedCallsReportPage(driver);
		bc.blockedNumebrsTableColumnVerification();
	}
    
    @Test(priority=8)
	public void blockedCallsTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Blocked Calls Table Column Verification Test"); 
		logger.assignCategory(Constants.blocked_calls_category);
		bc=new BlockedCallsReportPage(driver);
		bc.blockedCallsTableColumnVerification();
	}
    
    @Test(priority=9)
	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.blocked_calls_category);
		bc=new BlockedCallsReportPage(driver);
		bc.filterButton();
	}
    
    @Test(priority=10)
	public void filterButtonElementsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Elements Test"); 
		logger.assignCategory(Constants.blocked_calls_category);
		bc=new BlockedCallsReportPage(driver);
		bc.filterElements();
	}
    
//    @Test(priority=7)
//	public void filterFeatureForGroupTest() throws IOException, InterruptedException{
//		logger=extent.startTest("Filter Feature For Group Test"); 
//		logger.assignCategory(Constants.blocked_calls_category);
//		bc=new BlockedCallsReportPage(driver);
//		bc.filterFeatureBlockedCallsTable(Constants.LookerBlockedCallReport.group_filter);
//	}
//    
//    @Test(priority=8)
//	public void filterFeatureForCampaignTest() throws IOException, InterruptedException{
//		logger=extent.startTest("Filter Feature For Campaign Test"); 
//		logger.assignCategory(Constants.blocked_calls_category);
//		bc=new BlockedCallsReportPage(driver);
//		bc.filterFeatureBlockedCallsTable(Constants.LookerBlockedCallReport.campaign_filter);
//	}
//    
//    @Test(priority=9)
//	public void filterFeatureForTrackingNumberNameTest() throws IOException, InterruptedException{
//		logger=extent.startTest("Filter Feature For Tracking Number Name Test"); 
//		logger.assignCategory(Constants.blocked_calls_category);
//		bc=new BlockedCallsReportPage(driver);
//		bc.filterFeatureBlockedCallsTable(Constants.LookerBlockedCallReport.tracking_number_name_filter);
//	}
//    
//    @Test(priority=10)
//	public void filterFeatureForTrackingNumberTest() throws IOException, InterruptedException{
//		logger=extent.startTest("Filter Feature For Tracking Number Test"); 
//		logger.assignCategory(Constants.blocked_calls_category);
//		bc=new BlockedCallsReportPage(driver);
//		bc.filterFeatureBlockedCallsTable(Constants.LookerBlockedCallReport.tracking_number_filter);
//	}
    
	@AfterClass
	public void loggingOut() throws InterruptedException{
		
		bc=new BlockedCallsReportPage(driver);
		bc.switchToMainWindow();
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}

}
