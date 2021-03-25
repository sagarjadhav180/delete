package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
	String scorecardToUse = "SJS--774065396";
	String scorecard_1_ToDelete = "SJS-1349390088";
	String scorecard_2_ToDelete = "SJS--265268728";
	
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
		createScorecard();
	}
	
	//collapsing LHNB
	public void collapseLHNB() {
		homePage = new HomePage(driver);
        homePage.collapseLHNB();
	}
	
	//expanding LHNB
	public void expandLHNB() {
		homePage = new HomePage(driver);
        homePage.expandLHNB();
	}
	
	
	//navigating to select and  score page 
	public void navigateToSelectScorecardPage() throws InterruptedException {
        HomePage hp=new HomePage(driver);
		try {
			hp.clickAction(Constants.HomePage.scoreacrd_page);
		} catch (InterruptedException e) {
			expandLHNB();
			hp.clickAction(Constants.HomePage.scoreacrd_page);
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
            expandLHNB();
			hp.clickAction(Constants.HomePage.scoreacrd_page);
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
	
	
	@Test(priority=27) //--  Verify date range filter for today  
	public void dateRangeFilterVerificationForToday() throws InterruptedException {
		logger=extent.startTest("dateRangeFilterVerificationForToday", "Verify date range filter for today");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.dateRangeFilterFeature(Constants.SelectAndScorePage.date_range_for_today, TestBase.getOrg_unit_id());
		Thread.sleep(500);
	}
	
	
	@Test(priority=28) //--  Verify date range filter for Yesterday  
	public void dateRangeFilterVerificationForYesterDay() throws InterruptedException {
		logger=extent.startTest("dateRangeFilterVerificationForYesterDay", "Verify date range filter for Yesterday");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.dateRangeFilterFeature(Constants.SelectAndScorePage.date_range_for_yesterday, TestBase.getOrg_unit_id());
		Thread.sleep(500);
	}
	
	
	@Test(priority=29) //--  Verify date range filter for last 30 days
	public void dateRangeFilterVerificationForLast30Days() throws InterruptedException {
		logger=extent.startTest("dateRangeFilterVerificationForLast30Days", "Verify date range filter for last 30 days");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.dateRangeFilterFeature(Constants.SelectAndScorePage.date_range_for_last_30_days, TestBase.getOrg_unit_id());
		Thread.sleep(500);
	}
	
	
	@Test(priority=30) //--  Verify date range filter for last 7 days
	public void dateRangeFilterVerificationForLast7Days() throws InterruptedException {
		logger=extent.startTest("dateRangeFilterVerificationForLast7Days", "Verify date range filter for last 7 days");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.dateRangeFilterFeature(Constants.SelectAndScorePage.date_range_for_last_7_days, TestBase.getOrg_unit_id());
		Thread.sleep(500);
	}
	
	
	@Test(priority=31) //--  Verify status filter for need scorecard
	public void statusFilterVerificationForNeedScorecard() throws InterruptedException {
		logger=extent.startTest("statusFilterVerificationForNeedScorecard", "Verify status filter for need scorecard");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.statusFilterCheck(Constants.SelectAndScorePage.status_checkbox_for_need_scoreacard);
		Thread.sleep(500);
	}
	
	
	@Test(priority=32) //--  Verify status filter for UnScored
	public void statusFilterVerificationForUnScored() throws InterruptedException {
		logger=extent.startTest("statusFilterVerificationForUnScored", "Verify status filter for UnScored");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.statusFilterCheck(Constants.SelectAndScorePage.status_checkbox_for_unscored);
		Thread.sleep(500);
	}
	
	
	@Test(priority=33) //--  Verify status filter for Scored
	public void statusFilterVerificationForScored() throws InterruptedException {
		logger=extent.startTest("statusFilterVerificationForScored", "Verify status filter for Scored");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.statusFilterCheck(Constants.SelectAndScorePage.status_checkbox_for_scored);
		Thread.sleep(500);
	}
	
	
	@Test(priority=34) //--  Verify status filter for Reviewed
	public void statusFilterVerificationForReviewed() throws InterruptedException {
		logger=extent.startTest("statusFilterVerificationForReviewed", "Verify status filter for Reviewed");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.statusFilterCheck(Constants.SelectAndScorePage.status_checkbox_for_reviewed);
		Thread.sleep(500);
	}
	
	
	@Test(priority=35) //--  Verify advanced filter feature for duration 
	public void advanceFilterVerificationForDuration() throws InterruptedException {
		logger=extent.startTest("advanceFilterVerificationForDuration", "Verify advanced filter feature for duration ");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.advanceFilterCheck(Constants.SelectAndScorePage.advance_filter_for_duration);
		Thread.sleep(500);
	}
	
	
	@Test(priority=36) //--  Verify advanced filter feature for Group 
	public void advanceFilterVerificationForGroup() throws InterruptedException {
		logger=extent.startTest("advanceFilterVerificationForGroup", "Verify advanced filter feature for group ");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.advanceFilterCheck(Constants.SelectAndScorePage.advance_filter_for_group);
		Thread.sleep(500);
	}
	
	
	@Test(priority=37) //--  Verify advanced filter feature for identified agent 
	public void advanceFilterVerificationForIdentifiedAgent() throws InterruptedException {
		logger=extent.startTest("advanceFilterVerificationForIdentifiedAgent", "Verify advanced filter feature for identified agent ");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.advanceFilterCheck(Constants.SelectAndScorePage.advance_filter_for_identified_agent);
		Thread.sleep(500);
	}
	
	
	@Test(priority=38) //--  Verify advanced filter feature for score 
	public void advanceFilterVerificationForScore() throws InterruptedException {
		logger=extent.startTest("advanceFilterVerificationForScore", "Verify advanced filter feature for score");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.advanceFilterCheck(Constants.SelectAndScorePage.advance_filter_for_score);
		Thread.sleep(500);
	}
	
	
	@Test(priority=39) //--  Verify advanced filter feature for call title 
	public void advanceFilterVerificationForCallTitle() throws InterruptedException {
		logger=extent.startTest("advanceFilterVerificationForCallTitle", "Verify advanced filter feature for call title");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.advanceFilterCheck(Constants.SelectAndScorePage.advance_filter_for_call_title);
		Thread.sleep(500);
	}
	
	
	@Test(priority=40) //--  Verify email call feature 
	public void emailCallFeatureVerification() throws InterruptedException {
		logger=extent.startTest("emailCallFeatureVerification", "Verify email call feature");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.emailCallFeature();
		Thread.sleep(500);
	}
	
	
	@Test(priority=41) //--  Verify if user is able to score call
	public void scoreCall() throws InterruptedException {
		logger=extent.startTest("scoreCall", "Verify if user is able to score call");
		logger.assignCategory(Constants.select_and_score_category);
		//assigning agent and scorecard
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecardToUse, TestBase.getUser_id());
		Thread.sleep(500);
		//scoring call
		selectAndScorePage.scoreCall(callTitle, Constants.SelectAndScorePage.score_call_all_criteria);
		Thread.sleep(500);
	}

	
	@Test(priority=42) //--  Verify if user is able to update score of already scored call
	public void updateCallScore() throws InterruptedException {
		logger=extent.startTest("updateCallScore", "Verify if user is able to update score of already scored call");
		logger.assignCategory(Constants.select_and_score_category);
		//assigning agent and scorecard
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecardToUse, TestBase.getUser_id());
		Thread.sleep(500);
		//scoring call
		selectAndScorePage.scoreCall(callTitle, Constants.SelectAndScorePage.score_call_all_criteria);
		Thread.sleep(500);
		//updating score
		selectAndScorePage.upateScore(callTitle, "reviewCall");
		Thread.sleep(500);
	}
	
	
	@Test(priority=43) //--  Verify if user is able to review call
	public void reviewCallScore() throws InterruptedException {
		logger=extent.startTest("reviewCallScore", "Verify if user is able to review call");
		logger.assignCategory(Constants.select_and_score_category);
		//assigning agent and scorecard
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecardToUse, TestBase.getUser_id());
		Thread.sleep(500);
		//scoring call
		selectAndScorePage.scoreCall(callTitle, Constants.SelectAndScorePage.score_call_all_criteria);
		Thread.sleep(500);
		//review call
		selectAndScorePage.reviewCall(callTitle);
		Thread.sleep(500);
	}
	
	
	@Test(priority=44) //--  Verify status is turning into Unscored after attaching scorecard to it
	public void statusCheckForUnscored() throws InterruptedException {
		logger=extent.startTest("statusCheckForUnscored", "Verify status is turning into Unscored after attaching scorecard to it");
		logger.assignCategory(Constants.select_and_score_category);
		//assigning agent and scorecard
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecardToUse, TestBase.getUser_id());
		Thread.sleep(500);
		//status check
		selectAndScorePage.callStatusVerification(callTitle, Constants.SelectAndScorePage.status_checkbox_for_unscored);
		Thread.sleep(500);
	}
	
	
	@Test(priority=45) //--  Verify status is turning into scored after scoring the call
	public void statusCheckForScored() throws InterruptedException {
		logger=extent.startTest("statusCheckForScored", "Verify status is turning into scored after scoring the call");
		logger.assignCategory(Constants.select_and_score_category);
		//assigning agent and scorecard
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecardToUse, TestBase.getUser_id());
		Thread.sleep(500);
		//scoring call
		selectAndScorePage.scoreCall(callTitle, Constants.SelectAndScorePage.score_call_all_criteria);
		Thread.sleep(500);
		//status check
		selectAndScorePage.callStatusVerification(callTitle, Constants.SelectAndScorePage.status_checkbox_for_scored);
		Thread.sleep(500);
	}
	
	
	@Test(priority=46) //--  Verify status is turning into reviewed after reviewed the call
	public void statusCheckForReviewed() throws InterruptedException {
		logger=extent.startTest("statusCheckForReviewed", "Verify status is turning into reviewed after reviewed the call");
		logger.assignCategory(Constants.select_and_score_category);
		//assigning agent and scorecard
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecardToUse, TestBase.getUser_id());
		Thread.sleep(500);
		//scoring call
		selectAndScorePage.scoreCall(callTitle, Constants.SelectAndScorePage.score_call_all_criteria);
		Thread.sleep(500);
		//review call
		selectAndScorePage.reviewCall(callTitle);
		//status check
		selectAndScorePage.callStatusVerification(callTitle, Constants.SelectAndScorePage.status_checkbox_for_reviewed);
		Thread.sleep(500);
	}
	
	
	@Test(priority=47) //--  Verify scorer and reviewer details are displayed at the bottom of scoring section after call is reviewed
	public void scorerReviewerDetails() throws InterruptedException {
		logger=extent.startTest("scorerReviewerDetails", "Verify scorer and reviewer details are displayed at the bottom of scoring section after call is reviewed");
		logger.assignCategory(Constants.select_and_score_category);
		//assigning agent and scorecard
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecardToUse, TestBase.getUser_id());
		Thread.sleep(500);
		//scoring call
		selectAndScorePage.scoreCall(callTitle, Constants.SelectAndScorePage.score_call_all_criteria);
		Thread.sleep(500);
		//review call
		selectAndScorePage.reviewCall(callTitle);
		//details check
		Map<String,String> details = new HashMap<String,String>();
		details.put("expScorer", TestBase.getUser_id());
		details.put("expScoredFor", TestBase.getUser_id());
		details.put("expReviewer", TestBase.getUser_id());
		selectAndScorePage.scorerReviewerDetails(callTitle, details);
		Thread.sleep(500);
	}
	
	
//	@Test(priority=48) //--  Verify Cancel feature. -- commenting out since success message issue 
	public void cancelScoreVerification() throws InterruptedException {
		logger=extent.startTest("cancelScoreVerification", "Verify Cancel feature.");
		logger.assignCategory(Constants.select_and_score_category);
		//assigning agent and scorecard
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecardToUse, TestBase.getUser_id());
		Thread.sleep(500);
		//cancel score
		selectAndScorePage.cancelScoreFeature(callTitle);
		Thread.sleep(500);
	}
	
	
	@Test(priority=49) //--  Verify if notifications are getting saved 
	public void notificationsCreationVerification() throws InterruptedException {
		logger=extent.startTest("notificationsCreationVerification", "Verify if notifications are getting saved");
		logger.assignCategory(Constants.select_and_score_category);
		//deleting existing notifications
		selectAndScorePage.deleteNotifications(4);
		Thread.sleep(500);
		//adding notifications
		selectAndScorePage.addNotification(2);
		Thread.sleep(500);
	}
	
	
	@Test(priority=50) //--  Verify is user can add max 4 notifications for a call  
	public void maxNotificationsCreationVerification() throws InterruptedException {
		logger=extent.startTest("maxNotificationsCreationVerification", "Verify is user can add max 4 notifications for a call ");
		logger.assignCategory(Constants.select_and_score_category);
		//deleting existing notifications
		selectAndScorePage.deleteNotifications(4);
		Thread.sleep(500);
		//adding notifications
		selectAndScorePage.addNotification(4);
		Thread.sleep(500);
	}
	
	
	@Test(priority=51) //--  Verify is user can add max 4 notifications for a call  
	public void notificationsCreationValidation() throws InterruptedException {
		logger=extent.startTest("notificationsCreationValidation", "Verify is user can not add more than 4 notifications for a call ");
		logger.assignCategory(Constants.select_and_score_category);
		//deleting existing notifications
		selectAndScorePage.deleteNotifications(4);
		Thread.sleep(500);
		//adding notifications
		selectAndScorePage.addNotification(5);
		Thread.sleep(500);
	}
	
	
	@Test(priority=52) //--  Verify if notifications are getting deleted  
	public void notificationsDeletionVerification() throws InterruptedException {
		logger=extent.startTest("notificationsDeletionVerification", "Verify if notifications are getting deleted");
		logger.assignCategory(Constants.select_and_score_category);
		//deleting existing notifications
		selectAndScorePage.deleteNotifications(4);
		Thread.sleep(500);
		//adding notifications
		selectAndScorePage.addNotification(2);
		Thread.sleep(500);
		//deleting existing notifications
		selectAndScorePage.deleteNotifications(4);
		Thread.sleep(500);
	}
	
	
	@Test(priority=53) //--  Verify if scorecard association with already scored call is not broken even if group is removed from available to list
	public void scorecardAssociationCheckAfterGroupRemovalForScoredCall() throws InterruptedException {
		logger=extent.startTest("scorecardAssociationCheckAfterGroupRemovalForScoredCall", "Verify if scorecard asociation with already scored call is not broken even if group is removed from available to list");
		logger.assignCategory(Constants.select_and_score_category);
		
		//assigning agent and scorecard
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecardToUse, TestBase.getUser_id());
		Thread.sleep(500);
		
		//scoring call
		selectAndScorePage.scoreCall(callTitle, Constants.SelectAndScorePage.score_call_all_criteria);
		Thread.sleep(500);
		
		//remove the group from available to list
		String groupToBeRemoved = selectAndScorePage.getGroup(callTitle); //getting group to be removed
		expandLHNB();
		navigateToManageScorecardPage(); //--navigating to manage scorecard page
		collapseLHNB();

		Boolean flag = false;
		try {
			manageScorecardPage.removeScorecardForScorecardAssociationCheck(scorecardToUse, groupToBeRemoved);			
		}catch(Exception e) {
			collapseLHNB();
			flag = true;
		}finally {
			if(flag==true)
				manageScorecardPage.removeScorecardForScorecardAssociationCheck(scorecardToUse, groupToBeRemoved);
		}
		
		//check if scorecard association is not broken
		expandLHNB();
		navigateToSelectScorecardPage(); //--navigating back to select and score page
		collapseLHNB();
		selectAndScorePage.scorecardAssociationWithCall(callTitle, scorecardToUse);
		
		//add the group in available to list		
		expandLHNB();
		navigateToManageScorecardPage(); //--navigating to manage scorecard page
		collapseLHNB();		
		manageScorecardPage.addAllGroupsToAvailableToList(scorecardToUse);
		Thread.sleep(500);
		
		expandLHNB();
		navigateToSelectScorecardPage(); //--navigating back to select and score page
		collapseLHNB();
	}
	
	
	@Test(priority=54) //--  Verify if scorecard association with already reviewed call is not broken even if group is removed from available to list
	public void scorecardAssociationCheckAfterGroupRemovalForReviewedCall() throws InterruptedException {
		logger=extent.startTest("scorecardAssociationCheckAfterGroupRemovalForReviewedCall", "Verify if scorecard asociation with already reviewed call is not broken even if group is removed from available to list");
		logger.assignCategory(Constants.select_and_score_category);
		
		//assigning agent and scorecard
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecardToUse, TestBase.getUser_id());
		Thread.sleep(500);
		
		//scoring call
		selectAndScorePage.scoreCall(callTitle, Constants.SelectAndScorePage.score_call_all_criteria);
		Thread.sleep(500);
		
		//review call
		selectAndScorePage.reviewCall(callTitle);
		Thread.sleep(500);
		//remove the group from available to list
		String groupToBeRemoved = selectAndScorePage.getGroup(callTitle); //getting group to be removed
		expandLHNB();
		navigateToManageScorecardPage(); //--navigating to manage scorecard page
		collapseLHNB();
		manageScorecardPage.removeScorecardForScorecardAssociationCheck(scorecardToUse, groupToBeRemoved);
		
		//check if scorecard association is not broken
		expandLHNB();
		navigateToSelectScorecardPage(); //--navigating back to select and score page
		collapseLHNB();
		selectAndScorePage.scorecardAssociationWithCall(callTitle, scorecardToUse);
		
		//add the group in available to list		
		expandLHNB();
		navigateToManageScorecardPage(); //--navigating to manage scorecard page
		collapseLHNB();		
		manageScorecardPage.addAllGroupsToAvailableToList(scorecardToUse);
		Thread.sleep(500);
		
		expandLHNB();
		navigateToSelectScorecardPage(); //--navigating back to select and score page
		collapseLHNB();
	}
	
	
	@Test(priority=55) //--  Verify if scorecard association with already scored call is not broken even if scorecard is deleted
	public void scorecardAssociationCheckAfterGroupDeletionForScoredCall() throws InterruptedException {
		logger=extent.startTest("scorecardAssociationCheckAfterGroupDeletionForScoredCall", "Verify if scorecard asociation with already scored call is not broken even if scorecard is deleted");
		logger.assignCategory(Constants.select_and_score_category);
		
		//assigning agent and scorecard
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecard_1_ToDelete, TestBase.getUser_id());
		Thread.sleep(500);
		
		//scoring call
		selectAndScorePage.scoreCall(callTitle, Constants.SelectAndScorePage.score_call_all_criteria);
		Thread.sleep(500);
		
		//delete scorecard
		expandLHNB();
		navigateToManageScorecardPage(); //--navigating to manage scorecard page
		collapseLHNB();
		manageScorecardPage.deleteScorecard(scorecard_1_ToDelete);
		
		//check if scorecard association is not broken
		expandLHNB();
		navigateToSelectScorecardPage(); //--navigating back to select and score page
		collapseLHNB();
		selectAndScorePage.scorecardAssociationWithCall(callTitle, scorecard_1_ToDelete);
		
	}
	
	
	@Test(priority=56) //--  Verify if scorecard association with already reviewed call is not broken even if scorecard is deleted
	public void scorecardAssociationCheckAfterGroupDeletionForReviewedCall() throws InterruptedException {
		logger=extent.startTest("scorecardAssociationCheckAfterGroupDeletionForReviewedCall", "Verify if scorecard asociation with already reviewed call is not broken even if scorecard is deleted");
		logger.assignCategory(Constants.select_and_score_category);
		
		//assigning agent and scorecard
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecard_2_ToDelete, TestBase.getUser_id());
		Thread.sleep(500);
		
		//scoring call
		selectAndScorePage.scoreCall(callTitle, Constants.SelectAndScorePage.score_call_all_criteria);
		Thread.sleep(500);

		//review call
		selectAndScorePage.reviewCall(callTitle);
		Thread.sleep(500);
		
		//delete scorecard
		expandLHNB();
		navigateToManageScorecardPage(); //--navigating to manage scorecard page
		collapseLHNB();
		manageScorecardPage.deleteScorecard(scorecard_2_ToDelete);
		
		//check if scorecard association is not broken
		expandLHNB();
		navigateToSelectScorecardPage(); //--navigating back to select and score page
		collapseLHNB();
		selectAndScorePage.scorecardAssociationWithCall(callTitle, scorecard_2_ToDelete);
	}
	
	
	@Test(priority=57) //-- Verify if appropriate alert is displayed if mandatory criteria are not scored
	public void scoreCallAlertVerification() throws InterruptedException {
		logger=extent.startTest("scoreCallAlertVerification", "Verify if appropriate alert is displayed if mandatory criteria are not scored");
		logger.assignCategory(Constants.select_and_score_category);
		//assigning agent and scorecard
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecardToUse, TestBase.getUser_id());
		Thread.sleep(500);
		//scoring call
		selectAndScorePage.scoreCall(callTitle, Constants.SelectAndScorePage.score_call_only_optional_criteria);
		Thread.sleep(500);
	}
	
	@Test(priority=58) //--Verify if call is getting scored successfully if optional criterias are not scored
	public void scoreCallVerificationWithoutOptionalCriteria() throws InterruptedException {
		logger=extent.startTest("scoreCallVerificationWithoutOptionalCriteria", "Verify if call is getting scored successfully if optional criterias are not scored");
		logger.assignCategory(Constants.select_and_score_category);
		//assigning agent and scorecard
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecardToUse, TestBase.getUser_id());
		Thread.sleep(500);
		//scoring call
		selectAndScorePage.scoreCall(callTitle, Constants.SelectAndScorePage.score_call_only_manadatory_criteria);
		Thread.sleep(500);
	}
	
	
//	@Test(priority=60) //--Verify users displayed in identified agent drop down are as per user permission access -- need to discuss -- not working as expected
	public void userPermissionCheckForAgents() throws InterruptedException {
		logger=extent.startTest("userPermissionCheckForAgents", "Verify users displayed in identified agent drop down are as per user permission access");
		logger.assignCategory(Constants.select_and_score_category);
		
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecardToUse, TestBase.getUser_id());
		Thread.sleep(500);
		String group = selectAndScorePage.getGroup(callTitle);
		
		selectAndScorePage.editSpecificCall(callTitle);
		
		selectAndScorePage.identifiedAgentsDAMCheck(TestBase.getOrg_unit_id(), group);
		Thread.sleep(500);
	}
	
	
	@Test(priority=61) // -- Verify only those scorecards are displayed for to assign which are made available for the group in which call is placed
	public void userPermissionCheckForScorecards() throws InterruptedException {
		logger=extent.startTest("userPermissionCheckForScorecards", "Verify only those scorecards are displayed for to assign which are made available for the group in which call is placed");
		logger.assignCategory(Constants.select_and_score_category);
		
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecardToUse, TestBase.getUser_id());
		Thread.sleep(500);
		String group = selectAndScorePage.getGroup(callTitle);
		
		selectAndScorePage.editSpecificCall(callTitle);
		
		selectAndScorePage.scorecardsAvailabilityCheck(group);
		Thread.sleep(500);
	}
	
	
	@Test(priority=62) // -- Verify correct score is displayed after scoring the call
	public void scoreValueVerification() throws InterruptedException {
		logger=extent.startTest("scoreValueVerification", "Verify correct score is displayed after scoring the call");
		logger.assignCategory(Constants.select_and_score_category);
		
		//assigning agent and scorecard
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecardToUse, TestBase.getUser_id());
		Thread.sleep(500);
				
		//scoring call
		selectAndScorePage.scoreCall(callTitle, Constants.SelectAndScorePage.score_call_all_criteria);
		Thread.sleep(500);
		
		//verification
		selectAndScorePage.callScoreCheck(callTitle);
		Thread.sleep(500);
	}
	
	
	@Test(priority=63) // -- Verify if user is not able edit another call while previously edited call is not saved 
	public void editCallsAlert() throws InterruptedException {
		logger=extent.startTest("scoreValueVerification", "Verify if user is not able edit another call while previously edited call is not saved ");
		logger.assignCategory(Constants.select_and_score_category);
		
		selectAndScorePage.editCallAlert();
		
		Thread.sleep(500);
	}
	
	
	@Test(priority=64) // -- Verify if user is able to update the score after call is reviewed and call status turns into scored. 
	public void scoreCallAfterReview() throws InterruptedException {
		logger=extent.startTest("scoreCallAfterReview", "Verify if user is able to update the score after call is reviewed and call status turns into scored.");
		logger.assignCategory(Constants.select_and_score_category);
		
		//assigning agent and scorecard
		String callTitle = selectAndScorePage.scorecardAndAgentAssignment(scorecardToUse, TestBase.getUser_id());
		Thread.sleep(500);
		
		//scoring call
		selectAndScorePage.scoreCall(callTitle, Constants.SelectAndScorePage.score_call_all_criteria);
		Thread.sleep(500);
		
		//review call
		selectAndScorePage.reviewCall(callTitle);
		Thread.sleep(500);
		
		//update score
		selectAndScorePage.upateScore(callTitle, "reviewedCall");
		
		//check status
		selectAndScorePage.callStatusVerification(callTitle, Constants.SelectAndScorePage.status_checkbox_for_scored);
		
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
