package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyScheduledReportsPage {
	
	@FindBy(xpath="//div[@ class='pageProgressLoader']")
	private WebElement loadingWheel;

	@FindBy(xpath="//h1[contains(text(),'My Scheduled Reports')]")
	private WebElement header_label;

	@FindBy(xpath="//table[@id='scheduledreportstable']//thead//tr[1]//th")
	private List<WebElement> actual_table_columns;
	
	String[] expected_columns={"Schedule Name","Report Name","Creator","Created Date","Recipients","Frequency","Format","Status","Actions"};
	
	public MyScheduledReportsPage(WebDriver driver){
		PageFactory.initElements(driver,this);
	}

}
