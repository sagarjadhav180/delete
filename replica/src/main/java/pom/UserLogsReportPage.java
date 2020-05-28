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

public class UserLogsReportPage extends TestBase{

	@FindBy(xpath="//button[@class='btn run-button embed-view btn-primary'][text()='Run']")
	private WebElement run_button;

	@FindBy(xpath="(//div[@class='title-main']//span[text()='User Logs'])")
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
	
	String[] expected_filter_elements_after_expanding={"Date Range","Show Activity By","Activity","Group","User"};
	
	@FindBy(xpath="(//div[@class='vis-header'])[1]//span[text()='All Activity by Type']")
	private WebElement all_activity_by_type_label;	

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[1]")
	private WebElement all_activity_by_type_graph;	
	
	@FindBy(xpath="(//div[@class='ag-grid-container'])[1]//div[@class='ag-header-container']//strong")
	private List<WebElement> all_activity_table_columns;	
	
	String[] expected_all_activity_table_columns={"Activity Date/Time","User(Name/Login)","Group","Activity","Activity Details"};

	@FindBy(xpath="//div[@class='title-and-subtitle']//div[text()='Login Activity']")
	private WebElement login_activity_table_label;

	@FindBy(xpath="(//div[@class='vis-header']//span[text()='Login Activity'])[1]")
	private WebElement login_activity_graph_label;

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[2]")
	private WebElement login_activity_graph;	

	@FindBy(xpath="(//div[@class='ag-grid-container'])[2]//div[@class='ag-header-container']//strong")
	private List<WebElement> login_activity_table_columns;
	
	String[] expected_login_activity_table_columns={"Activity By","Login Count"};
	
	SoftAssert softassert=new SoftAssert(); 

	public UserLogsReportPage(WebDriver driver){
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
		Assert.assertTrue(header_label.isDisplayed(),"header label is not displayed or locator changed");
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
	
    public void allActivityByTypeLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if All Activity By Type Label is present");
		Assert.assertTrue(all_activity_by_type_label.isDisplayed(),"All Activity By Type label is not present or locator has been changed.");
	}
    
    public void allActivityByTypeGraph(){

    	logger.log(LogStatus.INFO, "Verifying if All Activity By Type Graph is present");
    	Assert.assertTrue(all_activity_by_type_graph.isDisplayed(),"All Activity By Type Graph is not present or locator has been changed.");    		
	}
    
    public void allActivityTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<all_activity_table_columns.size();i++){
			
			for(int j=0;j<expected_all_activity_table_columns.length;j++){
				
				if(all_activity_table_columns.get(i).getText().equals(expected_all_activity_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_all_activity_table_columns[j]+" is present");
					softassert.assertTrue(all_activity_table_columns.get(i).getText().equals(expected_all_activity_table_columns[j]),"Column "+expected_all_activity_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
    
    public void loginActivityTableLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if Login Activity Table Label is present");
		Assert.assertTrue(login_activity_table_label.isDisplayed(),"Login Activity Table label is not present or locator has been changed.");
	}
    
    public void loginActivityGraphLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if Login Activity Graph Label is present");
		Assert.assertTrue(login_activity_graph_label.isDisplayed(),"Login Activity Graph label is not present or locator has been changed.");
	}
    
    public void loginActivityGraph(){

    	logger.log(LogStatus.INFO, "Verifying if Login Activity Graph is present");
    	Assert.assertTrue(login_activity_graph.isDisplayed(),"Login Activity Graph is not present or locator has been changed.");    		
	}    
    
    public void loginActivityTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<login_activity_table_columns.size();i++){
			
			for(int j=0;j<expected_login_activity_table_columns.length;j++){
				
				if(login_activity_table_columns.get(i).getText().equals(expected_login_activity_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_login_activity_table_columns[j]+" is present");
					softassert.assertTrue(login_activity_table_columns.get(i).getText().equals(expected_login_activity_table_columns[j]),"Column "+expected_login_activity_table_columns[j]+" is not present");
				}
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
    
    public void filterFeatureForAllActivityTable(String filterName) throws InterruptedException{

    		int index=0;
            String filterValue;
    		for(int i=0;i<all_activity_table_columns.size();i++){
    			
    			if(filterName.equals("User")){
    				if(all_activity_table_columns.get(i).getText().startsWith(filterName)){
        				
        				index=i+1;
        				break;
        			}
    			}
    			else{
    				if(filterName.equals(all_activity_table_columns.get(i).getText())){
    				
    				index=i+1;
    				break;
    			}
    				
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
            
            if(filterName.equals("User")){
        	    Util.Action().sendKeys(filterValue.substring(0,filterValue.indexOf('(')-1)).perform();            	
            }
            else{
        	    Util.Action().sendKeys(filterValue).perform();            	
            }

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
