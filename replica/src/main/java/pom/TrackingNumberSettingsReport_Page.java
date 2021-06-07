package pom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import tests.TestBase;
import tests.Util;

public class TrackingNumberSettingsReport_Page extends TestBase{
	

	
	@FindBy(xpath="//div[@class='pageProgressLoader']")
	private static WebElement loading_wheel;
	
    @FindBy(xpath="//h1[contains(text(),'Tracking Number Settings')]")
	private static WebElement trackingNumberSettings_header;
    
    @FindBy(xpath="//div[contains(text(),'Loading Data...')]")
	private static WebElement loading_data_label;
    
	@FindBy(xpath="//a[@class='btn btn-sm btn-default'][text()='Schedule Report']")
	private static WebElement scheduleReport_button;
	
	@FindBy(xpath="//button[@class='btn btn-sm btn-default btn-last dropdown-toggle']")
	private static WebElement export_button;

	@FindBy(xpath="//span[@class='pull-left ng-binding'][contains(text(),'Showing')]")
	private static WebElement showing_label;
	
	@FindBy(xpath="//input[@id='simpleChart']")
	private static WebElement basic_search_textbox;
	
	@FindBy(xpath="//input[@id='simpleChart']//parent::div//button[1]")
	private static WebElement basic_search_button;

	@FindBy(xpath="//input[@id='simpleChart']//parent::div//button[2]")
	private static WebElement basic_search_cancel_button;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-block btn-adv'][text()='Advanced Filter']")
	private static WebElement advanced_filter_button;	
	
	@FindBy(xpath="//div[@class='btn-group dropdown']//i[@class='fa fa-columns']")
	private static WebElement column_Picker_button;
	
	@FindBy(xpath="//table[@id='classflowDataTable']//thead//tr[1]//th")
	private static List<WebElement> actual_column_names;
	
	String[] expected_column_names={" ID"," Tracking Number Name"," Tracking Number"," Type"," Ring-to Phone Number"," Ad Source"," Status"," Group Name"," Campaign name"," DNI"," Record Call"," Play Disclaimer"," Voice Prompt"," Whisper Message"};

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
	
	@FindBy(xpath="//table[@id='classflowDataTable']//tbody//tr")
	private static List<WebElement> table_call_count;
	
	@FindBy(xpath="//div[@class='advancedf']//select[1]")
	private static WebElement include_exclude_listbox;
	String[] expected_include_exclude_listbox={"Include","Exclude"};
	
	@FindBy(xpath="//div[@class='advancedf']//select[2]")
	private static WebElement advance_filter_elements_listbox;
	String[] expected_advance_filter_elements={"Tracking Number ID","Tracking Number Name","Tracking Number","Tracking Number Type","Ring to phone number","Ad Source","Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5","Tracking Number Status","Group name","Campaign Name","DNI Type","Host Domain","Referring Website","Html Class","Custom Parameters","Play Disclaimer","Voice Prompt","Whisper Message","Record Call","Pre-call webhook","Hunt Type","Voicemail"};
	
	@FindBy(xpath="//button[@class='btn btn-gray']")
	private static WebElement add_advance_filter_button;

	@FindBy(xpath="//div[@class='advancedf']//select[3]//following-sibling::input[2]")
	private static WebElement advance_filter_textbox_for_trackingNumber;

	@FindBy(xpath="//div[@class='advancedf']//select[3]//following-sibling::input[1]")
	private static WebElement advance_filter_textbox_for_rest_elements;
	
	@FindBy(xpath="//button[@class='btn btn-primary'][contains(text(),'Apply')]")
	private static WebElement apply_button;

	@FindBy(xpath="//button[@class='btn btn-default'][contains(text(),'Cancel')]")
	private static WebElement cancel_button;

	@FindBy(xpath="//ul[@id='columnpicker']//li//label")
	private static List<WebElement> all_actual_column_picker_options_labels;
	
	@FindBy(xpath="//ul[@id='columnpicker']//li//input")
	private static List<WebElement> column_picker_options_checkboxes;
	
	String[] expected_all_column_picker_options={"Instant Insights", "Instant Insights Config","ID","Tracking Number Name","Tracking Number","Type","Hunt Type","Ring-to Phone Number","Ad Source","Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5","Status","Group Name","Campaign name","DNI","Host Domain","Referring Website","HTML Class","Custom Params","Record Call","Play Disclaimer","Voice Prompt","Whisper Message","Pre-Call Webhook","Voicemail"};
	
	String[] expected_default_checked_column_picker_options={"ID","Tracking Number Name","Tracking Number","Type","Ring-to Phone Number","Ad Source","Status","Group Name","Campaign name","DNI","Record Call","Play Disclaimer","Voice Prompt","Whisper Message"};
	
	private TrackingNumberSettingsReport_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	static TrackingNumberSettingsReport_Page tn;
	static int counter=0;
	
	public static TrackingNumberSettingsReport_Page instance(){
		if(counter==0){
		tn=new TrackingNumberSettingsReport_Page(driver);
		counter++;
		}
		return tn;
		
	}
	
    public void uiVerification() throws InterruptedException{

    	SoftAssert softassert=new SoftAssert();
		wait.until(ExpectedConditions.visibilityOf(trackingNumberSettings_header));
		logger.log(LogStatus.INFO, "verifying if trackingNumberSettings_header is displayed");
		softassert.assertTrue(trackingNumberSettings_header.isDisplayed(),"trackingNumberSettings_header is not displayed or locator changed");
		
				
		logger.log(LogStatus.INFO, "verifying if scheduleReport_button is displayed");
		softassert.assertTrue(scheduleReport_button.isDisplayed(),"scheduleReport_button is not displayed or locator changed");
		
		logger.log(LogStatus.INFO, "verifying if export_button is displayed");
		softassert.assertTrue(export_button.isDisplayed(),"export_button is not displayed or locator changed");
	
		logger.log(LogStatus.INFO, "verifying if showing_label is present");
		softassert.assertTrue(showing_label.isDisplayed(),"showing_label is not displayed or locator changed");
	
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

    public void paginationTrackingNumbersCount(){
    	SoftAssert softassert=new SoftAssert();
    	//verification of count in pagination toolbox	

		String dbCount = Util.readingFromDB("SELECT count(*) as count FROM ce_call_flows WHERE ouid IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id ='"+TestBase.getOrg_unit_id()+"') AND status IN ('active','inactive','referral')");


		String countOnUI_pagination = pagination_call_count_label.getText().substring(pagination_call_count_label.getText().indexOf('f')+2);
		System.out.println("dbCount is "+dbCount);
		System.out.println("countOnUI_pagination is "+countOnUI_pagination);

		logger.log(LogStatus.INFO, "verifying count in  pagination toolbox");
		softassert.assertEquals(dbCount, countOnUI_pagination,"count in top pagination toolbox is mimatching with db count");
	
		softassert.assertAll();		

	}

    public void tableTrackingNumbersCount(){
		//verification of count in pagination toolbox	
    	SoftAssert softassert=new SoftAssert();
		String dbCount = Util.readingFromDB("SELECT count(*) as count FROM ce_call_flows WHERE ouid IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id ='"+TestBase.getOrg_unit_id()+"') AND status IN ('active','inactive','referral')");

		int final_count=table_call_count.size()+0;
		Util.scrollFunction(next_100_button);
		
		if(Integer.parseInt(dbCount)>100) {
			do {
				Util.click(next_100_button);
				wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
				final_count=final_count+table_call_count.size();
			}
			while(!next_100_button.getAttribute("class").endsWith("disabled"));	
		
		}else {
			final_count=table_call_count.size()+0;
		}
		
		System.out.println("dbCount is "+dbCount);
		System.out.println("table_call_count is "+final_count);
				
		logger.log(LogStatus.INFO, "verifying count of tracking numbers in table");
		softassert.assertEquals(dbCount, String.valueOf(final_count),"count  of listed tracking numbers is mismatching with db count");
		softassert.assertAll();
	    Util.click(first_button);	    
	}

    public void allColumnPickerOptions(){
		Util.click(column_Picker_button);
		SoftAssert softassert=new SoftAssert();
		List<String> act_columns = new ArrayList<String>();
		List<String> exp_columns = new ArrayList<String>(Arrays.asList(expected_all_column_picker_options));
		
		for(int i=0;i<all_actual_column_picker_options_labels.size();i++){
			act_columns.add(all_actual_column_picker_options_labels.get(i).getText());
		}
		Collections.sort(act_columns);
		Collections.sort(exp_columns);
		
		softassert.assertEquals(act_columns, exp_columns);
//		for(int i=0;i<all_actual_column_picker_options_labels.size();i++){
//			for(int j=0;j<expected_all_column_picker_options.length;j++){
//				
//				if(all_actual_column_picker_options_labels.get(i).getText().equals(expected_all_column_picker_options[j])){
//					logger.log(LogStatus.INFO, "Verifying if "+expected_all_column_picker_options[j]+" is present ");
//					softassert.assertTrue(all_actual_column_picker_options_labels.get(i).getText().equals(expected_all_column_picker_options[j]),"column picker option "+expected_all_column_picker_options[j]+" is not displayed or locator changed");
//				}
//			}
//		}
		softassert.assertAll();
//		Util.click(column_Picker_button);
		Util.Action().sendKeys(Keys.ESCAPE).perform();
	}

    
    public void defaultColumns(){
    	SoftAssert softassert=new SoftAssert();
        logger.log(LogStatus.INFO, "verifying column names in Tracking Number Settings report table");
		
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
        logger.log(LogStatus.INFO, "verifying column names in Tracking Number Settings Report table");
		
        List<String> act_columns = new ArrayList<String>();
        List<String> exp_columns = new ArrayList<String>(Arrays.asList(expected_all_column_picker_options));
        
        for(int i=0;i<actual_column_names.size();i++) {
        	act_columns.add(actual_column_names.get(i).getText());
        }
        
		Collections.sort(act_columns);
		Collections.sort(exp_columns);
		
		softassert.assertEquals(act_columns, exp_columns);
//		for(int i=0;i<actual_column_names.size();i++){
//			
//			for(int j=0;j<expected_all_column_picker_options.length;j++){
//
//	
//				if(actual_column_names.get(i).getText().equals(expected_all_column_picker_options[j])){
//					
//					logger.log(LogStatus.INFO, "verifying if "+expected_all_column_picker_options[j]+" is displayed");
//					softassert.assertTrue(actual_column_names.get(i).getText().equals(expected_all_column_picker_options[j]),"column "+expected_all_column_picker_options+" is not present");
//					break;					
//				}
//
//			}
//		}
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
//		Util.click(column_Picker_button);
		Util.Action().sendKeys(Keys.ESCAPE).perform();
	}
    
    public void checkAllColumnPickerOptions(){
    	SoftAssert softassert=new SoftAssert();
		Util.click(column_Picker_button);
		for(int i=0;i<column_picker_options_checkboxes.size();i++){
			
			if(!(column_picker_options_checkboxes.get(i).isSelected())){
				Util.click(column_picker_options_checkboxes.get(i));
			}
		}
//		Util.click(column_Picker_button);
		Util.Action().sendKeys(Keys.ESCAPE).perform();		
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
		int index =0;
		String filter_value="";
		System.out.println("----------------------------------");		
		for(int i=0;i<actual_column_names.size();i++){
			System.out.println("actual_column_names "+actual_column_names.get(i));
			System.out.println("actual_column_names --"+actual_column_names.get(i).getText()+"--");
			if(actual_column_names.get(i).getText().equals(filterelement)){
				System.out.println("actual_column_names in loop "+actual_column_names.get(i).getText());
				
				index=i;
				break;
	
			}
		}
		
		
		List<WebElement> values = driver.findElements(By.xpath("//table[@id='classflowDataTable']//tbody//tr[1]//td"));
		for(int j=0;j<values.size();j++){
			if(index==j){
				
				filter_value=values.get(j).getText();
			}
		}

		System.out.println("index is "+index);
		System.out.println("filter_value "+filter_value);
		
		System.out.println("----------------------------------");	
		basic_search_textbox.clear();
		if(filterelement.equals("Tracking Number") ){
		driver.navigate().refresh();
		basic_search_textbox.sendKeys(filter_value);
		Util.click(basic_search_button);
		}
		else{
			basic_search_textbox.sendKeys(filter_value);
			Util.click(basic_search_button);
		}
		wait.until(ExpectedConditions.visibilityOf(showing_label));
		
		String xPath="//table[@id='classflowDataTable']//tbody//tr";
		List<WebElement> rows = driver.findElements(By.xpath(xPath));
		List<WebElement> filtered_value = driver.findElements(By.xpath(xPath.concat("//td["+String.valueOf(index+1)+"]")));
		List<String> actual_values =  new ArrayList<String>();
		
		for(WebElement val:filtered_value) {
			actual_values.add(val.getText());
		}
			
		softassert.assertFalse(!actual_values.contains(filter_value));			
		
		
//		for(int k=0;k<rows.size();k++){
//			
//			List<WebElement> filtered_value = driver.findElements(By.xpath(xPath.concat("//td["+String.valueOf(index+1)+"]")));
//			for(int l=0;l<filtered_value.size();l++){
//				String actual_value = filtered_value.get(l).getText();
//				String expected_value=filter_value;
//				softassert.assertTrue(actual_value.contains(expected_value),"value "+actual_value+" is not filteredd value");
//			}		
//		}

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
		
			if(actual_column_names.get(i).getText().equalsIgnoreCase(filterelement)){
				index=i;
			}
		}
		
		List<WebElement> values = driver.findElements(By.xpath("//table[@id='classflowDataTable']//tbody//tr[1]//td"));
		for(int j=0;j<values.size();j++){
			if(index==j){
				filter_value=values.get(j).getText();
			}
		}
		if(filterelement.equals("Ad Source")){
			driver.navigate().refresh();
	    	wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
		}
		advanced_filter_button.click();
		Select select=new Select(advance_filter_elements_listbox);
		select.selectByVisibleText(filterelement);

//		advance_filter_textbox.clear();
        if(filterelement.equals("Tracking Number")){
		advance_filter_textbox_for_trackingNumber.sendKeys(filter_value);
        }
        else{
        advance_filter_textbox_for_rest_elements.sendKeys(filter_value);
        }
		Util.click(apply_button);
		
		wait.until(ExpectedConditions.visibilityOf(showing_label));
		
		String xPath="//table[@id='classflowDataTable']//tbody//tr";
		List<WebElement> rows = driver.findElements(By.xpath(xPath));
		List<WebElement> filtered_value = driver.findElements(By.xpath(xPath.concat("//td["+String.valueOf(index+1)+"]")));
        List<String> actual_values =  new ArrayList<String>();
		
		for(WebElement val:filtered_value) {
			actual_values.add(val.getText());
		}
			
		softassert.assertFalse(!actual_values.contains(filter_value));			
//		for(int k=0;k<rows.size();k++){
//			
//			List<WebElement> filtered_value = driver.findElements(By.xpath(xPath.concat("//td["+String.valueOf(index+1)+"]")));
//			for(int l=0;l<filtered_value.size();l++){
//				String actual_value = filtered_value.get(l).getText();
//				String expected_value=filter_value;
//				softassert.assertTrue(actual_value.contains(expected_value),"value "+actual_value+" is not filteredd value");
//			}		
//		}


//		Util.click(cancel_button);
//		wait.until(ExpectedConditions.visibilityOf(showing_label));
		

		logger.log(LogStatus.INFO, "Verifying if advanced filter feture is working for "+filter_value);	
		softassert.assertAll();
		

	}
    
    
    
    
    
    
    
    
    
    
    
    

}

