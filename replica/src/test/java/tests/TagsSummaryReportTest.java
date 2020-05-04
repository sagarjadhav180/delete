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
import pom.MarketingDashboardPage;
import pom.TagsSummaryPage;

public class TagsSummaryReportTest extends TestBase{
	
	HomePage hp;
	CallLogsReportPage clr;
	TagsSummaryPage ts;
	
	@BeforeClass
	public void goToLookerReports() throws InterruptedException, IOException{
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(7000);
		clr.goToReport(Constants.LookerReports.tags_summary_report);

		clr.switchToIFrame();

	}

	@Test(priority=1)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        ts=new TagsSummaryPage(driver);
		ts.headerLabel();
	}
	
	@Test(priority=2)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        ts=new TagsSummaryPage(driver);
		ts.presenceOfGearIcon();
	}
	
	@Test(priority=3)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        ts=new TagsSummaryPage(driver);
        ts.gearIconOptions();
	}
	
	@Test(priority=4)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        ts=new TagsSummaryPage(driver);
		ts.presenceOfTimeZone();
	}
	
	
	@AfterClass
	public void loggingOut() throws InterruptedException{
		
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}

}
