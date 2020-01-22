package pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import tests.TestBase;

public class SelectAndScorePage extends TestBase {

	@FindBy(xpath="//div[@ class='pageProgressLoader']")
	private WebElement loadingWheel;
	
	@FindBy(xpath="//h1[contains(text(),'Select and Score')]")
	private WebElement selectandscore_header_label;
	
	@FindBy(xpath="//h4[contains(text(),'Calls count on this page may differ from Reports.')]")
	private WebElement actual_call_count_note;	
	
	String expected_call_count_note="Calls count on this page may differ from Reports. Reports strictly follow the user permission settings and filter calls according to the groups users are assigned to. The Scorecard feature allows a user to be assigned calls that are part of a group the user does not have access to.";

	@FindBy(xpath="//button[@class='btn btn-lg btn-default ng-isolate-scope']")
	private WebElement date_filter_button;		
	
	@FindBy(xpath="//div[@class='daterangepicker dropdown-menu opensleft']//ul//li")
	private List<WebElement> actual_date_filter_elements;		
	
	String[] expected_date_filter_elements={"Today","Yesterday","Last 7 Days","Last 30 Days","This Month","Last Month","Custom Range"};
	
	@FindBy(xpath="(//span[text()='Export']//parent::button)[1]")
	private WebElement export_button;
	
	@FindBy(xpath="//button[text()=' Notifications']")
	private WebElement notifications_button;	
	
	@FindBy(xpath="//div[text()='Filter by Status:']//parent::form//label")
	private List<WebElement> filter_status;		
	
	String[] expected_filter_status={"Need Scorecard","Unscored","Scored","Reviewed"};
	
	@FindBy(xpath="//table[@id='scoredetailtable']//thead//tr[1]//th")
	private List<WebElement> actual_table_headers;			
	
	String[] expected_table_headers={"Play Call ","Status ","Date/Time ","Duration ","Group ","Identified Agent ","Call Title ","Scorecard ","Score Date ","Score ","Actions "};
	
	
	
	
	public SelectAndScorePage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	
	//to check expected filter status checkbox 
    public WebElement getStatusChecked(String status){
		
		WebElement webelement = driver.findElement(By.xpath("//div[text()='Filter by Status:']//parent::form//label[text()='"+status+"']//span"));
		return webelement;
	}
    
  ///to get action button of required call  
    public WebElement getActionButton(String button_name){
    	WebElement webelement = null;
    	
    	if(button_name.contains("play")){
		    webelement= driver.findElement(By.xpath("((//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td)[1]//button"));
    	}
//    	else if(button_name.contains("score")){
//    		webelement= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//button[text()='Score Now']"));    		
//    	}
    	else if(button_name.contains("edit")){
    		webelement= driver.findElement(By.xpath("((//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//div[@class='buttons pull-right']//button)[1]"));
    	}
    	else if(button_name.contains("download")){
    		webelement= driver.findElement(By.xpath("((//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//div[@class='buttons pull-right']//button)[2]"));
    	}
    	else if(button_name.contains("mail")){
    		webelement= driver.findElement(By.xpath("((//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//div[@class='buttons pull-right']//button)[3]"));
    	}
    	else if(button_name.contains("agent")){
    		webelement= driver.findElement(By.xpath("((//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//select)[1]"));
    	}
    	else if(button_name.contains("scorecard")){
    		webelement= driver.findElement(By.xpath("((//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//select)[2]"));
    	}
    	else if(button_name.contains("call title")){
    		webelement= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//input"));
    	}
    	else if(button_name.contains("save")){
    		webelement= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//button[text()='Save']"));
    	}
    	else if(button_name.contains("cancel")){
    		webelement= driver.findElement(By.xpath("(//table[@id='scoredetailtable']//tbody//td)[1]//parent::tr//td//button[text()='Cancel']"));
    	}
		return webelement;
	
    
    }
	
	
	
}
