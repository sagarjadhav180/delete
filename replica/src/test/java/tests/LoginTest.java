package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.LoginPage;

public class LoginTest extends TestBase
{

	//Login page UI verification
	@Test(priority=1)
	public void login_page_UI_Verification() throws IOException{
        LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("login_page_UI_Verification..");
        logger.log(LogStatus.INFO, "verifying UI of login page");
        logger.assignCategory(Constants.login_page_category);
        lp.UIVerification_LoginPage();
     
	}

	//Validate login funcutonality with invalidate cred.
	@Test(priority=2)
	public void login_with_invalidate_cred() throws IOException{
        LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("login_with_invalidate_cred");       
        logger.log(LogStatus.INFO, "verifying login_with_invalidate_cred");
        logger.assignCategory(Constants.login_page_category);
        lp.loginWithInvalidUser();
     
	}
	
	//Validate log in with blank user name 
	@Test(priority=3)
	public void login_with_blank_username() throws IOException{
        LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("login_with_blank_username"); 
        logger.log(LogStatus.INFO, "verifying login with blank username. ");
        logger.assignCategory(Constants.login_page_category);
        lp.loginWithBlankUserName();
     
	}
	
	//Validate log in with blank password
	@Test(priority=4)
	public void login_with_blank_password() throws IOException{
        LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("login_with_blank_password");        
        logger.log(LogStatus.INFO, "verifying login with blank password. ");
        logger.assignCategory(Constants.login_page_category);
        lp.loginWithBlankPassword();
     
	}
	
	//Check if inactive user is not able to login 
	@Test(priority=5)
	public void login_with_inactive_user() throws IOException{
        LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("login_with_inactive_user"); 
        logger.log(LogStatus.INFO, "verifying login with inactive_user. ");
        logger.assignCategory(Constants.login_page_category);
        lp.loginWithInactiveUser();
     
	}
	
	//Check if deleted user is not able to login
	@Test(priority=6)
	public void login_with_deleted_user() throws IOException{
        LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("login_with_deleted_user");        
        logger.log(LogStatus.INFO, "verifying login with deleted_user. ");
        logger.assignCategory(Constants.login_page_category);
        lp.loginWithDeletedUser();
     
	}
	
	//Validate log in with blank password and username
	@Test(priority=7)
	public void login_with_blank_username_and_password() throws IOException{
        LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("login_with_blank_username_and_password"); 
        logger.log(LogStatus.INFO, "verifying login with username_and_password. ");
        logger.assignCategory(Constants.login_page_category);
        lp.loginWithBlankUsernameAndPassword();
     
	}
	
	//Verify UI of forgot passowrd page
	@Test(priority=8)
	public void UIVerification_forgot_passowrd_page() throws IOException, InterruptedException{
        LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("UIVerification_forgot_passowrd_page"); 
        logger.log(LogStatus.INFO, "verifying UI of reset password page. ");
        logger.assignCategory(Constants.login_page_category);
        lp.UIVerification_ResetPasswordPage();
     
	}
	
	//Validate Next button with no email id
	@Test(priority=9)
	public void next_button_with_no_email_ID() throws IOException, InterruptedException{
        LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("next_button_with_no_email_ID"); 
        logger.log(LogStatus.INFO, "verifying next_button_with_no_email_ID. ");
        logger.assignCategory(Constants.login_page_category);
        lp.nextButtonClickOnResetPasswordPageWithBlankMailID();
     
	}
	
	//Check if user is able to reset password
	@Test(priority=10)
	public void reset_password() throws IOException, InterruptedException{
        LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("reset_password"); 
        logger.log(LogStatus.INFO, "verifying reset_password feature. ");
        logger.assignCategory(Constants.login_page_category);
        lp.resetPasswordFeature();
     
	}
	
	//Validate remember me functionality 
	@Test(priority=11)
	public void rememeber_me_functinonality() throws IOException, InterruptedException{
        LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("rememeber_me_functinonality"); 
        logger.log(LogStatus.INFO, "verifying rememeber_me feature. ");
        logger.assignCategory(Constants.login_page_category);
        lp.rememberMeFeature();
     
	}
	
	//check if user is able to login with valid credentials
	@Test(priority=12)
	public void validLogin() throws IOException{
        LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        logger.assignCategory(Constants.login_page_category);
        lp.validLogin();		
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
