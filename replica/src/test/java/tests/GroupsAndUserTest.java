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
		@Test(priority=6)
		public void groupDetails_GroupName_alert_messages() throws InterruptedException{
			
	        logger=extent.startTest("Group Details alert messages for Group Name & Phone Number verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.groupDetailsFormValidation("group_name_textbox");
		}
		
		//Check if appropriate alert is displayed if phone number is not 10 digit
		@Test(priority=7)
		public void groupDetails_PhoneNumber_alert_messages() throws InterruptedException{
			
	        logger=extent.startTest("Group Details alert messages for Group Name & Phone Number verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.groupDetailsFormValidation("phone_number_textbox");
		}
		
		//Check if updated group details are displayed
		@Test(priority=8)
		public void groupDetails_updated_details() throws InterruptedException{
			
	        logger=extent.startTest("Updated Group Details display verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.groupDetailsUpdate();
	        
		}
		
		//Check if feature settings strip is displayed
		@Test(priority=9)
		public void feature_setting_strip() throws InterruptedException{
			
	        logger=extent.startTest("Fetaure Setting Strip display verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.Strip(Constants.GroupsAndUser.feature_settings_strip);
	        
		}
		
		// check if the feature settings Strip is Collapsible & expandable
		@Test(priority=10)
		public void feature_Setting_Strip_Collapsible_Expandable() throws InterruptedException{
			
	        logger=extent.startTest("Feature Settings Strip Collapsible & expandable verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.expandSection(Constants.GroupsAndUser.feature_settings_strip);
	        gp.collpaseSection(Constants.GroupsAndUser.feature_settings_strip);
		}
		
		//UI verification of feature settings section
		@Test(priority=11)
		public void feature_settings_UI_verification() throws InterruptedException{
			
	        logger=extent.startTest("feature settings section UI verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.featureSettingsUI();
		}
		
		//Check if TN settings strip is displayed
		@Test(priority=12)
		public void tn_setting_strip() throws InterruptedException{
			
	        logger=extent.startTest("TN Setting Strip display verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.Strip(Constants.GroupsAndUser.tn_settings_strip);
	        
		}
		
		// check if the TN settings Strip is Collapsible & expandable
		@Test(priority=13)
		public void tn_Setting_Strip_Collapsible_Expandable() throws InterruptedException{
			
	        logger=extent.startTest("TN Settings Strip Collapsible & expandable verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.expandSection(Constants.GroupsAndUser.tn_settings_strip);
	        gp.collpaseSection(Constants.GroupsAndUser.tn_settings_strip);
		}
		
		//UI verification of TN settings section
		//Verify options displayed in referring website listbox
		//Verify options displayed in DNI type
		//Check if DNI Custom Parameters pop up is displayed when clicked in custom parameters
		//Check UI of DNI Custom Parameters pop up
		//Check options displayed in instant insights type listbox
		@Test(priority=14)
		public void tn_settings_UI_verification() throws InterruptedException{
			
	        logger=extent.startTest("TN settings section UI verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.tnSettingsUI();
		}
	
		//Check if appropriate alert is displayed if ring to number is not 10 digit
		@Test(priority=15)
		public void tn_settings_RingToNumber_verification() throws InterruptedException{
			
	        logger=extent.startTest("TN settings Ring To Number verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.tnSettingsFormValidation("ring_to_phone_number_textbox");
		}
	
		//Check if dni fields are not enabled unless dni checkbox is checked
		@Test(priority=16)
		public void tn_settings_DNI_checkbox_verification() throws InterruptedException{
			
	        logger=extent.startTest("TN settings DNI Section verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.dniAndIntantInsightsFormValidations("dni_section");
		}
		
		//Check if instant insights fields are not enabled unless instant insights checkbox is checked
		@Test(priority=17)
		public void tn_settings_instant_insights_checkbox_verification() throws InterruptedException{
			
	        logger=extent.startTest("TN settings instant insigts checkbox verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.dniAndIntantInsightsFormValidations("instant_insights_section");
		}
		
		//Check if appropriate alert is displayed if instant insights details are missing
		@Test(priority=18)
		public void tn_settings_instant_insights_checkbox_alert_verification() throws InterruptedException{
			
	        logger=extent.startTest("TN settings instant insigts checkbox alert verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.dniAndIntantInsightsFormValidations("instant_insights_section");
		}
		
		//Check if appropriate alert is displayed if DNI details are missing
		@Test(priority=19)
		public void tn_settings_Dynamic_Number_checkbox_alert_verification() throws InterruptedException{
			
	        logger=extent.startTest("TN settings DNI checkbox alert verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.dniAndIntantInsightsFormValidations("dni_section");
		}
		
		//Check if appropriate alert is displayed if voice prompt message is missing
		@Test(priority=20)
		public void tn_settings_voice_prompt_alert_verification() throws InterruptedException{
			
	        logger=extent.startTest("TN settings voice prompt alert verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.tnSettingsFormValidation("play_voice_prompt_textbox");
		}
		
		//Check if appropriate alert is displayed if whisper message is missing
		@Test(priority=21)
		public void tn_settings_whisper_message_alert_verification() throws InterruptedException{
			
	        logger=extent.startTest("TN settings whisper message alert verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.tnSettingsFormValidation("play_whisper_message_before_connecting_textbox");
		}
		
		//Check if appropriate alert is displayed if ring to number is invalid(less than 10 digits) is missing
		@Test(priority=22)
		public void tn_settings_Ring_To_Number_alert_verification() throws InterruptedException{
			
	        logger=extent.startTest("TN settings Ring To Number alert verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.tnSettingsFormValidation("ring_to_phone_number_textbox");
		}
		
		@Test(priority=23)
		public void custom_source_setting_strip() throws InterruptedException{
			
	        logger=extent.startTest("Custom Source Setting Strip display verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.Strip(Constants.GroupsAndUser.custom_sources_strip);
	        
		}
		
		// check if the Custom Soyu settings Strip is Collapsible & expandable
		/*
		 * @Test(priority=23) public void tn_Setting_Strip_Collapsible_Expandable()
		 * throws InterruptedException{
		 * 
		 * logger=extent.
		 * startTest("TN Settings Strip Collapsible & expandable verification..");
		 * logger.assignCategory(Constants.groups_and_user_category); GroupsAndUserPage
		 * gp=new GroupsAndUserPage(driver);
		 * gp.expandSection(Constants.GroupsAndUser.tn_settings_strip);
		 * gp.collpaseSection(Constants.GroupsAndUser.tn_settings_strip); }
		 * 
		 * //UI verification of TN settings section //Verify options displayed in
		 * referring website listbox //Verify options displayed in DNI type //Check if
		 * DNI Custom Parameters pop up is displayed when clicked in custom parameters
		 * //Check UI of DNI Custom Parameters pop up //Check options displayed in
		 * instant insights type listbox
		 * 
		 * @Test(priority=13) public void tn_settings_UI_verification() throws
		 * InterruptedException{
		 * 
		 * logger=extent.startTest("TN settings section UI verification..");
		 * logger.assignCategory(Constants.groups_and_user_category); GroupsAndUserPage
		 * gp=new GroupsAndUserPage(driver); gp.tnSettingsUI(); }
		 */
			
		
		
		
		
		
		
		
		//Check UI of Users section
		@Test(priority=50)
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
