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

	@Test(priority=6)
	public void presenceOfGroupSettingsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Group Settings Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.groupSettingsLabel();
	}
	
	@Test(priority=7)
	public void groupSettingsTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Group Settings Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.groupSettingsTableColumnVerification();
	}
	
	@Test(priority=8)
	public void presenceOfCampaignSettingsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Campaign Settings Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.campaignSettingsLabel();
	}
	
	@Test(priority=9)
	public void campaignsSettingsTilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Campaigns Settings Tiles Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
        ts.campaignSettingstilesVerification();
	}
	
	@Test(priority=10)
	public void activeCampaignsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Active Campaigns Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
        ts.campaignAndTNTileValueVerification(Constants.AccountDetailsReport.active_campaigns_tile);
	}
	
	@Test(priority=11)
	public void inActiveCampaignsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Inactive Campaigns Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
        ts.campaignAndTNTileValueVerification(Constants.AccountDetailsReport.inactive_campaigns_tile);
	}
	
	@Test(priority=12)
	public void campaignSettingsTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Campaign Settings Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.campaignSettingsTableColumnVerification();
	}

	@Test(priority=13)
	public void presenceOfTNSettingsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Tracking number Settings Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.tnSettingsLabel();
	}
	
	@Test(priority=14)
	public void trackingNumberSettingsTilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tracking Number Settings Tiles Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
        ts.tnSettingstilesVerification();
	}
	
	@Test(priority=15)
	public void activeTrackingNumberVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Active Tracking Number Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
        ts.campaignAndTNTileValueVerification(Constants.AccountDetailsReport.active_tracking_numbers_tile);
	}
	
	@Test(priority=16)
	public void inActiveTrackingNumberVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Inactive Tracking Number Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
        ts.campaignAndTNTileValueVerification(Constants.AccountDetailsReport.inactive_tracking_numbers_tile);
	}
	
	@Test(priority=17)
	public void trackingNumberSettingsTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tracking Number Settings Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.tnSettingsTableColumnVerification();
	}
	
	@Test(priority=18)
	public void presenceOfBillingUsageLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Billing Usage Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.billingUsageLabel();
	}
	
	@Test(priority=19)
	public void billingUsagaeTilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Billing Usagae Tiles Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
        ts.billingUsagetilesVerification();
	}
	
	@Test(priority=20)
	public void presenceOfUsageSummaryByGroupLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Usage Summary By Group Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.usageSummaryByGroupLabel();
	}
	
	@Test(priority=21)
	public void billingUsageByGroupTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Billing Usage By Group Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.usageSummaryByGroupTableColumnVerification();
	}
	
	@Test(priority=22)
	public void presenceOfConfigSummaryByGroupLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Config Summary By Group Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.configurationSummaryByGroupLabel();
	}

	@Test(priority=23)
	public void configSummaryByGroupTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Config Summary By Group Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.configSummaryByGroupTableColumnVerification();
	}
	
	@Test(priority=24)
	public void presenceOfUsageByTrackingNumberLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Usage By Tracking Numner Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.usageByTrackingNumberLabel();
	}
	
	@Test(priority=25)
	public void UsageByTrackingNumberTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Usage By Tracking Number Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.usageByTrackingNumberTableColumnVerification();
	}
	
	@Test(priority=26)
	public void presenceOfCallTrendsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of call Trends Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callTrendsLabel();
	}
	
	@Test(priority=27)
	public void callTrendTilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Call Trends Tiles Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callTrendsTilesVerification();
	}
	
	@Test(priority=28)
	public void totalCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Total Calls Count Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callTrendsTileValueVerificationForDefault7DaysFilter(Constants.AccountDetailsReport.total_calls_tile);
	}
	
	@Test(priority=29)
	public void uniqueCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Unique Calls Count Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callTrendsTileValueVerificationForDefault7DaysFilter(Constants.AccountDetailsReport.unique_calls_tile);
	}
	
	@Test(priority=30)
	public void answeredCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Answered Calls Count Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callTrendsTileValueVerificationForDefault7DaysFilter(Constants.AccountDetailsReport.answered_calls_tile);
	}

	@Test(priority=31)
	public void unAnsweredCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Unanswered Calls Count Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callTrendsTileValueVerificationForDefault7DaysFilter(Constants.AccountDetailsReport.unanswered_calls_tile);
	}
	
	@Test(priority=32)
	public void longestCallDurationVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Longest Call Duration Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callTrendsTileValueVerificationForDefault7DaysFilter(Constants.AccountDetailsReport.longest_call_duration_tile);
	}
	
	@Test(priority=33)
	public void averageCallDurationVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Average Call Duration Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callTrendsTileValueVerificationForDefault7DaysFilter(Constants.AccountDetailsReport.average_calls_duration_tile);
	}
	
	@Test(priority=34)
	public void presenceOfCallsOverTimebyDayLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Calls Over Time by Day Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callsOverTimebyDayLabel();
	}
	
	@Test(priority=35)
	public void presenceOfCallsOverTimebyDayGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Calls Over Time by Day Graph Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callsOverTimebyDayGraph();
	}
	
	@Test(priority=36)
	public void callsOverTimebyDayTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Calls Over Time by Day Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callsOverTimebyDayTableColumnVerification();
	}

	@Test(priority=37)
	public void presenceOfCallsOverTimebyHourLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Calls Over Time by Hour Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callsOverTimebyHourLabel();
	}
	
	@Test(priority=38)
	public void presenceOfCallsOverTimebyHourGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Calls Over Time by Hour Graph Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callsOverTimebyHourGraph();
	}
	
	@Test(priority=39)
	public void callsOverTimebyHourTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Calls Over Time by Hour Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callsOverTimebyHourTableColumnVerification();
	}
	
	@Test(priority=40)
	public void presenceOfCallMixLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Call Mix Label Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callsMixLabel();
	}

	@Test(priority=41)
	public void presenceOfCallMixGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Call Mix Graph Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callMixGraph();
	}

	@Test(priority=42)
	public void callMixTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Call Mix Table Column Verification Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.callMixTableColumnVerification();
	}

	@Test(priority=43)
	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.account_details_category);
        ts=new AccountDetailsReportPage(driver);
		ts.filterButton();
	}
	
	@Test(priority=44)
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
