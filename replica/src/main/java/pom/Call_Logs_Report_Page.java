package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import extentReport.ExtentReportsGenerator;
import tests.TestBase;
import tests.Util;

public class Call_Logs_Report_Page extends TestBase {
	

	@FindBy(xpath="//div[@class='ag-body-horizontal-scroll-viewport']")
	private WebElement call_logs_scroll;	
	
	@FindBy(xpath="//strong[text()='Comments']")
	private WebElement commnets_column;	
	
	@FindBy(xpath="(//span[text()='Call Logs - Enhanced'])[1]")
	private WebElement call_logs_enhanced_label;	

	@FindBy(xpath="//div[@class='vis-single-value']//div[@class='looker-vis-context-title']/span")
	private List<WebElement> tiles;	
	
	@FindBy(xpath="(//div[@class='vis-container'])[8]")
	private WebElement total_calls_graph;		
	
	@FindBy(xpath="(//div[@class='vis-container'])[9]")
	private WebElement unique_calls_graph;		
	
	String[] expceted_tile_names={"Total Calls","Unique Calls","Answered Calls","Average Call Duration","Detailed View","Total Leads 0% Of Total Calls","Total Conversion 0% Of Total Calls"};
	
	@FindBy(xpath="//div[@class='ag-header-row']//strong")
	private List<WebElement> table_column_labels;	

//	@FindBy(xpath="//*[@id='dashboard']/div/div[2]/div/div/div/div/div[2]/div[10]/div/lk-vis-element/div/div/div[2]/div/div/div/lk-visualization-container/div/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div/div//div")
//	private List<WebElement> table_column_labels;	
	
	String[] expeted_table_column_labels={"Hunt Type","Ad Source","Tracking Number Type","Campaign","Tracking Number Name","Tracking Number","Ring-to Name","Ring to Phone Number","Caller ID","Disposition","Tags","Comments","Identified Agent","Voicemail","Group","Play Call","Duration","Date/Time"};
	
	@FindBy(xpath="//div [@class='body-text text-muted']")
	private WebElement footer_note;	

	
	//Filter section
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

	public Call_Logs_Report_Page(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void switchToIFrame(){
		
		driver.switchTo().frame(reports_iframe);
		
	}
	
	public void headerLabel(){

		wait.until(ExpectedConditions.visibilityOf(call_logs_enhanced_label));
		logger.log(LogStatus.INFO, "verifying if call_logs_enhanced_label is present");
		softassert.assertTrue(call_logs_enhanced_label.isDisplayed(),"call_logs_enhanced_label is not displayed or locator has been chamged..");
				
	}
	
	public void tilesVerification() throws InterruptedException{
		
		for(int i=0;i<tiles.size();){
			for(int j=0;j<expceted_tile_names.length;j++){

				if(tiles.get(i).getText().equals(expceted_tile_names[j])){
					
					wait.until(ExpectedConditions.visibilityOf(tiles.get(i)));
					System.out.println("we -"+tiles.get(i).getText());
					System.out.println("array -"+expceted_tile_names[j]);
					logger.log(LogStatus.INFO, "verifying if "+expceted_tile_names[j]+" tile is present");
				
			    softassert.assertEquals(tiles.get(i).getText(), expceted_tile_names[j],expceted_tile_names[j]+" is not present");
				}
			}
			i++;
		}
		
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
	
	
	public void uiVerification() throws InterruptedException{
		
		driver.switchTo().frame(reports_iframe);
		

		wait.until(ExpectedConditions.visibilityOf(call_logs_enhanced_label));
		logger.log(LogStatus.INFO, "verifying if call_logs_enhanced_label is present");
		softassert.assertTrue(call_logs_enhanced_label.isDisplayed(),"call_logs_enhanced_label is not displayed or locator has been chamged..");

		System.out.println("----------------------------------------tiles---------------------------------------");
		
		try{
			Thread.sleep(3000);
		for(int i=0;i<tiles.size();){
			for(int j=0;j<expceted_tile_names.length;j++){

				if(tiles.get(i).getText().equals(expceted_tile_names[j])){
					
					wait.until(ExpectedConditions.visibilityOf(tiles.get(i)));
					System.out.println("we -"+tiles.get(i).getText());
					System.out.println("array -"+expceted_tile_names[j]);
					logger.log(LogStatus.INFO, "verifying if "+expceted_tile_names[j]+" tile is present");
				
			    softassert.assertEquals(tiles.get(i).getText(), expceted_tile_names[j],expceted_tile_names[j]+" is not present");
				}
			}
			i++;
		}}
		catch(Exception e){
			driver.navigate().refresh();
			Thread.sleep(7000);
			}
		finally{
			for(int i=0;i<tiles.size();){
				for(int j=0;j<expceted_tile_names.length;j++){

					if(tiles.get(i).getText().equals(expceted_tile_names[j])){
						
						wait.until(ExpectedConditions.visibilityOf(tiles.get(i)));
						System.out.println("we -"+tiles.get(i).getText());
						System.out.println("array -"+expceted_tile_names[j]);
						logger.log(LogStatus.INFO, "verifying if "+expceted_tile_names[j]+" tile is present");
					
				    softassert.assertEquals(tiles.get(i).getText(), expceted_tile_names[j],expceted_tile_names[j]+" is not present");
					}
				}
				i++;
			}
		}
		
		Util.scrollFunction(total_calls_graph);
		logger.log(LogStatus.INFO, "verifying if total calls graph is present");
		softassert.assertTrue(total_calls_graph.isDisplayed(),"total calls graph is not displayed or locator has been chamged..");

		logger.log(LogStatus.INFO, "verifying if unique calls graph is present");
		softassert.assertTrue(unique_calls_graph.isDisplayed(),"unique calls graph is not displayed or locator has been chamged..");
		
		System.out.println("-------------------------------table-columns------------------------------------------------");

		
//		Util.scrollFunction(call_logs_scroll);

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
		Util.getJavascriptExecutor().executeScript("window.scrollBy(500,0)","");


		
		
	    wait.until(ExpectedConditions.visibilityOf(filter_button));
	    logger.log(LogStatus.INFO, "verifying if filter_button is present");
	    softassert.assertTrue(filter_button.isDisplayed(), "filter_button is not present");
	
	    
	    logger.log(LogStatus.INFO, "verifying if filter_button is enabled");
	    softassert.assertTrue(filter_button.isEnabled(), "filter_button is not enabled");	    
	
//	    for(int i=0;i<filter_elements_before_expanding.size();){
//	    	for(int j=0;j<expected_filter_elements.length;j++){
//
//	    		if(filter_elements_before_expanding.get(i).getText().equals(expected_filter_elements[j])){
//		    		System.out.println("we - "+filter_elements_before_expanding.get(i).getText());
//		    		System.out.println("array -"+expected_filter_elements[j]);
//	    			wait.until(ExpectedConditions.visibilityOf(filter_elements_before_expanding.get(i)));
//	    		logger.log(LogStatus.INFO,"verifying if "+expected_filter_elements[j]+" is present");
//	    	    softassert.assertEquals(filter_elements_before_expanding.get(i).getText(),expected_filter_elements[j],expected_filter_elements[j]+" filter element is npt present");
//	    		}
//	    		}
//	    	i++;
//	    }
		System.out.println("------------------------filter-element-after-expanding-------------------------------------------------------");	    
	    //expanding filter section
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
	    
//		//collapsing filter section
		Util.click(filter_button);

		Util.scrollFunction(footer_note);
		
	    wait.until(ExpectedConditions.visibilityOf(footer_note));
		logger.log(LogStatus.INFO, "verifying if footer note is present");
	    softassert.assertTrue(footer_note.isDisplayed(), "footer note is not present");
	    
	    softassert.assertAll();
	}
	
	
	
	
}
