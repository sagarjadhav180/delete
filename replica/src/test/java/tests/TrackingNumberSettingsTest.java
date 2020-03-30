package tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.CallDetailsReport_Page;
import pom.HomePage;
import pom.LoginPage;
import pom.TrackingNumberSettingsReport_Page;

public class TrackingNumberSettingsTest extends TestBase{
	
	HomePage hp;
	TrackingNumberSettingsReport_Page tn;
	private static final String category="Tracking Number Settings Test";
	
	@BeforeClass
	public void goToTrackingNumberSettingsPage() throws IOException, InterruptedException{
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        logger.assignCategory("Login Suite");
        lp.validLogin();
        
        hp=new HomePage(driver);
        hp.left_hand_navigation_bar_click();
		hp.clickAction("Legacy Reports");
		
		hp.click_subLink("Tracking Number Settings");
	}
	
	//ui verification of call details page
	@Test(priority=1)
	public void uiVerification() throws InterruptedException{
		logger=extent.startTest("uiVerification Test");
		logger.assignCategory(category);
			
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.uiVerification();
	}
	
	@Test(priority=2)
	public void paginationUIVerification(){
		
		logger=extent.startTest("Pagination toolbox UI verification");
		logger.assignCategory(category);
		
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.paginationButtons();
	}
	
	@Test(priority=3)
	public void paginationCount(){
		
		logger=extent.startTest("Pagination Count verification");
		logger.assignCategory(category);
		
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.paginationTrackingNumbersCount();
	}
	
	@Test(priority=4)
	public void tableCount(){
		
		logger=extent.startTest("Table count verification");
		logger.assignCategory(category);
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.tableTrackingNumbersCount();
		
	}
	
	@Test(priority=5)
	public void defaultColumnPickerOptions(){
		logger=extent.startTest("Default column picker options Test");
		logger.assignCategory(category);
			
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.allColumnPickerOptions();
	}
	
	@Test(priority=6)
	public void defaultColumnsDisplayed(){
		logger=extent.startTest("Default columns Test");
		logger.assignCategory(category);
			
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.defaultColumns();
		
	}
	
	@Test(priority=7)
	public void allColumnPickerCheckboxesClickable(){
	
		logger=extent.startTest("Enability of all column picker checkboxes");
		logger.assignCategory(category);
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.allColumnPickerCheckboxes();
	
	}

	@Test(priority=8)
	public void columnPickerFeature(){
		logger=extent.startTest("Column Picker feature");
		logger.assignCategory(category);
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.checkAllColumnPickerOptions();
		tn.allColumns();
	}
	
	@Test(priority=9)
	public void advancedFilterUI(){
		
		logger=extent.startTest("Advanced Filter section UI");
		logger.assignCategory(category);
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.advancedFilter();
	}
	
}
