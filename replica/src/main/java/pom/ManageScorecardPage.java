package pom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import dbUtil.GroupDBUtil;
import dbUtil.ScorecardDBUtil;
import dbUtil.UserDBUtil;
import tests.TestBase;
import tests.Util;

public class ManageScorecardPage extends TestBase {
	
	//score-card data set
	String scorecardTitle = "SJS-"+Util.generateRandomNumber();
	String instructions = "test scorecard";
	String outcomeLabel = "test- call";
	String criteriaTitle = "Criteria-"+Util.generateRandomNumber();
	String helpText = "test";
	
	@FindBy(xpath="//div[@ class='pageProgressLoader']")
	private WebElement loadingWheel;

	@FindBy(xpath="//div[@class='ui-pnotify ']//div[@class='ui-pnotify-sticker']")
	private WebElement pause_button_success_message;

	@FindBy(xpath="//div[@class='ui-pnotify ']//div[@class='ui-pnotify-closer']")
	private WebElement close_button_success_message;
	
	@FindBy(xpath="//h1[contains(text(),'Scorecards')]")
	private WebElement scorecard_header_label;

	@FindBy(xpath="//button[@class='btn btn-sm btn-default']")
	private WebElement add_scorecard_button;

	@FindBy(xpath="(//span[text()='Export']//parent::button)[1]")
	private WebElement export_button;

	@FindBy(xpath="//h4[text()='AVAILABLE SCORECARDS']")
	private WebElement available_scorecards_strip;
	
	@FindBy(xpath="//div[@class='ui-pnotify ']//div[text()='Successfully Created Scorecard']")
	private WebElement success_message_scorecard_creation;

	@FindBy(xpath="//div[@class='ui-pnotify ']//div[text()='Successfully updated Scorecard']")
	private WebElement success_message_scorecard_updation;

	@FindBy(xpath="//div[@class='ui-pnotify ']//div[text()='Successfully Archived Scorecard']")
	private WebElement success_message_scorecard_deletion;

	@FindBy(xpath="//div[@class='ui-pnotify ']//h4[text()='Scorecard Details Form']")
	private WebElement alert_message_scorecard_creation;
	
	@FindBy(xpath="//div[@class='modal-footer']//button[text()='OK']")
	private WebElement scorecard_deletion_alert_ok_button;

	@FindBy(xpath="//div[@class='modal-footer']//button[text()='Cancel']")
	private WebElement scorecard_deletion_alert_cancel_button;
	
	@FindBy(xpath="//table/thead//tr[1]//th")
	private List<WebElement> actual_column_names;
	
	//-----------------------------------------------------
//	static String index = null;
//	@FindBy(xpath="//table[@id='scorecardtable']//thead//tr[1]//th")
//	private WebElement index;
	
//	@FindBy(xpath="//table[@id='scorecardtable']/tbody//td["+index+"]")
//	private WebElement actual_column_values;
	//--------------------------------------
	
	String[] expected_column_names={"Scorecard Name","Created By","Date Created","Modified Date","Group","Actions"};
	
	//pagination tool box - top ------------
	@FindBy(xpath="(//button[contains(text(),'First')])[1]")
	private static WebElement top_first_button;	
	
	@FindBy(xpath="(//button[contains(text(),'Last')])[1]")
	private static WebElement top_last_button;
	
	@FindBy(xpath="(//button[contains(text(),'Prev')])[1]")
	private static WebElement top_prev_button;	
	
	@FindBy(xpath="(//button[contains(text(),'Next')])[1]")
	private static WebElement top_next_button;
	
	@FindBy(xpath="(//button[contains(text(),'Showing')])[1]")
	private static WebElement top_pagination_count;
	
	//pagination tool box - bottom -------
	@FindBy(xpath="(//button[contains(text(),'First')])[2]")
	private static WebElement bottom_first_button;	

	@FindBy(xpath="(//button[contains(text(),'Last')])[2]")
	private static WebElement bottom_last_button;	

	@FindBy(xpath="(//button[contains(text(),'Prev')])[2]")
	private static WebElement bottom_prev_button;	

	@FindBy(xpath="(//button[contains(text(),'Next')])[2]")
	private static WebElement bottom_next_button;

	@FindBy(xpath="(//button[contains(text(),'Showing')])[2]")
	private static WebElement bottom_pagination_count;

	@FindBy(xpath="//table[@id='scorecardtable']//tbody//tr")
	private static List<WebElement> scorecards_count_in_table;
	
	//Configure score card page --------------------
	@FindBy(xpath="//h3[text()='Create and Configure Scorecard']")
	private static WebElement create_scorecard_header_label;	

	@FindBy(xpath="//h3[text()='Create and Configure Scorecard']//following-sibling::button[@class='close pull-right']")
	private static WebElement configure_scorecard_close_button;

	@FindBy(xpath="//div[@class='modal-body modalbody panel-body']//label[text()='Scorecard Title']")
	private static WebElement scorecard_title_label;	

	@FindBy(xpath="//div[@class='modal-body modalbody panel-body']//label[text()='Scorecard Title']//parent::div//input")
	private static WebElement scorecard_title_textbox;

	@FindBy(xpath="//div[@class='modal-body modalbody panel-body']//label[text()='Available to']")
	private static WebElement available_to_label;

	@FindBy(xpath="//div[@class='modal-body modalbody panel-body']//label[text()='Available to']//following-sibling::div//button")
	private static WebElement available_to_dropdown;

	@FindBy(xpath="//input[@placeholder='Search...']//ancestor::li//following-sibling::li[@class='ng-scope']")
	private static List<WebElement> available_to_dropdown_options;
	
	@FindBy(xpath="//a[@id='selectAll']")
	private static WebElement select_all_checkbox;

	@FindBy(xpath="//a[@id='deselectAll']")
	private static WebElement deselect_all_checkbox;

	@FindBy(xpath="//input[@placeholder='Search...']")
	private static WebElement search_group_textbox;

	@FindBy(xpath="//input[@placeholder='Search...']//ancestor::li//following-sibling::li//a//span[text()]")
	private static List<WebElement> available_to_groups;
	
	@FindBy(xpath="(//ul[starts-with(@class,'dropdown-menu dropdown')]//a)[position()>0 and position()<3]")
	private static List<WebElement> available_to_groups_check_uncheck_options;
	String[] exp_available_to_groups_check_uncheck_options = {"Check All","Uncheck All"};

	@FindBy(xpath="//input[@placeholder='Search...']//ancestor::li//following-sibling::li//a//span//ancestor::li//input")
	private static List<WebElement> available_to_group_checkboxes;
	
	//-------------------------------------------------------------------------------------------
//	@FindBy(xpath="//input[@placeholder='Search...']//ancestor::li//following-sibling::li//a//span[text()='"+group_name+"']//ancestor::li//input")
//	private static List<WebElement> available_to_group_checkbox;
	//---------------------------------------------------------------------------------------------
	
	@FindBy(xpath="//div[@class='modal-body modalbody panel-body']//label[text()='Actions']")
	private static WebElement actions_label;
	
	@FindBy(xpath="//div[@class='modal-body modalbody panel-body']//label[text()='Actions']//following-sibling::div//select")
	private static WebElement actions_listbox;
	String[] expected_actions_listbox = {"Export", "Import"};
	
	@FindBy(xpath="//div[@class='modal-body modalbody panel-body']//label[text()='Instructions']")
	private static WebElement instructions_label;

	@FindBy(xpath="//div[@class='modal-body modalbody panel-body']//label[text()='Instructions']//parent::div//textarea")
	private static WebElement instructions_textbox;
	
	@FindBy(xpath="//div[@class='modal-body modalbody panel-body']//label[text()='Outcome Label']")
	private static WebElement outcome_label_label;

	@FindBy(xpath="//div[@class='modal-body modalbody panel-body']//label[text()='Outcome Label']//parent::div//input")
	private static WebElement outcome_label_textbox;
	
	//criteria
	@FindBy(xpath="(//div[@class='modal-body modalbody panel-body']//label[text()='Importance'])")
	private static WebElement importance_label;

	@FindBy(xpath="(//label[text()='Importance']//parent::div//select)[2]")
	private static WebElement importance_listbox;
	String[] expected_importance_listbox_options = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	
	@FindBy(xpath="//div[@class='modal-body modalbody panel-body']//label//b[text()='Criteria Title']")
	private static WebElement criteria_title_label;

	@FindBy(xpath="//label//b[text()='Criteria Title']//parent::label//following-sibling::div//input[@type='text']")
	private static WebElement criteria_title_textbox;
	
	@FindBy(xpath="//label/b[text()='Help Text']")
	private static WebElement help_text_label;

	@FindBy(xpath="//label/b[text()='Help Text']/..//parent::div//textarea")
	private static WebElement help_text_textbox;
	
	@FindBy(xpath="//label//b[text()='Criteria Type']")
	private static WebElement criteria_type_label;

	@FindBy(xpath="(//label[text()='Importance']//parent::div//select)[1]")
	private static WebElement criteria_listbox;
	String[] expected_criteria_listbox = {"Pass/Fail", "Scale 0-3", "Scale 0-5", "Scale 0-10"};
	
	@FindBy(xpath="//div[@class='modal-body modalbody panel-body']//label[text()='Pass:']")
	private static WebElement pass_label;

	@FindBy(xpath="//label[text()='Pass:']//following-sibling::input[1]")
	private static WebElement pass_checkbox;
	
	@FindBy(xpath="//label[text()='Fail:']//following-sibling::input[1]")
	private static WebElement fail_label;

	@FindBy(xpath="//label[text()='Fail:']//following-sibling::input[1]")
	private static WebElement fail_checkbox;
	
	@FindBy(xpath="//label//b[text()='Make this a required question']")
	private static WebElement make_this_rerequired_question_label;

	@FindBy(xpath="//label//b[text()='Make this a required question']//parent::label//parent::div//child::input")
	private static WebElement make_this_rerequired_question_checkbox;
	
	@FindBy(xpath="//i[@ class='fa fa-times']")
	private static WebElement delete_criteria_button;

	@FindBy(xpath="//button[text()=' Add Criteria']")
	private static WebElement add_criteria_button;
	
	@FindBy(xpath="//button[text()='Cancel']")
	private static WebElement cancel_configure_scorecard_button;

	@FindBy(xpath="//button[text()='Save']")
	private static WebElement save_configure_scorecard_button;
	
	
	public ManageScorecardPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	//to click on desired action button of desired score-card 
    public void clickActionButton(String scorecard_name,String button_name) throws InterruptedException{
		
		WebElement webelement = driver.findElement(By.xpath("//table//tbody//tr//td[text()='"+scorecard_name+"']//ancestor::tr//child::button[contains(text(),'"+button_name+"')]"));
		Util.Action().moveToElement(webelement).perform();
		webelement.click();
		
		switch(button_name) {
		case "Edit" :
			Util.customWait(create_scorecard_header_label);
			break;
		case "Archive" :
			driver.switchTo().activeElement();
			Util.Action().moveToElement(scorecard_deletion_alert_ok_button).perform();	
			scorecard_deletion_alert_ok_button.click();
			Util.customWait(success_message_scorecard_deletion);
			Assert.assertTrue(success_message_scorecard_deletion.isDisplayed(),"Scorecard not deleted successfully");
			Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);
			break;
		}		
	}
    
    //To check if header label is present
    public void headerLabel() {
    	Util.waitExecutorForVisibilityOfElement(scorecard_header_label);
    	logger.log(LogStatus.INFO, "Verifying if scorecard_header_label is present");
    	Assert.assertTrue(scorecard_header_label.isDisplayed(), "scorecard_header_label is not displayed");
    }
    
    //To check if add score-card button is displayed and clickable
    public void scorecardButton() {
    	//visibility of button
       	Util.waitExecutorForVisibilityOfElement(add_scorecard_button);
    	logger.log(LogStatus.INFO, "Verifying if add_scorecard_button is present");
    	Assert.assertTrue(add_scorecard_button.isDisplayed(), "add_scorecard_button is not displayed");   	
    	
    	//clickable
    	logger.log(LogStatus.INFO, "Verifying if add_scorecard_button is clickable");
    	Assert.assertTrue(add_scorecard_button.isEnabled(), "add_scorecard_button is not clickable");       	
    }
    
    //To check if export button is displayed and clickable
    public void exportButton() {
    	//visibility of button
       	Util.waitExecutorForVisibilityOfElement(export_button);
    	logger.log(LogStatus.INFO, "Verifying if export_button is present");
    	Assert.assertTrue(export_button.isDisplayed(), "export_button is not displayed");   	
    	
    	//clickable
    	logger.log(LogStatus.INFO, "Verifying if export_button is clickable");
    	Assert.assertTrue(export_button.isEnabled(), "export_button is not clickable");       	
    }
	
    //To check UI of pagination tool-box at the top
	public void paginationToolboxTop() {
    	logger.log(LogStatus.INFO, "Verifying if top_first_button button is displayd");
    	Assert.assertTrue(top_first_button.isDisplayed(), "top_first_button is not displayed");
    	logger.log(LogStatus.INFO, "Verifying if top_last_button button is displayd");
    	Assert.assertTrue(top_last_button.isDisplayed(), "top_last_button is not displayed");
    	logger.log(LogStatus.INFO, "Verifying if top_prev_button button is displayd");
    	Assert.assertTrue(top_prev_button.isDisplayed(), "top_prev_button is not displayed");
    	logger.log(LogStatus.INFO, "Verifying if top_next_button button is displayd");
    	Assert.assertTrue(top_next_button.isDisplayed(), "top_next_button is not displayed");   
	}
	
	//To check UI of pagination tool-box at the bottom
	public void paginationToolboxBottom() {
    	logger.log(LogStatus.INFO, "Verifying if bottom_first_button button is displayd");
    	Assert.assertTrue(bottom_first_button.isDisplayed(), "bottom_first_button is not displayed");
    	logger.log(LogStatus.INFO, "Verifying if bottom_last_button button is displayd");
    	Assert.assertTrue(bottom_last_button.isDisplayed(), "bottom_last_button is not displayed");
    	logger.log(LogStatus.INFO, "Verifying if bottom_prev_button button is displayd");
    	Assert.assertTrue(bottom_prev_button.isDisplayed(), "bottom_prev_button is not displayed");
    	logger.log(LogStatus.INFO, "Verifying if bottom_next_button button is displayd");
    	Assert.assertTrue(bottom_next_button.isDisplayed(), "bottom_next_button is not displayed");   
	}
	
	//To check if next button is enabled if records are less than 100
	public void nextButtonEnable(String checkForClickable) {
		switch(checkForClickable) {
		case "yes" :
			logger.log(LogStatus.INFO, "Verifying if top_next_button button is enabled since there are more than 100 records");
			Assert.assertFalse(top_next_button.getAttribute("class").endsWith("disabled"),"top_next_button is not enabled");
			logger.log(LogStatus.INFO, "Verifying if bottom_next_button button is enabled since there are more than 100 records");
			Assert.assertFalse(bottom_next_button.getAttribute("class").endsWith("disabled"),"bottom_next_button is not enabled");
			break;
		case "no" :
			logger.log(LogStatus.INFO, "Verifying if top_next_button button is disabled since there are less than 100 records");
			Assert.assertTrue(top_next_button.getAttribute("class").endsWith("disabled"),"top_next_button is not disabled");
			logger.log(LogStatus.INFO, "Verifying if bottom_next_button button is disabled since there are less than 100 records");
			Assert.assertTrue(bottom_next_button.getAttribute("class").endsWith("disabled"),"bottom_next_button is not disabled");
			break;
		}
	}
	
	//To check if last button is enabled if records are less than 100
	public void lastButtonEnable(String checkForClickable) {
		
		switch(checkForClickable) {
		case "yes" :
			logger.log(LogStatus.INFO, "Verifying if top_last_button button is enabled since there are more than 100 records");
			Assert.assertFalse(top_last_button.getAttribute("class").endsWith("disabled"),"top_last_button is not enabled");
			logger.log(LogStatus.INFO, "Verifying if bottom_last_button is enabled since there are more than 100 records");
			Assert.assertFalse(bottom_last_button.getAttribute("class").endsWith("disabled"),"bottom_last_button button is not enabled");	
			break;
		case "no" :
			logger.log(LogStatus.INFO, "Verifying if top_last_button button is disabled since there are less than 100 records");
			Assert.assertTrue(top_last_button.getAttribute("class").endsWith("disabled"),"top_last_button is not disabled");
			logger.log(LogStatus.INFO, "Verifying if bottom_last_button is disabled since there are less than 100 records");
			Assert.assertTrue(bottom_last_button.getAttribute("class").endsWith("disabled"),"bottom_last_button button is not disabled");	
			break;
		}	
	}
	
	//To check if top and bottom level next and last buttons are disabled when records are less than 100
	public void paginationButtonsVerificationForLessThan100Records() {
		
		//query to check records count
		String username = TestBase.getUser_id();;
    	String userId = UserDBUtil.getCTUserId(username);
    	int scorecad_count = ScorecardDBUtil.getScorecardsRecords(userId);
    	
		if(scorecad_count<100) {
			nextButtonEnable("no");
			lastButtonEnable("no");
		}else {
			logger.log(LogStatus.INFO, "records are more than 100");
		}
	}
	
	//To check if top and bottom level next and last buttons are enabled when records are more than 100
	public void paginationButtonsVerificationForMoreThan100Records() {
		
		//query to check records count
		String username = TestBase.getUser_id();
    	String userId = UserDBUtil.getCTUserId(username);
    	int scorecad_count = ScorecardDBUtil.getScorecardsRecords(userId);
		
		if(scorecad_count>100) {
			nextButtonEnable("yes");
			lastButtonEnable("yes");
		}else {
			logger.log(LogStatus.INFO, "records are less than 100");
		}
	}
	
	//To check if available score-card strip is present
    public void availableScoreCardStrip() {
    	Util.waitExecutorForVisibilityOfElement(available_scorecards_strip);
    	logger.log(LogStatus.INFO, "Verifying if available_scorecards_strip is present");
    	Assert.assertTrue(available_scorecards_strip.isDisplayed(), "available_scorecards_strip is not displayed");
    }

    //check table column names
    public void tableColumnNames() {
    	logger.log(LogStatus.INFO, "Verifying table columns of scoreacard table");
    	Boolean flag = Util.collectionComarator(expected_column_names, actual_column_names);
    	Assert.assertEquals(String.valueOf(flag), "true", "scorecard table columns are not matching");
    }
    
    //Add scorecard button
    public void addScorecardButton() {
    	Util.waitExecutorForVisibilityOfElement(add_scorecard_button);
    	add_scorecard_button.click();
    	Assert.assertTrue(create_scorecard_header_label.isDisplayed(), "add_scorecard_button is not working");
    }
    
    //create score card UI
    public void createAndConfigureScoreacrdSectionUI() {
    	
    	SoftAssert softAssert = Util.softAssert();
    	
    	logger.log(LogStatus.INFO, "Verifying if create_scorecard_header_label is displayed");
    	softAssert.assertTrue(create_scorecard_header_label.isDisplayed(), "create_scorecard_header_label is not dispalyed");
    	
    	logger.log(LogStatus.INFO, "Verifying if scorecard_title_label is displayed");
    	softAssert.assertTrue(scorecard_title_label.isDisplayed(), "scorecard_title_label is not dispalyed");    	
    	
    	logger.log(LogStatus.INFO, "Verifying if scorecard_title_textbox is displayed");
    	softAssert.assertTrue(scorecard_title_textbox.isDisplayed(), "scorecard_title_textbox is not dispalyed");    	
    	
    	logger.log(LogStatus.INFO, "Verifying if instructions_label is displayed");
    	softAssert.assertTrue(instructions_label.isDisplayed(), "instructions_label is not dispalyed");
    	
    	logger.log(LogStatus.INFO, "Verifying if instructions_textbox is displayed");
    	softAssert.assertTrue(instructions_textbox.isDisplayed(), "instructions_textbox is not dispalyed");
     	
    	logger.log(LogStatus.INFO, "Verifying if outcome_label_label is displayed");
    	softAssert.assertTrue(outcome_label_label.isDisplayed(), "outcome_label_label is not dispalyed"); 	
    	
    	logger.log(LogStatus.INFO, "Verifying if outcome_label_textbox is displayed");
    	softAssert.assertTrue(outcome_label_textbox.isDisplayed(), "outcome_label_textbox is not dispalyed");
    	
    	logger.log(LogStatus.INFO, "Verifying if available_to_label is displayed");
    	softAssert.assertTrue(available_to_label.isDisplayed(), "available_to_label is not dispalyed");
    	
    	logger.log(LogStatus.INFO, "Verifying if available_to_options");
    	Boolean flag_available_to_options = Util.collectionComarator(exp_available_to_groups_check_uncheck_options, available_to_groups_check_uncheck_options);
    	softAssert.assertEquals(String.valueOf(flag_available_to_options), "true", "available_to_options are not matching");

    	logger.log(LogStatus.INFO, "Verifying if actions_label is displayed");
    	softAssert.assertTrue(actions_label.isDisplayed(), "actions_label is not dispalyed");
    	
    	logger.log(LogStatus.INFO, "Verifying if actions_options");
    	Select actions_options = new Select(actions_listbox);
    	List<WebElement> act_actions_options = actions_options.getOptions();
    	Boolean flag_actions_options = Util.collectionComarator(expected_actions_listbox, act_actions_options);
    	softAssert.assertEquals(String.valueOf(flag_actions_options), "true", "actions options are not matching");

    	logger.log(LogStatus.INFO, "Verifying if criteria_title_label  is displayed");
    	softAssert.assertTrue(criteria_title_label.isDisplayed(), "criteria_title_label is not dispalyed");
    	
    	logger.log(LogStatus.INFO, "Verifying if criteria_title_textbox  is displayed");
    	softAssert.assertTrue(criteria_title_textbox.isDisplayed(), "criteria_title_textbox is not dispalyed");
    	
    	logger.log(LogStatus.INFO, "Verifying if help_text_label  is displayed");
    	softAssert.assertTrue(help_text_label.isDisplayed(), "help_text_label is not dispalyed");
    	
    	logger.log(LogStatus.INFO, "Verifying if help_text_textbox  is displayed");
    	softAssert.assertTrue(help_text_textbox.isDisplayed(), "help_text_textbox is not dispalyed");
    	
    	logger.log(LogStatus.INFO, "Verifying if criteria_type_label  is displayed");
    	softAssert.assertTrue(criteria_type_label.isDisplayed(), "criteria_type_label is not dispalyed");
    	
    	logger.log(LogStatus.INFO, "Verifying criteria_type options");
    	Select criteria_type_options = new Select(criteria_listbox);
    	Boolean flag_criteria_type_options = Util.collectionComarator(expected_criteria_listbox, criteria_type_options.getOptions());
    	softAssert.assertEquals(String.valueOf(flag_criteria_type_options), "true", "criteria_type options are not matching");
    	
    	logger.log(LogStatus.INFO, "Verifying if importance_label  is displayed");
    	softAssert.assertTrue(importance_label.isDisplayed(), "importance_label is not dispalyed");
   
    	logger.log(LogStatus.INFO, "Verifying importance options");
    	Select importance_listbox_options = new Select(importance_listbox);
    	Boolean importance_listbox_flag = Util.collectionComarator(expected_importance_listbox_options, importance_listbox_options.getOptions());
    	softAssert.assertEquals(String.valueOf(importance_listbox_flag), "true", "importance_listbox_options  are not matching");
    	
    	logger.log(LogStatus.INFO, "Verifying if make_this_rerequired_question_label  is displayed");
    	softAssert.assertTrue(make_this_rerequired_question_label.isDisplayed(), "make_this_rerequired_question_label is not dispalyed");    	
    	
    	logger.log(LogStatus.INFO, "Verifying if make_this_rerequired_question_checkbox  is displayed");
    	softAssert.assertTrue(make_this_rerequired_question_checkbox.isDisplayed(), "make_this_rerequired_question_checkbox is not dispalyed");    	
    	
    	logger.log(LogStatus.INFO, "Verifying if pass_label  is displayed");
    	softAssert.assertTrue(pass_label.isDisplayed(), "pass_label is not dispalyed");  
    	
    	logger.log(LogStatus.INFO, "Verifying if pass_checkbox  is displayed");
    	softAssert.assertTrue(pass_checkbox.isDisplayed(), "pass_checkbox is not dispalyed");  

    	logger.log(LogStatus.INFO, "Verifying if fail_label  is displayed");
    	softAssert.assertTrue(fail_label.isDisplayed(), "fail_label is not dispalyed");  

    	logger.log(LogStatus.INFO, "Verifying if fail_checkbox  is displayed");
    	softAssert.assertTrue(fail_checkbox.isDisplayed(), "fail_checkbox is not dispalyed");  
    	
    	logger.log(LogStatus.INFO, "Verifying if add_criteria_button  is displayed");
    	softAssert.assertTrue(add_criteria_button.isDisplayed(), "add_criteria_button is not dispalyed");  
    	
    	logger.log(LogStatus.INFO, "Verifying if save_configure_scorecard_button  is displayed");
    	softAssert.assertTrue(save_configure_scorecard_button.isDisplayed(), "save_configure_scorecard_button is not dispalyed");  
    	
    	logger.log(LogStatus.INFO, "Verifying if cancel_configure_scorecard_button  is displayed");
    	softAssert.assertTrue(cancel_configure_scorecard_button.isDisplayed(), "cancel_configure_scorecard_button is not dispalyed");  
    	
    	softAssert.assertAll();
    }
    
    //To check available to groups are as per DAM
    public void availableToGroupsDAMCheck() {
       	//Opening score card section
    	Util.waitExecutorForVisibilityOfElement(add_scorecard_button);
    	add_scorecard_button.click();
    	Assert.assertTrue(create_scorecard_header_label.isDisplayed(), "Scorecard creation window not opened");
    	
    	//getting available_to_groups from UI
    	List<String> ui_available_to_groups = new ArrayList<String>();
    	List<String> db_available_to_groups = new ArrayList<String>();
    	
    	for(WebElement available_to_group:available_to_groups) {
    		ui_available_to_groups.add(available_to_group.getText().trim());
    	}
    	
    	//getting available_to_groups from db
    	db_available_to_groups = GroupDBUtil.getChildGroups(TestBase.getOrg_unit_id());
    	
    	//verification
    	Collections.sort(ui_available_to_groups);
    	Collections.sort(db_available_to_groups);
        Boolean flag = ui_available_to_groups.equals(db_available_to_groups);
    	Assert.assertEquals(String.valueOf(flag), "true", "Groups dispalyed in available to list are not as per DAM");
    }
    
    //Score card creation  
    public void createScorecard(String type) throws InterruptedException {
    	
    	switch(type) {
    	case "basic":
    		scorecard(1);
    		break;
    	case "all criteria":
    		scorecard(4);
    		break;
    	case "60 criteria":
    		scorecard(60);
    		break;
    	}
    } 
    
    //score card
    public void scorecard(int criteria) throws InterruptedException {
    	
    	//Opening score card section
    	Util.waitExecutorForVisibilityOfElement(add_scorecard_button);
    	add_scorecard_button.click();
    	Assert.assertTrue(create_scorecard_header_label.isDisplayed(), "Scorecard creation window not opened");
    	
    	//Entering score card details
    	scorecard_title_textbox.sendKeys(scorecardTitle);
    	instructions_textbox.sendKeys(instructions);
    	outcome_label_textbox.sendKeys(outcomeLabel);
    	available_to_dropdown.click();
    	for(WebElement available_to_groups_check_uncheck_option:available_to_groups_check_uncheck_options) {
    		if(available_to_groups_check_uncheck_option.getText().trim().equals("Check All")) 
        		Util.Action().moveToElement(available_to_groups_check_uncheck_option).perform();
        		available_to_groups_check_uncheck_option.click();	
        		break;
    	}
    	addCriteria(criteria);
    	
    	//submitting form
        save_configure_scorecard_button.click();
        Assert.assertTrue(success_message_scorecard_creation.isDisplayed(), "scorecard not created successfully");
        Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);
    }
    
    //criteria data set
    public void addCriteria(int noOfCriteria) {
    	
    	Integer[] indexes =  {1,2,3};
    	Integer[] importance = {1,2,3,4,5,6,7,8,9,10};
    	
    	for(int i=0;i<noOfCriteria;i++) {
        	int index = Util.getRandomNumber(indexes);
        	
        	//criteria title
    		criteria_title_textbox.sendKeys(criteriaTitle);
            
    		//help text
    		help_text_textbox.sendKeys(helpText);    
        	Select select = new Select(criteria_listbox);
            
        	//criteria type
        	if(i==0 || i%2==0) {
            	select.selectByVisibleText("Pass/Fail");
            }else {
            	if(index == 1) {
                	select.selectByVisibleText("Scale 0-5");	
            	}else if(index == 2) {
                	select.selectByVisibleText("Scale 0-3");
            	}else {
                	select.selectByVisibleText("Scale 0-10");
            	}
            }
            
        	//importance
        	int index_imp = Util.getRandomNumber(importance);
        	Select imp = new Select(importance_listbox);
        	imp.selectByVisibleText(String.valueOf(importance[index_imp]));
        	
        	//clicking on add criteria button
            if(noOfCriteria>1 && i<noOfCriteria) {
            	add_criteria_button.click();
            }
    	}
    } 
    
    //update score-card
    public void updateScorecard() throws InterruptedException {
    	//Opening score-card section
    	Util.waitExecutorForVisibilityOfElement(add_scorecard_button);
    	add_scorecard_button.click();
    	Assert.assertTrue(create_scorecard_header_label.isDisplayed(), "Scorecard creation window not opened");
    	
    	//Updating score-card details
    	scorecard_title_textbox.sendKeys("updated "+scorecardTitle);
    	
    	//submitting form
        save_configure_scorecard_button.click();
        Assert.assertTrue(success_message_scorecard_updation.isDisplayed(), "scorecard not updated successfully");
        Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);
    }
    
    //delete score-card
    public void deleteScorecard(String scorecard_name) throws InterruptedException {
    	
    	logger.log(LogStatus.INFO, "Verifying a sccorecard is getting archived");
    	clickActionButton(scorecard_name, Constants.ManageScorecardPage.archive_scorecard_button);
    }
    
    //cancel score-card creation
    public void cancelScorecardFeature() {
    	//Opening score-card section
    	Util.waitExecutorForVisibilityOfElement(add_scorecard_button);
    	add_scorecard_button.click();
    	Assert.assertTrue(create_scorecard_header_label.isDisplayed(), "Scorecard creation window not opened");
    	
    	//Entering score-card details
    	scorecard_title_textbox.sendKeys("");
    	instructions_textbox.sendKeys("");
    	outcome_label_textbox.sendKeys("");
    	available_to_dropdown.click();
    	for(WebElement available_to_groups_check_uncheck_option:available_to_groups_check_uncheck_options) {
    		if(available_to_groups_check_uncheck_option.getText().trim().equals("Check All")) 
        		Util.Action().moveToElement(available_to_groups_check_uncheck_option).perform();
        		available_to_groups_check_uncheck_option.click();	
        		break;
    	}
        criteria_title_textbox.sendKeys("");
        help_text_textbox.sendKeys("");
    	
    	//submitting form
        cancel_configure_scorecard_button.click();
        try {
        	Util.customWait(success_message_scorecard_creation);       	
        }catch(Exception e) {
        	logger.log(LogStatus.PASS, "");
        }

    }
    
    //create score card Validation -- score card creation without mandatory fields 
    public void scorecardCreationWithoutMandatoryFields() throws InterruptedException {
    	
    	//Opening score card section
    	Util.waitExecutorForVisibilityOfElement(add_scorecard_button);
    	add_scorecard_button.click();
    	Assert.assertTrue(create_scorecard_header_label.isDisplayed(), "Scorecard creation window not opened");
    	
    	//Entering score card details
//    	scorecard_title_textbox.sendKeys(scorecardTitle);
    	instructions_textbox.sendKeys(instructions);
    	outcome_label_textbox.sendKeys(outcomeLabel);
    	available_to_dropdown.click();
    	for(WebElement available_to_groups_check_uncheck_option:available_to_groups_check_uncheck_options) {
    		if(available_to_groups_check_uncheck_option.getText().trim().equals("Check All")) 
        		Util.Action().moveToElement(available_to_groups_check_uncheck_option).perform();
        		available_to_groups_check_uncheck_option.click();	
        		break;
    	}
    	addCriteria(1);
    	
    	//submitting form
        save_configure_scorecard_button.click();
        Assert.assertTrue(alert_message_scorecard_creation.isDisplayed(), "alert_message_scorecard_creation is not dispalyed");
        Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);
    }
    
    //create score card Validation 
    public void createScorecardValidations(String validation) throws InterruptedException {
    	
    	switch(validation) {
    	case "cancelFeature":
    		cancelScorecardFeature();
    		break;
    	case "checkaAllGroups":
    		checkAllGroups();
    		break;
    	case "uncheckAllGroups":
    		uncheckAllGroups();
    		break;
    	case "skipMandatoryFields":
    		scorecardCreationWithoutMandatoryFields();
    		break;
    	}
    }
    
    //create score card Validation -- to verify check all groups in available to 
    public void checkAllGroups() {
    	//Opening score card section
    	Util.waitExecutorForVisibilityOfElement(add_scorecard_button);
    	add_scorecard_button.click();
    	Assert.assertTrue(create_scorecard_header_label.isDisplayed(), "Scorecard creation window not opened");
    	
    	//checking all groups
    	available_to_dropdown.click();
    	for(WebElement available_to_groups_check_uncheck_option:available_to_groups_check_uncheck_options) {
    		if(available_to_groups_check_uncheck_option.getText().trim().equals("Check All")) 
        		Util.Action().moveToElement(available_to_groups_check_uncheck_option).perform();
        		available_to_groups_check_uncheck_option.click();	
        		break;
    	}
    	
    	//verifying if all groups are checked
    	int checkCounter = 0;
    	for(WebElement available_to_group_checkbox:available_to_group_checkboxes) {
    		if(!available_to_group_checkbox.getAttribute("checked").trim().equals("checked")) {
    			checkCounter++;
    			break;
    		}else continue;
    	}
    	
    	Assert.assertTrue(checkCounter<1,"All groups are not checked");
    }
    
    //create score card Validation -- to verify uncheck all groups in available to 
    public void uncheckAllGroups() {
    	//Opening score card section
    	Util.waitExecutorForVisibilityOfElement(add_scorecard_button);
    	add_scorecard_button.click();
    	Assert.assertTrue(create_scorecard_header_label.isDisplayed(), "Scorecard creation window not opened");
    	
    	//checking all groups
    	available_to_dropdown.click();
    	for(WebElement available_to_groups_check_uncheck_option:available_to_groups_check_uncheck_options) {
    		if(available_to_groups_check_uncheck_option.getText().trim().equals("Check All")) 
        		Util.Action().moveToElement(available_to_groups_check_uncheck_option).perform();
        		available_to_groups_check_uncheck_option.click();	
        		break;
    	}
    	
    	//Unchecking all groups
    	available_to_dropdown.click();
    	for(WebElement available_to_groups_check_uncheck_option:available_to_groups_check_uncheck_options) {
    		if(available_to_groups_check_uncheck_option.getText().trim().equals("Uncheck All")) 
        		Util.Action().moveToElement(available_to_groups_check_uncheck_option).perform();
        		available_to_groups_check_uncheck_option.click();	
        		break;
    	}
    	
    	//verifying if all groups are checked
    	int checkCounter = 0;
    	for(WebElement available_to_group_checkbox:available_to_group_checkboxes) {
    		if(available_to_group_checkbox.getAttribute("checked").trim().equals("checked")) {
    			checkCounter++;
    			break;
    		}else continue;
    	}
    	
    	Assert.assertTrue(checkCounter<1,"All groups are not unchecked");
    }
    
    //create score card Validation -- to verify deleting criteria 
    public void deleteCriteria() {
    	
    }
    
    
}
