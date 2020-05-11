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

public class BlockedCallsReportPage extends TestBase{
	
	@FindBy(xpath="//button[@class='btn run-button embed-view btn-primary'][text()='Run']")
	private WebElement run_button;

	@FindBy(xpath="//div[@class='title-main']//span[text()='Blocked Calls']")
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

	String[] expected_filter_elements_after_expanding={"Date Range","Campaign","Group","Tracking Number Name","Tracking Number"};
	
	@FindBy(xpath="//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span")
	private List<WebElement> tiles_names;	
	
	String[] expected_tiles_names={"Calls Checked","Blocked Call"};
	
	@FindBy(xpath="(//div[@class='grid-element']//div[@class='ag-header-row'])[2]//span[@class='column-label']//strong")
	private List<WebElement> blocked_number_table_column_labels;	
	String[] expected_blocked_number_table_column_labels={"Spam Caller ID","Calls Checked","Blocked Calls","Block % of Calls Checked"};
	
	@FindBy(xpath="(//div[@class='grid-element']//div[@class='ag-header ag-pivot-off'])[2]//span[@class='column-label']//strong")
	private List<WebElement> blocked_calls_table_column_labels;	
	String[] expected_blocked_calls_table_column_labels={"Group","Group External Id","Campaign","Campaign External Id","Tracking Number","Tracking Number Name","Calls Checked","Blocked Calls","Block % of Called Checked"};

	@FindBy(xpath="(//div[@class='grid-element']//span[text()='No Results'])[2]")
	private WebElement no_results_Label_blocked_calls_table;	

	@FindBy(xpath="(//div[@class='grid-element']//span[text()='No Results'])[1]")
	private WebElement no_results_Label_blocked_numbers_table;	
	
	SoftAssert softassert=new SoftAssert(); 

	public BlockedCallsReportPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
    public void switchToIFrame(){
		
		driver.switchTo().frame(reports_iframe);
		
	}
    
    public void switchToMainWindow(){
		
		driver.switchTo().window(driver.getWindowHandle());
		
	}
    
	public void headerLabel(){
		wait.until(ExpectedConditions.visibilityOf(header_label));
		logger.log(LogStatus.INFO, "verifying if tracking number settings label is present");
		softassert.assertTrue(header_label.isDisplayed(),"header_label is not displayed or locator has been chamged..");
				
	}
    
	public void runButton(){

		wait.until(ExpectedConditions.visibilityOf(run_button));
		logger.log(LogStatus.INFO, "verifying if run_button is present");
		Assert.assertTrue(run_button.isDisplayed(),"run_button is not displayed or locator has been chamged..");
		logger.log(LogStatus.INFO, "verifying if run_button is enabled");
		Assert.assertTrue(run_button.isEnabled(),"run_button is not enabled");
		
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

    public void blockedNumebrsTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<blocked_number_table_column_labels.size();i++){
			
			for(int j=0;j<expected_blocked_number_table_column_labels.length;j++){
				
				if(blocked_number_table_column_labels.get(i).getText().equals(expected_blocked_number_table_column_labels[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_blocked_number_table_column_labels[j]+" is present");
					softassert.assertTrue(blocked_number_table_column_labels.get(i).getText().equals(expected_blocked_number_table_column_labels[j]),"Column "+expected_blocked_number_table_column_labels[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}

    public void blockedCallsTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<blocked_calls_table_column_labels.size();i++){
			
			for(int j=0;j<expected_blocked_calls_table_column_labels.length;j++){
				
				if(blocked_calls_table_column_labels.get(i).getText().equals(expected_blocked_calls_table_column_labels[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_blocked_calls_table_column_labels[j]+" is present");
					softassert.assertTrue(blocked_calls_table_column_labels.get(i).getText().equals(expected_blocked_calls_table_column_labels[j]),"Column "+expected_blocked_number_table_column_labels[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}

    public void tilesVerification(){
    	
    	for(int i=0;i<tiles_names.size();i++){
    		
    		for(int j=0;j<expected_tiles_names.length;j++){
    			
    			if(tiles_names.get(i).getText().equals(expected_tiles_names[j])){
    				
    				logger.log(LogStatus.INFO, "Verifying if "+expected_tiles_names[j]+" is present");
    				softassert.assertTrue(tiles_names.get(i).getText().equals(expected_tiles_names[j]),"Tile "+expected_tiles_names[j]+" is not present");
    			}
    		}
    		
    	}
    	softassert.assertAll();
    }
        
    String call_checked_count_from_db = Util.readingFromDB("");
	String blocked_calls_count_from_db = Util.readingFromDB("");

    public void tileValueVerification(String tile_name){
	
    	
		String tile_values=driver.findElement(By.xpath("//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span[text()='"+tile_name+"']//parent::Div//parent::div/preceding-sibling::div//a")).getText();
	
        if(tile_name.equals("Calls Checked")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(call_checked_count_from_db!=null){
				System.out.println(tile_values);
				System.out.println(call_checked_count_from_db);
				softassert.assertTrue(tile_values.equals(call_checked_count_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
        
        else if(tile_name.equals("Blocked Call")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(blocked_calls_count_from_db!=null){
				System.out.println(tile_values);
				System.out.println(blocked_calls_count_from_db);
				softassert.assertTrue(tile_values.equals(blocked_calls_count_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
        

		softassert.assertAll();		
	}

    public void filterFeatureBlockedCallsTable(String filterName) throws InterruptedException{

    	if(call_checked_count_from_db.equals("0")){
    		logger.log(LogStatus.INFO, "Verifying if no results label is displayed since there is no data to filter");
    		Assert.assertTrue(no_results_Label_blocked_calls_table.isDisplayed(),"no results label is not displayed or locator changed");
    	}
    
    	else{
    		int index=0;
            String filterValue;
    		for(int i=0;i<blocked_calls_table_column_labels.size();i++){
    			
    			if(filterName.equals(blocked_calls_table_column_labels.get(i).getText())){
    				
    				index=i+1;
    				break;
    			}
    		}
    		List<WebElement> value_to_be_filtered = driver.findElements(By.xpath("//div[@class='ag-center-cols-container']/div/div["+String.valueOf(index)+"]"));		
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
    	    Util.Action().sendKeys(Keys.BACK_SPACE).perform();
            Util.Action().sendKeys(Keys.BACK_SPACE).perform();
    		Util.Action().sendKeys(Keys.ESCAPE).perform();	
    	
    		filter_button.click();
    	}
    	
	}
    
    
    
}
