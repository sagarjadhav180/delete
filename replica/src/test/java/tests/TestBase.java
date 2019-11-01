package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import extentReport.Listener;
import extentReport.SendEmail;
import extentReport.ExtentReportsGenerator;
import pom.LoginPage;

@Listeners(extentReport.Listener.class)
public class TestBase
{


	public static String Base_Url = "https://stag-7-cmo-1.convirza.com";
	public static ExtentTest logger;
	public  ExtentReports extent = ExtentReportsGenerator.getInstance(true);
	public static WebDriver driver;
	public  WebDriverWait wait;
	static int totalFailedTestCases;
	static int totalPassedTestCases;
	static int totalSkipedTestCases;

	List<ITestNGMethod> passedtests = new ArrayList<ITestNGMethod>();
	List<ITestNGMethod> failedtests = new ArrayList<ITestNGMethod>();
	List<ITestNGMethod> skippedtests = new ArrayList<ITestNGMethod>();
	public static String methodName;

	@Parameters({"browser","url"})
	@BeforeTest()
	public void setUp(String browser,String url) throws IOException{
		

		if(browser.contains("chrome")){
			
			System.setProperty("webdriver.chrome.driver",".//chromedriver.exe");
		    driver=new ChromeDriver();
		}
		else if(browser.contains("firefox")){
			System.setProperty("webdriver.gecko.driver", ".//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		//to clear casche
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//to delete cookies
	    driver.manage().deleteAllCookies();
		driver.get(url);
		wait= new WebDriverWait(driver, 40);		
		LoginPage lp=new LoginPage(driver,wait);
//		logger=extent.startTest("Login with valid credentials");
//		logger.assignCategory("Login Suite");
//		logger.log(LogStatus.INFO, "valid login test case running..");
		lp.validLogin();
		
	}

	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {

		if (result.getStatus() == ITestResult.FAILURE) {

			try {
				System.out.println("In fail");
				Thread.sleep(1200);
				failedtests.add(result.getMethod());
				logger.log(LogStatus.FAIL, "" + result.getThrowable().getMessage() + "");
				logger.log(LogStatus.FAIL, "Failed.");
				methodName = result.getName();
				String image_path = Util.createScreenshot(driver, methodName);
				String img = Util.image_upload(image_path);
				System.out.println("Failure Method" + methodName);
				logger.log(LogStatus.INFO, "Snapshot below: " + logger.addScreenCapture(img));
				driver.navigate().refresh();
				Thread.sleep(10000);
				driver.findElement(By.xpath("//div/nav/div/ul/li/a/span")).click();
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println("In Catch");
				e.printStackTrace();
			}

		}

		else if (result.getStatus() == ITestResult.SUCCESS) {
			System.out.println("In Pass");
			logger.log(LogStatus.PASS, "Success.");
			passedtests.add(result.getMethod());
		}

		else {
			System.out.println("In skip");
			logger.log(LogStatus.SKIP, "Test case skipped.");
			skippedtests.add(result.getMethod());

		}
		extent.endTest(logger);
		extent.flush();

	}
	
	@AfterTest
	public void tearDown(){
		
		driver.close();
	}
	

	@AfterSuite()
	public void close_connection() throws Exception {

		int[] result = extentReport.Listener.count_of_test();
		totalPassedTestCases = result[0];
		totalFailedTestCases = result[1];
		totalSkipedTestCases = result[2];
		SendEmail.execute("Extent.html", totalFailedTestCases, totalPassedTestCases, totalSkipedTestCases);
		driver.quit();
	}

}

