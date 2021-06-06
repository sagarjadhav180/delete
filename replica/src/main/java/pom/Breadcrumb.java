package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.TestBase;
import tests.Util;

public class Breadcrumb extends TestBase{

	@FindBy(xpath="//div[@ class='groupDetailsProgressLoader']")
	private WebElement loadingWheel;

	@FindBy(xpath="(//div[@class='bc-drawer-panel-nav ng-scope']//i)[1]")
	private WebElement breadcrumb_button;
	
	@FindBy(xpath="//div[@class='clearfix ng-scope']//div[2]//div[2]//div[1]//input[1]")
	private WebElement breadcrumb_textbox_company;	
	
	@FindBy(xpath="(//div[@class='bc-drawer-list-main']//table)[2]//tbody//tr")
	private List<WebElement> breadcrumb_company_grouplist;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-sm'][contains(text(),'Apply')]")
	private WebElement breadcrumb_apply_button;	
	
	public Breadcrumb(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	public void goToGroup(String groupName) throws InterruptedException{
		
		Util.click(breadcrumb_button);
		breadcrumb_textbox_company.sendKeys(groupName);
		
		for(int i=0;i<breadcrumb_company_grouplist.size();i++){
			if(breadcrumb_company_grouplist.get(i).getText().equals(groupName)){
				
				breadcrumb_company_grouplist.get(i).click();
				break;
			}
		}

		Util.click(breadcrumb_apply_button);
		Thread.sleep(2000);
	}
	
	
	
}
