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
import pom.TagsSummaryPage;
import pom.UserLogsReportPage;
import pom.WebhookLogsReportPage;

public class UserLogsReportTest extends TestBase{
	
	HomePage hp;
	CallLogsReportPage clr;
	UserLogsReportPage ts; 
	
	@BeforeClass
	public void goToLookerReports() throws Exception{
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
        goToReport();

	}

	public void goToReport() throws Exception{
		ts=new UserLogsReportPage(driver);
		clr=new CallLogsReportPage(driver);
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(1000);
		clr.goToReport(Constants.LookerReports.user_logs_report);
        Thread.sleep(7000);
		ts.switchToIFrame();
	}
	
	@Test(priority=1)
	public void runButtonVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Run Button Verification Test"); 
		logger.assignCategory(Constants.user_logs_category);
        ts=new UserLogsReportPage(driver);
		ts.runButton();
	}
	
	@Test(priority=2)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.user_logs_category);
        ts=new UserLogsReportPage(driver);
		ts.headerLabel();
	}
	
	@Test(priority=3)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.user_logs_category);
        ts=new UserLogsReportPage(driver);
		ts.presenceOfGearIcon();
	}
	
	@Test(priority=4)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.user_logs_category);
        ts=new UserLogsReportPage(driver);
        ts.gearIconOptions();
	}
	
	@Test(priority=5)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.user_logs_category);
        ts=new UserLogsReportPage(driver);
		ts.presenceOfTimeZone();
	}
	
	@Test(priority=6)
	public void presenceOfAllActivityLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of All Activity Label Verification Test"); 
		logger.assignCategory(Constants.user_logs_category);
		ts=new UserLogsReportPage(driver);
		ts.allActivityByTypeLabel();
	}	
	
	@Test(priority=7)
	public void presenceOfAllActivityGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of All Activity Graph Verification Test"); 
		logger.assignCategory(Constants.user_logs_category);
		ts=new UserLogsReportPage(driver);
		ts.allActivityByTypeGraph();
	}
	
	@Test(priority=8)
	public void allActivityTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("All Activity Table Column Verification Test"); 
		logger.assignCategory(Constants.user_logs_category);
		ts=new UserLogsReportPage(driver);
		ts.allActivityTableColumnVerification();
	}
	
	@Test(priority=9)
	public void presenceOfLoginActivityTableLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Login Activity Table Label Verification Test"); 
		logger.assignCategory(Constants.user_logs_category);
		ts=new UserLogsReportPage(driver);
		ts.loginActivityTableLabel();
	}	
	
	@Test(priority=10)
	public void presenceOfLoginActivityGraphLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Login Activity Graph Label Verification Test"); 
		logger.assignCategory(Constants.user_logs_category);
		ts=new UserLogsReportPage(driver);
		ts.loginActivityGraphLabel();
	}	

	@Test(priority=11)
	public void presenceOfLoginActivityGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Login Activity Graph Verification Test"); 
		logger.assignCategory(Constants.user_logs_category);
		ts=new UserLogsReportPage(driver);
		ts.loginActivityGraph();
	}
	
	@Test(priority=12)
	public void LoginActivityTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Login Activity Table Column Verification Test"); 
		logger.assignCategory(Constants.user_logs_category);
		ts=new UserLogsReportPage(driver);
		ts.loginActivityTableColumnVerification();
	}
	
	public void filterButtonElementsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Elements Test"); 
		logger.assignCategory(Constants.user_logs_category);
		ts=new UserLogsReportPage(driver);
		ts.filterElements();
	}
	
	public void filterFeatureForUserTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature For User Test"); 
		logger.assignCategory(Constants.user_logs_category);
		ts=new UserLogsReportPage(driver);
		ts.filterFeatureForAllActivityTable(Constants.LookerUserLogsReport.user_filter);
	}
	
	public void filterFeatureForGroupTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature For Group Test"); 
		logger.assignCategory(Constants.user_logs_category);
		ts=new UserLogsReportPage(driver);
		ts.filterFeatureForAllActivityTable(Constants.LookerUserLogsReport.group_filter);
	}
	
	public void filterFeatureForActivityTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Feature For Activity Test"); 
		logger.assignCategory(Constants.user_logs_category);
		ts=new UserLogsReportPage(driver);
		ts.filterFeatureForAllActivityTable(Constants.LookerUserLogsReport.activity_filter);
	}
	
	@AfterClass
	public void loggingOut() throws InterruptedException{
		
		ts=new UserLogsReportPage(driver);
		ts.switchToMainWindow();
		
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}
	
	
	
	

}
