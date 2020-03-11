package extentReport;

import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import tests.TestBase;



	public class Listener extends TestBase implements ITestListener  {
		static List<ITestNGMethod> passedtests = new ArrayList<ITestNGMethod>();
		static List<ITestNGMethod> failedtests = new ArrayList<ITestNGMethod>();
		static List<ITestNGMethod> skippedtests = new ArrayList<ITestNGMethod>();

		public void onFinish(ITestContext arg0) {
			// TODO Auto-generated method stub

		}


		public void onStart(ITestContext arg0) {
			// TODO Auto-generated method stub

		}


		public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
			// TODO Auto-generated method stub

		}

		public void onTestFailure(ITestResult arg0) {
			// TODO Auto-generated method stub
			failedtests.add(arg0.getMethod());
			System.out.println("Failed:" + arg0.getMethod());
		}

		public void onTestSkipped(ITestResult arg0) {
			// TODO Auto-generated method stub
			skippedtests.add(arg0.getMethod());
			System.out.println("Skipped:" + arg0.getMethod());
			System.out.println("Skipped:" + arg0.getMethod().getMethodName());
			System.out.println("Failed script name is" + methodName);
			logger = extent.startTest(arg0.getMethod().getMethodName());
			System.out.println("Current status is...... " + logger.getRunStatus());
			logger.log(LogStatus.SKIP, "This method is get skipped because the " + "<span class='red label'>" +methodName + "</span>"+" test case got failed.");
			logger.log(LogStatus.SKIP, arg0.getMethod().getMethodName());
			extent.endTest(logger);
			extent.flush();
		}

		public void onTestStart(ITestResult arg0) {
			// TODO Auto-generated method stub

		}

		public void onTestSuccess(ITestResult arg0) {
			// TODO Auto-generated method stub
			passedtests.add(arg0.getMethod());
			System.out.println("Passed:" + arg0.getMethod());
		}

		public static int[] count_of_test() {
			int[] result = { passedtests.size(), failedtests.size(), skippedtests.size() };
			return result;
		}
		// This belongs to ISuiteListener and will execute before the Suite start
	}

	

