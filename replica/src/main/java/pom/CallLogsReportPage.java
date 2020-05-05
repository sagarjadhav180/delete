package pom;

import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import extentReport.ExtentReportsGenerator;
import tests.TestBase;
import tests.Util;

@SuppressWarnings("unused")
public class CallLogsReportPage extends TestBase {
	

	@FindBy(xpath="//div[@class='ag-body-horizontal-scroll-viewport']")
	private WebElement call_logs_scroll;	
	
	@FindBy(xpath="//strong[text()='Comments']")
	private WebElement comments_column;	
	
	@FindBy(xpath="(//span[text()='Call Logs - Enhanced'])[1]")
	private WebElement call_logs_enhanced_label;	

	@FindBy(xpath="//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span")
	private List<WebElement> tiles_names;	
	
	@FindBy(xpath="//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span[text()='Detailed View']")
	private WebElement detailed_view_tile;

	@FindBy(xpath="//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span[text()='Detailed View']")
	private WebElement loading_wheel_detailed_view;

	@FindBy(xpath="(//span[text()='Call Logs Extended - Enhanced'])[1]")
	private WebElement detailed_view_header;

	@FindBy(xpath="//p[text()='This report is intended for download and/or scheduling. Due to the amount of data available, it may take longer than usual to load. To increase loading speed, the amount of logs available here has been reduced to 100 logs. The full set of logs will be available on the downloaded or scheduled version.']")
	private WebElement detailed_view_header_note;

	@FindBy(xpath="//span[text()='Default Report']")
	private WebElement default_view_tile;
	
	@FindBy(xpath="//div[@class='ag-root-wrapper-body ag-layout-normal']")
	private WebElement detailed_view_table;
	
	@FindBy(xpath="//button[@class='btn run-button embed-view btn-primary'][text()='Run']")
	private WebElement run_button;

	@FindBy(xpath="//div[@class='dropdown-toggle button-xs']/i")
	private WebElement gear_icon;

	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-wide pull-right']//li//a")
	private List<WebElement> gear_icon_options;
	
	String[] expected_gear_icon_options={"Download as PDF...","Download as CSVs","Send","Schedule","Move to Trash"};

	@FindBy(xpath="//span[@class='timezone']")
	private WebElement timezone;
	
	@FindBy(xpath="(//div[@class='vis-container'])[8]")
	private WebElement total_calls_graph;		
	
	@FindBy(xpath="(//div[@class='vis-container'])[9]")
	private WebElement unique_calls_graph;		
	
	String[] expceted_tile_names={"Total Calls","Unique Calls","Answered Calls","Average Call Duration","Detailed View","Total Leads 0% Of Total Calls","Total Conversion 0% Of Total Calls"};
	
	@FindBy(xpath="//div[@class='ag-header-row']//strong")
	private List<WebElement> table_column_labels;	

	@FindBy(xpath="(//i[@class='icon lk-icon-ellipsis fa fa-rotate-90'])[10]")
	private WebElement table_data_download_icon;	
	
//	@FindBy(xpath="//*[@id='dashboard']/div/div[2]/div/div/div/div/div[2]/div[10]/div/lk-vis-element/div/div/div[2]/div/div/div/lk-visualization-container/div/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div/div//div")
//	private List<WebElement> table_column_labels;	
	
	String[] expeted_table_column_labels={"Actions","Play Call","Duration","Date/Time","Group","Campaign","Tracking Number Name","Tracking Number","Tracking Number Type","Hunt Type","Ad Source","Ring-to Name","Ring to Phone Number","Caller ID","Disposition","Voicemail","Identified Agent","Tags","Comments",};
	
	@FindBy(xpath="//div [@class='body-text text-muted']")
	private WebElement footer_note;	

	
	//Filter section
	@FindBy(xpath="//div[@class='filters clearfix']")
	private WebElement filter_section;		
	
	@FindBy(xpath="//strong[@class='filter-section-title']//i")
	private WebElement filter_button;	
	
	@FindBy(xpath="//div[@class='title no-overflow']//strong//parent::span")
	private List<WebElement> filter_elements_before_expanding;

	@FindBy(xpath="//table[@class='explore-filters clearfix']//tbody//tr//td[@class='filter-name']")
	private List<WebElement> filter_elements_after_expanding;
	
	String[] expected_filter_elements={"Date Range","Show Columns By","Stack Columns By","Ad Source","Call Back","Call ID","Campaign","Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5","Duration","Group","Indicator Name","Indicator Type","Ring-to Name","Ring-to Phone Number","Send to Voicemail","Tags","Tracking Number Name","Tracking Number","Tracking Number Type","User"};

	@FindBy(xpath="//iframe[@id='looker']")
	private WebElement reports_iframe;
	
	SoftAssert softassert=new SoftAssert(); 

	public CallLogsReportPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void switchToIFrame(){
		
		driver.switchTo().frame(reports_iframe);
		
	}
	
	public void goToReport(String reportName){
		
	}
	
	public void headerLabel(){

		wait.until(ExpectedConditions.visibilityOf(call_logs_enhanced_label));
		logger.log(LogStatus.INFO, "verifying if call_logs_enhanced_label is present");
		softassert.assertTrue(call_logs_enhanced_label.isDisplayed(),"call_logs_enhanced_label is not displayed or locator has been chamged..");
				
	}
	
	public void presenceOfGearIcon(){
		
		logger.log(LogStatus.INFO, "Verifying if gear icon is present");
		Assert.assertTrue(gear_icon.isDisplayed(),"Gear icon is not present or locator has been changed.");
	}
	
    public void gearIconOptions() throws InterruptedException{
		
		logger.log(LogStatus.INFO, "Verifying options present in gear icon");
        
		gear_icon.click();
		for(int i=0;i<gear_icon_options.size();i++){
			
			for(int j=0;j<expected_gear_icon_options.length;j++){
				
				if(gear_icon_options.get(i).equals(expected_gear_icon_options[j])){
					logger.log(LogStatus.INFO, "Verifying if "+expected_gear_icon_options[j]+" is present");
					softassert.assertTrue(gear_icon_options.get(i).equals(expected_gear_icon_options[j]),"Gear icon "+expected_gear_icon_options[j]+" is present");
				}
			}
		}
    
		softassert.assertAll();
		gear_icon.click();
		Thread.sleep(1000);

    }
	
    public void presenceOfTimeZone(){
		
    	wait.until(ExpectedConditions.visibilityOf(timezone));
		logger.log(LogStatus.INFO, "Verifying if Time Zone is present");
		Assert.assertTrue(timezone.isDisplayed(),"Time Zone is not present or locator has been changed.");
	}
    
	public void tilesVerification() throws InterruptedException{

		Thread.sleep(7000);
		for(int i=0;i<tiles_names.size();){
			for(int j=0;j<expceted_tile_names.length;j++){

				if(tiles_names.get(i).getText().equals(expceted_tile_names[j])){
					
					wait.until(ExpectedConditions.visibilityOf(tiles_names.get(i)));
					Thread.sleep(1000);
					System.out.println("we -"+tiles_names.get(i).getText());
					System.out.println("array -"+expceted_tile_names[j]);
					logger.log(LogStatus.INFO, "verifying if "+expceted_tile_names[j]+" tile is present");
				
			    softassert.assertEquals(tiles_names.get(i).getText(), expceted_tile_names[j],expceted_tile_names[j]+" is not present");
				}
			}
			i++;
		}
		
	}
	
    public void tileValueVerificationForDefault7DaysFilter(String tile_name){
		
    	String endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
		String startDateToBeUsed = Util.getDate("yyyy-MM-dd","-7");

		String total_call_count_from_db = Util.readingFromDB("SELECT count(*) as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
		String unique_calls_count_from_db = Util.readingFromDB("SELECT count(*) as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59' AND repeat_call='false'");
		String answered_calls_count_from_db = Util.readingFromDB("SELECT count(*) as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59' AND disposition IN ('ANSWERED')");
		String avg_call_duration_from_db = Util.readingFromDB("SELECT ROUND(AVG(duration)) as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
		String total_leads_from_db = Util.readingFromDB("SELECT count(*) as count FROM indicator_score WHERE call_id IN (SELECT call_id FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59') AND indicator_id='51'");
		String total_conversion_from_db = Util.readingFromDB("SELECT score_value as count FROM indicator_score WHERE call_id IN (SELECT call_id FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59') AND indicator_id='18'");		
		
		String tile_values=driver.findElement(By.xpath("//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span[text()='"+tile_name+"']//parent::Div//parent::div/preceding-sibling::div//a")).getText();
	
		if(tile_name.equals("Total Calls")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(total_call_count_from_db!=null){
				System.out.println(tile_values);
				System.out.println(total_call_count_from_db);
				softassert.assertTrue(tile_values.equals(total_call_count_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
		else if(tile_name.equals("Unique Calls")){
			
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(unique_calls_count_from_db!=null){
				System.out.println(tile_values);
				System.out.println(unique_calls_count_from_db);
				softassert.assertTrue(tile_values.equals(unique_calls_count_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
		else if(tile_name.equals("Total Leads")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(total_leads_from_db!=null){
				System.out.println(tile_values);
				System.out.println(total_leads_from_db);
				softassert.assertTrue(tile_values.equals(total_leads_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
		else if(tile_name.equals("Total Conversion")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(total_conversion_from_db!=null){
				System.out.println(tile_values);
				System.out.println(total_conversion_from_db);
				softassert.assertTrue(tile_values.equals(total_conversion_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}	
		else if(tile_name.equals("Answered Calls")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(answered_calls_count_from_db!=null){
				System.out.println(tile_values);
				System.out.println(answered_calls_count_from_db);
				softassert.assertTrue(tile_values.equals(answered_calls_count_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
		else if(tile_values.equals("Average Call Duration")){
			int sec = 0;
			int min = Integer.valueOf(tile_values.substring(0,tile_values.indexOf('m')-1));
	        if(min<=9){
	        	sec = Integer.valueOf(tile_values.substring(6,8));    	
	        }
	        else{
	        	sec = Integer.valueOf(tile_values.substring(7,9));    	        	
	        }
	        min=min*60;
			int final_count=sec+min;
			tile_values=String.valueOf(final_count);
			System.out.println(tile_values);

			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(avg_call_duration_from_db!=null){
				System.out.println(tile_values);
				System.out.println(avg_call_duration_from_db);
				softassert.assertTrue(tile_values.equals(avg_call_duration_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
		
		

		softassert.assertAll();
	}
	
	public void totalCallsGraph(){
		
		Util.scrollFunction(total_calls_graph);
		logger.log(LogStatus.INFO, "verifying if total calls graph is present");
		softassert.assertTrue(total_calls_graph.isDisplayed(),"total calls graph is not displayed or locator has been chamged..");

	}
	
	public void uniqueCallsGraph(){
		
		logger.log(LogStatus.INFO, "verifying if unique calls graph is present");
		softassert.assertTrue(unique_calls_graph.isDisplayed(),"unique calls graph is not displayed or locator has been chamged..");

	}
	
	public void columnsVerification(){
		
		for(int i=0;i<table_column_labels.size();){
			for(int j=0;j<expeted_table_column_labels.length;j++){
				if(table_column_labels.get(i).getText().equals(expeted_table_column_labels[j])){
					wait.until(ExpectedConditions.visibilityOf(table_column_labels.get(i)));
					System.out.println("we-"+table_column_labels.get(i).getText());
					System.out.println("array-"+expeted_table_column_labels[j]);
            	logger.log(LogStatus.INFO, "verifying if "+expeted_table_column_labels[j]+" column is present");
			    softassert.assertEquals(table_column_labels.get(i).getText(), expeted_table_column_labels[j],expeted_table_column_labels[j]+" is not present");				
				}
			}
			i++;

		}

		
	}
	
	public void allColumnVerification() throws InterruptedException{
		
		WebElement actionsColumn = driver.findElement(By.xpath("//div[@class='ag-header-row']//strong[text()='Actions']"));
		actionsColumn.click();

		Util.Action().sendKeys(Keys.TAB).perform();
//		Util.Action().sendKeys(Keys.TAB).perform();
		Thread.sleep(2000);
		
		for(int i=0;i<expeted_table_column_labels.length;i++){
									
			Thread.sleep(1000);
			WebElement column = driver.findElement(By.xpath("//div[@class='ag-header-row']//strong[text()='"+expeted_table_column_labels[i]+"']"));	
			System.out.println("actual column "+column.getText());
			System.out.println("expected column "+expeted_table_column_labels[i]);
			logger.log(LogStatus.INFO, "verifying if "+expeted_table_column_labels[i]+" column is present");
            wait.until(ExpectedConditions.visibilityOf(column));
			softassert.assertEquals(column.getText(), expeted_table_column_labels[i],expeted_table_column_labels[i]+" is not present");				
			if(i<expeted_table_column_labels.length-2){
				Util.Action().sendKeys(Keys.TAB).perform();	
					
			}
			
			if(expeted_table_column_labels[i].equals("Comments")){
				break;
			}
		}
		
		
		
		
		softassert.assertAll();
	}
	
	public void filterButton(){
		
		wait.until(ExpectedConditions.visibilityOf(filter_button));
	    logger.log(LogStatus.INFO, "verifying if filter_button is present");
	    softassert.assertTrue(filter_button.isDisplayed(), "filter_button is not present");
	
	    
	    logger.log(LogStatus.INFO, "verifying if filter_button is enabled");
	    softassert.assertTrue(filter_button.isEnabled(), "filter_button is not enabled");	    
	}

	public void filterElements(){
    
	Util.click(filter_button);
    
    for(int k=0;k<filter_elements_after_expanding.size();){
    	for(int j=0;j<expected_filter_elements.length;j++){

    		if(filter_elements_after_expanding.get(k).getText().equals(expected_filter_elements[j])){
	    			    			    		
    		wait.until(ExpectedConditions.visibilityOf(filter_elements_after_expanding.get(k)));	    		
    		System.out.println("we-"+filter_elements_after_expanding.get(k).getText());
    		System.out.println("array-"+expected_filter_elements[j]);		
    		logger.log(LogStatus.INFO,"verifying if "+expected_filter_elements[j]+" filter is present");
    	    softassert.assertEquals(filter_elements_after_expanding.get(k).getText(),expected_filter_elements[j],expected_filter_elements[j]+" filter element is npt present");
    		}
    		}
    	k++;
    }
	System.out.println("-------------------------------------------------------------------------------");
    
//	//collapsing filter section
	Util.click(filter_button);

		
	}
	
	public void footerNote(){
	
	Util.scrollFunction(footer_note);
	
    wait.until(ExpectedConditions.visibilityOf(footer_note));
	logger.log(LogStatus.INFO, "verifying if footer note is present");
    softassert.assertTrue(footer_note.isDisplayed(), "footer note is not present");
		
	}

	String call_id;
	public void callDataInsertion(){
		
		//getting provisioned_route_id from campign
		String provisioned_route_id = Util.readingFromDB("SELECT provisioned_route_id as count FROM campaign_provisioned_route WHERE campaign_id='"+TestBase.getCampaign_id()+"' LIMIT 1");
		
		//inserting data in call table
		Util.readingFromDB("INSERT INTO call(provisioned_route_id,org_unit_id,disposition,duration,source,tracking,ring_to,repeat_call,call_started,location_route_id) VALUES('"+provisioned_route_id+"','"+TestBase.getOrg_unit_id()+"','ANSWERED','30','3852502145','1111111111','8018786943','false','"+Util.getDate("yyyy-MM-dd", "-2")+" 23:00','-1')");
		this.call_id=Util.readingFromDB("SELECT call_id as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+Util.getDate("yyyy-MM-dd", "-7")+" 23:59' AND '"+Util.getDate("yyyy-MM-dd", "0")+" 23:59' AND tracking='1111111111'");
		
		System.out.println("call_id "+call_id);
		//inserting data in call_detail
		Util.readingFromDB("INSERT INTO call_detail(call_id,bill_second,call_value,is_outbound,call_mine_status,cdr_source,call_ended,call_created,ring_to_name,channel_id,spam_call_checked,hunt_type,tracking_type,is_voicemail,is_dni_call,is_voicemail_checked,usage_component_id,is_premium,usage_type)VALUES ('"+call_id+"','60','32','false','not mined','SP','"+Util.getDate("yyyy-MM-dd", "-2")+" 23:02','"+Util.getDate("yyyy-MM-dd", "-2")+" 23:00','test','2','false','rollover','SimpleRoute','true','false','true','21','false','LOCAL')");
		
	}
	
	public void deleteCallRecord(){
	
		call_id=Util.readingFromDB("SELECT call_id as count  FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.org_unit_id+"')  AND tracking='1111111111'");
		
		Util.readingFromDB("DELETE FROM call WHERE call_id='"+call_id+"'");
		Util.readingFromDB("DELETE FROM call_detail WHERE call_id='"+call_id+"'");
	}
	
	public void filterFeature(String filterName,String filterValue) throws InterruptedException{
		
		filter_button.click();
		
		String xpath="//table[@class='explore-filters clearfix']//tbody//tr//td[@class='filter-name'][text()='"+filterName+"']";
		
		WebElement filter_textbox = driver.findElement(By.xpath(""+xpath+"//parent::tr//select//following-sibling::span"));
	
		wait.until(ExpectedConditions.visibilityOf(filter_textbox));
        Util.Action().moveToElement(filter_textbox).perform();
        Util.Action().click().perform();
	    Util.Action().sendKeys(filterValue).perform();
	    Util.Action().sendKeys(Keys.ESCAPE).perform();	
	
//		filter_textbox.sendKeys(filterValue);
//		Thread.sleep(5000);
//		filter_button.click();
		
		run_button.click();
		filter_button.click();
		Thread.sleep(5000);
		
		int index=0;
		
		for(int i=0;i<table_column_labels.size();i++){
			
			if(table_column_labels.get(i).getText().equals(filterName)){
				
				index=i+1;
				break;
			}
		}
		
		List<WebElement> filtered_values = driver.findElements(By.xpath("//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]"));
		System.out.println("//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]");
		for(int j=0;j<filtered_values.size();j++){
			
			System.out.println(filtered_values.get(j).getText());
			System.out.println(filterValue);
			logger.log(LogStatus.INFO, "Verifying if "+filtered_values.get(j).getText()+" is matching with "+filterValue);
			softassert.assertTrue(filtered_values.get(j).getText().equals(filterValue),"value "+filtered_values.get(j).getText()+" is not filtered value");
		}
		
		
		softassert.assertAll();

        filter_button.click();
		
		wait.until(ExpectedConditions.visibilityOf(filter_textbox));
        Util.Action().moveToElement(filter_textbox).perform();
        Util.Action().click().perform();
        Thread.sleep(1000);
	    Util.Action().sendKeys(Keys.CLEAR).perform();
        Util.Action().sendKeys(Keys.CLEAR).perform();
		Util.Action().sendKeys(Keys.ESCAPE).perform();	
	
		filter_button.click();

	}
	
//	public void uiVerification() throws InterruptedException{
//		
//		driver.switchTo().frame(reports_iframe);
//		
//
//		wait.until(ExpectedConditions.visibilityOf(call_logs_enhanced_label));
//		logger.log(LogStatus.INFO, "verifying if call_logs_enhanced_label is present");
//		softassert.assertTrue(call_logs_enhanced_label.isDisplayed(),"call_logs_enhanced_label is not displayed or locator has been chamged..");
//
//		System.out.println("----------------------------------------tiles_names---------------------------------------");
//		
//		try{
//			Thread.sleep(3000);
//		for(int i=0;i<tiles_names.size();){
//			for(int j=0;j<expceted_tile_names.length;j++){
//
//				if(tiles_names.get(i).getText().equals(expceted_tile_names[j])){
//					
//					wait.until(ExpectedConditions.visibilityOf(tiles_names.get(i)));
//					System.out.println("we -"+tiles_names.get(i).getText());
//					System.out.println("array -"+expceted_tile_names[j]);
//					logger.log(LogStatus.INFO, "verifying if "+expceted_tile_names[j]+" tile is present");
//				
//			    softassert.assertEquals(tiles_names.get(i).getText(), expceted_tile_names[j],expceted_tile_names[j]+" is not present");
//				}
//			}
//			i++;
//		}}
//		catch(Exception e){
//			driver.navigate().refresh();
//			Thread.sleep(7000);
//			}
//		finally{
//			for(int i=0;i<tiles_names.size();){
//				for(int j=0;j<expceted_tile_names.length;j++){
//
//					if(tiles_names.get(i).getText().equals(expceted_tile_names[j])){
//						
//						wait.until(ExpectedConditions.visibilityOf(tiles_names.get(i)));
//						System.out.println("we -"+tiles_names.get(i).getText());
//						System.out.println("array -"+expceted_tile_names[j]);
//						logger.log(LogStatus.INFO, "verifying if "+expceted_tile_names[j]+" tile is present");
//					
//				    softassert.assertEquals(tiles_names.get(i).getText(), expceted_tile_names[j],expceted_tile_names[j]+" is not present");
//					}
//				}
//				i++;
//			}
//		}
//		
//		Util.scrollFunction(total_calls_graph);
//		logger.log(LogStatus.INFO, "verifying if total calls graph is present");
//		softassert.assertTrue(total_calls_graph.isDisplayed(),"total calls graph is not displayed or locator has been chamged..");
//
//		logger.log(LogStatus.INFO, "verifying if unique calls graph is present");
//		softassert.assertTrue(unique_calls_graph.isDisplayed(),"unique calls graph is not displayed or locator has been chamged..");
//		
//		System.out.println("-------------------------------table-columns------------------------------------------------");
//
//		
////		Util.scrollFunction(call_logs_scroll);
//
//		for(int i=0;i<table_column_labels.size();){
//			for(int j=0;j<expeted_table_column_labels.length;j++){
//				if(table_column_labels.get(i).getText().equals(expeted_table_column_labels[j])){
//					wait.until(ExpectedConditions.visibilityOf(table_column_labels.get(i)));
//					System.out.println("we-"+table_column_labels.get(i).getText());
//					System.out.println("array-"+expeted_table_column_labels[j]);
//            	logger.log(LogStatus.INFO, "verifying if "+expeted_table_column_labels[j]+" column is present");
//			    softassert.assertEquals(table_column_labels.get(i).getText(), expeted_table_column_labels[j],expeted_table_column_labels[j]+" is not present");				
//				}
//			}
//			i++;
//
//		}
//		Util.getJavascriptExecutor().executeScript("window.scrollBy(500,0)","");
//
//
//		
//		
//	    wait.until(ExpectedConditions.visibilityOf(filter_button));
//	    logger.log(LogStatus.INFO, "verifying if filter_button is present");
//	    softassert.assertTrue(filter_button.isDisplayed(), "filter_button is not present");
//	
//	    
//	    logger.log(LogStatus.INFO, "verifying if filter_button is enabled");
//	    softassert.assertTrue(filter_button.isEnabled(), "filter_button is not enabled");	    
//	
////	    for(int i=0;i<filter_elements_before_expanding.size();){
////	    	for(int j=0;j<expected_filter_elements.length;j++){
////
////	    		if(filter_elements_before_expanding.get(i).getText().equals(expected_filter_elements[j])){
////		    		System.out.println("we - "+filter_elements_before_expanding.get(i).getText());
////		    		System.out.println("array -"+expected_filter_elements[j]);
////	    			wait.until(ExpectedConditions.visibilityOf(filter_elements_before_expanding.get(i)));
////	    		logger.log(LogStatus.INFO,"verifying if "+expected_filter_elements[j]+" is present");
////	    	    softassert.assertEquals(filter_elements_before_expanding.get(i).getText(),expected_filter_elements[j],expected_filter_elements[j]+" filter element is npt present");
////	    		}
////	    		}
////	    	i++;
////	    }
//		System.out.println("------------------------filter-element-after-expanding-------------------------------------------------------");	    
//	    //expanding filter section
//	    Util.click(filter_button);
//	    
//	    for(int k=0;k<filter_elements_after_expanding.size();){
//	    	for(int j=0;j<expected_filter_elements.length;j++){
//
//	    		if(filter_elements_after_expanding.get(k).getText().equals(expected_filter_elements[j])){
//		    			    			    		
//	    		wait.until(ExpectedConditions.visibilityOf(filter_elements_after_expanding.get(k)));	    		
//	    		System.out.println("we-"+filter_elements_after_expanding.get(k).getText());
//	    		System.out.println("array-"+expected_filter_elements[j]);		
//	    		logger.log(LogStatus.INFO,"verifying if "+expected_filter_elements[j]+" filter is present");
//	    	    softassert.assertEquals(filter_elements_after_expanding.get(k).getText(),expected_filter_elements[j],expected_filter_elements[j]+" filter element is npt present");
//	    		}
//	    		}
//	    	k++;
//	    }
//		System.out.println("-------------------------------------------------------------------------------");
//	    
////		//collapsing filter section
//		Util.click(filter_button);
//
//		Util.scrollFunction(footer_note);
//		
//	    wait.until(ExpectedConditions.visibilityOf(footer_note));
//		logger.log(LogStatus.INFO, "verifying if footer note is present");
//	    softassert.assertTrue(footer_note.isDisplayed(), "footer note is not present");
//	    
//	    softassert.assertAll();
//	}
	
	
	
	
}
