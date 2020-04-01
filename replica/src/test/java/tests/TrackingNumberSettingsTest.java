package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
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
	
	@Test(priority=11,groups="basic_filters")
	public void basicFilterFeatureForType(){
		
		logger=extent.startTest("Basic filter feature for Status");
		logger.assignCategory(category);
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.basicFilterFeature("Status");
		 
	}
	
	@Test(priority=10,groups="basic_filters")
	public void basicFilterFeatureForTrackingNumber(){
		
		logger=extent.startTest("Basic filter feature for Tracking Number");
		logger.assignCategory(category);
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.basicFilterFeature("Tracking Number");
		 
	}
	
	@Test(priority=12,groups="basic_filters")
	public void basicFilterFeatureForGroupName(){
		
		logger=extent.startTest("Basic filter feature for Group Name");
		logger.assignCategory(category);
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.basicFilterFeature("Group Name");
		 
	}
	
	@Test(priority=13,groups="basic_filters")
	public void basicFilterFeatureForAdSource(){
		
		logger=extent.startTest("Basic filter feature for Ad source");
		logger.assignCategory(category);
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.basicFilterFeature("Ad Source");
		 
	}
	
	@Test(priority=14,groups="basic_filters")
	public void basicFilterFeatureForCampaignName(){
		
		logger=extent.startTest("Basic filter feature for Campaign Name");
		logger.assignCategory(category);
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.basicFilterFeature("Campaign name");
		 
	}
	
	@Test(priority=15)
	public void advancedFilterForTrackingNumber(){
		
		logger=extent.startTest("Advanced Filter for Tracking Number");
		logger.assignCategory(category);
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.advancedFilterFeature("Tracking Number");
	}
	
	@Test(priority=16)
	public void advancedFilterForGroupName(){
		
		logger=extent.startTest("Advanced Filter for Group Name");
		logger.assignCategory(category);
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.advancedFilterFeature("Group name");
	}
	
	@Test(priority=16)
	public void advancedFilterForCampaignName(){
		
		logger=extent.startTest("Advanced Filter for Campaig Name");
		logger.assignCategory(category);
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.advancedFilterFeature("Campaign Name");
	}
	
	@Test(priority=17)
	public void advancedFilterForTrackingNumberName(){
		
		logger=extent.startTest("Advanced Filter for Tracking Number Name");
		logger.assignCategory(category);
		tn=TrackingNumberSettingsReport_Page.instance();
		tn.advancedFilterFeature("Tracking Number Name");
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
