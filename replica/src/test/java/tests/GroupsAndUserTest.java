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
			
	        logger=extent.startTest("groupsAndUserPageLabel");
			logger.assignCategory(Constants.groups_and_user_category);
			
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.groupsAndUserHeaderLabel();
		}
		
		//Check if export groups and user button is present and is clickable
		@Test(priority=2)
		public void exportgroupAndUserButton() throws InterruptedException{
			
	        logger=extent.startTest("exportgroupAndUserButton");
			logger.assignCategory(Constants.groups_and_user_category);
			
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.exportGroupsAndUserButton();
		}
		
		 
		//Check if Group details strip is present
		@Test(priority=3)
		public void groupDetailsStripVerification() throws InterruptedException{
			
	        logger=extent.startTest("groupDetailsStripVerification");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.Strip(Constants.GroupsAndUser.user_settings_strip);
		}
		
		
		// check if the Group Details Strip is Collapsible & expandable
		@Test(priority=4)
		public void groupDetailsStripCollapsible_Expandable() throws InterruptedException{
			
	        logger=extent.startTest("groupDetailsStripCollapsible_Expandable");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.expandSection(Constants.GroupsAndUser.group_details_strip);
	        gp.collapseSection(Constants.GroupsAndUser.group_details_strip);
		}


		//UI verification of Group Details section
		@Test(priority=5)
		public void groupDetailsUIverification() throws InterruptedException{
			
	        logger=extent.startTest("groupDetailsUIverification");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.groupDetailsUI();
		}	
		
		
		//Check if appropriate alert is displayed if group name is empty
		@Test(priority=6)
		public void groupDetailsFormValidationForGroupName() throws InterruptedException{
			
	        logger=extent.startTest("groupDetailsFormValidationForGroupName");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.groupDetailsFormValidation("group_name_textbox");
		}
		
		
		//Check if appropriate alert is displayed if phone number is not 10 digit
		@Test(priority=7)
		public void groupDetailsFormValidationForPhoneNumber() throws InterruptedException{
			
	        logger=extent.startTest("groupDetailsFormValidationForPhoneNumber");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.groupDetailsFormValidation("phone_number_textbox");
		}
		
		
		//Check if updated group details are displayed
		@Test(priority=8)
		public void groupDetailsUpdate() throws InterruptedException{
			
	        logger=extent.startTest("groupDetailsUpdate");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.groupDetailsUpdate();
	        
		}
		
		
		//Check if feature settings strip is displayed
		@Test(priority=9)
		public void featureSettingStrip() throws InterruptedException{
			
	        logger=extent.startTest("featureSettingStrip");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.Strip(Constants.GroupsAndUser.feature_settings_strip);
	        
		}
		
		
		//check if the feature settings Strip is Collapsible & expandable
		@Test(priority=10)
		public void featureSSettingStripCollapsibleExpandable() throws InterruptedException{
			
	        logger=extent.startTest("featureSSettingStripCollapsibleExpandable");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.expandSection(Constants.GroupsAndUser.feature_settings_strip);
	        gp.collapseSection(Constants.GroupsAndUser.feature_settings_strip);
		}
		
		 
		//UI verification of feature settings section
		@Test(priority=11)
		public void featureSettingsUIVerification() throws InterruptedException{
			
	        logger=extent.startTest("featureSettingsUIVerification");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.featureSettingsUI();
		}
		
		
		//Check if TN settings strip is displayed
		@Test(priority=12)
		public void tnSettingStrip() throws InterruptedException{
			
	        logger=extent.startTest("tnSettingStrip");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.Strip(Constants.GroupsAndUser.tn_settings_strip);
	        
		}
		
		
		// check if the TN settings Strip is Collapsible & expandable
		@Test(priority=13)
		public void tnSettingStripCollapsibleExpandable() throws InterruptedException{
			
	        logger=extent.startTest("tnSettingStripCollapsibleExpandable");
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
		public void tnSettingsUIVerification() throws InterruptedException{
			
	        logger=extent.startTest("tnSettingsUIVerification");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.tnSettingsUI();
		}
	
		
		//Check if appropriate alert is displayed if ring to number is not 10 digit
		@Test(priority=15)
		public void tnSettingsRingToNumberVerification() throws InterruptedException{
			
	        logger=extent.startTest("tnSettingsRingToNumberVerification");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.tnSettingsFormValidation("ring_to_phone_number_textbox");
		}
	
		
		//Check if dni fields are not enabled unless dni checkbox is checked
		@Test(priority=16)
		public void tnSettingsDNICheckboxVerification() throws InterruptedException{
			
	        logger=extent.startTest("tnSettingsDNICheckboxVerification");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        Thread.sleep(3000);
	        gp.dniAndIntantInsightsFormValidations("dni_section");
		}
		
		
		//Check if instant insights fields are not enabled unless instant insights checkbox is checked
		@Test(priority=17)
		public void tnSettingsInstantInsightsCheckboxVerification() throws InterruptedException{
			
	        logger=extent.startTest("tnSettingsInstantInsightsCheckboxVerification");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.dniAndIntantInsightsFormValidations("instant_insights_section");
		}
		
		
		//Check if appropriate alert is displayed if instant insights details are missing
		@Test(priority=18)
		public void tnSettingsInstantInsightsCheckboxAlertVerification() throws InterruptedException{
			
	        logger=extent.startTest("tnSettingsInstantInsightsCheckboxAlertVerification");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.tnSettingsFormValidation("instant_insights_section");
		}
		
		
		//Check if appropriate alert is displayed if DNI details are missing
		@Test(priority=19)
		public void tnSettingsDynamicNumberCheckboxAlertVerification() throws InterruptedException{
			
	        logger=extent.startTest("tnSettingsDynamicNumberCheckboxAlertVerification");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.tnSettingsFormValidation("dni_section");
		}
		
		
		//Check if appropriate alert is displayed if voice prompt message is missing
		@Test(priority=20)
		public void tnSettingsVoicePromptAlertVerification() throws InterruptedException{
			
	        logger=extent.startTest("tnSettingsVoicePromptAlertVerification");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.tnSettingsFormValidation("play_voice_prompt_textbox");
		}
		
		
		//Check if appropriate alert is displayed if whisper message is missing
		@Test(priority=21)
		public void tnSettingsWhisperMessageAlertVerification() throws InterruptedException{
			
	        logger=extent.startTest("tnSettingsWhisperMessageAlertVerification");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.tnSettingsFormValidation("play_whisper_message_before_connecting_textbox");
		}
		
		
		//Check if appropriate alert is displayed if ring to number is invalid(less than 10 digits) is missing
		@Test(priority=22)
		public void tnSettingsRingToNumberAlertVerification() throws InterruptedException{
			
	        logger=extent.startTest("tnSettingsRingToNumberAlertVerification");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.tnSettingsFormValidation("ring_to_phone_number_textbox");
		}
		
		
		//Check if Custom source strip is displayed
		@Test(priority=23)
		public void customSourceStrip() throws InterruptedException{
			
	        logger=extent.startTest("customSourceStrip");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.Strip(Constants.GroupsAndUser.custom_sources_strip);
	        
		}
		
		
		//check if the Custom Sources settings Strip is Collapsible & expandable	
		@Test(priority=24)
		public void customSourceStripCollapsibleExpandable() throws InterruptedException{
			
	        logger=extent.startTest("customSourceStripCollapsibleExpandable");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.expandSection(Constants.GroupsAndUser.custom_sources_strip);
	        gp.collapseSection(Constants.GroupsAndUser.custom_sources_strip);
	        
		}

		
		//UI verification of custom source section 
		@Test(priority=25)
		public void customSourceUIVerification() throws InterruptedException{
			
	        logger=extent.startTest("customSourceUIVerification");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.custom_Source_UI_Validation();
   
		}  

		
		//Check if able to add new custom source in every column 
		@Test(priority=26)
		public void customSourceAddNewSource() throws InterruptedException{
			
	        logger=extent.startTest("customSourceAddNewSource");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.custom_Source_Add_New_Source();
   
		}  

		
        //Check if able to clear selected custom source checkbox
		@Test(priority=27)
		public void customSourceClearSource() throws InterruptedException{
			
	        logger=extent.startTest("customSourceClearSource");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.custom_Source_clear_Source();
   
		}
		
		
		//Check if able to add new custom sgit ource in every column 	
		@Test(priority=28)
		public void customSourceDeleteSource() throws InterruptedException{
			
	        logger=extent.startTest("customSourceDeleteSource");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.custom_Source_delete_Source();
	        Thread.sleep(5000);
   
		}
	
			
		//Check if Call Action strip is displayed
		@Test(priority=29)
		public void callActionStrip() throws InterruptedException{
			
	        logger=extent.startTest("callActionStrip");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.Strip(Constants.GroupsAndUser.call_actions_strip);
   
		}	
		
		
		//Check if Call Action strip is expandable and collapsible
		@Test(priority=30)
		public void callActionStripExpandableCollapsible() throws InterruptedException{
			
	        logger=extent.startTest("callActionStripExpandableCollapsible");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.expandSection(Constants.GroupsAndUser.call_actions_strip);
	        gp.collapseSection(Constants.GroupsAndUser.call_actions_strip);
   
		}
		
	
	    /*Check UI of Call Action section
	    Check operators displayed for repeat call condition
	    Check operators displayed for duration condition
	    Check operators displayed for disposition condition
	    Check operators displayed for caller id condition
	    Check operators displayed for missed opportunity condition
	    Check operators displayed for sales inquiry condition
	    Check operators displayed for conversion condition
	    Check operators displayed for lead quality condition
   	    Check operators displayed for reffering source condition
	    Check operators displayed for reffering type condition
	    Check operators displayed for UTM campaign condition
	    Check operators displayed for UTM source condition
	    Check operators displayed for UTM medium condition
	    Check operators displayed for send to voicemail condition
	    Check if AND/OR operator is present
	    Check options displayed in Then listbox
		*/
		@Test(priority=31)
		public void callActionSectionUIVerification() throws InterruptedException{
			
	        logger=extent.startTest("callActionSectionUIVerification");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.callActionSectionUI();
   
		}
		

	    //Check if appropriate alert is displayed if user try to add call action without rule field
		@Test(priority=32)
		public void callActionFormValidationRuleField() throws InterruptedException{
			
	        logger=extent.startTest("callActionFormValidationRuleField");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.callActionFormValidation("rule");
   
		}

		
	    //Check if appropriate alert is displayed if user try to add call action without action field
		@Test(priority=33)
		public void callActionFormValidationActionField() throws InterruptedException{
			
	        logger=extent.startTest("callActionFormValidationActionField");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.callActionFormValidation("action");
   
		}
		
		
	    //Check if all filled data is reset after clicking on Reset button
		@Test(priority=34)
		public void callActionResetButtonFeature() throws InterruptedException{
			
	        logger=extent.startTest("callActionResetButtonFeature");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.resetCallAction();
   
		}
		
		
	    //Check if user is not able to add call actions more than 10
		@Test(priority=35)
		public void callActionAdd10Actions() throws InterruptedException{
			
	        logger=extent.startTest("callActionAdd10Actions");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.add10CallAction();
	        Thread.sleep(5000);
   
		}
		
		
	    //Check if user is not able to delete call actions
		@Test(priority=36)
		public void callActionDelete() throws InterruptedException{
			
	        logger=extent.startTest("callActionDelete");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.deleteAllCations();
   
		}

		
	    //Check if Sub Groups strip is displayed
		@Test(priority=37)
		public void subGroupStrip() throws InterruptedException{
			
	        logger=extent.startTest("subGroupStrip");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.Strip(Constants.GroupsAndUser.sub_groups_strip);
   
		}
		
		
	    //Check if Sub Groups strip is expandable and collapsible
		@Test(priority=38)
		public void subGroupStripExpandableCollapsible() throws InterruptedException{
			
	        logger=extent.startTest("subGroupStripExpandableCollapsible");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.expandSection(Constants.GroupsAndUser.sub_groups_strip);
	        gp.collapseSection(Constants.GroupsAndUser.sub_groups_strip);
   
		}
		
		
	    //Check UI of Sub Groups section
		@Test(priority=39)
		public void subGroupUIVerification() throws InterruptedException{
			
	        logger=extent.startTest("subGroupUIVerification");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.subGroupUI();
   
		}
		
		
	    //Check UI of pagination toolbox of sub groups section
		@Test(priority=40)
		public void subGroupPaginationToolbox() throws InterruptedException{
			
	        logger=extent.startTest("subGroupPaginationToolbox");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.subGroupPagiantionToolbox();
   
		}

		
	    //Check if pagination count is matching with db count
		@Test(priority=41)
		public void subGroupPaginationCount() throws InterruptedException{
			
	        logger=extent.startTest("subGroupPaginationCount");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.subGroupPaginationCount();
   
		}
		
		
	    //Check if pagination count is mataching with db count
		@Test(priority=42)
		public void subGroupGridCount() throws InterruptedException{
			
	        logger=extent.startTest("subGroupGridCount");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.subGroupGridCount();
   
		}
		
		
	    //Check if appropriate alert is displayed while saving subgroup if subgroup name is missing 
		@Test(priority=43)
		public void subGroupFormValidationForName() throws InterruptedException{
			
	        logger=extent.startTest("subGroupFormValidationForName");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.subGroupFormValidation("industry");
   
		}
		

	    //Check if appropriate alert is displayed while saving subgroup if industry is missing 
		@Test(priority=44)
		public void subGroupFormValidationForIndustry() throws InterruptedException{
			
	        logger=extent.startTest("subGroupFormValidationForIndustry");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.subGroupFormValidation("group_name_textbox");
   
		}
		
		
	    //Check if sub group is not created if clicked on cancel button after entering all details
		@Test(priority=45)
		public void subGroupCancelFeature() throws InterruptedException{
			
	        logger=extent.startTest("subGroupCancelFeature");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.cancelSubGroup();
   
		}
		
		
	    //Check if able to create new subgroup
		@Test(priority=46)
		public void subGroupCreation() throws InterruptedException{
			
	        logger=extent.startTest("subGroupCreation");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        this.groupName="SJSG-1"+Util.generateRandomNumber();
	        gp.createSubGroup(this.groupName);
	        Thread.sleep(4000);
	        
		}
	
		
	    //Check if able to update newly created subgroup
		@Test(priority=47)
		public void subGroupUpdation() throws InterruptedException{
			
	        logger=extent.startTest("subGroupUpdation");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.updateSubGroup(this.groupName,this.groupName_updated);
   
		}
		
		
	    //Check if able to delete newly created subgroup
		@Test(priority=48)
		public void subGroupDeletion() throws InterruptedException{
			
	        logger=extent.startTest("subGroupDeletion");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        gp.subGroupDeletion(this.groupName_updated);
   
		}

		
	    //Check if able to delete newly created subgroup
		@Test(priority=49)
		public void subGroupSelectFeature() throws InterruptedException{
			
	        logger=extent.startTest("subGroupSelectFeature");
			logger.assignCategory(Constants.groups_and_user_category);
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);

	        this.groupName="SJSG-1"+Util.generateRandomNumber();
	        gp.createSubGroup(this.groupName);
	        gp.subGroupNavigation(this.groupName);
	        gp.clickActionSubGroup(this.groupName,"delete_from_selected_group");	
	        Thread.sleep(5000);
   
		}
		
		
	    //Check UI of Users section
        @Test(priority=50)
		public void userSectionUIVerification() throws InterruptedException{
			
	        logger=extent.startTest("userSectionUIVerification");
			logger.assignCategory(Constants.groups_and_user_category);
			
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.users_UI_Validation();
		}
		
		
		//Check if grid count is matching with db count
	    @Test(priority=51)
		public void useSectionGridcountVerification() throws InterruptedException{
				
	        logger=extent.startTest("useSectionGridcountVerification");
			logger.assignCategory(Constants.groups_and_user_category);
				
		    GroupsAndUserPage gp=new GroupsAndUserPage(driver);
		    gp.usersGridCount();
		}
		
	       
		//Check roles displayed in roles listbox
        @Test(priority=52)
		public void userSectionRolesVerification() throws InterruptedException{
				
	        logger=extent.startTest("userSectionRolesVerification");
	        logger.assignCategory(Constants.groups_and_user_category);
				
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
		    gp.userRoles();
		
        }	
		
        
		//Check 'Inactive' status is not displayed at the time of creating new user	
	    @Test(priority=53)
		public void userSectionInactiveStatusVerification() throws InterruptedException{
	    	
	    	logger=extent.startTest("userSectionInactiveStatusVerification");
			logger.assignCategory(Constants.groups_and_user_category);
				
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.userStatus();

	    }	
		
	    
	    //Check if appropriate alert is displayed while creating new userif firstname is missing
	    @Test(priority=54)
		public void userSectionFirstnameAlertVerification() throws InterruptedException{
				
	    	logger=extent.startTest("userSectionFirstnameAlertVerification");
			logger.assignCategory(Constants.groups_and_user_category);
				
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.userCreationFormValidation("first_name_textbox");
	        
		}
	       
	       
	    // Check if appropriate alert is displayed while creating new user if lastname is missing
	    @Test(priority=55)
		public void userSectionLastnameAlertVerification() throws InterruptedException{
				
	        logger=extent.startTest("userSectionLastnameAlertVerification");
			logger.assignCategory(Constants.groups_and_user_category);
				
	        GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.userCreationFormValidation("last_name_textbox");
			
	    }	       
	       
	    
	    // Check if appropriate alert is displayed while creating new user if mail id is missing	
        @Test(priority=56)
        public void userSectionMailIDAlertVerification() throws InterruptedException{
				
            logger=extent.startTest("userSectionMailIDAlertVerification");
 
            logger.assignCategory(Constants.groups_and_user_category);
				
            GroupsAndUserPage gp=new GroupsAndUserPage(driver);
            gp.userCreationFormValidation("email_id_textbox");
		
        }	       
	
        
        String fname="";
        String lname="";
        String[] email=new String[4];
        
	    //Check if able to create new user with role Admin		
	    @Test(priority=57)
	   	public void userSectionCreateUserWithAdminRole() throws InterruptedException{
				
	        logger=extent.startTest("userSectionCreateUserWithAdminRole");
			logger.assignCategory(Constants.groups_and_user_category);
				
			GroupsAndUserPage gp=new GroupsAndUserPage(driver);
			
			fname="Admin"+Util.generateRandomNumber();
			lname="User"+Util.generateRandomNumber();
			email[0]="admin"+Util.generateRandomNumber()+"@yopmail.com.com";
			
			gp.createUser(fname, lname, email[0], "Admin");
			
	    }
	       
	    
	    //Check if able to create new user with role Standard	  
	    @Test(priority=58)
	    public void userSectionCreateUserWithStandardRole() throws InterruptedException{
				
	    	logger=extent.startTest("userSectionCreateUserWithStandardRole");
	    	logger.assignCategory(Constants.groups_and_user_category);
				 
	    	GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	    	
			fname="Standard"+Util.generateRandomNumber();
			lname="User"+Util.generateRandomNumber();
			email[1]="standard"+Util.generateRandomNumber()+"@yopmail.com.com";
	    	
	    	gp.createUser(fname, lname, email[1], "Standard");
			
	    }
	       
	       
	    // Check if able to create new user with role Read Only	
	    @Test(priority=59)
		public void userSectioCreateUserWithReadOnlyRole() throws InterruptedException{
				
	        logger=extent.startTest("userSectioCreateUserWithReadOnlyRole");
			logger.assignCategory(Constants.groups_and_user_category);
			
    	    GroupsAndUserPage gp=new GroupsAndUserPage(driver);

			fname="RO"+Util.generateRandomNumber();
			lname="User"+Util.generateRandomNumber();
			email[2]="ro"+Util.generateRandomNumber()+"@yopmail.com.com";
    	    
    	    gp.createUser(fname, lname, email[2], "Read-Only");
			Thread.sleep(10000);
	    }      
	       
	     
	    // Check if user is not created if clicked on cancel button	
	    @Test(priority=60)
		public void userSectionCancelButtonVerification() throws InterruptedException{
				
	        logger=extent.startTest("userSectionCancelButtonVerification");
	        logger.assignCategory(Constants.groups_and_user_category);
				
		    GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	        gp.userCancelFeature();
	
	    }        
	       
	    
	    //Check if able to update user details
	    @Test(priority=61)
	    public void userSectionUpdateUserDetail() throws InterruptedException{

	       logger=extent.startTest("userSectionUpdateUserDetail");
	       logger.assignCategory(Constants.groups_and_user_category);

	       GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	       
	       String temp_mail = "test" + Util.generateRandomNumber() + "@yopmail.com";
	       gp.createUser("fname", "lname", temp_mail, "Standard");
	       Thread.sleep(3000);
	       email[3]=Util.generateRandomNumber()+temp_mail;
	       
	       gp.updateUser(temp_mail, email[3]);
	    }  
	     
	    	      
	    //Check UI of User permission window
        @Test(priority=62)
	    public void userSectionUserPermissionUIVerification() throws InterruptedException{

	       logger=extent.startTest("userSectionUserPermissionUIVerification");
	       logger.assignCategory(Constants.groups_and_user_category);

	       GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	       
	       gp.userPermissionUI(email[3]);
	    }        
	  
        
	    //Check if able to update user permissions
        @Test(priority=63)
	    public void userSectionUserPermissionUpdate() throws InterruptedException{

	       logger=extent.startTest("userSectionUserPermissionUpdate");
	       logger.assignCategory(Constants.groups_and_user_category);

	       GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	       
	       Thread.sleep(3000);
	       gp.updateUserPermissions(email[1]);
	    } 

        
	    //Check if user permissions are not updated if click on cancel button
        @Test(priority=64)
	    public void userSectionUserPermissionUpdateCancelFeature() throws InterruptedException{

	       logger=extent.startTest("userSectionUserPermissionUpdateCancelFeature");
	       logger.assignCategory(Constants.groups_and_user_category);

	       GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	       
	       Thread.sleep(3000);
	       gp.userCancelFeature();
	    } 
	      
        
        //Check UI of change password pop up
        @Test(priority=65)
	    public void userSectionChangePasswordUI() throws InterruptedException{

	       logger=extent.startTest("userSectionChangePasswordUI");
	       logger.assignCategory(Constants.groups_and_user_category);

	       GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	       
	       Thread.sleep(3000);
	       gp.changePasswordWindow(email[3]);
	    } 
        
        
        //Check if appropriate alert is displayed if password field left blank
        @Test(priority=66)
	    public void userSectionChangePasswordFormValidationForpassword() throws InterruptedException{

	       logger=extent.startTest("userSectionChangePasswordFormValidationForpassword");
	       logger.assignCategory(Constants.groups_and_user_category);

	       GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	       
	       Thread.sleep(3000);
	       gp.changePasswordFormValidation(email[1]);
	    } 
        
        
        //Check if password is not changed if clicked on cancel button
        @Test(priority=67)
	    public void userSectionChangePasswordCancelFeature() throws InterruptedException{

	       logger=extent.startTest("userSectionChangePasswordCancelFeature");
	       logger.assignCategory(Constants.groups_and_user_category);

	       GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	       
	       Thread.sleep(3000);
	       gp.changePasswordCancel(email[3]);
	    }
        
        
        //Check if able to change the password
        @Test(priority=68)
	    public void userSectionChangePassword() throws InterruptedException{

	       logger=extent.startTest("userSectionChangePassword");
	       logger.assignCategory(Constants.groups_and_user_category);

	       GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	       
	       Thread.sleep(3000);
	       gp.changePassword(email[3]);
	    } 
        
               
	    //Check if able to delete newly created user
	    @Test(priority=69)
	    public void userSectionDeleteUser() throws InterruptedException{

	       logger=extent.startTest("userSectionDeleteUser");
           logger.assignCategory(Constants.groups_and_user_category);

	       GroupsAndUserPage gp=new GroupsAndUserPage(driver);
	       String tempmail = "test" + Util.generateRandomNumber() + "@yopmail.com";
	       gp.createUser("fname", "lname", tempmail, "Standard");
	       Thread.sleep(4000);
//	       for(String mail:email) {
//		       gp.deleteUser(mail);	    	   
//	       }
	       for(int i=0;i<email.length;i++) {
	    	   gp.deleteUser(email[i]);
	    	   Thread.sleep(2000);
	       }
	       

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
