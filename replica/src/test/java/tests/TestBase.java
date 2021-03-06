package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IClass;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.*;

import extentReport.*;
import io.EnvironmentHelper;
import pom.CampaignAndTrackingNumberPage;
import pom.CampaignBuilderPage;
import pom.HomePage;
import testdata.TestData;

@SuppressWarnings("unused")
@Listeners(extentReport.Listener.class)
public class TestBase
{
	//Environment Variables
	public static final String billing_id="70045";
	public static final String account="QA automation";
	public static final String campaignToBeEdited="00000SJC-1";
	public static final String tracking_number="SJ TN-1";
	public static final String geo_location="do_not_delete_location(automation)";
	public static final String webhook="automation_webhook_do_not_delete";	
	public static final String webhook_url="https://eneq4s0znwehc.x.pipedream.net/";	
	public static final String account_timezone="America/New_York";
	
	
	public static String org_unit_id=""; 
    public static String campaign_id = "";
	public static String campaign_ou_id="";
	public static String first_last_name="Autmation Account";
	public static String first_name="Autmation";	
	public static String last_name="Account";
	public static String user_id="";
	public static String password="";
	public static String env="stag-5";
	public static String Base_Url = "https://"+env+"-cmo-1.convirza.com";
	public static ExtentTest logger;
	public static ExtentReports extent = ExtentReportsGenerator.getInstance(true);
	public static WebDriver driver;
	public static  WebDriverWait wait;
	static int totalFailedTestCases;
	static int totalPassedTestCases;
	static int totalSkipedTestCases;
	String url_to_hit;
	
	
	@BeforeSuite
	public void testSetUp() throws Exception{       		
		EnvironmentHelper environmentHelper = new EnvironmentHelper();
		environmentHelper.updateAppConfig();
		environmentHelper.updateDBConfig();
		environmentHelper.updateTestBaseProperties();
	}
	
	@Parameters({"browser","url"})
	@BeforeTest
	public void setUp(String browser,String url) throws Exception{
		
		String sf = null;
		String sc = null ;
		if(browser.contains("chrome")){

			System.setProperty("webdriver.chrome.driver",".//chromedriver");
		    driver=new ChromeDriver();

		    
		    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
			SessionId session = ((ChromeDriver)driver).getSessionId();
			 sc = session.toString();
			System.out.println("Session id of ChromeDriver: " + session.toString());
		    
		}
		else if(browser.contains("firefox")){
			System.setProperty("webdriver.gecko.driver", ".//geckodriver.exe");
			driver=new FirefoxDriver();
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		    
		}
		 else if (browser.equals("headless")) {
			
			 String chromeDriverPath = ".//chromedriver_linux" ;
			 System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			 ChromeOptions options = new ChromeOptions();
			 options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
			 driver = new ChromeDriver(options);
			 
			}

		wait= new WebDriverWait(driver,120);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//to delete cookies
	    driver.manage().deleteAllCookies();
//		String URL="https://convirza.awsapps.com/auth/?client_id=06919f4fd8ed324e&redirect_uri=https%3A%2F%2Fconvirza.awsapps.com%2Fconnect%2Fauth%2Fcode";
	    
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream(".//property");
		prop.load(file);
		url_to_hit=prop.getProperty("url");			
		driver.get(url_to_hit);
//		driver.get(URL);
	    TestData.createData();			    
		extent.loadConfig(new File(".//src//main//java//extentReport//extent_config.xml"));
	}

	public static String getUser_id() {
		return user_id;
	}

	public static void setUser_id(String user_id) {
		TestBase.user_id = user_id;
	}

	public static String getPassword() {
		return password;
	}

	public static void setPassword(String password) {
		TestBase.password = password;
	}

	public static String getFirst_last_name() {
		return first_last_name;
	}

	public static void setFirst_last_name(String first_last_name) {
		TestBase.first_last_name = first_last_name;
	}

	public static String getFirst_name() {
		return first_name;
	}

	public static void setFirst_name(String first_name) {
		TestBase.first_name = first_name;
	}

	public static String getLast_name() {
		return last_name;
	}

	public static void setLast_name(String last_name) {
		TestBase.last_name = last_name;
	}

	
	public static String getEnv() {
		return env;
	}

	public static void setEnv(String env) {
		TestBase.env = env;
	}
	
	public static String getOrg_unit_id() {
		return org_unit_id;
	}

	public static void setOrg_unit_id(String org_unit_id) {
		TestBase.org_unit_id = org_unit_id;
	}

	public static String getCampaign_id() {
		return campaign_id;
	}

	public static void setCampaign_id(String campaign_id) {
		TestBase.campaign_id = campaign_id;
	}

	public static String getCampaign_ou_id() {
		return campaign_ou_id;
	}

	public static void setCampaign_ou_id(String campaign_ou_id) {
		TestBase.campaign_ou_id = campaign_ou_id;
	}

	
	@AfterTest
	public void tearDown() throws Exception{
		if(driver!=null){
		driver.quit();
		}
	}
	

	@AfterSuite
	public void close_connection() throws Exception {

		int[] result = extentReport.Listener.count_of_test();
		totalPassedTestCases = result[0];
		totalFailedTestCases = result[1];
		totalSkipedTestCases = result[2];
		SendEmail.execute("Extent.html", totalFailedTestCases, totalPassedTestCases, totalSkipedTestCases);
	}

}

