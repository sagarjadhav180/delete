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

public class LookerTrackingNumberSettingsPage extends TestBase {
	
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
	
	@FindBy(xpath="//div[@class='title-main']//span[text()='Tracking Number Settings']")
	private WebElement tracking_number_settings_label;
	
	@FindBy(xpath="//div[@class='vis-single-value-title']//span[@class='looker-vis-context-title-text ']")
	private List<WebElement> tiles_names;	
	
	String[] expceted_tile_names={"Active Campaigns","Active Tracking Numbers","Inactive Campaigns","Inactive Tracking Numbers","Detailed View"};
	
	@FindBy(xpath="//div[@class='vis-single-value-title']//span[@class='looker-vis-context-title-text '][text()='Detailed View']")
	private WebElement detailed_view_tile;
	
	@FindBy(xpath="//span[text()='Detailed View']//../..//preceding-sibling::div//a[1]")
	private WebElement detailed_view_button;
	
	@FindBy(xpath="//div[@class='title-main']//span[text()='Tracking Number Settings Extended']")
	private WebElement detailed_view_header;
	
	@FindBy(xpath="//p[text()='Due to the amount of data available in this section of the report, it may take longer than usual to load.']")
	private WebElement detailed_view_header_note;
	
	@FindBy(xpath="//div[@class='vis-single-value-title']//span[@class='looker-vis-context-title-text '][text()='Default Report']")
	private WebElement default_view_tile;
	
	@FindBy(xpath="//div[@class='ag-root-wrapper-body ag-layout-normal']")
	private WebElement detailed_view_table;
	
	@FindBy(xpath="//div[@class='ag-header-row']//strong")
	private List<WebElement> table_column_labels;	
	String[] expeted_table_column_labels={"Tracking Number ID","Tracking Number Name","Group","Campaign","Tracking Number","Tracking Number Type","Tracking Number Status","Ring-to Number","Ad Source","Record Call","Play Disclaimer","Voice Prompt","Whisper Enabled","DNI Type","Voicemail","Hunt Type","Overflow Ring-to Number"};
	
	@FindBy(xpath="//div[@class='title no-overflow']//strong//parent::span")
	private List<WebElement> filter_elements_before_expanding;
	
	@FindBy(xpath="//table[@class='explore-filters clearfix']//tbody//tr//td[@class='filter-name']")
	private List<WebElement> filter_elements_after_expanding;
	
	String[] expected_filter_elements={"Campaign","Group","Hunt Type","Ring-to Number","Send to Voicemail","Tracking Number Name","Tracking Number","Tracking Number Status","Tracking Number Type"};
	
	@FindBy(xpath="")
	private WebElement filter_button;
	
	SoftAssert softassert=new SoftAssert(); 

	public LookerTrackingNumberSettingsPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
    public void switchToIFrame(){
		
		driver.switchTo().frame(reports_iframe);
		
	}
    
	public void headerLabel(){

		wait.until(ExpectedConditions.visibilityOf(tracking_number_settings_label));
		logger.log(LogStatus.INFO, "verifying if tracking number settings label is present");
		softassert.assertTrue(tracking_number_settings_label.isDisplayed(),"tracking number settings label is not displayed or locator has been chamged..");
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
				
				if(gear_icon_options.get(i).equals(expected_gear_icon_options[j])){
					logger.log(LogStatus.INFO, "Verifying if "+expected_gear_icon_options[j]+" is present");
					softassert.assertTrue(gear_icon_options.get(i).equals(expected_gear_icon_options[j]),"Gear icon "+expected_gear_icon_options[j]+" is present");
				}
			}
		}
    
		softassert.assertAll();
    }
	
    public void presenceOfTimeZone(){
		
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

    public void tileValueVerification(String tile_name){
		
		String active_campaigns_count_from_db = Util.readingFromDB("SELECT COUNT (DISTINCT(campaign_id)) AS count FROM campaign_provisioned_route WHERE campaign_id IN (SELECT campaign_id FROM campaign WHERE campaign_ou_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND campaign_status='active')");
		String active_tracking_numbers_count_from_db = Util.readingFromDB("SELECT COUNT (provisioned_route_id) AS count FROM campaign_provisioned_route WHERE campaign_id IN (SELECT campaign_id FROM campaign WHERE campaign_ou_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND campaign_status='active');AND provisioned_route_id IN (SELECT provisioned_route_id FROM provisioned_route WHERE provisioned_route_status='active' )");
		String inactive_campaigns_count_from_db = Util.readingFromDB("SELECT COUNT (DISTINCT(campaign_id)) AS count FROM campaign_provisioned_route WHERE campaign_id IN (SELECT campaign_id FROM campaign WHERE campaign_ou_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND campaign_status='inactive')");
		String inactive_tracking_numbers_count_from_db = Util.readingFromDB("SELECT COUNT (provisioned_route_id) AS count FROM campaign_provisioned_route WHERE campaign_id IN (SELECT campaign_id FROM campaign WHERE campaign_ou_id IN (SELECT org_unit_id FROM org_unit WHERE top_ou_id='"+TestBase.getOrg_unit_id()+"') AND campaign_status='active')AND provisioned_route_id IN (SELECT provisioned_route_id FROM provisioned_route WHERE provisioned_route_status='inactive')");
		
		String tile_values=driver.findElement(By.xpath("//div[@class='vis-single-value-title']//div[@class='looker-vis-context-title']/span[text()='"+tile_name+"']//parent::Div//parent::div/preceding-sibling::div//a")).getText();
	
		if(tile_name.equals("Active Campaigns")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(active_campaigns_count_from_db!=null){
				System.out.println(tile_values);
				System.out.println(active_campaigns_count_from_db);
				softassert.assertTrue(tile_values.equals(active_campaigns_count_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
		else if(tile_name.equals("Active Tracking Numbers")){
			
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(active_tracking_numbers_count_from_db!=null){
				System.out.println(tile_values);
				System.out.println(active_tracking_numbers_count_from_db);
				softassert.assertTrue(tile_values.equals(active_tracking_numbers_count_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
		else if(tile_name.equals("Inactive Campaigns")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(inactive_campaigns_count_from_db!=null){
				System.out.println(tile_values);
				System.out.println(inactive_campaigns_count_from_db);
				softassert.assertTrue(tile_values.equals(inactive_campaigns_count_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}
			
		}
		else if(tile_name.equals("Inactive Tracking Numbers")){
			
			logger.log(LogStatus.INFO, "Verifying tile count for "+tile_name);
			if(inactive_tracking_numbers_count_from_db!=null){
				System.out.println(tile_values);
				System.out.println(inactive_tracking_numbers_count_from_db);
				softassert.assertTrue(tile_values.equals(inactive_tracking_numbers_count_from_db),"Tile count doest match with db count");			
			}
			else{
				softassert.assertTrue(tile_values.equals("0"),"Tile count doest match with db count");			
			}

			softassert.assertAll();			
			
		}
		
		

	}

    //to update
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
			
			if(i>expeted_table_column_labels.length){
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
        
    	//collapsing filter section
    	Util.click(filter_button);

    	}

    
}
