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
		ivr.pathPerformanceLabelVerification();
	}
	
	
	public void unusedPathLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Unused Path Label Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.ususedPathLabelVerification();
	}
	
	
	public void callsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Calls Label Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.callsLabelVerification();
	}
	
	
	public void instantInsightsLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Instant Insights Label Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.instantInsightsLabelVerification();
	}
	
	
	public void totalCallsCountForIVRVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Total Calls Count Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tileValueVerificationForIVR(Constants.LookerIVRKeypressReport.total_call_tile);
	}
	
	
	public void ivrCallsCountForIVRVerification() throws IOException, InterruptedException{
		logger=extent.startTest("IVR Calls Count Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tileValueVerificationForIVR(Constants.LookerIVRKeypressReport.ivr_calls_tile);
	}
	
	
	public void avgTimeInMenuForIVRVerification() throws IOException, InterruptedException{
		logger=extent.startTest("avg Time In Menu Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tileValueVerificationForIVR(Constants.LookerIVRKeypressReport.avg_time_tile);
	}
	
	
	public void abandonedCallsForIVRVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Abandoned Calls Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tileValueVerificationForIVR(Constants.LookerIVRKeypressReport.abandoned_calls_tile);
	}
	
	
	public void totalCallsForInstantInsightsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Total Calls Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tileValueVerificationForInstantInsights(Constants.LookerIVRKeypressReport.total_call_tile_instnat_insights);
	}
	
	
	public void callsWithInstantsInsightsForInstantInsightsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Calls With Instants Insights Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tileValueVerificationForInstantInsights(Constants.LookerIVRKeypressReport.calls_with_instant_insights_tile);
	}
	
	
	public void callsWithAgentIDForInstantInsightsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Calls With Agent ID Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tileValueVerificationForInstantInsights(Constants.LookerIVRKeypressReport.calls_with_agent_id_tile);
	}
	
	
	public void callsWithCallOutcomeForInstantInsightsVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Call Outcome Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.tileValueVerificationForInstantInsights(Constants.LookerIVRKeypressReport.calls_with_call_outcome_tile);
	}
	
	
	public void pathPerformanceTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Path Performance Table Column Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.pathPerformanceTableColumnVerification();
	}
	
	
	public void unusedPathTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Unused Path Table Column Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.unusedPathTableColumnVerification();
	}
	
	
	public void callsTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Calls Table Column Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.callsTableColumnVerification();
	}
	
	
	public void instantInsightsTableColumnVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Instant Insights Table Column Verification Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.instantInsightsTableColumnVerification();
	}
	
	
	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.filterButton();
	}
	
	
	public void filterButtonElementsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Elements Test"); 
		logger.assignCategory(Constants.ivr_keypress_category);
		ivr=new IVRKeypressReportPage(driver);
		ivr.filterElements();
	}
	
	@AfterClass
	public void loggingOut() throws InterruptedException{
		
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("LogOut"); 
        logger.log(LogStatus.INFO, "loggin out.. ");
        lp.logOut();
	}

}
