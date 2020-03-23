package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.CallDetailsReport_Page;
import pom.HomePage;
import pom.LoginPage;

public class CallDetailReportTest extends TestBase{

	CallDetailsReport_Page cdr;
	HomePage hp;
	
	
	@BeforeClass
	public void goToCallDetailsReportPage() throws InterruptedException, IOException{
	
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        logger.assignCategory("Login Suite");
        lp.validLogin();
        
        hp=new HomePage(driver);
        hp.left_hand_navigation_bar_click();
		hp.clickAction("Legacy Reports");
		
		hp.click_subLink("Call Details");
	}
	
	//ui verification of call details page
	@Test(priority=1)
	public void uiVerification() throws InterruptedException{
		logger=extent.startTest("uiVerification Test");
		logger.assignCategory("Call Details Test");
		
		cdr=CallDetailsReport_Page.instance();
	    cdr.UIVerification();
	}
	
	//To verify pagination toolbox call count
	@Test(priority=2)
	public void paginationUI(){
	    logger=extent.startTest("pagination toolbox UI Test");
		logger.assignCategory("Call Details Test");
			
		cdr=CallDetailsReport_Page.instance();
		cdr.paginationButtons();
	}
	
	//To verify pagination toolbox call count
	@Test(priority=3)
	public void paginationCount(){
		logger=extent.startTest("pagination toolbox call count Test");
		logger.assignCategory("Call Details Test");
		
		cdr=CallDetailsReport_Page.instance();
		cdr.paginationCallCount();
	}
	  
	//To verify table call count
	@Test(priority=4)
	public void tableCount(){
		logger=extent.startTest("table call count Test");
		logger.assignCategory("Call Details Test");
			
		cdr=CallDetailsReport_Page.instance();
		cdr.tableCallCount();
	} 

	//To verify by default displayed column picker options
	@Test(priority=5)
	public void defaultColumnPickerOptions(){
		logger=extent.startTest("default column picker options Test");
		logger.assignCategory("Call Details Test");
			
		cdr=CallDetailsReport_Page.instance();
		cdr.allColumnPickerOptions();
	}
	
	@Test(priority=6)
	public void defaultColumnsDisplayed(){
		logger=extent.startTest("default columns Test");
		logger.assignCategory("Call Details Test");
			
		cdr=CallDetailsReport_Page.instance();
		cdr.defaultColumns();
		
	}
	
	@Test(priority=7)
	public void allColumnPickerCheckboxesClickable(){
		logger=extent.startTest("Enability of all column picker checkboxes");
		logger.assignCategory("Call Details Test");
		cdr=CallDetailsReport_Page.instance();
		cdr.allColumnPickerCheckboxes();
	}
	
	@Test(priority=8)
	public void columnPickerFeature(){
		logger=extent.startTest("Column Picker feature");
		logger.assignCategory("Call Details Test");
		cdr=CallDetailsReport_Page.instance();
		cdr.checkAllColumnPickerOptions();
		cdr.allColumns();
	}
	
	@Test(priority=9)
	public void advancedFilterUI(){
		
		logger=extent.startTest("Advanced Filter section UI");
		logger.assignCategory("Call Details Test");
		cdr=CallDetailsReport_Page.instance();
		cdr.advancedFilter();
	}
	
	@Test(priority=10)
	public void basicFilterForCampaign(){
		
		logger=extent.startTest("Basic Filter for campaign");
		logger.assignCategory("Call Details Test");
		cdr=CallDetailsReport_Page.instance();
		cdr.basicFilterFeature("Campaign");
		
	}
	
	@Test(priority=11)
	public void basicFilterForCaller_ID(){
		
		logger=extent.startTest("Basic Filter for caller ID");
		logger.assignCategory("Call Details Test");
		cdr=CallDetailsReport_Page.instance();
		cdr.basicFilterFeature("Caller ID");
		
	}
	
	@Test(priority=12)
	public void basicFilterForTrackingNumber(){
		
		logger=extent.startTest("Basic Filter for Tracking Number");
		logger.assignCategory("Call Details Test");
		cdr=CallDetailsReport_Page.instance();
		cdr.basicFilterFeature("Tracking Number");
		
	}
	
	@Test(priority=13)
	public void basicFilterForDuration(){
		
		logger=extent.startTest("Basic Filter for Duration");
		logger.assignCategory("Call Details Test");
		cdr=CallDetailsReport_Page.instance();
		cdr.basicFilterFeature("Duration");
		
	}
	
	@Test(priority=14)
	public void basicFilterForGroupName(){
		
		logger=extent.startTest("Basic Filter for Group Name");
		logger.assignCategory("Call Details Test");
		cdr=CallDetailsReport_Page.instance();
		cdr.basicFilterFeature("Group Name");
		
	}
	
	@Test(priority=15)
	public void basicFilterForDisposition(){
		
		logger=extent.startTest("Basic Filter for Disposition");
		logger.assignCategory("Call Details Test");
		cdr=CallDetailsReport_Page.instance();
		cdr.basicFilterFeature("Disposition");
		
	}
	
    @Test(priority=16)
	public void advancedFilterForCallerID(){
		
		logger=extent.startTest("Advanced Filter for Caller ID");
		logger.assignCategory("Call Details Test");
		cdr=CallDetailsReport_Page.instance();
		cdr.advancedFilterFeature("Caller ID");
		
	}
    
    @Test(priority=17)
	public void advancedFilterForDuration(){
		
		logger=extent.startTest("Advanced Filter for Duration");
		logger.assignCategory("Call Details Test");
		cdr=CallDetailsReport_Page.instance();
		cdr.advancedFilterFeature("Duration");
		
	}
	
    @Test(priority=18)
	public void advancedFilterForGroupName(){
		
		logger=extent.startTest("Advanced Filter for Group Name");
		logger.assignCategory("Call Details Test");
		cdr=CallDetailsReport_Page.instance();
		cdr.advancedFilterFeature("Group Name");
		
	}
	
    @Test(priority=19)
	public void advancedFilterForCampaign(){
		
		logger=extent.startTest("Advanced Filter for Campaign");
		logger.assignCategory("Call Details Test");
		cdr=CallDetailsReport_Page.instance();
		cdr.advancedFilterFeature("Campaign Name");
		
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
