package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;

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
        logger.assignCategory(Constants.login_page_category);
        lp.validLogin();
        
        hp=new HomePage(driver);
    	hp.clickAction(Constants.HomePage.legacy_reports);
		
		hp.click_subLink(Constants.HomePage.call_details_report);
	}
	
	//ui verification of call details page
	@Test(priority=1)
	public void uiVerification() throws InterruptedException{
		logger=extent.startTest("uiVerification Test");
		logger.assignCategory(Constants.call_details_report_category);
		
		cdr=CallDetailsReport_Page.instance();
	    cdr.UIVerification();
	}
	
	//To verify pagination toolbox call count
	@Test(priority=2)
	public void paginationUI(){
	    logger=extent.startTest("pagination toolbox UI Test");
		logger.assignCategory(Constants.call_details_report_category);
			
		cdr=CallDetailsReport_Page.instance();
		cdr.paginationButtons();
	}
	
	//To verify pagination toolbox call count
	@Test(priority=3)
	public void paginationCount(){
		logger=extent.startTest("pagination toolbox call count Test");
		logger.assignCategory(Constants.call_details_report_category);
		
		cdr=CallDetailsReport_Page.instance();
		cdr.paginationCallCount();
	}
	  
	//To verify table call count
	@Test(priority=4)
	public void tableCount(){
		logger=extent.startTest("table call count Test");
		logger.assignCategory(Constants.call_details_report_category);
			
		cdr=CallDetailsReport_Page.instance();
		cdr.tableCallCount();
	} 

	//To verify by default displayed column picker options
	@Test(priority=5)
	public void defaultColumnPickerOptions(){
		logger=extent.startTest("default column picker options Test");
		logger.assignCategory(Constants.call_details_report_category);
			
		cdr=CallDetailsReport_Page.instance();
		cdr.allColumnPickerOptions();
	}
	
	@Test(priority=6)
	public void defaultColumnsDisplayed(){
		logger=extent.startTest("default columns Test");
		logger.assignCategory(Constants.call_details_report_category);
			
		cdr=CallDetailsReport_Page.instance();
		cdr.defaultColumns();
		
	}
	
	@Test(priority=7)
	public void allColumnPickerCheckboxesClickable(){
		logger=extent.startTest("Enability of all column picker checkboxes");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.allColumnPickerCheckboxes();
	}
	
	@Test(priority=8)
	public void columnPickerFeature(){
		logger=extent.startTest("Column Picker feature");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.checkAllColumnPickerOptions();
		cdr.allColumns();
	}
	
	@Test(priority=9)
	public void advancedFilterUI(){
		
		logger=extent.startTest("Advanced Filter section UI");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.advancedFilter();
	}
	
	@Test(priority=10)
	public void basicFilterForAdSource(){
		
		logger=extent.startTest("Basic Filter for Ad Source");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.basicFilterFeature(Constants.LegacyReports.ad_source);
		
	}
	
	@Test(priority=11)
	public void basicFilterForCaller_ID(){
		
		logger=extent.startTest("Basic Filter for caller ID");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.basicFilterFeature(Constants.LegacyReports.caller_id);
		
	}
	
	@Test(priority=12)
	public void basicFilterForTrackingNumber(){
		
		logger=extent.startTest("Basic Filter for Tracking Number");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.basicFilterFeature(Constants.LegacyReports.tracking_number);
		
	}
	
	@Test(priority=13)
	public void basicFilterForDuration(){
		
		logger=extent.startTest("Basic Filter for Duration");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.basicFilterFeature(Constants.LegacyReports.duration);
		
	}
	
	@Test(priority=14)
	public void basicFilterForGroupName(){
		
		logger=extent.startTest("Basic Filter for Group Name");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.basicFilterFeature(Constants.LegacyReports.group_name);
		
	}
	
	@Test(priority=15)
	public void basicFilterForDisposition(){
		
		logger=extent.startTest("Basic Filter for Disposition");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.basicFilterFeature(Constants.LegacyReports.disposition);
		
	}
	
    @Test(priority=16)
	public void advancedFilterForCallerID(){
		
		logger=extent.startTest("Advanced Filter for Caller ID");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.advancedFilterFeature(Constants.LegacyReports.caller_id);
		
	}
    
    @Test(priority=17)
	public void advancedFilterForDuration(){
		
		logger=extent.startTest("Advanced Filter for Duration");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.advancedFilterFeature(Constants.LegacyReports.duration);
		
	}
	
    @Test(priority=18)
	public void advancedFilterForGroupName(){
		
		logger=extent.startTest("Advanced Filter for Group Name");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.advancedFilterFeature(Constants.LegacyReports.group_name);
		
	}
	
    @Test(priority=19)
	public void advancedFilterForLineType(){
		
		logger=extent.startTest("Advanced Filter for Line Type");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.advancedFilterFeature(Constants.LegacyReports.line_type);
		
	}
    
    @Test(priority=20)
	public void dateRangeFilterForToday(){
		
		logger=extent.startTest("Date Range filter for today");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.dateRangeFilter(Constants.LegacyReports.today);
		
	}
    
    @Test(priority=21)
	public void dateRangeFilterForYesterday(){
		
		logger=extent.startTest("Date Range filter for yesterday");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.dateRangeFilter(Constants.LegacyReports.yesterday);
		
	}
    
    @Test(priority=22)
	public void dateRangeFilterForLast7days(){
		
		logger=extent.startTest("Date Range filter for Last 7 days");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.dateRangeFilter(Constants.LegacyReports.last_7_days);
		
	}
    
    @Test(priority=23)
	public void dateRangeFilterForLast30days(){
		
		logger=extent.startTest("Date Range filter for Last 30 days");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.dateRangeFilter(Constants.LegacyReports.last_30_days);
		
	}
    
    @Test(priority=24)    
    public void audioPlayerOpen(){
    	logger=extent.startTest("aaudio player opening");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.actionButtonClick(Constants.LegacyReports.play_button);
		cdr.actionSectionVerification("play_button", "");
    }
    
    @Test(priority=25)
    public void informationTagOpen(){
    	logger=extent.startTest("information tag opening");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.actionButtonClick(Constants.LegacyReports.inforamtion_icon_button);
		cdr.actionSectionVerification("inforamtion_icon_button", "complete info section");
    }
    
    @Test(priority=26)
    public void infoSectionUIVerification(){
    	logger=extent.startTest("info section ");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
    	cdr.actionSectionVerification("inforamtion_icon_button", "info section");
    }
    
    @Test(priority=27)
    public void commentSectionUIVerification(){
    	logger=extent.startTest("comments section ");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
    	cdr.actionSectionVerification("inforamtion_icon_button", "comments");
    }
    
    @Test(priority=28)
    public void tagSectionUIVerification(){
    	logger=extent.startTest("tags section ");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
    	cdr.actionSectionVerification("inforamtion_icon_button", "tags");
    }
    
    @Test(priority=29)
    public void emailCallSectionUIVerification(){
    	logger=extent.startTest("email call section ");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.actionButtonClick(Constants.LegacyReports.email_call);
		cdr.actionSectionVerification("email_call", "mail call UI");
    }
    
    @Test(priority=30)
    public void emailCallFeature(){
    	logger=extent.startTest("email call feature ");
		logger.assignCategory(Constants.call_details_report_category);
		cdr=CallDetailsReport_Page.instance();
		cdr.actionButtonClick(Constants.LegacyReports.email_call);
		cdr.actionSectionVerification("email_call", "mail feature");
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
