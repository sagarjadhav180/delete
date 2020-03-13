package tests;

import java.io.IOException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.CampaignAndTrackingNumberPage;
import pom.HomePage;
import pom.LoginPage;
import pom.TrackingNumberBuilderPage;
import reservenumber.ReserveNumber;

public class TrackingNumberTest extends TestBase{
	
	String tracking_number_name;
	String updated_tracking_number_name;
	int counter_a=0;
	int counter_b=0;
	TrackingNumberBuilderPage tn;
	CampaignAndTrackingNumberPage cp;
	
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

				e.printStackTrace();
			}		
			
		}
	

		  public CampaignAndTrackingNumberPage createInstanceCampaignAndTrackingNumberPage(){
                
			  if(counter_b==0){
			    cp=new CampaignAndTrackingNumberPage(driver);
			    counter_b++;
			  }
			    return cp;		  
		  }
		  
		  public TrackingNumberBuilderPage createInstance(){
              
			  if(counter_a==0){
			    tn=new TrackingNumberBuilderPage(driver);
			    counter_a++;
			  }
			    return tn;		  
		  }
		
		
	//Tracking number page UI verification
	@Test(priority=0)
	public void trakingNumberPageUIVerification() throws InterruptedException{
	   logger=extent.startTest("Tracking number UI Verification..");
       logger.assignCategory("Tracking number suite");
					
	   cp=createInstanceCampaignAndTrackingNumberPage();	
       cp.clickAction("update","SJC-1");
       tn=createInstance();
       tn.uiVerification();
				    
	}		
		
		
	//create simple tracking number
     	@Test(priority=1)
		public void simpleTrakingNumberCreation() throws InterruptedException{
			logger=extent.startTest("Tracking number creation..");
			logger.assignCategory("Tracking number suite");
			
//		    cp.clickAction("update","SJC-1");

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
			
//		    cp.clickAction("update","SJC-1");

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
			
//		    cp.clickAction("update","SJC-1");

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
			
//		    cp.clickAction("update","SJC-1");

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
		
        //outbound route creation
		@Test(priority=14)
		public void outboundTrakingNumberCreation() throws InterruptedException{
			logger=extent.startTest("outbound number creation..");
			logger.assignCategory("Tracking number suite");
			
//		    cp.clickAction("update","SJC-1");

            tn=createInstance();
		    int number1 = tests.Util.generateRandomNumber();
		    tracking_number_name="SJ TN-"+String.valueOf(number1);
		    tn.createOutboundRoute(tracking_number_name);
		    Thread.sleep(2000);

	
		}

		//outbound route deletion
		@Test(priority=15)
		public void outboundTrakingNumberDeletion() throws InterruptedException{

			logger=extent.startTest("outbound route number deletion..");
			logger.assignCategory("Tracking number suite");
			    
		    tn=new TrackingNumberBuilderPage(driver);
		    tn.clickAction(tracking_number_name, "Delete");
		    Thread.sleep(2000);
		}		
		
        //hangup route creation
		@Test(priority=16)
		public void hangupTrakingNumberCreation() throws InterruptedException{
			logger=extent.startTest("hangup number creation..");
			logger.assignCategory("Tracking number suite");
			
			
//		    cp.clickAction("update","SJC-1");

            tn=createInstance();
		    int number1 = tests.Util.generateRandomNumber();
		    tracking_number_name="SJ TN-"+String.valueOf(number1);
		    tn.createHangupRoute(tracking_number_name);
		    Thread.sleep(2000);
	
		}

        //hangup route deletion
		@Test(priority=17)
		public void hangupTrakingNumberDeletion() throws InterruptedException{

			logger=extent.startTest("hangup route number deletion..");
			logger.assignCategory("Tracking number suite");
			    
		    tn=new TrackingNumberBuilderPage(driver);
		    tn.clickAction(tracking_number_name, "Delete");
		    Thread.sleep(2000);
		}		
		
        //voicemail route creation
		@Test(priority=18)
		public void voicemailTrakingNumberCreation() throws InterruptedException{
			logger=extent.startTest("voicemail number creation..");
			logger.assignCategory("Tracking number suite");
			
//		    cp.clickAction("update","SJC-1");

            tn=createInstance();
		    int number1 = tests.Util.generateRandomNumber();
		    tracking_number_name="SJ TN-"+String.valueOf(number1);
		    tn.createVoicemailRoute(tracking_number_name);
		    Thread.sleep(2000);
	
		}		

        //voicemail route deletion
		@Test(priority=19)
		public void voicemailTrakingNumberDeletion() throws InterruptedException{

			logger=extent.startTest("voicemail route number deletion..");
			logger.assignCategory("Tracking number suite");
			    
		    tn=new TrackingNumberBuilderPage(driver);
		    tn.clickAction(tracking_number_name, "Delete");
		    Thread.sleep(2000);
		}		
		
       

		
	    //schedule route creation
		@Test(priority=20)
		public void scheduleTrakingNumberCreation() throws InterruptedException{
				logger=extent.startTest("scheduleRoute number creation..");
				logger.assignCategory("Tracking number suite");
				
//			    cp.clickAction("update","SJC-1");

	            tn=createInstance();
			    int number1 = tests.Util.generateRandomNumber();
			    tracking_number_name="SJ TN-"+String.valueOf(number1);
			    tn.createScheduleRoute(tracking_number_name);
			    Thread.sleep(2000);

		
		}
		
		//schedule route deletion
		@Test(priority=21)
		public void scheduleTrakingNumberDeletion() throws InterruptedException{

			logger=extent.startTest("schedule route number deletion..");
			logger.assignCategory("Tracking number suite");
			    
		    tn=new TrackingNumberBuilderPage(driver);
		    tn.clickAction(tracking_number_name, "Delete");
		    Thread.sleep(2000);
		}
		
		 //IVR route creation
		@Test(priority=22)
		public void IVRCreation() throws InterruptedException{
				logger=extent.startTest("IVR r creation..");
				logger.assignCategory("Tracking number suite");
				
				cp=createInstanceCampaignAndTrackingNumberPage();
//			    cp.clickAction("update","SJC-1");

	            tn=createInstance();
			    int number1 = tests.Util.generateRandomNumber();
			    tracking_number_name="SJ TN-"+String.valueOf(number1);
			    tn.createIVRRoute(tracking_number_name);
			    Thread.sleep(2000);

		
		} 
			
		
		//IVR route deletion
		@Test(priority=23)
		public void IVRDeletion() throws InterruptedException{

			logger=extent.startTest("IVR route number deletion..");
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
