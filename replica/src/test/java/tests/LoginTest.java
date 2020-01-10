package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.LoginPage;

public class LoginTest extends TestBase
{

	@Test(priority=1)
	public void login_page_UI_Verification() throws IOException{
        LoginPage lp=new LoginPage(driver,wait);
        logger=extent.startTest("login_page_UI_Verification..");
        logger.log(LogStatus.INFO, "verifying UI of login page");
        logger.assignCategory("Login Suite");
        lp.UIVerification_LoginPage();
     
	}

	@Test(priority=2)
	public void login_with_invalidate_cred() throws IOException{
        LoginPage lp=new LoginPage(driver,wait);
        logger=extent.startTest("login_with_invalidate_cred");       
        logger.log(LogStatus.INFO, "verifying login_with_invalidate_cred");
        logger.assignCategory("Login Suite");
        lp.loginWithInvalidUser();
     
	}
	
	@Test(priority=3)
	public void login_with_blank_username() throws IOException{
        LoginPage lp=new LoginPage(driver,wait);
        logger=extent.startTest("login_with_blank_username"); 
        logger.log(LogStatus.INFO, "verifying login with blank username. ");
        logger.assignCategory("Login Suite");
        lp.loginWithBlankUserName();
     
	}
	
	@Test(priority=4)
	public void login_with_blank_password() throws IOException{
        LoginPage lp=new LoginPage(driver,wait);
        logger=extent.startTest("login_with_blank_password");        
        logger.log(LogStatus.INFO, "verifying login with blank password. ");
        logger.assignCategory("Login Suite");
        lp.loginWithBlankPassword();
     
	}
	
	@Test(priority=5)
	public void login_with_inactive_user() throws IOException{
        LoginPage lp=new LoginPage(driver,wait);
        logger=extent.startTest("login_with_inactive_user"); 
        logger.log(LogStatus.INFO, "verifying login with inactive_user. ");
        logger.assignCategory("Login Suite");
        lp.loginWithInactiveUser();
     
	}
	
	@Test(priority=6)
	public void login_with_deleted_user() throws IOException{
        LoginPage lp=new LoginPage(driver,wait);
        logger=extent.startTest("login_with_deleted_user");        
        logger.log(LogStatus.INFO, "verifying login with deleted_user. ");
        logger.assignCategory("Login Suite");
        lp.loginWithDeletedUser();
     
	}
	
	@Test(priority=7)
	public void login_with_blank_username_and_password() throws IOException{
        LoginPage lp=new LoginPage(driver,wait);
        logger=extent.startTest("login_with_blank_username_and_password"); 
        logger.log(LogStatus.INFO, "verifying login with username_and_password. ");
        logger.assignCategory("Login Suite");
        lp.loginWithBlankUsernameAndPassword();
     
	}
	
	@Test(priority=8)
	public void UIVerification_forgot_passowrd_page() throws IOException, InterruptedException{
        LoginPage lp=new LoginPage(driver,wait);
        logger=extent.startTest("UIVerification_forgot_passowrd_page"); 
        logger.log(LogStatus.INFO, "verifying UI of reset password page. ");
        logger.assignCategory("Login Suite");
        lp.UIVerification_ResetPasswordPage();
     
	}
	
	@Test(priority=9)
	public void next_button_with_no_email_ID() throws IOException, InterruptedException{
        LoginPage lp=new LoginPage(driver,wait);
        logger=extent.startTest("next_button_with_no_email_ID"); 
        logger.log(LogStatus.INFO, "verifying next_button_with_no_email_ID. ");
        logger.assignCategory("Login Suite");
        lp.nextButtonClickOnResetPasswordPageWithBlankMailID();
     
	}
	
	@Test(priority=10)
	public void reset_password() throws IOException, InterruptedException{
        LoginPage lp=new LoginPage(driver,wait);
        logger=extent.startTest("reset_password"); 
        logger.log(LogStatus.INFO, "verifying reset_password feature. ");
        logger.assignCategory("Login Suite");
        lp.resetPasswordFeature();
     
	}
	
	@Test(priority=11)
	public void rememeber_me_functinonality() throws IOException, InterruptedException{
        LoginPage lp=new LoginPage(driver,wait);
        logger=extent.startTest("rememeber_me_functinonality"); 
        logger.log(LogStatus.INFO, "verifying rememeber_me feature. ");
        logger.assignCategory("Login Suite");
        lp.rememberMeFeature();
     
	}
	
	
	@Test(priority=12)
	public void validLogin() throws IOException{
        LoginPage lp=new LoginPage(driver,wait);
        logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        logger.assignCategory("Login Suite");
        lp.validLogin();		
	}

	
	
	
	
	
	
	
	
	
}