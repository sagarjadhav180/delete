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
	public void goToLookerReports() throws Exception{
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
        goToReport();
	}
	
	public void goToReport() throws Exception{
		ivr=new IVRKeypressReportPage(driver);
		clr=new CallLogsReportPage(driver);
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		Thread.sleep(1000);
		clr.goToReport(Constants.LookerReports.ivr_keypress_report);
        Thread.sleep(7000);
		ivr.switchToIFrame();
	}

	@Test(priority=1)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Header Label Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
        ivr=new IVRKeypressReportPage(driver);
		ivr.headerLabel();
	}
	
	@Test(priority=2)
	public void runButtonVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Run Button Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
        ivr=new IVRKeypressReportPage(driver);
		ivr.runButton();
	}
	
	@Test(priority=3)
	public void presenceOfGearIconVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Gear Icon Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
        ivr=new IVRKeypressReportPage(driver);
		ivr.presenceOfGearIcon();
	}
	
	@Test(priority=4)
	public void gearIconOptionsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Gear Icon options Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
        ivr=new IVRKeypressReportPage(driver);
        ivr.gearIconOptions();
	}
	
	@Test(priority=5)
	public void presenceOfTimeZoneVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Time Zone Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
        ivr=new IVRKeypressReportPage(driver);
		ivr.presenceOfTimeZone();
	}
	
	@Test(priority=6)
	public void tilesVerificationForIVR() throws IOException, InterruptedException{
		logger=extent.startTest("Tiles Verification for IVR Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tilesVerificationForIVR();
	}
	
	@Test(priority=7)
	public void tilesVerificationForInstantInsights() throws IOException, InterruptedException{
		logger=extent.startTest("Tiles Verification for Instant Insights Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tilesVerificationForInstantInghts();
	}
	
	@Test(priority=8)
	public void pathPerformanceLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Path Performance Label Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.pathPerformanceLabelVerification();
	}
	
	@Test(priority=9)
	public void unusedPathLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Unused Path Label Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.ususedPathLabelVerification();
	}
	
	@Test(priority=10)
	public void callsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Calls Label Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.callsLabelVerification();
	}
	
	@Test(priority=11)
	public void instantInsightsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Instant Insights Label Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.instantInsightsLabelVerification();
	}
	
	@Test(priority=12)
	public void totalCallsCountForIVRVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Total Calls Count Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tileValueVerificationForIVR(Constants.LookerIVRKeypressReport.total_call_tile);
	}
	
	@Test(priority=13)
	public void ivrCallsCountForIVRVerification() throws IOException, InterruptedException{
		logger=extent.startTest("IVR Calls Count Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tileValueVerificationForIVR(Constants.LookerIVRKeypressReport.ivr_calls_tile);
	}
	
	@Test(priority=14)
	public void avgTimeInMenuForIVRVerification() throws IOException, InterruptedException{
		logger=extent.startTest("avg Time In Menu Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tileValueVerificationForIVR(Constants.LookerIVRKeypressReport.avg_time_tile);
	}
	
	@Test(priority=15)
	public void abandonedCallsForIVRVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Abandoned Calls Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tileValueVerificationForIVR(Constants.LookerIVRKeypressReport.abandoned_calls_tile);
	}
	
	@Test(priority=16)
	public void totalCallsForInstantInsightsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Total Calls Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tileValueVerificationForInstantInsights(Constants.LookerIVRKeypressReport.total_call_tile_instnat_insights);
	}
	
	@Test(priority=17)
	public void callsWithInstantsInsightsForInstantInsightsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Calls With Instants Insights Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tileValueVerificationForInstantInsights(Constants.LookerIVRKeypressReport.calls_with_instant_insights_tile);
	}
	
	@Test(priority=18)
	public void callsWithAgentIDForInstantInsightsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Calls With Agent ID Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tileValueVerificationForInstantInsights(Constants.LookerIVRKeypressReport.calls_with_agent_id_tile);
	}
	
	@Test(priority=19)
	public void callsWithCallOutcomeForInstantInsightsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Call Outcome Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tileValueVerificationForInstantInsights(Constants.LookerIVRKeypressReport.calls_with_call_outcome_tile);
	}
	
	@Test(priority=20)
	public void pathPerformanceTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Path Performance Table Column Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.pathPerformanceTableColumnVerification();
	}
	
	@Test(priority=21)
	public void unusedPathTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Unused Path Table Column Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.unusedPathTableColumnVerification();
	}
	
	@Test(priority=22)
	public void callsTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Calls Table Column Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.callsTableColumnVerification();
	}
	
	@Test(priority=23)
	public void instantInsightsTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Instant Insights Table Column Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.instantInsightsTableColumnVerification();
	}
	
	@Test(priority=24)
	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.filterButton();
	}
	
	@Test(priority=25)
	public void filterButtonElementsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Elements Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.filterElements();
	}
	
	@AfterClass
	public void loggingOut() throws InterruptedException{
		
		ivr=new IVRKeypressReportPage(driver);
		ivr.switchToMainWindow();
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}

}
