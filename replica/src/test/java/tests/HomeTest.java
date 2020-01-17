package tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.HomePage;
import pom.LoginPage;

public class HomeTest extends TestBase
{
	HomePage hp;
	
	@BeforeClass
	public void validLogin() throws IOException{
        LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        logger.assignCategory("Login Suite");
        lp.validLogin();		
	}

	
	
	@Test(priority=1)
	public void ui_verification() throws InterruptedException{
		hp=new HomePage(driver);
		logger=extent.startTest("ui_verification");
		logger.log(LogStatus.INFO, "verifying UI of the Home page..");
		logger.assignCategory("Home page Suite");
		hp.UIVerification();
	} 
	
	@Test(priority=2)
	public void tiles_count_verification_UI() throws InterruptedException{
		hp=new HomePage(driver);
		logger=extent.startTest("count_verification_UI");
		logger.log(LogStatus.INFO, "verifying count displayed on UI..");
		logger.assignCategory("Home page Suite");
		hp.tilesCount();
	}
	

}
