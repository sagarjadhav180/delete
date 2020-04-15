package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
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
        logger.assignCategory(Constants.login_page_category);
        lp.validLogin();
        hp=new HomePage(driver);
        hp.left_hand_navigation_bar_click();

         
	}

//	@Test(priority=1)
//	public void default_state_left_hand_navigation_bar() throws InterruptedException{
//		hp=new HomePage(driver);
//		logger=extent.startTest("default_state_left_hand_navigation_bar");
//		logger.log(LogStatus.INFO, "verifying if left_hand_navigation_bar is by clickable..");
//		logger.assignCategory("Home page Suite");
//		hp.default_collpased_left_hand_navigation_bar_click();
//	}
	
	@Test(priority=1)
	public void ui_verification() throws InterruptedException{
		hp=new HomePage(driver);
		logger=extent.startTest("ui_verification");
		logger.log(LogStatus.INFO, "verifying UI of the Home page..");
		logger.assignCategory(Constants.home_page_category);
		hp.UIVerification();
	} 
	
	@Test(priority=2)
	public void tiles_count_verification_UI() throws InterruptedException{
		hp=new HomePage(driver);
		logger=extent.startTest("count_verification_UI");
		logger.log(LogStatus.INFO, "verifying count displayed on UI..");
		logger.assignCategory(Constants.home_page_category);
		hp.tilesCount();
	}
	
	//loging out -tear down
	@AfterClass
	public void logOut() throws IOException{
		LoginPage lp=new LoginPage(driver);
		logger=extent.startTest("LogOut"); 
		logger.log(LogStatus.INFO, "loggin out.. ");
		lp.logOut();
		        		
    }
		
		
		
	
	

}
