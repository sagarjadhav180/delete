package tests;


import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.HomePage;
import pom.LoginPage;
import pom.ManageScorecardPage;

public class ManageScorecardTest extends TestBase{

	ManageScorecardPage manageScorecardPage; 
	
	@BeforeClass //logging in
	public void login() throws IOException {
		//logging in
		LoginPage loginPage=new LoginPage(driver);
		loginPage.validLogin();
        //navigating to manage score card page
        navigateToManageScorecardPage();
        //closing LHNB
		HomePage homePage = new HomePage(driver);
        homePage.left_hand_navigation_bar_click();
        manageScorecardPage = new ManageScorecardPage(driver);
	}	
	
	//navigating to manage score card page 
	public void navigateToManageScorecardPage() {
        HomePage hp=new HomePage(driver);
		try {
			hp.clickAction(Constants.HomePage.scoreacrd_page);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		hp.click_subLink(Constants.HomePage.manage_scoreacrd_page);
	}
	
	
	//To check if page label is present
	@Test(priority=1)
	public void pageLabelVerification() {
		logger=extent.startTest("pageLabelVerification", "To check if page label is present");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.headerLabel();
	}
	
	
	//To check if add score card button is present
	@Test(priority=2)
	public void addScorecardButtonVerification() {
		logger=extent.startTest("addScorecardButtonVerification", "To check if add score card button is present");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.addScorecardButton();
	}
	
	
	//To check if add export button is present
	@Test(priority=3)
	public void exportButtonVerification() {
		logger=extent.startTest("exportButtonVerification", "To check if add export button is present");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.exportButton();
	}
	
	
	//To check UI of top pagination tool-box
	@Test(priority=4)
	public void topPaginationToolboxUIVerification() {
		logger=extent.startTest("topPaginationToolboxUIVerification", "To check UI of top pagination tool-box");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.paginationToolboxTop();
	}
	
	
	//To check UI of bottom pagination tool-box
	@Test(priority=5)
	public void bottomPaginationToolboxUIVerification() {
		logger=extent.startTest("bottomPaginationToolboxUIVerification", "To check UI of bottom pagination tool-box");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.paginationToolboxBottom();
	}
	
	
	//To check if Next and Last button is inability based on records
	@Test(priority=6)
	public void paginationButtonsInabilityVerification() {
		
		Boolean _100Records = manageScorecardPage.scorecards100Records();
		
		if(_100Records == true) 
			logger=extent.startTest("paginationButtonsInabilityVerification", "To check if Next and Last button is enabled since records are more than 100");
		else 
			logger=extent.startTest("paginationButtonsInabilityVerification", "To check if Next and Last button is disabled since records are less than 100");
		
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.paginationButtonsInabilityCheck(_100Records);
	}
	
	
	//To check if available Score cards Strip is displayed 
	@Test(priority=7)
	public void availableScorecardsStripVerification() {
		logger=extent.startTest("availableScorecardsStripVerification", "To check if available Score cards Strip is displayed ");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.availableScoreCardStrip();
	}
	

	//To check table columns of score card table 
	@Test(priority=8)
	public void scorecardTableVerification() {
		logger=extent.startTest("scorecardTableVerification", "To check table columns of score card table");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.tableColumnNames();
	}
	
	
	//To Verify Pagination count with DB
	@Test(priority=9)
	public void paginationCountVerification() {
		logger=extent.startTest("paginationCountVerification", "To Verify Pagination count with DB");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.paginationToolBoxCount();
	}
	
	
	//To Verify grid count with DB
	@Test(priority=10)
	public void gridCountVerification() {
		logger=extent.startTest("gridCountVerification", "To Verify grid count with DB");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.gridCount();
	}

	
	//To check if configure score card pop up is opening on add score card button click
	@Test(priority=11)
	public void addScorecardButtonCheck() throws InterruptedException {
		logger=extent.startTest("addScorecardButtonCheck", "To check if configure score card pop up is opening on add score card button click");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.addScorecardButtonCheck();
		Thread.sleep(2000);
	}
	
	
	//To check if UI of configure score card section 
	@Test(priority=12)
	public void addScorecardUIVerification() throws InterruptedException {
		logger=extent.startTest("addScorecardUIVerification", "To check if UI of configure score card section ");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.createAndConfigureScoreacrdSectionUI();
		Thread.sleep(2000);
	}
	
	
	//To check if groups displayed in Available to list box are as per DAM
	@Test(priority=13)
	public void availableToGroupsDAMCheck() throws InterruptedException {
		logger=extent.startTest("availableToGroupsDAMCheck", "To check if groups displayed in Available to list box are as per DAM");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.availableToGroupsDAMCheck();
		Thread.sleep(2000);
	}
	
	
	//To check if able to create score card 
	@Test(priority=14)
	public void createScorecardVerification() throws InterruptedException {
		logger=extent.startTest("createScorecardVerification", "To check if able to create score card");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.createScorecard(Constants.ManageScorecardPage.basic_scorecard);
		Thread.sleep(2000);
	}
	
	
	//To check if able to update score card 
	@Test(priority=15)
	public void updateScorecardVerification() throws InterruptedException {
		logger=extent.startTest("updateScorecardVerification", "To check if able to update score card ");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.updateScorecard();
		Thread.sleep(2000);
	}
	
	
	//To check if able to archive score card 
	@Test(priority=16)
	public void deleteScorecardVerification() throws InterruptedException {
		logger=extent.startTest("deleteScorecardVerification", "To check if able to archive score card ");
		logger.assignCategory(Constants.manage_scorecard_category);
		String scorecard_name = manageScorecardPage.createScorecardForUpdation(1);
		Thread.sleep(2000);
		manageScorecardPage.deleteScorecard(scorecard_name);
		Thread.sleep(2000);
	}
	
	
	//To check if able to delete criteria 
	@Test(priority=17)
	public void deleteScorecardCriteriaVerification() throws InterruptedException {
		logger=extent.startTest("deleteScorecardCriteriaVerification", "To check if able to delete criteria");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.createScorecardValidations(Constants.ManageScorecardPage.scorecard_delete_criteria);
		Thread.sleep(2000);
	}
	
	
	//Verify if alert is displayed if mandatory fields are not entered while creating scoreacrd
	@Test(priority=18)
	public void createScorecardWithoutMandatoryFields() throws InterruptedException {
		logger=extent.startTest("createScorecardWithoutMandatoryFields", "Verify if alert is dispalyed if mandatory fields are not entered while creating scoreacrd");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.createScorecardValidations(Constants.ManageScorecardPage.scorecard_skip_mandatory_fields);
		Thread.sleep(2000);
	}
	
	
	//To check Available to feature for uncheck all
	@Test(priority=19)
	public void unCheckAllFeatureVerification() throws InterruptedException {
		logger=extent.startTest("unCheckAllFeatureVerification", "To check Available to feature for un check all");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.createScorecardValidations(Constants.ManageScorecardPage.scorecard_uncheck_all_groups);
		Thread.sleep(2000);
	}
	
	
	//To check Available to feature for check all
	@Test(priority=20)
	public void checkAllFeatureVerification() throws InterruptedException {
		logger=extent.startTest("checkAllFeatureVerification", "To check Available to feature for check all");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.createScorecardValidations(Constants.ManageScorecardPage.scorecard_check_all_groups);
		Thread.sleep(2000);
	}
	
	
	//Verify Cancel Feature 
	@Test(priority=21)
	public void cancelFeatureVerification() throws InterruptedException {
		logger=extent.startTest("cancelFeatureVerification", "Verify Cancel Feature ");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.createScorecardValidations(Constants.ManageScorecardPage.scorecard_cancel_feature);
		Thread.sleep(2000);
	}
	
	
	//Verify Available to Feature -- defect on staging 7(only unique groups are displayed in assigned to)
	@Test(priority=22)
	public void availableToFeatureVerification() throws InterruptedException {
		logger=extent.startTest("availableToFeatureVerification", "Verify Available to Feature ");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.availableToGroupsFeature();
		Thread.sleep(2000);
	}
	
	
	//Verify if user is able to add 60 criteria
	@Test(priority=23)
	public void scorecardWith60Criteria() throws InterruptedException {
		logger=extent.startTest("scorecardWith60Criteria", "Verify if user is able to add 60 criteria");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.createScorecard(Constants.ManageScorecardPage.__60_criteria_scorecard);
		Thread.sleep(2000);
	}
	
	
	//Verify if user is not able to add more than 60 criteria
	@Test(priority=24)
	public void scorecardWithMoreThan60Criteria() throws InterruptedException {
		logger=extent.startTest("scorecardWithMoreThan60Criteria", "Verify if user is not able to add more than 60 criteria");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.createScorecardValidations(Constants.ManageScorecardPage.__61_criteria_scorecard);
		Thread.sleep(2000);
	}
	
	
	//Verify if able to create scorecard without adding self group in available to list
	@Test(priority=25)
	public void scorecardCreationWithoutSelfGroup() throws InterruptedException {
		logger=extent.startTest("scorecardCreationWithoutSelfGroup", "Verify if able to create scorecard without adding self group in available to list");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.createScorecard(Constants.ManageScorecardPage.scorecard_without_self_group);
		Thread.sleep(2000);
	}
	
	
	//Cleanup Activity
	public void cleanUp() throws InterruptedException {
		logger=extent.startTest("cleanUp", "Cleanup Activity");
		logger.assignCategory(Constants.manage_scorecard_category);
		manageScorecardPage.cleanUpScorecards();
		Thread.sleep(2000);
	}
	
	
	@AfterClass //logging out
	public void logOut() throws InterruptedException {
		cleanUp();
		LoginPage lp=new LoginPage(driver);
		logger.log(LogStatus.INFO, "loggin out.. ");
		lp.logOut();
	}
}
