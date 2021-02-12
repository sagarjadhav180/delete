package pom;

import java.util.List;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath="//div[@class='timeline-footer text-right']//a[text()='Add Action']")
	private WebElement score_notifications_add_action_button;
	
	@FindBy(xpath="//h3[@class='modal-title']//following-sibling::button")
	private WebElement score_notifications_condition_close_button;

	@FindBy(xpath="//div[starts-with(@class,'modal-body')]//button[text()='Cancel']")
	private WebElement score_notifications_cancel_button;
	
	@FindBy(xpath="//div[starts-with(@class,'modal-body')]//button[text()='Save']")
	private WebElement score_notifications_save_button;
	
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
	String[] expected_columns_names = {"Play Call ","Status ","Date/Time ","Duration ","Group ","Identified Agent ","Call Title ","Scorecard ","Score Date ","Score ","Actions "};
	
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
	
	//advanced filter
	@FindBy(xpath="//button[text()='Advanced filter']")
	private WebElement advanced_filter_button;
	
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
	
	//need to handle it when there are multiple conditions in filter
	@FindBy(xpath="//div[@class='advancedf']//select[2]")
	private WebElement advanced_filter_element_listbox;
	String[] exp_advanced_filter_element_listbox_options = {"-- Select --", "Duration", "Group", "Identified Agent", "Scorecard", "Score", "Call Title", "Tag", "Comments"};

	@FindBy(xpath="//div[@class='advancedf']//select[3]")
	private WebElement advanced_filter_operator_listbox;

	@FindBy(xpath="//div[@class='advancedf']//select[3]//following-sibling::input[1]")
	private WebElement advanced_filter_value_textbox;

	@FindBy(xpath="//span[@id='select2-chosen-4'][contains(text(),'-- Select --')]/..")
	private WebElement advanced_filter_identified_agent_dropdown;

	@FindBy(xpath="//span[@id='select2-chosen-4'][contains(text(),'-- Select --')]/..")
	private WebElement advanced_filter_scorecard_dropdown;

	@FindBy(xpath="//button[@class='btn btn-gray'][text()=' Add an Advanced Filter']")
	private WebElement add_an_advanced_filter_button;
	
	@FindBy(xpath="//button[text()='Apply']")
	private WebElement apply_advanced_filter_button;
	
	@FindBy(xpath="//button[text()='Cancel']")
	private WebElement cancel_advanced_filter_button;

	//confirmation messages
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
	
	//scoring section
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
	
	@FindBy(xpath="//strong[contains(text(),'Outcome')]")
	private WebElement outcome_label;

	@FindBy(xpath="//div[@id='scorecardarea2']//input[1]")
	private WebElement outcome_yes_checkbox;

	@FindBy(xpath="//div[@id='scorecardarea2']//input[2]")
	private WebElement outcome_no_checkbox;
	
	@FindBy(xpath="//button[text()='Done']")
	private WebElement done_button;

	@FindBy(xpath="//button[text()='Done']//preceding-sibling::button")
	private WebElement cancel_button;
	
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
		
		
	public SelectAndScorePage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	
	//to check expected filter status check box 
    public void selectScorecardStatusCheckbox(String status){
		WebElement status_checkbox = driver.findElement(By.xpath("//div[text()='Filter by Status:']//parent::form//label[text()='"+status+"']/input"));
		status_checkbox.click();
	}
    
	
	//To click on action button
    public void actionButtonClick(String button_name) {
    	
    	WebElement action_button = null;
    	
    	switch(button_name) {
    	case "play":
    		action_button= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//tr//td[1]//button[@title='Listen to call'][@aria-disabled='false'])[1]"));
    		action_button.click();
    		break;
    	case "i":
    		action_button= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//tr//td//button[@title='Toggle Call Info'])[1]"));
    		action_button.click();    		
    		break;
    	case "edit":
    		action_button= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//tr//td//button//i[contains(@class,'edit')])[1]"));
    		action_button.click(); 
    		break;
    	case "download":
    		action_button= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//tr//td//button[@title='Download Audio File'])[1]"));
    		action_button.click(); 
    		break;
    	case "mail":
    		action_button= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//tr//td//button[@title='Email Call'])[1]"));
    		action_button.click();     		
    		break;	
    	}
    	
    }
    
    //To click on info section buttons
    public void infoSectionButtonsClick(String buttonName) throws InterruptedException {
    	Thread.sleep(1000);
    	WebElement infSectionButtonsToClick = driver.findElement(By.xpath("//ul[@class='nav nav-tabs']//li//span[text()='"+buttonName+"']"));
    	Util.Action().moveToElement(infSectionButtonsToClick).click().perform();
    }
    
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
    	dateRangePickerElementClick(Constants.SelectAndScorePage.custom_Range);
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
	
	//default date range
	public void defaultDateRangeFilter() {
    	logger.log(LogStatus.INFO, "Verifying if 7 days filter is applied by default");
    	for(WebElement actual_date_filter_element:actual_date_filter_elements) {
    		if(actual_date_filter_element.equals(Constants.SelectAndScorePage.last_7_days))
        		Assert.assertTrue(actual_date_filter_element.getAttribute("class").equals("active"), "by default 7 days filter not selected");
    		    break;
    	}
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
	
	//Verify mail feature
	public void emailCallFeature() {
		//opening mail section
		actionButtonClick(Constants.SelectAndScorePage.mail_call_button);		
		
		//entering details
		Util.waitExecutorForVisibilityOfElement(email_this_call_to_textbox);
		email_this_call_to_textbox.sendKeys(Constants.LegacyReports.default_mail_id_to);
		email_this_call_message_textbox.sendKeys(Constants.LegacyReports.default_mail_id_message);
		
		//submit
		Util.click(send_now_mail_button);
		
		//verification
		Util.waitExecutorForVisibilityOfElement(success_message_for_mail_call);
		logger.log(LogStatus.INFO, "Verifying if mail is sent successfully");
		Assert.assertTrue(success_message_for_mail_call.isDisplayed(),"mail was not sent");
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
	
	//pagination tool box count verification
	public void paginationToolBoxCount() {
		
		String dbCount = null;
		String uiCount = null;
		//count from DB
    	dbCount = CallUtil.getCallRecordsCount(UtilityConstants.TimeConsatnts.date_range_for_last_7_days, TestBase.getOrg_unit_id());
    	
    	//count from UI
    	uiCount = top_pagination_count.getText().substring(top_pagination_count.getText().indexOf('f')+1).trim();
    	
    	//verify
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
    	Assert.assertEquals(uiCount, dbCount, "uiCount is not matching with dbCount");
    	if(Integer.parseInt(dbCount)>100)
        	top_first_button.click();
	}

	//to click in specified date range filter button
	public void dateRangePickerElementClick(String buttonName) {
		WebElement dateRangePickerElementButtonToClick = driver.findElement(By.xpath("//div[@class='daterangepicker dropdown-menu opensleft'][2]//ul//li[text()='"+buttonName+"']"));
		Util.Action().moveToElement(dateRangePickerElementButtonToClick).click().perform();
	}
	
    
    
}
