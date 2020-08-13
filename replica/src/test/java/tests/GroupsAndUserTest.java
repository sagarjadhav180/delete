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
	
	   
 	    static String groupName="";
	    static String groupName_updated="SJSG-1(delete)";	    
	
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
	        gp.collapseSection(Constants.GroupsAndUser.group_details_strip);
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
			
	        logger=extent.startTest("Group Details alert messages for Group Name verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.groupDetailsFormValidation("group_name_textbox");
		}
		
		 //Check if appropriate alert is displayed if phone number is not 10 digit
		@Test(priority=7)
		public void groupDetails_PhoneNumber_alert_messages() throws InterruptedException{
			
	        logger=extent.startTest("Group Details alert messages for Phone Number verification..");
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
	        gp.collapseSection(Constants.GroupsAndUser.feature_settings_strip);
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
	        gp.collapseSection(Constants.GroupsAndUser.tn_settings_strip);
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
	        Thread.sleep(3000);
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
	        gp.tnSettingsFormValidation("instant_insights_section");
		}
		
		 //Check if appropriate alert is displayed if DNI details are missing
		@Test(priority=19)
		public void tn_settings_Dynamic_Number_checkbox_alert_verification() throws InterruptedException{
			
	        logger=extent.startTest("TN settings DNI checkbox alert verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.tnSettingsFormValidation("dni_section");
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
		
		 //Check if Custom source strip is displayed
		@Test(priority=23)
		public void custom_source_strip() throws InterruptedException{
			
	        logger=extent.startTest("Custom Source Setting Strip display verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.Strip(Constants.GroupsAndUser.custom_sources_strip);
	        
		}
		
		 //check if the Custom Sources settings Strip is Collapsible & expandable
		
		@Test(priority=24)
		public void custom_source_Strip_Collapsible_Expandable() throws InterruptedException{
			
	        logger=extent.startTest("custom source Strip Collapsible & expandable verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.expandSection(Constants.GroupsAndUser.custom_sources_strip);
	        gp.collapseSection(Constants.GroupsAndUser.custom_sources_strip);
	        
		}

		 //UI verification of custom source section 
		
		@Test(priority=25)
		public void custom_source_UI_verification() throws InterruptedException{
			
	        logger=extent.startTest("custom source section UI verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.custom_Source_UI_Validation();
   
		}  

		 //Check if able to add new custom source in every column 
		
		@Test(priority=26)
		public void custom_source_add_new_source() throws InterruptedException{
			
	        logger=extent.startTest("custom source section add new source verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.custom_Source_Add_New_Source();
   
		}  

		
        //Check if able to clear selected custom source checkbox
		@Test(priority=27,dependsOnMethods="custom_source_add_new_source")
		public void custom_source_clear_source() throws InterruptedException{
			
	        logger=extent.startTest("custom_source_clear_source");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.custom_Source_clear_Source();
   
		}
		
		
		 //Check if able to add new custom sgit ource in every column 	
		@Test(priority=28,dependsOnMethods="custom_source_add_new_source")
		public void custom_source_delete_source() throws InterruptedException{
			
	        logger=extent.startTest("custom source section delete source verification..");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.custom_Source_delete_Source();
   
		}
	
			
		 //Check if Call Action strip is displayed
		@Test(priority=28)
		public void call_action_strip() throws InterruptedException{
			
	        logger=extent.startTest("call_action_strip");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.Strip(Constants.GroupsAndUser.call_actions_strip);
   
		}	
		
		
		 //Check if Call Action strip is expandable and collapsible
		@Test(priority=29)
		public void call_action_strip_expandable_collapsible() throws InterruptedException{
			
	        logger=extent.startTest("call_action_strip_expandable_collapsible");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.expandSection(Constants.GroupsAndUser.call_actions_strip);
	        gp.collapseSection(Constants.GroupsAndUser.call_actions_strip);
   
		}
		
	
		 //Check UI of Call Action section
	 //Check operators displayed for repeat call condition
	 //Check operators displayed for duration condition
	 //Check operators displayed for disposition condition
	 //Check operators displayed for caller id condition
	 //Check operators displayed for missed opportunity condition
	 //Check operators displayed for sales inquiry condition
	 //Check operators displayed for conversion condition
	 //Check operators displayed for lead quality condition
	 //Check operators displayed for reffering source condition
	 //Check operators displayed for reffering type condition
	 //Check operators displayed for UTM campaign condition
	 //Check operators displayed for UTM source condition
	 //Check operators displayed for UTM medium condition
	 //Check operators displayed for send to voicemail condition
	 //Check if AND/OR operator is present
	 //Check options displayed in Then listbox
		@Test(priority=30)
		public void call_action_Section_UI_Verification() throws InterruptedException{
			
	        logger=extent.startTest("call_action_Section_UI_Verification");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.callActionSectionUI();
   
		}

	 //Check if appropriate alert is displayed if user try to add call action without rule field
		@Test(priority=31)
		public void call_action_form_validation_rule_field() throws InterruptedException{
			
	        logger=extent.startTest("call_action_form_validation_rule_field");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.callActionFormValidation("rule");
   
		}

		
	 //Check if appropriate alert is displayed if user try to add call action without action field
		@Test(priority=31)
		public void call_action_form_validation_action_field() throws InterruptedException{
			
	        logger=extent.startTest("call_action_form_validation_action_field");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.callActionFormValidation("action");
   
		}
		
	 //Check if all filled data is reset after clicking on Reset button
		@Test(priority=32)
		public void call_action_reset_button_feature() throws InterruptedException{
			
	        logger=extent.startTest("call_action_reset_button_feature");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.resetCallAction();
   
		}
		
	 //Check if user is not able to add call actions more than 10
		@Test(priority=33)
		public void call_action_10_actions() throws InterruptedException{
			
	        logger=extent.startTest("call_action_10_actions");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.add10CallAction();
	        Thread.sleep(5000);
   
		}
		
		
	 //Check if user is not able to delete call actions
		@Test(priority=34)
		public void call_action_delete() throws InterruptedException{
			
	        logger=extent.startTest("call_action_delete");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.deleteAllCations();
   
		}

		
	 //Check if Sub Groups strip is displayed
		@Test(priority=35)
		public void sub_group_strip() throws InterruptedException{
			
	        logger=extent.startTest("sub_group_strip");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.Strip(Constants.GroupsAndUser.sub_groups_strip);
   
		}
		
		
	 //Check if Sub Groups strip is expandable and collapsible
		@Test(priority=36)
		public void sub_group_strip_expandable_collapsible() throws InterruptedException{
			
	        logger=extent.startTest("sub_group_strip_expandable_collapsible");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.expandSection(Constants.GroupsAndUser.sub_groups_strip);
	        gp.collapseSection(Constants.GroupsAndUser.sub_groups_strip);
   
		}
		
	 //Check UI of Sub Groups section
		@Test(priority=37)
		public void sub_group_UI_Verification() throws InterruptedException{
			
	        logger=extent.startTest("sub_group_UI_Verification");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.subGroupUI();
   
		}
		
	 //Check UI of pagination toolbox of sub groups section
		@Test(priority=37)
		public void sub_group_pagination_toolbox() throws InterruptedException{
			
	        logger=extent.startTest("sub_group_pagination_toolbox");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.subGroupPagiantionToolbox();
   
		}

		
	 //Check if pagination count is mataching with db count
		@Test(priority=38)
		public void sub_group_pagination_count() throws InterruptedException{
			
	        logger=extent.startTest("sub_group_pagination_count");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.subGroupPaginationCount();
   
		}
		
		
	 //Check if pagination count is mataching with db count
		@Test(priority=39)
		public void sub_group_grid_count() throws InterruptedException{
			
	        logger=extent.startTest("sub_group_grid_count");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.subGroupGridCount();
   
		}
		
		
	 //Check if appropriate alert is displayed while saving subgroup if subgroup name is missing 
		@Test(priority=40)
		public void sub_group_form_validation_for_name() throws InterruptedException{
			
	        logger=extent.startTest("sub_group_form_validation_for_name");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.subGroupFormValidation("industry");
   
		}
		

	 //Check if appropriate alert is displayed while saving subgroup if industry is missing 
		@Test(priority=41)
		public void sub_group_form_validation_for_industry() throws InterruptedException{
			
	        logger=extent.startTest("sub_group_form_validation_for_industry");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.subGroupFormValidation("group_name_textbox");
   
		}
		
		
	 //Check if sub group is not created if clicked on cancel button after entering all details
		@Test(priority=42)
		public void sub_group_cancel_feature() throws InterruptedException{
			
	        logger=extent.startTest("sub_group_cancel_feature");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.cancelSubGroup();
   
		}
		
		
	 //Check if able to create new subgroup
		@Test(priority=43)
		public void sub_group_creation() throws InterruptedException{
			
	        logger=extent.startTest("sub_group_creation");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.createSubGroup(this.groupName);
   
		}
	
		
	    //Check if able to update newly created subgroup
		@Test(priority=44)
		public void sub_group_updation() throws InterruptedException{
			
	        logger=extent.startTest("sub_group_updation");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.updateSubGroup(this.groupName,this.groupName_updated);
   
		}
		
		
	    //Check if able to delete newly created subgroup
		@Test(priority=45)
		public void sub_group_deletion() throws InterruptedException{
			
	        logger=extent.startTest("sub_group_deletion");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.subGroupDeletion(this.groupName_updated);
   
		}

		
	    //Check if able to delete newly created subgroup
		@Test(priority=45)
		public void sub_group_clear_feature() throws InterruptedException{
			
	        logger=extent.startTest("sub_group_clear_feature");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        this.groupName="SJSG-1"+Util.generateRandomNumber();
	        gp.createSubGroup(this.groupName);
	        gp.subGroupNavigation(this.groupName);
	        gp.subGroupDeletion(this.groupName);	        
   
		}
		
		
	   //Check UI of Users section
       //@Test(priority=24)
		public void userSectionUIVerification() throws InterruptedException{
			
	        logger=extent.startTest("User Section UI Verification verification..");
			logger.assignCategory(Constants.groups_and_user_category);
			
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.users_UI_Validation();
		}
		
		
		   //Check if grid count is matching with db count
		
	       @Test(priority=52)
			public void user_section_gridcount_dbcount_match() throws InterruptedException{
				
		        logger=extent.startTest("Checking if grid count is matching with db count..");
				logger.assignCategory(Constants.groups_and_user_category);
				
		        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
		        gp.usersGridCount();
			}
		
		   //Check roles displayed in roles listbox
			
	       @Test(priority=53)
			public void user_section_roles_verification() throws InterruptedException{
				
		        logger=extent.startTest("Checking if roles displayed in roles listbox..");
				logger.assignCategory(Constants.groups_and_user_category);
				
		        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
		        gp.userRoles();
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
