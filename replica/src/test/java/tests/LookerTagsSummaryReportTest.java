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
import pom.MarketingDashboardPage;
import pom.TagsSummaryPage;

public class TagsSummaryReportTest extends TestBase{
	
	HomePage hp;
	CallLogsReportPage clr;
	TagsSummaryPage ts; 
	
	@BeforeClass
	public void goToLookerReports() throws Exception{
		LoginPage lp=new LoginPage(driver);
		ts=new TagsSummaryPage(driver);
		logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
        goToReport();

	}

	public void goToReport() throws Exception{
		ts=new TagsSummaryPage(driver);
		clr=new CallLogsReportPage(driver);
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(1000);
		clr.goToReport(Constants.LookerReports.tags_summary_report);
        Thread.sleep(7000);
		ts.switchToIFrame();
	}
	
	@Test(priority=1)
	public void runButtonVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Run Button Verification Test"); 
		logger.assignCategory(Constants.tags_summary_category);
        ts=new TagsSummaryPage(driver);
		ts.runButton();
	}
	
	@Test(priority=2)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.tags_summary_category);
        ts=new TagsSummaryPage(driver);
		ts.headerLabel();
	}
	
	@Test(priority=3)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.tags_summary_category);
        ts=new TagsSummaryPage(driver);
		ts.presenceOfGearIcon();
	}
	
	@Test(priority=4)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.tags_summary_category);
        ts=new TagsSummaryPage(driver);
        ts.gearIconOptions();
	}
	
	@Test(priority=5)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.tags_summary_category);
        ts=new TagsSummaryPage(driver);
		ts.presenceOfTimeZone();
	}

	@Test(priority=6)
	public void tilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tiles Verification Test"); 
		logger.assignCategory(Constants.tags_summary_category);
        ts=new TagsSummaryPage(driver);
		ts.tilesVerification();
	}
	
	@Test(priority=7)
	public void toalCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Toal Calls Count Verification Test"); 
		logger.assignCategory(Constants.tags_summary_category);
        ts=new TagsSummaryPage(driver);
		ts.tileValueVerification(Constants.LookerTagsSummaryReport.total_call_tile);
	}
	
	@Test(priority=8)
	public void taggedCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tagged Calls Count Verification Test"); 
		logger.assignCategory(Constants.tags_summary_category);
        ts=new TagsSummaryPage(driver);
		ts.tileValueVerification(Constants.LookerTagsSummaryReport.tagged_calls_tile);
	}
	
	@Test(priority=9)
	public void tagsUsedCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tags Used Count Verification Test"); 
		logger.assignCategory(Constants.tags_summary_category);
        ts=new TagsSummaryPage(driver);
		ts.tileValueVerification(Constants.LookerTagsSummaryReport.tags_used_tile);
	}
	
	@Test(priority=10)
	public void presenceOfTagsOverTimeLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Tags Over Time Label Verification Test"); 
		logger.assignCategory(Constants.tags_summary_category);
		ts=new TagsSummaryPage(driver);
		ts.tagsOverTimeLabel();
	}
	
	@Test(priority=11)
	public void presenceOfTagsOverTimeGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Tags Over Time Graph Verification Test"); 
		logger.assignCategory(Constants.tags_summary_category);
		ts=new TagsSummaryPage(driver);
		ts.tagsOverTimeGraph();
	}
	
	@Test(priority=12)
	public void presenceOfTagsMixLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Tags Mix Label Verification Test"); 
		logger.assignCategory(Constants.tags_summary_category);
		ts=new TagsSummaryPage(driver);
		ts.tagsMixLabel();
	}
	
	@Test(priority=13)
	public void presenceOfTagsMixGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Tags Mix Graph Verification Test"); 
		logger.assignCategory(Constants.tags_summary_category);
		ts=new TagsSummaryPage(driver);
		ts.tagsMixGraph();
	}
	
	@Test(priority=14)
	public void callsTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Calls Table Column Verification Test"); 
		logger.assignCategory(Constants.tags_summary_category);
		ts=new TagsSummaryPage(driver);
		ts.callsTableColumnVerification();
	}
	
	@Test(priority=15)
	public void tagsTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tags Table Column Verification Test"); 
		logger.assignCategory(Constants.tags_summary_category);
		ts=new TagsSummaryPage(driver);
		ts.tagsTableColumnVerification();
	}

	@Test(priority=16)
	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.tags_summary_category);
		ts=new TagsSummaryPage(driver);
		ts.filterButton();
	}

	@Test(priority=17)
	public void filterButtonElementsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Elements Test"); 
		logger.assignCategory(Constants.tags_summary_category);
		ts=new TagsSummaryPage(driver);
		ts.filterElements();
	}
	
	@Test(priority=18)
	public void filterFeatureForCallsTableGroupTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature For Calls table Group Test"); 
		logger.assignCategory(Constants.tags_summary_category);
		ts=new TagsSummaryPage(driver);
		ts.filterFeatureForCallsTable(Constants.LookerTagsSummaryReport.group_filter);
	}

	@Test(priority=19)
	public void filterFeatureForTagsTableGroupTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature For Tags table Group Test"); 
		logger.assignCategory(Constants.tags_summary_category);
		ts=new TagsSummaryPage(driver);
		ts.filterFeatureForTagsTable(Constants.LookerTagsSummaryReport.group_filter);
	}
	
	@Test(priority=20)
	public void filterFeatureForTagsTableTagTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature For Tags table Tag Test"); 
		logger.assignCategory(Constants.tags_summary_category);
		ts=new TagsSummaryPage(driver);
		ts.filterFeatureForTagsTable(Constants.LookerTagsSummaryReport.Tag_filter);
	}
	
	@AfterClass
	public void loggingOut() throws InterruptedException{
		
		ts=new TagsSummaryPage(driver);
		ts.switchToMainWindow();
		
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}

	
	
}
