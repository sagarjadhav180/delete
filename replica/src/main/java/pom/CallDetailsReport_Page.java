package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import tests.CallDetailReportTest;
import tests.TestBase;
import tests.Util;

public class CallDetailsReport_Page extends TestBase{

	@FindBy(xpath="//div[@class='pageProgressLoader']")
	private static WebElement loading_wheel;
	
    @FindBy(xpath="//h1[contains(text(),'Call Details')]")
	private static WebElement callDetails_header;
	
    @FindBy(xpath="//div[contains(text(),'Loading Data...')]")
	private static WebElement loading_data_label;

    @FindBy(xpath="//div[contains(text(),'No Data Found')]")
	private static WebElement no_data_found_label;

    
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
    
	//date range
    @FindBy(xpath="//button[@class='btn btn-lg btn-default ng-isolate-scope']")
	private static WebElement dateRange_filter;

    @FindBy(xpath="//div[@class='ranges']//ul//li")
	private static List<WebElement> actual_dateRange_filter_elements;    

    @FindBy(xpath="//div[6]//button[1][text()='OK']")
	private static WebElement ok_button_dateRange_filter;

    @FindBy(xpath="//button[2][text()='Cancel']")
	private static WebElement cancel_button_dateRange_filter;
    
    String[] expected_dateRange_filter_elements={"Today","Yesterday","Last 7 Days","Last 30 Days","This Month","Last Month","Custom Range"};
    
	@FindBy(xpath="//a[@class='btn btn-sm btn-default'][text()='Schedule Report']")
	private static WebElement scheduleReport_button;
	
	@FindBy(xpath="//button[@class='btn btn-sm btn-default btn-last dropdown-toggle']")
	private static WebElement export_button;

	@FindBy(xpath="//div[@class='col-md-3 col-lg-2 mb10 noDataSelector ng-binding'][contains(text(),'Showing')]")
	private static WebElement showing_label;

	//basic search
	@FindBy(xpath="//input[@id='simpleChart']")
	private static WebElement basic_search_textbox;
	
	@FindBy(xpath="//input[@id='simpleChart']//parent::div//button[1]")
	private static WebElement basic_search_button;
	
	@FindBy(xpath="//input[@id='simpleChart']//parent::div//button[2]")
	private static WebElement basic_search_cancel_button;

	@FindBy(xpath="//button[@class='btn btn-default btn-block btn-adv'][text()='Advanced Filter']")
	private static WebElement advanced_filter_button;	
	
	@FindBy(xpath="//i[@class='fa fa-columns']")
	private static WebElement column_Picker_button;

	@FindBy(xpath="//table[@id='calldetailstable']//thead//tr//th")
	private static List<WebElement> actual_column_names;

	String[] expected_column_names={"Date/Time","Group Name","Campaign","Ad Source","Caller ID","Tracking Number","Destination Name | No.","Duration","Disposition","Line Type","Agent","Actions"};

	//action buttons
	@FindBy(xpath="(//table[@id='calldetailstable']//tbody//tr[1]//td//button)[1]")
	private static WebElement play_call_button;	
	
	@FindBy(xpath="(//table[@id='calldetailstable']//tbody//tr[1]//td//button)[2]")
	private static WebElement i_button;		

	@FindBy(xpath="(//table[@id='calldetailstable']//tbody//tr[1]//td//button)[3]")
	private static WebElement blockcall_button;		

	@FindBy(xpath="(//table[@id='calldetailstable']//tbody//tr[1]//td//button)[4]")
	private static WebElement downloadcall_button;		

	@FindBy(xpath="(//table[@id='calldetailstable']//tbody//tr[1]//td//button)[5]")
	private static WebElement email_button;		
	
	//Pagination
	@FindBy(xpath="//button[text()='First']")
	private static WebElement first_button;	
	
	@FindBy(xpath="//button[text()='Prev 100']")
	private static WebElement prev_100_button;
	
	@FindBy(xpath="//button[text()='Next 100']")
	private static WebElement next_100_button;	

	@FindBy(xpath="//button[text()='Last']")
	private static WebElement last_button;
	
	@FindBy(xpath="//button[contains(text(),'Showing')]")
	private static WebElement pagination_call_count_label;

	@FindBy(xpath="//div[@class='player-container']")
	private static WebElement audio_player;	

	@FindBy(xpath="//div[@class='tab-content']")
	private static WebElement inforamtion_tab;	

	@FindBy(xpath="//div[@class='tab-content']//strong")
	private static List<WebElement> inforamtion_section_labels;

	@FindBy(xpath="(//ul[@class='nav nav-tabs']//div)[1]")
	private static WebElement inforamtion_button;	
		
	@FindBy(xpath="(//ul[@class='nav nav-tabs']//div)[2]")
	private static WebElement comments_button;	

	@FindBy(xpath="(//ul[@class='nav nav-tabs']//div)[3]")
	private static WebElement tags_button;	
	
	String[] expected_inforamtion_section={"Name and Address","Conversation","Session"};
	
	@FindBy(xpath="//form[@id='commentForm']")
	private static WebElement comment_section;		

	@FindBy(xpath="//form[@id='commentForm']//div//label[contains(text(),'Comment:')]")
	private static WebElement comment_label;			

	@FindBy(xpath="//form[@id='commentForm']//div//textarea[@name='commenttext']")
	private static WebElement comment_textbox;
	
	@FindBy(xpath="//form[@id='commentForm']//div//input")
	private static WebElement add_comment_button;

	@FindBy(xpath="//form[@name='calltagForm']")
	private static WebElement tag_section;

	@FindBy(xpath="//form[@name='calltagForm']//div//label[contains(text(),'Select Tags:')]")
	private static WebElement select_tags_label;

	@FindBy(xpath="//form[@name='calltagForm']//div//input[@title='Save Call Tag Button']")
	private static WebElement save_tag_button;

	@FindBy(xpath="//form[@name='calltagForm']//div//ul[@class='select2-choices']")
	private static WebElement tag_textbox;
	
	@FindBy(xpath="//table[@id='calldetailstable']//tbody//tr//td//button[@title='Toggle Call Info']")
	private static List<WebElement> information_icon_button;

	@FindBy(xpath="//table[@id='calldetailstable']//tbody//tr//td//button[@title='Listen to call']")
	private static List<WebElement> play_audio_button;

	@FindBy(xpath="//table[@id='calldetailstable']//tbody//tr//td//button[@title='Email Call']")
	private static List<WebElement> email_call_button;
	
	@FindBy(xpath="//table[@id='calldetailstable']//tbody//tr")
	private static List<WebElement> table_call_count;	

	//advance filter
	@FindBy(xpath="//div[@class='advancedf']//select[1]")
	private static WebElement include_exclude_listbox;
	String[] expected_include_exclude_listbox={"Include","Exclude"};
	
	@FindBy(xpath="//div[@class='advancedf']//select[2]")
	private static WebElement advance_filter_elements_listbox;
	String[] expected_advance_filter_elements={"Call ID","Date","Group Name","Campaign Name","Ad Source","Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5","Caller ID","Tracking Number","Destination Name","Destination Number","Duration","Route Name","Tag","Caller/Company Name","Address","City","State/Province","Zip/Postal Code","Disposition","Line Type","Sent to Voicemail","Hunt Type","Tracking Number Type"};

	@FindBy(xpath="//button[@class='btn btn-gray']")
	private static WebElement add_advance_filter_button;

	@FindBy(xpath="//div[@class='advancedf']//select[3]//following-sibling::input[1]")
	private static WebElement advance_filter_textbox;
	
	@FindBy(xpath="//button[@class='btn btn-primary'][contains(text(),'Apply')]")
	private static WebElement apply_button;

	@FindBy(xpath="//button[@class='btn btn-default'][contains(text(),'Cancel')]")
	private static WebElement cancel_button;
	
	@FindBy(xpath="//ul[@id='columnpicker']//li//label")
	private static List<WebElement> all_actual_column_picker_options_labels;

	@FindBy(xpath="//ul[@id='columnpicker']//li//input")
	private static List<WebElement> column_picker_options_checkboxes;

	String[] expected_all_column_picker_options={"Date/Time","Group Name","Campaign","Ad Source","Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5","Caller ID","Tracking Number","Hunt Type","Number Type","Destination Name | No.","Duration","Caller Name","Company Name","Address","City","State/Province","Disposition","Line Type","Sent to Voicemail","Agent","Actions"};
	
	String[] expected_default_checked_column_picker_options={"Date/Time","Group Name","Campaign","Ad Source","Caller ID","Tracking Number","Destination Name | No.","Duration","Disposition","Line Type","Agent","Actions"};
	
	private CallDetailsReport_Page(WebDriver driver){
	  PageFactory.initElements(driver, this);
    }
	
	static CallDetailsReport_Page cd;
	static int counter=0;
	
	public static CallDetailsReport_Page instance(){
		if(counter==0){
		cd=new CallDetailsReport_Page(driver);
		counter++;
		}
		return cd;
		
	}
	
	public void UIVerification() throws InterruptedException{
	    SoftAssert softassert=new SoftAssert();		
		wait.until(ExpectedConditions.visibilityOf(callDetails_header));
		logger.log(LogStatus.INFO, "verifying if callDetails_header is displayed");
		softassert.assertTrue(callDetails_header.isDisplayed(),"callDetails_header is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "Verifying if dateRange_filter is displayed");
		softassert.assertTrue(dateRange_filter.isDisplayed(),"dateRange_filter is not displayed or locator changed");
		
		Util.click(dateRange_filter);
		logger.log(LogStatus.INFO, "verifying if daterange filter elements are present");
		
		for(int i=0;i<actual_dateRange_filter_elements.size();i++){
			
			for(int j=0;j<expected_dateRange_filter_elements.length;j++){
				if(actual_dateRange_filter_elements.get(i).getText().equals(expected_dateRange_filter_elements[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_dateRange_filter_elements[j]+" is present");
					softassert.assertTrue(actual_dateRange_filter_elements.get(i).getText().equals(expected_dateRange_filter_elements[j]),"filter element "+expected_dateRange_filter_elements[j]+" is not present or locator changed");
					break;
				}
			}
		}


		Util.click(cancel_button_dateRange_filter);
		Thread.sleep(2000);
		
		logger.log(LogStatus.INFO, "verifying if scheduleReport_button is displayed");
		softassert.assertTrue(scheduleReport_button.isDisplayed(),"scheduleReport_button is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "verifying if export_button is displayed");
		softassert.assertTrue(export_button.isDisplayed(),"export_button is not displayed or locator changed");
	
		logger.log(LogStatus.INFO, "verifying if showing_label is present");
		softassert.assertTrue(showing_label.isDisplayed(),"showing_label is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "verifying play_call_button is present");
		softassert.assertTrue(play_call_button.isDisplayed(),"play_call_button is not displayed or locator changed");
        
		logger.log(LogStatus.INFO, "verifying if information_button is displayed");
		softassert.assertTrue(i_button.isDisplayed(),"information_button is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "verifying blockcall_button is displayed");
		softassert.assertTrue(blockcall_button.isDisplayed(),"blockcall_button is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "verifying if downloadcall_button is displayed");
		softassert.assertTrue(downloadcall_button.isDisplayed(),"downloadcall_button is not displayedd or locator changed");
		
		logger.log(LogStatus.INFO, "verifying if email_button is displayed");
		softassert.assertTrue(email_button.isDisplayed(),"email_button is not displayed or locator changed");
	
		
		logger.log(LogStatus.INFO, "verifying if basic_search_textbox is displayed");
		softassert.assertTrue(basic_search_textbox.isDisplayed(),"basic_search_textbox is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "verifying if basic_search_button is presnet");
		softassert.assertTrue(basic_search_button.isDisplayed(),"basic_search_button is not present or locator changed");
		
		logger.log(LogStatus.INFO, "verifying if basic_search_cancel_button is present");
		softassert.assertTrue(basic_search_cancel_button.isDisplayed(),"basic_search_cancel_button is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "verifying if advanced_filter_button is present");
		softassert.assertTrue(advanced_filter_button.isDisplayed(),"advanced_filter_button is not displayed or locator chnaged");
		
		logger.log(LogStatus.INFO, "Verifying if column_Picker_button is present");
		softassert.assertTrue(column_Picker_button.isDisplayed(),"column_Picker_button is not displayed or locator changed");
		
		
		softassert.assertAll();	
	}  

	public void paginationButtons(){
        
	    SoftAssert softassert=new SoftAssert();
		//verifying if all buttons are displayed in pagination toolbox 
		logger.log(LogStatus.INFO, "verifying presence of buttons in pagination toolbox");
		wait.until(ExpectedConditions.visibilityOf(first_button));
	    logger.log(LogStatus.INFO, "verifying if next_100_button is present"); 
		softassert.assertTrue(next_100_button.isDisplayed(),"next 100 button is not present or locator changed");
	    logger.log(LogStatus.INFO, "verifying if prev_100_button is present");
		softassert.assertTrue(prev_100_button.isDisplayed(),"prev 100 button is not present or locator changed");	
		logger.log(LogStatus.INFO, "verifying if prev_100_button is present");
		softassert.assertTrue(first_button.isDisplayed(),"first button is not present or locator changed");	
		logger.log(LogStatus.INFO, "verifying if last_button is present");
		softassert.assertTrue(last_button.isDisplayed(),"last button is not present or locator changed");	
		softassert.assertAll();
		
	}
	
	public void paginationCallCount(){
	    SoftAssert softassert=new SoftAssert();
		//verification of count in pagination toolbox	
	    String endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
		String startDateToBeUsed = Util.getDate("yyyy-MM-dd","-7");

		String dbCount = Util.readingFromDB("SELECT count(*) as count  FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+org_unit_id+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");

		String countOnUI_pagination = pagination_call_count_label.getText().substring(pagination_call_count_label.getText().indexOf('f')+2);
		System.out.println("dbCount is "+dbCount);
		System.out.println("countOnUI_pagination is "+countOnUI_pagination);

		logger.log(LogStatus.INFO, "verifying count in  pagination toolbox");
		softassert.assertEquals(dbCount, countOnUI_pagination,"count in top pagination toolbox is mimatching with db count");
	
		softassert.assertAll();		

	}
	
	public void tableCallCount(){
	    SoftAssert softassert=new SoftAssert();
		//verification of count in pagination toolbox	
	    String endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
		String startDateToBeUsed = Util.getDate("yyyy-MM-dd","-7");

		String dbCount = Util.readingFromDB("SELECT count(*) as count  FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+org_unit_id+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");

		int final_count=table_call_count.size()+0;
		Util.scrollFunction(next_100_button);		
		if(!(next_100_button.getAttribute("class").endsWith("disabled"))){

			Util.click(next_100_button);
			wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
			final_count=final_count+table_call_count.size();
		
		}
		
		System.out.println("dbCount is "+dbCount);
		System.out.println("table_call_count is "+final_count);
				
		logger.log(LogStatus.INFO, "verifying count of listed calls");
		softassert.assertEquals(dbCount, String.valueOf(final_count),"count  of listed campaigns is mimatching with db count");
		softassert.assertAll();
	    
	    
	}
	
	public void allColumnPickerOptions(){
	    SoftAssert softassert=new SoftAssert();
		Util.click(column_Picker_button);
		
		for(int i=0;i<all_actual_column_picker_options_labels.size();i++){
			for(int j=0;j<expected_all_column_picker_options.length;j++){
				
				if(all_actual_column_picker_options_labels.get(i).getText().equals(expected_all_column_picker_options[j])){
					logger.log(LogStatus.INFO, "Verifying if "+expected_all_column_picker_options[j]+" is present ");
					softassert.assertTrue(all_actual_column_picker_options_labels.get(i).getText().equals(expected_all_column_picker_options[j]),"column picker option "+expected_all_column_picker_options[j]+" is not displayed or locator changed");
				}
			}
		}
		softassert.assertAll();
		Util.click(column_Picker_button);
	}
	
	public void defaultColumns(){
	    SoftAssert softassert=new SoftAssert();
        logger.log(LogStatus.INFO, "verifying column names in call detail table");
		
		for(int i=0;i<actual_column_names.size();i++){
			
			for(int j=0;j<expected_column_names.length;j++){
				if(actual_column_names.get(i).getText().equals(expected_column_names[j])){
					logger.log(LogStatus.INFO, "verifying if "+expected_column_names[j]+" is displayed");
					softassert.assertTrue(actual_column_names.get(i).getText().equals(expected_column_names[j]),"column "+expected_column_names[j]+" is not present");
					break;
				}
			}
		}
		softassert.assertAll();
	}
	
	public void allColumns(){
	    SoftAssert softassert=new SoftAssert();
        logger.log(LogStatus.INFO, "verifying column names in call detail table");
		
		for(int i=0;i<actual_column_names.size();i++){
			
			for(int j=0;j<expected_all_column_picker_options.length;j++){

	
				if(actual_column_names.get(i).getText().equals(expected_all_column_picker_options[j])){
					
					logger.log(LogStatus.INFO, "verifying if "+expected_all_column_picker_options[j]+" is displayed");
					softassert.assertTrue(actual_column_names.get(i).getText().equals(expected_all_column_picker_options[j]),"column "+expected_all_column_picker_options+" is not present");
					break;					
				}

			}
		}
		softassert.assertAll();
	}
	
	
	
	public void allColumnPickerCheckboxes(){
	    SoftAssert softassert=new SoftAssert();
		Util.click(column_Picker_button);
		for(int i=0;i<column_picker_options_checkboxes.size();i++){
			
			logger.log(LogStatus.INFO, "verifying if "+column_picker_options_checkboxes.get(i).getText()+" is enabled");
			softassert.assertTrue(column_picker_options_checkboxes.get(i).isEnabled(),column_picker_options_checkboxes.get(i) +" is not enabled");
			
		}
		softassert.assertAll();
		Util.click(column_Picker_button);
	}
	
	public void checkAllColumnPickerOptions(){
	    SoftAssert softassert=new SoftAssert();
		Util.click(column_Picker_button);
		for(int i=0;i<column_picker_options_checkboxes.size();i++){
			
			if(!(column_picker_options_checkboxes.get(i).isSelected())){
				Util.click(column_picker_options_checkboxes.get(i));
			}
		}
		Util.click(column_Picker_button);
	}
	
	public void advancedFilter(){
	    SoftAssert softassert=new SoftAssert();
		Util.click(advanced_filter_button);
		
		logger.log(LogStatus.INFO, "Verifying if include/exclude listbox displayed");
		softassert.assertTrue(include_exclude_listbox.isDisplayed(),"include/exclude listbox not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "verifying options displayed in include/exclude listbox");
		Select select=new Select(include_exclude_listbox);
		
		for(int i=0;i<select.getOptions().size();i++){
			
			for(int j=0;j<expected_include_exclude_listbox.length;j++){
				if(select.getOptions().get(i).getText().equals(expected_include_exclude_listbox[j])){
					
					logger.log(LogStatus.INFO, "verifying if "+expected_include_exclude_listbox[j]+" is displayed");
					softassert.assertTrue(select.getOptions().get(i).getText().equals(expected_include_exclude_listbox[j]),"element "+expected_include_exclude_listbox[j]+"is not present");
					break;
				}
			}
			
		}
		
		logger.log(LogStatus.INFO, "verifying if filter elements listbox is displayed");
		softassert.assertTrue(advance_filter_elements_listbox.isDisplayed(),"filter element listbox is not displayed or locator changed");
		
		Select select1=new Select(advance_filter_elements_listbox);
		
		for(int i=0;i<select1.getOptions().size();i++){
			
			for(int j=0;j<expected_advance_filter_elements.length;j++){
				if(select1.getOptions().get(i).getText().equals(expected_advance_filter_elements[j])){
					System.out.println(expected_advance_filter_elements[j]);
					System.out.println(select1.getOptions().get(i).getText());
					logger.log(LogStatus.INFO, "verifying if "+expected_advance_filter_elements[j]+" is present");
					softassert.assertTrue(select1.getOptions().get(i).getText().equals(expected_advance_filter_elements[j]),"filter element "+expected_advance_filter_elements[j]+" is not present or locator changed");
				}
			}
		}
		
		logger.log(LogStatus.INFO, "Verifying if add advanced filter button is present");
		softassert.assertTrue(add_advance_filter_button.isDisplayed(),"add advanced filter button is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "Verifying if ok button is displayed");
		softassert.assertTrue(apply_button.isDisplayed(),"apply button is not displayed or locator chaanged");

		logger.log(LogStatus.INFO, "Verifying if cancel button is displayed");
		softassert.assertTrue(cancel_button.isDisplayed(),"cancel button is not displayed or locator chaanged");
		Util.click(cancel_button);

		softassert.assertAll();
	}
	
	public void basicFilterFeature(String filterelement){
	    
    	try{
    	wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
    	}catch(Exception e){
 		   	}

		SoftAssert softassert=new SoftAssert();
		int index = 0;
		String filter_value="";
		
		for(int i=0;i<actual_column_names.size();i++){
		
			if(actual_column_names.get(i).getText().equals(filterelement)){
				index=i;
			}
		}
		


			List<WebElement> values = driver.findElements(By.xpath("//table[@id='calldetailstable']//tbody//tr[1]//td"));
			for(int j=0;j<values.size();j++){
			if(index==j){
				
				filter_value=values.get(j).getText();
			}
		}
		
		basic_search_textbox.clear();
		basic_search_textbox.sendKeys(filter_value);
		Util.click(basic_search_button);
		wait.until(ExpectedConditions.visibilityOf(showing_label));
		
		String xPath="//table[@id='calldetailstable']//tbody//tr";
		List<WebElement> rows = driver.findElements(By.xpath(xPath));
		
		for(int k=0;k<rows.size();k++){
			
			List<WebElement> filtered_value = driver.findElements(By.xpath(xPath.concat("//td["+String.valueOf(index+1)+"]")));
			for(int l=0;l<filtered_value.size();l++){
				String actual_value = filtered_value.get(l).getText();
				String expected_value=filter_value;
				softassert.assertTrue(actual_value.contains(expected_value),"value "+actual_value+" is not filteredd value");
			}		
		}

//		basic_search_textbox.clear();
//		Util.click(basic_search_button);
//		wait.until(ExpectedConditions.visibilityOf(showing_label));
		
		logger.log(LogStatus.INFO, "Verifying if basic filter feture is working for "+filter_value);	
		softassert.assertAll();
			
		
	}	
	

	public void advancedFilterFeature(String filterelement){
    	try{
    	wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
    	}catch(Exception e){
 		   	}

		SoftAssert softassert=new SoftAssert();
		int index = 0;
		String filter_value="";
		
		for(int i=0;i<actual_column_names.size();i++){
		
			if(actual_column_names.get(i).getText().equals(filterelement)){
				index=i;
			}
		}
		
		List<WebElement> values = driver.findElements(By.xpath("//table[@id='calldetailstable']//tbody//tr[1]//td"));
		for(int j=0;j<values.size();j++){
			if(index==j){
				filter_value=values.get(j).getText();
				if(filterelement.equals("Line Type")){
					if(filter_value.equals("") || filter_value.equals("null")){
					filter_value="NonFixedVOIP";
					}
				}
			}
		}
		
		advanced_filter_button.click();
		Select select=new Select(advance_filter_elements_listbox);
		select.selectByVisibleText(filterelement);
//		advance_filter_textbox.clear();
		advance_filter_textbox.sendKeys(filter_value);
		Util.click(apply_button);
		
		wait.until(ExpectedConditions.visibilityOf(showing_label));
		
		String xPath="//table[@id='calldetailstable']//tbody//tr";
		List<WebElement> rows = driver.findElements(By.xpath(xPath));
		
		for(int k=0;k<rows.size();k++){
			
			List<WebElement> filtered_value = driver.findElements(By.xpath(xPath.concat("//td["+String.valueOf(index+1)+"]")));
			for(int l=0;l<filtered_value.size();l++){
				String actual_value = filtered_value.get(l).getText();
				String expected_value=filter_value;
				softassert.assertTrue(actual_value.equals(expected_value),"value "+actual_value+" is not filteredd value");
			}		
		}


//		Util.click(cancel_button);
//		wait.until(ExpectedConditions.visibilityOf(showing_label));
		

		logger.log(LogStatus.INFO, "Verifying if advanced filter feture is working for "+filter_value);	
		softassert.assertAll();
		

	}
	
	public void dateRangeFilter(String dateRange){
	    SoftAssert softassert=new SoftAssert();
		String endDateToBeUsed ="";
		String startDateToBeUsed ="";
		
		if(dateRange.equals("Last 7 days")){
			startDateToBeUsed = Util.getDate("yyyy-MM-dd","-7");
			endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
		}
		else if(dateRange.equals("today")){
			startDateToBeUsed = Util.getDate("yyyy-MM-dd","-1");
			endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
		}
		else if(dateRange.equals("yesterday")){
			startDateToBeUsed = Util.getDate("yyyy-MM-dd","-2");
			endDateToBeUsed = Util.getDate("yyyy-MM-dd","-1");
		}
		else if(dateRange.equals("last 30 days")){
			startDateToBeUsed = Util.getDate("yyyy-MM-dd","-30");
			endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
		}

//        try{
//        	wait.until(ExpectedConditions.visibilityOf(showing_label));
//        	
//        	
//        }catch(Exception e){
//        	wait.until(ExpectedConditions.visibilityOf(no_data_found_label));
//        }
        
        
        wait.until(ExpectedConditions.visibilityOf(dateRange_filter));
		Util.click(dateRange_filter);
		
		for(int i=0;i<actual_dateRange_filter_elements.size();i++){
			
			if(dateRange.equalsIgnoreCase(actual_dateRange_filter_elements.get(i).getText())){
		
				Util.Action().moveToElement(actual_dateRange_filter_elements.get(i)).click().perform();
				wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
				break;
			}
		}
		
		

		String dbCount = Util.readingFromDB("SELECT count(*) as count  FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+org_unit_id+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
        
		if(!(dbCount.equals("0") || dbCount.equalsIgnoreCase("null"))){
			int final_count=table_call_count.size()+0;
			
			if(!(next_100_button.getAttribute("class").endsWith("disabled"))){
				Util.scrollFunction(next_100_button);
				Util.click(next_100_button);
				wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
				final_count=final_count+table_call_count.size();
				
		}
		System.out.println("dbCount is "+dbCount);
		System.out.println("table_call_count is "+final_count);	
		logger.log(LogStatus.INFO, "verifying filtur feature is working for "+dateRange+" date range");
		softassert.assertEquals(dbCount, String.valueOf(final_count),"count  of listed calls is mismatching with db count");
		}
		else{
		logger.log(LogStatus.INFO, "verifying if no data found label displayed since no call count is there for date range "+dateRange);			
		softassert.assertTrue(no_data_found_label.isDisplayed(),"no data found label not displayed or locator chamged");
		}
		softassert.assertAll();
		
		
	}
	
	
    public void actionButtonClick(String actionButton){
        SoftAssert softassert=new SoftAssert();
    	List<WebElement> buttons = driver.findElements(By.xpath("//table[@id='calldetailstable']//tbody//tr//td//button[@title='"+actionButton+"']"));
		
		for(int i=0;i<buttons.size();i++){
			
			if(buttons.get(i).isEnabled()){
				
				Util.click(buttons.get(i));
				break;
			}
		}
    	
	}
    	
	
	public void actionSectionVerification(String button,String sectionToVerify){
	    SoftAssert softassert=new SoftAssert();
		if(button.contains("play_button")){
			
			logger.log(LogStatus.INFO, "Verifying if audio player is displayed");
			softassert.assertTrue(audio_player.isDisplayed(),"audio player is dnot displayed or locator changed");
			
		}
		
		else if(button.contains("email_call")){
			
			if(sectionToVerify.equals("mail feature")){
				
				wait.until(ExpectedConditions.visibilityOf(email_this_call_to_textbox));
				email_this_call_to_textbox.sendKeys(CallDetailReportTest.default_mail_id_to);
				email_this_call_message_textbox.sendKeys(CallDetailReportTest.default_mail_id_message);
				Util.click(send_now_mail_button);
				wait.until(ExpectedConditions.visibilityOf(success_message_for_mail_call));
				logger.log(LogStatus.INFO, "Verifying if mail is sent successfully");
				softassert.assertTrue(success_message_for_mail_call.isDisplayed(),"mail was not sent");
				
			}
			else if(sectionToVerify.equals("mail call UI")){
				logger.log(LogStatus.INFO, "Verifyinf if email this call window is opened");
				softassert.assertTrue(email_this_call_window.isDisplayed(),"email thius call window is not opened or locator changed");
				
				logger.log(LogStatus.INFO, "Verifying if To label is present");
				softassert.assertTrue(email_this_call_to_label.isDisplayed(),"email this call to label is not present or locator changed");
				
				logger.log(LogStatus.INFO, "Verifying if from label is present");
				softassert.assertTrue(email_this_call_from_label.isDisplayed(),"Email this call from label is not present");
				
				logger.log(LogStatus.INFO, "Verifying if Message label is displayed");
				softassert.assertTrue(email_this_call_message_label.isDisplayed(),"email this call message label is not present or locator changed");
				
				logger.log(LogStatus.INFO, "Verifying if To textbox is present");
				softassert.assertTrue(email_this_call_to_textbox.isDisplayed(),"Email this call to text box is not present or locator changed");
		
				logger.log(LogStatus.INFO, "Verifying if Message textbox is present");
				softassert.assertTrue(email_this_call_message_textbox.isDisplayed(),"Email this call Message text box is not present or locator changed");

//				logger.log(LogStatus.INFO, "Verifying default from mail id is "+email_this_call_from_textbox.getText());
//				softassert.assertTrue(email_this_call_from_textbox.getText().equals(CallDetailReportTest.default_mail_id_from),"default mail id is incorrect");
				
				logger.log(LogStatus.INFO, "Verifying if Send now button is present");
				softassert.assertTrue(send_now_mail_button.isDisplayed(),"Email this call send now button is not present or locator changed");
				
				logger.log(LogStatus.INFO, "Verifying if cancel button is present");
				softassert.assertTrue(cancel_mail_button.isDisplayed(),"Email this call cancel button is not present or locator changed");				
				Util.click(cancel_mail_button);			
			}

		}
		
		else if(button.contains("inforamtion_icon_button")){
				
			if(sectionToVerify.contains("complete info section")){
			   logger.log(LogStatus.INFO, "Verifying if information section is displayed");
			   softassert.assertTrue(inforamtion_tab.isDisplayed(),"information section is not displayed or locator changed");
			}
			else if(sectionToVerify.contains("info section")){
				inforamtion_button.click();
				for(int i=0;i<inforamtion_section_labels.size();i++){
					for(int j=0;j<expected_inforamtion_section.length;j++){
						
						if(inforamtion_section_labels.get(i).getText().contains(expected_inforamtion_section[j])){
							logger.log(LogStatus.INFO, "Verifying if "+expected_inforamtion_section[j]+" is present");
							softassert.assertTrue(inforamtion_section_labels.get(i).getText().contains(expected_inforamtion_section[j]),"info label "+expected_inforamtion_section[j]+" is not present or locator changed");
						}
					}
				}			
			}
			else if(sectionToVerify.contains("comments")){
				comments_button.click();
				logger.log(LogStatus.INFO, "Verifying if Comments sectionis opened");
				softassert.assertTrue(comment_section.isDisplayed(),"comment section not displayed or locator changed");
				
				logger.log(LogStatus.INFO, "Verifying if comment label is displayed");
				softassert.assertTrue(comment_label.isDisplayed(),"comment label not displayed or locator changed");
				
				logger.log(LogStatus.INFO, "Verifying if add comment button is displayed");
				softassert.assertTrue(add_comment_button.isDisplayed(),"add comment button is not displayed or locator changed");
				
				logger.log(LogStatus.INFO, "Verifying if comment textbox is present");
				softassert.assertTrue(comment_textbox.isDisplayed(),"comment textbox is not displayed or locator changed");
				
			}
			else if(sectionToVerify.contains("tags")){
				
				Util.click(tags_button);
				logger.log(LogStatus.INFO, "Verifyig if tags section is opened");
				softassert.assertTrue(tag_section.isDisplayed(),"tags section is not displayed or locator changed");
				
				logger.log(LogStatus.INFO, "verifying if select tag label is displayed");
				softassert.assertTrue(select_tags_label.isDisplayed(),"select tag label is not displayed or locator changed");
				
				logger.log(LogStatus.INFO, "Verifying if tags textbox is displayed");
				softassert.assertTrue(tag_textbox.isDisplayed(),"tag textbox is not displayed or locator changed");
				
				logger.log(LogStatus.INFO, "Verifying if add tag button is displayed");
				softassert.assertTrue(save_tag_button.isDisplayed(),"add tag button is not displayed or locator changed");
				
			}
			
		}
		
		
		
		
		
		softassert.assertAll();
	}
		
		
		
	
	
	
	
}
