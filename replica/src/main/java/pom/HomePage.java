package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import tests.TestBase;
import tests.Util;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//button[@id='_pendo-close-guide_']")
	private WebElement pendo_close_button;	

	@FindBy(xpath="//div[@class='guide-header']")
	private WebElement pendo_popup;	

	
	@FindBy(xpath="//*[@id='sidebar']/li")
	private List<WebElement> links;	

	@FindBy(xpath="//tbody[@ id='progressLoader']")
	private WebElement loading_wheel;	
	
	
	public HomePage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickAction(String linkToBeClicked) throws InterruptedException{
		//WebElement link:links
		for(int i=0;i<links.size();i++){
		WebElement link = links.get(i);
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
	

}