package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.HomePage;
import pom.LegacyScheduledReportsPage;
import pom.LoginPage;
import pom.ScheduledReportBuilderPage;

public class LegacyScheduledReportTest extends TestBase {

	ScheduledReportBuilderPage sb;
	LegacyScheduledReportsPage ls;
	
	@BeforeClass
	public void goToLegacyScheduledReportsPage() throws IOException, InterruptedException{
		
		
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        logger.assignCategory(Constants.login_page_category);
        lp.validLogin();
        HomePage hp=new HomePage(driver);
        hp.clickAction(Constants.HomePage.settings_section);
        hp.click_subLink(Constants.HomePage.legacy_schedule_report);
	}
	
	@Test(priority=1)
	public void presenceOfReportLabel(){
		
		logger=extent.startTest("Report Label Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		ls=LegacyScheduledReportsPage.intanceLegacySchedule();
		ls.headerLabel();
		
	}
	
	@Test(priority=2)
	public void presenceOfAddScheduleButton(){
		
		logger=extent.startTest("Add Schedule Button Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		ls=LegacyScheduledReportsPage.intanceLegacySchedule();
		ls.scheduleButton();
		
	}
	
	@Test(priority=3)
	public void PresenceOfExportButton(){
		
		logger=extent.startTest("Export Button Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		ls=LegacyScheduledReportsPage.intanceLegacySchedule();
		ls.exportButton();
		
	}
	
	@Test(priority=4)
	public void exportButtonOptions(){
		
		logger=extent.startTest("Export Button Options Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		ls=LegacyScheduledReportsPage.intanceLegacySchedule();
		ls.exportButtonOptions();
		
	}
	
	@Test(priority=5)
	public void paginationToolboxUIVerification(){
		
		logger=extent.startTest("Pagination Toolbox UI Verification Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		ls=LegacyScheduledReportsPage.intanceLegacySchedule();
		ls.paginationToolboxUI();
		
	}
	
	@Test(priority=6)
	public void tableCountVerification(){
		
		
	}
	
	@Test(priority=7)
	public void paginationCountVerification(){
		
		
	}
	
	@Test(priority=8)
	public void navigateToScheduledReportBuilderPage() throws InterruptedException{
		
		ls=LegacyScheduledReportsPage.intanceLegacySchedule();
		ls.clickAction("", Constants.LegacyScheduledReport.add_scheduled_report_button);
		
	}
	
	@Test(priority=9,dependsOnMethods="navigateToScheduledReportBuilderPage")
	public void ScheduledReportBuilderPageLabel(){
		
		logger=extent.startTest("Scheduled Report Builder Page Label Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.scheduledReportBuilderPageLabel();
		
	}
	
	@Test(priority=10,dependsOnMethods="navigateToScheduledReportBuilderPage")
	public void presenceOfListButton(){
		
		logger=extent.startTest("List Button Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.listButton();
		
	}
	
	@Test(priority=11,dependsOnMethods="navigateToScheduledReportBuilderPage")
	public void reportDetailSectionUIVerification(){
		
		logger=extent.startTest("Report Details Section UI Verification Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.reportsDetailUIVerification();
		
	}
	
	@Test(priority=12,dependsOnMethods="navigateToScheduledReportBuilderPage")
	public void defaultReportSelected(){
		
		logger=extent.startTest("Default Report Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.defaultReport();
		
	}
	
	@Test(priority=13,dependsOnMethods="navigateToScheduledReportBuilderPage")
	public void defaultSecondaryOptionForCallDetailsReport() throws InterruptedException{
		
		logger=extent.startTest("Default Secondary Option For CallDetails Report Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		
		sb.secondaryGroupingOptionEnability(Constants.LegacyScheduledReport.secondary_grouping_for_call_details);
		
	}
	
	@Test(priority=14,dependsOnMethods="navigateToScheduledReportBuilderPage")
	public void defaultSecondaryOptionForTrackingNumberSettingsReport() throws InterruptedException{
		
		logger=extent.startTest("Default Secondary Option For Tracking Number Settings Report Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.secondaryGroupingOptionEnability(Constants.LegacyScheduledReport.secondary_grouping_for_tracking_number_settings);
		
	}
	
	@Test(priority=15,dependsOnMethods="navigateToScheduledReportBuilderPage")
	public void defaultSecondaryOptionForGroupActivityReport() throws InterruptedException{
		
		logger=extent.startTest("Default Secondary Option For Group Activity Report Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.secondaryGroupingOptionEnability(Constants.LegacyScheduledReport.secondary_grouping_for_group_activity);
		
	}
	
	@AfterClass
	public void logOut(){
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("LogOut"); 
		logger.log(LogStatus.INFO, "loggin out.. ");
		lp.logOut();
	}
}
