package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.Call_Logs_Report_Page;
import pom.HomePage;
import pom.LoginPage;

public class Call_Logs_Test extends TestBase{

	HomePage hp;
	Call_Logs_Report_Page clr;
	
	@BeforeClass
	public void goToLookerReports() throws InterruptedException, IOException{
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        lp.validLogin();
        
		hp=new HomePage(driver);
		hp.left_hand_navigation_bar_click();
		hp.clickAction("Reports");
		
	}
	
	
	@Test(priority=1)
	public void UI_Verification() throws IOException, InterruptedException{
		logger=extent.startTest("Call logs UI_Verification"); 
		logger.assignCategory("Call logs Suite");
        logger.log(LogStatus.INFO, "verifying UI of call logs report. ");
		clr=new Call_Logs_Report_Page(driver);
		clr.uiVerification();
	}
	
	@AfterClass
	public void goBackToHomePage() throws InterruptedException{
		hp=new HomePage(driver);
		hp.clickAction("Home");
	}
	
}
