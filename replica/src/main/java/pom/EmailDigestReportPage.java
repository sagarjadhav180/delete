package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class EmailDigestReportPage extends TestBase{

	@FindBy(xpath="//div[@class='title-main']//span[text()='Email Digest']")
	private WebElement header_label;
	
	@FindBy(xpath="//button[@class='btn run-button embed-view btn-primary'][text()='Run']")
	private WebElement run_button;

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
	
	String[] expected_filter_elements_after_expanding={"Date Range","User","Group Name","Tracking Number Name","Coachable Calls Missed Opportunity (High/Moderate/Low)","Coachable Calls Sales Skills (High/Moderate/Low)","Good Calls Sales Skills (High/Moderate/Low)"};
	
	@FindBy(xpath="//div[@class='vis-header']//span[text()='Summary of Calls']")
	private WebElement summary_of_calls_label;
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[1]//div[@class='ag-header-container']//strong")
	private List<WebElement> summary_of_calls_table_columns;

	String[] expected_summary_of_calls_table_columns={"Group Name","Calls over 30 sec","Total Conversion","Conversion Rate","Average Lead Quality","Average Sales Performance"};
	
	@FindBy(xpath="//div[@class='vis-header']//span[text()='Coachable Calls']")
	private WebElement coachable_calls_label;

	@FindBy(xpath="(//div[@class='ag-grid-container'])[2]//div[@class='ag-header-container']//strong")
	private List<WebElement> coachable_calls_table_columns;

	String[] expected_coachable_calls_table_columns={"Group Name","Tracking Number Name","Call Started Date/Time","Caller Id","Play Call","Sales Skills (High/Moderate/Low)","Lead Score (High/Moderate/Low)","Missed Opportunity (High/Moderate/Low)"};
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[2]//span[text()='No Results']")
	private WebElement coachable_calls_table_no_results_label;
	
	@FindBy(xpath="//div[@class='vis-header']//span[text()='Good Calls']")
	private WebElement good_calls_label;

	@FindBy(xpath="(//div[@class='ag-grid-container'])[3]//div[@class='ag-header-container']//strong")
	private List<WebElement> good_calls_table_columns;

	String[] expected_good_calls_table_columns={"Group Name","Tracking Number Name","Call Started Date/Time","Caller Id","Play Call","Sales Skills (High/Moderate/Low)","Lead Score (High/Moderate/Low)","Conversion Score (High/Moderate/Low)"};	
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[3]//span[text()='No Results']")
	private WebElement good_calls_table_no_results_label;

	
	SoftAssert softassert=new SoftAssert(); 

	public EmailDigestReportPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
    public void switchToIFrame(){
		
		driver.switchTo().frame(reports_iframe);
		
	}
    
    public void switchToMainWindow(){
		
		driver.switchTo().window(driver.getWindowHandle());
		
	}
    
    public void runButton(){

 		wait.until(ExpectedConditions.visibilityOf(run_button));
 		logger.log(LogStatus.INFO, "verifying if run_button is present");
 		Assert.assertTrue(run_button.isDisplayed(),"run_button is not displayed or locator has been chamged..");
 		logger.log(LogStatus.INFO, "verifying if run_button is enabled");
 		Assert.assertTrue(run_button.isEnabled(),"run_button is not enabled");
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
    
    public void summaryOfCallsLabel(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Summary Of Calls Label is displayed");
    	Assert.assertTrue(summary_of_calls_label.isDisplayed(),"Summary Of Calls Label is not displayed");
    }
    
    public void summaryOfCallsTableColumnVerification() throws InterruptedException{
		
    	Thread.sleep(2000);
    		
    	for(int i=0;i<summary_of_calls_table_columns.size();i++){
    				
    		for(int j=0;j<expected_summary_of_calls_table_columns.length;j++){
    					
    			if(summary_of_calls_table_columns.get(i).getText().equals(expected_summary_of_calls_table_columns[j])){
    					
    				logger.log(LogStatus.INFO, "Verifying if "+expected_summary_of_calls_table_columns[j]+" is present");
    				softassert.assertTrue(summary_of_calls_table_columns.get(i).getText().equals(expected_summary_of_calls_table_columns[j]),"Column "+expected_summary_of_calls_table_columns[j]+" is not present");
    				}
    			}	
    		}
    		
    	softassert.assertAll();		
	}
    
    public void coachableCallsLabel(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Coachable Calls Label is displayed");
    	Assert.assertTrue(coachable_calls_label.isDisplayed(),"Coachable Calls Label is not displayed");
    }
    
    public void coachableCallsTableColumnVerification() throws InterruptedException{
		
    	Thread.sleep(2000);
    		
    	for(int i=0;i<coachable_calls_table_columns.size();i++){
    				
    		for(int j=0;j<expected_coachable_calls_table_columns.length;j++){
    					
    			if(coachable_calls_table_columns.get(i).getText().equals(expected_coachable_calls_table_columns[j])){
    					
    				logger.log(LogStatus.INFO, "Verifying if "+expected_coachable_calls_table_columns[j]+" is present");
    				softassert.assertTrue(coachable_calls_table_columns.get(i).getText().equals(expected_coachable_calls_table_columns[j]),"Column "+expected_coachable_calls_table_columns[j]+" is not present");
    				}
    			}	
    		}
    		
    	softassert.assertAll();		
	}

    public void goodCallsLabel(){
    	
    	logger.log(LogStatus.INFO, "Verifying if Good Calls Label is displayed");
    	Assert.assertTrue(good_calls_label.isDisplayed(),"Good Calls Label is not displayed");
    }
    
    public void goodCallsTableColumnVerification() throws InterruptedException{
		
    	Thread.sleep(2000);
    		
    	for(int i=0;i<good_calls_table_columns.size();i++){
    				
    		for(int j=0;j<expected_good_calls_table_columns.length;j++){
    					
    			if(good_calls_table_columns.get(i).getText().equals(expected_good_calls_table_columns[j])){
    					
    				logger.log(LogStatus.INFO, "Verifying if "+expected_good_calls_table_columns[j]+" is present");
    				softassert.assertTrue(good_calls_table_columns.get(i).getText().equals(expected_good_calls_table_columns[j]),"Column "+expected_good_calls_table_columns[j]+" is not present");
    				}
    			}	
    		}
    		
    	softassert.assertAll();		
	}

    public void filterFeatureForCallsTable(String filterName) throws InterruptedException{

    	
    		int index=0;
            String filterValue;
    		for(int i=0;i<summary_of_calls_table_columns.size();i++){
    			
    			if(filterName.equals(summary_of_calls_table_columns.get(i).getText())){
    				
    				index=i+1;
    				break;
    			}
    		}
    		List<WebElement> value_to_be_filtered = driver.findElements(By.xpath("(//div[@class='ag-grid-container'])[1]//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]"));		
    		filterValue=value_to_be_filtered.get(0).getText();
    		
    		filter_button.click();
    		
    		String xpath="//table[@class='explore-filters clearfix']//tbody//tr//td[@class='filter-name'][text()='"+filterName+"']";
    		
    		WebElement filter_textbox = driver.findElement(By.xpath(""+xpath+"//parent::tr//select//following-sibling::span"));
    	
    		wait.until(ExpectedConditions.visibilityOf(filter_textbox));
            Util.Action().moveToElement(filter_textbox).perform();
            Util.Action().click().perform();
    	    Util.Action().sendKeys(filterValue).perform();
    	    Util.Action().sendKeys(Keys.ESCAPE).perform();	
    		
    		run_button.click();
    		filter_button.click();
    		Thread.sleep(5000);
    		
    	
    		List<WebElement> filtered_values = driver.findElements(By.xpath("(//div[@class='ag-grid-container'])[1]//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]"));
    		System.out.println("(//div[@class='ag-grid-container'])[1]//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]");
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
    	    Util.Action().sendKeys(Keys.BACK_SPACE).perform();
            Util.Action().sendKeys(Keys.BACK_SPACE).perform();
    		Util.Action().sendKeys(Keys.ESCAPE).perform();	
    	
    		filter_button.click();
    	
    	        
	}	
    
    
    
}
