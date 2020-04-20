package tests;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import constants.Constants;
import pom.LegacyScheduledReportsPage;
import pom.LoginPage;
import pom.ScheduledReportBuilderPage;

public class LegacyScheduledReportTest extends TestBase {

	ScheduledReportBuilderPage sb;
	LegacyScheduledReportsPage ls;
	
	@BeforeClass
	public void goToLegacyScheduledReportsPage() throws IOException{
		
		
		LoginPage lp=new LoginPage(driver);
        logger=extent.startTest("validLogin"); 
        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
        logger.assignCategory(Constants.login_page_category);
        lp.validLogin();
	}
	
	@Test
	public void presenceOfReportLabel(){
		
		logger=extent.startTest("Report Label Test");
		logger.assignCategory(Constants.legacy_scheduled_report_category);
		ls=LegacyScheduledReportsPage.intanceLegacySchedule();
		ls.headerLabel();
		
	}
	
}
