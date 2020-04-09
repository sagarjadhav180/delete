package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.CallDetailsReport_Page;
import pom.GroupActivityReportsPage;
import pom.HomePage;
import pom.LoginPage;

public class GroupActivityReportTest extends TestBase {
	
	GroupActivityReportsPage ga;
	HomePage hp;
	
		
	@BeforeClass
	public void goToGroupActivityReportPage() throws InterruptedException, IOException{
	
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        logger.assignCategory("Login Suite");
        lp.validLogin();
        
        hp=new HomePage(driver);
        hp.left_hand_navigation_bar_click();
		hp.clickAction(Constants.HomePage.legacy_reports);
		
		hp.click_subLink(Constants.HomePage.group_activity_report);
	}

	//ui verification of groupActivity reports page
	@Test(priority=1)
	public void uiVerification() throws InterruptedException{
		logger=extent.startTest("uiVerification Test");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.UIVerification();
	}
	
	//Tile count verification of groupActivity reports page
	@Test(priority=2)
	public void tileCountVerification() throws InterruptedException{
		logger=extent.startTest("Tile Count Verification");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.tileCountVerification();
	}
	
	@Test(priority=3)
	public void secondaryGroupingOptions() throws InterruptedException{
		logger=extent.startTest("Seconadry grouping options Test");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.secondaryGrouping();
	}
	
	//Table count verification of groupActivity reports page
	@Test(priority=4)
	public void tableCountVerification() throws InterruptedException{
		logger=extent.startTest("Table Count Verification");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.tableCount();
	}
	
	//Pagination UI verification of groupActivity reports page
	@Test(priority=5)
	public void paginationToolboxUIVerification() throws InterruptedException{
		logger=extent.startTest("Pagination Toolbox UI Verification");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.paginationUI();
	}
	
	//Pagination count verification of groupActivity reports page
	@Test(priority=6)
	public void paginationCountVerification() throws InterruptedException{
		logger=extent.startTest("Pagination Count Verification");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.paginationCount();
	}
	
	@Test(priority=7)
	public void defaultColumnPickerOptions() throws InterruptedException{
		logger=extent.startTest("Default column picker options Test");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.allColumnPickerOptions();
	}
	
	@Test(priority=8)
	public void defaultColumnsDisplayed() throws InterruptedException{
		logger=extent.startTest("default columns Test");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.defaultColumns();
	}
	
	@Test(priority=9)
	public void allColumnPickerCheckboxesClickable() throws InterruptedException{
		logger=extent.startTest("Enability of all column picker checkboxes");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.allColumnPickerCheckboxes();
	}
	
	@Test(priority=10)
	public void defaultSecondaryGroupingOption() throws InterruptedException{
		logger=extent.startTest("Default Secondary Grouping Option");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.defaultSecondaryOption("None");
	}
	
	@Test(priority=11)
	public void secondaryGroupingFeatureForNone() throws InterruptedException{
		logger=extent.startTest("Secondary Grouping Feature For None Test");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.secondaryGroupingFeature(Constants.LegacyReports.none,"None");
	}
	
	@Test(priority=12)
	public void secondaryGroupingFeatureForTrackingNumber() throws InterruptedException{
		logger=extent.startTest("Secondary Grouping Feature For Tracking Number Test");
		logger.assignCategory(Constants.group_activity_report_category,"Tracking Number");
			
		ga=GroupActivityReportsPage.instance();
		ga.secondaryGroupingFeature(Constants.LegacyReports.trackingnumber,"Tracking Number");
	}
	
	@Test(priority=13)
	public void secondaryGroupingFeatureForCampaign() throws InterruptedException{
		logger=extent.startTest("Secondary Grouping Feature For Campaign Test");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.secondaryGroupingFeature(Constants.LegacyReports.campaign,"Campaign");
	}
	
	@Test(priority=14)
	public void secondaryGroupingFeatureForCampaignColumn() throws InterruptedException{
		logger=extent.startTest("Secondary Grouping column Feature For Campaign column");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.secondaryGroupingColumn("Campaign");
	}
	
	@Test(priority=15)
	public void secondaryGroupingFeatureForTrackingumber() throws InterruptedException{
		logger=extent.startTest("Secondary Grouping column Feature For Tracking Number column");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.secondaryGroupingColumn("Tracking Number");
	}
	
	@Test(priority=16)
	public void advancedFilterUI() throws InterruptedException{
		logger=extent.startTest("Advanced Filter section UI");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.advancedFilter();
	}
	
	@Test(priority=17)
	public void basicFilterForGroupName() throws InterruptedException{
		logger=extent.startTest("Basic Filter for Group Name");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.basicFilterFeature(Constants.LegacyReports.basic_group_filter);
		
	}
	
	@Test(priority=18)
	public void advancedFilterForGroupName() throws InterruptedException{
		
		logger=extent.startTest("Advanced Filter for Group Name");
		logger.assignCategory(Constants.group_activity_report_category);
		
		ga=GroupActivityReportsPage.instance();
		ga.advancedFilterFeature(Constants.LegacyReports.group_filter_advanced);
		
	}
	
	@Test(priority=19)
	public void advancedFilterForAnweredCalls() throws InterruptedException{
		
		logger=extent.startTest("Advanced Filter for answered calls");
		logger.assignCategory(Constants.group_activity_report_category);
		
		ga=GroupActivityReportsPage.instance();
		ga.advancedFilterFeature(Constants.LegacyReports.answered_calls);
		
	}
	
	@Test(priority=20)
	public void advancedFilterForCalls() throws InterruptedException{
		
		logger=extent.startTest("Advanced Filter for Calls");
		logger.assignCategory(Constants.group_activity_report_category);
		
		ga=GroupActivityReportsPage.instance();
		ga.advancedFilterFeature(Constants.LegacyReports.calls);
		Thread.sleep(2000);
	}
	
	@Test(priority=21)
	public void advancedFilterForLeads() throws InterruptedException{
		
		logger=extent.startTest("Advanced Filter for Leads");
		logger.assignCategory(Constants.group_activity_report_category);
		
		ga=GroupActivityReportsPage.instance();
		ga.advancedFilterFeature(Constants.LegacyReports.leads);
		
	}
	
	@Test(priority=22)
	public void advancedFilterForConversion() throws InterruptedException{
		
		logger=extent.startTest("Advanced Filter for Conversion");
		logger.assignCategory(Constants.group_activity_report_category);
		
		ga=GroupActivityReportsPage.instance();
		ga.advancedFilterFeature(Constants.LegacyReports.conversions);
		
	}
	
	@Test(priority=23)
	public void dateRangeFilterForToday(){
		
		logger=extent.startTest("Date Range filter for today");
		logger.assignCategory(Constants.group_activity_report_category);
		
		ga=GroupActivityReportsPage.instance();
		ga.dateRangeFilter(Constants.LegacyReports.today);
		
	}
	
	@Test(priority=24)
	public void dateRangeFilterForYesterday(){
		
		logger=extent.startTest("Date Range filter for yesterday");
		logger.assignCategory(Constants.group_activity_report_category);
		
		ga=GroupActivityReportsPage.instance();
		ga.dateRangeFilter(Constants.LegacyReports.yesterday);
		
	}
		
	@Test(priority=25)
	public void dateRangeFilterForLast7Days(){
		
		logger=extent.startTest("Date Range filter for last 7 days");
		logger.assignCategory(Constants.group_activity_report_category);
		
		ga=GroupActivityReportsPage.instance();
		ga.dateRangeFilter(Constants.LegacyReports.last_7_days);
		
	}	
		
	@Test(priority=26)
	public void dateRangeFilterForLast30Days(){
		
		logger=extent.startTest("Date Range filter for last 30 days");
		logger.assignCategory(Constants.group_activity_report_category);
		
		ga=GroupActivityReportsPage.instance();
		ga.dateRangeFilter(Constants.LegacyReports.last_30_days);
		
	}	
		
	//logging out -tear down
	@AfterClass
	public void logOut() throws IOException{
			
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("LogOut"); 
		logger.log(LogStatus.INFO, "loggin out.. ");
		lp.logOut();
			        		
	}
		
		
		
}
