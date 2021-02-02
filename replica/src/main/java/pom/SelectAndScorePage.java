package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.TestBase;
import tests.Util;

public class SelectAndScorePage extends TestBase {

	@FindBy(xpath="//div[@ class='pageProgressLoader']")
	private WebElement loadingWheel;
	
	@FindBy(xpath="//h1[contains(text(),'Select and Score')]")
	private WebElement header_label;
	
	@FindBy(xpath="//h4[contains(text(),'Calls count on this page may differ from Reports.')]")
	private WebElement header_note;	
	
	String expected_call_count_note="Calls count on this page may differ from Reports. Reports strictly follow the user permission settings and filter calls according to the groups users are assigned to. The Scorecard feature allows a user to be assigned calls that are part of a group the user does not have access to.";

	@FindBy(xpath="//div[@class='options']//button")
	private WebElement date_range_filter_button;		
	
	@FindBy(xpath="//div[@class='daterangepicker dropdown-menu opensleft']//ul//li")
	private List<WebElement> actual_date_filter_elements;		
	
	String[] expected_date_filter_elements={"Today","Yesterday","Last 7 Days","Last 30 Days","This Month","Last Month","Custom Range"};
	
	@FindBy(xpath="(//span[text()='Export']//parent::button[@aria-hidden='false'])")
	private WebElement export_button;
	
	@FindBy(xpath="//button[text()=' Notifications']")
	private WebElement notifications_button;	
	
	@FindBy(xpath="//div[text()='Filter by Status:']//parent::form//label")
	private List<WebElement> filter_status;		
	
	String[] expected_filter_status={"Need Scorecard","Unscored","Scored","Reviewed"};
	
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
	
	@FindBy(xpath="//div[@class='advancedf']//select[1]")
	private WebElement include_exclude_listbox;
	
	//need to handle it when there are multiple conditions in filter
	@FindBy(xpath="//div[@class='advancedf']//select[2]")
	private WebElement advanced_filter_element_listbox;

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

	@FindBy(xpath="//div[@class='container-fluid']//ul//li//div[@aria-hidden='false']//div[contains(@id,'passcheck')]//input")
	private List<WebElement> pass_checkboxes;	

	@FindBy(xpath="//div[@class='container-fluid']//ul//li//div[@aria-hidden='false']//div[contains(@id,'failCheck')]//input")
	private List<WebElement> fail_checkboxes;

	@FindBy(xpath="//div[@class='container-fluid']//ul//li//div[@aria-hidden='false']//div[contains(@id,'naCheck')]//input")
	private List<WebElement> na_checkboxes;

	//--------------------scale checkboxes----------------------
//	@FindBy(xpath="//div[@class='container-fluid']//ul//li//div[@aria-hidden='false']//div[contains(@class,'radio-inline')]//label[contains(text(),'"+scale_value+"')]/..//input")
//	private List<WebElement> scale_checkboxes;
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
	
	//bottom -----------------------------------------------
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
		
	//  verification of buttons in top pagination toolbox
		
//		int currentDate = Util.getDate();
//		   String startDateToBeUsed = String.valueOf(currentDate-7);
//		   String endDateToBeUsed = String.valueOf(currentDate);
//		   System.out.println("startDateToBeUsed is "+startDateToBeUsed);
//		   System.out.println("endDateToBeUsed is "+endDateToBeUsed);
		
		
//		logger.log(LogStatus.INFO, "verifying presence of buttons in top pagination toolbox");
//		wait.until(ExpectedConditions.visibilityOf(users_topNextPagination_Button));
//		Assert1.assertTrue(top_first_button.isDisplayed(),"top_first_button is not present or locator changed");
//		Assert1.assertTrue(top_last_button.isDisplayed(),"top_last_button is not present or locator changed");	
//		Assert1.assertTrue(top_next_button.isDisplayed(),"top_next_button is not present or locator changed");	
//		Assert1.assertTrue(top_prev_button.isDisplayed(),"top_prev_button is not present or locator changed");	
	
//		dbCount = Util.readingFromDB("SELECT * FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit 
//      WHERE top_ou_id='70135') AND call_started BETWEEN '2020-01-15 23:59' AND '2020-01-22 23:59'" );
//	
//      countOnUI_pagination=top_pagination_count.getText().substring(top_pagination_count.getText().indexOf('f')+2);
//	logger.log(LogStatus.INFO, "verifying count of calls in top pagination toolbox");
//	Assert1.assertEquals(dbCount, countOnUI_pagination,"count in top pagination toolbox is mismatching with db count");
//	
//	logger.log(LogStatus.INFO, "verifying count of listed calls");
//	Assert1.assertEquals(dbCount, String.valueOf(call_count_in_table.size()),"count of listed calls is mismatching with db count");
		
		
	public SelectAndScorePage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	
	//to check expected filter status check box 
    public void selectScorecardStatusCheckbox(String status){
		WebElement status_checkbox = driver.findElement(By.xpath("//div[text()='Filter by Status:']//parent::form//label[text()='"+status+"']/input"));
		status_checkbox.click();
	}
    
    
    //to get action button of required call  
    public WebElement getActionButton(String button_name){
    	WebElement webelement = null;
    	
    	if(button_name.contains("play")){
		    webelement= driver.findElement(By.xpath("((//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td)[1]//button"));
    	}
//    	else if(button_name.contains("score")){
//    		webelement= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//button[text()='Score Now']"));    		
//    	}
    	else if(button_name.contains("edit")){
    		webelement= driver.findElement(By.xpath("((//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//div[@class='buttons pull-right']//button)[1]"));
    	}
    	else if(button_name.contains("download")){
    		webelement= driver.findElement(By.xpath("((//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//div[@class='buttons pull-right']//button)[2]"));
    	}
    	else if(button_name.contains("mail")){
    		webelement= driver.findElement(By.xpath("((//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//div[@class='buttons pull-right']//button)[3]"));
    	}
    	else if(button_name.contains("agent")){
    		webelement= driver.findElement(By.xpath("((//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//select)[1]"));
    	}
    	else if(button_name.contains("scorecard")){
    		webelement= driver.findElement(By.xpath("((//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//select)[2]"));
    	}
    	else if(button_name.contains("call title")){
    		webelement= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//input"));
    	}
    	else if(button_name.contains("save")){
    		webelement= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//button[text()='Save']"));
    	}
    	else if(button_name.contains("cancel")){
    		webelement= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//button[text()='Cancel']"));
    	}
		return webelement;
    }
	
	//To click on action button
    public void actionButtonClick(String button_name) {
    	
    	WebElement action_button = null;
    	
    	switch(button_name) {
    	case "play":
    		action_button= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//tr//td[1]//button[@title='Listen to call'][@aria-disabled='false'])[1]"));
    		action_button.click();
    		break;
    	case "info":
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
	
    
    
}
