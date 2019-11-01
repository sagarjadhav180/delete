package extentReport;

import java.util.HashMap;
import java.util.Map;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class ExtentReportsGenerator {
	
	
	private static ExtentReports extent;
	private static ExtentTest logger;

	public static ExtentReports getInstance(Boolean replace_existing) {
		if (extent == null) {
			if (replace_existing == true) {
				extent = new ExtentReports(".//Extent.html", true);
			} else {
				extent = new ExtentReports(".//Extent.html", false);
			}
//			logger = extent.startTest("");
			
			// optional added Build environment
			extent.addSystemInfo("Selenium Version", "3.11.0").addSystemInfo("Environment", "QA");
			extent.config().documentTitle("CFA_Automation_Test_Report").reportName("Automation Report -")
					.reportHeadline("Find Below test result").insertCustomStyles(".logger { border:2px solid #444; }");

			// Optional added system info
			extent.addSystemInfo("Selenium Version", "3.11.0");
			extent.addSystemInfo("Environment", "Staging");
			Map sysInfo = new HashMap();
			sysInfo.put("Selenium Version", "3.11.0");
			sysInfo.put("Environment", "Staging");
			extent.addSystemInfo(sysInfo);
//			logger.log(LogStatus.INFO, "Log Status");

			// Add the categories

		}

		return extent;

	}

}
