package tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.http.client.ClientProtocolException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.CampaignAndTrackingNumberPage;
import pom.HomePage;
import pom.LoginPage;
import pom.TrackingNumberBuilderPage;
import pom.campaignBuilderPage;
import reservenumber.ReserveNumber;

public class TrackingNumberTest extends TestBase{
	
	String tracking_number_name;
	String updated_tracking_number_name;
	int counter=0;
	TrackingNumberBuilderPage tn;
	
	//navigating to Campaign builder page
		@BeforeClass
		public void goToCampaignPage() throws IOException, InterruptedException{
			
			LoginPage lp=new LoginPage(driver);
	        logger=extent.startTest("validLogin"); 
	        logger.log(LogStatus.INFO, "verifying login with valid username_and_password. ");
	        logger.assignCategory("Login Suite");
	        lp.validLogin();
	        HomePage hp=new HomePage(driver);
	        hp.left_hand_navigation_bar_click();
			
			try {
				hp.clickAction("Campaign & Tracking Number");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		}
	

		  public TrackingNumberBuilderPage createInstance(){
                
			  if(counter==0){
			    tn=new TrackingNumberBuilderPage(driver);
			    counter++;
			  }
			    return tn;		  
		  }
		
		
	//Tracking number page UI verification
	@Test(priority=1)
	public void trakingNumberPageUIVerification() throws InterruptedException{
	   logger=extent.startTest("Tracking number UI Verification..");
       logger.assignCategory("Tracking number suite");
					
	   campaignBuilderPage cb=new campaignBuilderPage(driver, wait);
	   CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);			
       cp.clickAction("update","SJC-1");
       tn=createInstance();
       tn.uiVerification();
				    
	}		
		
		
	//create simple tracking number
     	@Test(priority=1)
		public void simpleTrakingNumberCreation() throws InterruptedException{
			logger=extent.startTest("Tracking number creation..");
			logger.assignCategory("Tracking number suite");
			
			campaignBuilderPage cb=new campaignBuilderPage(driver, wait);
			CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);			
		    cp.clickAction("update","SJC-1");

            tn=createInstance();
		    int number1 = tests.Util.generateRandomNumber();
		    tracking_number_name="SJ TN-"+String.valueOf(number1);
		    tn.createSimpleNumber(tracking_number_name);
		    Thread.sleep(2000);

	
		}
		
		//edit simple tracking number
		@Test(priority=2)
		public void simpleTrakingNumberUpdation() throws InterruptedException{
			logger=extent.startTest("Tracking number update..");
			logger.assignCategory("Tracking number suite");
			    
		    tn=createInstance();
		    tn.clickAction(tracking_number_name, "Edit");
		    updated_tracking_number_name=tracking_number_name.concat(" updated");
		    tn.editSimpleNumber(updated_tracking_number_name);
		    Thread.sleep(2000);

		}
		
		//delete simple tracking number
		@Test(priority=3)
		public void simpleTrakingNumberDeletion() throws InterruptedException{
			logger=extent.startTest("Tracking number deletion..");
			logger.assignCategory("Tracking number suite");
			    
		    tn=new TrackingNumberBuilderPage(driver);
		    tn.clickAction(updated_tracking_number_name, "Delete");
		    Thread.sleep(2000);
		}		
		
	
	


     	//create number pool
     	@Test(priority=4)
		public void numberPoolCreation() throws InterruptedException{
			logger=extent.startTest("Number Pool creation..");
			logger.assignCategory("Tracking number suite");
			
			CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);			
		    cp.clickAction("update","SJC-1");

		    int number1 = tests.Util.generateRandomNumber();
		    tracking_number_name="SJ TN-"+String.valueOf(number1);
		   
		    tn= createInstance();
	    	System.out.println("--------------------------------------------------------------");
	    	 System.out.println(tn.toString());
			   
	    	
	    	System.out.println("--------------------------------------------------------------");
		    
		    
		    tn.createNumberPool(tracking_number_name);
		    Thread.sleep(2000);

	
		}
		
		//edit simple tracking number
		@Test(priority=5)
		public void numberPoolUpdation() throws InterruptedException{
			logger=extent.startTest("Number pool update..");
			logger.assignCategory("Tracking number suite");
			tn = createInstance();

		    tn.clickAction(tracking_number_name, "Edit");
		    updated_tracking_number_name=tracking_number_name.concat(" updated");
		    tn.editNumberPool(updated_tracking_number_name);
		    Thread.sleep(2000);

		}
		
		//delete simple tracking number
		@Test(priority=6)
		public void numberPoolDeletion() throws InterruptedException{
			logger=extent.startTest("Number pool deletion..");
			logger.assignCategory("Tracking number suite");
			tn = createInstance();

		    tn.clickAction(updated_tracking_number_name, "Delete");
		    Thread.sleep(2000);
		}	
		
		//create reserve number
     	@Test(priority=7)
		public void reserveNumberCreation() throws Exception{
			logger=extent.startTest("Reserve Number creation..");
			logger.assignCategory("Tracking number suite");
			String number = ReserveNumber.makeNumberReseve();
			campaignBuilderPage cb=new campaignBuilderPage(driver, wait);
			CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);			
//		    cp.clickAction("update","SJC-1");
			tn = createInstance();
		    int number1 = tests.Util.generateRandomNumber();
		    tracking_number_name="SJ TN-"+String.valueOf(number1);
		    tn.createReserveNumber(tracking_number_name,number);
		    Thread.sleep(2000);
//		    cb.clickAction("list");
	
		}
		
		//edit reserve number
		@Test(priority=8)
		public void reserveNumberUpdation() throws InterruptedException{
			logger=extent.startTest("reserve number number update..");
			logger.assignCategory("Tracking number suite");
			    
			tn = createInstance(); 
		    tn.clickAction(tracking_number_name, "Edit");
		    updated_tracking_number_name=tracking_number_name.concat(" updated");
		    tn.editNumberPool(updated_tracking_number_name);
		    Thread.sleep(2000);

		}
		
		//delete simple tracking number
		@Test(priority=9)
		public void reserveNumberDeletion() throws InterruptedException{
			logger=extent.startTest("reserve number deletion..");
			logger.assignCategory("Tracking number suite");
			    
		    tn=new TrackingNumberBuilderPage(driver);
		    tn.clickAction(updated_tracking_number_name, "Delete");
		    Thread.sleep(2000);
		}	
		
        //GeoRoute creation
		@Test(priority=10)
		public void GeoRouteTrakingNumberCreation() throws InterruptedException{
			logger=extent.startTest("GeoRoute number creation..");
			logger.assignCategory("Tracking number suite");
			
			campaignBuilderPage cb=new campaignBuilderPage(driver, wait);
			CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);			
		    cp.clickAction("update","SJC-1");

            tn=createInstance();
		    int number1 = tests.Util.generateRandomNumber();
		    tracking_number_name="SJ TN-"+String.valueOf(number1);
		    tn.createGeoRoute(tracking_number_name);
		    Thread.sleep(2000);

	
		}
		
		//GeoRoute deletion
		@Test(priority=11)
		public void GeoRouteTrakingNumberDeletion() throws InterruptedException{

			logger=extent.startTest("geo route number deletion..");
			logger.assignCategory("Tracking number suite");
			    
		    tn=new TrackingNumberBuilderPage(driver);
		    tn.clickAction(tracking_number_name, "Delete");
		    Thread.sleep(2000);
		}
		
        //percent route creation
		@Test(priority=12)
		public void percentTrakingNumberCreation() throws InterruptedException{
			logger=extent.startTest("percentRoute number creation..");
			logger.assignCategory("Tracking number suite");
			
			campaignBuilderPage cb=new campaignBuilderPage(driver, wait);
			CampaignAndTrackingNumberPage cp=new CampaignAndTrackingNumberPage(driver,wait);			
		    cp.clickAction("update","SJC-1");

            tn=createInstance();
		    int number1 = tests.Util.generateRandomNumber();
		    tracking_number_name="SJ TN-"+String.valueOf(number1);
		    tn.createPercentRoute(tracking_number_name);
		    Thread.sleep(2000);

	
		}
		
		//percent route deletion
		@Test(priority=13)
		public void percentTrakingNumberDeletion() throws InterruptedException{

			logger=extent.startTest("percent route number deletion..");
			logger.assignCategory("Tracking number suite");
			    
		    tn=new TrackingNumberBuilderPage(driver);
		    tn.clickAction(tracking_number_name, "Delete");
		    Thread.sleep(2000);
		}
		
		
		@AfterClass
	    public void cleanUp(){
	    	tn = createInstance();
		    tn.unprovisionNumbers();
	    	
	   	
	    	
	    	}
}
