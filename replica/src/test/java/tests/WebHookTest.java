package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.HomePage;
import pom.LoginPage;
import pom.WebHookPage;

public class WebHookTest extends TestBase {

	HomePage hp;
	WebHookPage wh;
	
	

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
	
	public void createWebhook(){
		wh=new WebHookPage(driver);
		logger=extent.startTest("Webhook creation");
		logger.log(LogStatus.INFO, "verifying if webhook is getting created");
		logger.assignCategory(Constants.webhook_category);
		wh.createWebHook(webhook, webhook_url);
	}

	
}
