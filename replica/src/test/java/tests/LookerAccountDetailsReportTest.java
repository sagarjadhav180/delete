package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.CallLogsReportPage;
import pom.CallTrendsReportPage;
import pom.AccountDetailsReportPage;
import pom.HomePage;
import pom.LoginPage;

public class LookerAccountDetailsReportTest extends TestBase{

	HomePage hp;
	CallLogsReportPage clr;
	AccountDetailsReportPage ts; 
	
	@BeforeClass
	public void goToLookerReports() throws Exception{
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
        goToReport();

	}

	public void goToReport() throws Exception{
		ts=new AccountDetailsReportPage(driver);
		clr=new CallLogsReportPage(driver);
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(1000);
		clr.goToReport(Constants.LookerReports.account_details_report);
        Thread.sleep(7000);
		ts.switchToIFrame();
	}
	
	@Test(priority=1)
	public void runButtonVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Run Button Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.runButton();
	}
	
	@Test(priority=2)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.headerLabel();
	}
	
	@Test(priority=3)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.presenceOfGearIcon();
	}
	
	@Test(priority=4)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
        ts.gearIconOptions();
	}
	
	@Test(priority=5)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.presenceOfTimeZone();
	}
	
	public void presenceOfGroupSettingsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Group Settings Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.groupSettingsLabel();
	}
	
	public void groupSettingsTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Group Settings Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.groupSettingsTableColumnVerification();
	}
	
	public void presenceOfCampaignSettingsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Campaign Settings Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.campaignSettingsLabel();
	}
	
	public void campaignsSettingsTilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Campaigns Settings Tiles Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
        ts.campaignSettingstilesVerification();
	}
	
	public void activeCampaignsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Active Campaigns Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
        ts.campaignAndTNTileValueVerification(Constants.AccountDetailsReport.active_campaigns_tile);
	}
	
	public void inActiveCampaignsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Inactive Campaigns Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
        ts.campaignAndTNTileValueVerification(Constants.AccountDetailsReport.inactive_campaigns_tile);
	}
	
	public void campaignSettingsTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Campaign Settings Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.campaignSettingsTableColumnVerification();
	}
	
	public void presenceOfTNSettingsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Tracking number Settings Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.tnSettingsLabel();
	}
	
	public void trackingNumberSettingsTilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tracking Number Settings Tiles Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
        ts.tnSettingstilesVerification();
	}
	
	public void activeTrackingNumberVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Active Tracking Number Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
        ts.campaignAndTNTileValueVerification(Constants.AccountDetailsReport.active_tracking_numbers_tile);
	}
	
	public void inActiveTrackingNumberVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Inactive Tracking Number Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
        ts.campaignAndTNTileValueVerification(Constants.AccountDetailsReport.inactive_tracking_numbers_tile);
	}
	
	public void trackingNumberSettingsTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tracking Number Settings Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.tnSettingsTableColumnVerification();
	}
	
	public void presenceOfBillingUsageLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Billing Usage Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.billingUsageLabel();
	}
	
	public void billingUsagaeTilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Billing Usagae Tiles Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
        ts.billingUsagetilesVerification();
	}
	
	public void presenceOfUsageSummaryByGroupLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Usage Summary By Group Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.usageSummaryByGroupLabel();
	}
	
	public void billingUsageByGroupTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Billing Usage By Group Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.usageSummaryByGroupTableColumnVerification();
	}
	
	public void presenceOfConfigSummaryByGroupLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Config Summary By Group Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.configurationSummaryByGroupLabel();
	}
	
	public void configSummaryByGroupTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Config Summary By Group Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.configSummaryByGroupTableColumnVerification();
	}
	
	public void presenceOfUsageByTrackingNumberLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Usage By Tracking Numner Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.usageByTrackingNumberLabel();
	}
	
	public void UsageByTrackingNumberTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Usage By Tracking Number Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.usageByTrackingNumberTableColumnVerification();
	}
	
	public void presenceOfCallTrendsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of call Trends Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callTrendsLabel();
	}
	
	public void tilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tiles Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.tilesVerification();
	}
	
	public void totalCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Total Calls Count Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callTrendsTileValueVerificationForDefault7DaysFilter(Constants.AccountDetailsReport.total_calls_tile);
	}
	
	public void uniqueCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Unique Calls Count Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callTrendsTileValueVerificationForDefault7DaysFilter(Constants.AccountDetailsReport.unique_calls_tile);
	}
	
	public void answeredCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Answered Calls Count Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callTrendsTileValueVerificationForDefault7DaysFilter(Constants.AccountDetailsReport.answered_calls_tile);
	}
	
	public void unAnsweredCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Unanswered Calls Count Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callTrendsTileValueVerificationForDefault7DaysFilter(Constants.AccountDetailsReport.unanswered_calls_tile);
	}
	
	public void longestCallDurationVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Longest Call Duration Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callTrendsTileValueVerificationForDefault7DaysFilter(Constants.AccountDetailsReport.longest_call_duration_tile);
	}
	

	public void averageCallDurationVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Average Call Duration Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callTrendsTileValueVerificationForDefault7DaysFilter(Constants.AccountDetailsReport.average_calls_duration_tile);
	}
	
	public void presenceOfCallsOverTimebyDayLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Calls Over Time by Day Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callsOverTimebyDayLabel();
	}
	
	public void presenceOfCallsOverTimebyDayGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Calls Over Time by Day Graph Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callsOverTimebyDayGraph();
	}
	
	public void callsOverTimebyDayTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Calls Over Time by Day Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callsOverTimebyDayTableColumnVerification();
	}

	public void presenceOfCallsOverTimebyHourLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Calls Over Time by Hour Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callsOverTimebyHourLabel();
	}
	
	public void presenceOfCallsOverTimebyHourGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Calls Over Time by Hour Graph Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callsOverTimebyHourGraph();
	}
	
	public void callsOverTimebyHourTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Calls Over Time by Hour Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callsOverTimebyHourTableColumnVerification();
	}
	
	public void presenceOfCallMixLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Call Mix Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callsMixLabel();
	}
	
	public void presenceOfCallMixGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Call Mix Graph Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callMixGraph();
	}

	public void callMixTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Call Mix Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callMixTableColumnVerification();
	}

	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.filterButton();
	}
	
	public void filterButtonElementsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Elements Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
        ts.filterElements();
	}

	
	@AfterClass
	public void loggingOut() throws InterruptedException{
		
		ts=new AccountDetailsReportPage(driver);
		ts.switchToMainWindow();
		
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}
	
}
