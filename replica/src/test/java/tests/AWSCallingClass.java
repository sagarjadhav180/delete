package tests;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.Calling;

public class AWSCallingClass extends TestBase{
	
	
	@Test
	public void test1() throws InterruptedException {
		
		String URL="https://convirza.awsapps.com/auth/?client_id=06919f4fd8ed324e&redirect_uri=https%3A%2F%2Fconvirza.awsapps.com%2Fconnect%2Fauth%2Fcode";
		
//		driver.get(URL);
		
		String str="Verifying if call is getting through and entry of the same in DB";
		logger=extent.startTest("Call Test"); 
        logger.log(LogStatus.INFO, str.toUpperCase());
    
		Calling cl=new Calling(driver,wait);
		cl.test1();
		
	}

}
