package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import tests.TestBase;
import tests.Util;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//button[@id='_pendo-close-guide_']")
	private WebElement pendo_close_button;	

	@FindBy(xpath="//div[@class='guide-header']")
	private WebElement pendo_popup;	

	//left hand navigation bar
	
	@FindBy(xpath="//*[@id='sidebar']/li/a/i//following-sibling::span[1]")
	private List<WebElement> left_hand_navigation_bar_links;	

	String[] left_hand_navigation_bar_links_names={"Home","Reports","Legacy Reports","Scorecard","Campaign & Tracking Number","Group & User","Settings"};
	
	@FindBy(xpath="//*[@id='sidebar']/li//ul//li")
	private List<WebElement> left_hand_navigation_bar_sub_links;
	
	String[] left_hand_navigation_bar_sub_links_names={"Call Details","Group Activity","Tracking Number Settings","Manage Scorecard","Select & Score","My Scheduled Reports","Legacy Scheduled Reports","Customization","Blacklist","DNI","GeoRoute","Legacy Distribution Lists","Tags ","Webhook","Integration","Acquisio","Data Append","DoubleClick","Google Analytics"};

	//dashboard 

	@FindBy(xpath="//*[@id='wrap']/div[2]/div/div[1]/div//div//div[@class='tiles-heading']//div")
	private List<WebElement> dashboard_tiles;		

	String[] dashboard_tile_names={"Total Calls","Unique Calls","Answered Calls","Avg Call Duration","Calls by Day","Total Leads","% of Leads","Total Conversion","Conversion Rate"};
	
	@FindBy(xpath="//*[@id='wrap']/div[2]/div/div[1]/div//div//div[@class='tiles-heading']//div//parent::div//following-sibling::div//div[contains(@class,'pull-right')]")
	private List<WebElement> dashboard_tiles_values;		
	
	@FindBy(xpath="//h4[contains(text(),'Get Started')]")
	private List<WebElement> getstarted_label;	

	@FindBy(xpath="//h4[contains(text(),'Integrations')]")
	private List<WebElement> Integration_label;
	
	@FindBy(xpath="//div[contains(text(),'Metrics on the Home Page reflect data for the Group chosen in the Breadcrumbs at the top.')]")
	private List<WebElement> metrics_note;	
	
	@FindBy(xpath="//*[@id='wrap']/div[2]/div/div[2]/div[2]//span")
	private List<WebElement> dashboard_getstarted_links;
	
	String[] dashboard_getstarted_link_names={"Update your profile","Configure your company","Add more users","Create a campaign"};

	@FindBy(xpath="//*[@id='wrap']/div[2]/div/div[2]/div[3]/div//span")
	private List<WebElement> dashboard_integrstion_links;
	
	String[] dashboard_integrstion_link_names={"Acquisio","DoubleClick","Google Analytics"};
	
	@FindBy(xpath="//a[@id='leftmenu-trigger']")
	private WebElement left_hand_navigation_bar_collapsible_button;	

	@FindBy(xpath="//a[@class='navbar-brand']")
	private WebElement logo;
	
	@FindBy(xpath="//tbody[@ id='progressLoader']")
	private WebElement loading_wheel;	
	
//	WebDriverWait wait;
//	ExtentTest logger;
	SoftAssert softassert=new SoftAssert();
	
	public HomePage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickAction(String linkToBeClicked) throws InterruptedException{
		//WebElement link:links
		for(int i=0;i<left_hand_navigation_bar_links.size();i++){
		WebElement link = left_hand_navigation_bar_links.get(i);
			if(link.getText().contains(linkToBeClicked)){
				
				if(link.getText().contains("Campaign")){
					link.click();
//					try{
//						driver.switchTo().activeElement();
//					Util.click(pendo_close_button);
//					Thread.sleep(3000);
//					}
//					catch(Exception e){}
						
					try{
					wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
					
					}catch(Exception e){}
					
				}
				else{
				link.click();
				}

//				try{
//					if(loading_wheel.isDisplayed()){
//					wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
//					}
//				}catch(Exception e){
//				Thread.sleep(1000);	
//				}
			}
		}
		
//		if(pendo_popup.isDisplayed()==true){
//			driver.switchTo().activeElement();
//			Util.click(pendo_close_button);
//		}else{
//			wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
//			Thread.sleep(3000);	
//		}
	}
	
	//UI Verification of Home page
	public void UIVerification() throws InterruptedException{
		
		left_hand_navigation_bar_collapsible_button.click();
		Thread.sleep(1000);
		for(int i=0;i<left_hand_navigation_bar_links.size();){


			for(int j=0;j<left_hand_navigation_bar_links_names.length;j++){


				if(left_hand_navigation_bar_links.get(i).getText().equals(left_hand_navigation_bar_links_names[j])){
				
				//to check if link is present and link name	
				logger.log(LogStatus.INFO, "verifying tab "+left_hand_navigation_bar_links.get(i).getText());
				softassert.assertEquals(left_hand_navigation_bar_links.get(i).getText(), left_hand_navigation_bar_links_names[j],left_hand_navigation_bar_links.get(i)+" link is not present or locator has been changed..");
				
				}
			}
			//To verify links are clickable in left hand navigation bar
			logger.log(LogStatus.INFO, "verifying if "+left_hand_navigation_bar_links.get(i).getText()+" is clickable");
			softassert.assertTrue(left_hand_navigation_bar_links.get(i).isEnabled(),left_hand_navigation_bar_links.get(i).getText()+" is not clickable");
			
			i++;

		}

		
		//To verify all tiles are present in dashboard
		for(int k=0;k<dashboard_tiles.size();){
			for(int l=0;l<dashboard_tile_names.length;l++){
				System.out.println(dashboard_tiles.get(k).getText());
				System.out.println(dashboard_tile_names[l].toUpperCase());
				if(dashboard_tiles.get(k).getText().equals(dashboard_tile_names[l].toUpperCase())){
					
					logger.log(LogStatus.INFO, "verifying if "+dashboard_tiles.get(k).getText()+" tile is presnt");
					softassert.assertEquals(dashboard_tiles.get(k).getText(), dashboard_tile_names[l].toUpperCase(),dashboard_tiles.get(k).getText()+" tile is not present or locator changed..");
				}
			}
			k++;
		}
		
		//To verify all links are presnet in dashboard
		for(int m=0;m<dashboard_getstarted_links.size();){
			for(int n=0;n<dashboard_getstarted_link_names.length;n++){
				System.out.println(dashboard_getstarted_links.get(m).getText());
				System.out.println(dashboard_getstarted_link_names[n]);
				if(dashboard_getstarted_links.get(m).getText().equals(dashboard_getstarted_link_names[n])){
					
					logger.log(LogStatus.INFO, "verifying if "+dashboard_getstarted_links.get(m).getText()+" is present");
					softassert.assertEquals(dashboard_getstarted_links.get(m).getText(), dashboard_getstarted_link_names[n],dashboard_getstarted_links.get(m).getText()+" link is not present or locator has been changed..");
				}
				
			}

			//To verify all links are clickable in dashboard
			logger.log(LogStatus.INFO, "verifying if "+dashboard_getstarted_links.get(m).getText()+" is enabled");
			softassert.assertTrue(dashboard_getstarted_links.get(m).isEnabled(),dashboard_getstarted_links.get(m).getText()+" link is not enabled..");
			
			m++;
			
			
		}
		
		
		
		softassert.assertAll();
	}
	

	
	

}