package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.BlockedCallsReportPage;
import pom.CallLogsReportPage;
import pom.HomePage;
import pom.LoginPage;

public class BlockedCallReportTest extends TestBase{
	
	HomePage hp;
	CallLogsReportPage clr;
	BlockedCallsReportPage bc;
	
	@BeforeClass
	public void goToLookerReports() throws InterruptedException, IOException{
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(7000);
		clr.goToReport(Constants.LookerReports.blocked_calls_report);

		clr.switchToIFrame();

	}

	@Test(priority=1)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.blocked_calls_category);
        bc=new BlockedCallsReportPage(driver);
		bc.headerLabel();
	}
	
	@Test(priority=2)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.blocked_calls_category);
        bc=new BlockedCallsReportPage(driver);
		bc.presenceOfGearIcon();
	}
	
	@Test(priority=3)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.blocked_calls_category);
        bc=new BlockedCallsReportPage(driver);
		bc.gearIconOptions();
	}
	
	@Test(priority=4)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.blocked_calls_category);
        bc=new BlockedCallsReportPage(driver);
		bc.presenceOfTimeZone();
	}
	
	
	@AfterClass
	public void loggingOut() throws InterruptedException{
		
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}

}
