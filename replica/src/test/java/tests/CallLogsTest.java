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

public class CallLogsTest extends TestBase{

	HomePage hp;
	CallLogsReportPage clr;
	
	@BeforeClass
	public void goToLookerReports() throws InterruptedException, IOException{
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
		hp=new HomePage(driver);
		hp.clickAction("Reports");
		clr=new CallLogsReportPage(driver);
		clr.switchToIFrame();
	}
	
	
	@Test(priority=1)
	public void headerLabelVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Call logs header Label Verification Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
		clr.headerLabel();
	}
	
	@Test(priority=2)
	public void tilesVerification() throws IOException, InterruptedException{
		logger=extent.startTest("Tiles Verification Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.tilesVerification();
	}
	
	@Test(priority=3)
	public void presenceOfTotalCallsGraph() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Total Calls Graph Test"); 
		logger.assignCategory(Constants.call_logs_category);
        
        clr=new CallLogsReportPage(driver);
        clr.totalCallsGraph();
	}
	
	@Test(priority=4)
	public void presenceOfUniqueCallsGraph() throws IOException, InterruptedException{
		logger=extent.startTest("Presence Of Unique Calls Graph Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.totalCallsGraph();
	}
	
	@Test(priority=5)
	public void tableColumnsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Table Columns Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.columnsVerification();
	}
	
	@Test(priority=6)
	public void filterButtonTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.filterButton();
	}
	
	@Test(priority=7)
	public void filterButtonElementsTest() throws IOException, InterruptedException{
		logger=extent.startTest("Filter Button Elements Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.filterElements();
	}
	
	@Test(priority=8)
	public void footerNoteTest() throws IOException, InterruptedException{
		logger=extent.startTest("Footer Note Test"); 
		logger.assignCategory(Constants.call_logs_category);
        clr=new CallLogsReportPage(driver);
        clr.footerNote();
	}
	
	@AfterClass
	public void goBackToHomePage() throws InterruptedException{
		hp=new HomePage(driver);
		hp.clickAction("Home");
	}
	
}
