package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.CallDetailsReport_Page;
import pom.HomePage;
import pom.LoginPage;

public class CallDetailReportTest extends TestBase{

	CallDetailsReport_Page cdr;
	HomePage hp;
	
	
	@BeforeClass
	public void goToCallDetailsReportPage() throws InterruptedException, IOException{
	
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        logger.assignCategory("Login Suite");
        lp.validLogin();
        
        hp=new HomePage(driver);
        hp.left_hand_navigation_bar_click();
		hp.clickAction("Legacy Reports");
		
		hp.click_subLink("Call Details");
	}
	
	//ui verification of call details page
	@Test(priority=1)
	public void uiVerification() throws InterruptedException{
		logger=extent.startTest("uiVerification Test");
		logger.assignCategory("Call Details Suite");
		
		cdr=CallDetailsReport_Page.instance();
	    cdr.UIVerification();
	}
	
	@Test(priority=2)
	public void pagination(){
		logger=extent.startTest("pagination Test");
		logger.assignCategory("Call Details Test");
		
		cdr=CallDetailsReport_Page.instance();
		cdr.pagination();
	}
	  
	 
	
	//loging out -tear down
	@AfterClass
	public void tearDown() throws IOException{
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("LogOut"); 
		logger.log(LogStatus.INFO, "loggin out.. ");
		lp.logOut();
		        		
	}
	
}
