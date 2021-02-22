package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.HomePage;
import pom.LoginPage;
import pom.ManageScorecardPage;
import pom.SelectAndScorePage;

public class SelectAndScoreTest extends TestBase{
 
	SelectAndScorePage selectAndScorePage; 
	ManageScorecardPage manageScorecardPage;
	HomePage homePage;
	String scorecardToUse;
	String scorecard_1_ToDelete;
	String scorecard_2_ToDelete;
	
	@BeforeClass //--logging in
	public void login() throws IOException, InterruptedException {
		//logging in
		LoginPage loginPage=new LoginPage(driver);
		loginPage.validLogin();
        //navigating to manage score card page
		navigateToSelectScorecardPage();
        //closing LHNB
		collapseLHNB();
        selectAndScorePage = new SelectAndScorePage(driver);
		manageScorecardPage = new ManageScorecardPage(driver); 
		
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
	public void pageLabelVerification() {
		logger=extent.startTest("pageLabelVerification", "Verify if header label is displayed");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.pageLabel();
	}
	
	
	@Test(priority=2) //--Verify header note is displayed
	public void pageHeaderNoteVerification() {
		logger=extent.startTest("pageHeaderNoteVerification", "Verify header note is displayed");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.headerNote();
	}
	
	
	@Test(priority=3) //--Verify header note content 
	public void pageHeaderNoteContentVerification() {
		logger=extent.startTest("pageHeaderNoteContentVerification", "Verify header note content ");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.headerNoteContent();
	}
	
	
	@Test(priority=4) //--Verify UI of top pagination toolbox  
	public void topPaginationToolboxUIVerification() {
		logger=extent.startTest("topPaginationToolboxUIVerification", "Verify UI of top pagination toolbox ");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.paginationToolboxTop();
	}
	
	
	@Test(priority=5) //--Verify UI of bottom pagination toolbox  
	public void bottomPaginationToolboxUIVerification() {
		logger=extent.startTest("bottomPaginationToolboxUIVerification", "Verify UI of bottom pagination toolbox");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.paginationToolboxBottom();
	}
	
	
	@Test(priority=6) //--Verify UI of date range filter on right top side  
	public void dateRangeFilterUIVerification() {
		logger=extent.startTest("dateRangeFilterUIVerification", "Verify UI of date range filter on right top side");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.dateRangeFilterUI();
	}
	
	
	@Test(priority=7) //--  Verify if Notifications button is displayed and its clickable
	public void notificationsButtonVerification() {
		logger=extent.startTest("notificationsButtonVerification", "Verify if Notifications button is dispalyed and its clickable");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.notificationButton();
	}
	
	
	@Test(priority=8) //--  Verify if Export button is displayed and its clickable
	public void exportButtonVerification() {
		logger=extent.startTest("exportButtonVerification", "Verify if Export button is displayed and its clickable");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.exportButton();
	}
	
	
	@Test(priority=9) //--  Verify if Advance filter is displayed and its clickable
	public void advanceFilterButtonVerification() {
		logger=extent.startTest("advanceFilterButtonVerification", "Verify if Advance filter is displayed and its clickable");
		logger.assignCategory(Constants.select_and_score_category);
		selectAndScorePage.advanceFilterButton();
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
