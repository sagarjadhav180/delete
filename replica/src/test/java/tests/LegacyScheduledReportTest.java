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
	String report_name ;
	String updated_report_name;
	
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
		
		logger=extent.startTest("Table count Verification Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		ls=LegacyScheduledReportsPage.intanceLegacySchedule();
		ls.tableCount();
	}
	
	@Test(priority=7)
	public void paginationCountVerification(){
		logger=extent.startTest("PAgination count Verification Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		ls=LegacyScheduledReportsPage.intanceLegacySchedule();
		ls.paginationCount();
		
	}
	
	@Test(priority=8)
	public void navigateToScheduledReportBuilderPage() throws InterruptedException{
		
		ls=LegacyScheduledReportsPage.intanceLegacySchedule();
		ls.clickAction("", Constants.LegacyScheduledReport.add_scheduled_report_button);
		Thread.sleep(2000);
	}
	
	@Test(priority=9 )
	public void ScheduledReportBuilderPageLabel(){
		
		logger=extent.startTest("Scheduled Report Builder Page Label Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.scheduledReportBuilderPageLabel();
		
	}
	
	@Test(priority=10 )
	public void presenceOfListButton(){
		
		logger=extent.startTest("List Button Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.listButton();
		
	}
	
	@Test(priority=11 )
	public void reportDetailSectionUIVerification(){
		
		logger=extent.startTest("Report Details Section UI Verification Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.reportsDetailUIVerification();
		
	}
	
	@Test(priority=12 )
	public void defaultReportSelected(){
		
		logger=extent.startTest("Default Report Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.defaultReport();
		
	}
	
	@Test(priority=13 )
	public void defaultSecondaryOptionForCallDetailsReport() throws InterruptedException{
		
		logger=extent.startTest("Default Secondary Option For CallDetails Report Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		
		sb.secondaryGroupingOptionEnability(Constants.LegacyScheduledReport.secondary_grouping_for_call_details);
		
	}
	
	@Test(priority=14 )
	public void defaultSecondaryOptionForTrackingNumberSettingsReport() throws InterruptedException{
		
		logger=extent.startTest("Default Secondary Option For Tracking Number Settings Report Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.secondaryGroupingOptionEnability(Constants.LegacyScheduledReport.secondary_grouping_for_tracking_number_settings);
		
	}
	
	@Test(priority=15 )
	public void defaultSecondaryOptionForGroupActivityReport() throws InterruptedException{
		
		logger=extent.startTest("Default Secondary Option For Group Activity Report Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.secondaryGroupingOptionEnability(Constants.LegacyScheduledReport.secondary_grouping_for_group_activity);
		
	}
	
	@Test(priority=16 )
	public void secondaryGroupingOptions() throws InterruptedException{
		
		logger=extent.startTest("Secondary Grouping Options Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.seconadryGroupingOptions();
		
	}
	
	@Test(priority=17 )
	public void dateRangeFilterUI() throws InterruptedException{
		
		logger=extent.startTest("Date Range Filter Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.dateRangeFilterUI();
		
	}
	
	@Test(priority=18 )
	public void advanceFilterUI() throws InterruptedException{
		
		logger=extent.startTest("Advance Filter Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.advanceFilterUI();
		
	}
	
	@Test(priority=19 )
	public void advanceFilterElementsForCallDetailsReport() throws InterruptedException{
		
		logger=extent.startTest("Advance Filter Elements For Call Details Report Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.advanceFilterOptions(Constants.LegacyScheduledReport.secondary_grouping_for_call_details);
		
	}
	
	@Test(priority=20 )
	public void advanceFilterElementsForTrackingNumberSettingsReport() throws InterruptedException{
		
		logger=extent.startTest("Advance Filter Elements For Tracking Number Settings Report Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.advanceFilterOptions(Constants.LegacyScheduledReport.secondary_grouping_for_tracking_number_settings);
		
	}
	
	@Test(priority=21 )
	public void advanceFilterElementsForGroupActivityReport() throws InterruptedException{
		
		logger=extent.startTest("Advance Filter Elements For Group Activity Report Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.advanceFilterOptions(Constants.LegacyScheduledReport.secondary_grouping_for_group_activity);
		
	}
	
	@Test(priority=22 )
	public void scheduledReportForCallDetails() throws InterruptedException{
		
		logger=extent.startTest("Scheduled Report Creation For Call Details Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.createSchedule(Constants.LegacyScheduledReport.secondary_grouping_for_call_details, "automation_schedule"+String.valueOf(Util.generateRandomNumber()));
		
	}
	
	@Test(priority=23 )
	public void scheduledReportForTrackingNumberSettingsReport() throws InterruptedException{
		
		logger=extent.startTest("Scheduled Report Creation For Tracking Number Settings Report Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.createSchedule(Constants.LegacyScheduledReport.secondary_grouping_for_tracking_number_settings, "automation_schedule"+String.valueOf(Util.generateRandomNumber()));
		
	}
	
	@Test(priority=24 )
	public void scheduledReportForGroupActivityReport() throws InterruptedException{
		
		logger=extent.startTest("Scheduled Report Creation For Group Activity Report Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.createSchedule(Constants.LegacyScheduledReport.secondary_grouping_for_group_activity, "automation_schedule"+String.valueOf(Util.generateRandomNumber()));
		
	}
	
	@Test(priority=25 )
	public void addNewScheduleDistributionSectionUIVerificationTest() throws InterruptedException{
		
		logger=extent.startTest("Add New Schedule Distribution section UI Verification Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		sb.createSchedule(Constants.LegacyScheduledReport.secondary_grouping_for_call_details, "automation_schedule"+String.valueOf(Util.generateRandomNumber()));
		sb.scheduledDistributionSectionUI();
		
	}
	
	@Test(priority=26)
	public void addNewScheduleDistributionTest() throws InterruptedException{
		
		logger=extent.startTest("Add New Schedule Distribution Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		report_name = "automation"+String.valueOf(Util.generateRandomNumber());
		sb.createScheduledDistribution(report_name, Constants.LegacyScheduledReport.secondary_grouping_for_call_details);	
		
	}
	
	
	
	@Test(priority=27)
	public void editScheduledReportTest() throws InterruptedException{
		
		logger=extent.startTest("Edit Scheduled Report Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		Util.getJavascriptExecutor().executeScript("window.scrollBy(0,-1000)", "");
		sb.clickAction("list");
		ls.clickAction(report_name ,Constants.LegacyScheduledReport.edit_scheduled_report_button);
		updated_report_name="updated "+report_name;
		sb.updateScheduledDistribution(updated_report_name, Constants.LegacyScheduledReport.secondary_grouping_for_call_details);	
		
		
	}
	
	@Test(priority=28)
	public void sendNowScheduledReportTest() throws InterruptedException{
		sb=ScheduledReportBuilderPage.intanceScheduleBuilder();
		Util.getJavascriptExecutor().executeScript("window.scrollBy(0,-1000)", "");
		sb.clickAction("list");		
		logger=extent.startTest("Send Now Scheduled Report Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		ls=LegacyScheduledReportsPage.intanceLegacySchedule();
		ls.clickAction(updated_report_name, Constants.LegacyScheduledReport.send_now_scheduled_report_button);
		
	}
	
	@Test(priority=29)
	public void deleteScheduledReportTest() throws InterruptedException{
		
		logger=extent.startTest("Delete Scheduled Report Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		ls=LegacyScheduledReportsPage.intanceLegacySchedule();
		ls.clickAction(updated_report_name, Constants.LegacyScheduledReport.delete_scheduled_report_button);
		Thread.sleep(2000);
	}
	
	
	@AfterClass
	public void logOut(){
//		Util.readingFromDB("DELETE FROM report_sched WHERE org_unit_id='"+TestBase.getOrg_unit_id()+"'AND report_name LIKE 'automation%'");
		ls=LegacyScheduledReportsPage.intanceLegacySchedule();
		ls.closePopup();
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("LogOut"); 
		logger.log(LogStatus.INFO, "loggin out.. ");
		lp.logOut();
	}
}
