package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
	
	@BeforeClass //--logging in
	public void login() throws IOException {
		//logging in
		LoginPage loginPage=new LoginPage(driver);
		loginPage.validLogin();
        //navigating to manage score card page
		navigateToSelectScorecardPage();
        //closing LHNB
		collapseLHNB();
        selectAndScorePage = new SelectAndScorePage(driver);
		manageScorecardPage = new ManageScorecardPage(driver); 
	}
	
	//collapsing LGNB
	public void collapseLHNB() {
		homePage = new HomePage(driver);
        homePage.left_hand_navigation_bar_click();
	}
	
	//expanding LGNB
	public void expandLHNB() {
		homePage = new HomePage(driver);
        homePage.left_hand_navigation_bar_click();
	}
	
	
	//navigating to select and  score page 
	public void navigateToSelectScorecardPage() {
        HomePage hp=new HomePage(driver);
		try {
			hp.clickAction(Constants.HomePage.scoreacrd_page);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		hp.click_subLink(Constants.HomePage.select_and_score_page);
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
	
	
	//create score card -- prerequisite
	public void createScorecard() {
		
	}
	
	
	//Cleanup Activity
	public void cleanUp() throws InterruptedException {
		logger=extent.startTest("cleanUp", "Cleanup Activity");
		logger.assignCategory(Constants.select_and_score_category);
		manageScorecardPage.cleanUpScorecards();
		Thread.sleep(2000);
	}

	
	@AfterClass //--logging out
	public void logOut() throws InterruptedException {
		cleanUp();
		LoginPage lp=new LoginPage(driver);
		logger.log(LogStatus.INFO, "loggin out.. ");
		lp.logOut();
	}
	
	
}
