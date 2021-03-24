package pom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import dbUtil.CallUtil;
import dbUtil.ScorecardDBUtil;
import dbUtil.UserDBUtil;
import tests.TestBase;
import tests.Util;
import utilConstants.UtilityConstants;

public class SelectAndScorePage extends TestBase {

	@FindBy(xpath="//div[@ class='pageProgressLoader']")
	private WebElement loadingWheel;
	
	@FindBy(xpath="//h1[contains(text(),'Select and Score')]")
	private WebElement header_label;
	
	@FindBy(xpath="//h4[contains(text(),'Calls count on this page may differ from Reports.')]")
	private WebElement header_note;		
	String expected_call_count_note="Calls count on this page may differ from Reports. Reports strictly follow the user permission settings and filter calls according to the groups users are assigned to. The Scorecard feature allows a user to be assigned calls that are part of a group the user does not have access to.";

	//date range filter
	@FindBy(xpath="//div[@class='options']//button")
	private WebElement date_range_filter_button;
	
	@FindBy(xpath="//div[@class='daterangepicker dropdown-menu opensleft']//button[text()='OK']")
	private WebElement date_range_filter_ok_button;

	@FindBy(xpath="//div[@class='daterangepicker dropdown-menu opensleft']//button[text()='Cancel']")
	private WebElement date_range_filter_cancel_button;
	
	@FindBy(xpath="//div[@class='daterangepicker dropdown-menu opensleft']//ul//li")
	private List<WebElement> actual_date_filter_elements;		
	String[] expected_date_filter_elements={"Today","Yesterday","Last 7 Days","Last 30 Days","This Month","Last Month","Custom Range"};
	
	@FindBy(xpath="//div[@class='daterangepicker dropdown-menu opensleft']//div[@class='calendar left']")
	private WebElement date_range_filter_left_calender;
	
	@FindBy(xpath="//div[@class='daterangepicker dropdown-menu opensleft']//div[@class='calendar right']")
	private WebElement date_range_filter_right_calender;
	
	@FindBy(xpath="(//span[text()='Export']//parent::button[@aria-hidden='false'])")
	private WebElement export_button;
	
	//notification section
	@FindBy(xpath="//button[text()=' Notifications']")
	private WebElement notifications_button;	

	@FindBy(xpath="//h3[@class='modal-title' and text()='Score Notifications']")
	private WebElement score_notifications_label;
	
	@FindBy(xpath="//label[text()='Select action when you want to get a notification']")
	private WebElement score_notifications_header_note;

	@FindBy(xpath="//div[@class='timeline-header']//span[text()=' Action']")
	private WebElement score_notifications_action_label;
	
	@FindBy(xpath="//h3[text()='If']")
	private WebElement score_notifications_condition_label;
	
	@FindBy(xpath="//h3[text()='If']/..//following-sibling::div//select")
	private WebElement score_notifications_condition_listbox;
	
	@FindBy(xpath="//h3[text()='Then']")
	private WebElement score_notifications_then_label;
	
	@FindBy(xpath="//h3[text()='Then']/..//following-sibling::div//select")
	private WebElement score_notifications_then_listbox;
	
	@FindBy(xpath="//h3[text()='Then']/..//following-sibling::div//div[@aria-hidden='false']//input")
	private WebElement score_notifications_then_textbox;
	
	@FindBy(xpath="//div[@class='timeline-footer text-right']//a[text()='Add Action'][@aria-hidden='false']")
	private WebElement score_notifications_add_action_button;
	
	@FindBy(xpath="//div[@class='ui-pnotify ']//div[text()='Notification Action deleted successfully']")
	private WebElement score_notifications_delete_action_success_message;
	
	@FindBy(xpath="//a[starts-with(@ng-click,'removeScoreNotifications')]")
	private List<WebElement> score_notifications_delete_action_button;
	
	@FindBy(xpath="//div[@class='modal-footer']//button[text()='OK']")
	private WebElement score_notifications_delete_action_alert_ok_button;
	
	@FindBy(xpath="//div[@class='modal-footer']//button[text()='Cancel']")
	private WebElement score_notifications_delete_action_alert_cancel_button;
	
	@FindBy(xpath="//h3[@class='modal-title']//following-sibling::button")
	private WebElement score_notifications_condition_close_button;

	@FindBy(xpath="//div[starts-with(@class,'modal-body')]//button[text()='Cancel']")
	private WebElement score_notifications_cancel_button;
	
	@FindBy(xpath="//div[starts-with(@class,'modal-body')]//button[text()='Save']")
	private WebElement score_notifications_save_button;

	@FindBy(xpath="//div[@class='ui-pnotify ']//div[text()='Notification Actions saved successfully']")
	private WebElement success_message_notifications;	
	
	//status filters
	@FindBy(xpath="//div[text()='Filter by Status:']")
	private WebElement filter_status_label;		
	
	@FindBy(xpath="//div[text()='Filter by Status:']//parent::form//label")
	private List<WebElement> status_filter_labels;		
	String[] expected_status_filter_labels={"Need Scorecard","Unscored","Scored","Reviewed"};

	@FindBy(xpath="//div[text()='Filter by Status:']//parent::form//label/input")
	private List<WebElement> status_filter_checkboxes;		
	
	//----------------------------------------------------------------------------------
//	@FindBy(xpath="//div[text()='Filter by Status:']//parent::form//label[text()='"+status+"']/input")
//	private WebElement filter_status_checkbox;		
	
	@FindBy(xpath="//table[@id='scoredetailtable']//thead//tr[1]//th")
	private List<WebElement> actual_columns_names;			
	String[] expected_columns_names = {"Play Call","Status","Date/Time","Duration","Group","Identified Agent","Call Title","Scorecard","Score Date","Score","Actions"};
	
	//-------------------------------------------------------------
	//get index ==>
//	@FindBy(xpath="//table[@id='scoredetailtable']//thead//tr[1]//th")
//	private WebElement index;	

//	@FindBy(xpath="//table[@id='scoredetailtable']//tbody//tr//td["+index+"]")
//	private WebElement column_values;	

	//-------------------------------------------------------------
	
	//audio player
	@FindBy(xpath="//button[@ class='iconButton play']")
	private WebElement play_pause_audio_button;	

	@FindBy(xpath="//button[@class='iconButton level3']")
	private WebElement mute_unmute_audio_button;
		
	//Email call section
    @FindBy(xpath="//div[contains(text(),'Successfully emailed call')]")
	private static WebElement success_message_for_mail_call;
    
    @FindBy(xpath="//div[@class='modal-content']")
	private static WebElement email_this_call_window;
    
    @FindBy(xpath="//div[@class='modal-content']//h3[text()='Email this call']")
 	private static WebElement email_this_call_label;

    @FindBy(xpath="//div[@class='modal-content']//label[text()='To']")
 	private static WebElement email_this_call_to_label;

    @FindBy(xpath="//div[@class='modal-content']//label[text()='To']//parent::div//following-sibling::div//input")
 	private static WebElement email_this_call_to_textbox;
    
    @FindBy(xpath="//div[@class='modal-content']//label[text()='From']")
 	private static WebElement email_this_call_from_label;

    @FindBy(xpath="//div[@class='modal-content']//label[text()='From']//parent::div//following-sibling::div//input")
 	private static WebElement email_this_call_from_textbox;
    
    @FindBy(xpath="//div[@class='modal-content']//label[text()='Message']")
 	private static WebElement email_this_call_message_label;

    @FindBy(xpath="//div[@class='modal-content']//label[text()='Message']//parent::div//following-sibling::div//textarea")
 	private static WebElement email_this_call_message_textbox;

    @FindBy(xpath="//div[@class='modal-content']//button[text()='Send Now']")
 	private static WebElement send_now_mail_button;

    @FindBy(xpath="//div[@class='modal-content']//button[text()='Cancel']")
 	private static WebElement cancel_mail_button;
	
    //i section
	@FindBy(xpath="//div[@class='tab-content']")
	private static WebElement inforamtion_tab;	
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']//li//span[text()='Info']")
	private static WebElement info_button;
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']//li//span[text()='Comments']")
	private static WebElement comments_button;
	
	@FindBy(xpath="//ul[@class='nav nav-tabs']//li//span[text()='Tags']")
	private static WebElement tags_button;
    
	//info section
	@FindBy(xpath="//div[@class='tab-content']//strong")
	private static List<WebElement> inforamtion_section_labels;
	String[] expected_inforamtion_section={"Name and Address","Conversation","Session"};
	
	@FindBy(xpath="//div[@class='advancedf']//select[1]")
	private WebElement include_exclude_listbox;
	String[] exp_include_exclude_listbox_options = {"Include", "Exclude"};
	
	//tags section
	@FindBy(xpath="//form[@name='calltagForm']")
	private static WebElement tag_section;

	@FindBy(xpath="//form[@name='calltagForm']//div//label[contains(text(),'Select Tags:')]")
	private static WebElement select_tags_label;

	@FindBy(xpath="//form[@name='calltagForm']//div//input[@title='Save Call Tag Button']")
	private static WebElement save_tag_button;

	@FindBy(xpath="//form[@name='calltagForm']//div//ul[@class='select2-choices']")
	private static WebElement tag_textbox;

	//comments section
	@FindBy(xpath="//form[@id='commentForm']")
	private static WebElement comment_section;		

	@FindBy(xpath="//form[@id='commentForm']//div//label[contains(text(),'Comment:')]")
	private static WebElement comment_label;			

	@FindBy(xpath="//form[@id='commentForm']//div//textarea[@name='commenttext']")
	private static WebElement comment_textbox;
	
	@FindBy(xpath="//form[@id='commentForm']//div//input")
	private static WebElement add_comment_button;
	
	//advanced filter
	@FindBy(xpath="//button[text()='Advanced filter']")
	private WebElement advanced_filter_button;
	
	@FindBy(xpath="//div[@class='advancedf']//select[2]")
	private WebElement advanced_filter_element_listbox;
	String[] exp_advanced_filter_element_listbox_options = {"-- Select --", "Duration", "Group", "Identified Agent", "Scorecard", "Score", "Call Title", "Tag", "Comments"};

	@FindBy(xpath="//div[@class='advancedf']//select[3]")
	private WebElement advanced_filter_operator_listbox;

	@FindBy(xpath="//div[@class='advancedf']//select[3]//following-sibling::input[1]")
	private WebElement advanced_filter_value_textbox;

	@FindBy(xpath="(//span[starts-with(@id,'select2-chosen')])[2][contains(text(),'-- Select --')]/..")
	private WebElement advanced_filter_identified_agent_dropdown;

	@FindBy(xpath="//ul[@class='select2-results']//li")
	private List<WebElement> avaialble_identified_agents_list;
	
	@FindBy(xpath="//ul[@class='select2-results']//li")
	private List<WebElement> avaialble_scoredcard_list;
	
	@FindBy(xpath="(//span[starts-with(@id,'select2-chosen')])[2][contains(text(),'-- Select --')]/..")
	private WebElement advanced_filter_scorecard_dropdown;

	@FindBy(xpath="//button[@class='btn btn-gray'][text()=' Add an Advanced Filter']")
	private WebElement add_an_advanced_filter_button;
	
	@FindBy(xpath="//button[text()='Apply']")
	private WebElement apply_advanced_filter_button;
	
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancel_advanced_filter_button;

	//confirmation messages
	@FindBy(xpath="//div[@class='ui-pnotify ']//div[@class='ui-pnotify-sticker']")
	private WebElement pause_button_success_message;

	@FindBy(xpath="//div[@class='ui-pnotify ']//div[@class='ui-pnotify-closer']")
	private WebElement close_button_success_message;
	
	@FindBy(xpath="//div[@class='ui-pnotify ']//div[text()='Identified Agent is added successfully.']")
	private WebElement success_msg_for_agent_assigned;

	@FindBy(xpath="//div[@class='ui-pnotify ']//div[text()='Identified Agent is updated successfully.']")
	private WebElement success_msg_for_agent_updated;

	//-------------------------------------------------------------------------------------------------
	@FindBy(xpath="//button[@class='btn btn-primary'][contains(text(),'OK')]")
	private WebElement ok_button_for_agent_update;

	@FindBy(xpath="//button[@class='btn btn-default'][contains(text(),'cancel')]")
	private WebElement cancel_button_for_agent_update;
	//-------------------------------------------------------------------------------------------------
	
	@FindBy(xpath="//div[@class='ui-pnotify ']//div[text()='Call Title is added successfully.']")
	private WebElement success_msg_for_call_title_added;

	@FindBy(xpath="//div[@class='ui-pnotify ']//div[text()='Call Title is updated successfully.']")
	private WebElement success_msg_for_call_title_updated;
	
	@FindBy(xpath="//div[@class='ui-pnotify ']//div[text()='Scorecard is added successfully.']")
	private WebElement success_msg_for_scorecard_assignment;

	@FindBy(xpath="//div[@class='ui-pnotify ']//div[text()='Scorecard is updated successfully.']")
	private WebElement success_msg_for_scorecard_update;

	@FindBy(xpath="//div[@class='ui-pnotify ']//div[contains(text(),'updated successfully.')]")
	private WebElement success_msg_for_call_record_update;
	
	@FindBy(xpath="")
	private WebElement success_msg_for_call_score;
	
	@FindBy(xpath="//div[@class='ui-pnotify ']//div[text()='Call Scores updated successfully.']")
	private WebElement success_msg_for_call_score_update;
	
	@FindBy(xpath="//div[@class='ui-pnotify ']//div[text()='Call Reviewed successfully.']")
	private WebElement success_msg_for_call_score_review;
	
	@FindBy(xpath="//div[@class='ui-pnotify ']//div[text()='Please make sure you have answered all mandatory questions before clicking on Done button']")
	private WebElement alert_msg_for_missing_mandatory_criteria_answeres;
	
	//scoring section
	@FindBy(xpath="//div[@class='criteriaProgressLoader']")
	private WebElement criteria_loader;
	
	@FindBy(xpath="//strong[contains(text(),'Score :')]")
	private WebElement score_label;		

	@FindBy(xpath="//strong[contains(text(),'Score :')]//parent::span//i")
	private WebElement download_pdf_link;
	
	@FindBy(xpath="//h2[@class='critreriaclass ng-binding']")
	private WebElement scorecard_title;	

	@FindBy(xpath="//strong[contains(text(),'Criteria :')]")
	private WebElement criteria_label;	

	@FindBy(xpath="//div[@class='container-fluid']//ul//li//span[text()='*' and @aria-hidden='false']//ancestor::li//div[@aria-hidden='false']//div[contains(@id,'passcheck')]//input")
	private List<WebElement> pass_checkboxes_mandatory;	

	@FindBy(xpath="//div[@class='container-fluid']//ul//li//span[text()='*' and @aria-hidden='true']//ancestor::li//div[@aria-hidden='false']//div[contains(@id,'passcheck')]//input")
	private List<WebElement> pass_checkboxes_optional;
	
	@FindBy(xpath="//div[@class='container-fluid']//ul//li//span[text()='*' and @aria-hidden='false']//ancestor::li//div[@aria-hidden='false']//div[contains(@id,'failCheck')]//input")
	private List<WebElement> fail_checkboxes_mandatory;
	
	@FindBy(xpath="//div[@class='container-fluid']//ul//li//span[text()='*' and @aria-hidden='true']//ancestor::li//div[@aria-hidden='false']//div[contains(@id,'failCheck')]//input")
	private List<WebElement> fail_checkboxes_optional;

	@FindBy(xpath="//div[@class='container-fluid']//ul//li//span[text()='*' and @aria-hidden='false']//ancestor::li//div[@aria-hidden='false']//div[contains(@id,'naCheck')]//input")
	private List<WebElement> na_checkboxes_mandatory;
	
	@FindBy(xpath="//div[@class='container-fluid']//ul//li//span[text()='*' and @aria-hidden='true']//ancestor::li//div[@aria-hidden='false']//div[contains(@id,'naCheck')]//input")
	private List<WebElement> na_checkboxes_optional;

	//--------------------scale checkboxes----------------------
//	@FindBy(xpath="//div[@class='container-fluid']//ul//li//span[text()='*' and @aria-hidden='true']//ancestor::li//div[@aria-hidden='false']//div[contains(@class,'radio-inline')]//label[contains(text(),'"+scale_value+"')]/..//input")
//	private List<WebElement> scale_checkboxes_optional;
	
//	@FindBy(xpath="//div[@class='container-fluid']//ul//li//span[text()='*' and @aria-hidden='false']//ancestor::li//div[@aria-hidden='false']//div[contains(@class,'radio-inline')]//label[contains(text(),'"+scale_value+"')]/..//input")
//	private List<WebElement> scale_checkboxes_mandatory;
	//--------------------------------------------------------
	
	@FindBy(xpath="//div[@id='scorecardarea2']//strong")
	private WebElement outcome_label;
	
	@FindBy(xpath="//div[@class='container-fluid']//li//span[starts-with(text(),'Importance')]")
	private WebElement importance_label;

	@FindBy(xpath="//div[@id='scorecardarea2']//input[1]")
	private WebElement outcome_yes_checkbox;

	@FindBy(xpath="//div[@id='scorecardarea2']//input[2]")
	private WebElement outcome_no_checkbox;
	
	@FindBy(xpath="//button[text()='Done']")
	private WebElement done_button_scoring_section;
	
	@FindBy(xpath="//button[text()='Update Score']")
	private WebElement update_score_button_scoring_section;
	
	@FindBy(xpath="//div[@class='container-fluid']//button[text()='Review']")
	private WebElement review_button_scoring_section;

	@FindBy(xpath="//button[text()='Done']//preceding-sibling::button")
	private WebElement cancel_button_scoring_section;
	
	//pagination tool box - top ------------------------
	@FindBy(xpath="(//button[contains(text(),'First')])[1]")
	private static WebElement top_first_button;	
		
	@FindBy(xpath="(//button[contains(text(),'Last')])[1]")
	private static WebElement top_last_button;
		
	@FindBy(xpath="(//button[contains(text(),'Prev')])[1]")
	private static WebElement top_prev_button;	
		
	@FindBy(xpath="(//button[contains(text(),'Next')])[1]")
	private static WebElement top_next_button;
	
	//pagination tool box - bottom -----------------------------------------------
	@FindBy(xpath="(//button[contains(text(),'First')])[2]")
	private static WebElement bottom_first_button;	

	@FindBy(xpath="(//button[contains(text(),'Last')])[2]")
	private static WebElement bottom_last_button;	

	@FindBy(xpath="(//button[contains(text(),'Prev')])[2]")
	private static WebElement bottom_prev_button;	

	@FindBy(xpath="(//button[contains(text(),'Next')])[2]")
	private static WebElement bottom_next_button;

	//pagination count
	@FindBy(xpath="(//button[contains(text(),'Showing')])[1]")
	private static WebElement top_pagination_count;
	
	@FindBy(xpath="(//button[contains(text(),'Showing')])[2]")
	private static WebElement bottom_pagination_count;

	@FindBy(xpath="//table[@id='scoredetailtable']//tbody//tr")
	private static List<WebElement> call_count_in_table;
	
	@FindBy(xpath="//table[@id='scoredetailtable']//td[text()='No Data Found']")
	private static WebElement no_data_found_label;

	//edited call
	@FindBy(xpath="//table[@id='scoredetailtable']//tbody//tr//td//select[@name='identifyAgent']")
	private static WebElement identified_agent_listbox_edited_call;
	
	@FindBy(xpath="//table[@id='scoredetailtable']//tbody//tr//td//select[@name='selectedScorecard']")
	private static WebElement scorecard_listbox_edited_call;

	@FindBy(xpath="//table[@id='scoredetailtable']//tbody//tr//td//input[@name='call_title']")
	private static WebElement call_title_edited_call;
	
	@FindBy(xpath="//table[@id='scoredetailtable']//form[starts-with(@class,'form-buttons') and @aria-hidden='false']//button[text()='Save']")
	private static WebElement save_button_edited_call;
	
	@FindBy(xpath="//table[@id='scoredetailtable']//form[starts-with(@class,'form-buttons') and @aria-hidden='false']//button[text()='Cancel']")
	private static WebElement cancel_button_edited_call;
	
	@FindBy(xpath="//div[@class='bootbox-body']")
	private static WebElement edit_call_alert;
	
		
	public SelectAndScorePage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	
	//to check expected filter status check box 
    public void selectScorecardStatusCheckbox(String status){
		WebElement status_checkbox = driver.findElement(By.xpath("//div[text()='Filter by Status:']//parent::form//label[text()='"+status+"']/input"));
		status_checkbox.click();
	}
    
	public void pageLoadWait() {
		Util.waitExecutorForInVisibilityOfElement(loadingWheel);
	}
    
	//To click on action button
    public void actionButtonClick(String button_name) {
    	
    	WebElement action_button = null;
    	
    	//getting element to click
    	switch(button_name) {
    	case "play":
    		action_button= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//tr//td[1]//button[@title='Listen to call'][@aria-disabled='false'])[1]"));
    		break;
    	case "i":
    		action_button= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//tr//td//button[@title='Toggle Call Info'])[1]"));
    		break;
    	case "edit":
    		action_button= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//tr//td//button//i[contains(@class,'edit')])[1]"));
    		break;
    	case "download":
    		action_button= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//tr//td//button[@title='Download Audio File'])[1]"));
    		break;
    	case "mail":
    		action_button= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//tr//td//button[@title='Email Call'])[1]"));     		
    		break;	
    	}
    	
    	//clicking action
    	Util.click(action_button);
    }
    
    //To click on info section buttons
    public void infoSectionButtonsClick(String buttonName) throws InterruptedException {
    	Thread.sleep(1000);
    	WebElement infSectionButtonsToClick = driver.findElement(By.xpath("//ul[@class='nav nav-tabs']//li//span[text()='"+buttonName+"']"));
    	Util.Action().moveToElement(infSectionButtonsToClick).click().perform();
    }
    
    public int getIndexForFilter(String filterElement) {
    	int index = 0;
    	
    	for(int i=0;i<actual_columns_names.size();i++) {
    		if(actual_columns_names.get(i).getText().trim().equals(filterElement)) {
    			index = i+1;	
    			break;
    		}
    		
    	}
		return index;
    }
    
    //getting value to be filtered
    public String getValueToBeFiltered(String filterElement) {
    	int index = 0;
    	String valueTobeFiltered = null;
    	
    	//getting column index
    	index = getIndexForFilter(filterElement);
   
    	//getting value to be filtered
    	List<WebElement> values = driver.findElements(By.xpath("//table[@id='scoredetailtable']//tbody//tr//td["+index+"]"));
    	if(!values.isEmpty()) {
    		for(int i=0;i<values.size();i++) {
    			if(!values.get(i).getText().isEmpty()) {
    				valueTobeFiltered = values.get(i).getText().trim();
    			    break;    				
    			}
    		}
    	}else
    		valueTobeFiltered = "null";

    	if(filterElement.equals("Duration")) {
    		String[] seconds = valueTobeFiltered.split(":");
    		int totalSeconds = 0;
    		for(int i=0;i<seconds.length;i++) {
    			totalSeconds = totalSeconds + Integer.parseInt(seconds[i]);
    		}
    		valueTobeFiltered = String.valueOf(totalSeconds);
    	}else if (filterElement.equals("Score")) {
    		if(valueTobeFiltered.equals("Score Now")) {
    			valueTobeFiltered = "0";
    		}else
        		valueTobeFiltered = Util.getNumberFromAlphanumeric(valueTobeFiltered);
    	}

		return valueTobeFiltered;	
    }
    
    //getting score card status link 
    public String callStatusLink(String status) {
    	String link = null;
    	String iconsLib = "https://"+TestBase.getEnv()+"-cmo-1.convirza.com/img/icons";
    	
    	switch(status) {
    	case "Need Scorecard":
    		link = ""+iconsLib+"/needscorecard.png";
    		break;
    	case "Unscored":
    		link = ""+iconsLib+"/unscored.png";
    		break;
    	case "Scored":
    		link = ""+iconsLib+"/scored.png";
    		break;
    	case "Reviewed":
    		link = ""+iconsLib+"/reviewed.png";
    		break;
    	}
		return link;
    }
    
    //getting score card status 
    public String callStatus(String link) {
    	String status = null;
    	String iconsLib = "https://"+TestBase.getEnv()+"-cmo-1.convirza.com/img/icons";
    	
    	if(link.equals(iconsLib+"/needscorecard.png")) 
    		status = "Need Scorecard";
    	else if(link.equals(iconsLib+"/unscored.png"))
    		status = "Unscored";
    	else if(link.equals(iconsLib+"/scored.png"))
    		status = "Scored";
    	else if (link.equals(iconsLib+"/reviewed.png"))
    		status = "Reviewed";
    	
		return status;
    }
    
    //--------------------------------------------------UI---------------------------------------------------------------------------
    
    //Header label on page
    public void pageLabel() {
    	logger.log(LogStatus.INFO, "Verifying if pageLabel is displayed");
    	Util.waitExecutorForVisibilityOfElement(header_label);
    	Assert.assertTrue(header_label.isDisplayed(), "header label is not displayed");
    }
    
    //Header Note on page
    public void headerNote() {
    	logger.log(LogStatus.INFO, "Verifying if headerNote is displayed");
    	Util.waitExecutorForVisibilityOfElement(header_note);
    	Assert.assertTrue(header_note.isDisplayed(), "header label is not displayed");
    }
    
    //Header Note content on page
    public void headerNoteContent() {
    	logger.log(LogStatus.INFO, "Verifying if headerNoteContent");
    	Util.waitExecutorForVisibilityOfElement(header_note);
    	String actHeaderNoteConetnt = header_note.getText();
    	String expHeaderNoteConetnt = expected_call_count_note;
    	Assert.assertEquals(actHeaderNoteConetnt, expHeaderNoteConetnt, "Expected headerNoteContent not displayed");
    }
    
    //Notification Button
    public void notificationButton() {
    	logger.log(LogStatus.INFO, "Verifying if notificationButton is displayed");
    	Util.waitExecutorForVisibilityOfElement(notifications_button);
    	Assert.assertTrue(notifications_button.isDisplayed(), "notifications_button is not displayed");
    	
    	logger.log(LogStatus.INFO, "Verifying if notificationButton is clickable");
    	Assert.assertTrue(notifications_button.isEnabled(), "notifications_button is not clickable");
    }
    
    //Export Button
    public void exportButton() {
    	logger.log(LogStatus.INFO, "Verifying if export_button is displayed");
    	Util.waitExecutorForVisibilityOfElement(export_button);
    	Assert.assertTrue(export_button.isDisplayed(), "export_button is not displayed");
    	
    	logger.log(LogStatus.INFO, "Verifying if export_button is clickable");
    	Assert.assertTrue(export_button.isEnabled(), "export_button is not clickable");
    }
    
    //To check UI of pagination tool-box at the top
	public void paginationToolboxTop() {
    	logger.log(LogStatus.INFO, "Verifying if top_first_button button is displayd");
    	Util.waitExecutorForVisibilityOfElement(top_first_button);
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
	
	//Advance filter Button
	public void advanceFilterButton() {
    	SoftAssert softassert = Util.softAssert();
		logger.log(LogStatus.INFO, "Verifying if advanced filter button is displayed");
		softassert.assertTrue(advanced_filter_button.isDisplayed(), "advanced filter button is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if advanced filter button is clickable");
		softassert.assertTrue(advanced_filter_button.isEnabled(), "advanced filter button is not clickable");
		softassert.assertAll();
	}
	
	//To check UI of advance filter
	public void advanceFilterUI() {
    	SoftAssert softassert = Util.softAssert();
    	//opening advanced filter section
		advanced_filter_button.click();
    	
    	logger.log(LogStatus.INFO, "Verifying if include listbox is displayed");
    	softassert.assertTrue(include_exclude_listbox.isDisplayed(), "include listbox is not displayed");
    	
    	logger.log(LogStatus.INFO, "Verifying if advanced_filter_element_listbox is displayed");
    	softassert.assertTrue(advanced_filter_element_listbox.isDisplayed(), "advanced_filter_element_listbox is not displayed");
    	
    	logger.log(LogStatus.INFO, "Verifying if apply_advanced_filter_button is displayed");
    	softassert.assertTrue(apply_advanced_filter_button.isDisplayed(), "apply_advanced_filter_button is not displayed");
    	
    	logger.log(LogStatus.INFO, "Verifying if cancel_advanced_filter_button is displayed");
    	softassert.assertTrue(cancel_advanced_filter_button.isDisplayed(), "cancel_advanced_filter_button is not displayed");
    	
    	logger.log(LogStatus.INFO, "Verifying if add_an_advanced_filter_button is displayed");
    	softassert.assertTrue(add_an_advanced_filter_button.isDisplayed(), "add_an_advanced_filter_button is not displayed");
    	
    	//options in include exclude list box
    	logger.log(LogStatus.INFO, "Verifying include exclude listbox options");
    	Select includeExcludeListbox = new Select(include_exclude_listbox);
    	Boolean includeExcludeListboxFlag = Util.collectionComarator(exp_include_exclude_listbox_options, includeExcludeListbox.getOptions());
    	softassert.assertEquals(String.valueOf(includeExcludeListboxFlag), "true", "include exclude listbox options are not dispalyed");

    	//options in select list box
    	logger.log(LogStatus.INFO, "Verifying select listbox options");
    	Select advancedFilterElementListbox = new Select(advanced_filter_element_listbox);
    	Boolean advancedFilterElementListboxFlag = Util.collectionComarator(exp_advanced_filter_element_listbox_options, advancedFilterElementListbox.getOptions());
    	softassert.assertEquals(String.valueOf(advancedFilterElementListboxFlag), "true", "select listbox options are not dispalyed");
    	
    	softassert.assertAll();
    	//closing advanced filter section
    	cancel_advanced_filter_button.click();
	}
	
	//Filter by status
	public void filterByStatus() {
    	SoftAssert softassert = Util.softAssert();
    	
		logger.log(LogStatus.INFO, "Verifying if filter_status_label is displayed");
		softassert.assertTrue(filter_status_label.isDisplayed(), "filter_status_label is not displayed");

		logger.log(LogStatus.INFO, "Verifying if all filter status are displayed");
		Boolean statusFilterLabelsFlag = Util.collectionComarator(expected_status_filter_labels, status_filter_labels);
		softassert.assertEquals(String.valueOf(statusFilterLabelsFlag), "true", "status_filter_labels are not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if all filter status checkboxes are clickable");
		for(WebElement status_filter_checkbox:status_filter_checkboxes) {
			softassert.assertTrue(status_filter_checkbox.isEnabled());
		}
		softassert.assertAll();
	}
	
	//Score calls table columns
	public void tableColumns() {    	
		logger.log(LogStatus.INFO, "Verifying if all table columns are displayed");
		Boolean tableColumnNamesFlag = Util.collectionComarator(expected_columns_names, actual_columns_names);
		Assert.assertEquals(String.valueOf(tableColumnNamesFlag), "true", "all table columns are not displayed");
	}
	
	//Date Range filter
	public void dateRangeFilter() {    	
		logger.log(LogStatus.INFO, "Verifying if dateRangeFilter is displayed");
		Assert.assertTrue(date_range_filter_button.isDisplayed(), "dateRangeFilter is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if dateRangeFilter is clickable");
		Assert.assertTrue(date_range_filter_button.isEnabled(), "dateRangeFilter is not clickable");
	}
	
	//Date Range filter UI
	public void dateRangeFilterUI() {    	
    	SoftAssert softassert = Util.softAssert();
    	
    	//opening date range filter section
    	Util.Action().moveToElement(date_range_filter_button).click().perform();   
    	
    	logger.log(LogStatus.INFO, "Verifying all date range filter elements are displayed");
    	Boolean actualDateFilterElementsFlag = Util.collectionComarator(expected_date_filter_elements, actual_date_filter_elements);    	
    	softassert.assertEquals(String.valueOf(actualDateFilterElementsFlag), "true", "all date range filter elements are not displayed");

    	logger.log(LogStatus.INFO, "Verifying all date range filter elements are clickable");
    	for(WebElement actual_date_filter_element:actual_date_filter_elements) {
    		softassert.assertTrue(actual_date_filter_element.isEnabled(), "");
    	}
    	
    	logger.log(LogStatus.INFO, "Verifying if OK button is displayed");
    	softassert.assertTrue(date_range_filter_ok_button.isDisplayed(), "date_range_filter_ok_button is not displayed");
    	
    	logger.log(LogStatus.INFO, "Verifying if OK button is clickable");
    	softassert.assertTrue(date_range_filter_ok_button.isEnabled(), "date_range_filter_ok_button is not clickable");

    	logger.log(LogStatus.INFO, "Verifying if Cancel button is displayed");
    	softassert.assertTrue(date_range_filter_cancel_button.isDisplayed(), "date_range_filter_cancel_button is not displayed");
    	
    	logger.log(LogStatus.INFO, "Verifying if Cancel button is clickable");
    	softassert.assertTrue(date_range_filter_cancel_button.isEnabled(), "date_range_filter_cancel_button is not clickable");

    	//opening date picker box
    	dateRangePickerElementClick(Constants.SelectAndScorePage.date_range_for_custom_Range);
    	logger.log(LogStatus.INFO, "Verifying if date picker box is opening after clicking on custom range link");
    	softassert.assertTrue(date_range_filter_left_calender.isDisplayed(), "date picker box is not opening");
    	softassert.assertTrue(date_range_filter_right_calender.isDisplayed(), "date picker box is not opening");
    	
    	softassert.assertAll();
    	//closing date range filter section
    	Util.Action().moveToElement(date_range_filter_cancel_button).click().perform();	
	}
	
	//Score Notifications UI
	public void scoreNotificationsSectionUI() {
		
		SoftAssert softAssert = Util.softAssert();
		//opening score notification section
		notifications_button.click();

		//verification
		logger.log(LogStatus.INFO, "Verifying if tilte is displayed");
		Util.waitExecutorForVisibilityOfElement(score_notifications_label);
		softAssert.assertTrue(score_notifications_label.isDisplayed(), "score_notifications_label is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if header note is displayed");
		softAssert.assertTrue(score_notifications_header_note.isDisplayed(), "score_notifications_header_note is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if action label is displayed");
		softAssert.assertTrue(score_notifications_action_label.isDisplayed(), "score_notifications_action_label is not displayed");

		logger.log(LogStatus.INFO, "Verifying if score_notifications_condition_label is displayed");
		softAssert.assertTrue(score_notifications_condition_label.isDisplayed(), "score_notifications_condition_label is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if score_notifications_condition_listbox is displayed");
		softAssert.assertTrue(score_notifications_condition_listbox.isDisplayed(), "score_notifications_condition_listbox is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if score_notifications_then_label is displayed");
		softAssert.assertTrue(score_notifications_then_label.isDisplayed(), "score_notifications_then_label is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if score_notifications_then_listbox is displayed");
		softAssert.assertTrue(score_notifications_then_listbox.isDisplayed(), "score_notifications_then_listbox is not displayed");

		logger.log(LogStatus.INFO, "Verifying if score_notifications_add_action_button is displayed");
		softAssert.assertTrue(score_notifications_add_action_button.isDisplayed(), "score_notifications_add_action_button is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if score_notifications_add_action_button is clickable");
		softAssert.assertTrue(score_notifications_add_action_button.isEnabled(), "score_notifications_add_action_button is not clickable");
		
		logger.log(LogStatus.INFO, "Verifying if score_notifications_save_button is displayed");
		softAssert.assertTrue(score_notifications_save_button.isDisplayed(), "score_notifications_save_button is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if score_notifications_save_button is clickable");
		softAssert.assertTrue(score_notifications_save_button.isEnabled(), "score_notifications_save_button is not clickable");
		
		logger.log(LogStatus.INFO, "Verifying if score_notifications_cancel_button is displayed");
		softAssert.assertTrue(score_notifications_cancel_button.isDisplayed(), "score_notifications_cancel_button is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if score_notifications_cancel_button is clickable");
		softAssert.assertTrue(score_notifications_cancel_button.isEnabled(), "score_notifications_cancel_button is not clickable");
		
		softAssert.assertAll();
		//closing score notification section
		score_notifications_cancel_button.click();
	}
	
	//audio player UI
	public void audioPlayerUI() {
		SoftAssert softAssert = Util.softAssert();
		
		//opening audio player strip
		actionButtonClick(Constants.SelectAndScorePage.play_audio_button);
		
    	logger.log(LogStatus.INFO, "Verifying if play_pause_audio_button is displayed");	
    	Util.waitExecutorForVisibilityOfElement(play_pause_audio_button);
		softAssert.assertTrue(play_pause_audio_button.isDisplayed(), "play_pause_audio_button is not displayed");
		
    	logger.log(LogStatus.INFO, "Verifying if play_pause_audio_button is clickable");			
		softAssert.assertTrue(play_pause_audio_button.isEnabled(), "play_pause_audio_button is not clickable");

    	logger.log(LogStatus.INFO, "Verifying if mute_unmute_audio_button is displayed");			
		softAssert.assertTrue(mute_unmute_audio_button.isDisplayed(), "mute_unmute_audio_button is not displayed");
		
    	logger.log(LogStatus.INFO, "Verifying if mute_unmute_audio_button is clickable");			
		softAssert.assertTrue(mute_unmute_audio_button.isEnabled(), "mute_unmute_audio_button is not clickable");
    	
		//closing audio player strip
		actionButtonClick(Constants.SelectAndScorePage.play_audio_button);
	
	}
	
	//Verifying action buttons
	public void actionSectionUIVerification(String sectionToVerify) {
		
		SoftAssert softAssert = Util.softAssert();
		
		switch(sectionToVerify) {
		case "email":
			//opening mail section
			actionButtonClick(Constants.SelectAndScorePage.mail_call_button);
			
			//verification
			logger.log(LogStatus.INFO, "Verifyinf if email this call window is opened");
			softAssert.assertTrue(email_this_call_window.isDisplayed(),"email thius call window is not opened or locator changed");
			
			logger.log(LogStatus.INFO, "Verifying if To label is present");
			softAssert.assertTrue(email_this_call_to_label.isDisplayed(),"email this call to label is not present or locator changed");
			
			logger.log(LogStatus.INFO, "Verifying if from label is present");
			softAssert.assertTrue(email_this_call_from_label.isDisplayed(),"Email this call from label is not present");
			
			logger.log(LogStatus.INFO, "Verifying if Message label is displayed");
			softAssert.assertTrue(email_this_call_message_label.isDisplayed(),"email this call message label is not present or locator changed");
			
			logger.log(LogStatus.INFO, "Verifying if To textbox is present");
			softAssert.assertTrue(email_this_call_to_textbox.isDisplayed(),"Email this call to text box is not present or locator changed");
	
			logger.log(LogStatus.INFO, "Verifying if Message textbox is present");
			softAssert.assertTrue(email_this_call_message_textbox.isDisplayed(),"Email this call Message text box is not present or locator changed");

//			logger.log(LogStatus.INFO, "Verifying default from mail id is "+email_this_call_from_textbox.getText());
//			softassert.assertTrue(email_this_call_from_textbox.getText().equals(CallDetailReportTest.default_mail_id_from),"default mail id is incorrect");
			
			logger.log(LogStatus.INFO, "Verifying if Send now button is present");
			softAssert.assertTrue(send_now_mail_button.isDisplayed(),"Email this call send now button is not present or locator changed");
			
			logger.log(LogStatus.INFO, "Verifying if cancel button is present");
			softAssert.assertTrue(cancel_mail_button.isDisplayed(),"Email this call cancel button is not present or locator changed");				
			
			//closing mail section
			Util.click(cancel_mail_button);
			break;
		case "i":
			//opening i section
			actionButtonClick(Constants.SelectAndScorePage.i_call_button);
			
			//verification
			logger.log(LogStatus.INFO, "Verifying if information section is displayed");
			softAssert.assertTrue(inforamtion_tab.isDisplayed(),"information section is not displayed or locator changed");
			
			logger.log(LogStatus.INFO, "Verifying if info button is displayed");
			softAssert.assertTrue(info_button.isDisplayed(),"info button is not displayed or locator changed");
			
			logger.log(LogStatus.INFO, "Verifying if comments button is displayed");
			softAssert.assertTrue(comments_button.isDisplayed(),"comments  button is not displayed or locator changed");
			
			logger.log(LogStatus.INFO, "Verifying if tags button is displayed");
			softAssert.assertTrue(tags_button.isDisplayed(),"tags  button is not displayed or locator changed");
			
			//closing i section
			actionButtonClick(Constants.SelectAndScorePage.i_call_button);
			break;
		case "download":
			logger.log(LogStatus.INFO, "Verifying if download button is displayed and clickable");
			actionButtonClick(Constants.SelectAndScorePage.download_call_button);
			break;
		}
		
		softAssert.assertAll();
	}
	
	//Verifying info, mail, tags and comment sections from Info icon
	public void infoSectionUIVerification(String sectionToVerify) throws InterruptedException {
		
		SoftAssert softAssert = Util.softAssert();
		
		//opening i section
		actionButtonClick(Constants.SelectAndScorePage.i_call_button);		
		
		switch(sectionToVerify) {
		case "comments":
			//opening comments section
	        infoSectionButtonsClick(Constants.SelectAndScorePage.comment_call_button);
	        
	        //verification
	        logger.log(LogStatus.INFO, "Verifying if Comments sectionis opened");
	        softAssert.assertTrue(comment_section.isDisplayed(),"comment section not displayed or locator changed");
			
			logger.log(LogStatus.INFO, "Verifying if comment label is displayed");
			softAssert.assertTrue(comment_label.isDisplayed(),"comment label not displayed or locator changed");
			
			logger.log(LogStatus.INFO, "Verifying if add comment button is displayed");
			softAssert.assertTrue(add_comment_button.isDisplayed(),"add comment button is not displayed or locator changed");
			
			logger.log(LogStatus.INFO, "Verifying if comment textbox is present");
			softAssert.assertTrue(comment_textbox.isDisplayed(),"comment textbox is not displayed or locator changed");
	        
			break;
		case "tags":
			//opening tags section
	        infoSectionButtonsClick(Constants.SelectAndScorePage.tag_call_button);
	        
	        //verification
	        logger.log(LogStatus.INFO, "Verifying tags section");
	        
			logger.log(LogStatus.INFO, "Verifyig if tags section is opened");
			softAssert.assertTrue(tag_section.isDisplayed(),"tags section is not displayed or locator changed");
			
			logger.log(LogStatus.INFO, "verifying if select tag label is displayed");
			softAssert.assertTrue(select_tags_label.isDisplayed(),"select tag label is not displayed or locator changed");
			
			logger.log(LogStatus.INFO, "Verifying if tags textbox is displayed");
			softAssert.assertTrue(tag_textbox.isDisplayed(),"tag textbox is not displayed or locator changed");
			
			logger.log(LogStatus.INFO, "Verifying if add tag button is displayed");
			softAssert.assertTrue(save_tag_button.isDisplayed(),"add tag button is not displayed or locator changed");
	        
			break;
		case "info":
			//opening info section
	        infoSectionButtonsClick(Constants.SelectAndScorePage.info_call_button);		
	        
	        //verification
	        logger.log(LogStatus.INFO, "Verifying info section");
	        Boolean inforSectionLabelsFlag = Util.collectionComarator(expected_inforamtion_section, inforamtion_section_labels);
	        softAssert.assertEquals(String.valueOf(inforSectionLabelsFlag), "true", "inforamtion_section_labels are not displayed");
	        break;		
		}	
		
		softAssert.assertAll();
		//closing i section
		actionButtonClick(Constants.SelectAndScorePage.i_call_button);		
	}
	
	//scoring section UI verification
	public void scoringSectionUI(String callTitle, String scorecardName) throws InterruptedException {
		SoftAssert softAssert = Util.softAssert();
		//open scoring section
		getCallToPerformAction(callTitle, "scoreCall");
		
		//Verification
		logger.log(LogStatus.INFO, "Verifying if scorecard title is displayed");
		String actualScorecardTitle = scorecard_title.getText().trim();
		String expectedScorecardTitle = scorecardName;
		softAssert.assertEquals(actualScorecardTitle, expectedScorecardTitle, "Scorecard title is not displayed");

		logger.log(LogStatus.INFO, "Verifying if score_label is displayed");
		softAssert.assertTrue(score_label.isDisplayed(), "score_label is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if download_pdf_link is displayed");
		softAssert.assertTrue(download_pdf_link.isDisplayed(), "download_pdf_link is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if download_pdf_link is clickable");
		softAssert.assertTrue(download_pdf_link.isEnabled(), "download_pdf_link is not clickable");
		
		logger.log(LogStatus.INFO, "Verifying if criteria_label is displayed");
		softAssert.assertTrue(criteria_label.isDisplayed(), "criteria_label is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if outcome_label is displayed");
		softAssert.assertTrue(outcome_label.isDisplayed(), "outcome_label is not displayed");		
		

		logger.log(LogStatus.INFO, "Verifying if outcome_yes_checkbox is displayed");
		softAssert.assertTrue(outcome_yes_checkbox.isDisplayed(), "outcome_yes_checkbox is not displayed");	
		
		logger.log(LogStatus.INFO, "Verifying if outcome_yes_checkbox is clickable");
		softAssert.assertTrue(outcome_yes_checkbox.isEnabled(), "outcome_yes_checkbox is not clickable");	
		
		logger.log(LogStatus.INFO, "Verifying if done_button_scoring_section is displayed");
		softAssert.assertTrue(done_button_scoring_section.isDisplayed(), "done_button_scoring_section is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if done_button_scoring_section is clickable");
		softAssert.assertTrue(done_button_scoring_section.isEnabled(), "done_button_scoring_section is not clickable");

		logger.log(LogStatus.INFO, "Verifying if cancel_button_scoring_section is displayed");
		softAssert.assertTrue(cancel_button_scoring_section.isDisplayed(), "cancel_button_scoring_section is not displayed");
		
		logger.log(LogStatus.INFO, "Verifying if cancel_button_scoring_section is clickable");
		softAssert.assertTrue(cancel_button_scoring_section.isEnabled(), "cancel_button_scoring_section is not clickable");
		
		softAssert.assertAll();
		//closing scoring section
		Util.click(cancel_button_scoring_section);
	}
	
	//-------------------------------------------------------UI---------------------------------------------------------------------------
	
	
   
	//---------------------------------------Functional-----------------------------------------------------------------------------------
	
	//To check if top and bottom level next and last buttons are disabled when records are less than 100
	public void paginationButtonsInabilityCheck(Boolean _100Records) {
		
		if(_100Records == true) {
			nextButtonEnable("yes");
			lastButtonEnable("yes");
		}else {
			nextButtonEnable("no");
			lastButtonEnable("no");
		}
	}
	
	//Verify mail feature
	public void emailCallFeature() throws InterruptedException {
		//opening mail section
		actionButtonClick(Constants.SelectAndScorePage.mail_call_button);		
		
		//entering details
		Util.waitExecutorForVisibilityOfElement(email_this_call_to_textbox);
		email_this_call_to_textbox.sendKeys(Constants.LegacyReports.default_mail_id_to);
		email_this_call_message_textbox.sendKeys(Constants.LegacyReports.default_mail_id_message);
		
		//submit
		Util.click(send_now_mail_button);
		
		//verification
		logger.log(LogStatus.INFO, "Verifying if mail is sent successfully");
		Util.waitExecutorForVisibilityOfElement(success_message_for_mail_call);
		Assert.assertTrue(success_message_for_mail_call.isDisplayed(),"mail was not sent");
		Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);
	}
	
	//To check if next button is enabled based on records
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
	
	//pagination tool box count verification
	public void paginationToolBoxCount() {
		
		String dbCount = null;
		String uiCount = null;
		//count from DB
    	dbCount = CallUtil.getCallRecordsCount(UtilityConstants.TimeConsatnts.date_range_for_last_7_days, TestBase.getOrg_unit_id());
    	
    	//count from UI
    	uiCount = top_pagination_count.getText().substring(top_pagination_count.getText().indexOf('f')+1).trim();
    	
    	//verify
    	logger.log(LogStatus.INFO, "Verifying if call count shown in pagination toolbox is matching with DB");
    	Assert.assertEquals(uiCount, dbCount, "uiCount is not matching with dbCount");
	}
	
	//grid count verification
	public void gridCount(){
		String dbCount = null;
		String uiCount = null;
		//count from DB
    	dbCount = CallUtil.getCallRecordsCount(UtilityConstants.TimeConsatnts.date_range_for_last_7_days, TestBase.getOrg_unit_id());
    	
    	//count from ui
    	int finalCount = call_count_in_table.size()+0;
    	
    	if(Integer.parseInt(dbCount)>100) {
    		do {
        		top_next_button.click();
        		finalCount = finalCount + call_count_in_table.size();
        	}while(!top_next_button.getAttribute("class").endsWith("disabled"));	
    	}else
    		uiCount = String.valueOf(finalCount);
    	
    	//verify
    	logger.log(LogStatus.INFO, "Verifying if call count shown in grid is matching with DB");
    	Assert.assertEquals(uiCount, dbCount, "uiCount is not matching with dbCount");
    	if(Integer.parseInt(dbCount)>100)
        	top_first_button.click();
	}
	
	//default date range
	public void defaultDateRangeFilter() {
    	logger.log(LogStatus.INFO, "Verifying if 7 days filter is applied by default");
    	for(WebElement actual_date_filter_element:actual_date_filter_elements) {
    		if(actual_date_filter_element.equals(Constants.SelectAndScorePage.date_range_for_last_7_days))
        		Assert.assertTrue(actual_date_filter_element.getAttribute("class").equals("active"), "by default 7 days filter not selected");
    		    break;
    	}
	}
	
	//to click on specified date range filter button
	public void dateRangePickerElementClick(String buttonName) {
		String xPath = "//div[@class='daterangepicker dropdown-menu opensleft' and @style]//ul//li[text()='"+buttonName+"']";
		Util.customWait(driver.findElement(By.xpath(xPath)));
		WebElement dateRangePickerElementButtonToClick = driver.findElement(By.xpath("//div[@class='daterangepicker dropdown-menu opensleft' and @style]//ul//li[text()='"+buttonName+"']"));
		Util.Action().moveToElement(dateRangePickerElementButtonToClick).click().perform();
	}
	
	//Verify date range filter for given range
    public void dateRangeFilterFeature(String range, String org_unit_id) throws InterruptedException {
    	
    	String uiCount = null;
    	String dbCount = null;
    	
    	//getting DB count
    	switch(range) {
    	case "Today":
    		dbCount = dbUtil.CallUtil.getCallRecordsCount(Constants.SelectAndScorePage.date_range_for_today, org_unit_id);
    		break;
    	case "Yesterday":
    		dbCount = dbUtil.CallUtil.getCallRecordsCount(Constants.SelectAndScorePage.date_range_for_yesterday, org_unit_id);
    		break;
    	case "Last 7 Days":
    		dbCount = dbUtil.CallUtil.getCallRecordsCount(Constants.SelectAndScorePage.date_range_for_last_7_days, org_unit_id);
    		break;
    	case "Last 30 Days":
    		dbCount = dbUtil.CallUtil.getCallRecordsCount(Constants.SelectAndScorePage.date_range_for_last_30_days, org_unit_id);
    		break;
    	}
    	
    	//getting UI count
    	date_range_filter_button.click();
    	dateRangePickerElementClick(range);
    	pageLoadWait();
    	uiCount = top_pagination_count.getText().substring(top_pagination_count.getText().indexOf('f')+1).trim();
    	
    	//Verification
    	if(Integer.parseInt(dbCount)<1) {
    		logger.log(LogStatus.INFO, "Verifying if no_data_found_label is displayed on UI since no records are present for givren range "+range);
    		Assert.assertTrue(no_data_found_label.isDisplayed(), "no_data_found_label is not displayed");	
    	}
    	else {
    		logger.log(LogStatus.INFO, "Verifying if data shown on UI is is matching with DB for date range "+range);
        	Assert.assertEquals(uiCount, dbCount, "UI count is not matching with DB count for range "+range);
    	}
    		
    	
    }
    
    //Check data filter as per status
    public void statusFilterCheck(String status) {
    	//checking specified status check box
    	checkStatus(status);
    	
    	if(driver.getPageSource().contains("noDataSelector")) {
        	logger.log(LogStatus.INFO, "Verifying if no data found label is displayed");
        	Assert.assertTrue(no_data_found_label.isDisplayed(), "no data found label is not displayed");    		
    	}else {
    		//get filtered data
        	List<String> filteredData= getFilteredData("Status");
        	
        	//verification
        	String expectedStatus = callStatusLink(status);
        	
        	Boolean verificationFlag;
        	if(Collections.frequency(filteredData, expectedStatus) == filteredData.size())
        		verificationFlag = true;
        	else
        		verificationFlag = false;
        	
        	logger.log(LogStatus.INFO, "Verifying if data shown in grid is as per status filter "+status);
        	Assert.assertEquals(String.valueOf(verificationFlag), "true", "data shown in grid is not as per status filter applied");	
    	}
    	
    	//un-checking status checkbox
    	unCheckStatus(status);
    }

    public void checkStatus(String status) {
    	//checking specified status check box
    	String xPath = "//div[text()='Filter by Status:']//parent::form//label[text()='"+status+"']//span";
    	Util.waitExecutorForVisibilityOfElement(driver.findElement(By.xpath(xPath)));
    	
    	WebElement checkboxStatus = driver.findElement(By.xpath("//div[text()='Filter by Status:']//parent::form//label[text()='"+status+"']//span//preceding-sibling::input"));
    	if(checkboxStatus.getAttribute("aria-checked").equals("false")) {
        	WebElement statusCheckbox = driver.findElement(By.xpath(xPath));
        	Util.Action().moveToElement(statusCheckbox).click().perform();
        	Util.waitExecutorForInVisibilityOfElement(loadingWheel);	
    	}
    }
    
    public void unCheckStatus(String status) {
    	//checking specified status check box
    	String xPath = "//div[text()='Filter by Status:']//parent::form//label[text()='"+status+"']//span";
    	Util.waitExecutorForVisibilityOfElement(driver.findElement(By.xpath(xPath)));
    	
    	WebElement checkboxStatus = driver.findElement(By.xpath("//div[text()='Filter by Status:']//parent::form//label[text()='"+status+"']//span//preceding-sibling::input"));
    	if(checkboxStatus.getAttribute("aria-checked").equals("true")) {
        	WebElement statusCheckbox = driver.findElement(By.xpath(xPath));
        	Util.Action().moveToElement(statusCheckbox).click().perform();
        	Util.waitExecutorForInVisibilityOfElement(loadingWheel);	
    	}
    }
    
    //Check data filter as per advance filter
    public void advanceFilterCheck(String advanceFilterElement) {
    	//opening advance filter section
    	advanced_filter_button.click();
    	
    	//selecting filter element
		Select advancedFilterElementListbox = new Select(advanced_filter_element_listbox);
		advancedFilterElementListbox.selectByVisibleText(advanceFilterElement);
    	
    	//entering filter data
		String valueToBeFiltered = null;
		if(advanceFilterElement.equals("Duration") || advanceFilterElement.equals("Group") || advanceFilterElement.equals("Score") || advanceFilterElement.equals("Call Title") || advanceFilterElement.equals("Tag") || advanceFilterElement.equals("Comments")) {
    		valueToBeFiltered = getValueToBeFiltered(advanceFilterElement);
    		if(!valueToBeFiltered.equals("null"))
    			advanced_filter_value_textbox.sendKeys(valueToBeFiltered);
    		else
    			logger.log(LogStatus.INFO, "No data found to filter");
    			
    	}else if(advanceFilterElement.equals("Identified Agent")){
    		Util.Action().moveToElement(advanced_filter_identified_agent_dropdown).click().perform();
    		valueToBeFiltered = avaialble_identified_agents_list.get(1).getText();
    		Util.Action().moveToElement(avaialble_identified_agents_list.get(1)).click().perform();
    	}else if (advanceFilterElement.equals("Scorecard")){
    		Util.Action().moveToElement(advanced_filter_scorecard_dropdown).click().perform();
    		valueToBeFiltered = avaialble_scoredcard_list.get(1).getText();
    		Util.Action().moveToElement(avaialble_scoredcard_list.get(1)).click().perform();    		
    	}
		
    	//submit
		apply_advanced_filter_button.click();
		pageLoadWait();
		
		if(driver.getPageSource().contains("noDataSelector")) {
        	logger.log(LogStatus.INFO, "Verifying if no data found label is displayed");
        	Assert.assertTrue(no_data_found_label.isDisplayed(), "no data found label is not displayed");
		}else {
			//verification
			Boolean verificationFlag;
			List filteredData = getFilteredData(advanceFilterElement);
			
	    	if(Collections.frequency(filteredData, valueToBeFiltered) == filteredData.size())
	    		verificationFlag = true;
	    	else
	    		verificationFlag = false;
	    	
	    	logger.log(LogStatus.INFO, "Verifying if data shown in grid is correct for filter "+advanceFilterElement);
	    	Assert.assertEquals(String.valueOf(verificationFlag), "true", "data shown in grid is not as per filter applied");	
		}
		
    	//closing advance filter section
    	cancel_advanced_filter_button.click();
    	pageLoadWait();
    }
    
    //get filtered data in grid
    public List getFilteredData(String filterElement) {
    	List<String> list = new ArrayList<String>();
    	int index;
    	
    	//getting filter index
    	index = getIndexForFilter(filterElement);
    	
    	//getting filtered values
    	if(filterElement.equals("Status")) {
    		List<WebElement> values = driver.findElements(By.xpath("//table[@id='scoredetailtable']//tbody//tr//td[2]//img[@src]"));
        	for(WebElement value:values) {
        		list.add(value.getAttribute("src"));
        	}
    	}else {
    		List<WebElement> values = driver.findElements(By.xpath("//table[@id='scoredetailtable']//tbody//tr//td["+index+"]"));
        	for(WebElement value:values) {
        		if(filterElement.equals("Duration")) {
        			if(filterElement.equals("Duration")) {
        	    		String[] seconds = value.getText().split(":");
        	    		int totalSeconds = 0;
        	    		for(int i=0;i<seconds.length;i++) {
        	    			totalSeconds = Integer.parseInt(seconds[i]);
        	    		}
        	    		list.add(String.valueOf(totalSeconds));
        	    	}
        		}else if(filterElement.equals("Score")) {
            		list.add(Util.getNumberFromAlphanumeric(value.getText()));         			
        		}else{
            		list.add(value.getText());        			
        		}

        	}	
    	}
    	
		return list;
    }
    
    //assign agent, score card and call title to the call 
    public String scorecardAndAgentAssignment(String scorecardName, String identifiedAgnet) throws InterruptedException {
    	String callTitle = "call-"+Util.generateRandomNumber();
    	
    	//apply status filter for unscored call
    	checkStatus(Constants.SelectAndScorePage.status_checkbox_for_unscored);
    	checkStatus(Constants.SelectAndScorePage.status_checkbox_for_need_scoreacard);
    	
    	//edit a call
    	actionButtonClick(Constants.SelectAndScorePage.edit_call_button);
    	
    	//assign score card
    	assignScorecard(scorecardName);
    	
    	//assign agent
    	assignAgent(identifiedAgnet);
    	
    	//add call title
    	addCallTitle(callTitle);
    	
    	//submit
    	logger.log(LogStatus.INFO, "Verifying if call record is getting updated successfully");
    	Util.click(save_button_edited_call);
    	Util.waitExecutorForVisibilityOfElement(success_msg_for_call_record_update);
    	Assert.assertTrue(success_msg_for_call_record_update.isDisplayed(), "call record not updated successfully");
    	Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);

    	//uncheck status filter for unscored call
    	unCheckStatus(Constants.SelectAndScorePage.status_checkbox_for_unscored);
    	unCheckStatus(Constants.SelectAndScorePage.status_checkbox_for_need_scoreacard);
    	
		return callTitle;
    }
    
    //getting specific call to perform action -- score/review/update score
    public void getCallToPerformAction(String callTitle, String action) throws InterruptedException {
    	WebElement callForAction;
    	
    	switch(action) {
    	case "editCall":
    		callForAction = driver.findElement(By.xpath("//table[@id='scoredetailtable']//tbody//tr//td/span[@e-name='call_title'][text()='"+callTitle+"']//ancestor::tr//td//button//i[contains(@class,'edit')]"));
    		Util.click(callForAction);
    		break;
    	case "scoreCall":
    		callForAction = driver.findElement(By.xpath("//table[@id='scoredetailtable']//tbody//tr//td/span[@e-name='call_title'][text()='"+callTitle+"']//ancestor::tr//td//button[text()='Score Now']"));
    		Util.click(callForAction);
        	break;	
    	case "reviewCall":
    		callForAction = driver.findElement(By.xpath("//table[@id='scoredetailtable']//tbody//tr//td/span[@e-name='call_title'][text()='"+callTitle+"']//ancestor::tr//td//button[text()='Review']"));
    		Util.click(callForAction);
    		break;		
    	case "reviewedCall":
    		callForAction = driver.findElement(By.xpath("//table[@id='scoredetailtable']//tbody//tr//td/span[@e-name='call_title'][text()='"+callTitle+"']//ancestor::tr//td//button[text()='Reviewed']"));
    		Util.click(callForAction);
    		break;			
    	}
        Util.waitExecutorForInVisibilityOfElement(criteria_loader);
    	Thread.sleep(500);
    }
    
    //getting specific call score 
    public String getCallScore(String callTitle) {
    	String score = null;
    	WebElement callCallScore = driver.findElement(By.xpath("//table[@id='scoredetailtable']//tbody//tr//td/span[@e-name='call_title'][text()='"+callTitle+"']//ancestor::tr//td//div[starts-with(@class,'score pull') and @aria-hidden='false']"));
    	return score = callCallScore.getText().replaceAll("[^a-zA-Z0-9]", "");
    }
    
    //input score 
    public void scoreInput(String type) {
    	String[] outcomeArray = {"outcome_no_checkbox", "outcome_yes_checkbox"} ;
    	String[] passFailArray = {"Pass:", "Fail:","N/A:"};
    	
    	//get all criteria 
    	List<WebElement> criteria = driver.findElements(By.xpath("//ul//li[@ng-repeat='criteria in scorecards.criteriaList']//div[@ng-show][@aria-hidden='false']"));
    	
    	//go through each criteria
    	for(int i =0;i<criteria.size();i++) {
    		//get criteria
    		String critriaType = null;

    		//check if criteria is mandatory
    		Boolean mandatoryCriteria;
    		WebElement mandatory = driver.findElement(By.xpath("(//ul//li[@ng-repeat='criteria in scorecards.criteriaList']//div[@ng-show][@aria-hidden='false'])["+(i+1)+"]//parent::div[@class='container-fluid']//span[text()='*']"));
    		if(!mandatory.getAttribute("aria-hidden").equals("true"))
    			mandatoryCriteria = true;
    		else
    			mandatoryCriteria = false;
    		
    		//get criteria type
			String passFailCheck = criteria.get(i).getAttribute("ng-show");
			if(passFailCheck.equals("criteria.ctype != 'Pass/Fail'")) {
				List<WebElement> typ = driver.findElements(By.xpath("(//ul//li[@ng-repeat='criteria in scorecards.criteriaList']//div[@ng-show][@aria-hidden='false'])["+(i+1)+"]//div[@class='radio-inline ng-scope']"));
				if(typ.size()==7) 
					critriaType = "scale_0_5";		
				else if(typ.size()==5) 
					critriaType = "scale_0_3";	
				else if(typ.size()==12) 
					critriaType = "scale_0_10";	
			}else 
				critriaType = "pass_fail";
    		
    		if(type.equals("scoreOnlyOptionalCriteria")) {
    			if(mandatoryCriteria == false) {
        			//input based on criteria type
        			if(critriaType == "pass_fail") {
        				 int passFailArrayIndex = Util.getRandomString(passFailArray);
        				 WebElement passFailCheckbox = driver.findElement(By.xpath("(//ul//li[@ng-repeat='criteria in scorecards.criteriaList']//div[@ng-show][@aria-hidden='false'])["+(i+1)+"]//label[text()='"+passFailArray[passFailArrayIndex]+"']/..//input"));
        				 if(passFailCheckbox.getAttribute("aria-checked").equals("false")) 
            				 Util.click(passFailCheckbox);        					 
        			}
                    else {
                    	if(critriaType.equals("scale_0_5")) {
                    		String[] scaleArray = {"0:", "1:", "2:", "3:", "4:", "5:", "N/A:"};
           				    int passFailArrayIndex = Util.getRandomString(scaleArray);
           				    WebElement passFailCheckbox = driver.findElement(By.xpath("(//ul//li[@ng-repeat='criteria in scorecards.criteriaList']//div[@ng-show][@aria-hidden='false'])["+(i+1)+"]//div[@class='radio-inline ng-scope']/label[text()='"+scaleArray[passFailArrayIndex]+"']/..//input"));
           		        	Util.click(passFailCheckbox);
                    	}else if(critriaType.equals("scale_0_3")) {
                    		String[] scaleArray = {"0:", "1:", "2:", "3:", "N/A:"};
           				    int passFailArrayIndex = Util.getRandomString(scaleArray);
           				    WebElement passFailCheckbox = driver.findElement(By.xpath("(//ul//li[@ng-repeat='criteria in scorecards.criteriaList']//div[@ng-show][@aria-hidden='false'])["+(i+1)+"]//div[@class='radio-inline ng-scope']/label[text()='"+scaleArray[passFailArrayIndex]+"']/..//input"));
           		        	Util.click(passFailCheckbox);
                    	}else {
                    		String[] scaleArray = {"0:", "1:", "2:", "3:", "4:", "5:", "6:", "7:", "8:", "9:" ,"10:", "N/A:"};
           				    int passFailArrayIndex = Util.getRandomString(scaleArray);
           				    WebElement passFailCheckbox = driver.findElement(By.xpath("(//ul//li[@ng-repeat='criteria in scorecards.criteriaList']//div[@ng-show][@aria-hidden='false'])["+(i+1)+"]//div[@class='radio-inline ng-scope']/label[text()='"+scaleArray[passFailArrayIndex]+"']/..//input"));
           		        	Util.click(passFailCheckbox);
                    	}            	
                    }	    				
    			}
    		}else if(type.equals("scoreOnlyMandatoryCriteria")){
    			if(mandatoryCriteria == true) {
        			//input based on criteria type
        			if(critriaType == "pass_fail") {
        				 int passFailArrayIndex = Util.getRandomString(passFailArray);
        				 WebElement passFailCheckbox = driver.findElement(By.xpath("(//ul//li[@ng-repeat='criteria in scorecards.criteriaList']//div[@ng-show][@aria-hidden='false'])["+(i+1)+"]//label[text()='"+passFailArray[passFailArrayIndex]+"']/..//input"));
        				 if(passFailCheckbox.getAttribute("aria-checked").equals("false")) 
            				 Util.click(passFailCheckbox);        					 

        			}
                    else {
                    	if(critriaType.equals("scale_0_5")) {
                    		String[] scaleArray = {"0:", "1:", "2:", "3:", "4:", "5:", "N/A:"};
           				    int passFailArrayIndex = Util.getRandomString(scaleArray);
           				    WebElement passFailCheckbox = driver.findElement(By.xpath("(//ul//li[@ng-repeat='criteria in scorecards.criteriaList']//div[@ng-show][@aria-hidden='false'])["+(i+1)+"]//div[@class='radio-inline ng-scope']/label[text()='"+scaleArray[passFailArrayIndex]+"']/..//input"));
           		        	Util.click(passFailCheckbox);
                    	}else if(critriaType.equals("scale_0_3")) {
                    		String[] scaleArray = {"0:", "1:", "2:", "3:", "N/A:"};
           				    int passFailArrayIndex = Util.getRandomString(scaleArray);
           				    WebElement passFailCheckbox = driver.findElement(By.xpath("(//ul//li[@ng-repeat='criteria in scorecards.criteriaList']//div[@ng-show][@aria-hidden='false'])["+(i+1)+"]//div[@class='radio-inline ng-scope']/label[text()='"+scaleArray[passFailArrayIndex]+"']/..//input"));
           		        	Util.click(passFailCheckbox);
                    	}else {
                    		String[] scaleArray = {"0:", "1:", "2:", "3:", "4:", "5:", "6:", "7:", "8:", "9:" ,"10:", "N/A:"};
           				    int passFailArrayIndex = Util.getRandomString(scaleArray);
           				    WebElement passFailCheckbox = driver.findElement(By.xpath("(//ul//li[@ng-repeat='criteria in scorecards.criteriaList']//div[@ng-show][@aria-hidden='false'])["+(i+1)+"]//div[@class='radio-inline ng-scope']/label[text()='"+scaleArray[passFailArrayIndex]+"']/..//input"));
           		        	Util.click(passFailCheckbox);
                    	}            	
                    }	
        		
    			}
    		}else if(type.equals("scoreAllCriteria")){
    			//input based on criteria type
    			if(critriaType == "pass_fail") {
    				 int passFailArrayIndex = Util.getRandomString(passFailArray);
    				 WebElement passFailCheckbox = driver.findElement(By.xpath("(//ul//li[@ng-repeat='criteria in scorecards.criteriaList']//div[@ng-show][@aria-hidden='false'])["+(i+1)+"]//label[text()='"+passFailArray[passFailArrayIndex]+"']/..//input"));
    				 if(passFailCheckbox.getAttribute("aria-checked").equals("false")) 
        				 Util.click(passFailCheckbox);        					 
    			}
                else {
                	if(critriaType.equals("scale_0_5")) {
                		String[] scaleArray = {"0:", "1:", "2:", "3:", "4:", "5:", "N/A:"};
       				    int passFailArrayIndex = Util.getRandomString(scaleArray);
       				    WebElement passFailCheckbox = driver.findElement(By.xpath("(//ul//li[@ng-repeat='criteria in scorecards.criteriaList']//div[@ng-show][@aria-hidden='false'])["+(i+1)+"]//div[@class='radio-inline ng-scope']/label[text()='"+scaleArray[passFailArrayIndex]+"']/..//input"));
       		        	Util.click(passFailCheckbox);
                	}else if(critriaType.equals("scale_0_3")) {
                		String[] scaleArray = {"0:", "1:", "2:", "3:", "N/A:"};
       				    int passFailArrayIndex = Util.getRandomString(scaleArray);
       				    WebElement passFailCheckbox = driver.findElement(By.xpath("(//ul//li[@ng-repeat='criteria in scorecards.criteriaList']//div[@ng-show][@aria-hidden='false'])["+(i+1)+"]//div[@class='radio-inline ng-scope']/label[text()='"+scaleArray[passFailArrayIndex]+"']/..//input"));
       		        	Util.click(passFailCheckbox);
                	}else {
                		String[] scaleArray = {"0:", "1:", "2:", "3:", "4:", "5:", "6:", "7:", "8:", "9:" ,"10:", "N/A:"};
       				    int passFailArrayIndex = Util.getRandomString(scaleArray);
       				    WebElement passFailCheckbox = driver.findElement(By.xpath("(//ul//li[@ng-repeat='criteria in scorecards.criteriaList']//div[@ng-show][@aria-hidden='false'])["+(i+1)+"]//div[@class='radio-inline ng-scope']/label[text()='"+scaleArray[passFailArrayIndex]+"']/..//input"));
       		        	Util.click(passFailCheckbox);
                	}            	
                }	
    		} 		
		}
    	
    	//input for outcome
    	int outcomeArrayIndex = Util.getRandomString(outcomeArray);
    	if(outcomeArray[outcomeArrayIndex].equals("outcome_yes_checkbox")) {
    		if(outcome_yes_checkbox.getAttribute("aria-checked").equals("false"))
        		Util.click(outcome_yes_checkbox);
    	}
    	else {
    		if(outcome_no_checkbox.getAttribute("aria-checked").equals("false"))
        		Util.click(outcome_no_checkbox);
    	}
    }
    
    //scoring a call
    public void scoreCall(String callTitle, String type) throws InterruptedException {
    	//edit call to be scored
    	getCallToPerformAction(callTitle, "scoreCall");
    	    	
    	//score a call
    	switch(type) {
    	case "scoreOnlyOptionalCriteria":
    		scoreInput("scoreOnlyOptionalCriteria");
    		break;
    	case "scoreOnlyMandatoryCriteria":
    		scoreInput("scoreOnlyMandatoryCriteria");
    		break;	
    	case "scoreAllCriteria":
    		scoreInput("scoreAllCriteria");
    		break;		
    	}
    	
    	//submit score 
    	Util.click(done_button_scoring_section);
    	
    	//verification based on given condition
    	if(type.equals("scoreAllCriteria") || type.equals("scoreOnlyMandatoryCriteria")) {
    		logger.log(LogStatus.INFO, "Verifying if call getting scored successfully");
    		//success message is not shown for call score so verification is on update_score button
    		Util.waitExecutorForVisibilityOfElement(update_score_button_scoring_section);
        	Assert.assertTrue(update_score_button_scoring_section.isDisplayed(), "call not scored successfully");	
    	}else {
    		logger.log(LogStatus.INFO, "Verifying if appropriate alert is displayed if mandatory criteria are not scored");
    		Util.waitExecutorForVisibilityOfElement(alert_msg_for_missing_mandatory_criteria_answeres);
        	Assert.assertTrue(alert_msg_for_missing_mandatory_criteria_answeres.isDisplayed(), "call scored successfully evem after not answering mandatory criteria");	  		
    	}
    	
    	//commenting out since success message is not displayed for call score
//    	Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);
    	
    	//closing scoring section
    	Util.click(cancel_button_scoring_section);
    }
    
    //update score 
    public void upateScore(String callTitle, String CallStatus) throws InterruptedException {
        //edit call to be scored
    	getCallToPerformAction(callTitle, CallStatus);
    	
    	//update score 
    	scoreInput("scoreAllCriteria");
 
    	//submit score
    	logger.log(LogStatus.INFO, "Verifying if call score is getting updated successfully");
    	Util.click(update_score_button_scoring_section);
      	Util.waitExecutorForVisibilityOfElement(success_msg_for_call_score_update);
    	Assert.assertTrue(success_msg_for_call_score_update.isDisplayed(), "call score not updated successfully");
    	Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);
    	
    	//closing scoring section
    	Util.click(cancel_button_scoring_section);
    }
    
    //review call
    public void reviewCall(String callTitle) throws InterruptedException {
        //edit call to be scored
    	getCallToPerformAction(callTitle, "reviewCall");
    	
    	//review a call
    	logger.log(LogStatus.INFO, "Verifying if call is getting reviewed successfully");
    	Util.click(review_button_scoring_section);
    	Util.waitExecutorForVisibilityOfElement(success_msg_for_call_score_review);
    	Assert.assertTrue(success_msg_for_call_score_review.isDisplayed(), "call not reviewed successfully");
    	Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);  	
    }
    
    //cancel feature -- answer all criteria and cancel
    public void cancelScoreFeature(String callTitle) throws InterruptedException {
    	//edit call to be scored
    	getCallToPerformAction(callTitle, "scoreCall");
    	    	
    	//score a call
    	scoreInput("scoreAllCriteria");
    	
    	//submit score 
    	logger.log(LogStatus.INFO, "Verifying if call is not scored on click of cancel button");
    	Util.click(cancel_button_scoring_section);
    	
    	//verification
        Boolean successMessageFlag;
    	if(driver.getPageSource().contains(success_msg_for_call_score.getText())) {
    		successMessageFlag = true;
    	}else
    		successMessageFlag = false;
    	
    	Assert.assertEquals(String.valueOf(successMessageFlag), "false", "success_msg_for_call_score is dispalyed even after cancel button click");    	
    }
    
    //get scorer and reviewer details
    public void scorerReviewerDetails(String callTitle, Map<String,String> details) throws InterruptedException {
    	SoftAssert softAssert = Util.softAssert();
    	
    	//edit call to be scored
    	getCallToPerformAction(callTitle, "reviewedCall");
    	
    	//expected scorer and reviewer details
    	String expScorer = details.get("expScorer");
    	String expCallAssigner = expScorer;
    	String expScoredFor = details.get("expScoredFor");
    	String expReviewer = details.get("expReviewer");
    	
    	//get scorer and reviewer details displayed
    	String actScorer ;
    	String actCallAssigner;
    	String actScoredFor;
    	String actReviewer;
    	
    	actScorer = driver.findElement(By.xpath("//div[@class='container-fluid']//div[starts-with(@ng-show,'item.status') and @aria-hidden='false']//div[starts-with(text(),'Selected By')]")).getText();
    	actScoredFor = driver.findElement(By.xpath("//div[@class='container-fluid']//div[starts-with(@ng-show,'item.status') and @aria-hidden='false']//div[starts-with(text(),'Scored For')]")).getText();
    	actReviewer = driver.findElement(By.xpath("//div[@class='container-fluid']//div[starts-with(@ng-show,'item.status') and @aria-hidden='false']//div[starts-with(text(),'Reviewed By')]")).getText();
    	actCallAssigner = actScorer;
    	
    	//verification
    	logger.log(LogStatus.INFO, "Verifying if correct scorer is displayed");
    	softAssert.assertTrue(actScorer.endsWith(expScorer), "incorrect scorer displayed");
    	logger.log(LogStatus.INFO, "Verifying if correct call assigner is displayed");
    	softAssert.assertTrue(actCallAssigner.endsWith(expCallAssigner), "incorrect Call Assigner displayed");
    	logger.log(LogStatus.INFO, "Verifying if correct scored for is displayed");
    	softAssert.assertTrue(actScoredFor.endsWith(expScoredFor), "incorrect Scored For displayed");
    	logger.log(LogStatus.INFO, "Verifying if correct reviewer is displayed");
    	softAssert.assertTrue(actReviewer.endsWith(expReviewer), "incorrect Reviewer displayed");
    	
    	softAssert.assertAll();
    	
    	//closing scoring section
    	Util.Action().moveToElement(cancel_button_scoring_section).click().perform();
    }
    
    //check agents displayed in list are as per user permission
    public void identifiedAgentsDAMCheck(String top_org_unit_id, String org_unit_id) {
    	List<String> identifiedAgentsFromUI = new ArrayList<String>();
    	List<String> identifiedAgentsFromDB = new ArrayList<String>();
    	
    	//edit call
//    	actionButtonClick(Constants.SelectAndScorePage.edit_call_button);
    	
    	//get listed agents from UI
    	Select identifiedAgentListBox = new Select(identified_agent_listbox_edited_call);
    	List<WebElement> identifiedAgents = identifiedAgentListBox.getOptions();
    	for(WebElement identifiedAgent:identifiedAgents) {
    		if(!identifiedAgent.getAttribute("value").equals("?") &&  !identifiedAgent.getAttribute("value").equals("unassigned")) {
        		String validMailId = Util.getValidMailIdFromString(identifiedAgent.getText());
        		identifiedAgentsFromUI.add(validMailId);	
    		}
    	}
    	
    	//get agents from DB
    	identifiedAgentsFromDB = dbUtil.UserDBUtil.getUsers(top_org_unit_id);
    	identifiedAgentsFromDB = dbUtil.UserDBUtil.getUsers(org_unit_id);
    	identifiedAgentsFromDB = dbUtil.UserDBUtil.getChildGroupUsers(org_unit_id);

    	//verification
    	Collections.sort(identifiedAgentsFromUI);
    	Collections.sort(identifiedAgentsFromDB);
    	logger.log(LogStatus.INFO, "Verifying if agents displayed in list are following user permission");
    	
    	Assert.assertEquals(identifiedAgentsFromUI, identifiedAgentsFromDB, "agents displayed in list are not following user permission");
    	
    	//cancel edited call
    	cancel_button_edited_call.click();
    }
    
    //edit desired call
    public void editSpecificCall(String callTitle) {
    	WebElement action_button_of_call = driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//tr//td//span[@e-name='call_title'][text()='"+callTitle+"']//ancestor::tr//td//button//i[contains(@class,'edit')])[1]"));
    	 Util.click(action_button_of_call);
    }
    
    //check score cards displayed in list are as per configured in available to list
    public void scorecardsAvailabilityCheck(String groupName) {
    	List<String> scorecardsAvailableFromUI = new ArrayList<String>();
    	List<String> scorecardsAvailableFromDB = new ArrayList<String>();
    	
    	//edit call
//    	actionButtonClick(Constants.SelectAndScorePage.edit_call_button);
    	
    	//get listed scorecards from UI
    	Select scorecardListBox = new Select(scorecard_listbox_edited_call);
    	List<WebElement> scorecards = scorecardListBox.getOptions();
    	for(WebElement scorecard:scorecards) {
    		if(!scorecard.getAttribute("value").equals("?") &&  !scorecard.getAttribute("value").equals("unassigned"))
        		scorecardsAvailableFromUI.add(scorecard.getText());
    	}
    	
    	//get scorecards from DB
    	String group_id = dbUtil.GroupDBUtil.getOrgUnitId(groupName);
        scorecardsAvailableFromDB = dbUtil.ScorecardDBUtil.getScorecardsNames(group_id);

    	//verification
    	Collections.sort(scorecardsAvailableFromUI);
    	Collections.sort(scorecardsAvailableFromDB);
    	logger.log(LogStatus.INFO, "Verifying if scorecards displayed in list are as per configured in available to list");
    	Assert.assertEquals(scorecardsAvailableFromUI, scorecardsAvailableFromDB, "scorecards displayed in list are not as per configured in available to list");
    	
    	//cancel edited call
    	cancel_button_edited_call.click();
    }
    
    //assigning agent to the call
    public void assignAgent(String agentName) {
    	Select identifiedAgentListBox = new Select(identified_agent_listbox_edited_call);
    	String agentId = dbUtil.UserDBUtil.getCTUserId(agentName);
    	if(!identifiedAgentListBox.getFirstSelectedOption().getAttribute("value").equals(agentId)) 
    		identifiedAgentListBox.selectByValue(agentId);    		
    }
    
    //assigning score card to the call
    public void assignScorecard(String scorecardName) {
    	Select scoreCardListBox = new Select(scorecard_listbox_edited_call);
    	if(!scoreCardListBox.getFirstSelectedOption().getText().equals(scorecardName)) 
        	scoreCardListBox.selectByVisibleText(scorecardName);    		
    }
    
    //adding title to the call
    public void addCallTitle(String callTitle) {
    	call_title_edited_call.clear();
    	call_title_edited_call.sendKeys(callTitle);
    }
    
    //get call status -- unscored/scored/reviewed
    public String getCallStatus(String callTitle) {
    	String callStatus = null;
    	
    	//getting call status
    	WebElement statusElement = driver.findElement(By.xpath("//table[@id='scoredetailtable']//tbody//tr//td/span[@e-name='call_title'][text()='"+callTitle+"']//ancestor::tr//td//img"));
    	String statusLink = statusElement.getAttribute("src");
    	return callStatus = callStatus(statusLink);
    }
    
    //Verify status is turning into appropriate value after actions
    public void callStatusVerification(String callTitle, String expectedStatus) {
    	//get actual status
    	String actualCallStatus = getCallStatus(callTitle);
    	String expecrtedCallStatus = expectedStatus;
    	
    	//verification
    	Assert.assertEquals(actualCallStatus, expecrtedCallStatus, "Status does not change into "+expectedStatus);
    }
    
    
    //adding Notifications
    public void addNotification(int noOfNotifications) throws InterruptedException {
    	
    	//open notifications section
    	Util.waitExecutorForAttribute(notifications_button, "aria-disabled", "false");
    	Util.scrollFunction(header_label);
    	notifications_button.click();
    	Util.waitExecutorForVisibilityOfElement(score_notifications_save_button);
    	
    	//add notifications
    	scoreNotificationsinput(noOfNotifications);
    	
    	//submit and verify
    	logger.log(LogStatus.INFO, "Verifying if notification is getting added successfully");
    	Util.click(score_notifications_save_button);
    	Util.waitExecutorForVisibilityOfElement(success_message_notifications);
    	Assert.assertTrue(success_message_notifications.isDisplayed(), "notification not added successfully");
    	Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);
    }
    
    //adding actions for notifications
    public void scoreNotificationsinput(int noOfNotifications) {
    	
    	for(int i=1;i<=noOfNotifications;i++) {
    		if(i<5) {
    			//setting if condition
            	WebElement ifConditionListbox = driver.findElement(By.xpath("(//h3[text()='If']/..//following-sibling::div//select)["+i+"]"));
            	Select ifConditionList = new Select(ifConditionListbox);
            	
            	if(i%2 == 0)
                	ifConditionList.selectByIndex(1);
            	else
                	ifConditionList.selectByIndex(2);

            	//setting then action
            	WebElement thenConditionListbox = driver.findElement(By.xpath("(//h3[text()='Then']/..//following-sibling::div//select)["+i+"]"));
            	Select thenConditionList = new Select(thenConditionListbox);
            	
            	if(i%2 == 0)
                	thenConditionList.selectByIndex(1);
            	else
                	thenConditionList.selectByIndex(2);            		
            	
            	//adding value for then condition
            	WebElement thenConditionTextBox = driver.findElement(By.xpath("(//h3[text()='Then']/..//following-sibling::div//div[@aria-hidden='false']//input)["+i+"]"));
            	if(thenConditionList.getFirstSelectedOption().getText().equals("Send email alert to")) {
            		thenConditionTextBox.clear();
            		thenConditionTextBox.sendKeys(TestBase.getUser_id());            		
            	}
            	else if (thenConditionList.getFirstSelectedOption().getText().equals("Send SMS to")) {
            		thenConditionTextBox.clear();
            		thenConditionTextBox.sendKeys("8018786943"); 			            		
            	}
            	
            	//add next action
            	if(i<noOfNotifications && i<4) 
            		score_notifications_add_action_button.click();      
            	else if(i>=4){
            		try {
            	    	logger.log(LogStatus.INFO, "Verifying if not able to add 5th notification");
            			Assert.assertFalse(score_notifications_add_action_button.isDisplayed());
            		}catch(Exception e){
            			Assert.fail("allowing add to 5th notiifcation");
            		}
            	}
    		}  		
    	}
    }
    
    
    public void deleteNotifications(int count) throws InterruptedException {
    	
    	//open notifications section
    	Util.waitExecutorForAttribute(notifications_button, "aria-disabled", "false");
//    	notifications_button.click();
    	Util.scrollFunction(header_label);
    	Util.click(notifications_button);
    	Thread.sleep(2000);

    	//getting countof notifications
    	int totalNotifiactions = (count<=score_notifications_delete_action_button.size()) ? count : (score_notifications_delete_action_button.size());
    	Thread.sleep(1000);
    	
    	for(int i=0;i<totalNotifiactions;i++){
    		WebElement ifConditionListbox = driver.findElement(By.xpath("(//h3[text()='If']/..//following-sibling::div//select)[1]"));
        	int ifConditionListSize = new Select(ifConditionListbox).getOptions().size();
    		//had to spy this element again here to avoid stale element exception
    		WebElement deleteActionButton = driver.findElement(By.xpath("(//a[starts-with(@ng-click,'removeScoreNotifications')])[1]//i"));
    		Util.click(deleteActionButton);
    		driver.switchTo().activeElement();
    		Util.waitExecutorForVisibilityOfElement(score_notifications_delete_action_alert_ok_button);
    		score_notifications_delete_action_alert_ok_button.click();
        	
    		if(ifConditionListSize<3) {
        		Util.waitExecutorForVisibilityOfElement(score_notifications_delete_action_success_message);
        		Util.closeBootstrapPopup(pause_button_success_message, close_button_success_message);    			
    		}
    		Thread.sleep(500);
    	}
    	
    	//close notifications section
    	Util.waitExecutorForVisibilityOfElement(score_notifications_cancel_button);
    	score_notifications_cancel_button.click();
    }
    
    //check if alert is  displayed if while editing a call if already any other edited call is not saved 
    public void editCallAlert() throws InterruptedException {
    	//editing a call
    	actionButtonClick(Constants.SelectAndScorePage.edit_call_button);
    	
    	//editing another call
    	actionButtonClick(Constants.SelectAndScorePage.edit_call_button);
    	
    	//verification
    	logger.log(LogStatus.INFO, "Verifying if Appropriate alert is displayed when previoulsy edited call is not closed");
    	Util.waitExecutorForVisibilityOfElement(edit_call_alert);
    	Assert.assertTrue(edit_call_alert.isDisplayed(), "Appropriate alert not displayed");
    	
    	//close popup
    	Util.keyboardActions("escape");
    }
    
    //check call score with DB
    public void callScoreCheck(String callTitle) {
    	String scoreFromUI;
    	String scoreFromDB;
    	
    	//get call score from UI
    	WebElement scoreElement = driver.findElement(By.xpath("//table[@id='scoredetailtable']//tbody//tr//td/span[@e-name='call_title'][text()='"+callTitle+"']//ancestor::tr//td//button[text()='Score Now']/..//following-sibling::div/div[@aria-hidden='false']"));
    	scoreFromUI = Util.getNumberFromAlphanumeric(scoreElement.getText());
    	
    	//get call score from DB
    	String callID = dbUtil.ScorecardDBUtil.getCallId(callTitle);
    	scoreFromDB = dbUtil.ScorecardDBUtil.getCallScore(callID);
    	//verification
    	logger.log(LogStatus.INFO, "Verifying if score displayed on UI is matching with DB");
    	Assert.assertEquals(scoreFromUI, scoreFromDB, "score displayed on UI does not match with DB");
    }
    
    //Check if score card is associated with call
    public void scorecardAssociationWithCall(String callTitle, String scorecardName) {
    	try {
    		//getting scorecard from call
        	WebElement scorecardElement = driver.findElement(By.xpath("//table[@id='scoredetailtable']//tbody//tr//td/span[@e-name='call_title'][text()='"+callTitle+"']//ancestor::tr//td/span[@e-name='selectedScorecard'][text()='"+scorecardName+"']"));
        
        	//verification	
        	logger.log(LogStatus.INFO, "Verifying if scoreacard is attached to the call");
        	Assert.assertTrue(scorecardElement.isDisplayed(), "Scorecard association with is broken");
    	}catch(Exception e) {}	
    }
    
    
    //get group associated with call title
    public String getGroup(String callTitle) {
    	String groupName;
    	
    	//getting scorecard from call
    	WebElement scorecardElement = driver.findElement(By.xpath("//table[@id='scoredetailtable']//tbody//tr//td/span[@e-name='call_title'][text()='"+callTitle+"']//ancestor::tr//td[@class='ng-binding'][3]"));
    	return groupName = scorecardElement.getText();
    }
    
  //------------------------------------------Functional----------------------------------------------------------------------------------
	
}
