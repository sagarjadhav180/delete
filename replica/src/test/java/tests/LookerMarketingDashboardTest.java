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

public class LookerMarketingDashboardTest extends TestBase {
	
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
	public void runButtonVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Run Button Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
		mkt.runButton();
	}
	
	@Test(priority=2)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
		mkt.headerLabel();
	}
	
	@Test(priority=3)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
		mkt.presenceOfGearIcon();
	}
	
	@Test(priority=4)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.gearIconOptions();
	}

	@Test(priority=5)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
		mkt.presenceOfTimeZone();
	}

	@Test(priority=6)
	public void marketingDashbordTileVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Marketing Dashbord Tile Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.marketingDahsboardTilesVerification();
	}
	
	@Test(priority=7)
	public void totalCallsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Total Calls Count Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.tileValueVerificationForDefault7DaysFilter(Constants.MarketingDashboardReport.total_calls_tile);
	}
	
	@Test(priority=8)
	public void leadsCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Leads Count Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.tileValueVerificationForDefault7DaysFilter(Constants.MarketingDashboardReport.leads_tile);
	}
	
	@Test(priority=9)
	public void conversionCountVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Conversion Count Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.tileValueVerificationForDefault7DaysFilter(Constants.MarketingDashboardReport.conversion_tile);
	}

	@Test(priority=10)
	public void callMixGraphLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Call Mix Graph Label Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.callMixLabel();
	}
	
	@Test(priority=11)
	public void highestConvertingLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Highest Converting Graph Label Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.highestConvertingLabel();
	}
	
	@Test(priority=12)
	public void totalCallsGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Total Calls Graph presence Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.totalCallsGraph();
	}
	
	@Test(priority=13)
	public void uniqueCallsGraphVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Unique Calls Graph presence Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.uniqueCallsGraph();
	}

	@Test(priority=14)
	public void marketingDashboardTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Marketing Dashboard Table Column Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.marketingDashboardTableColumnVerification();
	}

	@Test(priority=15)
	public void websiteCallsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Website Calls Label Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.websiteCallsLabel();
	}
	
	@Test(priority=16)
	public void websiteCallsTilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Website Calls Tile Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.websiteCallsTilesVerification();
	}
	
	@Test(priority=17)
	public void websiteNumberSwapsMapLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Website Number Swaps Label Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.websiteNumberSwapsMapLabel();
	}
	
	@Test(priority=18)
	public void websiteCallsMapLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Website Calls Label Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.websiteCallsMapLabel();
	}
	
	@Test(priority=19)
	public void websiteNumberSwapsMapVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Website Number Swaps Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.websiteNumberSwapsMap();
	}
	
	@Test(priority=20)
	public void websiteCallsMapVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Website Calls Label Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.websiteCallsMap();
	}
	
	@Test(priority=21)
	public void websiteCallsTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Website Calls Table Column Verification Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
        mkt=new MarketingDashboardPage(driver);
        mkt.websiteCallsTableColumnVerification();
	}

	@Test(priority=22)
	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.marketing_dashboard_category);
		mkt=new MarketingDashboardPage(driver);
        mkt.filterButton();
	}
	
	@Test(priority=23)
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
