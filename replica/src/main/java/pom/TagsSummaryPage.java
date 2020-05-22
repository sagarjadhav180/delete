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

public class TagsSummaryPage extends TestBase {

	@FindBy(xpath="//button[@class='btn run-button embed-view btn-primary'][text()='Run']")
	private WebElement run_button;

	@FindBy(xpath="(//div[@class='title-main']//span[text()='Tags Summary'])")
	private WebElement header_label;
	
	@FindBy(xpath="//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span")
	private List<WebElement> tiles_names;	
	
	String [] expected_tiles_names={"Total Calls","Tagged Calls","Tags Used"};
	
	@FindBy(xpath="//div[@class='vis-header']//span[text()='Tags Over Time']")
	private WebElement tags_over_time_label;	

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[1]")
	private WebElement tags_over_time_graph;	

	@FindBy(xpath="//div[@class='vis-header']//span[text()='Tags Mix']")
	private WebElement tags_mix_label;	

	@FindBy(xpath="(//div[starts-with(@id,'highcharts-')])[2]")
	private WebElement tags_mix_graph;	

	@FindBy(xpath="(//div[@class='dashboard-element'])[6]//div[@class='ag-header-container']//strong")
	private List<WebElement> calls_table_columns;	
	
	String[] expected_calls_table_columns={"Group","Group External Id","Total Calls"};
	
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

	String[] expected_filter_elements_after_expanding={"Date Range","Stack Columns By","Campaign","Group","Tag","Tracking Number Name","Tracking Number"};
	
	@FindBy(xpath="(//div[@class='dashboard-element'])[7]//div[@class='ag-header-container']//strong")
	private List<WebElement> tags_table_columns;	

	String[] expected_tags_table_columns={"Tag","Group","Group External Id","Calls Tagged","Total Duration","Average Call Duration"};
	
	SoftAssert softassert=new SoftAssert(); 

	public TagsSummaryPage(WebDriver driver){
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

//  pg queris
    String endDateToBeUsed = Util.getDate("yyyy-MM-dd","0");
	String startDateToBeUsed = Util.getDate("yyyy-MM-dd","-7");

	String total_call_count_from_db = Util.readingFromDB("SELECT count(*) as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59'");
	String tagged_calls_from_db = Util.readingFromDB("SELECT count(*) as count FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_id IN (SELECT call_id FROM call_tag WHERE call_tag_created BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59')");
	String tags_used_from_db = Util.readingFromDB("SELECT count(DISTINCT(tag_id)) AS count FROM call_tag WHERE call_id IN (SELECT call_id FROM call WHERE org_unit_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND call_started BETWEEN '"+startDateToBeUsed+" 23:59' AND '"+endDateToBeUsed+" 23:59')");    
//  -------------------------------------------------------------------------------------------------------------------- 
	
    public void tileValueVerification(String tile_name){
	
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
        
        else if(tile_name.equals("Tagged Calls")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(tagged_calls_from_db!=null){
				System.out.println(tile_values);
				System.out.println(tagged_calls_from_db);
				softassert.assertTrue(tile_values.equals(tagged_calls_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
        
        else if(tile_name.equals("Tags Used")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(tags_used_from_db!=null){
				System.out.println(tile_values);
				System.out.println(tags_used_from_db);
				softassert.assertTrue(tile_values.equals(tags_used_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}	
		}
      
    	softassert.assertAll();		
    	    	
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

    public void tagsOverTimeLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if Tags Over Time Label is present");
		Assert.assertTrue(tags_over_time_label.isDisplayed(),"Time Zone is not present or locator has been changed.");
	}
    
    public void tagsOverTimeGraph(){
		
		logger.log(LogStatus.INFO, "Verifying if Tags Over Time Graph is present");
		Assert.assertTrue(tags_over_time_graph.isDisplayed(),"Tags Over Time Graph is not present or locator has been changed.");
	}
    
    public void tagsMixLabel(){
		
		logger.log(LogStatus.INFO, "Verifying if Tags Mix Label is present");
		Assert.assertTrue(tags_mix_label.isDisplayed(),"Tags Mix is not present or locator has been changed.");
	}
    
    public void tagsMixGraph(){
		
		logger.log(LogStatus.INFO, "Verifying if Tags Mix Graph is present");
		Assert.assertTrue(tags_mix_graph.isDisplayed(),"Tags Mix Graph is not present or locator has been changed.");
	}
    
    public void callsTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<calls_table_columns.size();i++){
			
			for(int j=0;j<expected_calls_table_columns.length;j++){
				
				if(calls_table_columns.get(i).getText().equals(expected_calls_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_calls_table_columns[j]+" is present");
					softassert.assertTrue(calls_table_columns.get(i).getText().equals(expected_calls_table_columns[j]),"Column "+expected_calls_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
    
    public void tagsTableColumnVerification() throws InterruptedException{
		
		Thread.sleep(2000);
		
		for(int i=0;i<tags_table_columns.size();i++){
			
			for(int j=0;j<expected_tags_table_columns.length;j++){
				
				if(tags_table_columns.get(i).getText().equals(expected_tags_table_columns[j])){
					
					logger.log(LogStatus.INFO, "Verifying if "+expected_tags_table_columns[j]+" is present");
					softassert.assertTrue(tags_table_columns.get(i).getText().equals(expected_tags_table_columns[j]),"Column "+expected_tags_table_columns[j]+" is not present");
				}
			}
			
		}
			
		softassert.assertAll();
	}
    
    
	
    
    

}
