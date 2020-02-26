package pom;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import tests.TestBase;
import tests.Util;

public class TrackingNumberBuilderPage extends TestBase {
    
	SoftAssert softassert=new SoftAssert();
	
	//Tracking number list
	
	@FindBy(xpath="//h4[contains(text(),'TRACKING NUMBERS FOR SJC-1')]")
	private static WebElement header;

	@FindBy(xpath="//button[@class='btn btn-info'][contains(text(),'Add Tracking Number')]")
	private static WebElement add_tracking_number_button;	

	@FindBy(xpath="(//button[@id='export_btn'])[1]")
	private static WebElement export_button;
	
	@FindBy(xpath="(//table)[4]//thead//th")
	private static List<WebElement> tracking_number_list_column_headers;
	
	String[] tracking_number_list_column_header_name={"Tracking Number","Name","Ring-to Phone Number","Tracking Number Type","Ad Source","Spam Guard","Status","Actions"};
	
	//pagination toolbox
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
	
	@FindBy(xpath="(//table)[4]//tr")
	private static List<WebElement> tracking_numbers_count_in_table;	
	
	//Add tracking number page-basic section

	@FindBy(xpath="//label")
	private static List<WebElement> labels;	
	
	String[] label_names={"CONFIGURE NUMBER","NPA-NXX (Area Code)","Tracking Number Name","Ad Source","Tracking Number","CONFIGURE ROUTING OPTIONS"};
	
	@FindBy(xpath="//label[@class='control-label'][contains(text(),'Activate Voicemail ?')]")
	private static WebElement activate_voicemail_checkbox_label;	

	@FindBy(xpath="//label[@class='control-label'][contains(text(),'Activate Voicemail ?')]//parent::div//following-sibling::div//child::md-checkbox")
	private static WebElement activate_voicemail_checkbox;

	@FindBy(xpath="//label[@class='control-label'][contains(text(),'Activate Voicemail ?')]//parent::div//following-sibling::div//child::p")
	private static WebElement activate_voicemail_note;
	
	@FindBy(xpath="//label[@class='control-label'][contains(text(),'Active?')]")
	private static WebElement active_label;

	@FindBy(xpath="(//label[@class='control-label'][contains(text(),'Active?')]//parent::div/following-sibling::div//child::div[contains(@class,'primary switch')])[1]")
	private static WebElement active_label_checkbox;
	
	@FindBy(xpath="(//label[contains(text(),'Set Caller Id To')])[2]")
	private static WebElement set_caller_id_label;

	@FindBy(xpath="//md-radio-button[@id='optionsRadios1']")
	private static WebElement single_number_label;

	@FindBy(xpath="//md-radio-button[@id='optionsRadios1']/div[2]")
	private static WebElement single_number_button;
	
	@FindBy(xpath="//md-radio-button[@id='optionsRadios2']")
	private static WebElement number_pool_label;

	@FindBy(xpath="//button[contains(text(),'OK')]")
	private static WebElement ok_button_number_pool_label_create_alert;	
	
	@FindBy(xpath="//md-radio-button[@id='optionsRadios2']/div[1]")
	private static WebElement number_pool_button;

	@FindBy(xpath="//label[text()='Quantity']//parent::div//following-sibling::div//input")
	private static WebElement number_pool_quantity_textbox;
	
	@FindBy(xpath="//md-radio-button[@id='optionsRadios3']")
	private static WebElement reserved_number_label;

	@FindBy(xpath="//md-radio-button[@id='optionsRadios3']")
	private static WebElement reserved_number_button;
	
	@FindBy(xpath="//label[text()='Reserved Number']//parent::div//following-sibling::div//select")
	private static WebElement reserved_number_dropdown;	

	@FindBy(xpath="//label[text()='NPA-NXX (Area Code)']//parent::div//following-sibling::div//input")
	private static WebElement area_code_textbox;
	
	@FindBy(xpath="//label[text()='Tracking Number Name']//parent::div//following-sibling::div//input")
	private static WebElement tracking_number_name_textbox;

	@FindBy(xpath="//a[contains(text(),'ALPINE,UT')]")
	private static WebElement area_code_385;

	@FindBy(xpath="//ul[@class='dropdown-menu ng-isolate-scope']//li//a")
	private static List<WebElement> area_codes_list_for_385;
	
	@FindBy(xpath="//div[@class='col-lg-6 col-md-6 col-sm-12 mt20 mb20 pull-left']//div//div//div[contains(@class,'col-lg-6 col-md-6 col-sm-12')]//select[@id='source']//option")
	private static List<WebElement> tn_list_for_385;	
	
	@FindBy(xpath="(//label[text()='Ring to Phone Number']//parent::div//following-sibling::div//input)[3]")
	private static WebElement ring_to_phone_number_textbox;

	@FindBy(xpath="//label[text()='Tracking Number']//parent::div//following-sibling::div//child::select")
	private static WebElement tracking_number_dropdown;
	
	@FindBy(xpath="(//div[@class='input-icon right'])[4]")
	private static WebElement tracking_number_dropdown_button;	

	@FindBy(xpath="(//label[text()='Route Calls By']//parent::div//following-sibling::div//child::select[@id='source'])[1]")
	private static WebElement route_calls_by_dropdown;

	@FindBy(xpath="//label[text()='Ad Source']//parent::div//following-sibling::div//child::select[@id='source']")
	private static WebElement ad_source_dropdown;

	@FindBy(xpath="(//label[contains(text(),'Set Caller Id To')]//parent::div//following-sibling::div//child::select)[2]")
	private static WebElement set_caller_id_dropdown;

	@FindBy(xpath="//div[text()='Tracking Number created successfully.']")
	private static WebElement tn_creation_success_message;

	@FindBy(xpath="//div[text()='Tracking Number updated successfully.']")
	private static WebElement tn_updation_success_message;
	
	@FindBy(xpath="//div[text()='Tracking Number removed successfully.']")
	private static WebElement tn_deletion_success_message;	

	@FindBy(xpath="//button[contains(text(),'OK')]")
	private static WebElement ok_button_tn_deletion_alert;

	@FindBy(xpath="//button[contains(text(),'Cancel')]")
	private static WebElement cancel_button_tn_deletion_alert;
	
	//Add tracking number page-advanced section
	
	String[] trackingNumberLabels={"Call Value","Repeat Interval (hours)",
			"Voicemail","Configure Voicemail Greetings","Pre-call Webhook",
			"Record Call","Play call recording disclaimer","Play whisper message before connecting",
			"Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5",
			"Host Domain","Referring Website","DNI Type","HTML Class","Instant Insights","Key Press",
			"Voice prompt for Call outcome","Record a Sale","Sale amount voice prompt",
			"Record a Lead","Record Agent ID","Agent ID voice prompt","Number of Digits in Agent Id",
			"Voice prompt for Call outcome","Record a Sale","Sale amount voice prompt","Record a Lead"};
    
	@FindBy(xpath="(//label[text()='Play a voice prompt'])[2]")
	private static WebElement play_a_voice_prompt_label;	
	
	@FindBy(xpath="//label[contains(text(),'Call Value')]//parent::*//following-sibling::div//input")
	private WebElement call_value_textbox;
	
	@FindBy(xpath="//label[contains(text(),'Configure Voicemail Greetings')]/parent::*//following-sibling::div//textarea")
	private WebElement configure_voicemail_greetings_textbox;	
	
	@FindBy(xpath="//label[contains(text(),'Repeat Interval (hours)')]//parent::*//following-sibling::div//input")
	private WebElement repeat_interval_textbox;

	@FindBy(xpath="(//label[text()='Play a voice prompt'])[2]//..//following-sibling::div//md-checkbox")
	private WebElement play_voice_prompt_checkbox;
	
	@FindBy(xpath="(//label[contains(text(),'voice prompt')]//parent::*//following-sibling::div//textarea)[2]")
	private WebElement play_voice_prompt_textbox;

	@FindBy(xpath="(//label[text()='Play whisper message before connecting'])[1]//..//following-sibling::div//md-checkbox")
	private WebElement play_whisper_message_checkbox;
	
	@FindBy(xpath="(//label[contains(text(),'Play whisper message before connecting')]//parent::*//following-sibling::div//textarea)[1]")
	private WebElement play_whisper_message_textbox;
	
	
	//Dynamic Number Section
	
	@FindBy(xpath="//label[contains(text(),'Dynamic Number')]")
	private static WebElement dynamic_number_label;

	@FindBy(xpath="//label[contains(text(),'Dynamic Number')]/../following-sibling::div//md-checkbox")
	private static WebElement dynamic_number_checkbox;
	
	@FindBy(xpath="//label//parent::*//input[@id='showDNI']")
	private WebElement hostDomain_textbox;	
	
	@FindBy(xpath="//label//parent::*//input[@name='dni_element']")
	private WebElement htmlclass_textbox;	
	
	@FindBy(xpath="//label[text()='Referring Website']//parent::*//select")
	private WebElement reffering_website_dropdown;
	
	@FindBy(xpath="//label[text()='DNI Type']//parent::*//select")
	private WebElement dni_type_dropdown;
	String[] dni_types={"URL","Source"};
	
	@FindBy(xpath="//a[text()='Custom Parameters']//parent::div")
	private WebElement custom_parameters_button;
	
	//Custom source section
	String[] customsources_labels={"Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5"};
	
	@FindBy(xpath="//label[text()='Custom Source 1']//parent::div//following-sibling::div//span[2]")
	private WebElement custom_source1_dropdown;	

	@FindBy(xpath="//label[text()='Custom Source 1']//parent::div//following-sibling::div//input")
	private WebElement custom_source1_textbox;	
	
	@FindBy(xpath="//label[text()='Custom Source 2']//parent::div//following-sibling::div//span[2]")
	private WebElement custom_source2_dropdown;	

	@FindBy(xpath="//label[text()='Custom Source 2']//parent::div//following-sibling::div//input")
	private WebElement custom_source2_textbox;	
	
	@FindBy(xpath="//label[text()='Custom Source 3']//parent::div//following-sibling::div//span[2]")
	private WebElement custom_source3_dropdown;	
	
	@FindBy(xpath="//label[text()='Custom Source 3']//parent::div//following-sibling::div//input")
	private WebElement custom_source3_textbox;	
	
	@FindBy(xpath="//label[text()='Custom Source 4']//parent::div//following-sibling::div//span[2]")
	private WebElement custom_source4_dropdown;	
	
	@FindBy(xpath="//label[text()='Custom Source 4']//parent::div//following-sibling::div//input")
	private WebElement custom_source4_textbox;	
	
	@FindBy(xpath="//label[text()='Custom Source 5']//parent::div//following-sibling::div//span[2]")
	private WebElement custom_source5_dropdown;	
	
	@FindBy(xpath="//label[text()='Custom Source 5']//parent::div//following-sibling::div//input")
	private WebElement custom_source5_textbox;	
	
	
	//Instant insights section 

	@FindBy(xpath="//label[contains(text(),'Instant Insights')]/..//following-sibling::div//md-checkbox")
	private WebElement instant_insights_checkbox;
	
	@FindBy(xpath="//div[@class='col-lg-8 col-md-8 col-sm-12 mt10 mb10']//select[@id='source']")
	private WebElement instant_insights_dropdown;
	
	@FindBy(xpath="(//label[text()='Voice prompt for Call outcome']//parent::*//following-sibling::div//textarea)[1]")
	private WebElement voice_prompt_for_call_outcome_textbox;	
	
	@FindBy(xpath="((//label[text()='Voice prompt for Call outcome']//parent::div//following-sibling::div)[3]//a)[1]")
	private WebElement voice_prompt_for_call_outcome_addfile_button;

	@FindBy(xpath="((//label[text()='Voice prompt for Call outcome']//parent::div//following-sibling::div)[3]//a)[3]")
	private WebElement voice_prompt_for_call_outcome_play_button;
	
	@FindBy(xpath="//label[text()='Sale amount voice prompt']//parent::*//following-sibling::div//textarea")
	private WebElement sale_amount_voice_prompt_textbox;
	
	@FindBy(xpath="((//label[text()='Sale amount voice prompt']//parent::div//following-sibling::div)[3]//a)[1]")
	private WebElement sale_amount_voice_prompt_addfile_button;

	@FindBy(xpath="((//label[text()='Sale amount voice prompt']//parent::div//following-sibling::div)[3]//a)[3]")
	private WebElement sale_amount_voice_prompt_play_button;
	
	@FindBy(xpath="//label[text()='Agent ID voice prompt']//parent::div//following-sibling::div//textarea")
	private WebElement agent_ID_voice_prompt_textbox;

	@FindBy(xpath="((//label[text()='Agent ID voice prompt']//parent::div//following-sibling::div)[3]//a)[1]")
	private WebElement agent_ID_voice_prompt_addfile_button;

	@FindBy(xpath="((//label[text()='Agent ID voice prompt']//parent::div//following-sibling::div)[3]//a)[3]")
	private WebElement agent_ID_voice_prompt_play_button;
	
	@FindBy(xpath="//label[text()='Number of Digits in Agent Id']//parent::div//following-sibling::div//select")
	private WebElement number_of_digits_in_agent_Id_dropdown;

	@FindBy(xpath="((//div[@class='panel-footer text-right'])[2]//button)[1]")
	private WebElement save_button;
	
	@FindBy(xpath="((//div[@class='panel-footer text-right'])[2]//button)[2]")
	private WebElement save_and_clone_button;

	@FindBy(xpath="((//div[@class='panel-footer text-right'])[2]//button)[3]")
	private WebElement cancel_button;
	
	@FindBy(xpath="(//button[text()='Add Overflow Number'])[1]")
	private WebElement add_overflow_button_beside_default_ringto;

	
	//hunting section
	  //need to handle required_overflow_textbox
	
	@FindBy(xpath="(//button[contains(text(),'Add Overflow Number')])[2]")
	private WebElement add_overflow_button_in_hunt_section;	

	@FindBy(xpath="(//label[contains(text(),'Simultaneous Ring')])[1]//parent::div//following-sibling::div//md-checkbox")
	private WebElement simultaneous_ring_checkbox;	
	
	@FindBy(xpath="(//span[text()='  Overflow to'])[1]//parent::div//following-sibling::div//input")
	private WebElement add_overflow_textbox;

	@FindBy(xpath="(//span[text()='  Overflow to'])[1]//parent::div//following-sibling::div//select")
	private WebElement overflow_rings_dropdown;
	
	@FindBy(xpath="(//span[text()='  Overflow to'])[1]//parent::div//following-sibling::div//a")
	private WebElement delete_overflow_number_button;		
	
	@FindBy(xpath="//div[@class='pageProgressLoader']")
	private WebElement loading_wheel;

	@FindBy(xpath="//i[@class='fa fa-refresh fa-spin ng-hide']")
	private WebElement loading_wheel_for_area_code;

	@FindBy(xpath="//i[@id='LoadTrackingNumber']")
	private WebElement loading_wheel_for_tn;
	
	
	public TrackingNumberBuilderPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	//to get action button of desired tracking number
    public void clickAction(String tracking_number_name,String button_name){
		
		WebElement webelement = driver.findElement(By.xpath("//span[contains(text(),'"+tracking_number_name+"')]//ancestor::tr//div//button[contains(text(),'"+button_name+"')]"));
		System.out.println(webelement);
		Util.scrollFunction(webelement);
		
		if(button_name.contains("Delete")){
			wait.until(ExpectedConditions.visibilityOf(webelement));
			Util.click(webelement);
			driver.switchTo().activeElement();
            wait.until(ExpectedConditions.visibilityOf(ok_button_tn_deletion_alert));
			Util.Action().moveToElement(ok_button_tn_deletion_alert).click().perform();
			wait.until(ExpectedConditions.visibilityOf(tn_deletion_success_message));
			logger.log(LogStatus.INFO, "Verifying if tracking number is deleted successfully..");
			softassert.assertTrue(tn_deletion_success_message.isDisplayed(),"tracking number not deleted successfully");
            softassert.assertAll();
			
		}
		else{
			webelement.click();
		}
	}
    
    
    public void uiVerification(){
    	SoftAssert softassert=new SoftAssert();
    	wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
    	Util.scrollFunction(add_tracking_number_button);
        
        logger.log(LogStatus.INFO, "Verifying if add_tracking_number_button is present");
        softassert.assertTrue(add_tracking_number_button.isDisplayed(),"add_tracking_number_button is not displayed or locator changed");
        
        logger.log(LogStatus.INFO, "Verifying if add_tracking_number_button is enabled");
        softassert.assertTrue(add_tracking_number_button.isEnabled(),"add_tracking_number_button is not enabled");

        logger.log(LogStatus.INFO, "Verifying if export_button is displayed");
        softassert.assertTrue(export_button.isDisplayed(),"export_button is not displayed or locator changed");

        logger.log(LogStatus.INFO, "Verifying if export_button is enabled");
        softassert.assertTrue(export_button.isEnabled(),"export_button is not enabled");
        
        
        
        for(int i=0;i<tracking_number_list_column_headers.size();){
        	
        	for(int j=0;j<tracking_number_list_column_header_name.length;j++){
        		if(tracking_number_list_column_headers.get(i).getText().equals(tracking_number_list_column_header_name[j])){
        			logger.log(LogStatus.INFO, "verifying if "+tracking_number_list_column_header_name[j]+" is present");
        			softassert.assertTrue(tracking_number_list_column_headers.get(i).getText().equals(tracking_number_list_column_header_name[j]),"header "+tracking_number_list_column_header_name[j]+" is not present");
        		}
        	}
        	i++;
        }
        

    //  verification of buttons in top pagination toolbox
    	logger.log(LogStatus.INFO, "verifying presence of buttons in top pagination toolbox");
    	wait.until(ExpectedConditions.visibilityOf(top_first_button));
    	softassert.assertTrue(top_first_button.isDisplayed(),"top_first_button is not present or locator changed");
    	softassert.assertTrue(top_last_button.isDisplayed(),"top_last_button is not present or locator changed");	
    	softassert.assertTrue(top_next_button.isDisplayed(),"top_next_button is not present or locator changed");	
    	softassert.assertTrue(top_prev_button.isDisplayed(),"top_prev_button is not present or locator changed");	
    	
    	//verification of count in top pagination toolbox	
    	String dbCount = Util.readingFromDB("SELECT count(*) FROM ce_call_flows WHERE provisioned_route_id IN (SELECT provisioned_route_id FROM campaign_provisioned_route  WHERE campaign_id='17225') AND status NOT IN ('suspended')" );
        String countOnUI_pagination = top_pagination_count.getText().substring(top_pagination_count.getText().indexOf('f')+2);
    	logger.log(LogStatus.INFO, "verifying count tracking numbers in top pagination toolbox");
    	softassert.assertEquals(dbCount, countOnUI_pagination,"count in top pagination toolbox is mismatching with db count");
    	
    	logger.log(LogStatus.INFO, "verifying count of listed tracking numbers");
    	softassert.assertEquals(dbCount, String.valueOf(tracking_numbers_count_in_table.size()-1),"count  of listed tracking numbers is mismatching with db count");
        
        
        
        
        //opening tracking number builder page
        add_tracking_number_button.click();
        
        wait.until(ExpectedConditions.visibilityOf(header));
        logger.log(LogStatus.INFO, "verifying if header is displayed");
        softassert.assertTrue(header.isDisplayed(),"header is not displayed");
        
        for(int i=0;i<labels.size();){
        	
        	for(int j=0;j<label_names.length;j++){
        		if(labels.get(i).getText().equals(label_names[j])){
        			logger.log(LogStatus.INFO, "Verifying if "+label_names[j]+" is present");
        			softassert.assertTrue(labels.get(i).getText().equals(label_names[j]),"label "+label_names[j]+" is not present");
        		}
        	}
        	i++;
        }
        
        //basic section 
        logger.log(LogStatus.INFO, "Verifying if activate_voicemail field is present");
        softassert.assertTrue(activate_voicemail_checkbox_label.isDisplayed(),"activate_voicemail field is not displayed or locator chenged");
        
        logger.log(LogStatus.INFO, "Verifying if activate_voicemail_checkbox is present");
        softassert.assertTrue(activate_voicemail_checkbox.isDisplayed(),"activate_voicemail_checkbox is not displayed or locator chenged");
        
        logger.log(LogStatus.INFO, "Verifying if activate_voicemail_checkbox is enabled");
        softassert.assertTrue(activate_voicemail_checkbox.isEnabled(),"activate_voicemail_checkbox is not enabled");

        logger.log(LogStatus.INFO, "Verifying if activate_voicemail_note is displayed");
        softassert.assertTrue(activate_voicemail_note.isDisplayed(),"activate_voicemail_checkbox is not displayed or locator changed");
        
        logger.log(LogStatus.INFO, "Verifying if active_label is displayed");
        softassert.assertTrue(active_label.isDisplayed(),"active_label is not displayed or locator changed");

        logger.log(LogStatus.INFO, "Verifying if active_label_checkbox is displayed");
        softassert.assertTrue(active_label_checkbox.isDisplayed(),"active_label_checkbox is not displayed or locator changed");

        logger.log(LogStatus.INFO, "Verifying if active_label_checkbox is enabled");
        softassert.assertTrue(active_label_checkbox.isEnabled(),"active_label_checkbox is not enabled");
        
        logger.log(LogStatus.INFO, "Verifying if set_caller_id_label is displayed");
        softassert.assertTrue(set_caller_id_label.isDisplayed(),"set_caller_id_label is not displayed or locator changed");

        logger.log(LogStatus.INFO, "Verifying if single_number_label is displayed");
        softassert.assertTrue(single_number_label.isDisplayed(),"single_number_label is not displayed or locator changed");

        logger.log(LogStatus.INFO, "Verifying if single_number_button is displayed");
        softassert.assertTrue(single_number_button.isDisplayed(),"single_number_button is not displayed or locator changed");

        logger.log(LogStatus.INFO, "Verifying if single_number_button is enabled");
        softassert.assertTrue(single_number_button.isEnabled(),"single_number_button is not enabled");

        logger.log(LogStatus.INFO, "Verifying if number_pool_label is displayed");
        softassert.assertTrue(number_pool_label.isDisplayed(),"number_pool_label is not displayed or locator changed");

        logger.log(LogStatus.INFO, "Verifying if number_pool_button is displayed");
        softassert.assertTrue(number_pool_button.isDisplayed(),"number_pool_button is not displayed or locator changed");

        logger.log(LogStatus.INFO, "Verifying if number_pool_button is enabled");
        softassert.assertTrue(number_pool_button.isEnabled(),"number_pool_button is not enabled");

        Util.Action().moveToElement(number_pool_button).click().perform();
        logger.log(LogStatus.INFO, "Verifying if number_pool_quantity_textbox is displayed");
        softassert.assertTrue(number_pool_quantity_textbox.isDisplayed(),"number_pool_quantity_textbox is not displayed or locator changed");        
        Util.Action().moveToElement(single_number_button).click().perform();
        
        logger.log(LogStatus.INFO, "Verifying if reserved_number_label is displayed");
        softassert.assertTrue(reserved_number_label.isDisplayed(),"reserved_number_label is not displayed or locator changed");

        logger.log(LogStatus.INFO, "Verifying if area_code_textbox is displayed");
        softassert.assertTrue(area_code_textbox.isDisplayed(),"area_code_textbox is not displayed or locator changed");

        logger.log(LogStatus.INFO, "Verifying if tracking_number_name_textbox is displayed");
        softassert.assertTrue(tracking_number_name_textbox.isDisplayed(),"tracking_number_name_textbox is not displayed or locator changed");
        
        logger.log(LogStatus.INFO, "Verifying if ring_to_phone_number_textbox is displayed");
        softassert.assertTrue(ring_to_phone_number_textbox.isDisplayed(),"ring_to_phone_number_textbox is not displayed or locator changed");
        
        //advanced section
       
        Util.getJavascriptExecutor().executeScript("window.scrollBy(0,500)","");
        
        for(int i=0;i<labels.size();){
        	
        	for(int j=0;j<trackingNumberLabels.length;j++){
        		if(labels.get(i).getText().equals(trackingNumberLabels[j])){
        			System.out.println("we "+labels.get(i).getText());
        			System.out.println("array "+trackingNumberLabels[j]);
        			logger.log(LogStatus.INFO, "Verifying if "+trackingNumberLabels[j]+" is displayed");
        			softassert.assertTrue(labels.get(i).getText().equals(trackingNumberLabels[j]),trackingNumberLabels[j]+" is not displayed");
        			
        		}
        	}
        	i++;
        }
        logger.log(LogStatus.INFO, "Verifying if play_a_voice_prompt_label is displayed");
        softassert.assertTrue(play_a_voice_prompt_label.isDisplayed(),"play_a_voice_prompt_label is not displayed or locator changed");

        logger.log(LogStatus.INFO, "Verifying if call_value_textbox is displayed");
        softassert.assertTrue(call_value_textbox.isDisplayed(),"call_value_textbox is not displayed or locator changed");

        logger.log(LogStatus.INFO, "Verifying if configure_voicemail_greetings_textbox is displayed");
        softassert.assertTrue(configure_voicemail_greetings_textbox.isDisplayed(),"configure_voicemail_greetings_textbox is not displayed or locator changed");
        
        logger.log(LogStatus.INFO, "Verifying if repeat_interval_textbox is displayed");
        softassert.assertTrue(repeat_interval_textbox.isDisplayed(),"repeat_interval_textbox is not displayed or locator changed");

        Util.Action().moveToElement(play_voice_prompt_checkbox).click().perform();
        logger.log(LogStatus.INFO, "Verifying if play_voice_prompt_textbox is displayed");
        softassert.assertTrue(play_voice_prompt_textbox.isDisplayed(),"play_voice_prompt_textbox is not displayed or locator changed");

        Util.Action().moveToElement(play_whisper_message_checkbox).click().perform();
        logger.log(LogStatus.INFO, "Verifying if play_whisper_message_textbox is displayed");
        softassert.assertTrue(play_whisper_message_textbox.isDisplayed(),"play_whisper_message_textbox is not displayed or locator changed");

      
       //DNI section
        Util.Action().moveToElement(dynamic_number_checkbox).click().perform();
        logger.log(LogStatus.INFO, "Verifying if dynamic_number_label is displayed");
        softassert.assertTrue(dynamic_number_label.isDisplayed(),"dynamic_number_label is not displayed or locator changed");

        logger.log(LogStatus.INFO, "Verifying if hostDomain_textbox is displayed");
        softassert.assertTrue(hostDomain_textbox.isDisplayed(),"hostDomain_textbox is not displayed or locator changed");

        logger.log(LogStatus.INFO, "Verifying if htmlclass_textbox is displayed");
        softassert.assertTrue(htmlclass_textbox.isDisplayed(),"htmlclass_textbox is not displayed or locator changed");
        
        Select select=new Select(dni_type_dropdown);
        for(int i=0;i<select.getOptions().size();){
        	for(int j=0;j<dni_types.length;j++){
        		if(select.getOptions().get(i).getText().equals(dni_types[j])){
        			System.out.println("we "+select.getOptions().get(i).getText());
        			System.out.println("array "+dni_types[j]);
        			logger.log(LogStatus.INFO, "Verifying if "+select.getOptions().get(i).getText().equals(dni_types[j]));
        			softassert.assertTrue(select.getOptions().get(i).getText().equals(dni_types[j]),dni_types[j]+" is not present");
        		}
        		i++;
        	}
        }
        logger.log(LogStatus.INFO, "Verifying if custom_parameters_button is displayed");
        softassert.assertTrue(custom_parameters_button.isDisplayed(),"custom_parameters_button is not displayed or locator changed");        
        
        logger.log(LogStatus.INFO, "Verifying if custom_parameters_button is enabled");
        softassert.assertTrue(custom_parameters_button.isEnabled(),"custom_parameters_button is not enabled");         
      
        //custom source section
        
        for(int i=0;i<labels.size();){
        	
        	for(int j=0;j<customsources_labels.length;j++){
        		if(labels.get(i).getText().equals(customsources_labels[j])){
        			System.out.println("we "+labels.get(i).getText());
        			System.out.println("array "+customsources_labels[j]);
        			logger.log(LogStatus.INFO, "Verifying if "+customsources_labels[j]+" is displayed");
        			softassert.assertTrue(labels.get(i).getText().equals(customsources_labels[j]),customsources_labels[j]+" is not displayed");
        			
        		}
        	}
        	i++;
        }
        
    	//Instant insights section -- call outcome
        Util.Action().moveToElement(instant_insights_checkbox).click().perform();
        logger.log(LogStatus.INFO, "Verifying if voice_prompt_for_call_outcome_textbox is displayed");
        softassert.assertTrue(voice_prompt_for_call_outcome_textbox.isDisplayed(),"voice_prompt_for_call_outcome_textbox is not displayed or locator changed");  

        logger.log(LogStatus.INFO, "Verifying if voice_prompt_for_call_outcome_addfile_button is displayed");
        softassert.assertTrue(voice_prompt_for_call_outcome_addfile_button.isDisplayed(),"voice_prompt_for_call_outcome_addfile_button is not displayed or locator changed");  

        logger.log(LogStatus.INFO, "Verifying if voice_prompt_for_call_outcome_play_button is displayed");
        softassert.assertTrue(voice_prompt_for_call_outcome_play_button.isDisplayed(),"voice_prompt_for_call_outcome_play_button is not displayed or locator changed");  
        
        logger.log(LogStatus.INFO, "Verifying if sale_amount_voice_prompt_textbox is displayed");
        softassert.assertTrue(sale_amount_voice_prompt_textbox.isDisplayed(),"sale_amount_voice_prompt_textbox is not displayed or locator changed");          
        
        logger.log(LogStatus.INFO, "Verifying if sale_amount_voice_prompt_addfile_button is displayed");
        softassert.assertTrue(sale_amount_voice_prompt_addfile_button.isDisplayed(),"sale_amount_voice_prompt_addfile_button is not displayed or locator changed");          

        logger.log(LogStatus.INFO, "Verifying if sale_amount_voice_prompt_play_button is displayed");
        softassert.assertTrue(sale_amount_voice_prompt_play_button.isDisplayed(),"sale_amount_voice_prompt_play_button is not displayed or locator changed");          
   
    	//Instant insights section -- agent id
        Select select1=new Select(instant_insights_dropdown);
        select1.selectByVisibleText("Agent ID");
        
        logger.log(LogStatus.INFO, "Verifying if agent_ID_voice_prompt_textbox is displayed");
        softassert.assertTrue(agent_ID_voice_prompt_textbox.isDisplayed(),"agent_ID_voice_prompt_textbox is not displayed or locator changed");          

        logger.log(LogStatus.INFO, "Verifying if agent_ID_voice_prompt_addfile_button is displayed");
        softassert.assertTrue(agent_ID_voice_prompt_addfile_button.isDisplayed(),"agent_ID_voice_prompt_addfile_button is not displayed or locator changed");          

        logger.log(LogStatus.INFO, "Verifying if agent_ID_voice_prompt_play_button is displayed");
        softassert.assertTrue(agent_ID_voice_prompt_play_button.isDisplayed(),"agent_ID_voice_prompt_play_button is not displayed or locator changed");          

        
        Select select2=new Select(number_of_digits_in_agent_Id_dropdown);
        System.out.println("size is "+select2.getOptions().size()); 
        logger.log(LogStatus.INFO, "Verifying if number_of_digits_in_agent_Id_dropdown has 1 to 9 digits");
        softassert.assertTrue(select2.getOptions().size()==10,"number_of_digits_in_agent_Id_dropdown does not have 1 to 9 digits");
        
        
        softassert.assertAll();
        
    }
    
    
    
    public void createSimpleNumber(String tracking_number_name) throws InterruptedException{
    	

       wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
//     Util.getJavascriptExecutor().executeScript("window.scrollBy(0,900)"); 
    		
       Util.scrollFunction(header);  
       add_tracking_number_button.click();
    	
//    	tn_list_for_385
    	
    	wait.until(ExpectedConditions.visibilityOf(tracking_number_name_textbox));
    	tracking_number_name_textbox.sendKeys(tracking_number_name);
    	
    	Select selct_ad_source=new Select(ad_source_dropdown);
    	selct_ad_source.selectByIndex(4);
    	
    	ring_to_phone_number_textbox.clear();
    	ring_to_phone_number_textbox.sendKeys("8018786943");

    	area_code_textbox.sendKeys("385");
    	wait.until(ExpectedConditions.invisibilityOf(loading_wheel_for_area_code));
    	
    	for(int i=0;i<area_codes_list_for_385.size();i++){
    		if(area_codes_list_for_385.get(i).getText().contains("ALPINE")){
    			area_codes_list_for_385.get(i).click();
    			
    		}
    		
    	}
    	
    	wait.until(ExpectedConditions.invisibilityOf(loading_wheel_for_tn));
        
//        Util.click(tracking_number_dropdown);
        Select select_tracking_number=new Select(tracking_number_dropdown);
        select_tracking_number.selectByIndex(20);
    	Util.scrollFunction(save_button);
      
    	save_button.click();
    	
    	logger.log(LogStatus.INFO, "Verifying if tracking number is created");
        wait.until(ExpectedConditions.visibilityOf(tn_creation_success_message));
    	softassert.assertTrue(tn_creation_success_message.isDisplayed(),"tracking number is not created successfully..");
    	
 }
    
    
    public void editSimpleNumber(String updated_tracking_number_name) throws InterruptedException{
    	
        wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
     	
     	wait.until(ExpectedConditions.visibilityOf(tracking_number_name_textbox));
     	tracking_number_name_textbox.clear();
     	tracking_number_name_textbox.sendKeys(updated_tracking_number_name);
     	
     	Select selct_ad_source=new Select(ad_source_dropdown);
     	selct_ad_source.selectByIndex(3);
     	
     	ring_to_phone_number_textbox.clear();
     	ring_to_phone_number_textbox.sendKeys("8018786944");

     	 
     	Util.scrollFunction(save_button);
       
     	save_button.click();
     	
     	logger.log(LogStatus.INFO, "Verifying if tracking number is updated");
         wait.until(ExpectedConditions.visibilityOf(tn_updation_success_message));
     	softassert.assertTrue(tn_updation_success_message.isDisplayed(),"tracking number is not updated successfully..");
     	
     	softassert.assertAll();
     	
  }
    
    public void createNumberPool(String tracking_number_name) throws InterruptedException{
    	

        wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
//      Util.getJavascriptExecutor().executeScript("window.scrollBy(0,900)"); 
     		
        Util.scrollFunction(header);  
        add_tracking_number_button.click();
        
        wait.until(ExpectedConditions.visibilityOf(number_pool_button));
        try{
        Util.click(number_pool_button);
        }catch(Exception e){
        	e.printStackTrace();
        }
//     	tn_list_for_385
    	area_code_textbox.sendKeys("385");
     	wait.until(ExpectedConditions.invisibilityOf(loading_wheel_for_area_code));
     	
     	for(int i=0;i<area_codes_list_for_385.size();i++){
     		if(area_codes_list_for_385.get(i).getText().contains("ALPINE")){
     			area_codes_list_for_385.get(i).click();
     			
     		}
     		
     	}
      
     	wait.until(ExpectedConditions.visibilityOf(tracking_number_name_textbox));
     	tracking_number_name_textbox.sendKeys(tracking_number_name);
     	
     	Select selct_ad_source=new Select(ad_source_dropdown);
     	selct_ad_source.selectByIndex(4);
     	
     	ring_to_phone_number_textbox.clear();
     	ring_to_phone_number_textbox.sendKeys("8018786943");

//     	number_pool_quantity_textbox.clear();
     	number_pool_quantity_textbox.sendKeys("1");     
     	
     	Util.scrollFunction(save_button);
       
     	save_button.click();
     	
     	logger.log(LogStatus.INFO, "Verifying if tracking number is created");
        try{
     	wait.until(ExpectedConditions.visibilityOf(tn_creation_success_message));
        }catch(Exception e){
        	driver.switchTo().activeElement();
            Util.Action().moveToElement(ok_button_number_pool_label_create_alert).click().perform();
         	wait.until(ExpectedConditions.visibilityOf(tn_creation_success_message));        	
        }

     	softassert.assertTrue(tn_creation_success_message.isDisplayed(),"number pool is not created successfully..");
     	
  }

    

    public void editNumberPool(String updated_tracking_number_name) throws InterruptedException{
    	
        wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
     	
     	wait.until(ExpectedConditions.visibilityOf(tracking_number_name_textbox));
     	tracking_number_name_textbox.clear();
     	tracking_number_name_textbox.sendKeys(updated_tracking_number_name);
     	
     	Select selct_ad_source=new Select(ad_source_dropdown);
     	selct_ad_source.selectByIndex(3);
     	
     	ring_to_phone_number_textbox.clear();
     	ring_to_phone_number_textbox.sendKeys("8018786944");

     	 
     	Util.scrollFunction(save_button);
       
     	save_button.click();
     	
     	logger.log(LogStatus.INFO, "Verifying if tracking number is updated");
     	try{
         wait.until(ExpectedConditions.visibilityOf(tn_updation_success_message));
     	}catch(Exception e){
     		driver.switchTo().activeElement();
            Util.Action().moveToElement(ok_button_number_pool_label_create_alert).click().perform();
         	wait.until(ExpectedConditions.visibilityOf(tn_updation_success_message));
     	}
     	softassert.assertTrue(tn_updation_success_message.isDisplayed(),"tracking number is not updated successfully..");
     	
     	softassert.assertAll();
     	
  }
    
    
    
       public void createReserveNumber(String tracking_number_name,String tn) throws InterruptedException{
    	

        wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
//      Util.getJavascriptExecutor().executeScript("window.scrollBy(0,900)"); 
     		
        Util.scrollFunction(header);  
        add_tracking_number_button.click();
        
        wait.until(ExpectedConditions.visibilityOf(reserved_number_button));
        try{
        Util.click(reserved_number_button);
        }catch(Exception e){
        	e.printStackTrace();
        }

        Select select=new Select(reserved_number_dropdown);
        select.selectByValue(tn);
        
        
     	wait.until(ExpectedConditions.visibilityOf(tracking_number_name_textbox));
     	tracking_number_name_textbox.sendKeys(tracking_number_name);
     	
     	Select selct_ad_source=new Select(ad_source_dropdown);
     	selct_ad_source.selectByIndex(4);
     	
     	ring_to_phone_number_textbox.clear();
     	ring_to_phone_number_textbox.sendKeys("8018786943");
  
     	
     	Util.scrollFunction(save_button);
       
     	save_button.click();
     	
     	logger.log(LogStatus.INFO, "Verifying if reserve number is created");
        try{
        	driver.switchTo().activeElement();
            Util.Action().moveToElement(ok_button_number_pool_label_create_alert).click().perform();
         	wait.until(ExpectedConditions.visibilityOf(tn_creation_success_message));  
     	
        }catch(Exception e){
        	wait.until(ExpectedConditions.visibilityOf(tn_creation_success_message));
        }

     	softassert.assertTrue(tn_creation_success_message.isDisplayed(),"reserve number is not created successfully..");
     	
  } 
    
    
    
       public void editReserveNumber(String updated_tracking_number_name) throws InterruptedException{
       	
           wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
        	
        	wait.until(ExpectedConditions.visibilityOf(tracking_number_name_textbox));
        	tracking_number_name_textbox.clear();
        	tracking_number_name_textbox.sendKeys(updated_tracking_number_name);
        	
        	Select selct_ad_source=new Select(ad_source_dropdown);
        	selct_ad_source.selectByIndex(3);
        	
        	ring_to_phone_number_textbox.clear();
        	ring_to_phone_number_textbox.sendKeys("8018786944");

        	 
        	Util.scrollFunction(save_button);
          
        	save_button.click();
        	
        	logger.log(LogStatus.INFO, "Verifying if reserve number is updated");
        	try{
        		driver.switchTo().activeElement();
                Util.Action().moveToElement(ok_button_number_pool_label_create_alert).click().perform();
             	wait.until(ExpectedConditions.visibilityOf(tn_updation_success_message));
            
        	}catch(Exception e){
        		wait.until(ExpectedConditions.visibilityOf(tn_updation_success_message));
        	}
        	softassert.assertTrue(tn_updation_success_message.isDisplayed(),"reserve number is not updated successfully..");
        	
        	softassert.assertAll();
        	
     }
    
    
    
    
    
    
    
}
