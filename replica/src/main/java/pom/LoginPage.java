package pom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import tests.TestBase;
import tests.Util;

public class LoginPage extends TestBase {

	SoftAssert softassert=new SoftAssert();
	
	//Login page
	@FindBy(xpath="//div[@id='login_logo']")
	private static WebElement logo;

	@FindBy(xpath="//h4[@class='text-center welcome_text']")
	private static WebElement welcometext;
	
	@FindBy(xpath="//*[@id='email']")
	private static WebElement username_Field;

	@FindBy(xpath="//input[@placeholder='Password']")
	private static WebElement password_Field;	
	
	@FindBy(xpath="//*[@id='b1']")
	private static WebElement login_button;		
	
	@FindBy(xpath="//h4[text()='Invalid email or password']")
	private static WebElement error_message;			

	@FindBy(xpath="//input[@name='remember']")
	private static WebElement rememberMe_Checkbox;	
	
	@FindBy(xpath="//a[@class='pull-left']")
	private static WebElement forgotPassword_link;	
	
//	@FindBy(xpath="//span[@class='hidden-xs ng-binding' and contains(text(),'"+TestBase.getFirst_last_name()+"')]")
//	private static WebElement userprofile_link;

	@FindBy(xpath="//a[@class='navbar-brand']")
	private static WebElement logged_in_logo;
	
	@FindBy(xpath="//button[@id='_pendo-close-guide_']")
	private static WebElement pendo_popup_close_button;
	
	@FindBy(xpath="//a[@class='dropdown-toggle username bootstro']//img")
	private static WebElement profileButton;

	@FindBy(xpath="//a[@class='text-right ng-scope']")
	private static WebElement logoutLink;
	
	String invalid_username="inavalid_user@yopmail.com";
	String invalid_password="lmc2demo";
	
	String inactive_username="inactive_user@yopmail.com";
	String deleted_username="deleted_user@yopmail.com";
	
	String common_password="lmc2demo";

	
	//Reset Password page
	
	@FindBy(xpath="//h4[text()='Forgot Password Recovery']")
	private static WebElement forgot_password_window_title;	
	
	@FindBy(xpath="//input[@id='email']")
	private static WebElement email_textbox;
	
	@FindBy(xpath="//a[@class='btn btn-success']")
	private static WebElement nextButton;

	@FindBy(xpath="//a[@class='btn btn-default']")
	private static WebElement backButton;

	@FindBy(xpath="//div[contains(text(),'Check your e-mail for your temporary password')]")
	private static WebElement resetPasswordSuccessMessage;

	@FindBy(xpath="//div[contains(text(),'Email field can not be empty.. Please enter your e-mail')]")
	private static WebElement resetPasswordFailureMessage;
	
//    public static WebDriverWait wait;
//    public static ExtentTest logger;
//    public  static ExtentReports extent;
    
	public LoginPage (WebDriver driver){
		
		PageFactory.initElements(driver, this);
//        this.wait=wait1;	
//        this.logger=logger1;
//        this.extent=extent;
	}
	

	public void UIVerification_LoginPage(){
		
		//Verification of logo
		wait.until(ExpectedConditions.visibilityOf(logo));
		logger.log(LogStatus.INFO, "Verifying presence of logo..");
		softassert.assertTrue(logo.isDisplayed(),"logo is not present or locator has changed");
		
		//Verification of welcome text
		logger.log(LogStatus.INFO, "Verifying presence of welcome text..");
		softassert.assertTrue(welcometext.isDisplayed(),"welcome text is not present or locator has changed");

		//Verification of username
		logger.log(LogStatus.INFO, "Verifying presence of username field..");
		softassert.assertTrue(username_Field.isDisplayed(),"username filed is not present or locator has changed");

		//Verification of password
		logger.log(LogStatus.INFO, "Verifying presence of password field..");
		softassert.assertTrue(password_Field.isDisplayed(),"password field is not present or locator has changed");

		//Verification of login button
		logger.log(LogStatus.INFO, "Verifying presence of login button..");
		softassert.assertTrue(login_button.isDisplayed(),"login button is not present or locator has changed");

		//Verification of remember me checkbox
		logger.log(LogStatus.INFO, "Verifying presence of remember me checkbox..");
		softassert.assertTrue(rememberMe_Checkbox.isDisplayed(),"remember me checkbox is not present or locator has changed");

		//Verification of Forgot password link and its enable
		logger.log(LogStatus.INFO, "Verifying presence of Forgot password link..");
		softassert.assertTrue(forgotPassword_link.isDisplayed(),"Forgot password link checkbox is not present or locator has changed");
		softassert.assertTrue(forgotPassword_link.isEnabled(),"Forgot password link is not enabled");		
		softassert.assertAll();
	}
	
	public void loginWithInvalidUser(){
		
		wait.until(ExpectedConditions.visibilityOf(username_Field));
		
		wait.until(ExpectedConditions.visibilityOf(password_Field));
		
		wait.until(ExpectedConditions.visibilityOf(login_button));
		username_Field.clear();
		logger.log(LogStatus.INFO, "entering invalid username");
		username_Field.sendKeys(invalid_username);

		password_Field.clear();
		logger.log(LogStatus.INFO, "entering password");
		password_Field.sendKeys(common_password);
		login_button.click();
		
		logger.log(LogStatus.INFO, "To check if error message is displayed");
		softassert.assertTrue(error_message.isDisplayed(),"error message is not present or locator has changed");
		softassert.assertAll();
	}
	
    public void loginWithInactiveUser(){
		wait.until(ExpectedConditions.visibilityOf(username_Field));
		
		wait.until(ExpectedConditions.visibilityOf(password_Field));
		
		wait.until(ExpectedConditions.visibilityOf(login_button));
		username_Field.clear();
		logger.log(LogStatus.INFO, "entering inactive username");
		username_Field.sendKeys(inactive_username);

		
		
		password_Field.clear();
		logger.log(LogStatus.INFO, "entering password");
		password_Field.sendKeys(common_password);
		login_button.click();
		
		logger.log(LogStatus.INFO, "To check if error message is displayed");
		softassert.assertTrue(error_message.isDisplayed(),"error message is not present or locator has changed");		
		softassert.assertAll();
    }
	
    public void loginWithDeletedUser(){
        wait.until(ExpectedConditions.visibilityOf(username_Field));
		
		wait.until(ExpectedConditions.visibilityOf(password_Field));
		
		wait.until(ExpectedConditions.visibilityOf(login_button));
		username_Field.clear();
		logger.log(LogStatus.INFO, "entering Deleted username");
		username_Field.sendKeys(deleted_username);

		
		
		password_Field.clear();
		logger.log(LogStatus.INFO, "entering password");
		password_Field.sendKeys(common_password);
		login_button.click();
		
		logger.log(LogStatus.INFO, "To check if error message is displayed");
		softassert.assertTrue(error_message.isDisplayed(),"error message is not present or locator has changed");		
		softassert.assertAll();
    }

    public void loginWithBlankUserName(){

        wait.until(ExpectedConditions.visibilityOf(username_Field));
		
		wait.until(ExpectedConditions.visibilityOf(password_Field));
		
		wait.until(ExpectedConditions.visibilityOf(login_button));
		username_Field.clear();
		password_Field.clear();
		logger.log(LogStatus.INFO, "entering password");
		password_Field.sendKeys(common_password);
		
		logger.log(LogStatus.INFO, "To check if login button is not enabled");
		softassert.assertFalse(login_button.isEnabled(),"login_button is not enabled");		
		softassert.assertAll();
    }
    
    public void loginWithBlankPassword(){
        wait.until(ExpectedConditions.visibilityOf(username_Field));
		
		wait.until(ExpectedConditions.visibilityOf(password_Field));
		
		wait.until(ExpectedConditions.visibilityOf(login_button));
		username_Field.clear();
		logger.log(LogStatus.INFO, "entering username");
		username_Field.sendKeys(deleted_username);
		password_Field.clear();
		logger.log(LogStatus.INFO, "To check if login button is not enabled");
		softassert.assertFalse(login_button.isEnabled(),"login_button is not enabled");
		softassert.assertAll();
    }
    
    public void loginWithBlankUsernameAndPassword(){
    
    	    wait.until(ExpectedConditions.visibilityOf(username_Field));
		
    		wait.until(ExpectedConditions.visibilityOf(password_Field));
    		
    		wait.until(ExpectedConditions.visibilityOf(login_button));
    		username_Field.clear();
    		password_Field.clear();
    		
    		logger.log(LogStatus.INFO, "To check if login button is not enabled");
    		softassert.assertFalse(login_button.isEnabled(),"login_button is enabled");	
    		softassert.assertAll();
    }
    
 
    
    public void UIVerification_ResetPasswordPage() throws InterruptedException{
    	
    	logger.log(LogStatus.INFO,"navigating to reset password page");
    	forgotPassword_link.click();
    	
    	wait.until(ExpectedConditions.visibilityOf(forgot_password_window_title));
    	softassert.assertTrue(forgot_password_window_title.isDisplayed(),"forgot_password_window_title is not present or locator changed");
    	softassert.assertTrue(email_textbox.isDisplayed(),"email_textbox is not present or locator changed");
    	softassert.assertTrue(nextButton.isDisplayed(),"nextButton is not present or locator changed");
    	softassert.assertTrue(backButton.isDisplayed(),"backButton is not present or locator changed");
    	softassert.assertTrue(logo.isDisplayed(),"logo is not present or locator changed");
    	softassert.assertAll();
    	Thread.sleep(2000);
        Util.click(backButton);	
    	
    	
	}
    
    public void nextButtonClickOnResetPasswordPageWithBlankMailID(){
    	
    	logger.log(LogStatus.INFO,"navigating to reset password page");
    	forgotPassword_link.click();
    	
    	Util.click(nextButton);	
    	softassert.assertTrue(resetPasswordFailureMessage.isDisplayed(),"failure message is not displayed or locator changed");
    	Util.click(backButton);	
    	softassert.assertAll();
    }
    
    
    
    public void resetPasswordFeature() throws IOException{
    	logger.log(LogStatus.INFO,"navigating to reset password page");
    	forgotPassword_link.click();
    	wait.until(ExpectedConditions.visibilityOf(email_textbox));
Properties prop=new Properties();
		
		FileInputStream file=new FileInputStream(".//property");
		prop.load(file);
		String username=prop.getProperty("username");
    	email_textbox.sendKeys(username);
    	Util.click(nextButton);
    	logger.log(LogStatus.INFO, "Verifying if reset password mail is trigerred");
    	wait.until(ExpectedConditions.visibilityOf(resetPasswordSuccessMessage));
    	softassert.assertTrue(resetPasswordSuccessMessage.isDisplayed(),"resetPasswordSuccessMessage is not displayed or locator changed");
    	softassert.assertAll();
    	Util.click(backButton);
    }
    
    public void rememberMeFeature() throws IOException, InterruptedException{
        
    	logger.log(LogStatus.INFO, "rememberMeFeature test case running..");
		
		Properties prop=new Properties();
		
		FileInputStream file=new FileInputStream(".//property");
		prop.load(file);
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		
		wait.until(ExpectedConditions.visibilityOf(username_Field));
		
    	
		wait.until(ExpectedConditions.visibilityOf(password_Field));
		
		wait.until(ExpectedConditions.visibilityOf(login_button));
		
		username_Field.clear();
		username_Field.sendKeys(username);
		
		password_Field.clear();
		password_Field.sendKeys(password);
		
		rememberMe_Checkbox.click();
		
		login_button.click();
		
//		driver.switchTo().activeElement();
//		pendo_popup_close_button.click();
		
		wait.until(ExpectedConditions.visibilityOf(logged_in_logo));
		Assert.assertTrue(logged_in_logo.isDisplayed(),"incorrect username displayed");
		profileButton.click();
		Util.click(logoutLink);
		wait.until(ExpectedConditions.visibilityOf(username_Field));
		
		softassert.assertEquals(username_Field.getAttribute("value"), username);
		softassert.assertAll();
    	
 	}
    
	public void validLogin() throws IOException{
			
		wait.until(ExpectedConditions.visibilityOf(username_Field));
		
		wait.until(ExpectedConditions.visibilityOf(password_Field));
		
		wait.until(ExpectedConditions.visibilityOf(login_button));
		
		username_Field.clear();
		username_Field.sendKeys(TestBase.getUser_id());
		
		password_Field.clear();
		password_Field.sendKeys(password);
		login_button.click();
		try{
			wait.until(ExpectedConditions.visibilityOf(logged_in_logo));
			Assert.assertTrue(logged_in_logo.isDisplayed(),"logo not displayed or locator changed"); 
		}catch(Exception e){
			driver.switchTo().activeElement();
            Util.click(pendo_popup_close_button);			
    		wait.until(ExpectedConditions.visibilityOf(logged_in_logo));
    		Assert.assertTrue(logged_in_logo.isDisplayed(),"logo not displayed or locator changed");
		}
		
		
	}
	
	public void logOut(){
		wait.until(ExpectedConditions.visibilityOf(logged_in_logo));
		Assert.assertTrue(logged_in_logo.isDisplayed());
		profileButton.click();
		Util.click(logoutLink);
		wait.until(ExpectedConditions.visibilityOf(username_Field));

	}
	
	
	
}
