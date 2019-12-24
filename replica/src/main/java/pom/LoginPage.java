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

import com.relevantcodes.extentreports.LogStatus;

import tests.TestBase;
import tests.Util;

public class LoginPage extends TestBase {
	
	@FindBy(xpath="//*[@id='email']")
	private static WebElement username_Field;

	@FindBy(xpath="//input[@placeholder='Password']")
	private static WebElement password_Field;	
	
	@FindBy(xpath="//*[@id='b1']")
	private static WebElement login_button;		

	@FindBy(xpath="//input[@name='remember']")
	private static WebElement rememberMe_Checkbox;	
	
	@FindBy(xpath="//a[@class='pull-left']")
	private static WebElement forgotPassword_link;	
	
	@FindBy(xpath="//span[@class='hidden-xs ng-binding' and contains(text(),'Ganesh 5')]")
	private static WebElement userprofile_link;
	
	@FindBy(xpath="//button[@id='pendo-close-guide-7438aaa2']")
	private static WebElement pendo_popup_close_button;
	
	
	
    public static WebDriverWait wait;
	
	public LoginPage (WebDriver driver,WebDriverWait wait1){
		
		PageFactory.initElements(driver, this);
        this.wait=wait1;	
	}
	
	public void validLogin() throws IOException{
		
		logger=extent.startTest("Login with valid credentials");
		logger.assignCategory("Login Suite");
		logger.log(LogStatus.INFO, "valid login test case running..");
		
		Properties prop=new Properties();
		
		FileInputStream file=new FileInputStream(".//property");
		prop.load(file);
		String username=prop.getProperty("username");
		String password=prop.getProperty("password");
		
      try{
		wait.until(ExpectedConditions.visibilityOf(username_Field));
		Util.elementHighlight(username_Field);
		Util.removeElementHighlight(username_Field);
      }
      catch(Exception e){
			e.printStackTrace();
			System.out.println("username field not present or locator has been changed..");
		}
		try{
		wait.until(ExpectedConditions.visibilityOf(password_Field));
		Util.elementHighlight(password_Field);
		Util.removeElementHighlight(password_Field);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("password field not present or locator has been changed..");
		}
		
		  try{
				wait.until(ExpectedConditions.visibilityOf(login_button));
				Util.elementHighlight(login_button);
				Util.removeElementHighlight(login_button);
		      }
		      catch(Exception e){
					e.printStackTrace();
					System.out.println("login_button not present or locator has been changed..");
				}
		username_Field.clear();
		username_Field.sendKeys(username);
		password_Field.clear();
		password_Field.sendKeys(password);
		login_button.click();
		try{
		driver.switchTo().activeElement();
		pendo_popup_close_button.click();
		}catch(Exception e){}
		try{
			wait.until(ExpectedConditions.visibilityOf(userprofile_link));
		Assert.assertTrue(userprofile_link.isDisplayed(),"incorrect username displayed");
		}
		catch(Exception e){
			System.out.println("userprofile_link not displayed..");
		}
	}
	
	public void logOut(){
		
	}
	
	
	
}
