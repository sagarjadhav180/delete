package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import tests.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//button[@id='_pendo-close-guide_']")
	private WebElement pendo_close_button;	

	@FindBy(xpath="//*[@id='sidebar']/li")
	private List<WebElement> links;	

	@FindBy(xpath="//tbody[@ id='progressLoader']")
	private WebElement loading_wheel;	
	
	public HomePage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickAction(String linkToBeClicked){
		//WebElement link:links
		for(int i=0;i<links.size();i++){
		WebElement link = links.get(i);
			if(link.getText().contains(linkToBeClicked)){
				link.click();
				wait.until(ExpectedConditions.invisibilityOf(loading_wheel));
			}
		}
	}
	
}
