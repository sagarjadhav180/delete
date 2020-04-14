package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import tests.TestBase;

public class WebHookPage extends TestBase{

	@FindBy(xpath="//div[@ class='pageProgressLoader']")
	private WebElement loadingWheel;

	@FindBy(xpath="//a[@class='btn btn-sm btn-default']")
	private WebElement add_weebhook_button;
	
	@FindBy(xpath="(//label[text()='Webhook Name']//parent::div//following-sibling::div//input)[1]")
	private WebElement webhook_name_textbox;	
	
	@FindBy(xpath="(//label[text()='Description']//parent::div//following-sibling::div//textarea)")
	private WebElement webhook_description_textbox;	

	@FindBy(xpath="(//label[text()='Webhook Name']//parent::div//following-sibling::div//input)[2]")
	private WebElement webhook_url_textbox;	
	
	@FindBy(xpath="(//label[text()='Method']//parent::div//following-sibling::div//select)[1]")
	private WebElement webhook_method_listbox;

	@FindBy(xpath="(//label[text()='Method']//parent::div//following-sibling::div//select)[2]")
	private WebElement webhook_format_listbox;
	
	@FindBy(xpath="//div[@class='panel-footer text-right']//button")
	private WebElement webhook_save_button;
	
	@FindBy(xpath="//div[@class='ui-pnotify-text'][text()='Successfully created your webhook']")
	private WebElement webhook_creation_success_message;	

	public WebHookPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		
	}
	
	public void createWebHook(String webhhokName,String endpointUrl){

		wait.until(ExpectedConditions.visibilityOf(add_weebhook_button));
		wait.until(ExpectedConditions.attributeContains(add_weebhook_button, "aria-disabled", "false"));
		add_weebhook_button.click();
		wait.until(ExpectedConditions.visibilityOf(webhook_name_textbox));
		
		webhook_name_textbox.sendKeys(webhhokName);
		webhook_description_textbox.sendKeys("test webhook");
		webhook_url_textbox.sendKeys(endpointUrl);
		
		Select select=new Select(webhook_method_listbox);
		
		select.selectByVisibleText("Post");
		
        Select select1=new Select(webhook_format_listbox);
		
		select1.selectByVisibleText("JSON");
		
		webhook_save_button.click();
		
		wait.until(ExpectedConditions.visibilityOf(webhook_creation_success_message));
		
		logger.log(LogStatus.INFO, "Verifying if webhook is creaated");
		Assert.assertTrue(webhook_creation_success_message.isDisplayed(),"webhook is not created successfully");
		
	}
	
	
	
}
