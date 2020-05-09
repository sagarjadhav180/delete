package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

import tests.TestBase;
import tests.Util;

public class LegacyScheduledReportsPage extends TestBase {
	
	
	@FindBy(xpath="//div[@ class='pageProgressLoader']")
	private WebElement loadingWheel;
	
	@FindBy(xpath="//h1[contains(text(),'Legacy Scheduled Reports')]")
	private WebElement legacy_scheduled_reports_label;	
	
	@FindBy(xpath="//a[@class='btn btn-sm btn-default'][contains(text(),'Add Scheduled Report')]")
	private WebElement add_scheduled_report_button;	
	
	@FindBy(xpath="//span[contains(text(),'Export as')]")
	private WebElement export_button;	

	@FindBy(xpath="(//span[contains(text(),'Export as')]//parent::button//following-sibling::ul//li//a[contains(text(),'Excel')])[1]")
	private WebElement export_excel_button;	

	@FindBy(xpath="(//span[contains(text(),'Export as')]//parent::button//following-sibling::ul//li//a[contains(text(),'TSV')])[1]")
	private WebElement export_tsv_button;	
	
	@FindBy(xpath="//table[@id='scheduledreportstable']//thead//tr[1]//th")
	private List<WebElement> actual_column_labels;
	
	String[] expected_column_labels={"Name","Report","Creator","Dist List","Freq","Format","Status","Actions"};
	
	//pagination toolbox
	
	@FindBy(xpath="(//button[contains(text(),'First')])[1]")
	private static WebElement first_button;	
		
	@FindBy(xpath="(//button[contains(text(),'Last')])[1]")
	private static WebElement last_button;
		
	@FindBy(xpath="(//button[contains(text(),'Prev')])[1]")
	private static WebElement prev_button;	
		
	@FindBy(xpath="(//button[contains(text(),'Next')])[1]")
	private static WebElement next_button;
		
	@FindBy(xpath="(//button[contains(text(),'Showing')])[1]")
	private static WebElement pagination_count;	
	
	@FindBy(xpath="//table[@id='scheduledreportstable']//tbody//tr")
	private static List<WebElement> table_count;	

	@FindBy(xpath="//button[@class='btn btn-primary'][text()='OK']")
	private static WebElement ok_button_scheduled_report_deletion_message;	

	@FindBy(xpath="//button[@class='btn btn-default'][text()='Cancel']")
	private static WebElement cancel_button_scheduled_report_deletion_message;
	
	@FindBy(xpath="//div[@class='ui-pnotify-text'][text()='Your report is being processed.']")
	private static WebElement send_now_confirmation_message;	
	

	SoftAssert softassert=new SoftAssert();
	
	
	public LegacyScheduledReportsPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}

	static int counter=0;
	public static LegacyScheduledReportsPage intanceLegacySchedule(){
		
		LegacyScheduledReportsPage sp = null;
		if(counter==0){
			sp=new LegacyScheduledReportsPage(driver);
			return sp;
		}
		else{
		return sp;
		}
	}
	

	//to get action button of desired schedule  
    public void clickAction(String schedule_name,String button_name) throws InterruptedException{
		
    	if(schedule_name!=""){
    		
    		WebElement webelement = driver.findElement(By.xpath("//table[@id='scheduledreportstable']//tbody//tr//td[text()='"+schedule_name+"']//parent::tr//child::button[contains(text(),'"+button_name+"')]"));
    		System.out.println(webelement);
    		webelement.click();	
    		
    		if(button_name.contains("Delete")){
    			driver.switchTo().activeElement();
    			Util.click(ok_button_scheduled_report_deletion_message);
    		}
    		else if(button_name.contains("Send Now")){
    			wait.until(ExpectedConditions.visibilityOf(send_now_confirmation_message));
    			logger.log(LogStatus.INFO, "Verifying if mail is sent");
    			Assert.assertTrue(send_now_confirmation_message.isDisplayed(),"mail is not sent");
    		}
    	}
		
		
		else if(button_name.contains("Add Scheduled Report")){
			wait.until(ExpectedConditions.attributeContains(add_scheduled_report_button, "aria-disabled", "false"));
			add_scheduled_report_button.click();
		}
		
		else if(button_name.contains("Export as")){
			export_button.click();
		}
		Thread.sleep(2000);
		

    }

    //verification of buttons in top pagination toolbox
    public void paginationToolboxUI(){

    	
    	logger.log(LogStatus.INFO, "verifying presence of buttons in top pagination toolbox");
    	wait.until(ExpectedConditions.visibilityOf(first_button));
    	softassert.assertTrue(first_button.isDisplayed(),"first_button is not present or locator changed");
    	softassert.assertTrue(last_button.isDisplayed(),"last_button is not present or locator changed");	
    	softassert.assertTrue(next_button.isDisplayed(),"next_button is not present or locator changed");	
    	softassert.assertTrue(prev_button.isDisplayed(),"prev_button is not present or locator changed");    	
    	softassert.assertAll();
    
    }
    
	public void paginationCount(){
		
		if(table_count.size()>100){
	    	String db_count = Util.readingFromDB("SELECT count(*) as count FROM report_sched WHERE org_unit_id='"+TestBase.getOrg_unit_id()+"'");			
			String ui_count = pagination_count.getText().substring(pagination_count.getText().indexOf('f')+2);
			
	    	System.out.println("table_count "+ui_count);
	    	System.out.println("db count "+db_count);
	    	logger.log(LogStatus.INFO, "Verifying if table count is matching with db count");
	    	Assert.assertTrue(db_count.equals(String.valueOf(ui_count)),"Tabel count is not matching with db count");
		}
	}
	
    public void tableCount(){

    	int final_count=table_count.size()+0;

    	if(!(next_button.getAttribute("class").endsWith("disabled"))){
    		next_button.click();
			final_count=final_count+table_count.size();
			
    	}	
    	
    	String db_count = Util.readingFromDB("SELECT count(*) as count FROM report_sched WHERE org_unit_id='"+TestBase.getOrg_unit_id()+"' AND report_status='active'");
    
    	System.out.println("table_count "+final_count);
    	System.out.println("db count "+db_count);
    	logger.log(LogStatus.INFO, "Verifying if table count is matching with db count");
    	Assert.assertTrue(db_count.equals(String.valueOf(final_count)),"Tabel count is not matching with db count");
	
    }
	
    public void headerLabel(){
    	
    	logger.log(LogStatus.INFO, "Verifying if header label is dispalyed");
    	Assert.assertTrue(legacy_scheduled_reports_label.isDisplayed(),"header label is not displayed or locator changed");
    	
    }
    
    public void scheduleButton(){
    	
    	logger.log(LogStatus.INFO, "Verifying if add schedule button is displayed");
    	softassert.assertTrue(add_scheduled_report_button.isDisplayed(),"Add schedule report button is not displayed or locator changed");
    	
    	logger.log(LogStatus.INFO, "Verifying if add schedule report button is clickable");
    	softassert.assertTrue(add_scheduled_report_button.isEnabled(),"Add schedule report button is not enabled");
    	softassert.assertAll();
    }
    
    public void exportButton(){
    	logger.log(LogStatus.INFO, "Verifying if export button is displayed");
    	softassert.assertTrue(export_button.isDisplayed(),"export button is not displayed or locator changed");
    	
    	logger.log(LogStatus.INFO, "Verifying if export button is clickable");
    	softassert.assertTrue(export_button.isEnabled(),"export button is not enabled");
    	softassert.assertAll();
    }
    
    public void exportButtonOptions(){
    	
    	logger.log(LogStatus.INFO, "Verifying options present in export button");
    	
    	export_button.click();
    	softassert.assertTrue(export_excel_button.isDisplayed(),"excel option not present for export");
    	softassert.assertTrue(export_tsv_button.isDisplayed(),"tsv option not present for export");
    	export_button.click();
    	softassert.assertAll();
    }
    
    public void columnNames(){
    	
    	for(int i=0;i<actual_column_labels.size();i++){
    		
    		for(int j=0;j<expected_column_labels.length;j++){
    			
    			if(actual_column_labels.get(i).getText().equals(expected_column_labels[j])){
    				
    				logger.log(LogStatus.INFO, "Verifying if "+expected_column_labels[j]+" column is present");
    				softassert.assertTrue(actual_column_labels.get(i).getText().equals(expected_column_labels[j]),expected_column_labels[j]+" column is not present");
    			}
    		}
    	}
    	softassert.assertAll();
    }
    
    public void editReport(){
    	
    }
    
    public void deleteReport(){
    	
    }
    
    public void sendNowReport(){
    	
    }
    
    
    

}
