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
import pom.IVRKeypressReportPage;
import pom.LoginPage;
import pom.MarketingDashboardPage;

public class MarketingDashboardTest extends TestBase {
	
	HomePage hp;
	CallLogsReportPage clr;
	MarketingDashboardPage mkt;
	
	@BeforeClass
	public void goToLookerReports() throws Exception{
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
        goToReport();
	}

	public void goToReport() throws Exception{
		mkt=new MarketingDashboardPage(driver);
		clr=new CallLogsReportPage(driver);
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(1000);
		clr.goToReport(Constants.LookerReports.marketing_dashboard_report);
        Thread.sleep(7000);
		mkt.switchToIFrame();
	}
	
	@Test(priority=1)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
		mkt.headerLabel();
	}
	
	@Test(priority=2)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
		mkt.presenceOfGearIcon();
	}
	
	@Test(priority=3)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.gearIconOptions();
	}
	
	@Test(priority=4)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
		mkt.presenceOfTimeZone();
	}
	
	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
		mkt=new MarketingDashboardPage(driver);
        mkt.filterButton();
	}
	
	public void filterButtonElementsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Elements Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
		mkt=new MarketingDashboardPage(driver);
        mkt.filterElements();
	}
	
	@AfterClass
	public void loggingOut() throws InterruptedException{
		
		mkt=new MarketingDashboardPage(driver);
		mkt.switchToMainWindow();
		
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}

}
