package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import tests.TestBase;

public class ManageScorecardPage extends TestBase {
	
	@FindBy(xpath="//div[@ class='pageProgressLoader']")
	private WebElement loadingWheel;

	@FindBy(xpath="//h1[contains(text(),'Scorecards')]")
	private WebElement scorecard_header_label;

	@FindBy(xpath="//button[@class='btn btn-sm btn-default']")
	private WebElement add_scorecard_button;

	@FindBy(xpath="(//span[text()='Export']//parent::button)[1]")
	private WebElement export_button;

	@FindBy(xpath="//div[@class='ui-pnotify ']//div[text()='Successfully Created Scorecard']")
	private WebElement success_message_scorecard_creation;

	@FindBy(xpath="//div[@class='ui-pnotify ']//div[text()='Successfully updated Scorecard']")
	private WebElement success_message_scorecard_updation;

	@FindBy(xpath="//div[@class='ui-pnotify ']//div[text()='Successfully Archived Scorecard']")
	private WebElement success_message_scorecard_deletion;

	@FindBy(xpath="//div[@class='modal-footer']//button[text()='OK']")
	private WebElement scorecard_deletion_alert_ok_button;

	@FindBy(xpath="//div[@class='modal-footer']//button[text()='Cancel']")
	private WebElement scorecard_deletion_alert_cancel_button;
	
	@FindBy(xpath="//table/thead//tr[1]//th")
	private WebElement actual_column_names;
	
	//-----------------------------------------------------
//	static String index = null;
//	@FindBy(xpath="//table/tbody//td["+index+"]")
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

//  verification of buttons in top pagination toolbox
//	logger.log(LogStatus.INFO, "verifying presence of buttons in top pagination toolbox");
//	wait.until(ExpectedConditions.visibilityOf(users_topNextPagination_Button));
//	Assert1.assertTrue(top_first_button.isDisplayed(),"top_first_button is not present or locator changed");
//	Assert1.assertTrue(top_last_button.isDisplayed(),"top_last_button is not present or locator changed");	
//	Assert1.assertTrue(top_next_button.isDisplayed(),"top_next_button is not present or locator changed");	
//	Assert1.assertTrue(top_prev_button.isDisplayed(),"top_prev_button is not present or locator changed");	
	
//	dbCount = Util.readingFromDB("SELECT COUNT(*) FROM score_cards WHERE org_unit_id='70135'" );
//	
//      countOnUI_pagination=top_pagination_count.getText().substring(top_pagination_count.getText().indexOf('f')+2);
//	logger.log(LogStatus.INFO, "verifying count scorecards in top pagination toolbox");
//	Assert1.assertEquals(dbCount, countOnUI_pagination,"count in top pagination toolbox is mismatching with db count");
//	
//	logger.log(LogStatus.INFO, "verifying count of listed scorecards");
//	Assert1.assertEquals(dbCount, String.valueOf(scorecards_count_in_table.size()),"count  of listed tracking numbers is mismatching with db count");
	
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
	private static WebElement available_to_dropdown_options;
	
	@FindBy(xpath="//a[@id='selectAll']")
	private static WebElement select_all_checkbox;

	@FindBy(xpath="//a[@id='deselectAll']")
	private static WebElement deselect_all_checkbox;

	@FindBy(xpath="//input[@placeholder='Search...']")
	private static WebElement search_group_textbox;

	@FindBy(xpath="//input[@placeholder='Search...']//ancestor::li//following-sibling::li//a//span[text()]")
	private static List<WebElement> available_to_groups;

	//-------------------------------------------------------------------------------------------
//	@FindBy(xpath="//input[@placeholder='Search...']//ancestor::li//following-sibling::li//a//span[text()='"+group_name+"']//ancestor::li//input")
//	private static List<WebElement> available_to_group_checkbox;
	//---------------------------------------------------------------------------------------------
	
	@FindBy(xpath="//div[@class='modal-body modalbody panel-body']//label[text()='Actions']")
	private static WebElement actions_label;
	
	@FindBy(xpath="//div[@class='modal-body modalbody panel-body']//label[text()='Actions']//following-sibling::div//select")
	private static WebElement actions_listbox;
	
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
	private static WebElement importance_field;

	@FindBy(xpath="(//label[text()='Importance']//parent::div//select)[2]")
	private static List<WebElement> importance_dropdown;
	
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
	private static WebElement criteria_dropdown;
	
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
	
	//to get action button of desired score-card 
    public WebElement getScoreacrd(String scorecard_name,String button_name){
		
		WebElement webelement = driver.findElement(By.xpath("//table//tbody//tr//td[text()='"+scorecard_name+"']//ancestor::tr//child::button[contains(text(),'"+button_name+"')]"));
		return webelement;
	}
    
    
    
	
	
}
