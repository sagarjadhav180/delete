package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.CallBackReportPage;
import pom.CallLogsReportPage;
import pom.HomePage;
import pom.LoginPage;
import pom.LookerTrackingNumberSettingsPage;

public class LookerTrackingNumberSettingsReportTest extends TestBase{
	
	HomePage hp;
	CallLogsReportPage clr;
	LookerTrackingNumberSettingsPage tns;
	
	@BeforeClass
	public void goToLookerReports() throws Exception{
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
        goToReport();
	}
	
	public void goToReport() throws Exception{
		tns=new LookerTrackingNumberSettingsPage(driver);
		clr=new CallLogsReportPage(driver);
		hp=new HomePage(driver);
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(1000);
		clr.goToReport(Constants.LookerReports.tracking_number_settings_report);
        Thread.sleep(7000);
		tns.switchToIFrame();
	}

	@Test(priority=1)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.headerLabel();
	}
	
	@Test(priority=2)
	public void runButtonVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Run Button Verification Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.runButton();
	}
	
	@Test(priority=3)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.presenceOfGearIcon();
	}
	
	@Test(priority=4)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
        tns.gearIconOptions();
	}
	
	@Test(priority=5)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.presenceOfTimeZone();
	}
	
	@Test(priority=6)
	public void tilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tiles Verification Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.tilesVerification();
	}
	
	@Test(priority=7)
	public void activeCampaignCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Active Campaign Count Verification Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.tileValueVerification(Constants.LookerTrackingNumberSettingsReport.active_campaigns_tile);
	}
	
	@Test(priority=8)
	public void activeTrackingNumberCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Active Tracking Number Verification Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.tileValueVerification(Constants.LookerTrackingNumberSettingsReport.active_tracking_numbers_tile);
	}
	
	@Test(priority=9)
	public void inActiveCampaignCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("InActive Campaign Count Verification Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.tileValueVerification(Constants.LookerTrackingNumberSettingsReport.inactive_campaigns_tile);
	}
	
	@Test(priority=10)
	public void inActiveTrackingNumberCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("InActive Tracking Number Verification Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.tileValueVerification(Constants.LookerTrackingNumberSettingsReport.inactive_tracking_numbers_tile);
	}
	
	@Test(priority=11)
	public void tableColumnsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Table Columns Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.allColumnVerification();
	}
	
	@Test(priority=12)
	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.filterButton();
	}
	
	@Test(priority=13)
	public void filterButtonElementsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Elements Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.filterElements();
	}
	
	@Test(priority=14)
	public void filterFeatureForGroupTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature For Group Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.filterFeature(Constants.LookerTrackingNumberSettingsReport.group_filter);
	}
	
	@Test(priority=15)
	public void filterFeatureForCampaignTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature For Campaign Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.filterFeature(Constants.LookerTrackingNumberSettingsReport.campaign_filter);
	}
	
	@Test(priority=16)
	public void filterFeatureForRingToNumberTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature For Ring To Number Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.filterFeature(Constants.LookerTrackingNumberSettingsReport.ring_to_number_filter);
	}
	
	@Test(priority=17)
	public void filterFeatureForTrackingNumberNameTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature For Tracking Number Name Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.filterFeature(Constants.LookerTrackingNumberSettingsReport.tracking_number_name_filter);
	}
	
	@Test(priority=18)
	public void filterFeatureForTrackingNumberTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature For Tracking Number Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.filterFeature(Constants.LookerTrackingNumberSettingsReport.tracking_number_filter);
	}
	
	@Test(priority=19)
	public void filterFeatureForTrackingNumberTypeTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature For Tracking Number Type Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.filterFeature(Constants.LookerTrackingNumberSettingsReport.tracking_number_type_filter);
	}
	
	@Test(priority=20)
	public void presenceOfDetailedViewTileTest() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Detailed View Tile Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.detailedViewTile();
	}
	
	@Test(priority=21)
	public void detailedViewUIVerificationTest() throws IOException, InterruptedException{
		logger=extent.startTest("Detailed View UI Verification Test"); 
		logger.assignCategory(Constants.tracking_number_settings_report_category);
        tns=new LookerTrackingNumberSettingsPage(driver);
		tns.detailedViewUIVerification();
	}
	
	@AfterClass
	public void loggingOut() throws InterruptedException{
		
		tns=new LookerTrackingNumberSettingsPage(driver);
		tns.switchToMainWindow();
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}
	

}
