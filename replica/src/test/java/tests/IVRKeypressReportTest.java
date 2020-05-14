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
import pom.LookerTrackingNumberSettingsPage;

public class IVRKeypressReportTest extends TestBase{
	
	HomePage hp;
	CallLogsReportPage clr;
	IVRKeypressReportPage ivr;
	
	@BeforeClass
	public void goToLookerReports() throws InterruptedException, IOException{
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(7000);
		clr.goToReport(Constants.LookerReports.ivr_keypress_report);

		clr.switchToIFrame();

	}

	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
        ivr=new IVRKeypressReportPage(driver);
		ivr.headerLabel();
	}
	
	public void runButtonVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Run Button Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
        ivr=new IVRKeypressReportPage(driver);
		ivr.runButton();
	}
	
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
        ivr=new IVRKeypressReportPage(driver);
		ivr.presenceOfGearIcon();
	}
	

	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
        ivr=new IVRKeypressReportPage(driver);
        ivr.gearIconOptions();
	}
	
	
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
        ivr=new IVRKeypressReportPage(driver);
		ivr.presenceOfTimeZone();
	}
	
	
	public void tilesVerificationForIVR() throws IOException, InterruptedException{
		logger=extent.startTest("Tiles Verification for IVR Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tilesVerificationForIVR();
	}
	
	
	public void tilesVerificationForInstantInsights() throws IOException, InterruptedException{
		logger=extent.startTest("Tiles Verification for Instant Insights Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tilesVerificationForInstantInghts();
	}
	
	
	public void pathPerformanceLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Path Performance Label Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr
	}
	
	
	public void unusedPathLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Unused Path Label Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr
	}
	
	
	public void callsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Calls Label Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr
	}
	
	
	public void instantInsightsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Instant Insights Label Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr
	}
	
	@AfterClass
	public void loggingOut() throws InterruptedException{
		
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}

}
