package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import dbUtil.CallUtil;
import pom.HomePage;
import pom.LoginPage;
import pom.ManageScorecardPage;
import pom.SelectAndScorePage;
import utilConstants.UtilityConstants;

public class SelectAndScoreTest extends TestBase{
 
	SelectAndScorePage selectAndScorePage; 
	ManageScorecardPage manageScorecardPage;
	HomePage homePage;
	String scorecardToUse = "SJS-1098643971";
	String scorecard_1_ToDelete;
	String scorecard_2_ToDelete;
	
	@BeforeClass //--logging in
	public void login() throws IOException, InterruptedException {
		//logging in
		LoginPage loginPage=new LoginPage(driver);
		loginPage.validLogin();

        selectAndScorePage = new SelectAndScorePage(driver);
		manageScorecardPage = new ManageScorecardPage(driver); 
		
		//navigating to manage score card page
		navigateToSelectScorecardPage();
        //closing LHNB
		collapseLHNB();
		
		//creating required scorecards
//		createScorecard();
	}
	
	//collapsing LHNB
	public void collapseLHNB() {
		homePage = new HomePage(driver);
        homePage.left_hand_navigation_bar_click();
	}
	
	//expanding LHNB
	public void expandLHNB() {
		homePage = new HomePage(driver);
        homePage.left_hand_navigation_bar_click();
	}
	
	
	//navigating to select and  score page 
	public void navigateToSelectScorecardPage() throws InterruptedException {
        HomePage hp=new HomePage(driver);
		try {
			hp.clickAction(Constants.HomePage.scoreacrd_page);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		hp.click_subLink(Constants.HomePage.select_and_score_page);
		try {
			hp.clickAction(Constants.HomePage.scoreacrd_page);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		selectAndScorePage.pageLoadWait();
	}
	
	//navigating to manage score card page 
	public void navigateToManageScorecardPage() throws InterruptedException {
        HomePage hp=new HomePage(driver);
        try {
			hp.clickAction(Constants.HomePage.scoreacrd_page);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		hp.click_subLink(Constants.HomePage.manage_scoreacrd_page);
		try {
			hp.clickAction(Constants.HomePage.scoreacrd_page);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	//create score card -- prerequisite
	public void createScorecard() throws InterruptedException {
		//navigating to manage score-card page
		expandLHNB();
		navigateToManageScorecardPage();
		collapseLHNB();
		Thread.sleep(5000);
		
		scorecardToUse = manageScorecardPage.createScorecardForUpdation(10);
		Thread.sleep(2000);
		scorecard_1_ToDelete = manageScorecardPage.createScorecardForUpdation(10);
		Thread.sleep(2000);
		scorecard_2_ToDelete = manageScorecardPage.createScorecardForUpdation(10);
		
		//navigating back to select and score page
		expandLHNB();
		navigateToSelectScorecardPage();
		Thread.sleep(5000);
		collapseLHNB();
	}
	
	
	@Test(priority=1) //--Verify if header label is displayed
	public void pageLabelVerification() throws InterruptedException {
		logger=extent.startTest("pageLabelVerification", "Verify if header label is displayed");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.pageLabel();
		Thread.sleep(500);
	}
	
	
	@Test(priority=2) //--Verify header note is displayed
	public void pageHeaderNoteVerification() throws InterruptedException {
		logger=extent.startTest("pageHeaderNoteVerification", "Verify header note is displayed");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.headerNote();
		Thread.sleep(500);
	}
	
	
	@Test(priority=3) //--Verify header note content 
	public void pageHeaderNoteContentVerification() throws InterruptedException {
		logger=extent.startTest("pageHeaderNoteContentVerification", "Verify header note content ");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.headerNoteContent();
		Thread.sleep(500);
	}
	
	
	@Test(priority=4) //--Verify UI of top pagination toolbox  
	public void topPaginationToolboxUIVerification() throws InterruptedException {
		logger=extent.startTest("topPaginationToolboxUIVerification", "Verify UI of top pagination toolbox ");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.paginationToolboxTop();
		Thread.sleep(500);
	}
	
	
	@Test(priority=5) //--Verify UI of bottom pagination toolbox  
	public void bottomPaginationToolboxUIVerification() throws InterruptedException {
		logger=extent.startTest("bottomPaginationToolboxUIVerification", "Verify UI of bottom pagination toolbox");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.paginationToolboxBottom();
		Thread.sleep(500);
	}
	
	
	@Test(priority=6) //--Verify if date range filter is present on right top side 
	public void dateRangeFilterLinkVerification() throws InterruptedException {
		logger=extent.startTest("dateRangeFilterLinkVerification", "Verify if date range filter is present on right top side");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.dateRangeFilter();
		Thread.sleep(500);
	}
	
	
	@Test(priority=7) //--  Verify if Notifications button is displayed and its clickable
	public void notificationsButtonVerification() throws InterruptedException {
		logger=extent.startTest("notificationsButtonVerification", "Verify if Notifications button is dispalyed and its clickable");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.notificationButton();
		Thread.sleep(500);
	}
	
	
	@Test(priority=8) //--  Verify if Export button is displayed and its clickable
	public void exportButtonVerification() throws InterruptedException {
		logger=extent.startTest("exportButtonVerification", "Verify if Export button is displayed and its clickable");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.exportButton();
		Thread.sleep(500);
	}
	
	
	@Test(priority=9) //--  Verify if Advance filter is displayed and its clickable
	public void advanceFilterButtonVerification() throws InterruptedException {
		logger=extent.startTest("advanceFilterButtonVerification", "Verify if Advance filter is displayed and its clickable");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.advanceFilterButton();
		Thread.sleep(500);
	}
	
	
	@Test(priority=10) //--  Verify Advanced filter UI
	public void advanceFilterUIVerification() throws InterruptedException {
		logger=extent.startTest("advanceFilterUIVerification", "Verify Advanced filter UI");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.advanceFilterUI();
		Thread.sleep(500);
	}
	
	
	@Test(priority=11) //--  Verify Filter by status (if all 4 status are displayed and checkbox is clickable)
	public void filterByStatusVerification() throws InterruptedException {
		logger=extent.startTest("filterByStatusVerification", "Verify Filter by status (if all 4 status are displayed and checkbox is clickable)");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.filterByStatus();
		Thread.sleep(500);
	}
	
	
	@Test(priority=12) //--  Verify table columns 
	public void gridColumnsVerification() throws InterruptedException {
		logger=extent.startTest("gridColumnsVerification", "Verify table columns ");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.tableColumns();
		Thread.sleep(500);
	}
	
	
	@Test(priority=13) //--  Verify UI of date range filter   
	public void dateRangeFilterUIVerification() throws InterruptedException {
		logger=extent.startTest("dateRangeFilterUIVerification", "Verify UI of date range filter ");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.dateRangeFilterUI();
		Thread.sleep(500);
	}
	
	
	@Test(priority=14) //--  Verify if by default 7 days filter is applied   
	public void defaultDateRangeFilterVerification() throws InterruptedException {
		logger=extent.startTest("defaultDateRangeFilterVerification", "Verify if by default 7 days filter is applied");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.defaultDateRangeFilter();
		Thread.sleep(500);
	}
	
	
	@Test(priority=15) //--  Verify UI of audio player.   
	public void audioPlayerUIVerification() throws InterruptedException {
		logger=extent.startTest("audioPlayerUIVerification", "Verify UI of audio player.");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.audioPlayerUI();
		Thread.sleep(500);
	}
	
	
	@Test(priority=16) //--  Verify UI of scoring section   
	public void scoringSectionUIVerification() throws InterruptedException {
		logger=extent.startTest("scoringSectionUIVerification", "Verify UI of scoring section");
		logger.assignCategory(Constants.select_and_score_category);
		
		//Assigning agent and scorecard to a call
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecardToUse, TestBase.getUser_id());
		Thread.sleep(1000);
		
		//scoring section UI verification
		selectAndScorePage.scoringSectionUI(callTitle, scorecardToUse);
		Thread.sleep(500);
	}
	
	
	@Test(priority=17) //--  Verify UI of comments section   
	public void commentsSectionUIVerification() throws InterruptedException {
		logger=extent.startTest("commentsSectionUIVerification", "Verify UI of comments section");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.infoSectionUIVerification(Constants.SelectAndScorePage.comment_call_button);	
		Thread.sleep(500);
	}
	
	
	@Test(priority=18) //--  Verify UI of tags section   
	public void tagsSectionUIVerification() throws InterruptedException {
		logger=extent.startTest("tagsSectionUIVerification", "Verify UI of tags section");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.infoSectionUIVerification(Constants.SelectAndScorePage.tag_call_button);	
		Thread.sleep(500);
	}
	
	@Test(priority=19) //--  Verify UI of info section   
	public void infoSectionUIVerification() throws InterruptedException {
		logger=extent.startTest("tagsSectionUIVerification", "Verify UI of info section");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.infoSectionUIVerification(Constants.SelectAndScorePage.info_call_button);	
		Thread.sleep(500);
	}
	
	
	@Test(priority=20) //--  Verify UI of I section   
	public void ISectionUIVerification() throws InterruptedException {
		logger=extent.startTest("ISectionUIVerification", "Verify UI of I section");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.actionSectionUIVerification(Constants.SelectAndScorePage.i_call_button);	
		Thread.sleep(500);
	}
	
	
	@Test(priority=21) //--  Verify UI of email section   
	public void emailSectionUIVerification() throws InterruptedException {
		logger=extent.startTest("ISectionUIVerification", "Verify UI of email section");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.actionSectionUIVerification(Constants.SelectAndScorePage.mail_call_button);	
		Thread.sleep(500);
	}
	
	
	@Test(priority=22) //--  Verify UI of Download section   
	public void downloadSectionUIVerification() throws InterruptedException {
		logger=extent.startTest("ISectionUIVerification", "Verify UI of Download section");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.actionSectionUIVerification(Constants.SelectAndScorePage.download_call_button);	
		Thread.sleep(500);
	}
	
	@Test(priority=23) //--  Verify UI of Score Notifications section   
	public void scoreNotificationsUIVerification() throws InterruptedException {
		logger=extent.startTest("scoreNotificationsUIVerification", "Verify UI of Score Notifications section");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.scoreNotificationsSectionUI();	
		Thread.sleep(500);
	}

	
	@Test(priority=24) //--  To check if Next and Last button is inability based on records  
	public void paginationButtonsInabilityVerification() throws InterruptedException {
		
		//count from DB
    	String dbCount = CallUtil.getCallRecordsCount(UtilityConstants.TimeConsatnts.date_range_for_last_7_days, TestBase.getOrg_unit_id());
		Boolean _100Records;
		
    	if(Integer.parseInt(dbCount)>100) {
    		_100Records = true;
    		logger=extent.startTest("paginationButtonsInabilityVerification", "To check if Next and Last button is enabled since records are more than 100");    		
    	}
    	else {
			logger=extent.startTest("paginationButtonsInabilityVerification", "To check if Next and Last button is disabled since records are less than 100");
			_100Records = false;	
    	}
    	
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.paginationButtonsInabilityCheck(_100Records);	
		Thread.sleep(500);
	}
	
	
	@Test(priority=25) //--  Verify Pagination count with DB   
	public void paginationCountVerification() throws InterruptedException {
		logger=extent.startTest("paginationCountVerification", "Verify Pagination count with DB");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.paginationToolBoxCount();
		Thread.sleep(500);
	}
	
	
	@Test(priority=26) //--  Verify grid count with DB   
	public void gridCountVerification() throws InterruptedException {
		logger=extent.startTest("gridCountVerification", "Verify grid count with DB");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.gridCount();
		Thread.sleep(500);
	}
	
	
	//Cleanup Activity
	public void cleanUp() throws InterruptedException {
		logger=extent.startTest("cleanUp", "Cleanup Activity");
		logger.assignCategory(Constants.select_and_score_category);
		
		//navigating to manage score-card page
		expandLHNB();
		navigateToManageScorecardPage();
		collapseLHNB();
		
		manageScorecardPage.cleanUpScorecards();
		Thread.sleep(2000);
	}

	
	@AfterClass //--logging out
	public void logOut() throws InterruptedException {
//		cleanUp();
		LoginPage lp=new LoginPage(driver);
		logger.log(LogStatus.INFO, "loggin out.. ");
		lp.logOut();
	}
	
	
}
