package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.GroupActivityReportsPage;
import pom.HomePage;
import pom.LoginPage;

public class GroupActivityReportTest extends TestBase {
	
	GroupActivityReportsPage ga;
	HomePage hp;
	
		
	@BeforeClass
	public void goToGroupActivityReportPage() throws InterruptedException, IOException{
	
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        logger.assignCategory("Login Suite");
        lp.validLogin();
        
        hp=new HomePage(driver);
        hp.left_hand_navigation_bar_click();
		hp.clickAction(Constants.HomePage.legacy_reports);
		
		hp.click_subLink(Constants.HomePage.group_activity_report);
	}

	//ui verification of groupActivity reports page
	@Test(priority=1)
	public void uiVerification() throws InterruptedException{
		logger=extent.startTest("uiVerification Test");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.UIVerification();
	}
	
	//Tile count verification of groupActivity reports page
	@Test(priority=2)
	public void tileCountVerification() throws InterruptedException{
		logger=extent.startTest("Tile Count Verification");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.tileCountVerification();
	}
	
	//Table count verification of groupActivity reports page
	@Test(priority=3)
	public void tableCountVerification() throws InterruptedException{
		logger=extent.startTest("Table Count Verification");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.tableCount();
	}
	
	//Pagination UI verification of groupActivity reports page
	@Test(priority=4)
	public void paginationToolboxUIVerification() throws InterruptedException{
		logger=extent.startTest("Pagination Toolbox UI Verification");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.paginationUI();
	}
	
	//Pagination count verification of groupActivity reports page
	@Test(priority=5)
	public void paginationCountVerification() throws InterruptedException{
		logger=extent.startTest("Pagination Count Verification");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.paginationCount();
	}
	
	@Test(priority=6)
	public void defaultColumnPickerOptions() throws InterruptedException{
		logger=extent.startTest("Default column picker options Test");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.allColumnPickerOptions();
	}
	
	@Test(priority=7)
	public void defaultColumnsDisplayed() throws InterruptedException{
		logger=extent.startTest("default columns Test");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.defaultColumns();
	}
	
	@Test(priority=8)
	public void allColumnPickerCheckboxesClickable() throws InterruptedException{
		logger=extent.startTest("Enability of all column picker checkboxes");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.allColumnPickerCheckboxes();
	}
	
	@Test(priority=9)
	public void advancedFilterUI() throws InterruptedException{
		logger=extent.startTest("Advanced Filter section UI");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.advancedFilter();
	}
	
	@Test(priority=10)
	public void basicFilterForGroupName() throws InterruptedException{
		logger=extent.startTest("Basic Filter for Group Name");
		logger.assignCategory(Constants.group_activity_report_category);
			
		ga=GroupActivityReportsPage.instance();
		ga.basicFilterFeature("Group");
	}
	

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		//logging out -tear down
		@AfterClass
		public void logOut() throws IOException{
			
			LoginPage lp=new LoginPage(driver);
			logger=extent.startTest("LogOut"); 
			logger.log(LogStatus.INFO, "loggin out.. ");
			lp.logOut();
			        		
		}
		
		
		
}
