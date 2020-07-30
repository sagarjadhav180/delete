package tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.CampaignAndTrackingNumberPage;
import pom.CampaignBuilderPage;
import pom.GroupsAndUserPage;
import pom.HomePage;
import pom.LoginPage;

public class GroupsAndUserTest extends TestBase
{
	
	    //Logging In
		@BeforeClass
		public void goToGroupsAndUserPage() throws IOException, InterruptedException{
			
			LoginPage lp=new LoginPage(driver);
	        lp.validLogin();

	        HomePage hp=new HomePage(driver);
	        
			try {
				hp.clickAction(Constants.HomePage.group_User_page);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
		
		
		//Check if Group and User label is displayed
		@Test(priority=1)
		public void groupsAndUserPageLabel() throws InterruptedException{
			
	        logger=extent.startTest("Groups And User Page Label verification..");
			logger.assignCategory(Constants.groups_and_user_category);
			
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.groupsAndUserHeaderLabel();
		}
		
		//Check if export groups and user button is present and is clickable
		@Test(priority=2)
		public void exportgroupAndUserButton() throws InterruptedException{
			
	        logger=extent.startTest("export groups and user button verification..");
			logger.assignCategory(Constants.groups_and_user_category);
			
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.exportGroupsAndUserButton();
		}
		
		//Check if Group details strip is present
		@Test(priority=3)
		public void groupDetailsStripVerification() throws InterruptedException{
			
	        logger=extent.startTest("Group Details Strip verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.Strip(Constants.GroupsAndUser.user_settings_strip);
		}
		
		// check if the Group Details Strip is Collapsible & expandable
		@Test(priority=4)
		public void groupDetailsStripCollapsible_Expandable() throws InterruptedException{
			
	        logger=extent.startTest("Group Details Strip Collapsible & expandable verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.expandSection(Constants.GroupsAndUser.group_details_strip);
	        gp.collpaseSection(Constants.GroupsAndUser.group_details_strip);
		}


		//UI verification of Group Details section
		@Test(priority=5)
		public void groupDetailsUIverification() throws InterruptedException{
			
	        logger=extent.startTest("Group Details section UI verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.groupDetailsUI();
		}	
		
		//Check if appropriate alert is displayed if group name is empty
		//Check if appropriate alert is displayed if phone number is not 10 digit
		@Test(priority=6)
		public void groupDetails_alert_messages() throws InterruptedException{
			
	        logger=extent.startTest("Group Details alert messages for Group Name & Phone Number verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.groupDetailsFormValidation("group_name_textbox");
	        gp.groupDetailsFormValidation("phone_number_textbox");
		}
		
		//Check if updated group details are displayed
		@Test(priority=7)
		public void groupDetails_updated_details() throws InterruptedException{
			
	        logger=extent.startTest("Updated Group Details display verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.groupDetailsUpdate();
	        
		}
		
		//Check if feature settings strip is displayed
		@Test(priority=8)
		public void feature_setting_strip() throws InterruptedException{
			
	        logger=extent.startTest("Group Details Strip Collapsible & expandable verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.Strip(Constants.GroupsAndUser.feature_settings_strip);
	        
		}
		
		//Check UI of Users section
		@Test(priority=10)
		public void userSectionUIVerification() throws InterruptedException{
			
	        logger=extent.startTest("User Section UI Verification verification..");
			logger.assignCategory(Constants.groups_and_user_category);
			
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.users_UI_Validation();
		}
		
		
		
		//Logging Out
		@AfterClass
		public void goToHomePage(){
	        
			HomePage hp=new HomePage(driver);
	        Util.getJavascriptExecutor().executeScript("window.scrollBy(0,-2000)");	
	        try {
				hp.clickAction("Home");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        LoginPage lp=new LoginPage(driver);
	    
	        logger.log(LogStatus.INFO, "loggin out.. ");
	        lp.logOut();
	        
		}
		
	

}
