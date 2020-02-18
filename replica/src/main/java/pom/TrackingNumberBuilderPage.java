package pom;

import java.util.List;
import java.util.NoSuchElementException;

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

	@FindBy(xpath="//md-radio-button[@id='optionsRadios2']/div[2]")
	private static WebElement number_pool_button;

	@FindBy(xpath="//label[text()='Quantity']//parent::div//following-sibling::div//input")
	private static WebElement number_pool_quantity;
	
	@FindBy(xpath="//md-radio-button[@id='optionsRadios3']")
	private static WebElement reserved_number_label;

	@FindBy(xpath="//md-radio-button[@id='optionsRadios3']/div[2]")
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
	
	@FindBy(xpath="(//label[contains(text(),'voice prompt')]//parent::*//following-sibling::div//textarea)[2]")
	private WebElement play_voice_prompt_textbox;
	
	@FindBy(xpath="(//label[contains(text(),'Play whisper message before connecting')]//parent::*//following-sibling::div//textarea)[1]")
	private WebElement play_whisper_message_textbox;
	
	
	//Dynamic Number Section
	
	@FindBy(xpath="//label[contains(text(),'Dynamic Number')]")
	private static WebElement dynamic_number_label;
	
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
	private WebElement custom_parameters;
	
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
    public WebElement getgroup(String tracking_number_name,String button_name){
		
		WebElement webelement = driver.findElement(By.xpath("//span[contains(text(),'"+tracking_number_name+"')]//ancestor::tr//div//button[text()='"+button_name+"']"));
		return webelement;
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
    	softassert.assertEquals(dbCount, String.valueOf(tracking_numbers_count_in_table.size()),"count  of listed tracking numbers is mismatching with db count");
        
        
        
        
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
        }
        
    }
    
    
    
    public void createSimpleNumber(String tracking_number_name) throws InterruptedException{
    	

       wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
//     Util.getJavascriptExecutor().executeScript("window.scrollBy(0,900)"); 
    		
       Util.scrollFunction(add_tracking_number_button);  
       add_tracking_number_button.click();
    	
//    	tn_list_for_385
    	
    	wait.until(ExpectedConditions.visibilityOf(tracking_number_name_textbox));
    	tracking_number_name_textbox.sendKeys(tracking_number_name);
    	
    	Select selct_ad_source=new Select(ad_source_dropdown);
    	selct_ad_source.selectByIndex(2);
    	
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
        select_tracking_number.selectByIndex(4);
    	Util.scrollFunction(save_button);
      
    	save_button.click();
    	
    	logger.log(LogStatus.INFO, "Verifying if tracking number is created");
        wait.until(ExpectedConditions.visibilityOf(tn_creation_success_message));
    	softassert.assertTrue(tn_creation_success_message.isDisplayed(),"tracking number is not created successfully..");
    	logger.log(LogStatus.INFO, "tracking number created sucessfully");
    	
 }
	


    
}
