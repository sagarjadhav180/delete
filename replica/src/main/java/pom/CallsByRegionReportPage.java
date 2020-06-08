package pom;

import java.util.List;

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

public class CallsByRegionReportPage extends TestBase {

	@FindBy(xpath="//button[@class='btn run-button embed-view btn-primary'][text()='Run']")
	private WebElement run_button;

	@FindBy(xpath="//div[@class='title-main']//span[text()='Calls By Region']")
	private WebElement header_label;
	
	@FindBy(xpath="//div[@class='dropdown-toggle button-xs']/i")
	private WebElement gear_icon;

	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-wide pull-right']//li//a")
	private List<WebElement> gear_icon_options;
	
	String[] expected_gear_icon_options={"Download as PDF...","Download as CSVs","Send","Schedule","Move to Trash"};

	@FindBy(xpath="//span[@class='timezone']")
	private WebElement timezone;
	
	@FindBy(xpath="//iframe[@id='looker']")
	private WebElement reports_iframe;
	
	@FindBy(xpath="//strong[@class='filter-section-title']//i")
	private WebElement filter_button;
	
	@FindBy(xpath="//table[@class='explore-filters clearfix']//tbody//tr//td[@class='filter-name']")
	private List<WebElement> filter_elements_after_expanding;
	
	String[] expected_filter_elements_after_expanding={"Date Range","Show By","Ad Source","Campaign","Custom Source 1","Custom Source 2","Custom Source 3","Custom Source 4","Custom Source 5","Group","Referring Source","Referring Type","Tracking Number Name","Tracking Number"};
	
	SoftAssert softassert=new SoftAssert(); 

	@FindBy(xpath="//div[@class='vis-header']//span[text()='Calls By Regions']")
	private WebElement calls_by_region_graph_label;
	
	@FindBy(xpath="(//div[@class='vis-wrapper-container'])[1]")
	private WebElement calls_by_region_graph;

	@FindBy(xpath="//div[@class='vis-header']//span[text()='Top Regions']")
	private WebElement top_regions_graph_label;

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[1]")
	private WebElement top_regions_graph;

	@FindBy(xpath="//div[@class='vis-header']//span[text()='Calls By State/Province']")
	private WebElement calls_by_state_graph_label;

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[1]")
	private WebElement calls_by_state_graph;
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[1]//div[@class='ag-header-container']//strong")
	private List<WebElement> table_columns;
	
	String[] expected_table_columns={"Calls By Zip/Postal Code","City","State/Province","Country Code","Calls","Average Call Duration"};
	
	public CallsByRegionReportPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
    public void switchToIFrame(){
		
		driver.switchTo().frame(reports_iframe);
		
	}
    
    public void switchToMainWindow(){
		
		driver.switchTo().window(driver.getWindowHandle());
		
	}
    
	public void headerLabel(){
		logger.log(LogStatus.INFO, "Verifying if header label is present");
		Assert.assertTrue(header_label.isDisplayed(),"Header label is not present or locator has been changed.");
	}
    
    public void presenceOfGearIcon(){
		
		logger.log(LogStatus.INFO, "Verifying if gear icon is present");
		Assert.assertTrue(gear_icon.isDisplayed(),"Gear icon is not present or locator has been changed.");
	}
	
    public void gearIconOptions(){
		
		logger.log(LogStatus.INFO, "Verifying options present in gear icon");
        
		gear_icon.click();
		for(int i=0;i<gear_icon_options.size();i++){
			
			for(int j=0;j<expected_gear_icon_options.length;j++){
				
				if(gear_icon_options.get(i).getText().equals(expected_gear_icon_options[j])){
					logger.log(LogStatus.INFO, "Verifying if "+expected_gear_icon_options[j]+" is present");
					softassert.assertTrue(gear_icon_options.get(i).getText().equals(expected_gear_icon_options[j]),"Gear icon "+expected_gear_icon_options[j]+" is present");
				}
			}
		}
    
		softassert.assertAll();
		gear_icon.click();
    }

	
    public void presenceOfTimeZone(){
		
		logger.log(LogStatus.INFO, "Verifying if Time Zone is present");
		Assert.assertTrue(timezone.isDisplayed(),"Time Zone is not present or locator has been changed.");
	}
	
    public void runButton(){

		wait.until(ExpectedConditions.visibilityOf(run_button));
		logger.log(LogStatus.INFO, "verifying if run_button is present");
		Assert.assertTrue(run_button.isDisplayed(),"run_button is not displayed or locator has been chamged..");
		logger.log(LogStatus.INFO, "verifying if run_button is enabled");
		Assert.assertTrue(run_button.isEnabled(),"run_button is not enabled");
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
        	for(int j=0;j<expected_filter_elements_after_expanding.length;j++){

        		if(filter_elements_after_expanding.get(k).getText().equals(expected_filter_elements_after_expanding[j])){
    	    			    			    		
        		wait.until(ExpectedConditions.visibilityOf(filter_elements_after_expanding.get(k)));	    		
        		System.out.println("we-"+filter_elements_after_expanding.get(k).getText());
        		System.out.println("array-"+expected_filter_elements_after_expanding[j]);		
        		logger.log(LogStatus.INFO,"verifying if "+expected_filter_elements_after_expanding[j]+" filter is present");
        	    softassert.assertEquals(filter_elements_after_expanding.get(k).getText(),expected_filter_elements_after_expanding[j],expected_filter_elements_after_expanding[j]+" filter element is npt present");
        		}
        		}
        	k++;
        }

        softassert.assertAll();
    	//collapsing filter section
    	Util.click(filter_button);

    }
    
    public void callsByRegionGraphLabel(){
		
    	logger.log(LogStatus.INFO, "Verifying if Calls By Region Graph Label is present");
    	Assert.assertTrue(calls_by_region_graph_label.isDisplayed(),"Calls By Region Graph Label is not present or locator has been changed.");    		

	}

    public void callsByRegionGraph(){
		
    	logger.log(LogStatus.INFO, "Verifying if Calls By Region Graph is present");
    	Assert.assertTrue(calls_by_region_graph.isDisplayed(),"Calls By Region Graph is not present or locator has been changed.");    		

	}
    
    public void topRegionGraphLabel(){
		
    	logger.log(LogStatus.INFO, "Verifying if Top Region Graph Label is present");
    	Assert.assertTrue(top_regions_graph_label.isDisplayed(),"Top Regions Graph Label is not present or locator has been changed.");    		

	}

    public void topRegionGraph(){
		
    	logger.log(LogStatus.INFO, "Verifying if Top Region Graph is present");
    	Assert.assertTrue(top_regions_graph.isDisplayed(),"Top Regions Graph is not present or locator has been changed.");    		

	}

    public void callsByStateGraphLabel(){
		
    	logger.log(LogStatus.INFO, "Verifying if Calls By State Graph Label is present");
    	Assert.assertTrue(calls_by_state_graph_label.isDisplayed(),"Calls By State Graph Label is not present or locator has been changed.");    		

	}

    public void callsByStateGraph(){
		
    	logger.log(LogStatus.INFO, "Verifying if Calls By State Graph is present");
    	Assert.assertTrue(calls_by_state_graph.isDisplayed(),"Calls By State Graph is not present or locator has been changed.");    		

	}
    
    public void tableColumnVerification() throws InterruptedException{
	
    	Thread.sleep(2000);
    	
    	for(int i=0;i<table_columns.size();i++){
    			
    		for(int j=0;j<expected_table_columns.length;j++){
    				
    			if(table_columns.get(i).getText().equals(expected_table_columns[j])){
    				logger.log(LogStatus.INFO, "Verifying if "+expected_table_columns[j]+" is present");
   					softassert.assertTrue(table_columns.get(i).getText().equals(expected_table_columns[j]),"Column "+expected_table_columns[j]+" is not present");
   				}
   			}
   			
    	}
    			
    	softassert.assertAll();	
	}
    
    
    
}
