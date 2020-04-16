package pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ScheduledReportBuilderPage {

	
	@FindBy(xpath="//h1[contains(text(),'Scheduled Report Builder')]")
	private WebElement scheduled_report_builder_label;
	
	@FindBy(xpath="//a[@class='btn btn-default hidden-xs']")
	private WebElement list_button;
	
	@FindBy(xpath="//h4[contains(text(),'Report Details')]")
	private WebElement report_detail_label;	

	@FindBy(xpath="//label[contains(text(),'Active?')]")
	private WebElement active_label;	
	
	@FindBy(xpath="//label[contains(text(),'Scheduled Report Name')]")
	private WebElement scheduled_report_name_label;		

	@FindBy(xpath="//label[contains(text(),'Description')]")
	private WebElement description_label;		
	
	@FindBy(xpath="//label[contains(text(),'Report Type')]")
	private WebElement report_label;			

	@FindBy(xpath="//label[contains(text(),'Date Range')]")
	private WebElement date_range_label;
	
	@FindBy(xpath="//label[contains(text(),'Secondary Grouping')]")
	private WebElement secondary_grouping_label;	
	
	@FindBy(xpath="(//span[@class='knob ng-binding ng-scope'])[2]")
	private WebElement report_status_toggle;	

	@FindBy(xpath="//label[contains(text(),'Scheduled Report Name')]//parent::div//div//input")
	private WebElement scheduled_report_name_textbox;
	
	@FindBy(xpath="//label[contains(text(),'Description')]//parent::div//div//input")
	private WebElement description_textbox;	
	
	@FindBy(xpath="//div[@class='input-group']//input[@id='simpleChart']")
	private WebElement basic_search_textbox;	

	@FindBy(xpath="//ul[@class='select2-result-sub']//li")
	private WebElement report_type_listbox;	
	
	@FindBy(xpath="//ul[@class='select2-result-sub']//li")
	private WebElement secondary_grouping_listbox;		
	
	@FindBy(xpath="(//i[@class='fa fa-calendar'])[1]")
	private WebElement date_range_calender_button;			
	
	@FindBy(xpath="(//div[@class='ranges']//ul)[3]//li")
	private WebElement date_range_calender_options;		

	@FindBy(xpath="//div[5]//div[3]//button[1][text()='OK']")
	private WebElement date_range_calender_ok_button;		
	
	@FindBy(xpath="//div[5]//button[2][text()='Cancel']")
	private WebElement date_range_calender_cancel_button;			
	
	
}
